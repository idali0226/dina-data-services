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
@Table(name = "attachmenttag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attachmenttag.findAll", query = "SELECT a FROM Attachmenttag a"),
    @NamedQuery(name = "Attachmenttag.findByAttachmentTagID", query = "SELECT a FROM Attachmenttag a WHERE a.attachmentTagID = :attachmentTagID"), 
    @NamedQuery(name = "Attachmenttag.findByTag", query = "SELECT a FROM Attachmenttag a WHERE a.tag = :tag")})
public class Attachmenttag extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AttachmentTagID")
    private Integer attachmentTagID;

    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "Tag")
    private String tag;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "AttachmentID", referencedColumnName = "AttachmentID")
    @ManyToOne(optional = false)
    private Attachment attachmentID;

    public Attachmenttag() {
    }

    public Attachmenttag(Integer attachmentTagID) {
        this.attachmentTagID = attachmentTagID;
    }

    public Attachmenttag(Integer attachmentTagID, Date timestampCreated, String tag) {
        this.attachmentTagID = attachmentTagID;
        this.timestampCreated = timestampCreated;
        this.tag = tag;
    }

    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + attachmentTagID;
    }
    
    @Override
    public int getEntityId() {
        return attachmentTagID;
    }

    public Integer getAttachmentTagID() {
        return attachmentTagID;
    }

    public void setAttachmentTagID(Integer attachmentTagID) {
        this.attachmentTagID = attachmentTagID;
    }
 

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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
        hash += (attachmentTagID != null ? attachmentTagID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attachmenttag)) {
            return false;
        }
        Attachmenttag other = (Attachmenttag) object;
        return !((this.attachmentTagID == null && other.attachmentTagID != null) || (this.attachmentTagID != null && !this.attachmentTagID.equals(other.attachmentTagID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Attachmenttag[ attachmentTagID=" + attachmentTagID + " ]";
    }
    
}
