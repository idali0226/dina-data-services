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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
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
@Table(name = "spsymbiotainstance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spsymbiotainstance.findAll", query = "SELECT s FROM Spsymbiotainstance s"),
    @NamedQuery(name = "Spsymbiotainstance.findBySpSymbiotaInstanceID", query = "SELECT s FROM Spsymbiotainstance s WHERE s.spSymbiotaInstanceID = :spSymbiotaInstanceID"), 
    @NamedQuery(name = "Spsymbiotainstance.findByCollectionMemberID", query = "SELECT s FROM Spsymbiotainstance s WHERE s.collectionMemberID = :collectionMemberID"),
    @NamedQuery(name = "Spsymbiotainstance.findByDescription", query = "SELECT s FROM Spsymbiotainstance s WHERE s.description = :description"),
    @NamedQuery(name = "Spsymbiotainstance.findByInstanceName", query = "SELECT s FROM Spsymbiotainstance s WHERE s.instanceName = :instanceName"),
    @NamedQuery(name = "Spsymbiotainstance.findByLastCacheBuild", query = "SELECT s FROM Spsymbiotainstance s WHERE s.lastCacheBuild = :lastCacheBuild"),
    @NamedQuery(name = "Spsymbiotainstance.findByLastPull", query = "SELECT s FROM Spsymbiotainstance s WHERE s.lastPull = :lastPull"),
    @NamedQuery(name = "Spsymbiotainstance.findByLastPush", query = "SELECT s FROM Spsymbiotainstance s WHERE s.lastPush = :lastPush"),
    @NamedQuery(name = "Spsymbiotainstance.findBySymbiotaKey", query = "SELECT s FROM Spsymbiotainstance s WHERE s.symbiotaKey = :symbiotaKey")})
public class Spsymbiotainstance extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SpSymbiotaInstanceID")
    private Integer spSymbiotaInstanceID;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CollectionMemberID")
    private int collectionMemberID;
    
    @Size(max = 256)
    @Column(name = "Description")
    private String description;
    
    @Size(max = 256)
    @Column(name = "InstanceName")
    private String instanceName;
    
    @Column(name = "LastCacheBuild")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastCacheBuild;
    
    @Column(name = "LastPull")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPull;
    
    @Column(name = "LastPush")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPush;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Size(max = 128)
    @Column(name = "SymbiotaKey")
    private String symbiotaKey;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "SchemaMappingID", referencedColumnName = "SpExportSchemaMappingID")
    @ManyToOne
    private Spexportschemamapping schemaMappingID;

    public Spsymbiotainstance() {
    }

    public Spsymbiotainstance(Integer spSymbiotaInstanceID) {
        this.spSymbiotaInstanceID = spSymbiotaInstanceID;
    }

    public Spsymbiotainstance(Integer spSymbiotaInstanceID, Date timestampCreated, int collectionMemberID) {
        this.spSymbiotaInstanceID = spSymbiotaInstanceID;
        this.timestampCreated = timestampCreated;
        this.collectionMemberID = collectionMemberID;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + spSymbiotaInstanceID;
    }

    @Override
    public int getEntityId() {
        return spSymbiotaInstanceID;
    }
    
    public Integer getSpSymbiotaInstanceID() {
        return spSymbiotaInstanceID;
    }

    public void setSpSymbiotaInstanceID(Integer spSymbiotaInstanceID) {
        this.spSymbiotaInstanceID = spSymbiotaInstanceID;
    }
 

    public int getCollectionMemberID() {
        return collectionMemberID;
    }

    public void setCollectionMemberID(int collectionMemberID) {
        this.collectionMemberID = collectionMemberID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public Date getLastCacheBuild() {
        return lastCacheBuild;
    }

    public void setLastCacheBuild(Date lastCacheBuild) {
        this.lastCacheBuild = lastCacheBuild;
    }

    public Date getLastPull() {
        return lastPull;
    }

    public void setLastPull(Date lastPull) {
        this.lastPull = lastPull;
    }

    public Date getLastPush() {
        return lastPush;
    }

    public void setLastPush(Date lastPush) {
        this.lastPush = lastPush;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSymbiotaKey() {
        return symbiotaKey;
    }

    public void setSymbiotaKey(String symbiotaKey) {
        this.symbiotaKey = symbiotaKey;
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
    public Spexportschemamapping getSchemaMappingID() {
        return schemaMappingID;
    }

    public void setSchemaMappingID(Spexportschemamapping schemaMappingID) {
        this.schemaMappingID = schemaMappingID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (spSymbiotaInstanceID != null ? spSymbiotaInstanceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spsymbiotainstance)) {
            return false;
        }
        Spsymbiotainstance other = (Spsymbiotainstance) object;
        return !((this.spSymbiotaInstanceID == null && other.spSymbiotaInstanceID != null) || (this.spSymbiotaInstanceID != null && !this.spSymbiotaInstanceID.equals(other.spSymbiotaInstanceID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Spsymbiotainstance[ spSymbiotaInstanceID=" + spSymbiotaInstanceID + " ]";
    }
    
}
