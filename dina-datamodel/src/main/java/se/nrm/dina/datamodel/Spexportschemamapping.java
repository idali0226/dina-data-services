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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType; 
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
@Table(name = "spexportschemamapping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spexportschemamapping.findAll", query = "SELECT s FROM Spexportschemamapping s"),
    @NamedQuery(name = "Spexportschemamapping.findBySpExportSchemaMappingID", query = "SELECT s FROM Spexportschemamapping s WHERE s.spExportSchemaMappingID = :spExportSchemaMappingID"), 
    @NamedQuery(name = "Spexportschemamapping.findByDescription", query = "SELECT s FROM Spexportschemamapping s WHERE s.description = :description"),
    @NamedQuery(name = "Spexportschemamapping.findByMappingName", query = "SELECT s FROM Spexportschemamapping s WHERE s.mappingName = :mappingName"),
    @NamedQuery(name = "Spexportschemamapping.findByTimeStampExported", query = "SELECT s FROM Spexportschemamapping s WHERE s.timeStampExported = :timeStampExported"),
    @NamedQuery(name = "Spexportschemamapping.findByCollectionMemberID", query = "SELECT s FROM Spexportschemamapping s WHERE s.collectionMemberID = :collectionMemberID")})
public class Spexportschemamapping extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SpExportSchemaMappingID")
    private Integer spExportSchemaMappingID;
    
    
    @Size(max = 255)
    @Column(name = "Description")
    private String description;
    
    @Size(max = 50)
    @Column(name = "MappingName")
    private String mappingName;
    
    @Column(name = "TimeStampExported")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStampExported;
    
    @Column(name = "CollectionMemberID")
    private Integer collectionMemberID;
    
    @ManyToMany(mappedBy = "spexportschemamappingList", fetch = FetchType.LAZY)
    private List<Spexportschema> spexportschemaList;
    
    @OneToMany(mappedBy = "spExportSchemaMappingID", fetch = FetchType.LAZY)
    private List<Spexportschemaitemmapping> spexportschemaitemmappingList;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @OneToMany(mappedBy = "schemaMappingID", fetch = FetchType.LAZY)
    private List<Spsymbiotainstance> spsymbiotainstanceList;

    public Spexportschemamapping() {
    }

    public Spexportschemamapping(Integer spExportSchemaMappingID) {
        this.spExportSchemaMappingID = spExportSchemaMappingID;
    }

    public Spexportschemamapping(Integer spExportSchemaMappingID, Date timestampCreated) {
        this.spExportSchemaMappingID = spExportSchemaMappingID;
        this.timestampCreated = timestampCreated;
    }

    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + spExportSchemaMappingID;
    }
    
    @Override
    public int getEntityId() {
        return spExportSchemaMappingID;
    }
    
    public Integer getSpExportSchemaMappingID() {
        return spExportSchemaMappingID;
    }

    public void setSpExportSchemaMappingID(Integer spExportSchemaMappingID) {
        this.spExportSchemaMappingID = spExportSchemaMappingID;
    }
 
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMappingName() {
        return mappingName;
    }

    public void setMappingName(String mappingName) {
        this.mappingName = mappingName;
    }

    public Date getTimeStampExported() {
        return timeStampExported;
    }

    public void setTimeStampExported(Date timeStampExported) {
        this.timeStampExported = timeStampExported;
    }

    public Integer getCollectionMemberID() {
        return collectionMemberID;
    }

    public void setCollectionMemberID(Integer collectionMemberID) {
        this.collectionMemberID = collectionMemberID;
    }

    @XmlTransient
    public List<Spexportschema> getSpexportschemaList() {
        return spexportschemaList;
    }

    public void setSpexportschemaList(List<Spexportschema> spexportschemaList) {
        this.spexportschemaList = spexportschemaList;
    }

    @XmlTransient
    public List<Spexportschemaitemmapping> getSpexportschemaitemmappingList() {
        return spexportschemaitemmappingList;
    }

    public void setSpexportschemaitemmappingList(List<Spexportschemaitemmapping> spexportschemaitemmappingList) {
        this.spexportschemaitemmappingList = spexportschemaitemmappingList;
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
    public List<Spsymbiotainstance> getSpsymbiotainstanceList() {
        return spsymbiotainstanceList;
    }

    public void setSpsymbiotainstanceList(List<Spsymbiotainstance> spsymbiotainstanceList) {
        this.spsymbiotainstanceList = spsymbiotainstanceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (spExportSchemaMappingID != null ? spExportSchemaMappingID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spexportschemamapping)) {
            return false;
        }
        Spexportschemamapping other = (Spexportschemamapping) object;
        return !((this.spExportSchemaMappingID == null && other.spExportSchemaMappingID != null) || (this.spExportSchemaMappingID != null && !this.spExportSchemaMappingID.equals(other.spExportSchemaMappingID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Spexportschemamapping[ spExportSchemaMappingID=" + spExportSchemaMappingID + " ]";
    }
    
}
