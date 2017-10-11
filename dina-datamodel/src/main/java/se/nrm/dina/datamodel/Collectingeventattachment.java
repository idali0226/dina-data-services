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
@Table(name = "collectingeventattachment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Collectingeventattachment.findAll", query = "SELECT c FROM Collectingeventattachment c"),
    @NamedQuery(name = "Collectingeventattachment.findByCollectingEventAttachmentID", query = "SELECT c FROM Collectingeventattachment c WHERE c.collectingEventAttachmentID = :collectingEventAttachmentID"),
    @NamedQuery(name = "Collectingeventattachment.findByCollectionMemberID", query = "SELECT c FROM Collectingeventattachment c WHERE c.collectionMemberID = :collectionMemberID"),
    @NamedQuery(name = "Collectingeventattachment.findByOrdinal", query = "SELECT c FROM Collectingeventattachment c WHERE c.ordinal = :ordinal")})
public class Collectingeventattachment extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CollectingEventAttachmentID")
    private Integer collectingEventAttachmentID;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CollectionMemberID")
    private int collectionMemberID;
    
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
    
    @JoinColumn(name = "CollectingEventID", referencedColumnName = "CollectingEventID")
    @ManyToOne(optional = false)
    private Collectingevent collectingEventID;
    
    @JoinColumn(name = "AttachmentID", referencedColumnName = "AttachmentID")
    @ManyToOne(optional = false)
    private Attachment attachmentID;

    public Collectingeventattachment() {
    }

    public Collectingeventattachment(Integer collectingEventAttachmentID) {
        this.collectingEventAttachmentID = collectingEventAttachmentID;
    }

    public Collectingeventattachment(Integer collectingEventAttachmentID, Date timestampCreated, int collectionMemberID, int ordinal) {
        this.collectingEventAttachmentID = collectingEventAttachmentID;
        this.timestampCreated = timestampCreated;
        this.collectionMemberID = collectionMemberID;
        this.ordinal = ordinal;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + collectingEventAttachmentID;
    }
    
    @Override
    public int getEntityId() {
        return collectingEventAttachmentID;
    }
     
    public Integer getCollectingEventAttachmentID() {
        return collectingEventAttachmentID;
    }

    public void setCollectingEventAttachmentID(Integer collectingEventAttachmentID) {
        this.collectingEventAttachmentID = collectingEventAttachmentID;
    }
 

    public int getCollectionMemberID() {
        return collectionMemberID;
    }

    public void setCollectionMemberID(int collectionMemberID) {
        this.collectionMemberID = collectionMemberID;
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
    public Collectingevent getCollectingEventID() {
        return collectingEventID;
    }

    public void setCollectingEventID(Collectingevent collectingEventID) {
        this.collectingEventID = collectingEventID;
    }

    @XmlIDREF
    public Attachment getAttachmentID() {
        return attachmentID;
    }

    public void setAttachmentID(Attachment attachmentID) {
        this.attachmentID = attachmentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (collectingEventAttachmentID != null ? collectingEventAttachmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Collectingeventattachment)) {
            return false;
        }
        Collectingeventattachment other = (Collectingeventattachment) object;
        return !((this.collectingEventAttachmentID == null && other.collectingEventAttachmentID != null) || (this.collectingEventAttachmentID != null && !this.collectingEventAttachmentID.equals(other.collectingEventAttachmentID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Collectingeventattachment[ collectingEventAttachmentID=" + collectingEventAttachmentID + " ]";
    }
    
}
