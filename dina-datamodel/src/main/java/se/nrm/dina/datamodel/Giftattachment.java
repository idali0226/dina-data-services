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
@Table(name = "giftattachment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Giftattachment.findAll", query = "SELECT g FROM Giftattachment g"),
    @NamedQuery(name = "Giftattachment.findByGiftAttachmentID", query = "SELECT g FROM Giftattachment g WHERE g.giftAttachmentID = :giftAttachmentID"), 
    @NamedQuery(name = "Giftattachment.findByOrdinal", query = "SELECT g FROM Giftattachment g WHERE g.ordinal = :ordinal"),
    @NamedQuery(name = "Giftattachment.findByCreatedByAgentID", query = "SELECT g FROM Giftattachment g WHERE g.createdByAgentID = :createdByAgentID"),
    @NamedQuery(name = "Giftattachment.findByAttachmentID", query = "SELECT g FROM Giftattachment g WHERE g.attachmentID = :attachmentID"),
    @NamedQuery(name = "Giftattachment.findByGiftID", query = "SELECT g FROM Giftattachment g WHERE g.giftID = :giftID"),
    @NamedQuery(name = "Giftattachment.findByModifiedByAgentID", query = "SELECT g FROM Giftattachment g WHERE g.modifiedByAgentID = :modifiedByAgentID")})
public class Giftattachment extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GiftAttachmentID")
    private Integer giftAttachmentID;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ordinal")
    private int ordinal;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Column(name = "CreatedByAgentID")
    private Integer createdByAgentID;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "AttachmentID")
    private int attachmentID;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "GiftID")
    private int giftID;
    
    @Column(name = "ModifiedByAgentID")
    private Integer modifiedByAgentID;

    public Giftattachment() {
    }

    public Giftattachment(Integer giftAttachmentID) {
        this.giftAttachmentID = giftAttachmentID;
    }

    public Giftattachment(Integer giftAttachmentID, Date timestampCreated, int ordinal, int attachmentID, int giftID) {
        this.giftAttachmentID = giftAttachmentID;
        this.timestampCreated = timestampCreated;
        this.ordinal = ordinal;
        this.attachmentID = attachmentID;
        this.giftID = giftID;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + giftAttachmentID;
    }
    
    @Override
    public int getEntityId() {
        return giftAttachmentID;
    }

    public Integer getGiftAttachmentID() {
        return giftAttachmentID;
    }

    public void setGiftAttachmentID(Integer giftAttachmentID) {
        this.giftAttachmentID = giftAttachmentID;
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

    public int getGiftID() {
        return giftID;
    }

    public void setGiftID(int giftID) {
        this.giftID = giftID;
    }

    public Integer getModifiedByAgentID() {
        return modifiedByAgentID;
    }

    public void setModifiedByAgentID(Integer modifiedByAgentID) {
        this.modifiedByAgentID = modifiedByAgentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (giftAttachmentID != null ? giftAttachmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Giftattachment)) {
            return false;
        }
        Giftattachment other = (Giftattachment) object;
        return !((this.giftAttachmentID == null && other.giftAttachmentID != null) || (this.giftAttachmentID != null && !this.giftAttachmentID.equals(other.giftAttachmentID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Giftattachment[ giftAttachmentID=" + giftAttachmentID + " ]";
    }
    
}
