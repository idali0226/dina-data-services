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
@Table(name = "workbenchtemplatemappingitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Workbenchtemplatemappingitem.findAll", query = "SELECT w FROM Workbenchtemplatemappingitem w"),
    @NamedQuery(name = "Workbenchtemplatemappingitem.findByWorkbenchTemplateMappingItemID", query = "SELECT w FROM Workbenchtemplatemappingitem w WHERE w.workbenchTemplateMappingItemID = :workbenchTemplateMappingItemID"),  
    @NamedQuery(name = "Workbenchtemplatemappingitem.findByCaption", query = "SELECT w FROM Workbenchtemplatemappingitem w WHERE w.caption = :caption") })
public class Workbenchtemplatemappingitem extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "WorkbenchTemplateMappingItemID")
    private Integer workbenchTemplateMappingItemID;
    
    
    @Column(name = "XCoord")
    private Short xCoord;
    
    @Column(name = "YCoord")
    private Short yCoord;
    
    @Size(max = 64)
    @Column(name = "Caption")
    private String caption;
    
    @Column(name = "CarryForward")
    private Boolean carryForward;
    
    @Column(name = "DataFieldLength")
    private Short dataFieldLength;
    
    @Size(max = 255)
    @Column(name = "FieldName")
    private String fieldName;
    
    @Column(name = "FieldType")
    private Short fieldType;
    
    @Size(max = 255)
    @Column(name = "ImportedColName")
    private String importedColName;
    
    @Column(name = "IsExportableToContent")
    private Boolean isExportableToContent;
    
    @Column(name = "IsIncludedInTitle")
    private Boolean isIncludedInTitle;
    
    @Column(name = "IsRequired")
    private Boolean isRequired;
    
    @Size(max = 128)
    @Column(name = "MetaData")
    private String metaData;
    
    @Column(name = "DataColumnIndex")
    private Short dataColumnIndex;
    
    @Column(name = "TableId")
    private Integer tableId;
    
    @Size(max = 64)
    @Column(name = "TableName")
    private String tableName;
    
    @Column(name = "ViewOrder")
    private Short viewOrder;
    
    @Column(name = "IsEditable")
    private Boolean isEditable;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "WorkbenchTemplateID", referencedColumnName = "WorkbenchTemplateID")
    @ManyToOne(optional = false)
    private Workbenchtemplate workbenchTemplateID;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workbenchTemplateMappingItemID", fetch = FetchType.LAZY)
    private List<Workbenchdataitem> workbenchdataitemList;

    public Workbenchtemplatemappingitem() {
    }

    public Workbenchtemplatemappingitem(Integer workbenchTemplateMappingItemID) {
        this.workbenchTemplateMappingItemID = workbenchTemplateMappingItemID;
    }

    public Workbenchtemplatemappingitem(Integer workbenchTemplateMappingItemID, Date timestampCreated) {
        this.workbenchTemplateMappingItemID = workbenchTemplateMappingItemID;
        this.timestampCreated = timestampCreated;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + workbenchTemplateMappingItemID;
    }
    
    @Override
    public int getEntityId() {
        return workbenchTemplateMappingItemID;
    }

    public Integer getWorkbenchTemplateMappingItemID() {
        return workbenchTemplateMappingItemID;
    }

    public void setWorkbenchTemplateMappingItemID(Integer workbenchTemplateMappingItemID) {
        this.workbenchTemplateMappingItemID = workbenchTemplateMappingItemID;
    }

    
    public Short getXCoord() {
        return xCoord;
    }

    public void setXCoord(Short xCoord) {
        this.xCoord = xCoord;
    }

    public Short getYCoord() {
        return yCoord;
    }

    public void setYCoord(Short yCoord) {
        this.yCoord = yCoord;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Boolean getCarryForward() {
        return carryForward;
    }

    public void setCarryForward(Boolean carryForward) {
        this.carryForward = carryForward;
    }

    public Short getDataFieldLength() {
        return dataFieldLength;
    }

    public void setDataFieldLength(Short dataFieldLength) {
        this.dataFieldLength = dataFieldLength;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Short getFieldType() {
        return fieldType;
    }

    public void setFieldType(Short fieldType) {
        this.fieldType = fieldType;
    }

    public String getImportedColName() {
        return importedColName;
    }

    public void setImportedColName(String importedColName) {
        this.importedColName = importedColName;
    }

    public Boolean getIsExportableToContent() {
        return isExportableToContent;
    }

    public void setIsExportableToContent(Boolean isExportableToContent) {
        this.isExportableToContent = isExportableToContent;
    }

    public Boolean getIsIncludedInTitle() {
        return isIncludedInTitle;
    }

    public void setIsIncludedInTitle(Boolean isIncludedInTitle) {
        this.isIncludedInTitle = isIncludedInTitle;
    }

    public Boolean getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    public String getMetaData() {
        return metaData;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }

    public Short getDataColumnIndex() {
        return dataColumnIndex;
    }

    public void setDataColumnIndex(Short dataColumnIndex) {
        this.dataColumnIndex = dataColumnIndex;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Short getViewOrder() {
        return viewOrder;
    }

    public void setViewOrder(Short viewOrder) {
        this.viewOrder = viewOrder;
    }

    public Boolean getIsEditable() {
        return isEditable;
    }

    public void setIsEditable(Boolean isEditable) {
        this.isEditable = isEditable;
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

    @XmlTransient
    public List<Workbenchdataitem> getWorkbenchdataitemList() {
        return workbenchdataitemList;
    }

    public void setWorkbenchdataitemList(List<Workbenchdataitem> workbenchdataitemList) {
        this.workbenchdataitemList = workbenchdataitemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (workbenchTemplateMappingItemID != null ? workbenchTemplateMappingItemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Workbenchtemplatemappingitem)) {
            return false;
        }
        Workbenchtemplatemappingitem other = (Workbenchtemplatemappingitem) object;
        return !((this.workbenchTemplateMappingItemID == null && other.workbenchTemplateMappingItemID != null) || (this.workbenchTemplateMappingItemID != null && !this.workbenchTemplateMappingItemID.equals(other.workbenchTemplateMappingItemID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Workbenchtemplatemappingitem[ workbenchTemplateMappingItemID=" + workbenchTemplateMappingItemID + " ]";
    }
    
}
