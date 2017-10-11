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
@Table(name = "spversion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spversion.findAll", query = "SELECT s FROM Spversion s"),
    @NamedQuery(name = "Spversion.findBySpVersionID", query = "SELECT s FROM Spversion s WHERE s.spVersionID = :spVersionID"), 
    @NamedQuery(name = "Spversion.findByAppName", query = "SELECT s FROM Spversion s WHERE s.appName = :appName"),
    @NamedQuery(name = "Spversion.findByAppVersion", query = "SELECT s FROM Spversion s WHERE s.appVersion = :appVersion"),
    @NamedQuery(name = "Spversion.findBySchemaVersion", query = "SELECT s FROM Spversion s WHERE s.schemaVersion = :schemaVersion"),
    @NamedQuery(name = "Spversion.findByIsDBClosed", query = "SELECT s FROM Spversion s WHERE s.isDBClosed = :isDBClosed"),
    @NamedQuery(name = "Spversion.findByDbClosedBy", query = "SELECT s FROM Spversion s WHERE s.dbClosedBy = :dbClosedBy"),
    @NamedQuery(name = "Spversion.findByWorkbenchSchemaVersion", query = "SELECT s FROM Spversion s WHERE s.workbenchSchemaVersion = :workbenchSchemaVersion")})
public class Spversion extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SpVersionID")
    private Integer spVersionID;
    
    
    @Size(max = 32)
    @Column(name = "AppName")
    private String appName;
    
    @Size(max = 16)
    @Column(name = "AppVersion")
    private String appVersion;
    
    @Size(max = 16)
    @Column(name = "SchemaVersion")
    private String schemaVersion;
    
    @Column(name = "IsDBClosed")
    private Boolean isDBClosed;
    
    @Size(max = 32)
    @Column(name = "DbClosedBy")
    private String dbClosedBy;
    
    @Size(max = 16)
    @Column(name = "WorkbenchSchemaVersion")
    private String workbenchSchemaVersion;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;

    public Spversion() {
    }

    public Spversion(Integer spVersionID) {
        this.spVersionID = spVersionID;
    }

    public Spversion(Integer spVersionID, Date timestampCreated) {
        this.spVersionID = spVersionID;
        this.timestampCreated = timestampCreated;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + spVersionID;
    }
    
    @Override
    public int getEntityId() {
        return spVersionID;
    }

    public Integer getSpVersionID() {
        return spVersionID;
    }

    public void setSpVersionID(Integer spVersionID) {
        this.spVersionID = spVersionID;
    }
  

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getSchemaVersion() {
        return schemaVersion;
    }

    public void setSchemaVersion(String schemaVersion) {
        this.schemaVersion = schemaVersion;
    }

    public Boolean getIsDBClosed() {
        return isDBClosed;
    }

    public void setIsDBClosed(Boolean isDBClosed) {
        this.isDBClosed = isDBClosed;
    }

    public String getDbClosedBy() {
        return dbClosedBy;
    }

    public void setDbClosedBy(String dbClosedBy) {
        this.dbClosedBy = dbClosedBy;
    }

    public String getWorkbenchSchemaVersion() {
        return workbenchSchemaVersion;
    }

    public void setWorkbenchSchemaVersion(String workbenchSchemaVersion) {
        this.workbenchSchemaVersion = workbenchSchemaVersion;
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
        hash += (spVersionID != null ? spVersionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spversion)) {
            return false;
        }
        Spversion other = (Spversion) object;
        return !((this.spVersionID == null && other.spVersionID != null) || (this.spVersionID != null && !this.spVersionID.equals(other.spVersionID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Spversion[ spVersionID=" + spVersionID + " ]";
    }
    
}
