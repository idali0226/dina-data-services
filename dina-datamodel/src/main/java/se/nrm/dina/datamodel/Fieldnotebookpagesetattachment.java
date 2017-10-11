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
@Table(name = "fieldnotebookpagesetattachment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fieldnotebookpagesetattachment.findAll", query = "SELECT f FROM Fieldnotebookpagesetattachment f"),
    @NamedQuery(name = "Fieldnotebookpagesetattachment.findByFieldNotebookPageSetAttachmentId", query = "SELECT f FROM Fieldnotebookpagesetattachment f WHERE f.fieldNotebookPageSetAttachmentId = :fieldNotebookPageSetAttachmentId"), 
    @NamedQuery(name = "Fieldnotebookpagesetattachment.findByOrdinal", query = "SELECT f FROM Fieldnotebookpagesetattachment f WHERE f.ordinal = :ordinal")})
public class Fieldnotebookpagesetattachment extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FieldNotebookPageSetAttachmentId")
    private Integer fieldNotebookPageSetAttachmentId;
    
    
    
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
    
    @JoinColumn(name = "FieldNotebookPageSetID", referencedColumnName = "FieldNotebookPageSetID")
    @ManyToOne(optional = false)
    private Fieldnotebookpageset fieldNotebookPageSetID;
    
    @JoinColumn(name = "AttachmentID", referencedColumnName = "AttachmentID")
    @ManyToOne(optional = false)
    private Attachment attachmentID;

    public Fieldnotebookpagesetattachment() {
    }

    public Fieldnotebookpagesetattachment(Integer fieldNotebookPageSetAttachmentId) {
        this.fieldNotebookPageSetAttachmentId = fieldNotebookPageSetAttachmentId;
    }

    public Fieldnotebookpagesetattachment(Integer fieldNotebookPageSetAttachmentId, Date timestampCreated, int ordinal) {
        this.fieldNotebookPageSetAttachmentId = fieldNotebookPageSetAttachmentId;
        this.timestampCreated = timestampCreated;
        this.ordinal = ordinal;
    }

    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + fieldNotebookPageSetAttachmentId;
    }
    
    @Override
    public int getEntityId() {
        return fieldNotebookPageSetAttachmentId;
    }
    
    public Integer getFieldNotebookPageSetAttachmentId() {
        return fieldNotebookPageSetAttachmentId;
    }

    public void setFieldNotebookPageSetAttachmentId(Integer fieldNotebookPageSetAttachmentId) {
        this.fieldNotebookPageSetAttachmentId = fieldNotebookPageSetAttachmentId;
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
    public Fieldnotebookpageset getFieldNotebookPageSetID() {
        return fieldNotebookPageSetID;
    }

    public void setFieldNotebookPageSetID(Fieldnotebookpageset fieldNotebookPageSetID) {
        this.fieldNotebookPageSetID = fieldNotebookPageSetID;
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
        hash += (fieldNotebookPageSetAttachmentId != null ? fieldNotebookPageSetAttachmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fieldnotebookpagesetattachment)) {
            return false;
        }
        Fieldnotebookpagesetattachment other = (Fieldnotebookpagesetattachment) object;
        return !((this.fieldNotebookPageSetAttachmentId == null && other.fieldNotebookPageSetAttachmentId != null) || (this.fieldNotebookPageSetAttachmentId != null && !this.fieldNotebookPageSetAttachmentId.equals(other.fieldNotebookPageSetAttachmentId)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Fieldnotebookpagesetattachment[ fieldNotebookPageSetAttachmentId=" + fieldNotebookPageSetAttachmentId + " ]";
    }
    
}
