/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.datamodel;
 
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType; 
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import se.nrm.dina.datamodel.util.Util;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "sptasksemaphore")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sptasksemaphore.findAll", query = "SELECT s FROM Sptasksemaphore s"),
    @NamedQuery(name = "Sptasksemaphore.findByTaskSemaphoreID", query = "SELECT s FROM Sptasksemaphore s WHERE s.taskSemaphoreID = :taskSemaphoreID"), 
    @NamedQuery(name = "Sptasksemaphore.findByContext", query = "SELECT s FROM Sptasksemaphore s WHERE s.context = :context"),
    @NamedQuery(name = "Sptasksemaphore.findByIsLocked", query = "SELECT s FROM Sptasksemaphore s WHERE s.isLocked = :isLocked"),
    @NamedQuery(name = "Sptasksemaphore.findByLockedTime", query = "SELECT s FROM Sptasksemaphore s WHERE s.lockedTime = :lockedTime"),
    @NamedQuery(name = "Sptasksemaphore.findByMachineName", query = "SELECT s FROM Sptasksemaphore s WHERE s.machineName = :machineName"),
    @NamedQuery(name = "Sptasksemaphore.findByScope", query = "SELECT s FROM Sptasksemaphore s WHERE s.scope = :scope"),
    @NamedQuery(name = "Sptasksemaphore.findByTaskName", query = "SELECT s FROM Sptasksemaphore s WHERE s.taskName = :taskName"),
    @NamedQuery(name = "Sptasksemaphore.findByUsageCount", query = "SELECT s FROM Sptasksemaphore s WHERE s.usageCount = :usageCount")})
public class Sptasksemaphore extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TaskSemaphoreID")
    private Integer taskSemaphoreID;
    
    
    @Size(max = 32)
    @Column(name = "Context")
    private String context;
    
    @Column(name = "IsLocked")
    private Boolean isLocked;
    
    @Column(name = "LockedTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lockedTime;
    
    @Size(max = 64)
    @Column(name = "MachineName")
    private String machineName;
    
    @Column(name = "Scope")
    private Short scope;
    
    @Size(max = 32)
    @Column(name = "TaskName")
    private String taskName;
    
    @Column(name = "UsageCount")
    private Integer usageCount;
    
    @JoinColumn(name = "DisciplineID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne
    private Discipline disciplineID;
    
    @JoinColumn(name = "OwnerID", referencedColumnName = "SpecifyUserID")
    @ManyToOne
    private Specifyuser ownerID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "CollectionID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne
    private Collection collectionID;

    public Sptasksemaphore() {
    }

    public Sptasksemaphore(Integer taskSemaphoreID) {
        this.taskSemaphoreID = taskSemaphoreID;
    }

    public Sptasksemaphore(Integer taskSemaphoreID, Date timestampCreated) {
        this.taskSemaphoreID = taskSemaphoreID;
        this.timestampCreated = timestampCreated;
    }

    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + taskSemaphoreID;
    }
    
    @Override
    public int getEntityId() {
        return taskSemaphoreID;
    }
    
    public Integer getTaskSemaphoreID() {
        return taskSemaphoreID;
    }

    public void setTaskSemaphoreID(Integer taskSemaphoreID) {
        this.taskSemaphoreID = taskSemaphoreID;
    }
 

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }

    public Date getLockedTime() {
        return lockedTime;
    }

    public void setLockedTime(Date lockedTime) {
        this.lockedTime = lockedTime;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public Short getScope() {
        return scope;
    }

    public void setScope(Short scope) {
        this.scope = scope;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getUsageCount() {
        return usageCount;
    }

    public void setUsageCount(Integer usageCount) {
        this.usageCount = usageCount;
    }

    @XmlIDREF
    public Discipline getDisciplineID() {
        return disciplineID;
    }

    public void setDisciplineID(Discipline disciplineID) {
        this.disciplineID = disciplineID;
    }

    @XmlIDREF
    public Specifyuser getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(Specifyuser ownerID) {
        this.ownerID = ownerID;
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
    public Collection getCollectionID() {
        return collectionID;
    }

    public void setCollectionID(Collection collectionID) {
        this.collectionID = collectionID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskSemaphoreID != null ? taskSemaphoreID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sptasksemaphore)) {
            return false;
        }
        Sptasksemaphore other = (Sptasksemaphore) object;
        return !((this.taskSemaphoreID == null && other.taskSemaphoreID != null) || (this.taskSemaphoreID != null && !this.taskSemaphoreID.equals(other.taskSemaphoreID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Sptasksemaphore[ taskSemaphoreID=" + taskSemaphoreID + " ]";
    }
    
}
