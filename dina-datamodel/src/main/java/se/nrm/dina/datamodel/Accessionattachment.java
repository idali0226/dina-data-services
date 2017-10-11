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
@Table(name = "accessionattachment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accessionattachment.findAll", query = "SELECT a FROM Accessionattachment a"),
    @NamedQuery(name = "Accessionattachment.findByAccessionAttachmentID", query = "SELECT a FROM Accessionattachment a WHERE a.accessionAttachmentID = :accessionAttachmentID"), 
    @NamedQuery(name = "Accessionattachment.findByOrdinal", query = "SELECT a FROM Accessionattachment a WHERE a.ordinal = :ordinal")})
public class Accessionattachment extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AccessionAttachmentID")
    private Integer accessionAttachmentID;

    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ordinal")
    private int ordinal;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @JoinColumn(name = "AccessionID", referencedColumnName = "AccessionID")
    @ManyToOne(optional = false )
    private Accession accessionID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "AttachmentID", referencedColumnName = "AttachmentID")
    @ManyToOne(optional = false)
    private Attachment attachmentID;

    public Accessionattachment() {
    }

    public Accessionattachment(Integer accessionAttachmentID) {
        this.accessionAttachmentID = accessionAttachmentID;
    }

    public Accessionattachment(Integer accessionAttachmentID, Date timestampCreated, int ordinal) {
        this.accessionAttachmentID = accessionAttachmentID;
        this.timestampCreated = timestampCreated;
        this.ordinal = ordinal;
    }

    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + accessionAttachmentID;
    }

    @XmlTransient
    @Override
    public int getEntityId() {
        return accessionAttachmentID;
    }


    public Integer getAccessionAttachmentID() {
        return accessionAttachmentID;
    }

    public void setAccessionAttachmentID(Integer accessionAttachmentID) {
        this.accessionAttachmentID = accessionAttachmentID;
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
    public Accession getAccessionID() {
        return accessionID;
    }

    public void setAccessionID(Accession accessionID) {
        this.accessionID = accessionID;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessionAttachmentID != null ? accessionAttachmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accessionattachment)) {
            return false;
        }
        Accessionattachment other = (Accessionattachment) object;
        return !((this.accessionAttachmentID == null && other.accessionAttachmentID != null) || (this.accessionAttachmentID != null && !this.accessionAttachmentID.equals(other.accessionAttachmentID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Accessionattachment[ accessionAttachmentID=" + accessionAttachmentID + " ]";
    }

    
}
