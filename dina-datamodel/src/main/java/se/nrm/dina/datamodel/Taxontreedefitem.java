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
@Table(name = "taxontreedefitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taxontreedefitem.findAll", query = "SELECT t FROM Taxontreedefitem t"),
    @NamedQuery(name = "Taxontreedefitem.findByTaxonTreeDefItemID", query = "SELECT t FROM Taxontreedefitem t WHERE t.taxonTreeDefItemID = :taxonTreeDefItemID"), 
    @NamedQuery(name = "Taxontreedefitem.findByFormatToken", query = "SELECT t FROM Taxontreedefitem t WHERE t.formatToken = :formatToken"),
    @NamedQuery(name = "Taxontreedefitem.findByFullNameSeparator", query = "SELECT t FROM Taxontreedefitem t WHERE t.fullNameSeparator = :fullNameSeparator"),
    @NamedQuery(name = "Taxontreedefitem.findByIsEnforced", query = "SELECT t FROM Taxontreedefitem t WHERE t.isEnforced = :isEnforced"),
    @NamedQuery(name = "Taxontreedefitem.findByIsInFullName", query = "SELECT t FROM Taxontreedefitem t WHERE t.isInFullName = :isInFullName"),
    @NamedQuery(name = "Taxontreedefitem.findByName", query = "SELECT t FROM Taxontreedefitem t WHERE t.name = :name"),
    @NamedQuery(name = "Taxontreedefitem.findByRankID", query = "SELECT t FROM Taxontreedefitem t WHERE t.rankID = :rankID"), 
    @NamedQuery(name = "Taxontreedefitem.findByTitle", query = "SELECT t FROM Taxontreedefitem t WHERE t.title = :title")})
public class Taxontreedefitem extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TaxonTreeDefItemID")
    private Integer taxonTreeDefItemID;
    
    
    @Size(max = 32)
    @Column(name = "FormatToken")
    private String formatToken;
    
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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taxonTreeDefItemID", fetch = FetchType.LAZY)
    private List<Taxon> taxonList;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @OneToMany(mappedBy = "parentItemID", fetch = FetchType.LAZY)
    private List<Taxontreedefitem> taxontreedefitemList;
    
    @JoinColumn(name = "ParentItemID", referencedColumnName = "TaxonTreeDefItemID")
    @ManyToOne
    private Taxontreedefitem parentItemID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "TaxonTreeDefID", referencedColumnName = "TaxonTreeDefID")
    @ManyToOne(optional = false)
    private Taxontreedef taxonTreeDefID;

    public Taxontreedefitem() {
    }

    public Taxontreedefitem(Integer taxonTreeDefItemID) {
        this.taxonTreeDefItemID = taxonTreeDefItemID;
    }

    public Taxontreedefitem(Integer taxonTreeDefItemID, Date timestampCreated, String name, int rankID) {
        this.taxonTreeDefItemID = taxonTreeDefItemID;
        this.timestampCreated = timestampCreated;
        this.name = name;
        this.rankID = rankID;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + taxonTreeDefItemID;
    }
    
    @Override
    public int getEntityId() {
        return taxonTreeDefItemID;
    }

    public Integer getTaxonTreeDefItemID() {
        return taxonTreeDefItemID;
    }

    public void setTaxonTreeDefItemID(Integer taxonTreeDefItemID) {
        this.taxonTreeDefItemID = taxonTreeDefItemID;
    }
  

    public String getFormatToken() {
        return formatToken;
    }

    public void setFormatToken(String formatToken) {
        this.formatToken = formatToken;
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
    public List<Taxon> getTaxonList() {
        return taxonList;
    }

    public void setTaxonList(List<Taxon> taxonList) {
        this.taxonList = taxonList;
    }

    @XmlIDREF
    public Agent getModifiedByAgentID() {
        return modifiedByAgentID;
    }

    public void setModifiedByAgentID(Agent modifiedByAgentID) {
        this.modifiedByAgentID = modifiedByAgentID;
    }

    @XmlTransient
    public List<Taxontreedefitem> getTaxontreedefitemList() {
        return taxontreedefitemList;
    }

    public void setTaxontreedefitemList(List<Taxontreedefitem> taxontreedefitemList) {
        this.taxontreedefitemList = taxontreedefitemList;
    }

    @XmlIDREF
    public Taxontreedefitem getParentItemID() {
        return parentItemID;
    }

    public void setParentItemID(Taxontreedefitem parentItemID) {
        this.parentItemID = parentItemID;
    }

    @XmlIDREF
    public Agent getCreatedByAgentID() {
        return createdByAgentID;
    }

    public void setCreatedByAgentID(Agent createdByAgentID) {
        this.createdByAgentID = createdByAgentID;
    }

    @XmlIDREF
    public Taxontreedef getTaxonTreeDefID() {
        return taxonTreeDefID;
    }

    public void setTaxonTreeDefID(Taxontreedef taxonTreeDefID) {
        this.taxonTreeDefID = taxonTreeDefID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxonTreeDefItemID != null ? taxonTreeDefItemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taxontreedefitem)) {
            return false;
        }
        Taxontreedefitem other = (Taxontreedefitem) object;
        return !((this.taxonTreeDefItemID == null && other.taxonTreeDefItemID != null) || (this.taxonTreeDefItemID != null && !this.taxonTreeDefItemID.equals(other.taxonTreeDefItemID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Taxontreedefitem[ taxonTreeDefItemID=" + taxonTreeDefItemID + " ]";
    }
    
}
