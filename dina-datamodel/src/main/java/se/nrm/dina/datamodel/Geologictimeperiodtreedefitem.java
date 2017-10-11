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
@Table(name = "geologictimeperiodtreedefitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Geologictimeperiodtreedefitem.findAll", query = "SELECT g FROM Geologictimeperiodtreedefitem g"),
    @NamedQuery(name = "Geologictimeperiodtreedefitem.findByGeologicTimePeriodTreeDefItemID", query = "SELECT g FROM Geologictimeperiodtreedefitem g WHERE g.geologicTimePeriodTreeDefItemID = :geologicTimePeriodTreeDefItemID"), 
    @NamedQuery(name = "Geologictimeperiodtreedefitem.findByFullNameSeparator", query = "SELECT g FROM Geologictimeperiodtreedefitem g WHERE g.fullNameSeparator = :fullNameSeparator"),
    @NamedQuery(name = "Geologictimeperiodtreedefitem.findByIsEnforced", query = "SELECT g FROM Geologictimeperiodtreedefitem g WHERE g.isEnforced = :isEnforced"),
    @NamedQuery(name = "Geologictimeperiodtreedefitem.findByIsInFullName", query = "SELECT g FROM Geologictimeperiodtreedefitem g WHERE g.isInFullName = :isInFullName"),
    @NamedQuery(name = "Geologictimeperiodtreedefitem.findByName", query = "SELECT g FROM Geologictimeperiodtreedefitem g WHERE g.name = :name"), 
    @NamedQuery(name = "Geologictimeperiodtreedefitem.findByTitle", query = "SELECT g FROM Geologictimeperiodtreedefitem g WHERE g.title = :title")})
public class Geologictimeperiodtreedefitem extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GeologicTimePeriodTreeDefItemID")
    private Integer geologicTimePeriodTreeDefItemID;
    
    
    @Size(max = 32)
    @Column(name = "FullNameSeparator")
    private String fullNameSeparator;
    
    @Column(name = "IsEnforced")
    private Boolean isEnforced;
    
    @Column(name = "IsInFullName")
    private Boolean isInFullName;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "Name")
    private String name;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "RankID")
    private int rankID;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Size(max = 64)
    @Column(name = "TextAfter")
    private String textAfter;
    
    @Size(max = 64)
    @Column(name = "TextBefore")
    private String textBefore;
    
    @Size(max = 64)
    @Column(name = "Title")
    private String title;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "geologicTimePeriodTreeDefItemID", fetch = FetchType.LAZY)
    private List<Geologictimeperiod> geologictimeperiodList;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @OneToMany(mappedBy = "parentItemID", fetch = FetchType.LAZY)
    private List<Geologictimeperiodtreedefitem> geologictimeperiodtreedefitemList;
    
    @JoinColumn(name = "ParentItemID", referencedColumnName = "GeologicTimePeriodTreeDefItemID")
    @ManyToOne
    private Geologictimeperiodtreedefitem parentItemID;
    
    @JoinColumn(name = "GeologicTimePeriodTreeDefID", referencedColumnName = "GeologicTimePeriodTreeDefID")
    @ManyToOne(optional = false)
    private Geologictimeperiodtreedef geologicTimePeriodTreeDefID;

    public Geologictimeperiodtreedefitem() {
    }

    public Geologictimeperiodtreedefitem(Integer geologicTimePeriodTreeDefItemID) {
        this.geologicTimePeriodTreeDefItemID = geologicTimePeriodTreeDefItemID;
    }

    public Geologictimeperiodtreedefitem(Integer geologicTimePeriodTreeDefItemID, Date timestampCreated, String name, int rankID) {
        this.geologicTimePeriodTreeDefItemID = geologicTimePeriodTreeDefItemID;
        this.timestampCreated = timestampCreated;
        this.name = name;
        this.rankID = rankID;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + geologicTimePeriodTreeDefItemID;
    }
    
    @Override
    public int getEntityId() {
        return geologicTimePeriodTreeDefItemID;
    }

    public Integer getGeologicTimePeriodTreeDefItemID() {
        return geologicTimePeriodTreeDefItemID;
    }

    public void setGeologicTimePeriodTreeDefItemID(Integer geologicTimePeriodTreeDefItemID) {
        this.geologicTimePeriodTreeDefItemID = geologicTimePeriodTreeDefItemID;
    }

    

    public String getFullNameSeparator() {
        return fullNameSeparator;
    }

    public void setFullNameSeparator(String fullNameSeparator) {
        this.fullNameSeparator = fullNameSeparator;
    }

    public Boolean getIsEnforced() {
        return isEnforced;
    }

    public void setIsEnforced(Boolean isEnforced) {
        this.isEnforced = isEnforced;
    }

    public Boolean getIsInFullName() {
        return isInFullName;
    }

    public void setIsInFullName(Boolean isInFullName) {
        this.isInFullName = isInFullName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getTextAfter() {
        return textAfter;
    }

    public void setTextAfter(String textAfter) {
        this.textAfter = textAfter;
    }

    public String getTextBefore() {
        return textBefore;
    }

    public void setTextBefore(String textBefore) {
        this.textBefore = textBefore;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlTransient
    public List<Geologictimeperiod> getGeologictimeperiodList() {
        return geologictimeperiodList;
    }

    public void setGeologictimeperiodList(List<Geologictimeperiod> geologictimeperiodList) {
        this.geologictimeperiodList = geologictimeperiodList;
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
    public List<Geologictimeperiodtreedefitem> getGeologictimeperiodtreedefitemList() {
        return geologictimeperiodtreedefitemList;
    }

    public void setGeologictimeperiodtreedefitemList(List<Geologictimeperiodtreedefitem> geologictimeperiodtreedefitemList) {
        this.geologictimeperiodtreedefitemList = geologictimeperiodtreedefitemList;
    }

    @XmlIDREF
    public Geologictimeperiodtreedefitem getParentItemID() {
        return parentItemID;
    }

    public void setParentItemID(Geologictimeperiodtreedefitem parentItemID) {
        this.parentItemID = parentItemID;
    }

    @XmlIDREF
    public Geologictimeperiodtreedef getGeologicTimePeriodTreeDefID() {
        return geologicTimePeriodTreeDefID;
    }

    public void setGeologicTimePeriodTreeDefID(Geologictimeperiodtreedef geologicTimePeriodTreeDefID) {
        this.geologicTimePeriodTreeDefID = geologicTimePeriodTreeDefID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (geologicTimePeriodTreeDefItemID != null ? geologicTimePeriodTreeDefItemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Geologictimeperiodtreedefitem)) {
            return false;
        }
        Geologictimeperiodtreedefitem other = (Geologictimeperiodtreedefitem) object;
        return !((this.geologicTimePeriodTreeDefItemID == null && other.geologicTimePeriodTreeDefItemID != null) || (this.geologicTimePeriodTreeDefItemID != null && !this.geologicTimePeriodTreeDefItemID.equals(other.geologicTimePeriodTreeDefItemID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Geologictimeperiodtreedefitem[ geologicTimePeriodTreeDefItemID=" + geologicTimePeriodTreeDefItemID + " ]";
    }
    
}
