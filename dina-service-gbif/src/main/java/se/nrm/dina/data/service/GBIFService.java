/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.data.service;
 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path; 
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.nrm.dina.darwincore.model.DarwinCore;
import se.nrm.dina.darwincore.model.DarwinCoreInterface;
import se.nrm.dina.darwincore.model.DwcEvent;
import se.nrm.dina.darwincore.model.DwcIdentification;
import se.nrm.dina.darwincore.model.DwcLocality;
import se.nrm.dina.darwincore.model.DwcOccurrence;
import se.nrm.dina.darwincore.model.DwcTaxon;
import se.nrm.dina.data.jpa.DinaDao; 
import se.nrm.dina.data.jpa.DinaGNMDao;
import se.nrm.dina.data.service.util.Util;

/**
 *
 * @author idali
 */
@Path("/gbif") 
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
@Stateless
public class GBIFService {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private final static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    
    private final String NRM_INSTITUTION_NAME = "Swedish Museum of Natural History";
    private final String GNM_INSTITUTION_NAME = "Göteborgs Naturhistoriska museum";
    
    private final String NRM_INSTITUTION_CODE = "NRM";
    private final String GNM_INSTITUTION_CODE = "GNM";
//    private final String INSTITUTION_CODE = "S";   // institution code 'S' is for botenis collection.
      
    
    private final int CO_ID_INDEX = 0;
    private final int CO_CATALOGNUMBER_INDEX = 1;  
    private final int CO_CREATEDDATE_INDEX = 2;
    private final int CO_MODIFIEDDATE_INDEX = 3;
    private final int CE_ID_INDEX = 4;
    private final int CE_VERBATIMDATE_INDEX = 5;
    private final int CE_REMARKS_INDEX = 6;
    private final int CE_ENDDATE_INDEX = 7;
    private final int CE_STARTDATE_INDEX = 8;
    private final int COL_COLLECTION_TYPE_INDEX = 9;
    private final int COL_COLLECTION_PRIMARYFOCUS_INDEX = 10;
    private final int COL_COLLECTION_CODE_INDEX = 11;
    private final int LOC_ID_INDEX = 12;
    private final int LOC_LAT_INDEX = 13;
    private final int LOC_LANT_INDEX = 14; 
    private final int LOC_NAME_INDEX = 15; 
    private final int LOC_MINELEVATION_INDEX = 16;
    private final int LOC_MAXELEVATION_INDEX = 17; 
    private final int GEO_RANKID_INDEX = 18;
    private final int GEO_PARENT_ID_INDEX = 19;
    private final int DET_TYPESTATUSNAME_INDEX = 20;
    private final int DET_DATE_INDEX = 21;
    private final int DET_QUALIFIER_INDEX = 22;
    private final int TX_FULLNAME_INDEX = 23;
    private final int TX_NAME_INDEX = 24;
    private final int TX_RANKID_INDEX = 25;
    private final int TX_AUTHOR_INDEX = 26;
    private final int TX_PARENTID_INDEX = 27;
    
    private final static int COUNTY_RANKID = 400;
    private final static int STATE_RANKID = 300;
    private final static int COUNTRY_RANKID = 200;
    private final static int CONTINENT_RANKID = 100;
    
    private DwcOccurrence occurrence;
    private DwcTaxon dwcTaxon;
    private DwcEvent dwcEvent;
    private DwcIdentification identification;
    private DwcLocality dwcLocality;
    
    
    
    private List<DarwinCoreInterface> dcList;
     
    private StringBuilder sb;
    private StringBuilder dataSb;
    
    private int geoRank;
    private int geoParentId;
    
    private int taxonRank;
    private int taxonParentId;  
     
    private Date endDate;
    private Date startDate;
     
    private Calendar calendar;
     
    private String strStartDate;
    private String strEndDate;
    private String institutionCode;
    private int collectionId;
    private int startId;
    
    private String institutionName;
     
    @EJB
    private DinaDao dao;
    
    @EJB
    private DinaGNMDao gnmDao;
    
    @GET
    @Path("/{institutionCode}/{collectionId}/{startdate}/{enddate}/{id}")
    public Response getAllData( @PathParam("institutionCode") String instCode,
                                @PathParam("collectionId") int collectionId,
                                @PathParam("startdate") String startDate, 
                                @PathParam("enddate") String endDate, 
                                @PathParam("id") int id) {

        logger.info("getAllData");
        
        this.strStartDate = startDate;
        this.strEndDate = endDate; 
        this.collectionId = collectionId;
        this.startId = id;
 
        if(instCode.toLowerCase().equals("nrm")) {
            institutionCode = NRM_INSTITUTION_CODE;
            institutionName = NRM_INSTITUTION_NAME;
        } else {
            institutionCode = GNM_INSTITUTION_CODE;
            institutionName = GNM_INSTITUTION_NAME;
        }
  
        DarwinCore darwincore = new DarwinCore();
        dcList = new ArrayList<>();
        
        int count = 0;
        String strQry = createQuery();  
          
        List<Object[]> list;
        if(institutionCode.equals(NRM_INSTITUTION_CODE)) {
            list = dao.getAllByNativeQuery(strQry);
        } else {
            list = gnmDao.getAllByNativeQuery(strQry);
        }
      
         
        logger.info("list : {}", list.size());
        for(Object[] object : list) {
  
            buildLocality(object); 
            buildEvent(object);
            buildOccurrence(object);
            buildIdentification(object);
            buildTaxon(object);

            if (count >= 2000) {
                darwincore.setRecords(dcList);
                darwincore.setCollectionObjectId(Integer.parseInt(object[CO_ID_INDEX].toString()));  
                Response.ResponseBuilder rb = Response.ok(darwincore);
                return rb.build();
            }  
            count++; 
        }  
        
        darwincore.setRecords(dcList);
        darwincore.setCollectionObjectId(0);
        
        Response.ResponseBuilder rb = Response.ok(darwincore);
        return rb.build();
    }
  
    private void buildLocality(Object[] object) {
        geoParentId = 0;
        geoRank = 0;
            
        dwcLocality = new DwcLocality();
        if (object[LOC_ID_INDEX] != null) {
            dwcLocality.setLocalityId((object[LOC_ID_INDEX].toString()));

            if (object[LOC_NAME_INDEX] != null) {
                dwcLocality.setLocality(object[LOC_NAME_INDEX].toString());
            }
            if (object[LOC_LAT_INDEX] != null) {
                dwcLocality.setDecimalLatitude(object[LOC_LAT_INDEX].toString()); 
            }
            if (object[LOC_LANT_INDEX] != null) {
                dwcLocality.setDecimalLongitude(object[LOC_LANT_INDEX].toString()); 
            }
            if (object[LOC_MINELEVATION_INDEX] != null) {
                dwcLocality.setMinimumElevationInMeters(object[LOC_MINELEVATION_INDEX].toString()); 
            }
            if (object[LOC_MAXELEVATION_INDEX] != null) {
                dwcLocality.setMaximumElevationInMeters(object[LOC_MAXELEVATION_INDEX].toString());
            }
             
            if (object[GEO_PARENT_ID_INDEX] != null) { 
                geoParentId = Integer.parseInt(object[GEO_PARENT_ID_INDEX].toString());
            }
            if (object[GEO_RANKID_INDEX] != null) {
                geoRank = Integer.parseInt(object[GEO_RANKID_INDEX].toString());
            }
     
            buildGeography(geoParentId, geoRank);
            dcList.add(dwcLocality);
        }
    }
    
   

    private void buildOccurrence(Object[] object) {

        occurrence = new DwcOccurrence();
        if (object[CE_ID_INDEX] != null) {
            occurrence.setEventID(object[CE_ID_INDEX].toString());
        }
          
        if(object[CO_MODIFIEDDATE_INDEX] != null) { 
            occurrence.setModified(StringUtils.substringBefore(object[CO_MODIFIEDDATE_INDEX].toString(), ".0"));
        } else {
            occurrence.setModified(StringUtils.substringBefore(object[CO_CREATEDDATE_INDEX].toString(), ".0"));
        }
        
        if(object[COL_COLLECTION_TYPE_INDEX] != null) {
            occurrence.setBasisOfRecord(object[COL_COLLECTION_TYPE_INDEX].toString());
        }
 
        if(object[COL_COLLECTION_PRIMARYFOCUS_INDEX] != null) {
            occurrence.setType(object[COL_COLLECTION_PRIMARYFOCUS_INDEX].toString());
        }
         
        occurrence.setCollectionCode(object[COL_COLLECTION_CODE_INDEX].toString());
        occurrence.setRightsHolder(institutionName);
        occurrence.setInstitutionCode(institutionCode);

        sb = new StringBuilder();
        sb.append(institutionCode);
        sb.append(":");
        sb.append(object[COL_COLLECTION_CODE_INDEX]);
        sb.append(":");
        sb.append(object[CO_ID_INDEX]);
        occurrence.setOccurrenceID(sb.toString());
        if(object[CO_CATALOGNUMBER_INDEX] != null) {
            occurrence.setCatalogNumber(object[CO_CATALOGNUMBER_INDEX].toString()); 
        } 
        dcList.add(occurrence);
    }
 
    private void buildGeography(final int geoParentId, final int rankId) {
 
        sb = new StringBuilder();
        sb.append("SELECT g.rankID, g.fullName, g.parentID.geographyID, g.geographyCode ");
        sb.append("FROM Geography g ");
        sb.append("WHERE g.geographyID = "); 
         
        if (rankId > 100) {
            int geoPid = geoParentId;
            int rId = rankId;
            
            List<String> list = new ArrayList();
            boolean isParentNull = false;  
            Object[] obj;
            while (rId > 100 && !isParentNull) { 
                
                if(institutionCode.equals(NRM_INSTITUTION_CODE)) {
                    obj = dao.getListOfDataByJPQL(sb.toString() + geoPid); 
                } else {
                    obj = gnmDao.getListOfDataByJPQL(sb.toString() + geoPid); 
                }
                
                if (obj != null) {
                    list.add(obj[1].toString());
                    if (obj[0] != null) {
                        rId = Integer.parseInt(obj[0].toString());
                        switch (rId) {
                            case COUNTY_RANKID:
                                dwcLocality.setCounty(obj[1].toString());
                                break;
                            case STATE_RANKID:
                                dwcLocality.setStateProvince(obj[1].toString());
                                break;
                            case COUNTRY_RANKID:
                                dwcLocality.setCountry(obj[1].toString());
                                if(obj[3] != null) {
                                    dwcLocality.setCountryCode(obj[3].toString());
                                } 
                                break;
                            case CONTINENT_RANKID:
                                dwcLocality.setContinent(obj[1].toString());
                                break; 
                        }
                    }
                    
                    isParentNull = obj[2] == null; 
                    if (!isParentNull) {
                        geoPid = Integer.parseInt(obj[2].toString());
                    } else {
                        return;
                    } 
                } else {
                    return;
                } 
            } 
            Collections.reverse(list);
            
            dataSb = new StringBuilder();
            list.stream()
                    .forEach(s -> {
                        dataSb.append(s);
                        dataSb.append("; ");
                    });
 
            String highGeography = dataSb.toString();
            highGeography = StringUtils.removeEnd(highGeography, ";");
            dwcLocality.setHigherGeography(highGeography);
        } 
    }
    
    private void buildIdentification(Object[] object) {

        identification = new DwcIdentification();
        identification.setIdentificationID(occurrence.getOccurrenceID()); 
        identification.setOccurrenceID(occurrence.getOccurrenceID()); 
        identification.setIdentifiedBy("");

        if (object[DET_DATE_INDEX] != null) {           //  no data
            identification.setDateIdentified(object[DET_DATE_INDEX].toString());
        }
        if (object[DET_QUALIFIER_INDEX] != null) {
            identification.setIdentificationQualifier(object[DET_QUALIFIER_INDEX].toString());
        }

        if (object[DET_TYPESTATUSNAME_INDEX] != null) {
            identification.setTypeStatus(object[DET_TYPESTATUSNAME_INDEX].toString());
        } 
        dcList.add(identification);
    }
    
    private void buildCollector(final int collectingeventId) { 
        
//        logger.info("buildCollector : {}", collectingeventId);
        sb = new StringBuilder();
        sb.append("SELECT a.FirstName, a.MiddleInitial, a.LastName ");
        sb.append("FROM collector AS c ");
        sb.append("Inner Join agent AS a ON c.AgentID = a.AgentID ");
        sb.append("Inner Join collectingevent AS ce ON c.CollectingEventID = ce.CollectingEventID ");
        sb.append("WHERE ce.CollectingEventID = ");
        sb.append(collectingeventId);
                 
        List<String> collectorNames = new ArrayList<>();
   
        List<Object[]> list;
        if(institutionCode.equals(NRM_INSTITUTION_CODE)) {
            list = dao.getAllByNativeQuery(sb.toString());
        } else {
            list = gnmDao.getAllByNativeQuery(sb.toString());
        }
        
        
        for(Object[] object : list) {  
            dataSb = new StringBuilder();
            if(object[0] != null) {
                dataSb.append(object[0]);
            }
            if(object[1] != null) {
                dataSb.append(" ");
                dataSb.append(object[1]); 
            }
            if(object[2] != null) {
                dataSb.append(" ");
                dataSb.append(object[2]);
            }
            collectorNames.add(dataSb.toString());
        }  
        dwcEvent.setCollectors(collectorNames); 
        dwcEvent.setCollector(collectorNames.isEmpty() ? "" : StringUtils.join(collectorNames, "; "));
    }
    
    
    private void buildEvent(Object[] object) {
              
        
        dwcEvent = new DwcEvent(); 
        if(object[CE_ID_INDEX] != null) {
            dwcEvent.setEventId(object[CE_ID_INDEX].toString()); 
            
            if(object[LOC_ID_INDEX] != null) {
                dwcEvent.setLocationID(object[LOC_ID_INDEX].toString());
            }
            
            buildCollector(Integer.parseInt(object[CE_ID_INDEX].toString())); 
            
            if(object[CE_VERBATIMDATE_INDEX] != null) {
                dwcEvent.setVerbatimEventDate(object[CE_VERBATIMDATE_INDEX].toString());
            }
            
            if(object[CE_REMARKS_INDEX] != null) {
                dwcEvent.setRemarks(object[CE_REMARKS_INDEX].toString());
            }
            
            if(object[CE_ENDDATE_INDEX] != null) {
                endDate = convertStringToDate(object[CE_ENDDATE_INDEX].toString());
                
                if(endDate != null) {
                    calendar = Calendar.getInstance();
                    calendar.setTime(endDate);
                    dwcEvent.setEndDayOfYear(String.valueOf(calendar.get(Calendar.DAY_OF_YEAR)));
                } 
            }
            
            if(object[CE_STARTDATE_INDEX] != null) {
                dwcEvent.setEventDate(object[CE_STARTDATE_INDEX].toString());
                startDate = convertStringToDate(object[CE_STARTDATE_INDEX].toString());
                
                if(startDate != null) {
                    calendar = Calendar.getInstance();
                    calendar.setTime(startDate);
                    dwcEvent.setYear(String.valueOf(calendar.get(Calendar.YEAR)));
                    dwcEvent.setMonth(String.valueOf(calendar.get(Calendar.MONTH) + 1));
                    dwcEvent.setDay(String.valueOf(calendar.get(Calendar.DATE)));

                    dwcEvent.setStartDayOfYear(String.valueOf(calendar.get(Calendar.DAY_OF_YEAR)));
                    if (endDate == null) {
                        dwcEvent.setEndDayOfYear(String.valueOf(calendar.get(Calendar.DAY_OF_YEAR)));
                    }
                } 
            } 
        }
        dcList.add(dwcEvent); 
    }
    
     
    
    
    private void buildTaxon(Object[] object) {
        dwcTaxon = new DwcTaxon(); 
        
        sb = new StringBuilder();
        if (object[TX_FULLNAME_INDEX] != null) {
            sb.append(object[TX_FULLNAME_INDEX]);
            if (object[TX_AUTHOR_INDEX] != null) {
                sb.append(" ");
                sb.append(object[TX_AUTHOR_INDEX]);
            }
            dwcTaxon.setScientificName(sb.toString());
        }
        
        
        taxonRank = 0;
        if(object[TX_RANKID_INDEX] != null) {
            taxonRank = Integer.parseInt(object[TX_RANKID_INDEX].toString());
            dwcTaxon.setTaxonRank(Util.getRankName(taxonRank));
            
            if (taxonRank <= 180) { 
                switch (taxonRank) {
                    case 10:
                        dwcTaxon.setKingdom(object[TX_NAME_INDEX].toString());
                        break;
                    case 30:
                        dwcTaxon.setPhylum(object[TX_NAME_INDEX].toString());
                        break;
                    case 60:
                        dwcTaxon.setClazz(object[TX_NAME_INDEX].toString());
                        break;
                    case 100:
                        dwcTaxon.setOrder(object[TX_NAME_INDEX].toString());
                        break;
                    case 140:
                        dwcTaxon.setFamily(object[TX_NAME_INDEX].toString());
                        break;
                    case 180:
                        // genus rankid 180
                        dwcTaxon.setGenus(object[TX_NAME_INDEX].toString());
                        break;
                    default:
                        break;
                }
            }  else if(taxonRank == 220) {
                if(object[TX_NAME_INDEX] != null) {
                    dwcTaxon.setSpecificEpithet(object[TX_NAME_INDEX].toString());                // is this only for species ?
                }
            } else if(taxonRank == 230) {
                if(object[TX_NAME_INDEX] != null) {
                    dwcTaxon.setInfraspecficEpithet(object[TX_NAME_INDEX].toString());                // is this only for species ?
                }
            }
            if(object[TX_PARENTID_INDEX] != null) {
                taxonParentId = Integer.parseInt(object[TX_PARENTID_INDEX].toString());
                getHighClassification(taxonParentId, taxonRank, object[TX_FULLNAME_INDEX].toString()); 
            } 
        } 
        
        dwcTaxon.setIdentificationID(identification.getIdentificationID()); 
        dcList.add(dwcTaxon); 
    }
    
    
    private void getHighClassification(int taxonParentId, final int rankId, String taxaName) {
        
        sb = new StringBuilder();
        sb.append("SELECT t.taxonID, t.rankID, t.fullName, t.name, t.parentID.taxonID ");
        sb.append("FROM Taxon t ");
        sb.append("WHERE t.taxonID = ");
         
        if (rankId > 10) {
            int taxPId = taxonParentId;
            int rId = rankId;  

            dataSb = new StringBuilder();
//            dataSb.insert(0, "; ");
//            dataSb.insert(0, taxaName); 
            
            boolean isParentNull = false;
            Object[] taxonData;
            while (rId > 10 && !isParentNull) {  
                
                if(institutionCode.equals(NRM_INSTITUTION_CODE)) {
                    taxonData = dao.getListOfDataByJPQL(sb.toString() + taxPId); 
                } else {
                    taxonData = gnmDao.getListOfDataByJPQL(sb.toString() + taxPId); 
                }
                
                if(taxonData != null) {
                    if(taxonData[2] != null) {
                        dataSb.insert(0, "; ");
                        dataSb.insert(0, taxonData[2]);  
                        rId = Integer.parseInt(taxonData[1].toString());
                        switch (rId) {
                            case 220:
                                dwcTaxon.setSpecificEpithet(taxonData[3].toString());
                                break;
                            case 180:
                                dwcTaxon.setGenus(taxonData[2].toString());
                                break;
                            case 140:
                                dwcTaxon.setFamily(taxonData[2].toString());
                                break;
                            case 100:
                                dwcTaxon.setOrder(taxonData[2].toString());
                                break;
                            case 60:
                                dwcTaxon.setClazz(taxonData[2].toString());
                                break;
                            case 30:
                                dwcTaxon.setPhylum(taxonData[2].toString());
                                break;
                            case 10:
                                dwcTaxon.setKingdom(taxonData[2].toString());
                                break;
                        }
                    } 
                    dwcTaxon.setHigherClassification(StringUtils.removeStart(dataSb.toString(), "; "));
                    

                    isParentNull = taxonData[4] == null;
                    if (!isParentNull) {
                        taxPId = Integer.parseInt(taxonData[4].toString());
                        if (taxPId == taxonParentId) {
                            return; // points to self
                        }
                    }  
                } else {
                    return;
                } 
            } 
        }  
    }
     
    private String createQuery() {   
    
        StringBuilder querySB = new StringBuilder();
        querySB.append("SELECT co.CollectionObjectID, co.CatalogNumber, co.TimestampCreated, co.TimestampModified,");
        querySB.append("ce.CollectingEventID, ce.VerbatimDate, ce.Remarks, ce.EndDate, ce.StartDate, ");
        querySB.append("c.CollectionType, c.PrimaryFocus, c.Code, "); 
        querySB.append("loc.LocalityID, loc.Latitude1, loc.Longitude1, loc.LocalityName, loc.MinElevation, loc.MaxElevation, ");
        querySB.append("geo.RankID as geork, geo.ParentID as geopt, ");
        querySB.append("det.TypeStatusName, det.DeterminedDate, det.Qualifier, ");
        querySB.append("tx.FullName, tx.Name, tx.RankID, tx.Author, tx.ParentID ");   
        querySB.append("FROM collectionobject AS co ");  
        querySB.append("LEFT JOIN collection AS c ON co.CollectionID = c.UserGroupScopeId ");
        querySB.append("LEFT JOIN determination AS det ON co.CollectionObjectID = det.CollectionObjectID "); 
        querySB.append("LEFT JOIN taxon AS tx ON det.PreferredTaxonID = tx.TaxonID ");
        querySB.append("LEFT JOIN collectingevent AS ce ON co.CollectingEventID = ce.CollectingEventID " );  
        querySB.append("LEFT JOIN locality AS loc ON ce.LocalityID = loc.LocalityID ");
        querySB.append("LEFT JOIN geography AS geo ON loc.GeographyID = geo.GeographyID ");
        querySB.append("WHERE det.isCurrent <> 0 ");   
        querySB.append("AND co.collectionMemberId = ");
        querySB.append(collectionId);
        querySB.append(" AND (co.timestampCreated BETWEEN '");
//        querySB.append("AND co.collectionMemberId IN (");
//        querySB.append(163840);
//        querySB.append(",");
//        querySB.append(262144);
//        querySB.append(",");
//        querySB.append(491521);  
//        querySB.append(") AND (co.timestampCreated BETWEEN '");
        querySB.append(strStartDate);
        querySB.append("' AND '");
        querySB.append(strEndDate);
        querySB.append("' OR co.timestampModified BETWEEN '");
        querySB.append(strStartDate);
        querySB.append("' AND '");
        querySB.append(strEndDate);
        querySB.append("') AND det.isCurrent =  "); 
        querySB.append(true); 
        querySB.append(" AND co.CollectionObjectId > ");
        querySB.append(startId);
        querySB.append(" AND ce.LocalityID IS NOT NULL ");
        querySB.append("ORDER BY co.CollectionObjectId ");
        querySB.append("LIMIT 2010");
        return querySB.toString();   
    }
    
    private Date convertStringToDate(String strDate) {
        Date date = null; 
        if(date != null) {
            try {
                date = (Date)FORMAT.parse(strDate);
            } catch (ParseException ex) { 
            }
        } 
        return date;
    } 
}
