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
@Table(name = "dnasequencerunattachment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dnasequencerunattachment.findAll", query = "SELECT d FROM Dnasequencerunattachment d"),
    @NamedQuery(name = "Dnasequencerunattachment.findByDnaSequencingRunAttachmentId", query = "SELECT d FROM Dnasequencerunattachment d WHERE d.dnaSequencingRunAttachmentId = :dnaSequencingRunAttachmentId"), 
    @NamedQuery(name = "Dnasequencerunattachment.findByOrdinal", query = "SELECT d FROM Dnasequencerunattachment d WHERE d.ordinal = :ordinal")})
public class Dnasequencerunattachment extends  BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DnaSequencingRunAttachmentId")
    private Integer dnaSequencingRunAttachmentId;
    
    
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
    
    @JoinColumn(name = "DnaSequencingRunID", referencedColumnName = "DNASequencingRunID")
    @ManyToOne(optional = false)
    private Dnasequencingrun dnaSequencingRunID;
    
    @JoinColumn(name = "AttachmentID", referencedColumnName = "AttachmentID")
    @ManyToOne(optional = false)
    private Attachment attachmentID;

    public Dnasequencerunattachment() {
    }

    public Dnasequencerunattachment(Integer dnaSequencingRunAttachmentId) {
        this.dnaSequencingRunAttachmentId = dnaSequencingRunAttachmentId;
    }

    public Dnasequencerunattachment(Integer dnaSequencingRunAttachmentId, Date timestampCreated, int ordinal) {
        this.dnaSequencingRunAttachmentId = dnaSequencingRunAttachmentId;
        this.timestampCreated = timestampCreated;
        this.ordinal = ordinal;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + dnaSequencingRunAttachmentId;
    }
    
    @Override
    public int getEntityId() {
        return dnaSequencingRunAttachmentId;
    }

    public Integer getDnaSequencingRunAttachmentId() {
        return dnaSequencingRunAttachmentId;
    }

    public void setDnaSequencingRunAttachmentId(Integer dnaSequencingRunAttachmentId) {
        this.dnaSequencingRunAttachmentId = dnaSequencingRunAttachmentId;
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
    public Dnasequencingrun getDnaSequencingRunID() {
        return dnaSequencingRunID;
    }

    public void setDnaSequencingRunID(Dnasequencingrun dnaSequencingRunID) {
        this.dnaSequencingRunID = dnaSequencingRunID;
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
        hash += (dnaSequencingRunAttachmentId != null ? dnaSequencingRunAttachmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dnasequencerunattachment)) {
            return false;
        }
        Dnasequencerunattachment other = (Dnasequencerunattachment) object;
        return !((this.dnaSequencingRunAttachmentId == null && other.dnaSequencingRunAttachmentId != null) || (this.dnaSequencingRunAttachmentId != null && !this.dnaSequencingRunAttachmentId.equals(other.dnaSequencingRunAttachmentId)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Dnasequencerunattachment[ dnaSequencingRunAttachmentId=" + dnaSequencingRunAttachmentId + " ]";
    }
    
}
