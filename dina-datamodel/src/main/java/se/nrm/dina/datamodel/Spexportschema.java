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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table; 
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
@Table(name = "spexportschema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spexportschema.findAll", query = "SELECT s FROM Spexportschema s"),
    @NamedQuery(name = "Spexportschema.findBySpExportSchemaID", query = "SELECT s FROM Spexportschema s WHERE s.spExportSchemaID = :spExportSchemaID"), 
    @NamedQuery(name = "Spexportschema.findByDescription", query = "SELECT s FROM Spexportschema s WHERE s.description = :description"),
    @NamedQuery(name = "Spexportschema.findBySchemaName", query = "SELECT s FROM Spexportschema s WHERE s.schemaName = :schemaName"),
    @NamedQuery(name = "Spexportschema.findBySchemaVersion", query = "SELECT s FROM Spexportschema s WHERE s.schemaVersion = :schemaVersion")})
public class Spexportschema extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SpExportSchemaID")
    private Integer spExportSchemaID;
    
    @Size(max = 255)
    @Column(name = "Description")
    private String description;
    
    @Size(max = 80)
    @Column(name = "SchemaName")
    private String schemaName;
    
    @Size(max = 80)
    @Column(name = "SchemaVersion")
    private String schemaVersion;
    
    @JoinTable(name = "sp_schema_mapping", joinColumns = {
        @JoinColumn(name = "SpExportSchemaID", referencedColumnName = "SpExportSchemaID")}, inverseJoinColumns = {
        @JoinColumn(name = "SpExportSchemaMappingID", referencedColumnName = "SpExportSchemaMappingID")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Spexportschemamapping> spexportschemamappingList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "spExportSchemaID", fetch = FetchType.LAZY)
    private List<Spexportschemaitem> spexportschemaitemList;
    
    @JoinColumn(name = "DisciplineID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne(optional = false)
    private Discipline disciplineID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;

    public Spexportschema() {
    }

    public Spexportschema(Integer spExportSchemaID) {
        this.spExportSchemaID = spExportSchemaID;
    }

    public Spexportschema(Integer spExportSchemaID, Date timestampCreated) {
        this.spExportSchemaID = spExportSchemaID;
        this.timestampCreated = timestampCreated;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + spExportSchemaID;
    }
    
    @Override
    public int getEntityId() {
        return spExportSchemaID;
    }

    public Integer getSpExportSchemaID() {
        return spExportSchemaID;
    }

    public void setSpExportSchemaID(Integer spExportSchemaID) {
        this.spExportSchemaID = spExportSchemaID;
    }
 
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getSchemaVersion() {
        return schemaVersion;
    }

    public void setSchemaVersion(String schemaVersion) {
        this.schemaVersion = schemaVersion;
    }

    @XmlTransient
    public List<Spexportschemamapping> getSpexportschemamappingList() {
        return spexportschemamappingList;
    }

    public void setSpexportschemamappingList(List<Spexportschemamapping> spexportschemamappingList) {
        this.spexportschemamappingList = spexportschemamappingList;
    }

    @XmlTransient
    public List<Spexportschemaitem> getSpexportschemaitemList() {
        return spexportschemaitemList;
    }

    public void setSpexportschemaitemList(List<Spexportschemaitem> spexportschemaitemList) {
        this.spexportschemaitemList = spexportschemaitemList;
    }

    @XmlIDREF
    public Discipline getDisciplineID() {
        return disciplineID;
    }

    public void setDisciplineID(Discipline disciplineID) {
        this.disciplineID = disciplineID;
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
        hash += (spExportSchemaID != null ? spExportSchemaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spexportschema)) {
            return false;
        }
        Spexportschema other = (Spexportschema) object;
        return !((this.spExportSchemaID == null && other.spExportSchemaID != null) || (this.spExportSchemaID != null && !this.spExportSchemaID.equals(other.spExportSchemaID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Spexportschema[ spExportSchemaID=" + spExportSchemaID + " ]";
    }
    
}
