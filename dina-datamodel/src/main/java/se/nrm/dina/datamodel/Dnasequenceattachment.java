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
@Table(name = "dnasequenceattachment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dnasequenceattachment.findAll", query = "SELECT d FROM Dnasequenceattachment d"),
    @NamedQuery(name = "Dnasequenceattachment.findByDnaSequenceAttachmentId", query = "SELECT d FROM Dnasequenceattachment d WHERE d.dnaSequenceAttachmentId = :dnaSequenceAttachmentId"), 
    @NamedQuery(name = "Dnasequenceattachment.findByOrdinal", query = "SELECT d FROM Dnasequenceattachment d WHERE d.ordinal = :ordinal")})
public class Dnasequenceattachment extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DnaSequenceAttachmentId")
    private Integer dnaSequenceAttachmentId;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ordinal")
    private int ordinal;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @JoinColumn(name = "DnaSequenceID", referencedColumnName = "DnaSequenceID")
    @ManyToOne(optional = false)
    private Dnasequence dnaSequenceID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "AttachmentID", referencedColumnName = "AttachmentID")
    @ManyToOne(optional = false)
    private Attachment attachmentID;

    public Dnasequenceattachment() {
    }

    public Dnasequenceattachment(Integer dnaSequenceAttachmentId) {
        this.dnaSequenceAttachmentId = dnaSequenceAttachmentId;
    }

    public Dnasequenceattachment(Integer dnaSequenceAttachmentId, Date timestampCreated, int ordinal) {
        this.dnaSequenceAttachmentId = dnaSequenceAttachmentId;
        this.timestampCreated = timestampCreated;
        this.ordinal = ordinal;
    }

    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + dnaSequenceAttachmentId;
    }
    
    @Override
    public int getEntityId() {
        return dnaSequenceAttachmentId;
    }
    
    public Integer getDnaSequenceAttachmentId() {
        return dnaSequenceAttachmentId;
    }

    public void setDnaSequenceAttachmentId(Integer dnaSequenceAttachmentId) {
        this.dnaSequenceAttachmentId = dnaSequenceAttachmentId;
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
    public Dnasequence getDnaSequenceID() {
        return dnaSequenceID;
    }

    public void setDnaSequenceID(Dnasequence dnaSequenceID) {
        this.dnaSequenceID = dnaSequenceID;
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
        hash += (dnaSequenceAttachmentId != null ? dnaSequenceAttachmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dnasequenceattachment)) {
            return false;
        }
        Dnasequenceattachment other = (Dnasequenceattachment) object;
        return !((this.dnaSequenceAttachmentId == null && other.dnaSequenceAttachmentId != null) || (this.dnaSequenceAttachmentId != null && !this.dnaSequenceAttachmentId.equals(other.dnaSequenceAttachmentId)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Dnasequenceattachment[ dnaSequenceAttachmentId=" + dnaSequenceAttachmentId + " ]";
    }
    
}
