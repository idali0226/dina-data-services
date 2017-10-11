/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.datamodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import se.nrm.dina.datamodel.util.Util;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "workbenchdataitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Workbenchdataitem.findAll", query = "SELECT w FROM Workbenchdataitem w"),
    @NamedQuery(name = "Workbenchdataitem.findByWorkbenchDataItemID", query = "SELECT w FROM Workbenchdataitem w WHERE w.workbenchDataItemID = :workbenchDataItemID"),
    @NamedQuery(name = "Workbenchdataitem.findByRowNumber", query = "SELECT w FROM Workbenchdataitem w WHERE w.rowNumber = :rowNumber"),
    @NamedQuery(name = "Workbenchdataitem.findByValidationStatus", query = "SELECT w FROM Workbenchdataitem w WHERE w.validationStatus = :validationStatus")})
public class Workbenchdataitem implements EntityBean, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "WorkbenchDataItemID")
    private Integer workbenchDataItemID;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "CellData")
    private String cellData;
    
    @Column(name = "RowNumber")
    private Short rowNumber;
    
    @Column(name = "ValidationStatus")
    private Short validationStatus;
    
    @JoinColumn(name = "WorkbenchTemplateMappingItemID", referencedColumnName = "WorkbenchTemplateMappingItemID")
    @ManyToOne(optional = false)
    private Workbenchtemplatemappingitem workbenchTemplateMappingItemID;
    
    @JoinColumn(name = "WorkbenchRowID", referencedColumnName = "WorkbenchRowID")
    @ManyToOne(optional = false)
    private Workbenchrow workbenchRowID;

    public Workbenchdataitem() {
    }

    public Workbenchdataitem(Integer workbenchDataItemID) {
        this.workbenchDataItemID = workbenchDataItemID;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + workbenchDataItemID;
    }
    
    @Override
    public int getEntityId() {
        return workbenchDataItemID;
    }

    public Integer getWorkbenchDataItemID() {
        return workbenchDataItemID;
    }

    public void setWorkbenchDataItemID(Integer workbenchDataItemID) {
        this.workbenchDataItemID = workbenchDataItemID;
    }

    public String getCellData() {
        return cellData;
    }

    public void setCellData(String cellData) {
        this.cellData = cellData;
    }

    public Short getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Short rowNumber) {
        this.rowNumber = rowNumber;
    }

    public Short getValidationStatus() {
        return validationStatus;
    }

    public void setValidationStatus(Short validationStatus) {
        this.validationStatus = validationStatus;
    }

    @XmlIDREF
    public Workbenchtemplatemappingitem getWorkbenchTemplateMappingItemID() {
        return workbenchTemplateMappingItemID;
    }

    public void setWorkbenchTemplateMappingItemID(Workbenchtemplatemappingitem workbenchTemplateMappingItemID) {
        this.workbenchTemplateMappingItemID = workbenchTemplateMappingItemID;
    }

    @XmlIDREF
    public Workbenchrow getWorkbenchRowID() {
        return workbenchRowID;
    }

    public void setWorkbenchRowID(Workbenchrow workbenchRowID) {
        this.workbenchRowID = workbenchRowID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (workbenchDataItemID != null ? workbenchDataItemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Workbenchdataitem)) {
            return false;
        }
        Workbenchdataitem other = (Workbenchdataitem) object;
        return !((this.workbenchDataItemID == null && other.workbenchDataItemID != null) || (this.workbenchDataItemID != null && !this.workbenchDataItemID.equals(other.workbenchDataItemID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Workbenchdataitem[ workbenchDataItemID=" + workbenchDataItemID + " ]";
    }
    
}
