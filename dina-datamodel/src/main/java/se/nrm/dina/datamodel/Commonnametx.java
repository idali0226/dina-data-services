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
@Table(name = "commonnametx")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commonnametx.findAll", query = "SELECT c FROM Commonnametx c"),
    @NamedQuery(name = "Commonnametx.findByCommonNameTxID", query = "SELECT c FROM Commonnametx c WHERE c.commonNameTxID = :commonNameTxID"), 
    @NamedQuery(name = "Commonnametx.findByAuthor", query = "SELECT c FROM Commonnametx c WHERE c.author = :author"),
    @NamedQuery(name = "Commonnametx.findByCountry", query = "SELECT c FROM Commonnametx c WHERE c.country = :country"),
    @NamedQuery(name = "Commonnametx.findByLanguage", query = "SELECT c FROM Commonnametx c WHERE c.language = :language"),
    @NamedQuery(name = "Commonnametx.findByName", query = "SELECT c FROM Commonnametx c WHERE c.name = :name"),
    @NamedQuery(name = "Commonnametx.findByVariant", query = "SELECT c FROM Commonnametx c WHERE c.variant = :variant")})
public class Commonnametx extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CommonNameTxID")
    private Integer commonNameTxID;
    
    
    @Size(max = 128)
    @Column(name = "Author")
    private String author;
    
    @Size(max = 2)
    @Column(name = "Country")
    private String country;
    
    @Size(max = 2)
    @Column(name = "Language")
    private String language;
    
    @Size(max = 255)
    @Column(name = "Name")
    private String name;
    
    @Size(max = 2)
    @Column(name = "Variant")
    private String variant;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commonNameTxID", fetch = FetchType.LAZY)
    private List<Commonnametxcitation> commonnametxcitationList;
    
    @JoinColumn(name = "TaxonID", referencedColumnName = "TaxonID")
    @ManyToOne(optional = false)
    private Taxon taxonID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;

    public Commonnametx() {
    }

    public Commonnametx(Integer commonNameTxID) {
        this.commonNameTxID = commonNameTxID;
    }

    public Commonnametx(Integer commonNameTxID, Date timestampCreated) {
        this.commonNameTxID = commonNameTxID;
        this.timestampCreated = timestampCreated;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + commonNameTxID;
    }

    @Override
    public int getEntityId() {
        return commonNameTxID;
    }
    
    public Integer getCommonNameTxID() {
        return commonNameTxID;
    }

    public void setCommonNameTxID(Integer commonNameTxID) {
        this.commonNameTxID = commonNameTxID;
    }
 
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    @XmlTransient
    public List<Commonnametxcitation> getCommonnametxcitationList() {
        return commonnametxcitationList;
    }

    public void setCommonnametxcitationList(List<Commonnametxcitation> commonnametxcitationList) {
        this.commonnametxcitationList = commonnametxcitationList;
    }

    @XmlIDREF
    public Taxon getTaxonID() {
        return taxonID;
    }

    public void setTaxonID(Taxon taxonID) {
        this.taxonID = taxonID;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commonNameTxID != null ? commonNameTxID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commonnametx)) {
            return false;
        }
        Commonnametx other = (Commonnametx) object;
        return !((this.commonNameTxID == null && other.commonNameTxID != null) || (this.commonNameTxID != null && !this.commonNameTxID.equals(other.commonNameTxID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Commonnametx[ commonNameTxID=" + commonNameTxID + " ]";
    }
    
}
