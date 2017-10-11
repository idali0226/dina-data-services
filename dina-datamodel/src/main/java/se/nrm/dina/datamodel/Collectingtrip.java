/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.datamodel;
 
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "collectingtrip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Collectingtrip.findAll", query = "SELECT c FROM Collectingtrip c"),
    @NamedQuery(name = "Collectingtrip.findByCollectingTripID", query = "SELECT c FROM Collectingtrip c WHERE c.collectingTripID = :collectingTripID"),
     @NamedQuery(name = "Collectingtrip.findByCollectingTripName", query = "SELECT c FROM Collectingtrip c WHERE c.collectingTripName = :collectingTripName"),
    @NamedQuery(name = "Collectingtrip.findByEndDate", query = "SELECT c FROM Collectingtrip c WHERE c.endDate = :endDate"),  
    @NamedQuery(name = "Collectingtrip.findBySponsor", query = "SELECT c FROM Collectingtrip c WHERE c.sponsor = :sponsor"),
    @NamedQuery(name = "Collectingtrip.findByStartDate", query = "SELECT c FROM Collectingtrip c WHERE c.startDate = :startDate"),     
    @NamedQuery(name = "Collectingtrip.findByCruise", query = "SELECT c FROM Collectingtrip c WHERE c.cruise = :cruise"),
    @NamedQuery(name = "Collectingtrip.findByExpedition", query = "SELECT c FROM Collectingtrip c WHERE c.expedition = :expedition"),
    @NamedQuery(name = "Collectingtrip.findByVessel", query = "SELECT c FROM Collectingtrip c WHERE c.vessel = :vessel")})
public class Collectingtrip extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CollectingTripID")
    private Integer collectingTripID;
    
    
    
    @Size(max = 64)
    @Column(name = "CollectingTripName")
    private String collectingTripName;
    
    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    
    @Size(max = 50)
    @Column(name = "EndDateVerbatim")
    private String endDateVerbatim;
    
    @Column(name = "EndTime")
    private Short endTime;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Size(max = 64)
    @Column(name = "Sponsor")
    private String sponsor;
    
    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    
    @Size(max = 50)
    @Column(name = "StartDateVerbatim")
    private String startDateVerbatim;
    
    @Column(name = "StartTime")
    private Short startTime;
    
    @Column(name = "EndDatePrecision")
    private Short endDatePrecision;
    
    @Column(name = "Number1")
    private Integer number1;
    
    @Column(name = "Number2")
    private Integer number2;
    
    @Column(name = "StartDatePrecision")
    private Short startDatePrecision;
    
    @Size(max = 255)
    @Column(name = "Text1")
    private String text1;
    
    @Size(max = 128)
    @Column(name = "Text2")
    private String text2;
    
    @Size(max = 64)
    @Column(name = "Text3")
    private String text3;
    
    @Size(max = 64)
    @Column(name = "Text4")
    private String text4;
    
    @Column(name = "YesNo1")
    private Boolean yesNo1;
    
    @Column(name = "YesNo2")
    private Boolean yesNo2;
    
    @Size(max = 250)
    @Column(name = "Cruise")
    private String cruise;
    
    @Size(max = 250)
    @Column(name = "Expedition")
    private String expedition;
    
    @Size(max = 250)
    @Column(name = "Vessel")
    private String vessel;
    
    @JoinColumn(name = "DisciplineID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne(optional = false)
    private Discipline disciplineID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @OneToMany(mappedBy = "collectingTripID", fetch = FetchType.LAZY)
    private List<Collectingevent> collectingeventList;

    public Collectingtrip() {
    }

    public Collectingtrip(Integer collectingTripID) {
        this.collectingTripID = collectingTripID;
    }

    public Collectingtrip(Integer collectingTripID, Date timestampCreated) {
        this.collectingTripID = collectingTripID;
        this.timestampCreated = timestampCreated;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + collectingTripID;
    }

    @Override
    public int getEntityId() {
        return collectingTripID;
    }
    
    public Integer getCollectingTripID() {
        return collectingTripID;
    }

    public void setCollectingTripID(Integer collectingTripID) {
        this.collectingTripID = collectingTripID;
    }
 
    public String getCollectingTripName() {
        return collectingTripName;
    }

    public void setCollectingTripName(String collectingTripName) {
        this.collectingTripName = collectingTripName;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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

    public Short getEndDatePrecision() {
        return endDatePrecision;
    }

    public void setEndDatePrecision(Short endDatePrecision) {
        this.endDatePrecision = endDatePrecision;
    }

    public Integer getNumber1() {
        return number1;
    }

    public void setNumber1(Integer number1) {
        this.number1 = number1;
    }

    public Integer getNumber2() {
        return number2;
    }

    public void setNumber2(Integer number2) {
        this.number2 = number2;
    }

    public Short getStartDatePrecision() {
        return startDatePrecision;
    }

    public void setStartDatePrecision(Short startDatePrecision) {
        this.startDatePrecision = startDatePrecision;
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

    public Boolean getYesNo1() {
        return yesNo1;
    }

    public void setYesNo1(Boolean yesNo1) {
        this.yesNo1 = yesNo1;
    }

    public Boolean getYesNo2() {
        return yesNo2;
    }

    public void setYesNo2(Boolean yesNo2) {
        this.yesNo2 = yesNo2;
    }

    public String getCruise() {
        return cruise;
    }

    public void setCruise(String cruise) {
        this.cruise = cruise;
    }

    public String getExpedition() {
        return expedition;
    }

    public void setExpedition(String expedition) {
        this.expedition = expedition;
    }

    public String getVessel() {
        return vessel;
    }

    public void setVessel(String vessel) {
        this.vessel = vessel;
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
        hash += (collectingTripID != null ? collectingTripID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Collectingtrip)) {
            return false;
        }
        Collectingtrip other = (Collectingtrip) object;
        return !((this.collectingTripID == null && other.collectingTripID != null) || (this.collectingTripID != null && !this.collectingTripID.equals(other.collectingTripID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Collectingtrip[ collectingTripID=" + collectingTripID + " ]";
    }
    
}
