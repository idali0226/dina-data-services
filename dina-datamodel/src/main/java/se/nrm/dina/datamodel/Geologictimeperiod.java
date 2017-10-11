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
@Table(name = "geologictimeperiod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Geologictimeperiod.findAll", query = "SELECT g FROM Geologictimeperiod g"),
    @NamedQuery(name = "Geologictimeperiod.findByGeologicTimePeriodID", query = "SELECT g FROM Geologictimeperiod g WHERE g.geologicTimePeriodID = :geologicTimePeriodID"),  
    @NamedQuery(name = "Geologictimeperiod.findByFullName", query = "SELECT g FROM Geologictimeperiod g WHERE g.fullName = :fullName"),
    @NamedQuery(name = "Geologictimeperiod.findByGuid", query = "SELECT g FROM Geologictimeperiod g WHERE g.guid = :guid"),
    @NamedQuery(name = "Geologictimeperiod.findByHighestChildNodeNumber", query = "SELECT g FROM Geologictimeperiod g WHERE g.highestChildNodeNumber = :highestChildNodeNumber"),
    @NamedQuery(name = "Geologictimeperiod.findByIsAccepted", query = "SELECT g FROM Geologictimeperiod g WHERE g.isAccepted = :isAccepted"),
    @NamedQuery(name = "Geologictimeperiod.findByIsBioStrat", query = "SELECT g FROM Geologictimeperiod g WHERE g.isBioStrat = :isBioStrat"),
    @NamedQuery(name = "Geologictimeperiod.findByName", query = "SELECT g FROM Geologictimeperiod g WHERE g.name = :name") })
public class Geologictimeperiod extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GeologicTimePeriodID")
    private Integer geologicTimePeriodID;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "EndPeriod")
    private Float endPeriod;
    
    @Column(name = "EndUncertainty")
    private Float endUncertainty;
    
    @Size(max = 64)
    @Column(name = "Text1")
    private String text1;
    
    @Size(max = 64)
    @Column(name = "Text2")
    private String text2;
    
    @Size(max = 255)
    @Column(name = "FullName")
    private String fullName;
    
    @Size(max = 128)
    @Column(name = "GUID")
    private String guid;
    
    @Column(name = "HighestChildNodeNumber")
    private Integer highestChildNodeNumber;
    
    @Column(name = "IsAccepted")
    private Boolean isAccepted;
    
    @Column(name = "IsBioStrat")
    private Boolean isBioStrat;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "Name")
    private String name;
    
    @Column(name = "NodeNumber")
    private Integer nodeNumber;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "RankID")
    private int rankID;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Size(max = 64)
    @Column(name = "Standard")
    private String standard;
    
    @Column(name = "StartPeriod")
    private Float startPeriod;
    
    @Column(name = "StartUncertainty")
    private Float startUncertainty;
    
    @OneToMany(mappedBy = "chronosStratEndID", fetch = FetchType.LAZY)
    private List<Paleocontext> paleocontextList;
    
    @OneToMany(mappedBy = "chronosStratID", fetch = FetchType.LAZY)
    private List<Paleocontext> paleocontextList1;
    
    @OneToMany(mappedBy = "bioStratID", fetch = FetchType.LAZY)
    private List<Paleocontext> paleocontextList2;
    
    @OneToMany(mappedBy = "acceptedID", fetch = FetchType.LAZY)
    private List<Geologictimeperiod> geologictimeperiodList;
    
    @JoinColumn(name = "AcceptedID", referencedColumnName = "GeologicTimePeriodID")
    @ManyToOne
    private Geologictimeperiod acceptedID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "GeologicTimePeriodTreeDefID", referencedColumnName = "GeologicTimePeriodTreeDefID")
    @ManyToOne(optional = false)
    private Geologictimeperiodtreedef geologicTimePeriodTreeDefID;
    
    @JoinColumn(name = "GeologicTimePeriodTreeDefItemID", referencedColumnName = "GeologicTimePeriodTreeDefItemID")
    @ManyToOne(optional = false)
    private Geologictimeperiodtreedefitem geologicTimePeriodTreeDefItemID;
    
    @OneToMany(mappedBy = "parentID", fetch = FetchType.LAZY)
    private List<Geologictimeperiod> geologictimeperiodList1;
    
    @JoinColumn(name = "ParentID", referencedColumnName = "GeologicTimePeriodID")
    @ManyToOne
    private Geologictimeperiod parentID;

    public Geologictimeperiod() {
    }

    public Geologictimeperiod(Integer geologicTimePeriodID) {
        this.geologicTimePeriodID = geologicTimePeriodID;
    }

    public Geologictimeperiod(Integer geologicTimePeriodID, Date timestampCreated, String name, int rankID) {
        this.geologicTimePeriodID = geologicTimePeriodID;
        this.timestampCreated = timestampCreated;
        this.name = name;
        this.rankID = rankID;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + geologicTimePeriodID;
    }
    
    @Override
    public int getEntityId() {
        return geologicTimePeriodID;
    }

    public Integer getGeologicTimePeriodID() {
        return geologicTimePeriodID;
    }

    public void setGeologicTimePeriodID(Integer geologicTimePeriodID) {
        this.geologicTimePeriodID = geologicTimePeriodID;
    }
  
    public Float getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(Float endPeriod) {
        this.endPeriod = endPeriod;
    }

    public Float getEndUncertainty() {
        return endUncertainty;
    }

    public void setEndUncertainty(Float endUncertainty) {
        this.endUncertainty = endUncertainty;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Integer getHighestChildNodeNumber() {
        return highestChildNodeNumber;
    }

    public void setHighestChildNodeNumber(Integer highestChildNodeNumber) {
        this.highestChildNodeNumber = highestChildNodeNumber;
    }

    public Boolean getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(Boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    public Boolean getIsBioStrat() {
        return isBioStrat;
    }

    public void setIsBioStrat(Boolean isBioStrat) {
        this.isBioStrat = isBioStrat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNodeNumber() {
        return nodeNumber;
    }

    public void setNodeNumber(Integer nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    public int getRankID() {
        return rankID;
    }

    public void setRankID(int rankID) {
        this.rankID = rankID;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public Float getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(Float startPeriod) {
        this.startPeriod = startPeriod;
    }

    public Float getStartUncertainty() {
        return startUncertainty;
    }

    public void setStartUncertainty(Float startUncertainty) {
        this.startUncertainty = startUncertainty;
    }

    @XmlTransient
    public List<Paleocontext> getPaleocontextList() {
        return paleocontextList;
    }

    public void setPaleocontextList(List<Paleocontext> paleocontextList) {
        this.paleocontextList = paleocontextList;
    }

    @XmlTransient
    public List<Paleocontext> getPaleocontextList1() {
        return paleocontextList1;
    }

    public void setPaleocontextList1(List<Paleocontext> paleocontextList1) {
        this.paleocontextList1 = paleocontextList1;
    }

    @XmlTransient
    public List<Paleocontext> getPaleocontextList2() {
        return paleocontextList2;
    }

    public void setPaleocontextList2(List<Paleocontext> paleocontextList2) {
        this.paleocontextList2 = paleocontextList2;
    }

    @XmlTransient
    public List<Geologictimeperiod> getGeologictimeperiodList() {
        return geologictimeperiodList;
    }

    public void setGeologictimeperiodList(List<Geologictimeperiod> geologictimeperiodList) {
        this.geologictimeperiodList = geologictimeperiodList;
    }

    @XmlIDREF
    public Geologictimeperiod getAcceptedID() {
        return acceptedID;
    }

    public void setAcceptedID(Geologictimeperiod acceptedID) {
        this.acceptedID = acceptedID;
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
    public Geologictimeperiodtreedef getGeologicTimePeriodTreeDefID() {
        return geologicTimePeriodTreeDefID;
    }

    public void setGeologicTimePeriodTreeDefID(Geologictimeperiodtreedef geologicTimePeriodTreeDefID) {
        this.geologicTimePeriodTreeDefID = geologicTimePeriodTreeDefID;
    }

    @XmlIDREF
    public Geologictimeperiodtreedefitem getGeologicTimePeriodTreeDefItemID() {
        return geologicTimePeriodTreeDefItemID;
    }

    public void setGeologicTimePeriodTreeDefItemID(Geologictimeperiodtreedefitem geologicTimePeriodTreeDefItemID) {
        this.geologicTimePeriodTreeDefItemID = geologicTimePeriodTreeDefItemID;
    }

    @XmlTransient
    public List<Geologictimeperiod> getGeologictimeperiodList1() {
        return geologictimeperiodList1;
    }

    public void setGeologictimeperiodList1(List<Geologictimeperiod> geologictimeperiodList1) {
        this.geologictimeperiodList1 = geologictimeperiodList1;
    }

    @XmlIDREF
    public Geologictimeperiod getParentID() {
        return parentID;
    }

    public void setParentID(Geologictimeperiod parentID) {
        this.parentID = parentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (geologicTimePeriodID != null ? geologicTimePeriodID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Geologictimeperiod)) {
            return false;
        }
        Geologictimeperiod other = (Geologictimeperiod) object;
        return !((this.geologicTimePeriodID == null && other.geologicTimePeriodID != null) || (this.geologicTimePeriodID != null && !this.geologicTimePeriodID.equals(other.geologicTimePeriodID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Geologictimeperiod[ geologicTimePeriodID=" + geologicTimePeriodID + " ]";
    }
    
}
