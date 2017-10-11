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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "collection")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Collection.findAll", query = "SELECT c FROM Collection c"),
    @NamedQuery(name = "Collection.findByUserGroupScopeId", query = "SELECT c FROM Collection c WHERE c.userGroupScopeId = :userGroupScopeId"), 
    @NamedQuery(name = "Collection.findByCode", query = "SELECT c FROM Collection c WHERE c.code = :code"),
    @NamedQuery(name = "Collection.findByCollectionId", query = "SELECT c FROM Collection c WHERE c.collectionId = :collectionId"),
    @NamedQuery(name = "Collection.findByCollectionName", query = "SELECT c FROM Collection c WHERE c.collectionName = :collectionName"),
    @NamedQuery(name = "Collection.findByCollectionType", query = "SELECT c FROM Collection c WHERE c.collectionType = :collectionType"), 
    @NamedQuery(name = "Collection.findByGuid", query = "SELECT c FROM Collection c WHERE c.guid = :guid") })
public class Collection extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "UserGroupScopeId")
    private Integer userGroupScopeId;
    
    
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "CatalogFormatNumName")
    private String catalogFormatNumName;
    
    @Size(max = 50)
    @Column(name = "Code")
    private String code;
    
    @Column(name = "collectionId")
    private Integer collectionId;
    
    @Size(max = 50)
    @Column(name = "CollectionName")
    private String collectionName;
    
    @Size(max = 32)
    @Column(name = "CollectionType")
    private String collectionType;
    
    @Size(max = 32)
    @Column(name = "DbContentVersion")
    private String dbContentVersion;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Description")
    private String description;
    
    @Size(max = 32)
    @Column(name = "DevelopmentStatus")
    private String developmentStatus;
    
    @Column(name = "EstimatedSize")
    private Integer estimatedSize;
    
    @Size(max = 128)
    @Column(name = "GUID")
    private String guid;
    
    @Size(max = 32)
    @Column(name = "InstitutionType")
    private String institutionType;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsEmbeddedCollectingEvent")
    private boolean isEmbeddedCollectingEvent;
    
    @Size(max = 24)
    @Column(name = "IsaNumber")
    private String isaNumber;
    
    @Size(max = 32)
    @Column(name = "KingdomCoverage")
    private String kingdomCoverage;
    
    @Size(max = 32)
    @Column(name = "PreservationMethodType")
    private String preservationMethodType;
    
    @Size(max = 32)
    @Column(name = "PrimaryFocus")
    private String primaryFocus;
    
    @Size(max = 32)
    @Column(name = "PrimaryPurpose")
    private String primaryPurpose;
    
    @Size(max = 24)
    @Column(name = "RegNumber")
    private String regNumber;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Scope")
    private String scope;
    
    @Size(max = 255)
    @Column(name = "WebPortalURI")
    private String webPortalURI;
    
    @Size(max = 255)
    @Column(name = "WebSiteURI")
    private String webSiteURI;
    
    @JoinTable(name = "autonumsch_coll", joinColumns = {
        @JoinColumn(name = "CollectionID", referencedColumnName = "UserGroupScopeId")}, inverseJoinColumns = {
        @JoinColumn(name = "AutoNumberingSchemeID", referencedColumnName = "AutoNumberingSchemeID")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Autonumberingscheme> autonumberingschemeList;
    
    @OneToMany(mappedBy = "collectionID", fetch = FetchType.LAZY)
    private List<Sptasksemaphore> sptasksemaphoreList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "collectionID", fetch = FetchType.LAZY)
    private List<Preptype> preptypeList;
    
    @OneToMany(mappedBy = "leftSideCollectionID", fetch = FetchType.LAZY)
    private List<Collectionreltype> collectionreltypeList;
    
    @OneToMany(mappedBy = "rightSideCollectionID", fetch = FetchType.LAZY)
    private List<Collectionreltype> collectionreltypeList1;
    
    @OneToMany(mappedBy = "collectionCCID", fetch = FetchType.LAZY)
    private List<Agent> agentList;
    
    @OneToMany(mappedBy = "collectionTCID", fetch = FetchType.LAZY)
    private List<Agent> agentList1;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "collectionID", fetch = FetchType.LAZY)
    private List<Collectionobject> collectionobjectList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "collectionID", fetch = FetchType.LAZY)
    private List<Fieldnotebook> fieldnotebookList;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne 
    private Agent createdByAgentID;
    
    @JoinColumn(name = "DisciplineID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne(optional = false)
    private Discipline disciplineID;
    
    @JoinColumn(name = "InstitutionNetworkID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne
    private Institution institutionNetworkID;
    
    @OneToMany(mappedBy = "collectionID", fetch = FetchType.LAZY)
    private List<Spappresourcedir> spappresourcedirList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "collectionID", fetch = FetchType.LAZY)
    private List<Picklist> picklistList;

    public Collection() {
    }

    public Collection(Integer userGroupScopeId) {
        this.userGroupScopeId = userGroupScopeId;
    }

    public Collection(Integer userGroupScopeId, Date timestampCreated, String catalogFormatNumName, boolean isEmbeddedCollectingEvent) {
        this.userGroupScopeId = userGroupScopeId;
        this.timestampCreated = timestampCreated;
        this.catalogFormatNumName = catalogFormatNumName;
        this.isEmbeddedCollectingEvent = isEmbeddedCollectingEvent;
    }
    
    @XmlID
    @XmlAttribute(name = "uuid")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + userGroupScopeId;
    }
  
    @Override
    public int getEntityId() {
        return userGroupScopeId;
    }

    public Integer getUserGroupScopeId() {
        return userGroupScopeId;
    }

    public void setUserGroupScopeId(Integer userGroupScopeId) {
        this.userGroupScopeId = userGroupScopeId;
    }
 

    public String getCatalogFormatNumName() {
        return catalogFormatNumName;
    }

    public void setCatalogFormatNumName(String catalogFormatNumName) {
        this.catalogFormatNumName = catalogFormatNumName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionType() {
        return collectionType;
    }

    public void setCollectionType(String collectionType) {
        this.collectionType = collectionType;
    }

    public String getDbContentVersion() {
        return dbContentVersion;
    }

    public void setDbContentVersion(String dbContentVersion) {
        this.dbContentVersion = dbContentVersion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDevelopmentStatus() {
        return developmentStatus;
    }

    public void setDevelopmentStatus(String developmentStatus) {
        this.developmentStatus = developmentStatus;
    }

    public Integer getEstimatedSize() {
        return estimatedSize;
    }

    public void setEstimatedSize(Integer estimatedSize) {
        this.estimatedSize = estimatedSize;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getInstitutionType() {
        return institutionType;
    }

    public void setInstitutionType(String institutionType) {
        this.institutionType = institutionType;
    }

    public boolean getIsEmbeddedCollectingEvent() {
        return isEmbeddedCollectingEvent;
    }

    public void setIsEmbeddedCollectingEvent(boolean isEmbeddedCollectingEvent) {
        this.isEmbeddedCollectingEvent = isEmbeddedCollectingEvent;
    }

    public String getIsaNumber() {
        return isaNumber;
    }

    public void setIsaNumber(String isaNumber) {
        this.isaNumber = isaNumber;
    }

    public String getKingdomCoverage() {
        return kingdomCoverage;
    }

    public void setKingdomCoverage(String kingdomCoverage) {
        this.kingdomCoverage = kingdomCoverage;
    }

    public String getPreservationMethodType() {
        return preservationMethodType;
    }

    public void setPreservationMethodType(String preservationMethodType) {
        this.preservationMethodType = preservationMethodType;
    }

    public String getPrimaryFocus() {
        return primaryFocus;
    }

    public void setPrimaryFocus(String primaryFocus) {
        this.primaryFocus = primaryFocus;
    }

    public String getPrimaryPurpose() {
        return primaryPurpose;
    }

    public void setPrimaryPurpose(String primaryPurpose) {
        this.primaryPurpose = primaryPurpose;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getWebPortalURI() {
        return webPortalURI;
    }

    public void setWebPortalURI(String webPortalURI) {
        this.webPortalURI = webPortalURI;
    }

    public String getWebSiteURI() {
        return webSiteURI;
    }

    public void setWebSiteURI(String webSiteURI) {
        this.webSiteURI = webSiteURI;
    }

    @XmlTransient
    public List<Autonumberingscheme> getAutonumberingschemeList() {
        return autonumberingschemeList;
    }

    public void setAutonumberingschemeList(List<Autonumberingscheme> autonumberingschemeList) {
        this.autonumberingschemeList = autonumberingschemeList;
    }

    @XmlTransient
    public List<Sptasksemaphore> getSptasksemaphoreList() {
        return sptasksemaphoreList;
    }

    public void setSptasksemaphoreList(List<Sptasksemaphore> sptasksemaphoreList) {
        this.sptasksemaphoreList = sptasksemaphoreList;
    }

    @XmlTransient
    public List<Preptype> getPreptypeList() {
        return preptypeList;
    }

    public void setPreptypeList(List<Preptype> preptypeList) {
        this.preptypeList = preptypeList;
    }

    @XmlTransient
    public List<Collectionreltype> getCollectionreltypeList() {
        return collectionreltypeList;
    }

    public void setCollectionreltypeList(List<Collectionreltype> collectionreltypeList) {
        this.collectionreltypeList = collectionreltypeList;
    }

    @XmlTransient
    public List<Collectionreltype> getCollectionreltypeList1() {
        return collectionreltypeList1;
    }

    public void setCollectionreltypeList1(List<Collectionreltype> collectionreltypeList1) {
        this.collectionreltypeList1 = collectionreltypeList1;
    }

    @XmlTransient
    public List<Agent> getAgentList() {
        return agentList;
    }

    public void setAgentList(List<Agent> agentList) {
        this.agentList = agentList;
    }

    @XmlTransient
    public List<Agent> getAgentList1() {
        return agentList1;
    }

    public void setAgentList1(List<Agent> agentList1) {
        this.agentList1 = agentList1;
    }

    @XmlTransient
    public List<Collectionobject> getCollectionobjectList() {
        return collectionobjectList;
    }

    public void setCollectionobjectList(List<Collectionobject> collectionobjectList) {
        this.collectionobjectList = collectionobjectList;
    }

    @XmlTransient
    public List<Fieldnotebook> getFieldnotebookList() {
        return fieldnotebookList;
    }

    public void setFieldnotebookList(List<Fieldnotebook> fieldnotebookList) {
        this.fieldnotebookList = fieldnotebookList;
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
    public Discipline getDisciplineID() {
        return disciplineID;
    }

    public void setDisciplineID(Discipline disciplineID) {
        this.disciplineID = disciplineID;
    }

    @XmlIDREF
    public Institution getInstitutionNetworkID() {
        return institutionNetworkID;
    }

    public void setInstitutionNetworkID(Institution institutionNetworkID) {
        this.institutionNetworkID = institutionNetworkID;
    }

    @XmlTransient
    public List<Spappresourcedir> getSpappresourcedirList() {
        return spappresourcedirList;
    }

    public void setSpappresourcedirList(List<Spappresourcedir> spappresourcedirList) {
        this.spappresourcedirList = spappresourcedirList;
    }

    @XmlTransient
    public List<Picklist> getPicklistList() {
        return picklistList;
    }

    public void setPicklistList(List<Picklist> picklistList) {
        this.picklistList = picklistList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userGroupScopeId != null ? userGroupScopeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Collection)) {
            return false;
        }
        Collection other = (Collection) object;
        return !((this.userGroupScopeId == null && other.userGroupScopeId != null) || (this.userGroupScopeId != null && !this.userGroupScopeId.equals(other.userGroupScopeId)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Collection[ userGroupScopeId=" + userGroupScopeId + " ]";
    }
    
}
