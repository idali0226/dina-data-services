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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "autonumberingscheme")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autonumberingscheme.findAll", query = "SELECT a FROM Autonumberingscheme a"),
    @NamedQuery(name = "Autonumberingscheme.findByAutoNumberingSchemeID", query = "SELECT a FROM Autonumberingscheme a WHERE a.autoNumberingSchemeID = :autoNumberingSchemeID"), 
    @NamedQuery(name = "Autonumberingscheme.findByFormatName", query = "SELECT a FROM Autonumberingscheme a WHERE a.formatName = :formatName"),  
    @NamedQuery(name = "Autonumberingscheme.findBySchemeName", query = "SELECT a FROM Autonumberingscheme a WHERE a.schemeName = :schemeName"),
    @NamedQuery(name = "Autonumberingscheme.findByTableNumber", query = "SELECT a FROM Autonumberingscheme a WHERE a.tableNumber = :tableNumber")})
public class Autonumberingscheme extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AutoNumberingSchemeID")
    private Integer autoNumberingSchemeID;
    
    
    @Size(max = 64)
    @Column(name = "FormatName")
    private String formatName;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsNumericOnly")
    private boolean isNumericOnly;
    
    @Size(max = 64)
    @Column(name = "SchemeClassName")
    private String schemeClassName;
    
    @Size(max = 64)
    @Column(name = "SchemeName")
    private String schemeName;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "TableNumber")
    private int tableNumber;
    
    @ManyToMany(mappedBy = "autonumberingschemeList", fetch = FetchType.LAZY)
    private List<Division> divisionList;
    
    @ManyToMany(mappedBy = "autonumberingschemeList", fetch = FetchType.LAZY)
    private List<Discipline> disciplineList;
    
    @ManyToMany(mappedBy = "autonumberingschemeList", fetch = FetchType.LAZY)
    private List<Collection> collectionList;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;

    public Autonumberingscheme() {
    }

    public Autonumberingscheme(Integer autoNumberingSchemeID) {
        this.autoNumberingSchemeID = autoNumberingSchemeID;
    }

    public Autonumberingscheme(Integer autoNumberingSchemeID, Date timestampCreated, boolean isNumericOnly, int tableNumber) {
        this.autoNumberingSchemeID = autoNumberingSchemeID;
        this.timestampCreated = timestampCreated;
        this.isNumericOnly = isNumericOnly;
        this.tableNumber = tableNumber;
    }
    
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + autoNumberingSchemeID;
    }
    
    @Override
    public int getEntityId() {
        return autoNumberingSchemeID;
    }
    

    public Integer getAutoNumberingSchemeID() {
        return autoNumberingSchemeID;
    }

    public void setAutoNumberingSchemeID(Integer autoNumberingSchemeID) {
        this.autoNumberingSchemeID = autoNumberingSchemeID;
    }
 

    public String getFormatName() {
        return formatName;
    }

    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }

    public boolean getIsNumericOnly() {
        return isNumericOnly;
    }

    public void setIsNumericOnly(boolean isNumericOnly) {
        this.isNumericOnly = isNumericOnly;
    }

    public String getSchemeClassName() {
        return schemeClassName;
    }

    public void setSchemeClassName(String schemeClassName) {
        this.schemeClassName = schemeClassName;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    @XmlTransient
    public List<Division> getDivisionList() {
        return divisionList;
    }

    public void setDivisionList(List<Division> divisionList) {
        this.divisionList = divisionList;
    }

    @XmlTransient
    public List<Discipline> getDisciplineList() {
        return disciplineList;
    }

    public void setDisciplineList(List<Discipline> disciplineList) {
        this.disciplineList = disciplineList;
    }

    @XmlTransient
    public List<Collection> getCollectionList() {
        return collectionList;
    }

    public void setCollectionList(List<Collection> collectionList) {
        this.collectionList = collectionList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (autoNumberingSchemeID != null ? autoNumberingSchemeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autonumberingscheme)) {
            return false;
        }
        Autonumberingscheme other = (Autonumberingscheme) object;
        return !((this.autoNumberingSchemeID == null && other.autoNumberingSchemeID != null) || (this.autoNumberingSchemeID != null && !this.autoNumberingSchemeID.equals(other.autoNumberingSchemeID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Autonumberingscheme[ autoNumberingSchemeID=" + autoNumberingSchemeID + " ]";
    }
    
}
