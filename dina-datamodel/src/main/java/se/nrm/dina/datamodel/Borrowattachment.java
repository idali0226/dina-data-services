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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table; 
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import se.nrm.dina.datamodel.util.Util;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "borrowattachment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Borrowattachment.findAll", query = "SELECT b FROM Borrowattachment b"),
    @NamedQuery(name = "Borrowattachment.findByBorrowAttachmentID", query = "SELECT b FROM Borrowattachment b WHERE b.borrowAttachmentID = :borrowAttachmentID"),
    @NamedQuery(name = "Borrowattachment.findByBorrowID", query = "SELECT b FROM Borrowattachment b WHERE b.borrowID = :borrowID"),
    @NamedQuery(name = "Borrowattachment.findByAttachmentID", query = "SELECT b FROM Borrowattachment b WHERE b.attachmentID = :attachmentID")})
public class Borrowattachment extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BorrowAttachmentID")
    private Integer borrowAttachmentID;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ordinal")
    private int ordinal;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Column(name = "ModifiedByAgentID")
    private Integer modifiedByAgentID;
    
    @Column(name = "CreatedByAgentID")
    private Integer createdByAgentID;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "BorrowID")
    private int borrowID;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "AttachmentID")
    private int attachmentID;

    public Borrowattachment() {
    }

    public Borrowattachment(Integer borrowAttachmentID) {
        this.borrowAttachmentID = borrowAttachmentID;
    }

    public Borrowattachment(Integer borrowAttachmentID, Date timestampCreated, int ordinal, int borrowID, int attachmentID) {
        this.borrowAttachmentID = borrowAttachmentID;
        this.timestampCreated = timestampCreated;
        this.ordinal = ordinal;
        this.borrowID = borrowID;
        this.attachmentID = attachmentID;
    }

    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + borrowAttachmentID;
    }

    @Override
    public int getEntityId() {
        return borrowAttachmentID;
    }
    
    public Integer getBorrowAttachmentID() {
        return borrowAttachmentID;
    }

    public void setBorrowAttachmentID(Integer borrowAttachmentID) {
        this.borrowAttachmentID = borrowAttachmentID;
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

    public Integer getModifiedByAgentID() {
        return modifiedByAgentID;
    }

    public void setModifiedByAgentID(Integer modifiedByAgentID) {
        this.modifiedByAgentID = modifiedByAgentID;
    }

    public Integer getCreatedByAgentID() {
        return createdByAgentID;
    }

    public void setCreatedByAgentID(Integer createdByAgentID) {
        this.createdByAgentID = createdByAgentID;
    }

    public int getBorrowID() {
        return borrowID;
    }

    public void setBorrowID(int borrowID) {
        this.borrowID = borrowID;
    }

    public int getAttachmentID() {
        return attachmentID;
    }

    public void setAttachmentID(int attachmentID) {
        this.attachmentID = attachmentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (borrowAttachmentID != null ? borrowAttachmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Borrowattachment)) {
            return false;
        }
        Borrowattachment other = (Borrowattachment) object;
        return !((this.borrowAttachmentID == null && other.borrowAttachmentID != null) || (this.borrowAttachmentID != null && !this.borrowAttachmentID.equals(other.borrowAttachmentID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Borrowattachment[ borrowAttachmentID=" + borrowAttachmentID + " ]";
    }
    
}
