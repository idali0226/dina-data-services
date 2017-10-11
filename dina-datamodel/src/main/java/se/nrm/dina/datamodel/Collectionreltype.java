/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.datamodel;
 
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "collectionreltype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Collectionreltype.findAll", query = "SELECT c FROM Collectionreltype c"),
    @NamedQuery(name = "Collectionreltype.findByCollectionRelTypeID", query = "SELECT c FROM Collectionreltype c WHERE c.collectionRelTypeID = :collectionRelTypeID"), 
    @NamedQuery(name = "Collectionreltype.findByName", query = "SELECT c FROM Collectionreltype c WHERE c.name = :name")})
public class Collectionreltype extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CollectionRelTypeID")
    private Integer collectionRelTypeID;
    
    
    @Size(max = 32)
    @Column(name = "Name")
    private String name;
    
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
    
    @JoinColumn(name = "LeftSideCollectionID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne
    private Collection leftSideCollectionID;
    
    @JoinColumn(name = "RightSideCollectionID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne
    private Collection rightSideCollectionID;
    
    @OneToMany(mappedBy = "collectionRelTypeID", fetch = FetchType.LAZY)
    private List<Collectionrelationship> collectionrelationshipList;

    public Collectionreltype() {
    }

    public Collectionreltype(Integer collectionRelTypeID) {
        this.collectionRelTypeID = collectionRelTypeID;
    }

    public Collectionreltype(Integer collectionRelTypeID, Date timestampCreated) {
        this.collectionRelTypeID = collectionRelTypeID;
        this.timestampCreated = timestampCreated;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + collectionRelTypeID;
    }
    
    @Override
    public int getEntityId() {
        return collectionRelTypeID;
    }

    public Integer getCollectionRelTypeID() {
        return collectionRelTypeID;
    }

    public void setCollectionRelTypeID(Integer collectionRelTypeID) {
        this.collectionRelTypeID = collectionRelTypeID;
    }
 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public Collection getLeftSideCollectionID() {
        return leftSideCollectionID;
    }

    public void setLeftSideCollectionID(Collection leftSideCollectionID) {
        this.leftSideCollectionID = leftSideCollectionID;
    }

    @XmlIDREF
    public Collection getRightSideCollectionID() {
        return rightSideCollectionID;
    }

    public void setRightSideCollectionID(Collection rightSideCollectionID) {
        this.rightSideCollectionID = rightSideCollectionID;
    }

    @XmlTransient
    public List<Collectionrelationship> getCollectionrelationshipList() {
        return collectionrelationshipList;
    }

    public void setCollectionrelationshipList(List<Collectionrelationship> collectionrelationshipList) {
        this.collectionrelationshipList = collectionrelationshipList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (collectionRelTypeID != null ? collectionRelTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Collectionreltype)) {
            return false;
        }
        Collectionreltype other = (Collectionreltype) object;
        return !((this.collectionRelTypeID == null && other.collectionRelTypeID != null) || (this.collectionRelTypeID != null && !this.collectionRelTypeID.equals(other.collectionRelTypeID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Collectionreltype[ collectionRelTypeID=" + collectionRelTypeID + " ]";
    }
    
}
