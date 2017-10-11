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
@Table(name = "geographytreedef")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Geographytreedef.findAll", query = "SELECT g FROM Geographytreedef g"),
    @NamedQuery(name = "Geographytreedef.findByGeographyTreeDefID", query = "SELECT g FROM Geographytreedef g WHERE g.geographyTreeDefID = :geographyTreeDefID"), 
    @NamedQuery(name = "Geographytreedef.findByFullNameDirection", query = "SELECT g FROM Geographytreedef g WHERE g.fullNameDirection = :fullNameDirection"),
    @NamedQuery(name = "Geographytreedef.findByName", query = "SELECT g FROM Geographytreedef g WHERE g.name = :name")})
public class Geographytreedef extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GeographyTreeDefID")
    private Integer geographyTreeDefID;
    
    
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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "geographyTreeDefID", fetch = FetchType.LAZY)
    private List<Discipline> disciplineList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "geographyTreeDefID", fetch = FetchType.LAZY)
    private List<Geography> geographyList;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "geographyTreeDefID", fetch = FetchType.LAZY)
    private List<Geographytreedefitem> geographytreedefitemList;

    public Geographytreedef() {
    }

    public Geographytreedef(Integer geographyTreeDefID) {
        this.geographyTreeDefID = geographyTreeDefID;
    }

    public Geographytreedef(Integer geographyTreeDefID, Date timestampCreated, String name) {
        this.geographyTreeDefID = geographyTreeDefID;
        this.timestampCreated = timestampCreated;
        this.name = name;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + geographyTreeDefID;
    }
    
    @Override
    public int getEntityId() {
        return geographyTreeDefID;
    }

    public Integer getGeographyTreeDefID() {
        return geographyTreeDefID;
    }

    public void setGeographyTreeDefID(Integer geographyTreeDefID) {
        this.geographyTreeDefID = geographyTreeDefID;
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
    public List<Geography> getGeographyList() {
        return geographyList;
    }

    public void setGeographyList(List<Geography> geographyList) {
        this.geographyList = geographyList;
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
    public List<Geographytreedefitem> getGeographytreedefitemList() {
        return geographytreedefitemList;
    }

    public void setGeographytreedefitemList(List<Geographytreedefitem> geographytreedefitemList) {
        this.geographytreedefitemList = geographytreedefitemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (geographyTreeDefID != null ? geographyTreeDefID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Geographytreedef)) {
            return false;
        }
        Geographytreedef other = (Geographytreedef) object;
        return !((this.geographyTreeDefID == null && other.geographyTreeDefID != null) || (this.geographyTreeDefID != null && !this.geographyTreeDefID.equals(other.geographyTreeDefID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Geographytreedef[ geographyTreeDefID=" + geographyTreeDefID + " ]";
    }
    
}
