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
@Table(name = "borrowagent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Borrowagent.findAll", query = "SELECT b FROM Borrowagent b"),
    @NamedQuery(name = "Borrowagent.findByBorrowAgentID", query = "SELECT b FROM Borrowagent b WHERE b.borrowAgentID = :borrowAgentID"), 
    @NamedQuery(name = "Borrowagent.findByCollectionMemberID", query = "SELECT b FROM Borrowagent b WHERE b.collectionMemberID = :collectionMemberID"),
    @NamedQuery(name = "Borrowagent.findByRole", query = "SELECT b FROM Borrowagent b WHERE b.role = :role")})
public class Borrowagent extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BorrowAgentID")
    private Integer borrowAgentID;
    
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CollectionMemberID")
    private int collectionMemberID;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "Role")
    private String role;
    
    @JoinColumn(name = "AgentID", referencedColumnName = "AgentID")
    @ManyToOne(optional = false)
    private Agent agentID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "BorrowID", referencedColumnName = "BorrowID")
    @ManyToOne(optional = false)
    private Borrow borrowID;

    public Borrowagent() {
    }

    public Borrowagent(Integer borrowAgentID) {
        this.borrowAgentID = borrowAgentID;
    }

    public Borrowagent(Integer borrowAgentID, Date timestampCreated, int collectionMemberID, String role) {
        this.borrowAgentID = borrowAgentID;
        this.timestampCreated = timestampCreated;
        this.collectionMemberID = collectionMemberID;
        this.role = role;
    }
    
       
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + borrowAgentID;
    }
    
    @Override
    public int getEntityId() {
        return borrowAgentID;
    }

    public Integer getBorrowAgentID() {
        return borrowAgentID;
    }

    public void setBorrowAgentID(Integer borrowAgentID) {
        this.borrowAgentID = borrowAgentID;
    }
 
    public int getCollectionMemberID() {
        return collectionMemberID;
    }

    public void setCollectionMemberID(int collectionMemberID) {
        this.collectionMemberID = collectionMemberID;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
    public Borrow getBorrowID() {
        return borrowID;
    }

    public void setBorrowID(Borrow borrowID) {
        this.borrowID = borrowID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (borrowAgentID != null ? borrowAgentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Borrowagent)) {
            return false;
        }
        Borrowagent other = (Borrowagent) object;
        return !((this.borrowAgentID == null && other.borrowAgentID != null) || (this.borrowAgentID != null && !this.borrowAgentID.equals(other.borrowAgentID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Borrowagent[ borrowAgentID=" + borrowAgentID + " ]";
    }
    
}
