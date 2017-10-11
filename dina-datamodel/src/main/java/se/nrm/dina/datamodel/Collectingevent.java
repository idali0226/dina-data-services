/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.datamodel;
 
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType; 
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
@Table(name = "collectingevent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Collectingevent.findAll", query = "SELECT c FROM Collectingevent c"),
    @NamedQuery(name = "Collectingevent.findByCollectingEventID", query = "SELECT c FROM Collectingevent c WHERE c.collectingEventID = :collectingEventID"),
    @NamedQuery(name = "Collectingevent.findByEndDate", query = "SELECT c FROM Collectingevent c WHERE c.endDate = :endDate"),
    @NamedQuery(name = "Collectingevent.findByStartDate", query = "SELECT c FROM Collectingevent c WHERE c.startDate = :startDate"),
    @NamedQuery(name = "Collectingevent.findByStationFieldNumber", query = "SELECT c FROM Collectingevent c WHERE c.stationFieldNumber = :stationFieldNumber"),
    @NamedQuery(name = "Collectingevent.findByVisibility", query = "SELECT c FROM Collectingevent c WHERE c.visibility = :visibility"),
    @NamedQuery(name = "Collectingevent.findByGuid", query = "SELECT c FROM Collectingevent c WHERE c.guid = :guid")  })
public class Collectingevent extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CollectingEventID")
    private Integer collectingEventID;
    
    
    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    
    @Column(name = "EndDatePrecision")
    private Short endDatePrecision;
    
    @Size(max = 50)
    @Column(name = "EndDateVerbatim")
    private String endDateVerbatim;
    
    @Column(name = "EndTime")
    private Short endTime;
    
    @Size(max = 50)
    @Column(name = "Method")
    private String method;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    
    @Column(name = "StartDatePrecision")
    private Short startDatePrecision;
    
    @Size(max = 50)
    @Column(name = "StartDateVerbatim")
    private String startDateVerbatim;
    
    @Column(name = "StartTime")
    private Short startTime;
    
    @Size(max = 50)
    @Column(name = "StationFieldNumber")
    private String stationFieldNumber;
    
    @Size(max = 50)
    @Column(name = "VerbatimDate")
    private String verbatimDate;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "VerbatimLocality")
    private String verbatimLocality;
    
    @Column(name = "Visibility")
    private Short visibility;
    
    @Column(name = "SGRStatus")
    private Short sGRStatus;
    
    @Size(max = 128)
    @Column(name = "GUID")
    private String guid;
    
    @Column(name = "Integer1")
    private Integer integer1;
    
    @Column(name = "Integer2")
    private Integer integer2;
    
    @Column(name = "ReservedInteger3")
    private Integer reservedInteger3;
    
    @Column(name = "ReservedInteger4")
    private Integer reservedInteger4;
    
    @Size(max = 128)
    @Column(name = "ReservedText1")
    private String reservedText1;
    
    @Size(max = 128)
    @Column(name = "ReservedText2")
    private String reservedText2;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text1")
    private String text1;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text2")
    private String text2;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "collectingEventID", fetch = FetchType.LAZY)
    private List<Collectingeventattachment> collectingeventattachmentList;
    
    @OneToMany(mappedBy = "collectingEventID", fetch = FetchType.LAZY)
    private List<Collectionobject> collectionobjectList;
    
    @JoinColumn(name = "DisciplineID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne(optional = false)
    private Discipline disciplineID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CollectingTripID", referencedColumnName = "CollectingTripID")
    @ManyToOne
    private Collectingtrip collectingTripID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "VisibilitySetByID", referencedColumnName = "SpecifyUserID")
    @ManyToOne
    private Specifyuser visibilitySetByID;
    
    @JoinColumn(name = "PaleoContextID", referencedColumnName = "PaleoContextID")
    @ManyToOne
    private Paleocontext paleoContextID;
    
    @JoinColumn(name = "LocalityID", referencedColumnName = "LocalityID")
    @ManyToOne
    private Locality localityID;
    
    @JoinColumn(name = "CollectingEventAttributeID", referencedColumnName = "CollectingEventAttributeID")
    @ManyToOne
    private Collectingeventattribute collectingEventAttributeID;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "collectingEventID", fetch = FetchType.LAZY)
    private List<Collectingeventattr> collectingeventattrList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "collectingEventID", fetch = FetchType.LAZY)
    private List<Collector> collectorList;

    public Collectingevent() {
    }

    public Collectingevent(Integer collectingEventID) {
        this.collectingEventID = collectingEventID;
    }

    public Collectingevent(Integer collectingEventID, Date timestampCreated) {
        this.collectingEventID = collectingEventID;
        this.timestampCreated = timestampCreated;
    }
    
        @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + collectingEventID;
    }

    @Override
    public int getEntityId() {
        return collectingEventID;
    }
    
    public Integer getCollectingEventID() {
        return collectingEventID;
    }

    public void setCollectingEventID(Integer collectingEventID) {
        this.collectingEventID = collectingEventID;
    }
 

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Short getEndDatePrecision() {
        return endDatePrecision;
    }

    public void setEndDatePrecision(Short endDatePrecision) {
        this.endDatePrecision = endDatePrecision;
    }

    public String getEndDateVerbatim() {
        return endDateVerbatim;
    }

    public void setEndDateVerbatim(String endDateVerbatim) {
        this.endDateVerbatim = endDateVerbatim;
    }

    public Short getEndTime() {
        return endTime;
    }

    public void setEndTime(Short endTime) {
        this.endTime = endTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Short getStartDatePrecision() {
        return startDatePrecision;
    }

    public void setStartDatePrecision(Short startDatePrecision) {
        this.startDatePrecision = startDatePrecision;
    }

    public String getStartDateVerbatim() {
        return startDateVerbatim;
    }

    public void setStartDateVerbatim(String startDateVerbatim) {
        this.startDateVerbatim = startDateVerbatim;
    }

    public Short getStartTime() {
        return startTime;
    }

    public void setStartTime(Short startTime) {
        this.startTime = startTime;
    }

    public String getStationFieldNumber() {
        return stationFieldNumber;
    }

    public void setStationFieldNumber(String stationFieldNumber) {
        this.stationFieldNumber = stationFieldNumber;
    }

    public String getVerbatimDate() {
        return verbatimDate;
    }

    public void setVerbatimDate(String verbatimDate) {
        this.verbatimDate = verbatimDate;
    }

    public String getVerbatimLocality() {
        return verbatimLocality;
    }

    public void setVerbatimLocality(String verbatimLocality) {
        this.verbatimLocality = verbatimLocality;
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

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Integer getInteger1() {
        return integer1;
    }

    public void setInteger1(Integer integer1) {
        this.integer1 = integer1;
    }

    public Integer getInteger2() {
        return integer2;
    }

    public void setInteger2(Integer integer2) {
        this.integer2 = integer2;
    }

    public Integer getReservedInteger3() {
        return reservedInteger3;
    }

    public void setReservedInteger3(Integer reservedInteger3) {
        this.reservedInteger3 = reservedInteger3;
    }

    public Integer getReservedInteger4() {
        return reservedInteger4;
    }

    public void setReservedInteger4(Integer reservedInteger4) {
        this.reservedInteger4 = reservedInteger4;
    }

    public String getReservedText1() {
        return reservedText1;
    }

    public void setReservedText1(String reservedText1) {
        this.reservedText1 = reservedText1;
    }

    public String getReservedText2() {
        return reservedText2;
    }

    public void setReservedText2(String reservedText2) {
        this.reservedText2 = reservedText2;
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

    @XmlTransient
    public List<Collectingeventattachment> getCollectingeventattachmentList() {
        return collectingeventattachmentList;
    }

    public void setCollectingeventattachmentList(List<Collectingeventattachment> collectingeventattachmentList) {
        this.collectingeventattachmentList = collectingeventattachmentList;
    }

    @XmlTransient
    public List<Collectionobject> getCollectionobjectList() {
        return collectionobjectList;
    }

    public void setCollectionobjectList(List<Collectionobject> collectionobjectList) {
        this.collectionobjectList = collectionobjectList;
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
    public Collectingtrip getCollectingTripID() {
        return collectingTripID;
    }

    public void setCollectingTripID(Collectingtrip collectingTripID) {
        this.collectingTripID = collectingTripID;
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
    public Locality getLocalityID() {
        return localityID;
    }

    public void setLocalityID(Locality localityID) {
        this.localityID = localityID;
    }

    @XmlIDREF
    public Collectingeventattribute getCollectingEventAttributeID() {
        return collectingEventAttributeID;
    }

    public void setCollectingEventAttributeID(Collectingeventattribute collectingEventAttributeID) {
        this.collectingEventAttributeID = collectingEventAttributeID;
    }

    @XmlTransient
    public List<Collectingeventattr> getCollectingeventattrList() {
        return collectingeventattrList;
    }

    public void setCollectingeventattrList(List<Collectingeventattr> collectingeventattrList) {
        this.collectingeventattrList = collectingeventattrList;
    }

    @XmlTransient
    public List<Collector> getCollectorList() {
        return collectorList;
    }

    public void setCollectorList(List<Collector> collectorList) {
        this.collectorList = collectorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (collectingEventID != null ? collectingEventID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Collectingevent)) {
            return false;
        }
        Collectingevent other = (Collectingevent) object;
        return !((this.collectingEventID == null && other.collectingEventID != null) || (this.collectingEventID != null && !this.collectingEventID.equals(other.collectingEventID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Collectingevent[ collectingEventID=" + collectingEventID + " ]";
    }
    
}
