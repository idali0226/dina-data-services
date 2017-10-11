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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table; 
import javax.validation.constraints.NotNull;
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
@Table(name = "spauditlog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spauditlog.findAll", query = "SELECT s FROM Spauditlog s"),
    @NamedQuery(name = "Spauditlog.findBySpAuditLogID", query = "SELECT s FROM Spauditlog s WHERE s.spAuditLogID = :spAuditLogID"), 
    @NamedQuery(name = "Spauditlog.findByAction", query = "SELECT s FROM Spauditlog s WHERE s.action = :action"),
    @NamedQuery(name = "Spauditlog.findByRecordId", query = "SELECT s FROM Spauditlog s WHERE s.recordId = :recordId"),
    @NamedQuery(name = "Spauditlog.findByTableNum", query = "SELECT s FROM Spauditlog s WHERE s.tableNum = :tableNum"),
    @NamedQuery(name = "Spauditlog.findByParentRecordId", query = "SELECT s FROM Spauditlog s WHERE s.parentRecordId = :parentRecordId"),
    @NamedQuery(name = "Spauditlog.findByParentTableNum", query = "SELECT s FROM Spauditlog s WHERE s.parentTableNum = :parentTableNum"),
    @NamedQuery(name = "Spauditlog.findByRecordVersion", query = "SELECT s FROM Spauditlog s WHERE s.recordVersion = :recordVersion")})
public class Spauditlog extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SpAuditLogID")
    private Integer spAuditLogID;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Action")
    private int action;
    
    @Column(name = "RecordId")
    private Integer recordId;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "TableNum")
    private int tableNum;
    
    @Column(name = "ParentRecordId")
    private Integer parentRecordId;
    
    @Column(name = "ParentTableNum")
    private Short parentTableNum;
    
    @Column(name = "RecordVersion")
    private Integer recordVersion;
    
    @OneToMany(mappedBy = "spAuditLogID", fetch = FetchType.LAZY)
    private List<Spauditlogfield> spauditlogfieldList;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;

    public Spauditlog() {
    }

    public Spauditlog(Integer spAuditLogID) {
        this.spAuditLogID = spAuditLogID;
    }

    public Spauditlog(Integer spAuditLogID, Date timestampCreated, int action, int tableNum) {
        this.spAuditLogID = spAuditLogID;
        this.timestampCreated = timestampCreated;
        this.action = action;
        this.tableNum = tableNum;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + spAuditLogID;
    }
    
    @Override
    public int getEntityId() {
        return spAuditLogID;
    }

    public Integer getSpAuditLogID() {
        return spAuditLogID;
    }

    public void setSpAuditLogID(Integer spAuditLogID) {
        this.spAuditLogID = spAuditLogID;
    }
 

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public int getTableNum() {
        return tableNum;
    }

    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }

    public Integer getParentRecordId() {
        return parentRecordId;
    }

    public void setParentRecordId(Integer parentRecordId) {
        this.parentRecordId = parentRecordId;
    }

    public Short getParentTableNum() {
        return parentTableNum;
    }

    public void setParentTableNum(Short parentTableNum) {
        this.parentTableNum = parentTableNum;
    }

    public Integer getRecordVersion() {
        return recordVersion;
    }

    public void setRecordVersion(Integer recordVersion) {
        this.recordVersion = recordVersion;
    }

    @XmlTransient
    public List<Spauditlogfield> getSpauditlogfieldList() {
        return spauditlogfieldList;
    }

    public void setSpauditlogfieldList(List<Spauditlogfield> spauditlogfieldList) {
        this.spauditlogfieldList = spauditlogfieldList;
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
        hash += (spAuditLogID != null ? spAuditLogID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spauditlog)) {
            return false;
        }
        Spauditlog other = (Spauditlog) object;
        return !((this.spAuditLogID == null && other.spAuditLogID != null) || (this.spAuditLogID != null && !this.spAuditLogID.equals(other.spAuditLogID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Spauditlog[ spAuditLogID=" + spAuditLogID + " ]";
    }
    
}
