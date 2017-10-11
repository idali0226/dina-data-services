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
@Table(name = "collectionrelationship")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Collectionrelationship.findAll", query = "SELECT c FROM Collectionrelationship c"),
    @NamedQuery(name = "Collectionrelationship.findByCollectionRelationshipID", query = "SELECT c FROM Collectionrelationship c WHERE c.collectionRelationshipID = :collectionRelationshipID")})
public class Collectionrelationship extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CollectionRelationshipID")
    private Integer collectionRelationshipID;
    
    
    @Size(max = 32)
    @Column(name = "Text1")
    private String text1;
    
    @Size(max = 32)
    @Column(name = "Text2")
    private String text2;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CollectionRelTypeID", referencedColumnName = "CollectionRelTypeID")
    @ManyToOne
    private Collectionreltype collectionRelTypeID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "LeftSideCollectionID", referencedColumnName = "CollectionObjectID")
    @ManyToOne(optional = false)
    private Collectionobject leftSideCollectionID;
    
    @JoinColumn(name = "RightSideCollectionID", referencedColumnName = "CollectionObjectID")
    @ManyToOne(optional = false)
    private Collectionobject rightSideCollectionID;

    public Collectionrelationship() {
    }

    public Collectionrelationship(Integer collectionRelationshipID) {
        this.collectionRelationshipID = collectionRelationshipID;
    }

    public Collectionrelationship(Integer collectionRelationshipID, Date timestampCreated) {
        this.collectionRelationshipID = collectionRelationshipID;
        this.timestampCreated = timestampCreated;
    }

    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + collectionRelationshipID;
    }
    
    @Override
    public int getEntityId() {
        return collectionRelationshipID;
    }
    
    public Integer getCollectionRelationshipID() {
        return collectionRelationshipID;
    }

    public void setCollectionRelationshipID(Integer collectionRelationshipID) {
        this.collectionRelationshipID = collectionRelationshipID;
    }
 

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    @XmlIDREF
    public Agent getModifiedByAgentID() {
        return modifiedByAgentID;
    }

    public void setModifiedByAgentID(Agent modifiedByAgentID) {
        this.modifiedByAgentID = modifiedByAgentID;
    }

    @XmlIDREF
    public Collectionreltype getCollectionRelTypeID() {
        return collectionRelTypeID;
    }

    public void setCollectionRelTypeID(Collectionreltype collectionRelTypeID) {
        this.collectionRelTypeID = collectionRelTypeID;
    }

    @XmlIDREF
    public Agent getCreatedByAgentID() {
        return createdByAgentID;
    }

    public void setCreatedByAgentID(Agent createdByAgentID) {
        this.createdByAgentID = createdByAgentID;
    }

    @XmlIDREF
    public Collectionobject getLeftSideCollectionID() {
        return leftSideCollectionID;
    }

    public void setLeftSideCollectionID(Collectionobject leftSideCollectionID) {
        this.leftSideCollectionID = leftSideCollectionID;
    }

    @XmlIDREF
    public Collectionobject getRightSideCollectionID() {
        return rightSideCollectionID;
    }

    public void setRightSideCollectionID(Collectionobject rightSideCollectionID) {
        this.rightSideCollectionID = rightSideCollectionID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (collectionRelationshipID != null ? collectionRelationshipID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Collectionrelationship)) {
            return false;
        }
        Collectionrelationship other = (Collectionrelationship) object;
        return !((this.collectionRelationshipID == null && other.collectionRelationshipID != null) || (this.collectionRelationshipID != null && !this.collectionRelationshipID.equals(other.collectionRelationshipID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Collectionrelationship[ collectionRelationshipID=" + collectionRelationshipID + " ]";
    }
    
}
