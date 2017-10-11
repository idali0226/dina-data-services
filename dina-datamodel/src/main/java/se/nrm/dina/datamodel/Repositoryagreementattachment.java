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
@Table(name = "repositoryagreementattachment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Repositoryagreementattachment.findAll", query = "SELECT r FROM Repositoryagreementattachment r"),
    @NamedQuery(name = "Repositoryagreementattachment.findByRepositoryAgreementAttachmentID", query = "SELECT r FROM Repositoryagreementattachment r WHERE r.repositoryAgreementAttachmentID = :repositoryAgreementAttachmentID"), 
    @NamedQuery(name = "Repositoryagreementattachment.findByOrdinal", query = "SELECT r FROM Repositoryagreementattachment r WHERE r.ordinal = :ordinal")})
public class Repositoryagreementattachment extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RepositoryAgreementAttachmentID")
    private Integer repositoryAgreementAttachmentID;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ordinal")
    private int ordinal;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @JoinColumn(name = "RepositoryAgreementID", referencedColumnName = "RepositoryAgreementID")
    @ManyToOne(optional = false)
    private Repositoryagreement repositoryAgreementID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "AttachmentID", referencedColumnName = "AttachmentID")
    @ManyToOne(optional = false)
    private Attachment attachmentID;

    public Repositoryagreementattachment() {
    }

    public Repositoryagreementattachment(Integer repositoryAgreementAttachmentID) {
        this.repositoryAgreementAttachmentID = repositoryAgreementAttachmentID;
    }

    public Repositoryagreementattachment(Integer repositoryAgreementAttachmentID, Date timestampCreated, int ordinal) {
        this.repositoryAgreementAttachmentID = repositoryAgreementAttachmentID;
        this.timestampCreated = timestampCreated;
        this.ordinal = ordinal;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + repositoryAgreementAttachmentID;
    }
    
    @Override
    public int getEntityId() {
        return repositoryAgreementAttachmentID;
    }

    public Integer getRepositoryAgreementAttachmentID() {
        return repositoryAgreementAttachmentID;
    }

    public void setRepositoryAgreementAttachmentID(Integer repositoryAgreementAttachmentID) {
        this.repositoryAgreementAttachmentID = repositoryAgreementAttachmentID;
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
    public Repositoryagreement getRepositoryAgreementID() {
        return repositoryAgreementID;
    }

    public void setRepositoryAgreementID(Repositoryagreement repositoryAgreementID) {
        this.repositoryAgreementID = repositoryAgreementID;
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
        hash += (repositoryAgreementAttachmentID != null ? repositoryAgreementAttachmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Repositoryagreementattachment)) {
            return false;
        }
        Repositoryagreementattachment other = (Repositoryagreementattachment) object;
        return !((this.repositoryAgreementAttachmentID == null && other.repositoryAgreementAttachmentID != null) || (this.repositoryAgreementAttachmentID != null && !this.repositoryAgreementAttachmentID.equals(other.repositoryAgreementAttachmentID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Repositoryagreementattachment[ repositoryAgreementAttachmentID=" + repositoryAgreementAttachmentID + " ]";
    }
    
}
