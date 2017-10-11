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
@Table(name = "spappresourcedata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spappresourcedata.findAll", query = "SELECT s FROM Spappresourcedata s"),
    @NamedQuery(name = "Spappresourcedata.findBySpAppResourceDataID", query = "SELECT s FROM Spappresourcedata s WHERE s.spAppResourceDataID = :spAppResourceDataID")})
public class Spappresourcedata extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SpAppResourceDataID")
    private Integer spAppResourceDataID;
    
    
    @Lob
    @Column(name = "data")
    private byte[] data;
    
    @JoinColumn(name = "SpViewSetObjID", referencedColumnName = "SpViewSetObjID")
    @ManyToOne
    private Spviewsetobj spViewSetObjID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "SpAppResourceID", referencedColumnName = "SpAppResourceID")
    @ManyToOne
    private Spappresource spAppResourceID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;

    public Spappresourcedata() {
    }

    public Spappresourcedata(Integer spAppResourceDataID) {
        this.spAppResourceDataID = spAppResourceDataID;
    }

    public Spappresourcedata(Integer spAppResourceDataID, Date timestampCreated) {
        this.spAppResourceDataID = spAppResourceDataID;
        this.timestampCreated = timestampCreated;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + spAppResourceDataID;
    }
    
    @Override
    public int getEntityId() {
        return spAppResourceDataID;
    }

    public Integer getSpAppResourceDataID() {
        return spAppResourceDataID;
    }

    public void setSpAppResourceDataID(Integer spAppResourceDataID) {
        this.spAppResourceDataID = spAppResourceDataID;
    }
  
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @XmlIDREF
    public Spviewsetobj getSpViewSetObjID() {
        return spViewSetObjID;
    }

    public void setSpViewSetObjID(Spviewsetobj spViewSetObjID) {
        this.spViewSetObjID = spViewSetObjID;
    }

    @XmlIDREF
    public Agent getModifiedByAgentID() {
        return modifiedByAgentID;
    }

    public void setModifiedByAgentID(Agent modifiedByAgentID) {
        this.modifiedByAgentID = modifiedByAgentID;
    }

    @XmlIDREF
    public Spappresource getSpAppResourceID() {
        return spAppResourceID;
    }

    public void setSpAppResourceID(Spappresource spAppResourceID) {
        this.spAppResourceID = spAppResourceID;
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
        hash += (spAppResourceDataID != null ? spAppResourceDataID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spappresourcedata)) {
            return false;
        }
        Spappresourcedata other = (Spappresourcedata) object;
        return !((this.spAppResourceDataID == null && other.spAppResourceDataID != null) || (this.spAppResourceDataID != null && !this.spAppResourceDataID.equals(other.spAppResourceDataID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Spappresourcedata[ spAppResourceDataID=" + spAppResourceDataID + " ]";
    }
    
}
