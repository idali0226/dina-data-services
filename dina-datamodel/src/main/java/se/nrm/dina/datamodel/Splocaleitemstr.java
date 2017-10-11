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
@Table(name = "splocaleitemstr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Splocaleitemstr.findAll", query = "SELECT s FROM Splocaleitemstr s"),
    @NamedQuery(name = "Splocaleitemstr.findBySpLocaleItemStrID", query = "SELECT s FROM Splocaleitemstr s WHERE s.spLocaleItemStrID = :spLocaleItemStrID"), 
    @NamedQuery(name = "Splocaleitemstr.findByCountry", query = "SELECT s FROM Splocaleitemstr s WHERE s.country = :country"),
    @NamedQuery(name = "Splocaleitemstr.findByLanguage", query = "SELECT s FROM Splocaleitemstr s WHERE s.language = :language"),
    @NamedQuery(name = "Splocaleitemstr.findByText", query = "SELECT s FROM Splocaleitemstr s WHERE s.text = :text"),
    @NamedQuery(name = "Splocaleitemstr.findByVariant", query = "SELECT s FROM Splocaleitemstr s WHERE s.variant = :variant")})
public class Splocaleitemstr extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SpLocaleItemStrID")
    private Integer spLocaleItemStrID;
     
    @Size(max = 2)
    @Column(name = "Country")
    private String country;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Language")
    private String language;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Text")
    private String text;
    
    @Size(max = 2)
    @Column(name = "Variant")
    private String variant;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "SpLocaleContainerDescID", referencedColumnName = "SpLocaleContainerID")
    @ManyToOne
    private Splocalecontainer spLocaleContainerDescID;
    
    @JoinColumn(name = "SpLocaleContainerNameID", referencedColumnName = "SpLocaleContainerID")
    @ManyToOne
    private Splocalecontainer spLocaleContainerNameID;
    
    @JoinColumn(name = "SpLocaleContainerItemDescID", referencedColumnName = "SpLocaleContainerItemID")
    @ManyToOne
    private Splocalecontaineritem spLocaleContainerItemDescID;
    
    @JoinColumn(name = "SpLocaleContainerItemNameID", referencedColumnName = "SpLocaleContainerItemID")
    @ManyToOne
    private Splocalecontaineritem spLocaleContainerItemNameID;

    public Splocaleitemstr() {
    }

    public Splocaleitemstr(Integer spLocaleItemStrID) {
        this.spLocaleItemStrID = spLocaleItemStrID;
    }

    public Splocaleitemstr(Integer spLocaleItemStrID, Date timestampCreated, String language, String text) {
        this.spLocaleItemStrID = spLocaleItemStrID;
        this.timestampCreated = timestampCreated;
        this.language = language;
        this.text = text;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + spLocaleItemStrID;
    }
    
    @Override
    public int getEntityId() {
        return spLocaleItemStrID;
    }

    public Integer getSpLocaleItemStrID() {
        return spLocaleItemStrID;
    }

    public void setSpLocaleItemStrID(Integer spLocaleItemStrID) {
        this.spLocaleItemStrID = spLocaleItemStrID;
    }
 
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
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
    public Splocalecontainer getSpLocaleContainerDescID() {
        return spLocaleContainerDescID;
    }

    public void setSpLocaleContainerDescID(Splocalecontainer spLocaleContainerDescID) {
        this.spLocaleContainerDescID = spLocaleContainerDescID;
    }

    @XmlIDREF
    public Splocalecontainer getSpLocaleContainerNameID() {
        return spLocaleContainerNameID;
    }

    public void setSpLocaleContainerNameID(Splocalecontainer spLocaleContainerNameID) {
        this.spLocaleContainerNameID = spLocaleContainerNameID;
    }

    @XmlIDREF
    public Splocalecontaineritem getSpLocaleContainerItemDescID() {
        return spLocaleContainerItemDescID;
    }

    public void setSpLocaleContainerItemDescID(Splocalecontaineritem spLocaleContainerItemDescID) {
        this.spLocaleContainerItemDescID = spLocaleContainerItemDescID;
    }

    @XmlIDREF
    public Splocalecontaineritem getSpLocaleContainerItemNameID() {
        return spLocaleContainerItemNameID;
    }

    public void setSpLocaleContainerItemNameID(Splocalecontaineritem spLocaleContainerItemNameID) {
        this.spLocaleContainerItemNameID = spLocaleContainerItemNameID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (spLocaleItemStrID != null ? spLocaleItemStrID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Splocaleitemstr)) {
            return false;
        }
        Splocaleitemstr other = (Splocaleitemstr) object;
        return !((this.spLocaleItemStrID == null && other.spLocaleItemStrID != null) || (this.spLocaleItemStrID != null && !this.spLocaleItemStrID.equals(other.spLocaleItemStrID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Splocaleitemstr[ spLocaleItemStrID=" + spLocaleItemStrID + " ]";
    }
    
}
