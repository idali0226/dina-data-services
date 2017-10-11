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
@Table(name = "spexportschemaitemmapping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spexportschemaitemmapping.findAll", query = "SELECT s FROM Spexportschemaitemmapping s"),
    @NamedQuery(name = "Spexportschemaitemmapping.findBySpExportSchemaItemMappingID", query = "SELECT s FROM Spexportschemaitemmapping s WHERE s.spExportSchemaItemMappingID = :spExportSchemaItemMappingID"), 
    @NamedQuery(name = "Spexportschemaitemmapping.findByRemarks", query = "SELECT s FROM Spexportschemaitemmapping s WHERE s.remarks = :remarks"),
    @NamedQuery(name = "Spexportschemaitemmapping.findByExportedFieldName", query = "SELECT s FROM Spexportschemaitemmapping s WHERE s.exportedFieldName = :exportedFieldName")})
public class Spexportschemaitemmapping extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SpExportSchemaItemMappingID")
    private Integer spExportSchemaItemMappingID;
    
    
    @Size(max = 255)
    @Column(name = "Remarks")
    private String remarks;
    
    @Size(max = 64)
    @Column(name = "ExportedFieldName")
    private String exportedFieldName;
    
    @JoinColumn(name = "ExportSchemaItemID", referencedColumnName = "SpExportSchemaItemID")
    @ManyToOne(optional = false)
    private Spexportschemaitem exportSchemaItemID;
    
    @JoinColumn(name = "SpQueryFieldID", referencedColumnName = "SpQueryFieldID")
    @ManyToOne
    private Spqueryfield spQueryFieldID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "SpExportSchemaMappingID", referencedColumnName = "SpExportSchemaMappingID")
    @ManyToOne
    private Spexportschemamapping spExportSchemaMappingID;

    public Spexportschemaitemmapping() {
    }

    public Spexportschemaitemmapping(Integer spExportSchemaItemMappingID) {
        this.spExportSchemaItemMappingID = spExportSchemaItemMappingID;
    }

    public Spexportschemaitemmapping(Integer spExportSchemaItemMappingID, Date timestampCreated) {
        this.spExportSchemaItemMappingID = spExportSchemaItemMappingID;
        this.timestampCreated = timestampCreated;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + spExportSchemaItemMappingID;
    }
    
    @Override
    public int getEntityId() {
        return spExportSchemaItemMappingID;
    }

    public Integer getSpExportSchemaItemMappingID() {
        return spExportSchemaItemMappingID;
    }

    public void setSpExportSchemaItemMappingID(Integer spExportSchemaItemMappingID) {
        this.spExportSchemaItemMappingID = spExportSchemaItemMappingID;
    }
 
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getExportedFieldName() {
        return exportedFieldName;
    }

    public void setExportedFieldName(String exportedFieldName) {
        this.exportedFieldName = exportedFieldName;
    }

    @XmlIDREF
    public Spexportschemaitem getExportSchemaItemID() {
        return exportSchemaItemID;
    }

    public void setExportSchemaItemID(Spexportschemaitem exportSchemaItemID) {
        this.exportSchemaItemID = exportSchemaItemID;
    }

    @XmlIDREF
    public Spqueryfield getSpQueryFieldID() {
        return spQueryFieldID;
    }

    public void setSpQueryFieldID(Spqueryfield spQueryFieldID) {
        this.spQueryFieldID = spQueryFieldID;
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
    public Spexportschemamapping getSpExportSchemaMappingID() {
        return spExportSchemaMappingID;
    }

    public void setSpExportSchemaMappingID(Spexportschemamapping spExportSchemaMappingID) {
        this.spExportSchemaMappingID = spExportSchemaMappingID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (spExportSchemaItemMappingID != null ? spExportSchemaItemMappingID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spexportschemaitemmapping)) {
            return false;
        }
        Spexportschemaitemmapping other = (Spexportschemaitemmapping) object;
        return !((this.spExportSchemaItemMappingID == null && other.spExportSchemaItemMappingID != null) || (this.spExportSchemaItemMappingID != null && !this.spExportSchemaItemMappingID.equals(other.spExportSchemaItemMappingID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Spexportschemaitemmapping[ spExportSchemaItemMappingID=" + spExportSchemaItemMappingID + " ]";
    }
    
}
