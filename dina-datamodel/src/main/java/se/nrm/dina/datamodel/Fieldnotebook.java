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
import javax.persistence.Temporal;
import javax.persistence.TemporalType; 
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
@Table(name = "fieldnotebook")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fieldnotebook.findAll", query = "SELECT f FROM Fieldnotebook f"),
    @NamedQuery(name = "Fieldnotebook.findByFieldNotebookID", query = "SELECT f FROM Fieldnotebook f WHERE f.fieldNotebookID = :fieldNotebookID"), 
    @NamedQuery(name = "Fieldnotebook.findByEndDate", query = "SELECT f FROM Fieldnotebook f WHERE f.endDate = :endDate"),
    @NamedQuery(name = "Fieldnotebook.findByStorage", query = "SELECT f FROM Fieldnotebook f WHERE f.storage = :storage"),
    @NamedQuery(name = "Fieldnotebook.findByName", query = "SELECT f FROM Fieldnotebook f WHERE f.name = :name"),
    @NamedQuery(name = "Fieldnotebook.findByStartDate", query = "SELECT f FROM Fieldnotebook f WHERE f.startDate = :startDate")})
public class Fieldnotebook extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FieldNotebookID")
    private Integer fieldNotebookID;
    
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Description")
    private String description;
    
    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    
    @Size(max = 64)
    @Column(name = "Storage")
    private String storage;
    
    @Size(max = 32)
    @Column(name = "Name")
    private String name;
    
    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    
    @OneToMany(mappedBy = "fieldNotebookID", fetch = FetchType.LAZY)
    private List<Fieldnotebookpageset> fieldnotebookpagesetList;
    
    @JoinColumn(name = "AgentID", referencedColumnName = "AgentID")
    @ManyToOne(optional = false)
    private Agent agentID;
    
    @JoinColumn(name = "DisciplineID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne(optional = false)
    private Discipline disciplineID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "CollectionID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne(optional = false)
    private Collection collectionID;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fieldNotebookID", fetch = FetchType.LAZY)
    private List<Fieldnotebookattachment> fieldnotebookattachmentList;

    public Fieldnotebook() {
    }

    public Fieldnotebook(Integer fieldNotebookID) {
        this.fieldNotebookID = fieldNotebookID;
    }

    public Fieldnotebook(Integer fieldNotebookID, Date timestampCreated) {
        this.fieldNotebookID = fieldNotebookID;
        this.timestampCreated = timestampCreated;
    }

        
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + fieldNotebookID;
    }
    
    @Override
    public int getEntityId() {
        return fieldNotebookID;
    }
    
    public Integer getFieldNotebookID() {
        return fieldNotebookID;
    }

    public void setFieldNotebookID(Integer fieldNotebookID) {
        this.fieldNotebookID = fieldNotebookID;
    }

    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @XmlTransient
    public List<Fieldnotebookpageset> getFieldnotebookpagesetList() {
        return fieldnotebookpagesetList;
    }

    public void setFieldnotebookpagesetList(List<Fieldnotebookpageset> fieldnotebookpagesetList) {
        this.fieldnotebookpagesetList = fieldnotebookpagesetList;
    }

    @XmlIDREF
    public Agent getAgentID() {
        return agentID;
    }

    public void setAgentID(Agent agentID) {
        this.agentID = agentID;
    }

    @XmlIDREF
    public Discipline getDisciplineID() {
        return disciplineID;
    }

    public void setDisciplineID(Discipline disciplineID) {
        this.disciplineID = disciplineID;
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
    public Collection getCollectionID() {
        return collectionID;
    }

    public void setCollectionID(Collection collectionID) {
        this.collectionID = collectionID;
    }

    @XmlTransient
    public List<Fieldnotebookattachment> getFieldnotebookattachmentList() {
        return fieldnotebookattachmentList;
    }

    public void setFieldnotebookattachmentList(List<Fieldnotebookattachment> fieldnotebookattachmentList) {
        this.fieldnotebookattachmentList = fieldnotebookattachmentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fieldNotebookID != null ? fieldNotebookID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fieldnotebook)) {
            return false;
        }
        Fieldnotebook other = (Fieldnotebook) object;
        return !((this.fieldNotebookID == null && other.fieldNotebookID != null) || (this.fieldNotebookID != null && !this.fieldNotebookID.equals(other.fieldNotebookID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Fieldnotebook[ fieldNotebookID=" + fieldNotebookID + " ]";
    }
    
}
