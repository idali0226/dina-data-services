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
@Table(name = "geographytreedefitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Geographytreedefitem.findAll", query = "SELECT g FROM Geographytreedefitem g"),
    @NamedQuery(name = "Geographytreedefitem.findByGeographyTreeDefItemID", query = "SELECT g FROM Geographytreedefitem g WHERE g.geographyTreeDefItemID = :geographyTreeDefItemID"), 
    @NamedQuery(name = "Geographytreedefitem.findByFullNameSeparator", query = "SELECT g FROM Geographytreedefitem g WHERE g.fullNameSeparator = :fullNameSeparator"),
    @NamedQuery(name = "Geographytreedefitem.findByIsEnforced", query = "SELECT g FROM Geographytreedefitem g WHERE g.isEnforced = :isEnforced"),
    @NamedQuery(name = "Geographytreedefitem.findByIsInFullName", query = "SELECT g FROM Geographytreedefitem g WHERE g.isInFullName = :isInFullName"),
    @NamedQuery(name = "Geographytreedefitem.findByName", query = "SELECT g FROM Geographytreedefitem g WHERE g.name = :name"),
    @NamedQuery(name = "Geographytreedefitem.findByRankID", query = "SELECT g FROM Geographytreedefitem g WHERE g.rankID = :rankID"), 
    @NamedQuery(name = "Geographytreedefitem.findByTitle", query = "SELECT g FROM Geographytreedefitem g WHERE g.title = :title")})
public class Geographytreedefitem extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GeographyTreeDefItemID")
    private Integer geographyTreeDefItemID;
    
    
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "geographyTreeDefItemID", fetch = FetchType.LAZY)
    private List<Geography> geographyList;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @OneToMany(mappedBy = "parentItemID", fetch = FetchType.LAZY)
    private List<Geographytreedefitem> geographytreedefitemList;
    
    @JoinColumn(name = "ParentItemID", referencedColumnName = "GeographyTreeDefItemID")
    @ManyToOne
    private Geographytreedefitem parentItemID;
    
    @JoinColumn(name = "GeographyTreeDefID", referencedColumnName = "GeographyTreeDefID")
    @ManyToOne(optional = false)
    private Geographytreedef geographyTreeDefID;

    public Geographytreedefitem() {
    }

    public Geographytreedefitem(Integer geographyTreeDefItemID) {
        this.geographyTreeDefItemID = geographyTreeDefItemID;
    }

    public Geographytreedefitem(Integer geographyTreeDefItemID, Date timestampCreated, String name, int rankID) {
        this.geographyTreeDefItemID = geographyTreeDefItemID;
        this.timestampCreated = timestampCreated;
        this.name = name;
        this.rankID = rankID;
    }

    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + geographyTreeDefItemID;
    }
    
    @Override
    public int getEntityId() {
        return geographyTreeDefItemID;
    }
    
    public Integer getGeographyTreeDefItemID() {
        return geographyTreeDefItemID;
    }

    public void setGeographyTreeDefItemID(Integer geographyTreeDefItemID) {
        this.geographyTreeDefItemID = geographyTreeDefItemID;
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
    public List<Geography> getGeographyList() {
        return geographyList;
    }

    public void setGeographyList(List<Geography> geographyList) {
        this.geographyList = geographyList;
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
    public List<Geographytreedefitem> getGeographytreedefitemList() {
        return geographytreedefitemList;
    }

    public void setGeographytreedefitemList(List<Geographytreedefitem> geographytreedefitemList) {
        this.geographytreedefitemList = geographytreedefitemList;
    }

    @XmlIDREF
    public Geographytreedefitem getParentItemID() {
        return parentItemID;
    }

    public void setParentItemID(Geographytreedefitem parentItemID) {
        this.parentItemID = parentItemID;
    }

    @XmlIDREF
    public Geographytreedef getGeographyTreeDefID() {
        return geographyTreeDefID;
    }

    public void setGeographyTreeDefID(Geographytreedef geographyTreeDefID) {
        this.geographyTreeDefID = geographyTreeDefID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (geographyTreeDefItemID != null ? geographyTreeDefItemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Geographytreedefitem)) {
            return false;
        }
        Geographytreedefitem other = (Geographytreedefitem) object;
        return !((this.geographyTreeDefItemID == null && other.geographyTreeDefItemID != null) || (this.geographyTreeDefItemID != null && !this.geographyTreeDefItemID.equals(other.geographyTreeDefItemID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Geographytreedefitem[ geographyTreeDefItemID=" + geographyTreeDefItemID + " ]";
    }
    
}
