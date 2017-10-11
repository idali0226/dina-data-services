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
@Table(name = "gift")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gift.findAll", query = "SELECT g FROM Gift g"),
    @NamedQuery(name = "Gift.findByGiftID", query = "SELECT g FROM Gift g WHERE g.giftID = :giftID"), 
    @NamedQuery(name = "Gift.findByDateReceived", query = "SELECT g FROM Gift g WHERE g.dateReceived = :dateReceived"),
    @NamedQuery(name = "Gift.findByGiftDate", query = "SELECT g FROM Gift g WHERE g.giftDate = :giftDate"),
    @NamedQuery(name = "Gift.findByGiftNumber", query = "SELECT g FROM Gift g WHERE g.giftNumber = :giftNumber") })
public class Gift extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GiftID")
    private Integer giftID;
    
    
    
    @Column(name = "DateReceived")
    @Temporal(TemporalType.DATE)
    private Date dateReceived;
    
    @Column(name = "GiftDate")
    @Temporal(TemporalType.DATE)
    private Date giftDate;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "GiftNumber")
    private String giftNumber;
    
    @Column(name = "IsFinancialResponsibility")
    private Boolean isFinancialResponsibility;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Number1")
    private Float number1;
    
    @Column(name = "Number2")
    private Float number2;
    
    @Size(max = 64)
    @Column(name = "PurposeOfGift")
    private String purposeOfGift;
    
    @Size(max = 255)
    @Column(name = "ReceivedComments")
    private String receivedComments;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "SpecialConditions")
    private String specialConditions;
    
    @Size(max = 500)
    @Column(name = "SrcGeography")
    private String srcGeography;
    
    @Size(max = 500)
    @Column(name = "SrcTaxonomy")
    private String srcTaxonomy;
    
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
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Contents")
    private String contents;
    
    @JoinColumn(name = "DisciplineID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne(optional = false)
    private Discipline disciplineID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "DivisionID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne
    private Division divisionID;
    
    @JoinColumn(name = "AddressOfRecordID", referencedColumnName = "AddressOfRecordID")
    @ManyToOne
    private Addressofrecord addressOfRecordID;
    
    @OneToMany(mappedBy = "giftID", fetch = FetchType.LAZY)
    private List<Shipment> shipmentList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "giftID", fetch = FetchType.LAZY)
    private List<Giftagent> giftagentList;
    
    @OneToMany(mappedBy = "giftID", fetch = FetchType.LAZY)
    private List<Giftpreparation> giftpreparationList;

    public Gift() {
    }

    public Gift(Integer giftID) {
        this.giftID = giftID;
    }

    public Gift(Integer giftID, Date timestampCreated, String giftNumber) {
        this.giftID = giftID;
        this.timestampCreated = timestampCreated;
        this.giftNumber = giftNumber;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + giftID;
    }
    
    @Override
    public int getEntityId() {
        return giftID;
    }

    public Integer getGiftID() {
        return giftID;
    }

    public void setGiftID(Integer giftID) {
        this.giftID = giftID;
    }
 

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public Date getGiftDate() {
        return giftDate;
    }

    public void setGiftDate(Date giftDate) {
        this.giftDate = giftDate;
    }

    public String getGiftNumber() {
        return giftNumber;
    }

    public void setGiftNumber(String giftNumber) {
        this.giftNumber = giftNumber;
    }

    public Boolean getIsFinancialResponsibility() {
        return isFinancialResponsibility;
    }

    public void setIsFinancialResponsibility(Boolean isFinancialResponsibility) {
        this.isFinancialResponsibility = isFinancialResponsibility;
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

    public String getPurposeOfGift() {
        return purposeOfGift;
    }

    public void setPurposeOfGift(String purposeOfGift) {
        this.purposeOfGift = purposeOfGift;
    }

    public String getReceivedComments() {
        return receivedComments;
    }

    public void setReceivedComments(String receivedComments) {
        this.receivedComments = receivedComments;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSpecialConditions() {
        return specialConditions;
    }

    public void setSpecialConditions(String specialConditions) {
        this.specialConditions = specialConditions;
    }

    public String getSrcGeography() {
        return srcGeography;
    }

    public void setSrcGeography(String srcGeography) {
        this.srcGeography = srcGeography;
    }

    public String getSrcTaxonomy() {
        return srcTaxonomy;
    }

    public void setSrcTaxonomy(String srcTaxonomy) {
        this.srcTaxonomy = srcTaxonomy;
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

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
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
    public Division getDivisionID() {
        return divisionID;
    }

    public void setDivisionID(Division divisionID) {
        this.divisionID = divisionID;
    }

    @XmlIDREF
    public Addressofrecord getAddressOfRecordID() {
        return addressOfRecordID;
    }

    public void setAddressOfRecordID(Addressofrecord addressOfRecordID) {
        this.addressOfRecordID = addressOfRecordID;
    }

    @XmlTransient
    public List<Shipment> getShipmentList() {
        return shipmentList;
    }

    public void setShipmentList(List<Shipment> shipmentList) {
        this.shipmentList = shipmentList;
    }

    @XmlTransient
    public List<Giftagent> getGiftagentList() {
        return giftagentList;
    }

    public void setGiftagentList(List<Giftagent> giftagentList) {
        this.giftagentList = giftagentList;
    }

    @XmlTransient
    public List<Giftpreparation> getGiftpreparationList() {
        return giftpreparationList;
    }

    public void setGiftpreparationList(List<Giftpreparation> giftpreparationList) {
        this.giftpreparationList = giftpreparationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (giftID != null ? giftID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gift)) {
            return false;
        }
        Gift other = (Gift) object;
        return !((this.giftID == null && other.giftID != null) || (this.giftID != null && !this.giftID.equals(other.giftID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Gift[ giftID=" + giftID + " ]";
    }
    
}
