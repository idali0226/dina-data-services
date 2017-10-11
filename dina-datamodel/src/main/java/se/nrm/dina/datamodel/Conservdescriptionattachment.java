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
@Table(name = "conservdescriptionattachment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conservdescriptionattachment.findAll", query = "SELECT c FROM Conservdescriptionattachment c"),
    @NamedQuery(name = "Conservdescriptionattachment.findByConservDescriptionAttachmentID", query = "SELECT c FROM Conservdescriptionattachment c WHERE c.conservDescriptionAttachmentID = :conservDescriptionAttachmentID"), 
    @NamedQuery(name = "Conservdescriptionattachment.findByOrdinal", query = "SELECT c FROM Conservdescriptionattachment c WHERE c.ordinal = :ordinal")})
public class Conservdescriptionattachment extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ConservDescriptionAttachmentID")
    private Integer conservDescriptionAttachmentID;

    
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
    
    @JoinColumn(name = "ConservDescriptionID", referencedColumnName = "ConservDescriptionID")
    @ManyToOne(optional = false)
    private Conservdescription conservDescriptionID;
    
    @JoinColumn(name = "AttachmentID", referencedColumnName = "AttachmentID")
    @ManyToOne(optional = false)
    private Attachment attachmentID;

    public Conservdescriptionattachment() {
    }

    public Conservdescriptionattachment(Integer conservDescriptionAttachmentID) {
        this.conservDescriptionAttachmentID = conservDescriptionAttachmentID;
    }

    public Conservdescriptionattachment(Integer conservDescriptionAttachmentID, Date timestampCreated, int ordinal) {
        this.conservDescriptionAttachmentID = conservDescriptionAttachmentID;
        this.timestampCreated = timestampCreated;
        this.ordinal = ordinal;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + conservDescriptionAttachmentID;
    }
    
    @Override
    public int getEntityId() {
        return conservDescriptionAttachmentID;
    }

    public Integer getConservDescriptionAttachmentID() {
        return conservDescriptionAttachmentID;
    }

    public void setConservDescriptionAttachmentID(Integer conservDescriptionAttachmentID) {
        this.conservDescriptionAttachmentID = conservDescriptionAttachmentID;
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
    public Conservdescription getConservDescriptionID() {
        return conservDescriptionID;
    }

    public void setConservDescriptionID(Conservdescription conservDescriptionID) {
        this.conservDescriptionID = conservDescriptionID;
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
        hash += (conservDescriptionAttachmentID != null ? conservDescriptionAttachmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conservdescriptionattachment)) {
            return false;
        }
        Conservdescriptionattachment other = (Conservdescriptionattachment) object;
        return !((this.conservDescriptionAttachmentID == null && other.conservDescriptionAttachmentID != null) || (this.conservDescriptionAttachmentID != null && !this.conservDescriptionAttachmentID.equals(other.conservDescriptionAttachmentID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Conservdescriptionattachment[ conservDescriptionAttachmentID=" + conservDescriptionAttachmentID + " ]";
    }
    
}
