/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.datamodel;
 
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table; 
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import se.nrm.dina.datamodel.util.Util;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "borrowmaterial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Borrowmaterial.findAll", query = "SELECT b FROM Borrowmaterial b"),
    @NamedQuery(name = "Borrowmaterial.findByBorrowMaterialID", query = "SELECT b FROM Borrowmaterial b WHERE b.borrowMaterialID = :borrowMaterialID"),
    @NamedQuery(name = "Borrowmaterial.findByCollectionMemberID", query = "SELECT b FROM Borrowmaterial b WHERE b.collectionMemberID = :collectionMemberID"),
    @NamedQuery(name = "Borrowmaterial.findByDescription", query = "SELECT b FROM Borrowmaterial b WHERE b.description = :description"), 
    @NamedQuery(name = "Borrowmaterial.findByQuantityResolved", query = "SELECT b FROM Borrowmaterial b WHERE b.quantityResolved = :quantityResolved"),
    @NamedQuery(name = "Borrowmaterial.findByQuantityReturned", query = "SELECT b FROM Borrowmaterial b WHERE b.quantityReturned = :quantityReturned")})
public class Borrowmaterial extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BorrowMaterialID")
    private Integer borrowMaterialID;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CollectionMemberID")
    private int collectionMemberID;
    
    @Size(max = 50)
    @Column(name = "Description")
    private String description;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "InComments")
    private String inComments;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MaterialNumber")
    private String materialNumber;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "OutComments")
    private String outComments;
    
    @Column(name = "Quantity")
    private Short quantity;
    
    @Column(name = "QuantityResolved")
    private Short quantityResolved;
    
    @Column(name = "QuantityReturned")
    private Short quantityReturned;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "BorrowID", referencedColumnName = "BorrowID")
    @ManyToOne(optional = false)
    private Borrow borrowID;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "borrowMaterialID", fetch = FetchType.LAZY)
    private List<Borrowreturnmaterial> borrowreturnmaterialList;

    public Borrowmaterial() {
    }

    public Borrowmaterial(Integer borrowMaterialID) {
        this.borrowMaterialID = borrowMaterialID;
    }

    public Borrowmaterial(Integer borrowMaterialID, Date timestampCreated, int collectionMemberID, String materialNumber) {
        this.borrowMaterialID = borrowMaterialID;
        this.timestampCreated = timestampCreated;
        this.collectionMemberID = collectionMemberID;
        this.materialNumber = materialNumber;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + borrowMaterialID;
    }

    @Override
    public int getEntityId() {
        return borrowMaterialID;
    }
    
    public Integer getBorrowMaterialID() {
        return borrowMaterialID;
    }

    public void setBorrowMaterialID(Integer borrowMaterialID) {
        this.borrowMaterialID = borrowMaterialID;
    }
 
    public int getCollectionMemberID() {
        return collectionMemberID;
    }

    public void setCollectionMemberID(int collectionMemberID) {
        this.collectionMemberID = collectionMemberID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInComments() {
        return inComments;
    }

    public void setInComments(String inComments) {
        this.inComments = inComments;
    }

    public String getMaterialNumber() {
        return materialNumber;
    }

    public void setMaterialNumber(String materialNumber) {
        this.materialNumber = materialNumber;
    }

    public String getOutComments() {
        return outComments;
    }

    public void setOutComments(String outComments) {
        this.outComments = outComments;
    }

    public Short getQuantity() {
        return quantity;
    }

    public void setQuantity(Short quantity) {
        this.quantity = quantity;
    }

    public Short getQuantityResolved() {
        return quantityResolved;
    }

    public void setQuantityResolved(Short quantityResolved) {
        this.quantityResolved = quantityResolved;
    }

    public Short getQuantityReturned() {
        return quantityReturned;
    }

    public void setQuantityReturned(Short quantityReturned) {
        this.quantityReturned = quantityReturned;
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

    @XmlTransient
    public List<Borrowreturnmaterial> getBorrowreturnmaterialList() {
        return borrowreturnmaterialList;
    }

    public void setBorrowreturnmaterialList(List<Borrowreturnmaterial> borrowreturnmaterialList) {
        this.borrowreturnmaterialList = borrowreturnmaterialList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (borrowMaterialID != null ? borrowMaterialID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Borrowmaterial)) {
            return false;
        }
        Borrowmaterial other = (Borrowmaterial) object;
        return !((this.borrowMaterialID == null && other.borrowMaterialID != null) || (this.borrowMaterialID != null && !this.borrowMaterialID.equals(other.borrowMaterialID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Borrowmaterial[ borrowMaterialID=" + borrowMaterialID + " ]";
    }
    
}
