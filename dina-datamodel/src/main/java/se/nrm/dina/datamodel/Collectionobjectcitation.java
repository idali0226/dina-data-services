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
import javax.persistence.FetchType;
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
import javax.xml.bind.annotation.XmlTransient;
import se.nrm.dina.datamodel.util.Util;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "collectionobjectcitation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Collectionobjectcitation.findAll", query = "SELECT c FROM Collectionobjectcitation c"),
    @NamedQuery(name = "Collectionobjectcitation.findByCollectionObjectCitationID", query = "SELECT c FROM Collectionobjectcitation c WHERE c.collectionObjectCitationID = :collectionObjectCitationID"), 
    @NamedQuery(name = "Collectionobjectcitation.findByCollectionMemberID", query = "SELECT c FROM Collectionobjectcitation c WHERE c.collectionMemberID = :collectionMemberID"),
    @NamedQuery(name = "Collectionobjectcitation.findByIsFigured", query = "SELECT c FROM Collectionobjectcitation c WHERE c.isFigured = :isFigured")})
public class Collectionobjectcitation extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CollectionObjectCitationID")
    private Integer collectionObjectCitationID;
   
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CollectionMemberID")
    private int collectionMemberID;
    
    @Column(name = "IsFigured")
    private Boolean isFigured;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "ReferenceWorkID", referencedColumnName = "ReferenceWorkID")
    @ManyToOne(optional = false)
    private Referencework referenceWorkID;
    
    @JoinColumn(name = "CollectionObjectID", referencedColumnName = "CollectionObjectID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Collectionobject collectionObjectID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;

    public Collectionobjectcitation() {
    }

    public Collectionobjectcitation(Integer collectionObjectCitationID) {
        this.collectionObjectCitationID = collectionObjectCitationID;
    }

    public Collectionobjectcitation(Integer collectionObjectCitationID, Date timestampCreated, int collectionMemberID) {
        this.collectionObjectCitationID = collectionObjectCitationID;
        this.timestampCreated = timestampCreated;
        this.collectionMemberID = collectionMemberID;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + collectionObjectCitationID;
    }
    
    @Override
    public int getEntityId() {
        return collectionObjectCitationID;
    }

    public Integer getCollectionObjectCitationID() {
        return collectionObjectCitationID;
    }

    public void setCollectionObjectCitationID(Integer collectionObjectCitationID) {
        this.collectionObjectCitationID = collectionObjectCitationID;
    }
 
    public int getCollectionMemberID() {
        return collectionMemberID;
    }

    public void setCollectionMemberID(int collectionMemberID) {
        this.collectionMemberID = collectionMemberID;
    }

    public Boolean getIsFigured() {
        return isFigured;
    }

    public void setIsFigured(Boolean isFigured) {
        this.isFigured = isFigured;
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
    public Referencework getReferenceWorkID() {
        return referenceWorkID;
    }

    public void setReferenceWorkID(Referencework referenceWorkID) {
        this.referenceWorkID = referenceWorkID;
    }

    @XmlTransient
    public Collectionobject getCollectionObjectID() {
        return collectionObjectID;
    }

    public void setCollectionObjectID(Collectionobject collectionObjectID) {
        this.collectionObjectID = collectionObjectID;
    }

    @XmlIDREF
    public Agent getCreatedByAgentID() {
        return createdByAgentID;
    }

    public void setCreatedByAgentID(Agent createdByAgentID) {
        this.createdByAgentID = createdByAgentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (collectionObjectCitationID != null ? collectionObjectCitationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Collectionobjectcitation)) {
            return false;
        }
        Collectionobjectcitation other = (Collectionobjectcitation) object;
        return !((this.collectionObjectCitationID == null && other.collectionObjectCitationID != null) || (this.collectionObjectCitationID != null && !this.collectionObjectCitationID.equals(other.collectionObjectCitationID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Collectionobjectcitation[ collectionObjectCitationID=" + collectionObjectCitationID + " ]";
    }
    
}
