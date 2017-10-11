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
@Table(name = "fieldnotebookpageset")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fieldnotebookpageset.findAll", query = "SELECT f FROM Fieldnotebookpageset f"),
    @NamedQuery(name = "Fieldnotebookpageset.findByFieldNotebookPageSetID", query = "SELECT f FROM Fieldnotebookpageset f WHERE f.fieldNotebookPageSetID = :fieldNotebookPageSetID"), 
    @NamedQuery(name = "Fieldnotebookpageset.findByDescription", query = "SELECT f FROM Fieldnotebookpageset f WHERE f.description = :description"),
    @NamedQuery(name = "Fieldnotebookpageset.findByEndDate", query = "SELECT f FROM Fieldnotebookpageset f WHERE f.endDate = :endDate"),
    @NamedQuery(name = "Fieldnotebookpageset.findByMethod", query = "SELECT f FROM Fieldnotebookpageset f WHERE f.method = :method"),
    @NamedQuery(name = "Fieldnotebookpageset.findByOrderNumber", query = "SELECT f FROM Fieldnotebookpageset f WHERE f.orderNumber = :orderNumber"),
    @NamedQuery(name = "Fieldnotebookpageset.findByStartDate", query = "SELECT f FROM Fieldnotebookpageset f WHERE f.startDate = :startDate")})
public class Fieldnotebookpageset extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FieldNotebookPageSetID")
    private Integer fieldNotebookPageSetID;
    
    
    @Size(max = 128)
    @Column(name = "Description")
    private String description;
    
    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    
    @Size(max = 64)
    @Column(name = "Method")
    private String method;
    
    @Column(name = "OrderNumber")
    private Short orderNumber;
    
    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    
    @JoinColumn(name = "AgentID", referencedColumnName = "AgentID")
    @ManyToOne
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
    
    @JoinColumn(name = "FieldNotebookID", referencedColumnName = "FieldNotebookID")
    @ManyToOne
    private Fieldnotebook fieldNotebookID;
    
    @OneToMany(mappedBy = "fieldNotebookPageSetID", fetch = FetchType.LAZY)
    private List<Fieldnotebookpage> fieldnotebookpageList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fieldNotebookPageSetID", fetch = FetchType.LAZY)
    private List<Fieldnotebookpagesetattachment> fieldnotebookpagesetattachmentList;

    public Fieldnotebookpageset() {
    }

    public Fieldnotebookpageset(Integer fieldNotebookPageSetID) {
        this.fieldNotebookPageSetID = fieldNotebookPageSetID;
    }

    public Fieldnotebookpageset(Integer fieldNotebookPageSetID, Date timestampCreated) {
        this.fieldNotebookPageSetID = fieldNotebookPageSetID;
        this.timestampCreated = timestampCreated;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + fieldNotebookPageSetID;
    }
    
    @Override
    public int getEntityId() {
        return fieldNotebookPageSetID;
    }

    public Integer getFieldNotebookPageSetID() {
        return fieldNotebookPageSetID;
    }

    public void setFieldNotebookPageSetID(Integer fieldNotebookPageSetID) {
        this.fieldNotebookPageSetID = fieldNotebookPageSetID;
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

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Short getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Short orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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
    public Fieldnotebook getFieldNotebookID() {
        return fieldNotebookID;
    }

    public void setFieldNotebookID(Fieldnotebook fieldNotebookID) {
        this.fieldNotebookID = fieldNotebookID;
    }

    @XmlTransient
    public List<Fieldnotebookpage> getFieldnotebookpageList() {
        return fieldnotebookpageList;
    }

    public void setFieldnotebookpageList(List<Fieldnotebookpage> fieldnotebookpageList) {
        this.fieldnotebookpageList = fieldnotebookpageList;
    }

    @XmlTransient
    public List<Fieldnotebookpagesetattachment> getFieldnotebookpagesetattachmentList() {
        return fieldnotebookpagesetattachmentList;
    }

    public void setFieldnotebookpagesetattachmentList(List<Fieldnotebookpagesetattachment> fieldnotebookpagesetattachmentList) {
        this.fieldnotebookpagesetattachmentList = fieldnotebookpagesetattachmentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fieldNotebookPageSetID != null ? fieldNotebookPageSetID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fieldnotebookpageset)) {
            return false;
        }
        Fieldnotebookpageset other = (Fieldnotebookpageset) object;
        return !((this.fieldNotebookPageSetID == null && other.fieldNotebookPageSetID != null) || (this.fieldNotebookPageSetID != null && !this.fieldNotebookPageSetID.equals(other.fieldNotebookPageSetID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Fieldnotebookpageset[ fieldNotebookPageSetID=" + fieldNotebookPageSetID + " ]";
    }
    
}
