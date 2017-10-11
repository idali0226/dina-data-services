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
@Table(name = "geologictimeperiodtreedef")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Geologictimeperiodtreedef.findAll", query = "SELECT g FROM Geologictimeperiodtreedef g"),
    @NamedQuery(name = "Geologictimeperiodtreedef.findByGeologicTimePeriodTreeDefID", query = "SELECT g FROM Geologictimeperiodtreedef g WHERE g.geologicTimePeriodTreeDefID = :geologicTimePeriodTreeDefID"), 
    @NamedQuery(name = "Geologictimeperiodtreedef.findByFullNameDirection", query = "SELECT g FROM Geologictimeperiodtreedef g WHERE g.fullNameDirection = :fullNameDirection"),
    @NamedQuery(name = "Geologictimeperiodtreedef.findByName", query = "SELECT g FROM Geologictimeperiodtreedef g WHERE g.name = :name")})
public class Geologictimeperiodtreedef extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GeologicTimePeriodTreeDefID")
    private Integer geologicTimePeriodTreeDefID;
    
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
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "geologicTimePeriodTreeDefID", fetch = FetchType.LAZY)
    private List<Discipline> disciplineList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "geologicTimePeriodTreeDefID", fetch = FetchType.LAZY)
    private List<Geologictimeperiod> geologictimeperiodList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "geologicTimePeriodTreeDefID", fetch = FetchType.LAZY)
    private List<Geologictimeperiodtreedefitem> geologictimeperiodtreedefitemList;

    public Geologictimeperiodtreedef() {
    }

    public Geologictimeperiodtreedef(Integer geologicTimePeriodTreeDefID) {
        this.geologicTimePeriodTreeDefID = geologicTimePeriodTreeDefID;
    }

    public Geologictimeperiodtreedef(Integer geologicTimePeriodTreeDefID, Date timestampCreated, String name) {
        this.geologicTimePeriodTreeDefID = geologicTimePeriodTreeDefID;
        this.timestampCreated = timestampCreated;
        this.name = name;
    }

    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + geologicTimePeriodTreeDefID;
    }
    
    @Override
    public int getEntityId() {
        return geologicTimePeriodTreeDefID;
    }
    
    public Integer getGeologicTimePeriodTreeDefID() {
        return geologicTimePeriodTreeDefID;
    }

    public void setGeologicTimePeriodTreeDefID(Integer geologicTimePeriodTreeDefID) {
        this.geologicTimePeriodTreeDefID = geologicTimePeriodTreeDefID;
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
    public List<Geologictimeperiod> getGeologictimeperiodList() {
        return geologictimeperiodList;
    }

    public void setGeologictimeperiodList(List<Geologictimeperiod> geologictimeperiodList) {
        this.geologictimeperiodList = geologictimeperiodList;
    }

    @XmlTransient
    public List<Geologictimeperiodtreedefitem> getGeologictimeperiodtreedefitemList() {
        return geologictimeperiodtreedefitemList;
    }

    public void setGeologictimeperiodtreedefitemList(List<Geologictimeperiodtreedefitem> geologictimeperiodtreedefitemList) {
        this.geologictimeperiodtreedefitemList = geologictimeperiodtreedefitemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (geologicTimePeriodTreeDefID != null ? geologicTimePeriodTreeDefID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Geologictimeperiodtreedef)) {
            return false;
        }
        Geologictimeperiodtreedef other = (Geologictimeperiodtreedef) object;
        return !((this.geologicTimePeriodTreeDefID == null && other.geologicTimePeriodTreeDefID != null) || (this.geologicTimePeriodTreeDefID != null && !this.geologicTimePeriodTreeDefID.equals(other.geologicTimePeriodTreeDefID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Geologictimeperiodtreedef[ geologicTimePeriodTreeDefID=" + geologicTimePeriodTreeDefID + " ]";
    }
    
}
