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
@Table(name = "latlonpolygon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Latlonpolygon.findAll", query = "SELECT l FROM Latlonpolygon l"),
    @NamedQuery(name = "Latlonpolygon.findByLatLonPolygonID", query = "SELECT l FROM Latlonpolygon l WHERE l.latLonPolygonID = :latLonPolygonID"), 
    @NamedQuery(name = "Latlonpolygon.findByIsPolyline", query = "SELECT l FROM Latlonpolygon l WHERE l.isPolyline = :isPolyline"),
    @NamedQuery(name = "Latlonpolygon.findByName", query = "SELECT l FROM Latlonpolygon l WHERE l.name = :name"),
    @NamedQuery(name = "Latlonpolygon.findBySpVisualQueryID", query = "SELECT l FROM Latlonpolygon l WHERE l.spVisualQueryID = :spVisualQueryID"),
    @NamedQuery(name = "Latlonpolygon.findByLocalityID", query = "SELECT l FROM Latlonpolygon l WHERE l.localityID = :localityID") })
public class Latlonpolygon extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LatLonPolygonID")
    private Integer latLonPolygonID;
    
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Description")
    private String description;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsPolyline")
    private boolean isPolyline;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "Name")
    private String name;
    
    @Column(name = "SpVisualQueryID")
    private Integer spVisualQueryID;
    
    @Column(name = "LocalityID")
    private Integer localityID;
    
    @Column(name = "CreatedByAgentID")
    private Integer createdByAgentID;
    
    @Column(name = "ModifiedByAgentID")
    private Integer modifiedByAgentID;

    public Latlonpolygon() {
    }

    public Latlonpolygon(Integer latLonPolygonID) {
        this.latLonPolygonID = latLonPolygonID;
    }

    public Latlonpolygon(Integer latLonPolygonID, Date timestampCreated, boolean isPolyline, String name) {
        this.latLonPolygonID = latLonPolygonID;
        this.timestampCreated = timestampCreated;
        this.isPolyline = isPolyline;
        this.name = name;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + latLonPolygonID;
    }
    
    @Override
    public int getEntityId() {
        return latLonPolygonID;
    }

    public Integer getLatLonPolygonID() {
        return latLonPolygonID;
    }

    public void setLatLonPolygonID(Integer latLonPolygonID) {
        this.latLonPolygonID = latLonPolygonID;
    }
 

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsPolyline() {
        return isPolyline;
    }

    public void setIsPolyline(boolean isPolyline) {
        this.isPolyline = isPolyline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSpVisualQueryID() {
        return spVisualQueryID;
    }

    public void setSpVisualQueryID(Integer spVisualQueryID) {
        this.spVisualQueryID = spVisualQueryID;
    }

    public Integer getLocalityID() {
        return localityID;
    }

    public void setLocalityID(Integer localityID) {
        this.localityID = localityID;
    }

    public Integer getCreatedByAgentID() {
        return createdByAgentID;
    }

    public void setCreatedByAgentID(Integer createdByAgentID) {
        this.createdByAgentID = createdByAgentID;
    }

    public Integer getModifiedByAgentID() {
        return modifiedByAgentID;
    }

    public void setModifiedByAgentID(Integer modifiedByAgentID) {
        this.modifiedByAgentID = modifiedByAgentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (latLonPolygonID != null ? latLonPolygonID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Latlonpolygon)) {
            return false;
        }
        Latlonpolygon other = (Latlonpolygon) object;
        return !((this.latLonPolygonID == null && other.latLonPolygonID != null) || (this.latLonPolygonID != null && !this.latLonPolygonID.equals(other.latLonPolygonID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Latlonpolygon[ latLonPolygonID=" + latLonPolygonID + " ]";
    }
    
}
