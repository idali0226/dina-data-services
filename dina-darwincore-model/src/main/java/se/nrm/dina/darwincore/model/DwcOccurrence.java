package se.nrm.dina.darwincore.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author idali
 */
@XmlRootElement
@XmlType(name="",propOrder={"occurrenceID","catalogNumber","type","modified","rightsHolder","rights","institutionCode","collectionCode",
                            "basisOfRecord","individualCount","eventID"})
public class DwcOccurrence implements DarwinCoreInterface, Serializable {
    
    private String type;
    private String modified;
    private String rightsHolder;
    private String rights;
    private String institutionCode;
    private String collectionCode;
    private String occurrenceID;
    private String catalogNumber;
    private String basisOfRecord;
    private String individualCount;
    private String eventID;

    @XmlElement(name="dwc:basisOfRecord")
    public String getBasisOfRecord() {
        return basisOfRecord;
    }

    public void setBasisOfRecord(String basisOfRecord) {
        this.basisOfRecord = basisOfRecord;
    }

    @XmlElement(name="dwc:collectionCode")
    public String getCollectionCode() {
        return collectionCode;
    }

    public void setCollectionCode(String collectionCode) {
        this.collectionCode = collectionCode;
    }

    @XmlElement(name="dwc:eventID")
    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    @XmlElement(name="dwc:institutionCode")
    public String getInstitutionCode() {
        return institutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode;
    }

    @XmlElement(name="dcterms:modified")
    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    @XmlElement(name="dwc:occurrenceID")
    public String getOccurrenceID() {
        return occurrenceID;
    } 
    
    public void setOccurrenceID(String occurrenceID) {
        this.occurrenceID = occurrenceID;
    }

    @XmlElement(name="dwc:catalogNumber")
    public String getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(String catalogNumber) {
        this.catalogNumber = catalogNumber;
    } 
    
    @XmlElement(name="dcterms:rights")
    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    @XmlElement(name="dcterms:rightsHolder")
    public String getRightsHolder() {
        return rightsHolder;
    }

    public void setRightsHolder(String rightsHolder) {
        this.rightsHolder = rightsHolder;
    }

    @XmlElement(name="dcterms:type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlElement(name="dwc:individualCount")
    public String getIndividualCount() {
        return individualCount;
    }

    public void setIndividualCount(String individualCount) {
        this.individualCount = individualCount;
    }
    
    
}
