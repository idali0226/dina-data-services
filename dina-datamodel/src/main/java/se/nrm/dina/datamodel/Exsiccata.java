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
@Table(name = "exsiccata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exsiccata.findAll", query = "SELECT e FROM Exsiccata e"),
    @NamedQuery(name = "Exsiccata.findByExsiccataID", query = "SELECT e FROM Exsiccata e WHERE e.exsiccataID = :exsiccataID"), 
    @NamedQuery(name = "Exsiccata.findByTitle", query = "SELECT e FROM Exsiccata e WHERE e.title = :title")})
public class Exsiccata extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ExsiccataID")
    private Integer exsiccataID;
    
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Title")
    private String title;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exsiccataID", fetch = FetchType.LAZY)
    private List<Exsiccataitem> exsiccataitemList;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "ReferenceWorkID", referencedColumnName = "ReferenceWorkID")
    @ManyToOne(optional = false)
    private Referencework referenceWorkID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;

    public Exsiccata() {
    }

    public Exsiccata(Integer exsiccataID) {
        this.exsiccataID = exsiccataID;
    }

    public Exsiccata(Integer exsiccataID, Date timestampCreated, String title) {
        this.exsiccataID = exsiccataID;
        this.timestampCreated = timestampCreated;
        this.title = title;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + exsiccataID;
    }
    
    @Override
    public int getEntityId() {
        return exsiccataID;
    }

    public Integer getExsiccataID() {
        return exsiccataID;
    }

    public void setExsiccataID(Integer exsiccataID) {
        this.exsiccataID = exsiccataID;
    }

   

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlTransient
    public List<Exsiccataitem> getExsiccataitemList() {
        return exsiccataitemList;
    }

    public void setExsiccataitemList(List<Exsiccataitem> exsiccataitemList) {
        this.exsiccataitemList = exsiccataitemList;
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
        hash += (exsiccataID != null ? exsiccataID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exsiccata)) {
            return false;
        }
        Exsiccata other = (Exsiccata) object;
        return !((this.exsiccataID == null && other.exsiccataID != null) || (this.exsiccataID != null && !this.exsiccataID.equals(other.exsiccataID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Exsiccata[ exsiccataID=" + exsiccataID + " ]";
    }
    
}
