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
@Table(name = "attributedef")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attributedef.findAll", query = "SELECT a FROM Attributedef a"),
    @NamedQuery(name = "Attributedef.findByAttributeDefID", query = "SELECT a FROM Attributedef a WHERE a.attributeDefID = :attributeDefID"), 
    @NamedQuery(name = "Attributedef.findByDataType", query = "SELECT a FROM Attributedef a WHERE a.dataType = :dataType"),
    @NamedQuery(name = "Attributedef.findByFieldName", query = "SELECT a FROM Attributedef a WHERE a.fieldName = :fieldName"),
    @NamedQuery(name = "Attributedef.findByTableType", query = "SELECT a FROM Attributedef a WHERE a.tableType = :tableType")})
public class Attributedef extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AttributeDefID")
    private Integer attributeDefID;

    
    @Column(name = "DataType")
    private Short dataType;
    
    @Size(max = 32)
    @Column(name = "FieldName")
    private String fieldName;
    
    @Column(name = "TableType")
    private Short tableType;
    
    @JoinColumn(name = "DisciplineID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne(optional = false)
    private Discipline disciplineID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "PrepTypeID", referencedColumnName = "PrepTypeID")
    @ManyToOne
    private Preptype prepTypeID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attributeDefID", fetch = FetchType.LAZY)
    private List<Preparationattr> preparationattrList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attributeDefID", fetch = FetchType.LAZY)
    private List<Collectingeventattr> collectingeventattrList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attributeDefID", fetch = FetchType.LAZY)
    private List<Collectionobjectattr> collectionobjectattrList;

    public Attributedef() {
    }

    public Attributedef(Integer attributeDefID) {
        this.attributeDefID = attributeDefID;
    }

    public Attributedef(Integer attributeDefID, Date timestampCreated) {
        this.attributeDefID = attributeDefID;
        this.timestampCreated = timestampCreated;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + attributeDefID;
    }
    
    @Override
    public int getEntityId() {
        return attributeDefID;
    }

    public Integer getAttributeDefID() {
        return attributeDefID;
    }

    public void setAttributeDefID(Integer attributeDefID) {
        this.attributeDefID = attributeDefID;
    }
 
    public Short getDataType() {
        return dataType;
    }

    public void setDataType(Short dataType) {
        this.dataType = dataType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Short getTableType() {
        return tableType;
    }

    public void setTableType(Short tableType) {
        this.tableType = tableType;
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
    public Preptype getPrepTypeID() {
        return prepTypeID;
    }

    public void setPrepTypeID(Preptype prepTypeID) {
        this.prepTypeID = prepTypeID;
    }

    @XmlIDREF
    public Agent getCreatedByAgentID() {
        return createdByAgentID;
    }

    public void setCreatedByAgentID(Agent createdByAgentID) {
        this.createdByAgentID = createdByAgentID;
    }

    @XmlTransient
    public List<Preparationattr> getPreparationattrList() {
        return preparationattrList;
    }

    public void setPreparationattrList(List<Preparationattr> preparationattrList) {
        this.preparationattrList = preparationattrList;
    }

    @XmlTransient
    public List<Collectingeventattr> getCollectingeventattrList() {
        return collectingeventattrList;
    }

    public void setCollectingeventattrList(List<Collectingeventattr> collectingeventattrList) {
        this.collectingeventattrList = collectingeventattrList;
    }

    @XmlTransient
    public List<Collectionobjectattr> getCollectionobjectattrList() {
        return collectionobjectattrList;
    }

    public void setCollectionobjectattrList(List<Collectionobjectattr> collectionobjectattrList) {
        this.collectionobjectattrList = collectionobjectattrList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attributeDefID != null ? attributeDefID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attributedef)) {
            return false;
        }
        Attributedef other = (Attributedef) object;
        return !((this.attributeDefID == null && other.attributeDefID != null) || (this.attributeDefID != null && !this.attributeDefID.equals(other.attributeDefID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Attributedef[ attributeDefID=" + attributeDefID + " ]";
    }
    
}
