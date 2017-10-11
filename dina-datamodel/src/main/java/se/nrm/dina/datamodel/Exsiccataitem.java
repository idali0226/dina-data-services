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
@Table(name = "exsiccataitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exsiccataitem.findAll", query = "SELECT e FROM Exsiccataitem e"),
    @NamedQuery(name = "Exsiccataitem.findByExsiccataItemID", query = "SELECT e FROM Exsiccataitem e WHERE e.exsiccataItemID = :exsiccataItemID"), 
    @NamedQuery(name = "Exsiccataitem.findByFascicle", query = "SELECT e FROM Exsiccataitem e WHERE e.fascicle = :fascicle"),
    @NamedQuery(name = "Exsiccataitem.findByNumber", query = "SELECT e FROM Exsiccataitem e WHERE e.number = :number")})
public class Exsiccataitem extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ExsiccataItemID")
    private Integer exsiccataItemID;
    
    
    @Size(max = 16)
    @Column(name = "Fascicle")
    private String fascicle;
    
    @Size(max = 16)
    @Column(name = "Number")
    private String number;
    
    @JoinColumn(name = "ExsiccataID", referencedColumnName = "ExsiccataID")
    @ManyToOne(optional = false)
    private Exsiccata exsiccataID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CollectionObjectID", referencedColumnName = "CollectionObjectID")
    @ManyToOne(optional = false)
    private Collectionobject collectionObjectID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;

    public Exsiccataitem() {
    }

    public Exsiccataitem(Integer exsiccataItemID) {
        this.exsiccataItemID = exsiccataItemID;
    }

    public Exsiccataitem(Integer exsiccataItemID, Date timestampCreated) {
        this.exsiccataItemID = exsiccataItemID;
        this.timestampCreated = timestampCreated;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + exsiccataItemID;
    }

    @Override
    public int getEntityId() {
        return exsiccataItemID;
    }

    public Integer getExsiccataItemID() {
        return exsiccataItemID;
    }

    public void setExsiccataItemID(Integer exsiccataItemID) {
        this.exsiccataItemID = exsiccataItemID;
    }

 

    public String getFascicle() {
        return fascicle;
    }

    public void setFascicle(String fascicle) {
        this.fascicle = fascicle;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @XmlIDREF
    public Exsiccata getExsiccataID() {
        return exsiccataID;
    }

    public void setExsiccataID(Exsiccata exsiccataID) {
        this.exsiccataID = exsiccataID;
    }

    @XmlIDREF
    public Agent getModifiedByAgentID() {
        return modifiedByAgentID;
    }

    public void setModifiedByAgentID(Agent modifiedByAgentID) {
        this.modifiedByAgentID = modifiedByAgentID;
    }

    @XmlIDREF
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
        hash += (exsiccataItemID != null ? exsiccataItemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exsiccataitem)) {
            return false;
        }
        Exsiccataitem other = (Exsiccataitem) object;
        return !((this.exsiccataItemID == null && other.exsiccataItemID != null) || (this.exsiccataItemID != null && !this.exsiccataItemID.equals(other.exsiccataItemID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Exsiccataitem[ exsiccataItemID=" + exsiccataItemID + " ]";
    }
    
}
