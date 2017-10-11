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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table; 
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import se.nrm.dina.datamodel.util.Util;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "referenceworkattachment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Referenceworkattachment.findAll", query = "SELECT r FROM Referenceworkattachment r"),
    @NamedQuery(name = "Referenceworkattachment.findByReferenceWorkAttachmentID", query = "SELECT r FROM Referenceworkattachment r WHERE r.referenceWorkAttachmentID = :referenceWorkAttachmentID"), 
    @NamedQuery(name = "Referenceworkattachment.findByOrdinal", query = "SELECT r FROM Referenceworkattachment r WHERE r.ordinal = :ordinal"),
    @NamedQuery(name = "Referenceworkattachment.findByReferenceWorkID", query = "SELECT r FROM Referenceworkattachment r WHERE r.referenceWorkID = :referenceWorkID"),
    @NamedQuery(name = "Referenceworkattachment.findByModifiedByAgentID", query = "SELECT r FROM Referenceworkattachment r WHERE r.modifiedByAgentID = :modifiedByAgentID"),
    @NamedQuery(name = "Referenceworkattachment.findByCreatedByAgentID", query = "SELECT r FROM Referenceworkattachment r WHERE r.createdByAgentID = :createdByAgentID"),
    @NamedQuery(name = "Referenceworkattachment.findByAttachmentID", query = "SELECT r FROM Referenceworkattachment r WHERE r.attachmentID = :attachmentID")})
public class Referenceworkattachment extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ReferenceWorkAttachmentID")
    private Integer referenceWorkAttachmentID;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ordinal")
    private int ordinal;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ReferenceWorkID")
    private int referenceWorkID;
    
    @Column(name = "ModifiedByAgentID")
    private Integer modifiedByAgentID;
    
    @Column(name = "CreatedByAgentID")
    private Integer createdByAgentID;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "AttachmentID")
    private int attachmentID;

    public Referenceworkattachment() {
    }

    public Referenceworkattachment(Integer referenceWorkAttachmentID) {
        this.referenceWorkAttachmentID = referenceWorkAttachmentID;
    }

    public Referenceworkattachment(Integer referenceWorkAttachmentID, Date timestampCreated, int ordinal, int referenceWorkID, int attachmentID) {
        this.referenceWorkAttachmentID = referenceWorkAttachmentID;
        this.timestampCreated = timestampCreated;
        this.ordinal = ordinal;
        this.referenceWorkID = referenceWorkID;
        this.attachmentID = attachmentID;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + referenceWorkAttachmentID;
    }
    
    @Override
    public int getEntityId() {
        return referenceWorkAttachmentID;
    }

    public Integer getReferenceWorkAttachmentID() {
        return referenceWorkAttachmentID;
    }

    public void setReferenceWorkAttachmentID(Integer referenceWorkAttachmentID) {
        this.referenceWorkAttachmentID = referenceWorkAttachmentID;
    }
 

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getReferenceWorkID() {
        return referenceWorkID;
    }

    public void setReferenceWorkID(int referenceWorkID) {
        this.referenceWorkID = referenceWorkID;
    }

    public Integer getModifiedByAgentID() {
        return modifiedByAgentID;
    }

    public void setModifiedByAgentID(Integer modifiedByAgentID) {
        this.modifiedByAgentID = modifiedByAgentID;
    }

    public Integer getCreatedByAgentID() {
        return createdByAgentID;
    }

    public void setCreatedByAgentID(Integer createdByAgentID) {
        this.createdByAgentID = createdByAgentID;
    }

    public int getAttachmentID() {
        return attachmentID;
    }

    public void setAttachmentID(int attachmentID) {
        this.attachmentID = attachmentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (referenceWorkAttachmentID != null ? referenceWorkAttachmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Referenceworkattachment)) {
            return false;
        }
        Referenceworkattachment other = (Referenceworkattachment) object;
        return !((this.referenceWorkAttachmentID == null && other.referenceWorkAttachmentID != null) || (this.referenceWorkAttachmentID != null && !this.referenceWorkAttachmentID.equals(other.referenceWorkAttachmentID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Referenceworkattachment[ referenceWorkAttachmentID=" + referenceWorkAttachmentID + " ]";
    }
    
}
