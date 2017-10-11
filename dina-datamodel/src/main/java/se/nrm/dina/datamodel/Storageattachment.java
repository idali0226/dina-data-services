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
@Table(name = "storageattachment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Storageattachment.findAll", query = "SELECT s FROM Storageattachment s"),
    @NamedQuery(name = "Storageattachment.findByStorageAttachmentID", query = "SELECT s FROM Storageattachment s WHERE s.storageAttachmentID = :storageAttachmentID"), 
    @NamedQuery(name = "Storageattachment.findByOrdinal", query = "SELECT s FROM Storageattachment s WHERE s.ordinal = :ordinal")})
public class Storageattachment extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StorageAttachmentID")
    private Integer storageAttachmentID;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ordinal")
    private int ordinal;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "AttachmentID", referencedColumnName = "AttachmentID")
    @ManyToOne(optional = false)
    private Attachment attachmentID;
    
    @JoinColumn(name = "StorageID", referencedColumnName = "StorageID")
    @ManyToOne(optional = false)
    private Storage storageID;

    public Storageattachment() {
    }

    public Storageattachment(Integer storageAttachmentID) {
        this.storageAttachmentID = storageAttachmentID;
    }

    public Storageattachment(Integer storageAttachmentID, Date timestampCreated, int ordinal) {
        this.storageAttachmentID = storageAttachmentID;
        this.timestampCreated = timestampCreated;
        this.ordinal = ordinal;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + storageAttachmentID;
    }
    
    @Override
    public int getEntityId() {
        return storageAttachmentID;
    }

    public Integer getStorageAttachmentID() {
        return storageAttachmentID;
    }

    public void setStorageAttachmentID(Integer storageAttachmentID) {
        this.storageAttachmentID = storageAttachmentID;
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
    public Attachment getAttachmentID() {
        return attachmentID;
    }

    public void setAttachmentID(Attachment attachmentID) {
        this.attachmentID = attachmentID;
    }

    @XmlIDREF
    public Storage getStorageID() {
        return storageID;
    }

    public void setStorageID(Storage storageID) {
        this.storageID = storageID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storageAttachmentID != null ? storageAttachmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Storageattachment)) {
            return false;
        }
        Storageattachment other = (Storageattachment) object;
        return !((this.storageAttachmentID == null && other.storageAttachmentID != null) || (this.storageAttachmentID != null && !this.storageAttachmentID.equals(other.storageAttachmentID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Storageattachment[ storageAttachmentID=" + storageAttachmentID + " ]";
    }
    
}
