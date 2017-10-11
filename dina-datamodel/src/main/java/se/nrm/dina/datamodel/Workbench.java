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
@Table(name = "workbench")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Workbench.findAll", query = "SELECT w FROM Workbench w"),
    @NamedQuery(name = "Workbench.findByWorkbenchID", query = "SELECT w FROM Workbench w WHERE w.workbenchID = :workbenchID"), 
    @NamedQuery(name = "Workbench.findByAllPermissionLevel", query = "SELECT w FROM Workbench w WHERE w.allPermissionLevel = :allPermissionLevel"),
    @NamedQuery(name = "Workbench.findByTableID", query = "SELECT w FROM Workbench w WHERE w.tableID = :tableID"),
    @NamedQuery(name = "Workbench.findByExportInstitutionName", query = "SELECT w FROM Workbench w WHERE w.exportInstitutionName = :exportInstitutionName"),
    @NamedQuery(name = "Workbench.findByFormId", query = "SELECT w FROM Workbench w WHERE w.formId = :formId"),
    @NamedQuery(name = "Workbench.findByGroupPermissionLevel", query = "SELECT w FROM Workbench w WHERE w.groupPermissionLevel = :groupPermissionLevel"),
    @NamedQuery(name = "Workbench.findByLockedByUserName", query = "SELECT w FROM Workbench w WHERE w.lockedByUserName = :lockedByUserName"),
    @NamedQuery(name = "Workbench.findByName", query = "SELECT w FROM Workbench w WHERE w.name = :name"),
    @NamedQuery(name = "Workbench.findByOwnerPermissionLevel", query = "SELECT w FROM Workbench w WHERE w.ownerPermissionLevel = :ownerPermissionLevel"),
    @NamedQuery(name = "Workbench.findBySrcFilePath", query = "SELECT w FROM Workbench w WHERE w.srcFilePath = :srcFilePath"),
    @NamedQuery(name = "Workbench.findByExportedFromTableName", query = "SELECT w FROM Workbench w WHERE w.exportedFromTableName = :exportedFromTableName")})
public class Workbench extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "WorkbenchID")
    private Integer workbenchID;
    
    
    @Column(name = "AllPermissionLevel")
    private Integer allPermissionLevel;
    
    @Column(name = "TableID")
    private Integer tableID;
    
    @Size(max = 128)
    @Column(name = "ExportInstitutionName")
    private String exportInstitutionName;
    
    @Column(name = "FormId")
    private Integer formId;
    
    @Column(name = "GroupPermissionLevel")
    private Integer groupPermissionLevel;
    
    @Size(max = 64)
    @Column(name = "LockedByUserName")
    private String lockedByUserName;
    
    @Size(max = 64)
    @Column(name = "Name")
    private String name;
    
    @Column(name = "OwnerPermissionLevel")
    private Integer ownerPermissionLevel;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Size(max = 255)
    @Column(name = "SrcFilePath")
    private String srcFilePath;
    
    @Size(max = 128)
    @Column(name = "ExportedFromTableName")
    private String exportedFromTableName;
    
    @JoinColumn(name = "SpecifyUserID", referencedColumnName = "SpecifyUserID")
    @ManyToOne(optional = false)
    private Specifyuser specifyUserID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "WorkbenchTemplateID", referencedColumnName = "WorkbenchTemplateID")
    @ManyToOne(optional = false)
    private Workbenchtemplate workbenchTemplateID;
    
    @JoinColumn(name = "SpPrincipalID", referencedColumnName = "SpPrincipalID")
    @ManyToOne
    private Spprincipal spPrincipalID;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workbenchID", fetch = FetchType.LAZY)
    private List<Workbenchrow> workbenchrowList;

    public Workbench() {
    }

    public Workbench(Integer workbenchID) {
        this.workbenchID = workbenchID;
    }

    public Workbench(Integer workbenchID, Date timestampCreated) {
        this.workbenchID = workbenchID;
        this.timestampCreated = timestampCreated;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + workbenchID;
    }
    
    @Override
    public int getEntityId() {
        return workbenchID;
    }

    public Integer getWorkbenchID() {
        return workbenchID;
    }

    public void setWorkbenchID(Integer workbenchID) {
        this.workbenchID = workbenchID;
    }
 

    public Integer getAllPermissionLevel() {
        return allPermissionLevel;
    }

    public void setAllPermissionLevel(Integer allPermissionLevel) {
        this.allPermissionLevel = allPermissionLevel;
    }

    public Integer getTableID() {
        return tableID;
    }

    public void setTableID(Integer tableID) {
        this.tableID = tableID;
    }

    public String getExportInstitutionName() {
        return exportInstitutionName;
    }

    public void setExportInstitutionName(String exportInstitutionName) {
        this.exportInstitutionName = exportInstitutionName;
    }

    public Integer getFormId() {
        return formId;
    }

    public void setFormId(Integer formId) {
        this.formId = formId;
    }

    public Integer getGroupPermissionLevel() {
        return groupPermissionLevel;
    }

    public void setGroupPermissionLevel(Integer groupPermissionLevel) {
        this.groupPermissionLevel = groupPermissionLevel;
    }

    public String getLockedByUserName() {
        return lockedByUserName;
    }

    public void setLockedByUserName(String lockedByUserName) {
        this.lockedByUserName = lockedByUserName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOwnerPermissionLevel() {
        return ownerPermissionLevel;
    }

    public void setOwnerPermissionLevel(Integer ownerPermissionLevel) {
        this.ownerPermissionLevel = ownerPermissionLevel;
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

    public String getExportedFromTableName() {
        return exportedFromTableName;
    }

    public void setExportedFromTableName(String exportedFromTableName) {
        this.exportedFromTableName = exportedFromTableName;
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

    @XmlIDREF
    public Workbenchtemplate getWorkbenchTemplateID() {
        return workbenchTemplateID;
    }

    public void setWorkbenchTemplateID(Workbenchtemplate workbenchTemplateID) {
        this.workbenchTemplateID = workbenchTemplateID;
    }

    @XmlIDREF
    public Spprincipal getSpPrincipalID() {
        return spPrincipalID;
    }

    public void setSpPrincipalID(Spprincipal spPrincipalID) {
        this.spPrincipalID = spPrincipalID;
    }

    @XmlTransient
    public List<Workbenchrow> getWorkbenchrowList() {
        return workbenchrowList;
    }

    public void setWorkbenchrowList(List<Workbenchrow> workbenchrowList) {
        this.workbenchrowList = workbenchrowList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (workbenchID != null ? workbenchID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Workbench)) {
            return false;
        }
        Workbench other = (Workbench) object;
        return !((this.workbenchID == null && other.workbenchID != null) || (this.workbenchID != null && !this.workbenchID.equals(other.workbenchID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Workbench[ workbenchID=" + workbenchID + " ]";
    }
    
}
