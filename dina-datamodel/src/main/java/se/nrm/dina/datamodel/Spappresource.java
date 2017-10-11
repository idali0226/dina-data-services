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
@Table(name = "spappresource")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spappresource.findAll", query = "SELECT s FROM Spappresource s"),
    @NamedQuery(name = "Spappresource.findBySpAppResourceID", query = "SELECT s FROM Spappresource s WHERE s.spAppResourceID = :spAppResourceID"), 
    @NamedQuery(name = "Spappresource.findByAllPermissionLevel", query = "SELECT s FROM Spappresource s WHERE s.allPermissionLevel = :allPermissionLevel"),
    @NamedQuery(name = "Spappresource.findByDescription", query = "SELECT s FROM Spappresource s WHERE s.description = :description"),
    @NamedQuery(name = "Spappresource.findByGroupPermissionLevel", query = "SELECT s FROM Spappresource s WHERE s.groupPermissionLevel = :groupPermissionLevel"),
    @NamedQuery(name = "Spappresource.findByLevel", query = "SELECT s FROM Spappresource s WHERE s.level = :level"),
    @NamedQuery(name = "Spappresource.findByMetaData", query = "SELECT s FROM Spappresource s WHERE s.metaData = :metaData"),
    @NamedQuery(name = "Spappresource.findByMimeType", query = "SELECT s FROM Spappresource s WHERE s.mimeType = :mimeType"),
    @NamedQuery(name = "Spappresource.findByName", query = "SELECT s FROM Spappresource s WHERE s.name = :name"),
    @NamedQuery(name = "Spappresource.findByOwnerPermissionLevel", query = "SELECT s FROM Spappresource s WHERE s.ownerPermissionLevel = :ownerPermissionLevel")})
public class Spappresource extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SpAppResourceID")
    private Integer spAppResourceID;
    
    
    @Column(name = "AllPermissionLevel")
    private Integer allPermissionLevel;
    
    @Size(max = 255)
    @Column(name = "Description")
    private String description;
    
    @Column(name = "GroupPermissionLevel")
    private Integer groupPermissionLevel;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Level")
    private short level;
    
    @Size(max = 255)
    @Column(name = "MetaData")
    private String metaData;
    
    @Size(max = 255)
    @Column(name = "MimeType")
    private String mimeType;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "Name")
    private String name;
    
    @Column(name = "OwnerPermissionLevel")
    private Integer ownerPermissionLevel;
    
    @JoinColumn(name = "SpAppResourceDirID", referencedColumnName = "SpAppResourceDirID")
    @ManyToOne(optional = false)
    private Spappresourcedir spAppResourceDirID;
    
    @JoinColumn(name = "SpecifyUserID", referencedColumnName = "SpecifyUserID")
    @ManyToOne(optional = false)
    private Specifyuser specifyUserID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "SpPrincipalID", referencedColumnName = "SpPrincipalID")
    @ManyToOne
    private Spprincipal spPrincipalID;
    
    @OneToMany(mappedBy = "spAppResourceID", fetch = FetchType.LAZY)
    private List<Spappresourcedata> spappresourcedataList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appResourceID", fetch = FetchType.LAZY)
    private List<Spreport> spreportList;

    public Spappresource() {
    }

    public Spappresource(Integer spAppResourceID) {
        this.spAppResourceID = spAppResourceID;
    }

    public Spappresource(Integer spAppResourceID, Date timestampCreated, short level, String name) {
        this.spAppResourceID = spAppResourceID;
        this.timestampCreated = timestampCreated;
        this.level = level;
        this.name = name;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + spAppResourceID;
    }
    
    @Override
    public int getEntityId() {
        return spAppResourceID;
    }
    
    public Integer getSpAppResourceID() {
        return spAppResourceID;
    }

    public void setSpAppResourceID(Integer spAppResourceID) {
        this.spAppResourceID = spAppResourceID;
    }
 

    public Integer getAllPermissionLevel() {
        return allPermissionLevel;
    }

    public void setAllPermissionLevel(Integer allPermissionLevel) {
        this.allPermissionLevel = allPermissionLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getGroupPermissionLevel() {
        return groupPermissionLevel;
    }

    public void setGroupPermissionLevel(Integer groupPermissionLevel) {
        this.groupPermissionLevel = groupPermissionLevel;
    }

    public short getLevel() {
        return level;
    }

    public void setLevel(short level) {
        this.level = level;
    }

    public String getMetaData() {
        return metaData;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOwnerPermissionLevel() {
        return ownerPermissionLevel;
    }

    public void setOwnerPermissionLevel(Integer ownerPermissionLevel) {
        this.ownerPermissionLevel = ownerPermissionLevel;
    }

    @XmlIDREF
    public Spappresourcedir getSpAppResourceDirID() {
        return spAppResourceDirID;
    }

    public void setSpAppResourceDirID(Spappresourcedir spAppResourceDirID) {
        this.spAppResourceDirID = spAppResourceDirID;
    }

    @XmlIDREF
    public Specifyuser getSpecifyUserID() {
        return specifyUserID;
    }

    public void setSpecifyUserID(Specifyuser specifyUserID) {
        this.specifyUserID = specifyUserID;
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
    public Spprincipal getSpPrincipalID() {
        return spPrincipalID;
    }

    public void setSpPrincipalID(Spprincipal spPrincipalID) {
        this.spPrincipalID = spPrincipalID;
    }

    @XmlTransient
    public List<Spappresourcedata> getSpappresourcedataList() {
        return spappresourcedataList;
    }

    public void setSpappresourcedataList(List<Spappresourcedata> spappresourcedataList) {
        this.spappresourcedataList = spappresourcedataList;
    }

    @XmlTransient
    public List<Spreport> getSpreportList() {
        return spreportList;
    }

    public void setSpreportList(List<Spreport> spreportList) {
        this.spreportList = spreportList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (spAppResourceID != null ? spAppResourceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spappresource)) {
            return false;
        }
        Spappresource other = (Spappresource) object;
        return !((this.spAppResourceID == null && other.spAppResourceID != null) || (this.spAppResourceID != null && !this.spAppResourceID.equals(other.spAppResourceID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Spappresource[ spAppResourceID=" + spAppResourceID + " ]";
    }
    
}
