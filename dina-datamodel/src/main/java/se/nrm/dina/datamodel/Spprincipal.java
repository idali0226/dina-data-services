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
@Table(name = "spprincipal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spprincipal.findAll", query = "SELECT s FROM Spprincipal s"),
    @NamedQuery(name = "Spprincipal.findBySpPrincipalID", query = "SELECT s FROM Spprincipal s WHERE s.spPrincipalID = :spPrincipalID"), 
    @NamedQuery(name = "Spprincipal.findByGroupSubClass", query = "SELECT s FROM Spprincipal s WHERE s.groupSubClass = :groupSubClass"),
    @NamedQuery(name = "Spprincipal.findByGroupType", query = "SELECT s FROM Spprincipal s WHERE s.groupType = :groupType"),
    @NamedQuery(name = "Spprincipal.findByName", query = "SELECT s FROM Spprincipal s WHERE s.name = :name"),
    @NamedQuery(name = "Spprincipal.findByPriority", query = "SELECT s FROM Spprincipal s WHERE s.priority = :priority"),
    @NamedQuery(name = "Spprincipal.findByUserGroupScopeID", query = "SELECT s FROM Spprincipal s WHERE s.userGroupScopeID = :userGroupScopeID")})
public class Spprincipal extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SpPrincipalID")
    private Integer spPrincipalID;
    
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "GroupSubClass")
    private String groupSubClass;
    
    @Size(max = 32)
    @Column(name = "groupType")
    private String groupType;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "Name")
    private String name;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Priority")
    private short priority;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Column(name = "userGroupScopeID")
    private Integer userGroupScopeID;
    
    @ManyToMany(mappedBy = "spprincipalList", fetch = FetchType.LAZY)
    private List<Specifyuser> specifyuserList;
    
    @ManyToMany(mappedBy = "spprincipalList", fetch = FetchType.LAZY)
    private List<Sppermission> sppermissionList;
    
    @OneToMany(mappedBy = "spPrincipalID", fetch = FetchType.LAZY)
    private List<Recordset> recordsetList;
    
    @OneToMany(mappedBy = "spPrincipalID", fetch = FetchType.LAZY)
    private List<Spappresource> spappresourceList;
    
    @OneToMany(mappedBy = "spPrincipalID", fetch = FetchType.LAZY)
    private List<Workbench> workbenchList;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;

    public Spprincipal() {
    }

    public Spprincipal(Integer spPrincipalID) {
        this.spPrincipalID = spPrincipalID;
    }

    public Spprincipal(Integer spPrincipalID, Date timestampCreated, String groupSubClass, String name, short priority) {
        this.spPrincipalID = spPrincipalID;
        this.timestampCreated = timestampCreated;
        this.groupSubClass = groupSubClass;
        this.name = name;
        this.priority = priority;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + spPrincipalID;
    }
    
    @Override
    public int getEntityId() {
        return spPrincipalID;
    }

    public Integer getSpPrincipalID() {
        return spPrincipalID;
    }

    public void setSpPrincipalID(Integer spPrincipalID) {
        this.spPrincipalID = spPrincipalID;
    }
 

    public String getGroupSubClass() {
        return groupSubClass;
    }

    public void setGroupSubClass(String groupSubClass) {
        this.groupSubClass = groupSubClass;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getPriority() {
        return priority;
    }

    public void setPriority(short priority) {
        this.priority = priority;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getUserGroupScopeID() {
        return userGroupScopeID;
    }

    public void setUserGroupScopeID(Integer userGroupScopeID) {
        this.userGroupScopeID = userGroupScopeID;
    }

    @XmlTransient
    public List<Specifyuser> getSpecifyuserList() {
        return specifyuserList;
    }

    public void setSpecifyuserList(List<Specifyuser> specifyuserList) {
        this.specifyuserList = specifyuserList;
    }

    @XmlTransient
    public List<Sppermission> getSppermissionList() {
        return sppermissionList;
    }

    public void setSppermissionList(List<Sppermission> sppermissionList) {
        this.sppermissionList = sppermissionList;
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
    public List<Workbench> getWorkbenchList() {
        return workbenchList;
    }

    public void setWorkbenchList(List<Workbench> workbenchList) {
        this.workbenchList = workbenchList;
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
        hash += (spPrincipalID != null ? spPrincipalID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spprincipal)) {
            return false;
        }
        Spprincipal other = (Spprincipal) object;
        return !((this.spPrincipalID == null && other.spPrincipalID != null) || (this.spPrincipalID != null && !this.spPrincipalID.equals(other.spPrincipalID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Spprincipal[ spPrincipalID=" + spPrincipalID + " ]";
    }
    
}
