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
@Table(name = "picklistitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Picklistitem.findAll", query = "SELECT p FROM Picklistitem p"),
    @NamedQuery(name = "Picklistitem.findByPickListItemID", query = "SELECT p FROM Picklistitem p WHERE p.pickListItemID = :pickListItemID"), 
    @NamedQuery(name = "Picklistitem.findByOrdinal", query = "SELECT p FROM Picklistitem p WHERE p.ordinal = :ordinal"),
    @NamedQuery(name = "Picklistitem.findByTitle", query = "SELECT p FROM Picklistitem p WHERE p.title = :title"),
    @NamedQuery(name = "Picklistitem.findByValue", query = "SELECT p FROM Picklistitem p WHERE p.value = :value")})
public class Picklistitem extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PickListItemID")
    private Integer pickListItemID;
    
    
    @Column(name = "Ordinal")
    private Integer ordinal;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "Title")
    private String title;
    
    @Size(max = 64)
    @Column(name = "Value")
    private String value;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "PickListID", referencedColumnName = "PickListID")
    @ManyToOne(optional = false)
    private Picklist pickListID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;

    public Picklistitem() {
    }

    public Picklistitem(Integer pickListItemID) {
        this.pickListItemID = pickListItemID;
    }

    public Picklistitem(Integer pickListItemID, Date timestampCreated, String title) {
        this.pickListItemID = pickListItemID;
        this.timestampCreated = timestampCreated;
        this.title = title;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + pickListItemID;
    }
    
    @Override
    public int getEntityId() {
        return pickListItemID;
    }

    public Integer getPickListItemID() {
        return pickListItemID;
    }

    public void setPickListItemID(Integer pickListItemID) {
        this.pickListItemID = pickListItemID;
    }
 
    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @XmlIDREF
    public Agent getModifiedByAgentID() {
        return modifiedByAgentID;
    }

    public void setModifiedByAgentID(Agent modifiedByAgentID) {
        this.modifiedByAgentID = modifiedByAgentID;
    }

    @XmlIDREF
    public Picklist getPickListID() {
        return pickListID;
    }

    public void setPickListID(Picklist pickListID) {
        this.pickListID = pickListID;
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
        hash += (pickListItemID != null ? pickListItemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Picklistitem)) {
            return false;
        }
        Picklistitem other = (Picklistitem) object;
        return !((this.pickListItemID == null && other.pickListItemID != null) || (this.pickListItemID != null && !this.pickListItemID.equals(other.pickListItemID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Picklistitem[ pickListItemID=" + pickListItemID + " ]";
    }
    
}
