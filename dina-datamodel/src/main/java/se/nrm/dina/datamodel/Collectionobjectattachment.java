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
import javax.persistence.FetchType;
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
import javax.xml.bind.annotation.XmlTransient;
import se.nrm.dina.datamodel.util.Util;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "collectionobjectattachment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Collectionobjectattachment.findAll", query = "SELECT c FROM Collectionobjectattachment c"),
    @NamedQuery(name = "Collectionobjectattachment.findByCollectionObjectAttachmentID", query = "SELECT c FROM Collectionobjectattachment c WHERE c.collectionObjectAttachmentID = :collectionObjectAttachmentID"),
     @NamedQuery(name = "Collectionobjectattachment.findByCollectionMemberID", query = "SELECT c FROM Collectionobjectattachment c WHERE c.collectionMemberID = :collectionMemberID"),
    @NamedQuery(name = "Collectionobjectattachment.findByOrdinal", query = "SELECT c FROM Collectionobjectattachment c WHERE c.ordinal = :ordinal")})
public class Collectionobjectattachment extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CollectionObjectAttachmentID")
    private Integer collectionObjectAttachmentID;
    
    
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
    
    @JoinColumn(name = "CollectionObjectID", referencedColumnName = "CollectionObjectID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Collectionobject collectionObjectID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "AttachmentID", referencedColumnName = "AttachmentID")
    @ManyToOne(optional = false)
    private Attachment attachmentID;

    public Collectionobjectattachment() {
    }

    public Collectionobjectattachment(Integer collectionObjectAttachmentID) {
        this.collectionObjectAttachmentID = collectionObjectAttachmentID;
    }

    public Collectionobjectattachment(Integer collectionObjectAttachmentID, Date timestampCreated, int collectionMemberID, int ordinal) {
        this.collectionObjectAttachmentID = collectionObjectAttachmentID;
        this.timestampCreated = timestampCreated;
        this.collectionMemberID = collectionMemberID;
        this.ordinal = ordinal;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + collectionObjectAttachmentID;
    }
    
    @Override
    public int getEntityId() {
        return collectionObjectAttachmentID;
    }

    public Integer getCollectionObjectAttachmentID() {
        return collectionObjectAttachmentID;
    }

    public void setCollectionObjectAttachmentID(Integer collectionObjectAttachmentID) {
        this.collectionObjectAttachmentID = collectionObjectAttachmentID;
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

    @XmlTransient
    public Collectionobject getCollectionObjectID() {
        return collectionObjectID;
    }

    public void setCollectionObjectID(Collectionobject collectionObjectID) {
        this.collectionObjectID = collectionObjectID;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (collectionObjectAttachmentID != null ? collectionObjectAttachmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Collectionobjectattachment)) {
            return false;
        }
        Collectionobjectattachment other = (Collectionobjectattachment) object;
        return !((this.collectionObjectAttachmentID == null && other.collectionObjectAttachmentID != null) || (this.collectionObjectAttachmentID != null && !this.collectionObjectAttachmentID.equals(other.collectionObjectAttachmentID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Collectionobjectattachment[ collectionObjectAttachmentID=" + collectionObjectAttachmentID + " ]";
    }
    
}
