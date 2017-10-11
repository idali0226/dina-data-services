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
@Table(name = "datatype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datatype.findAll", query = "SELECT d FROM Datatype d"),
    @NamedQuery(name = "Datatype.findByDataTypeID", query = "SELECT d FROM Datatype d WHERE d.dataTypeID = :dataTypeID"), 
    @NamedQuery(name = "Datatype.findByName", query = "SELECT d FROM Datatype d WHERE d.name = :name")})
public class Datatype extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DataTypeID")
    private Integer dataTypeID;
    
    
    @Size(max = 50)
    @Column(name = "Name")
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dataTypeID", fetch = FetchType.LAZY)
    private List<Discipline> disciplineList;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;

    public Datatype() {
    }

    public Datatype(Integer dataTypeID) {
        this.dataTypeID = dataTypeID;
    }

    public Datatype(Integer dataTypeID, Date timestampCreated) {
        this.dataTypeID = dataTypeID;
        this.timestampCreated = timestampCreated;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + dataTypeID;
    }

    @Override
    public int getEntityId() {
        return dataTypeID;
    }
    
    public Integer getDataTypeID() {
        return dataTypeID;
    }

    public void setDataTypeID(Integer dataTypeID) {
        this.dataTypeID = dataTypeID;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Discipline> getDisciplineList() {
        return disciplineList;
    }

    public void setDisciplineList(List<Discipline> disciplineList) {
        this.disciplineList = disciplineList;
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
        hash += (dataTypeID != null ? dataTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datatype)) {
            return false;
        }
        Datatype other = (Datatype) object;
        return !((this.dataTypeID == null && other.dataTypeID != null) || (this.dataTypeID != null && !this.dataTypeID.equals(other.dataTypeID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Datatype[ dataTypeID=" + dataTypeID + " ]";
    }
    
}
