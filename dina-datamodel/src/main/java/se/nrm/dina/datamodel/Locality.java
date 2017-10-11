/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.datamodel;
 
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table; 
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import se.nrm.dina.datamodel.util.Util;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "locality")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locality.findAll", query = "SELECT l FROM Locality l"),
    @NamedQuery(name = "Locality.findByLocalityID", query = "SELECT l FROM Locality l WHERE l.localityID = :localityID"), 
    @NamedQuery(name = "Locality.findByDatum", query = "SELECT l FROM Locality l WHERE l.datum = :datum"),
    @NamedQuery(name = "Locality.findByElevationAccuracy", query = "SELECT l FROM Locality l WHERE l.elevationAccuracy = :elevationAccuracy"),
    @NamedQuery(name = "Locality.findByElevationMethod", query = "SELECT l FROM Locality l WHERE l.elevationMethod = :elevationMethod"),
    @NamedQuery(name = "Locality.findByGuid", query = "SELECT l FROM Locality l WHERE l.guid = :guid"), 
    @NamedQuery(name = "Locality.findByVerbatimLongitude", query = "SELECT l FROM Locality l WHERE l.verbatimLongitude = :verbatimLongitude")})
public class Locality extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LocalityID")
    private Integer localityID;
    
    @Size(max = 50)
    @Column(name = "Datum")
    private String datum;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ElevationAccuracy")
    private Double elevationAccuracy;
    
    @Size(max = 50)
    @Column(name = "ElevationMethod")
    private String elevationMethod;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "GML")
    private String gml;
    
    @Size(max = 128)
    @Column(name = "GUID")
    private String guid;
    
    
    @Size(max = 50)
    @Column(name = "Lat1Text")
    private String lat1Text;
     
    @Size(max = 50)
    @Column(name = "Lat2Text")
    private String lat2Text;
    
    @Column(name = "LatLongAccuracy")
    private Double latLongAccuracy;
    
    @Size(max = 50)
    @Column(name = "LatLongMethod")
    private String latLongMethod;
    
    @Size(max = 50)
    @Column(name = "LatLongType")
    private String latLongType;
    
    @Column(name = "Latitude1")
    private BigDecimal latitude1;
    
    @Column(name = "Latitude2")
    private BigDecimal latitude2;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "LocalityName")
    private String localityName;
    
    @Size(max = 50)
    @Column(name = "Long1Text")
    private String long1Text;
    
    @Size(max = 50)
    @Column(name = "Long2Text")
    private String long2Text;
    
    @Column(name = "Longitude1")
    private BigDecimal longitude1;
    
    @Column(name = "Longitude2")
    private BigDecimal longitude2;
    
    @Column(name = "MaxElevation")
    private Double maxElevation;
    
    @Column(name = "MinElevation")
    private Double minElevation;
    
    @Size(max = 255)
    @Column(name = "NamedPlace")
    private String namedPlace;
    
    @Size(max = 50)
    @Column(name = "OriginalElevationUnit")
    private String originalElevationUnit;
    
    @Column(name = "OriginalLatLongUnit")
    private Integer originalLatLongUnit;
    
    @Size(max = 120)
    @Column(name = "RelationToNamedPlace")
    private String relationToNamedPlace;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Size(max = 32)
    @Column(name = "ShortName")
    private String shortName;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "SrcLatLongUnit")
    private short srcLatLongUnit;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text1")
    private String text1;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text2")
    private String text2;
    
    @Size(max = 50)
    @Column(name = "VerbatimElevation")
    private String verbatimElevation;
    
    @Column(name = "Visibility")
    private Short visibility;
    
    @Column(name = "SGRStatus")
    private Short sGRStatus;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text3")
    private String text3;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text4")
    private String text4;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text5")
    private String text5;
    
    @Size(max = 50)
    @Column(name = "VerbatimLatitude")
    private String verbatimLatitude;
    
    @Size(max = 50)
    @Column(name = "VerbatimLongitude")
    private String verbatimLongitude;
    
    @OneToMany(mappedBy = "localityID", fetch = FetchType.LAZY)
    private List<Geocoorddetail> geocoorddetailList;
    
    @JoinColumn(name = "DisciplineID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne(optional = false)
    private Discipline disciplineID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "VisibilitySetByID", referencedColumnName = "SpecifyUserID")
    @ManyToOne
    private Specifyuser visibilitySetByID;
    
    @JoinColumn(name = "PaleoContextID", referencedColumnName = "PaleoContextID")
    @ManyToOne
    private Paleocontext paleoContextID;
    
    @JoinColumn(name = "GeographyID", referencedColumnName = "GeographyID")
    @ManyToOne
    private Geography geographyID;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localityID", fetch = FetchType.LAZY)
    private List<Localitycitation> localitycitationList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localityID", fetch = FetchType.LAZY)
    private List<Localitynamealias> localitynamealiasList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localityID", fetch = FetchType.LAZY)
    private List<Localityattachment> localityattachmentList;
    
    @OneToMany(mappedBy = "localityID", fetch = FetchType.LAZY)
    private List<Localitydetail> localitydetailList;
    
    @OneToMany(mappedBy = "localityID", fetch = FetchType.LAZY)
    private List<Collectingevent> collectingeventList;

    public Locality() {
    }

    public Locality(Integer localityID) {
        this.localityID = localityID;
    }

    public Locality(Integer localityID, Date timestampCreated, String localityName, short srcLatLongUnit) {
        this.localityID = localityID;
        this.timestampCreated = timestampCreated;
        this.localityName = localityName;
        this.srcLatLongUnit = srcLatLongUnit;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + localityID;
    }
    
    @Override
    public int getEntityId() {
        return localityID;
    }

    public Integer getLocalityID() {
        return localityID;
    }

    public void setLocalityID(Integer localityID) {
        this.localityID = localityID;
    }
 

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public Double getElevationAccuracy() {
        return elevationAccuracy;
    }

    public void setElevationAccuracy(Double elevationAccuracy) {
        this.elevationAccuracy = elevationAccuracy;
    }

    public String getElevationMethod() {
        return elevationMethod;
    }

    public void setElevationMethod(String elevationMethod) {
        this.elevationMethod = elevationMethod;
    }

    public String getGml() {
        return gml;
    }

    public void setGml(String gml) {
        this.gml = gml;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getLat1Text() {
        return lat1Text;
    }

    public void setLat1Text(String lat1Text) {
        this.lat1Text = lat1Text;
    }

    public String getLat2Text() {
        return lat2Text;
    }

    public void setLat2Text(String lat2Text) {
        this.lat2Text = lat2Text;
    }

    public Double getLatLongAccuracy() {
        return latLongAccuracy;
    }

    public void setLatLongAccuracy(Double latLongAccuracy) {
        this.latLongAccuracy = latLongAccuracy;
    }

    public String getLatLongMethod() {
        return latLongMethod;
    }

    public void setLatLongMethod(String latLongMethod) {
        this.latLongMethod = latLongMethod;
    }

    public String getLatLongType() {
        return latLongType;
    }

    public void setLatLongType(String latLongType) {
        this.latLongType = latLongType;
    }

    public BigDecimal getLatitude1() {
        return latitude1;
    }

    public void setLatitude1(BigDecimal latitude1) {
        this.latitude1 = latitude1;
    }

    public BigDecimal getLatitude2() {
        return latitude2;
    }

    public void setLatitude2(BigDecimal latitude2) {
        this.latitude2 = latitude2;
    }

    public String getLocalityName() {
        return localityName;
    }

    public void setLocalityName(String localityName) {
        this.localityName = localityName;
    }

    public String getLong1Text() {
        return long1Text;
    }

    public void setLong1Text(String long1Text) {
        this.long1Text = long1Text;
    }

    public String getLong2Text() {
        return long2Text;
    }

    public void setLong2Text(String long2Text) {
        this.long2Text = long2Text;
    }

    public BigDecimal getLongitude1() {
        return longitude1;
    }

    public void setLongitude1(BigDecimal longitude1) {
        this.longitude1 = longitude1;
    }

    public BigDecimal getLongitude2() {
        return longitude2;
    }

    public void setLongitude2(BigDecimal longitude2) {
        this.longitude2 = longitude2;
    }

    public Double getMaxElevation() {
        return maxElevation;
    }

    public void setMaxElevation(Double maxElevation) {
        this.maxElevation = maxElevation;
    }

    public Double getMinElevation() {
        return minElevation;
    }

    public void setMinElevation(Double minElevation) {
        this.minElevation = minElevation;
    }

    public String getNamedPlace() {
        return namedPlace;
    }

    public void setNamedPlace(String namedPlace) {
        this.namedPlace = namedPlace;
    }

    public String getOriginalElevationUnit() {
        return originalElevationUnit;
    }

    public void setOriginalElevationUnit(String originalElevationUnit) {
        this.originalElevationUnit = originalElevationUnit;
    }

    public Integer getOriginalLatLongUnit() {
        return originalLatLongUnit;
    }

    public void setOriginalLatLongUnit(Integer originalLatLongUnit) {
        this.originalLatLongUnit = originalLatLongUnit;
    }

    public String getRelationToNamedPlace() {
        return relationToNamedPlace;
    }

    public void setRelationToNamedPlace(String relationToNamedPlace) {
        this.relationToNamedPlace = relationToNamedPlace;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public short getSrcLatLongUnit() {
        return srcLatLongUnit;
    }

    public void setSrcLatLongUnit(short srcLatLongUnit) {
        this.srcLatLongUnit = srcLatLongUnit;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getVerbatimElevation() {
        return verbatimElevation;
    }

    public void setVerbatimElevation(String verbatimElevation) {
        this.verbatimElevation = verbatimElevation;
    }

    public Short getVisibility() {
        return visibility;
    }

    public void setVisibility(Short visibility) {
        this.visibility = visibility;
    }

    public Short getSGRStatus() {
        return sGRStatus;
    }

    public void setSGRStatus(Short sGRStatus) {
        this.sGRStatus = sGRStatus;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getText4() {
        return text4;
    }

    public void setText4(String text4) {
        this.text4 = text4;
    }

    public String getText5() {
        return text5;
    }

    public void setText5(String text5) {
        this.text5 = text5;
    }

    public String getVerbatimLatitude() {
        return verbatimLatitude;
    }

    public void setVerbatimLatitude(String verbatimLatitude) {
        this.verbatimLatitude = verbatimLatitude;
    }

    public String getVerbatimLongitude() {
        return verbatimLongitude;
    }

    public void setVerbatimLongitude(String verbatimLongitude) {
        this.verbatimLongitude = verbatimLongitude;
    }

    @XmlTransient
    public List<Geocoorddetail> getGeocoorddetailList() {
        return geocoorddetailList;
    }

    public void setGeocoorddetailList(List<Geocoorddetail> geocoorddetailList) {
        this.geocoorddetailList = geocoorddetailList;
    }

    @XmlIDREF
    public Discipline getDisciplineID() {
        return disciplineID;
    }

    public void setDisciplineID(Discipline disciplineID) {
        this.disciplineID = disciplineID;
    }

    @XmlIDREF
    public Agent getModifiedByAgentID() {
        return modifiedByAgentID;
    }

    public void setModifiedByAgentID(Agent modifiedByAgentID) {
        this.modifiedByAgentID = modifiedByAgentID;
    }

    @XmlIDREF
    public Agent getCreatedByAgentID() {
        return createdByAgentID;
    }

    public void setCreatedByAgentID(Agent createdByAgentID) {
        this.createdByAgentID = createdByAgentID;
    }

    @XmlIDREF
    public Specifyuser getVisibilitySetByID() {
        return visibilitySetByID;
    }

    public void setVisibilitySetByID(Specifyuser visibilitySetByID) {
        this.visibilitySetByID = visibilitySetByID;
    }

    @XmlIDREF
    public Paleocontext getPaleoContextID() {
        return paleoContextID;
    }

    public void setPaleoContextID(Paleocontext paleoContextID) {
        this.paleoContextID = paleoContextID;
    }

    @XmlIDREF
    public Geography getGeographyID() {
        return geographyID;
    }

    public void setGeographyID(Geography geographyID) {
        this.geographyID = geographyID;
    }

    @XmlTransient
    public List<Localitycitation> getLocalitycitationList() {
        return localitycitationList;
    }

    public void setLocalitycitationList(List<Localitycitation> localitycitationList) {
        this.localitycitationList = localitycitationList;
    }

    @XmlTransient
    public List<Localitynamealias> getLocalitynamealiasList() {
        return localitynamealiasList;
    }

    public void setLocalitynamealiasList(List<Localitynamealias> localitynamealiasList) {
        this.localitynamealiasList = localitynamealiasList;
    }

    @XmlTransient
    public List<Localityattachment> getLocalityattachmentList() {
        return localityattachmentList;
    }

    public void setLocalityattachmentList(List<Localityattachment> localityattachmentList) {
        this.localityattachmentList = localityattachmentList;
    }

    @XmlTransient
    public List<Localitydetail> getLocalitydetailList() {
        return localitydetailList;
    }

    public void setLocalitydetailList(List<Localitydetail> localitydetailList) {
        this.localitydetailList = localitydetailList;
    }

    @XmlTransient
    public List<Collectingevent> getCollectingeventList() {
        return collectingeventList;
    }

    public void setCollectingeventList(List<Collectingevent> collectingeventList) {
        this.collectingeventList = collectingeventList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (localityID != null ? localityID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locality)) {
            return false;
        }
        Locality other = (Locality) object;
        return !((this.localityID == null && other.localityID != null) || (this.localityID != null && !this.localityID.equals(other.localityID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Locality[ localityID=" + localityID + " ]";
    }
    
}
