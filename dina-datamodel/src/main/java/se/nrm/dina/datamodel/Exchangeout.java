/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.datamodel;
 
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "exchangeout")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exchangeout.findAll", query = "SELECT e FROM Exchangeout e"),
    @NamedQuery(name = "Exchangeout.findByExchangeOutID", query = "SELECT e FROM Exchangeout e WHERE e.exchangeOutID = :exchangeOutID"), 
    @NamedQuery(name = "Exchangeout.findByDescriptionOfMaterial", query = "SELECT e FROM Exchangeout e WHERE e.descriptionOfMaterial = :descriptionOfMaterial"),
    @NamedQuery(name = "Exchangeout.findByExchangeDate", query = "SELECT e FROM Exchangeout e WHERE e.exchangeDate = :exchangeDate"), 
    @NamedQuery(name = "Exchangeout.findByQuantityExchanged", query = "SELECT e FROM Exchangeout e WHERE e.quantityExchanged = :quantityExchanged"),
    @NamedQuery(name = "Exchangeout.findBySrcGeography", query = "SELECT e FROM Exchangeout e WHERE e.srcGeography = :srcGeography"),
    @NamedQuery(name = "Exchangeout.findBySrcTaxonomy", query = "SELECT e FROM Exchangeout e WHERE e.srcTaxonomy = :srcTaxonomy"), 
    @NamedQuery(name = "Exchangeout.findByExchangeOutNumber", query = "SELECT e FROM Exchangeout e WHERE e.exchangeOutNumber = :exchangeOutNumber")})
public class Exchangeout extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ExchangeOutID")
    private Integer exchangeOutID;
    
    
    @Size(max = 120)
    @Column(name = "DescriptionOfMaterial")
    private String descriptionOfMaterial;
    
    @Column(name = "ExchangeDate")
    @Temporal(TemporalType.DATE)
    private Date exchangeDate;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Number1")
    private Float number1;
    
    @Column(name = "Number2")
    private Float number2;
    
    @Column(name = "QuantityExchanged")
    private Short quantityExchanged;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Size(max = 32)
    @Column(name = "SrcGeography")
    private String srcGeography;
    
    @Size(max = 32)
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
    
    @Size(max = 50)
    @Column(name = "ExchangeOutNumber")
    private String exchangeOutNumber;
    
    @JoinColumn(name = "CatalogedByID", referencedColumnName = "AgentID")
    @ManyToOne(optional = false)
    private Agent catalogedByID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "DivisionID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne(optional = false)
    private Division divisionID;
    
    @JoinColumn(name = "SentToOrganizationID", referencedColumnName = "AgentID")
    @ManyToOne(optional = false)
    private Agent sentToOrganizationID;
    
    @JoinColumn(name = "AddressOfRecordID", referencedColumnName = "AddressOfRecordID")
    @ManyToOne
    private Addressofrecord addressOfRecordID;
    
    @OneToMany(mappedBy = "exchangeOutID", fetch = FetchType.LAZY)
    private List<Shipment> shipmentList;

    public Exchangeout() {
    }

    public Exchangeout(Integer exchangeOutID) {
        this.exchangeOutID = exchangeOutID;
    }

    public Exchangeout(Integer exchangeOutID, Date timestampCreated) {
        this.exchangeOutID = exchangeOutID;
        this.timestampCreated = timestampCreated;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + exchangeOutID;
    }
    
    @Override
    public int getEntityId() {
        return exchangeOutID;
    }
     
    public Integer getExchangeOutID() {
        return exchangeOutID;
    }

    public void setExchangeOutID(Integer exchangeOutID) {
        this.exchangeOutID = exchangeOutID;
    }
 
    public String getDescriptionOfMaterial() {
        return descriptionOfMaterial;
    }

    public void setDescriptionOfMaterial(String descriptionOfMaterial) {
        this.descriptionOfMaterial = descriptionOfMaterial;
    }

    public Date getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(Date exchangeDate) {
        this.exchangeDate = exchangeDate;
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

    public Short getQuantityExchanged() {
        return quantityExchanged;
    }

    public void setQuantityExchanged(Short quantityExchanged) {
        this.quantityExchanged = quantityExchanged;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public String getExchangeOutNumber() {
        return exchangeOutNumber;
    }

    public void setExchangeOutNumber(String exchangeOutNumber) {
        this.exchangeOutNumber = exchangeOutNumber;
    }

    @XmlIDREF
    public Agent getCatalogedByID() {
        return catalogedByID;
    }

    public void setCatalogedByID(Agent catalogedByID) {
        this.catalogedByID = catalogedByID;
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
    public Agent getSentToOrganizationID() {
        return sentToOrganizationID;
    }

    public void setSentToOrganizationID(Agent sentToOrganizationID) {
        this.sentToOrganizationID = sentToOrganizationID;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (exchangeOutID != null ? exchangeOutID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exchangeout)) {
            return false;
        }
        Exchangeout other = (Exchangeout) object;
        return !((this.exchangeOutID == null && other.exchangeOutID != null) || (this.exchangeOutID != null && !this.exchangeOutID.equals(other.exchangeOutID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Exchangeout[ exchangeOutID=" + exchangeOutID + " ]";
    }
    
}
