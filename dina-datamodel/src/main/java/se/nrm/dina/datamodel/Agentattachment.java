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
@Table(name = "agentattachment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agentattachment.findAll", query = "SELECT a FROM Agentattachment a"),
    @NamedQuery(name = "Agentattachment.findByAgentAttachmentID", query = "SELECT a FROM Agentattachment a WHERE a.agentAttachmentID = :agentAttachmentID"), 
    @NamedQuery(name = "Agentattachment.findByOrdinal", query = "SELECT a FROM Agentattachment a WHERE a.ordinal = :ordinal")})
public class Agentattachment extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AgentAttachmentID")
    private Integer agentAttachmentID;
  
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ordinal")
    private int ordinal;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @JoinColumn(name = "AgentID", referencedColumnName = "AgentID")
    @ManyToOne(optional = false)
    private Agent agentID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "AttachmentID", referencedColumnName = "AttachmentID")
    @ManyToOne(optional = false)
    private Attachment attachmentID;

    public Agentattachment() {
    }

    public Agentattachment(Integer agentAttachmentID) {
        this.agentAttachmentID = agentAttachmentID;
    }

    public Agentattachment(Integer agentAttachmentID, Date timestampCreated, int ordinal) {
        this.agentAttachmentID = agentAttachmentID;
        this.timestampCreated = timestampCreated;
        this.ordinal = ordinal;
    }

    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + agentAttachmentID;
    }
    
    @Override
    public int getEntityId() {
        return agentAttachmentID;
    }

    public Integer getAgentAttachmentID() {
        return agentAttachmentID;
    }

    public void setAgentAttachmentID(Integer agentAttachmentID) {
        this.agentAttachmentID = agentAttachmentID;
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
    public Agent getAgentID() {
        return agentID;
    }

    public void setAgentID(Agent agentID) {
        this.agentID = agentID;
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
        hash += (agentAttachmentID != null ? agentAttachmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agentattachment)) {
            return false;
        }
        Agentattachment other = (Agentattachment) object;
        return !((this.agentAttachmentID == null && other.agentAttachmentID != null) || (this.agentAttachmentID != null && !this.agentAttachmentID.equals(other.agentAttachmentID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Agentattachment[ agentAttachmentID=" + agentAttachmentID + " ]";
    }
    
}
