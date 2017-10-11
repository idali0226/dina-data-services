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
@Table(name = "lithostrattreedefitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lithostrattreedefitem.findAll", query = "SELECT l FROM Lithostrattreedefitem l"),
    @NamedQuery(name = "Lithostrattreedefitem.findByLithoStratTreeDefItemID", query = "SELECT l FROM Lithostrattreedefitem l WHERE l.lithoStratTreeDefItemID = :lithoStratTreeDefItemID"), 
    @NamedQuery(name = "Lithostrattreedefitem.findByFullNameSeparator", query = "SELECT l FROM Lithostrattreedefitem l WHERE l.fullNameSeparator = :fullNameSeparator"),
    @NamedQuery(name = "Lithostrattreedefitem.findByIsEnforced", query = "SELECT l FROM Lithostrattreedefitem l WHERE l.isEnforced = :isEnforced"),
    @NamedQuery(name = "Lithostrattreedefitem.findByIsInFullName", query = "SELECT l FROM Lithostrattreedefitem l WHERE l.isInFullName = :isInFullName"),
    @NamedQuery(name = "Lithostrattreedefitem.findByName", query = "SELECT l FROM Lithostrattreedefitem l WHERE l.name = :name"),
    @NamedQuery(name = "Lithostrattreedefitem.findByRankID", query = "SELECT l FROM Lithostrattreedefitem l WHERE l.rankID = :rankID"), 
    @NamedQuery(name = "Lithostrattreedefitem.findByTitle", query = "SELECT l FROM Lithostrattreedefitem l WHERE l.title = :title")})
public class Lithostrattreedefitem extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LithoStratTreeDefItemID")
    private Integer lithoStratTreeDefItemID;
    
    
    
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
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "LithoStratTreeDefID", referencedColumnName = "LithoStratTreeDefID")
    @ManyToOne(optional = false )
    private Lithostrattreedef lithoStratTreeDefID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @OneToMany(mappedBy = "parentItemID", fetch = FetchType.LAZY)
    private List<Lithostrattreedefitem> lithostrattreedefitemList;
    
    @JoinColumn(name = "ParentItemID", referencedColumnName = "LithoStratTreeDefItemID")
    @ManyToOne
    private Lithostrattreedefitem parentItemID;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lithoStratTreeDefItemID", fetch = FetchType.LAZY)
    private List<Lithostrat> lithostratList;

    public Lithostrattreedefitem() {
    }

    public Lithostrattreedefitem(Integer lithoStratTreeDefItemID) {
        this.lithoStratTreeDefItemID = lithoStratTreeDefItemID;
    }

    public Lithostrattreedefitem(Integer lithoStratTreeDefItemID, Date timestampCreated, String name, int rankID) {
        this.lithoStratTreeDefItemID = lithoStratTreeDefItemID;
        this.timestampCreated = timestampCreated;
        this.name = name;
        this.rankID = rankID;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + lithoStratTreeDefItemID;
    }
    
    @Override
    public int getEntityId() {
        return lithoStratTreeDefItemID;
    }

    public Integer getLithoStratTreeDefItemID() {
        return lithoStratTreeDefItemID;
    }

    public void setLithoStratTreeDefItemID(Integer lithoStratTreeDefItemID) {
        this.lithoStratTreeDefItemID = lithoStratTreeDefItemID;
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

    @XmlIDREF
    public Agent getModifiedByAgentID() {
        return modifiedByAgentID;
    }

    public void setModifiedByAgentID(Agent modifiedByAgentID) {
        this.modifiedByAgentID = modifiedByAgentID;
    }

    @XmlIDREF
    public Lithostrattreedef getLithoStratTreeDefID() {
        return lithoStratTreeDefID;
    }

    public void setLithoStratTreeDefID(Lithostrattreedef lithoStratTreeDefID) {
        this.lithoStratTreeDefID = lithoStratTreeDefID;
    }

    @XmlIDREF
    public Agent getCreatedByAgentID() {
        return createdByAgentID;
    }

    public void setCreatedByAgentID(Agent createdByAgentID) {
        this.createdByAgentID = createdByAgentID;
    }

    @XmlTransient
    public List<Lithostrattreedefitem> getLithostrattreedefitemList() {
        return lithostrattreedefitemList;
    }

    public void setLithostrattreedefitemList(List<Lithostrattreedefitem> lithostrattreedefitemList) {
        this.lithostrattreedefitemList = lithostrattreedefitemList;
    }

    @XmlIDREF
    public Lithostrattreedefitem getParentItemID() {
        return parentItemID;
    }

    public void setParentItemID(Lithostrattreedefitem parentItemID) {
        this.parentItemID = parentItemID;
    }

    @XmlTransient
    public List<Lithostrat> getLithostratList() {
        return lithostratList;
    }

    public void setLithostratList(List<Lithostrat> lithostratList) {
        this.lithostratList = lithostratList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lithoStratTreeDefItemID != null ? lithoStratTreeDefItemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lithostrattreedefitem)) {
            return false;
        }
        Lithostrattreedefitem other = (Lithostrattreedefitem) object;
        return !((this.lithoStratTreeDefItemID == null && other.lithoStratTreeDefItemID != null) || (this.lithoStratTreeDefItemID != null && !this.lithoStratTreeDefItemID.equals(other.lithoStratTreeDefItemID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Lithostrattreedefitem[ lithoStratTreeDefItemID=" + lithoStratTreeDefItemID + " ]";
    }
    
}
