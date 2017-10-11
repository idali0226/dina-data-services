/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.datamodel;
 
import java.math.BigInteger;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
@Table(name = "specifyuser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Specifyuser.findAll", query = "SELECT s FROM Specifyuser s"),
    @NamedQuery(name = "Specifyuser.findBySpecifyUserID", query = "SELECT s FROM Specifyuser s WHERE s.specifyUserID = :specifyUserID"), 
    @NamedQuery(name = "Specifyuser.findByAccumMinLoggedIn", query = "SELECT s FROM Specifyuser s WHERE s.accumMinLoggedIn = :accumMinLoggedIn"),
    @NamedQuery(name = "Specifyuser.findByEMail", query = "SELECT s FROM Specifyuser s WHERE s.eMail = :eMail"),
    @NamedQuery(name = "Specifyuser.findByIsLoggedIn", query = "SELECT s FROM Specifyuser s WHERE s.isLoggedIn = :isLoggedIn"),
    @NamedQuery(name = "Specifyuser.findByIsLoggedInReport", query = "SELECT s FROM Specifyuser s WHERE s.isLoggedInReport = :isLoggedInReport"),
    @NamedQuery(name = "Specifyuser.findByLoginCollectionName", query = "SELECT s FROM Specifyuser s WHERE s.loginCollectionName = :loginCollectionName"),
    @NamedQuery(name = "Specifyuser.findByLoginDisciplineName", query = "SELECT s FROM Specifyuser s WHERE s.loginDisciplineName = :loginDisciplineName"),
    @NamedQuery(name = "Specifyuser.findByLoginOutTime", query = "SELECT s FROM Specifyuser s WHERE s.loginOutTime = :loginOutTime"),
    @NamedQuery(name = "Specifyuser.findByName", query = "SELECT s FROM Specifyuser s WHERE s.name = :name"),
    @NamedQuery(name = "Specifyuser.findByPassword", query = "SELECT s FROM Specifyuser s WHERE s.password = :password"),
    @NamedQuery(name = "Specifyuser.findByUserType", query = "SELECT s FROM Specifyuser s WHERE s.userType = :userType")})
public class Specifyuser extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SpecifyUserID")
    private Integer specifyUserID;
    
    
    @Column(name = "AccumMinLoggedIn")
    private BigInteger accumMinLoggedIn;
    
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 64)
    @Column(name = "EMail")
    private String eMail;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsLoggedIn")
    private boolean isLoggedIn;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsLoggedInReport")
    private boolean isLoggedInReport;
    
    @Size(max = 64)
    @Column(name = "LoginCollectionName")
    private String loginCollectionName;
    
    @Size(max = 64)
    @Column(name = "LoginDisciplineName")
    private String loginDisciplineName;
    
    @Column(name = "LoginOutTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date loginOutTime;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "Name")
    private String name;
    
    @Size(max = 255)
    @Column(name = "Password")
    private String password;
    
    @Size(max = 32)
    @Column(name = "UserType")
    private String userType;
    
    @JoinTable(name = "specifyuser_spprincipal", joinColumns = {
        @JoinColumn(name = "SpecifyUserID", referencedColumnName = "SpecifyUserID")}, inverseJoinColumns = {
        @JoinColumn(name = "SpPrincipalID", referencedColumnName = "SpPrincipalID")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Spprincipal> spprincipalList;
    
    @OneToMany(mappedBy = "ownerID", fetch = FetchType.LAZY)
    private List<Sptasksemaphore> sptasksemaphoreList;
    
    @OneToMany(mappedBy = "visibilitySetByID", fetch = FetchType.LAZY)
    private List<Locality> localityList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specifyUserID", fetch = FetchType.LAZY)
    private List<Recordset> recordsetList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specifyUserID", fetch = FetchType.LAZY)
    private List<Spappresource> spappresourceList;
    
    @OneToMany(mappedBy = "visibilitySetByID", fetch = FetchType.LAZY)
    private List<Taxon> taxonList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specifyUserID", fetch = FetchType.LAZY)
    private List<Spquery> spqueryList;
    
    @OneToMany(mappedBy = "specifyUserID", fetch = FetchType.LAZY)
    private List<Agent> agentList;
    
    @OneToMany(mappedBy = "visibilitySetByID", fetch = FetchType.LAZY)
    private List<Collectionobject> collectionobjectList;
    
    @OneToMany(mappedBy = "visibilitySetByID", fetch = FetchType.LAZY)
    private List<Collectingevent> collectingeventList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specifyUserID", fetch = FetchType.LAZY)
    private List<Workbench> workbenchList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specifyUserID", fetch = FetchType.LAZY)
    private List<Workbenchtemplate> workbenchtemplateList;
    
    @OneToMany(mappedBy = "specifyUserID", fetch = FetchType.LAZY)
    private List<Spappresourcedir> spappresourcedirList;
    
    @OneToMany(mappedBy = "visibilitySetByID")
    private List<Attachment> attachmentList;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID" )
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID" )
    @ManyToOne
    private Agent createdByAgentID;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specifyUserID", fetch = FetchType.LAZY)
    private List<Spreport> spreportList;

    public Specifyuser() {
    }

    public Specifyuser(Integer specifyUserID) {
        this.specifyUserID = specifyUserID;
    }

    public Specifyuser(Integer specifyUserID, Date timestampCreated, boolean isLoggedIn, boolean isLoggedInReport, String name) {
        this.specifyUserID = specifyUserID;
        this.timestampCreated = timestampCreated;
        this.isLoggedIn = isLoggedIn;
        this.isLoggedInReport = isLoggedInReport;
        this.name = name;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + specifyUserID;
    }

    @Override
    public int getEntityId() {
        return specifyUserID;
    }
    
    public Integer getSpecifyUserID() {
        return specifyUserID;
    }

    public void setSpecifyUserID(Integer specifyUserID) {
        this.specifyUserID = specifyUserID;
    }
 

    public BigInteger getAccumMinLoggedIn() {
        return accumMinLoggedIn;
    }

    public void setAccumMinLoggedIn(BigInteger accumMinLoggedIn) {
        this.accumMinLoggedIn = accumMinLoggedIn;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public boolean getIsLoggedInReport() {
        return isLoggedInReport;
    }

    public void setIsLoggedInReport(boolean isLoggedInReport) {
        this.isLoggedInReport = isLoggedInReport;
    }

    public String getLoginCollectionName() {
        return loginCollectionName;
    }

    public void setLoginCollectionName(String loginCollectionName) {
        this.loginCollectionName = loginCollectionName;
    }

    public String getLoginDisciplineName() {
        return loginDisciplineName;
    }

    public void setLoginDisciplineName(String loginDisciplineName) {
        this.loginDisciplineName = loginDisciplineName;
    }

    public Date getLoginOutTime() {
        return loginOutTime;
    }

    public void setLoginOutTime(Date loginOutTime) {
        this.loginOutTime = loginOutTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @XmlTransient
    public List<Spprincipal> getSpprincipalList() {
        return spprincipalList;
    }

    public void setSpprincipalList(List<Spprincipal> spprincipalList) {
        this.spprincipalList = spprincipalList;
    }

    @XmlTransient
    public List<Sptasksemaphore> getSptasksemaphoreList() {
        return sptasksemaphoreList;
    }

    public void setSptasksemaphoreList(List<Sptasksemaphore> sptasksemaphoreList) {
        this.sptasksemaphoreList = sptasksemaphoreList;
    }

    @XmlTransient
    public List<Locality> getLocalityList() {
        return localityList;
    }

    public void setLocalityList(List<Locality> localityList) {
        this.localityList = localityList;
    }

    @XmlTransient
    public List<Recordset> getRecordsetList() {
        return recordsetList;
    }

    public void setRecordsetList(List<Recordset> recordsetList) {
        this.recordsetList = recordsetList;
    }

    @XmlTransient
    public List<Spappresource> getSpappresourceList() {
        return spappresourceList;
    }

    public void setSpappresourceList(List<Spappresource> spappresourceList) {
        this.spappresourceList = spappresourceList;
    }

    @XmlTransient
    public List<Taxon> getTaxonList() {
        return taxonList;
    }

    public void setTaxonList(List<Taxon> taxonList) {
        this.taxonList = taxonList;
    }

    @XmlTransient
    public List<Spquery> getSpqueryList() {
        return spqueryList;
    }

    public void setSpqueryList(List<Spquery> spqueryList) {
        this.spqueryList = spqueryList;
    }

    @XmlTransient
    public List<Agent> getAgentList() {
        return agentList;
    }

    public void setAgentList(List<Agent> agentList) {
        this.agentList = agentList;
    }

    @XmlTransient
    public List<Collectionobject> getCollectionobjectList() {
        return collectionobjectList;
    }

    public void setCollectionobjectList(List<Collectionobject> collectionobjectList) {
        this.collectionobjectList = collectionobjectList;
    }

    @XmlTransient
    public List<Collectingevent> getCollectingeventList() {
        return collectingeventList;
    }

    public void setCollectingeventList(List<Collectingevent> collectingeventList) {
        this.collectingeventList = collectingeventList;
    }

    @XmlTransient
    public List<Workbench> getWorkbenchList() {
        return workbenchList;
    }

    public void setWorkbenchList(List<Workbench> workbenchList) {
        this.workbenchList = workbenchList;
    }

    @XmlTransient
    public List<Workbenchtemplate> getWorkbenchtemplateList() {
        return workbenchtemplateList;
    }

    public void setWorkbenchtemplateList(List<Workbenchtemplate> workbenchtemplateList) {
        this.workbenchtemplateList = workbenchtemplateList;
    }

    @XmlTransient
    public List<Spappresourcedir> getSpappresourcedirList() {
        return spappresourcedirList;
    }

    public void setSpappresourcedirList(List<Spappresourcedir> spappresourcedirList) {
        this.spappresourcedirList = spappresourcedirList;
    }

    @XmlTransient
    public List<Attachment> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(List<Attachment> attachmentList) {
        this.attachmentList = attachmentList;
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
    public List<Spreport> getSpreportList() {
        return spreportList;
    }

    public void setSpreportList(List<Spreport> spreportList) {
        this.spreportList = spreportList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (specifyUserID != null ? specifyUserID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Specifyuser)) {
            return false;
        }
        Specifyuser other = (Specifyuser) object;
        return !((this.specifyUserID == null && other.specifyUserID != null) || (this.specifyUserID != null && !this.specifyUserID.equals(other.specifyUserID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Specifyuser[ specifyUserID=" + specifyUserID + " ]";
    }
    
}
