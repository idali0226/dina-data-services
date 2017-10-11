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
import javax.persistence.Lob;
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
@Table(name = "lithostrattreedef")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lithostrattreedef.findAll", query = "SELECT l FROM Lithostrattreedef l"),
    @NamedQuery(name = "Lithostrattreedef.findByLithoStratTreeDefID", query = "SELECT l FROM Lithostrattreedef l WHERE l.lithoStratTreeDefID = :lithoStratTreeDefID"), 
    @NamedQuery(name = "Lithostrattreedef.findByFullNameDirection", query = "SELECT l FROM Lithostrattreedef l WHERE l.fullNameDirection = :fullNameDirection"),
    @NamedQuery(name = "Lithostrattreedef.findByName", query = "SELECT l FROM Lithostrattreedef l WHERE l.name = :name")})
public class Lithostrattreedef extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LithoStratTreeDefID")
    private Integer lithoStratTreeDefID;
    
    
    @Column(name = "FullNameDirection")
    private Integer fullNameDirection;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "Name")
    private String name;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @OneToMany(mappedBy = "lithoStratTreeDefID", fetch = FetchType.LAZY)
    private List<Discipline> disciplineList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lithoStratTreeDefID", fetch = FetchType.LAZY)
    private List<Lithostrattreedefitem> lithostrattreedefitemList;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lithoStratTreeDefID", fetch = FetchType.LAZY)
    private List<Lithostrat> lithostratList;

    public Lithostrattreedef() {
    }

    public Lithostrattreedef(Integer lithoStratTreeDefID) {
        this.lithoStratTreeDefID = lithoStratTreeDefID;
    }

    public Lithostrattreedef(Integer lithoStratTreeDefID, Date timestampCreated, String name) {
        this.lithoStratTreeDefID = lithoStratTreeDefID;
        this.timestampCreated = timestampCreated;
        this.name = name;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + lithoStratTreeDefID;
    }
    
    @Override
    public int getEntityId() {
        return lithoStratTreeDefID;
    }

    public Integer getLithoStratTreeDefID() {
        return lithoStratTreeDefID;
    }

    public void setLithoStratTreeDefID(Integer lithoStratTreeDefID) {
        this.lithoStratTreeDefID = lithoStratTreeDefID;
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

    @XmlTransient
    public List<Discipline> getDisciplineList() {
        return disciplineList;
    }

    public void setDisciplineList(List<Discipline> disciplineList) {
        this.disciplineList = disciplineList;
    }

    @XmlTransient
    public List<Lithostrattreedefitem> getLithostrattreedefitemList() {
        return lithostrattreedefitemList;
    }

    public void setLithostrattreedefitemList(List<Lithostrattreedefitem> lithostrattreedefitemList) {
        this.lithostrattreedefitemList = lithostrattreedefitemList;
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
    public List<Lithostrat> getLithostratList() {
        return lithostratList;
    }

    public void setLithostratList(List<Lithostrat> lithostratList) {
        this.lithostratList = lithostratList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lithoStratTreeDefID != null ? lithoStratTreeDefID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lithostrattreedef)) {
            return false;
        }
        Lithostrattreedef other = (Lithostrattreedef) object;
        return !((this.lithoStratTreeDefID == null && other.lithoStratTreeDefID != null) || (this.lithoStratTreeDefID != null && !this.lithoStratTreeDefID.equals(other.lithoStratTreeDefID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Lithostrattreedef[ lithoStratTreeDefID=" + lithoStratTreeDefID + " ]";
    }
    
}
