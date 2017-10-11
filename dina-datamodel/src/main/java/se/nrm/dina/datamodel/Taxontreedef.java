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
@Table(name = "taxontreedef")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taxontreedef.findAll", query = "SELECT t FROM Taxontreedef t"),
    @NamedQuery(name = "Taxontreedef.findByTaxonTreeDefID", query = "SELECT t FROM Taxontreedef t WHERE t.taxonTreeDefID = :taxonTreeDefID"), 
    @NamedQuery(name = "Taxontreedef.findByFullNameDirection", query = "SELECT t FROM Taxontreedef t WHERE t.fullNameDirection = :fullNameDirection"),
    @NamedQuery(name = "Taxontreedef.findByName", query = "SELECT t FROM Taxontreedef t WHERE t.name = :name") })
public class Taxontreedef extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TaxonTreeDefID")
    private Integer taxonTreeDefID;
   
    @Column(name = "FullNameDirection")
    private Integer fullNameDirection;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "Name")
    private String name;
    
    @Size(max = 255)
    @Column(name = "Remarks")
    private String remarks;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @OneToMany(mappedBy = "taxonTreeDefID", fetch = FetchType.LAZY)
    private List<Discipline> disciplineList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taxonTreeDefID", fetch = FetchType.LAZY)
    private List<Taxon> taxonList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taxonTreeDefID", fetch = FetchType.LAZY)
    private List<Taxontreedefitem> taxontreedefitemList;

    public Taxontreedef() {
    }

    public Taxontreedef(Integer taxonTreeDefID) {
        this.taxonTreeDefID = taxonTreeDefID;
    }

    public Taxontreedef(Integer taxonTreeDefID, Date timestampCreated, String name) {
        this.taxonTreeDefID = taxonTreeDefID;
        this.timestampCreated = timestampCreated;
        this.name = name;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + taxonTreeDefID;
    }
    
    @Override
    public int getEntityId() {
        return taxonTreeDefID;
    }

    public Integer getTaxonTreeDefID() {
        return taxonTreeDefID;
    }

    public void setTaxonTreeDefID(Integer taxonTreeDefID) {
        this.taxonTreeDefID = taxonTreeDefID;
    }

    
    public Integer getFullNameDirection() {
        return fullNameDirection;
    }

    public void setFullNameDirection(Integer fullNameDirection) {
        this.fullNameDirection = fullNameDirection;
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

    @XmlTransient
    public List<Discipline> getDisciplineList() {
        return disciplineList;
    }

    public void setDisciplineList(List<Discipline> disciplineList) {
        this.disciplineList = disciplineList;
    }

    @XmlTransient
    public List<Taxon> getTaxonList() {
        return taxonList;
    }

    public void setTaxonList(List<Taxon> taxonList) {
        this.taxonList = taxonList;
    }

    @XmlTransient
    public List<Taxontreedefitem> getTaxontreedefitemList() {
        return taxontreedefitemList;
    }

    public void setTaxontreedefitemList(List<Taxontreedefitem> taxontreedefitemList) {
        this.taxontreedefitemList = taxontreedefitemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxonTreeDefID != null ? taxonTreeDefID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taxontreedef)) {
            return false;
        }
        Taxontreedef other = (Taxontreedef) object;
        return !((this.taxonTreeDefID == null && other.taxonTreeDefID != null) || (this.taxonTreeDefID != null && !this.taxonTreeDefID.equals(other.taxonTreeDefID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Taxontreedef[ taxonTreeDefID=" + taxonTreeDefID + " ]";
    }
    
}
