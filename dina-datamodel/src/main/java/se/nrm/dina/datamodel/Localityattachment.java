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
@Table(name = "localityattachment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localityattachment.findAll", query = "SELECT l FROM Localityattachment l"),
    @NamedQuery(name = "Localityattachment.findByLocalityAttachmentID", query = "SELECT l FROM Localityattachment l WHERE l.localityAttachmentID = :localityAttachmentID"), 
    @NamedQuery(name = "Localityattachment.findByOrdinal", query = "SELECT l FROM Localityattachment l WHERE l.ordinal = :ordinal")})
public class Localityattachment extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LocalityAttachmentID")
    private Integer localityAttachmentID;
    
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
    
    @JoinColumn(name = "LocalityID", referencedColumnName = "LocalityID")
    @ManyToOne(optional = false)
    private Locality localityID;
    
    @JoinColumn(name = "AttachmentID", referencedColumnName = "AttachmentID")
    @ManyToOne(optional = false)
    private Attachment attachmentID;

    public Localityattachment() {
    }

    public Localityattachment(Integer localityAttachmentID) {
        this.localityAttachmentID = localityAttachmentID;
    }

    public Localityattachment(Integer localityAttachmentID, Date timestampCreated, int ordinal) {
        this.localityAttachmentID = localityAttachmentID;
        this.timestampCreated = timestampCreated;
        this.ordinal = ordinal;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + localityAttachmentID;
    }
    
    @Override
    public int getEntityId() {
        return localityAttachmentID;
    }
    
    public Integer getLocalityAttachmentID() {
        return localityAttachmentID;
    }

    public void setLocalityAttachmentID(Integer localityAttachmentID) {
        this.localityAttachmentID = localityAttachmentID;
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
    public Locality getLocalityID() {
        return localityID;
    }

    public void setLocalityID(Locality localityID) {
        this.localityID = localityID;
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
        hash += (localityAttachmentID != null ? localityAttachmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localityattachment)) {
            return false;
        }
        Localityattachment other = (Localityattachment) object;
        return !((this.localityAttachmentID == null && other.localityAttachmentID != null) || (this.localityAttachmentID != null && !this.localityAttachmentID.equals(other.localityAttachmentID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Localityattachment[ localityAttachmentID=" + localityAttachmentID + " ]";
    }
    
}
