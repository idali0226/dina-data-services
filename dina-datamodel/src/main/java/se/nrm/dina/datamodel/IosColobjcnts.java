/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.datamodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import se.nrm.dina.datamodel.util.Util;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "ios_colobjcnts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IosColobjcnts.findAll", query = "SELECT i FROM IosColobjcnts i"),
    @NamedQuery(name = "IosColobjcnts.findByOldID", query = "SELECT i FROM IosColobjcnts i WHERE i.oldID = :oldID"),
    @NamedQuery(name = "IosColobjcnts.findByNewID", query = "SELECT i FROM IosColobjcnts i WHERE i.newID = :newID")})
public class IosColobjcnts implements EntityBean, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OldID")
    private Integer oldID;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "NewID")
    private int newID;

    public IosColobjcnts() {
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + oldID;
    }
    
    @Override
    public int getEntityId() {
        return oldID;
    }

    public IosColobjcnts(Integer oldID) {
        this.oldID = oldID;
    }

    public IosColobjcnts(Integer oldID, int newID) {
        this.oldID = oldID;
        this.newID = newID;
    }

    public Integer getOldID() {
        return oldID;
    }

    public void setOldID(Integer oldID) {
        this.oldID = oldID;
    }

    public int getNewID() {
        return newID;
    }

    public void setNewID(int newID) {
        this.newID = newID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oldID != null ? oldID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IosColobjcnts)) {
            return false;
        }
        IosColobjcnts other = (IosColobjcnts) object;
        return !((this.oldID == null && other.oldID != null) || (this.oldID != null && !this.oldID.equals(other.oldID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.IosColobjcnts[ oldID=" + oldID + " ]";
    }
    
}
