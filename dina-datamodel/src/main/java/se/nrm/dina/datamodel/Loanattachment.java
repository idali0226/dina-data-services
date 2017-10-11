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
@Table(name = "loanattachment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loanattachment.findAll", query = "SELECT l FROM Loanattachment l"),
    @NamedQuery(name = "Loanattachment.findByLoanAttachmentID", query = "SELECT l FROM Loanattachment l WHERE l.loanAttachmentID = :loanAttachmentID"), 
    @NamedQuery(name = "Loanattachment.findByOrdinal", query = "SELECT l FROM Loanattachment l WHERE l.ordinal = :ordinal")})
public class Loanattachment extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LoanAttachmentID")
    private Integer loanAttachmentID;
    
    
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
    
    @JoinColumn(name = "LoanID", referencedColumnName = "LoanID")
    @ManyToOne(optional = false)
    private Loan loanID;
    
    @JoinColumn(name = "AttachmentID", referencedColumnName = "AttachmentID")
    @ManyToOne(optional = false)
    private Attachment attachmentID;

    public Loanattachment() {
    }

    public Loanattachment(Integer loanAttachmentID) {
        this.loanAttachmentID = loanAttachmentID;
    }

    public Loanattachment(Integer loanAttachmentID, Date timestampCreated, int ordinal) {
        this.loanAttachmentID = loanAttachmentID;
        this.timestampCreated = timestampCreated;
        this.ordinal = ordinal;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + loanAttachmentID;
    }
    
    @Override
    public int getEntityId() {
        return loanAttachmentID;
    }

    public Integer getLoanAttachmentID() {
        return loanAttachmentID;
    }

    public void setLoanAttachmentID(Integer loanAttachmentID) {
        this.loanAttachmentID = loanAttachmentID;
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
    public Loan getLoanID() {
        return loanID;
    }

    public void setLoanID(Loan loanID) {
        this.loanID = loanID;
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
        hash += (loanAttachmentID != null ? loanAttachmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loanattachment)) {
            return false;
        }
        Loanattachment other = (Loanattachment) object;
        return !((this.loanAttachmentID == null && other.loanAttachmentID != null) || (this.loanAttachmentID != null && !this.loanAttachmentID.equals(other.loanAttachmentID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Loanattachment[ loanAttachmentID=" + loanAttachmentID + " ]";
    }
    
}
