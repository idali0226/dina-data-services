/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.datamodel;
 
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "appraisal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appraisal.findAll", query = "SELECT a FROM Appraisal a"),
    @NamedQuery(name = "Appraisal.findByAppraisalID", query = "SELECT a FROM Appraisal a WHERE a.appraisalID = :appraisalID"), 
    @NamedQuery(name = "Appraisal.findByAppraisalDate", query = "SELECT a FROM Appraisal a WHERE a.appraisalDate = :appraisalDate"),
    @NamedQuery(name = "Appraisal.findByAppraisalNumber", query = "SELECT a FROM Appraisal a WHERE a.appraisalNumber = :appraisalNumber"),
    @NamedQuery(name = "Appraisal.findByAppraisalValue", query = "SELECT a FROM Appraisal a WHERE a.appraisalValue = :appraisalValue"),
    @NamedQuery(name = "Appraisal.findByMonetaryUnitType", query = "SELECT a FROM Appraisal a WHERE a.monetaryUnitType = :monetaryUnitType")})
public class Appraisal extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AppraisalID")
    private Integer appraisalID;
    
   
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "AppraisalDate")
    @Temporal(TemporalType.DATE)
    private Date appraisalDate;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "AppraisalNumber")
    private String appraisalNumber;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AppraisalValue")
    private BigDecimal appraisalValue;
    
    @Size(max = 8)
    @Column(name = "MonetaryUnitType")
    private String monetaryUnitType;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Notes")
    private String notes;
    
    @OneToMany(mappedBy = "appraisalID")
    private List<Collectionobject> collectionobjectList;
    
    @JoinColumn(name = "AgentID", referencedColumnName = "AgentID")
    @ManyToOne(optional = false)
    private Agent agentID;
    
    @JoinColumn(name = "AccessionID", referencedColumnName = "AccessionID")
    @ManyToOne
    private Accession accessionID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;

    public Appraisal() {
    }

    public Appraisal(Integer appraisalID) {
        this.appraisalID = appraisalID;
    }

    public Appraisal(Integer appraisalID, Date timestampCreated, Date appraisalDate, String appraisalNumber) {
        this.appraisalID = appraisalID;
        this.timestampCreated = timestampCreated;
        this.appraisalDate = appraisalDate;
        this.appraisalNumber = appraisalNumber;
    }

    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + appraisalID;
    }
    
    @Override
    public int getEntityId() {
        return appraisalID;
    }
    
    public Integer getAppraisalID() {
        return appraisalID;
    }

    public void setAppraisalID(Integer appraisalID) {
        this.appraisalID = appraisalID;
    }

    
    public Date getAppraisalDate() {
        return appraisalDate;
    }

    public void setAppraisalDate(Date appraisalDate) {
        this.appraisalDate = appraisalDate;
    }

    public String getAppraisalNumber() {
        return appraisalNumber;
    }

    public void setAppraisalNumber(String appraisalNumber) {
        this.appraisalNumber = appraisalNumber;
    }

    public BigDecimal getAppraisalValue() {
        return appraisalValue;
    }

    public void setAppraisalValue(BigDecimal appraisalValue) {
        this.appraisalValue = appraisalValue;
    }

    public String getMonetaryUnitType() {
        return monetaryUnitType;
    }

    public void setMonetaryUnitType(String monetaryUnitType) {
        this.monetaryUnitType = monetaryUnitType;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @XmlTransient
    public List<Collectionobject> getCollectionobjectList() {
        return collectionobjectList;
    }

    public void setCollectionobjectList(List<Collectionobject> collectionobjectList) {
        this.collectionobjectList = collectionobjectList;
    }

    @XmlIDREF
    public Agent getAgentID() {
        return agentID;
    }

    public void setAgentID(Agent agentID) {
        this.agentID = agentID;
    }

    @XmlIDREF
    public Accession getAccessionID() {
        return accessionID;
    }

    public void setAccessionID(Accession accessionID) {
        this.accessionID = accessionID;
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
        hash += (appraisalID != null ? appraisalID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appraisal)) {
            return false;
        }
        Appraisal other = (Appraisal) object;
        return !((this.appraisalID == null && other.appraisalID != null) || (this.appraisalID != null && !this.appraisalID.equals(other.appraisalID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Appraisal[ appraisalID=" + appraisalID + " ]";
    }
    
}
