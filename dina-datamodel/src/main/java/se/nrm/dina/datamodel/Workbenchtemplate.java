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
@Table(name = "workbenchtemplate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Workbenchtemplate.findAll", query = "SELECT w FROM Workbenchtemplate w"),
    @NamedQuery(name = "Workbenchtemplate.findByWorkbenchTemplateID", query = "SELECT w FROM Workbenchtemplate w WHERE w.workbenchTemplateID = :workbenchTemplateID"), 
    @NamedQuery(name = "Workbenchtemplate.findByName", query = "SELECT w FROM Workbenchtemplate w WHERE w.name = :name"),
    @NamedQuery(name = "Workbenchtemplate.findBySrcFilePath", query = "SELECT w FROM Workbenchtemplate w WHERE w.srcFilePath = :srcFilePath")})
public class Workbenchtemplate extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "WorkbenchTemplateID")
    private Integer workbenchTemplateID;
    
    
    @Size(max = 64)
    @Column(name = "Name")
    private String name;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Size(max = 255)
    @Column(name = "SrcFilePath")
    private String srcFilePath;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workbenchTemplateID", fetch = FetchType.LAZY)
    private List<Workbenchtemplatemappingitem> workbenchtemplatemappingitemList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workbenchTemplateID", fetch = FetchType.LAZY)
    private List<Workbench> workbenchList;
    
    @JoinColumn(name = "SpecifyUserID", referencedColumnName = "SpecifyUserID")
    @ManyToOne(optional = false)
    private Specifyuser specifyUserID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @OneToMany(mappedBy = "workbenchTemplateID", fetch = FetchType.LAZY)
    private List<Spreport> spreportList;

    public Workbenchtemplate() {
    }

    public Workbenchtemplate(Integer workbenchTemplateID) {
        this.workbenchTemplateID = workbenchTemplateID;
    }

    public Workbenchtemplate(Integer workbenchTemplateID, Date timestampCreated) {
        this.workbenchTemplateID = workbenchTemplateID;
        this.timestampCreated = timestampCreated;
    }

    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + workbenchTemplateID;
    }
    
    @Override
    public int getEntityId() {
        return workbenchTemplateID;
    }
    
    public Integer getWorkbenchTemplateID() {
        return workbenchTemplateID;
    }

    public void setWorkbenchTemplateID(Integer workbenchTemplateID) {
        this.workbenchTemplateID = workbenchTemplateID;
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

    public String getSrcFilePath() {
        return srcFilePath;
    }

    public void setSrcFilePath(String srcFilePath) {
        this.srcFilePath = srcFilePath;
    }

    @XmlTransient
    public List<Workbenchtemplatemappingitem> getWorkbenchtemplatemappingitemList() {
        return workbenchtemplatemappingitemList;
    }

    public void setWorkbenchtemplatemappingitemList(List<Workbenchtemplatemappingitem> workbenchtemplatemappingitemList) {
        this.workbenchtemplatemappingitemList = workbenchtemplatemappingitemList;
    }

    @XmlTransient
    public List<Workbench> getWorkbenchList() {
        return workbenchList;
    }

    public void setWorkbenchList(List<Workbench> workbenchList) {
        this.workbenchList = workbenchList;
    }

    @XmlIDREF
    public Specifyuser getSpecifyUserID() {
        return specifyUserID;
    }

    public void setSpecifyUserID(Specifyuser specifyUserID) {
        this.specifyUserID = specifyUserID;
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
    public List<Spreport> getSpreportList() {
        return spreportList;
    }

    public void setSpreportList(List<Spreport> spreportList) {
        this.spreportList = spreportList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (workbenchTemplateID != null ? workbenchTemplateID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Workbenchtemplate)) {
            return false;
        }
        Workbenchtemplate other = (Workbenchtemplate) object;
        return !((this.workbenchTemplateID == null && other.workbenchTemplateID != null) || (this.workbenchTemplateID != null && !this.workbenchTemplateID.equals(other.workbenchTemplateID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Workbenchtemplate[ workbenchTemplateID=" + workbenchTemplateID + " ]";
    }
    
}
