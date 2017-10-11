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
@Table(name = "preparation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preparation.findAll", query = "SELECT p FROM Preparation p"),
    @NamedQuery(name = "Preparation.findByPreparationID", query = "SELECT p FROM Preparation p WHERE p.preparationID = :preparationID"), 
    @NamedQuery(name = "Preparation.findByCollectionMemberID", query = "SELECT p FROM Preparation p WHERE p.collectionMemberID = :collectionMemberID"),
    @NamedQuery(name = "Preparation.findByCountAmt", query = "SELECT p FROM Preparation p WHERE p.countAmt = :countAmt"),
    @NamedQuery(name = "Preparation.findByDescription", query = "SELECT p FROM Preparation p WHERE p.description = :description"), 
    @NamedQuery(name = "Preparation.findByPreparedDate", query = "SELECT p FROM Preparation p WHERE p.preparedDate = :preparedDate"),
    @NamedQuery(name = "Preparation.findByPreparedDatePrecision", query = "SELECT p FROM Preparation p WHERE p.preparedDatePrecision = :preparedDatePrecision"),
    @NamedQuery(name = "Preparation.findBySampleNumber", query = "SELECT p FROM Preparation p WHERE p.sampleNumber = :sampleNumber"),
    @NamedQuery(name = "Preparation.findByStatus", query = "SELECT p FROM Preparation p WHERE p.status = :status"),
    @NamedQuery(name = "Preparation.findByStorageLocation", query = "SELECT p FROM Preparation p WHERE p.storageLocation = :storageLocation"), })
public class Preparation extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PreparationID")
    private Integer preparationID;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CollectionMemberID")
    private int collectionMemberID;
    
    @Column(name = "CountAmt")
    private Integer countAmt;
    
    @Size(max = 255)
    @Column(name = "Description")
    private String description;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Number1")
    private Float number1;
    
    @Column(name = "Number2")
    private Float number2;
    
    @Column(name = "PreparedDate")
    @Temporal(TemporalType.DATE)
    private Date preparedDate;
    
    @Column(name = "PreparedDatePrecision")
    private Short preparedDatePrecision;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Size(max = 32)
    @Column(name = "SampleNumber")
    private String sampleNumber;
    
    @Size(max = 32)
    @Column(name = "Status")
    private String status;
    
    @Size(max = 50)
    @Column(name = "StorageLocation")
    private String storageLocation;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text1")
    private String text1;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text2")
    private String text2;
    
    @Column(name = "YesNo1")
    private Boolean yesNo1;
    
    @Column(name = "YesNo2")
    private Boolean yesNo2;
    
    @Column(name = "YesNo3")
    private Boolean yesNo3;
    
    @Column(name = "Integer1")
    private Integer integer1;
    
    @Column(name = "Integer2")
    private Integer integer2;
    
    @Column(name = "ReservedInteger3")
    private Integer reservedInteger3;
    
    @Column(name = "ReservedInteger4")
    private Integer reservedInteger4;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "preparationID", fetch = FetchType.LAZY)
    private List<Preparationattachment> preparationattachmentList;
    
    @JoinColumn(name = "PreparationAttributeID", referencedColumnName = "PreparationAttributeID")
    @ManyToOne
    private Preparationattribute preparationAttributeID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "PrepTypeID", referencedColumnName = "PrepTypeID")
    @ManyToOne(optional = false)
    private Preptype prepTypeID;
    
    @JoinColumn(name = "CollectionObjectID", referencedColumnName = "CollectionObjectID")
    @ManyToOne(optional = false,  cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
    private Collectionobject collectionObjectID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "StorageID", referencedColumnName = "StorageID")
    @ManyToOne
    private Storage storageID;
    
    @JoinColumn(name = "PreparedByID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent preparedByID;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "preparationId", fetch = FetchType.LAZY)
    private List<Preparationattr> preparationattrList;
    
    @OneToMany(mappedBy = "preparationID", fetch = FetchType.LAZY)
    private List<Loanpreparation> loanpreparationList;
    
    @OneToMany(mappedBy = "preparationID", fetch = FetchType.LAZY)
    private List<Giftpreparation> giftpreparationList;
    
    @OneToMany(mappedBy = "preparationID", fetch = FetchType.LAZY)
    private List<Deaccessionpreparation> deaccessionpreparationList;

    public Preparation() {
    }

    public Preparation(Integer preparationID) {
        this.preparationID = preparationID;
    }

    public Preparation(Integer preparationID, Date timestampCreated, int collectionMemberID) {
        this.preparationID = preparationID;
        this.timestampCreated = timestampCreated;
        this.collectionMemberID = collectionMemberID;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + preparationID;
    }
    
    @XmlTransient
    @Override
    public int getEntityId() {
        return preparationID == null ? 0 : preparationID;
    }

    public Integer getPreparationID() {
        return preparationID;
    }

    public void setPreparationID(Integer preparationID) {
        this.preparationID = preparationID;
    }
 

    public int getCollectionMemberID() {
        return collectionMemberID;
    }

    public void setCollectionMemberID(int collectionMemberID) {
        this.collectionMemberID = collectionMemberID;
    }

    public Integer getCountAmt() {
        return countAmt;
    }

    public void setCountAmt(Integer countAmt) {
        this.countAmt = countAmt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getNumber1() {
        return number1;
    }

    public void setNumber1(Float number1) {
        this.number1 = number1;
    }

    public Float getNumber2() {
        return number2;
    }

    public void setNumber2(Float number2) {
        this.number2 = number2;
    }

    public Date getPreparedDate() {
        return preparedDate;
    }

    public void setPreparedDate(Date preparedDate) {
        this.preparedDate = preparedDate;
    }

    public Short getPreparedDatePrecision() {
        return preparedDatePrecision;
    }

    public void setPreparedDatePrecision(Short preparedDatePrecision) {
        this.preparedDatePrecision = preparedDatePrecision;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSampleNumber() {
        return sampleNumber;
    }

    public void setSampleNumber(String sampleNumber) {
        this.sampleNumber = sampleNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public Boolean getYesNo1() {
        return yesNo1;
    }

    public void setYesNo1(Boolean yesNo1) {
        this.yesNo1 = yesNo1;
    }

    public Boolean getYesNo2() {
        return yesNo2;
    }

    public void setYesNo2(Boolean yesNo2) {
        this.yesNo2 = yesNo2;
    }

    public Boolean getYesNo3() {
        return yesNo3;
    }

    public void setYesNo3(Boolean yesNo3) {
        this.yesNo3 = yesNo3;
    }

    public Integer getInteger1() {
        return integer1;
    }

    public void setInteger1(Integer integer1) {
        this.integer1 = integer1;
    }

    public Integer getInteger2() {
        return integer2;
    }

    public void setInteger2(Integer integer2) {
        this.integer2 = integer2;
    }

    public Integer getReservedInteger3() {
        return reservedInteger3;
    }

    public void setReservedInteger3(Integer reservedInteger3) {
        this.reservedInteger3 = reservedInteger3;
    }

    public Integer getReservedInteger4() {
        return reservedInteger4;
    }

    public void setReservedInteger4(Integer reservedInteger4) {
        this.reservedInteger4 = reservedInteger4;
    }

    @XmlTransient
    public List<Preparationattachment> getPreparationattachmentList() {
        return preparationattachmentList;
    }

    public void setPreparationattachmentList(List<Preparationattachment> preparationattachmentList) {
        this.preparationattachmentList = preparationattachmentList;
    }

    @XmlIDREF
    public Preparationattribute getPreparationAttributeID() {
        return preparationAttributeID;
    }

    public void setPreparationAttributeID(Preparationattribute preparationAttributeID) {
        this.preparationAttributeID = preparationAttributeID;
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

    @XmlTransient
    public Collectionobject getCollectionObjectID() {
        return collectionObjectID;
    }

    public void setCollectionObjectID(Collectionobject collectionObjectID) {
        this.collectionObjectID = collectionObjectID;
    }

    @XmlIDREF
    public Agent getCreatedByAgentID() {
        return createdByAgentID;
    }

    public void setCreatedByAgentID(Agent createdByAgentID) {
        this.createdByAgentID = createdByAgentID;
    }

    @XmlIDREF
    public Storage getStorageID() {
        return storageID;
    }

    public void setStorageID(Storage storageID) {
        this.storageID = storageID;
    }

    @XmlIDREF
    public Agent getPreparedByID() {
        return preparedByID;
    }

    public void setPreparedByID(Agent preparedByID) {
        this.preparedByID = preparedByID;
    }

    @XmlTransient
    public List<Preparationattr> getPreparationattrList() {
        return preparationattrList;
    }

    public void setPreparationattrList(List<Preparationattr> preparationattrList) {
        this.preparationattrList = preparationattrList;
    }

    @XmlTransient
    public List<Loanpreparation> getLoanpreparationList() {
        return loanpreparationList;
    }

    public void setLoanpreparationList(List<Loanpreparation> loanpreparationList) {
        this.loanpreparationList = loanpreparationList;
    }

    @XmlTransient
    public List<Giftpreparation> getGiftpreparationList() {
        return giftpreparationList;
    }

    public void setGiftpreparationList(List<Giftpreparation> giftpreparationList) {
        this.giftpreparationList = giftpreparationList;
    }

    @XmlTransient
    public List<Deaccessionpreparation> getDeaccessionpreparationList() {
        return deaccessionpreparationList;
    }

    public void setDeaccessionpreparationList(List<Deaccessionpreparation> deaccessionpreparationList) {
        this.deaccessionpreparationList = deaccessionpreparationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preparationID != null ? preparationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preparation)) {
            return false;
        }
        Preparation other = (Preparation) object;
        return !((this.preparationID == null && other.preparationID != null) || (this.preparationID != null && !this.preparationID.equals(other.preparationID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Preparation[ preparationID=" + preparationID + " ]";
    }
    
}
