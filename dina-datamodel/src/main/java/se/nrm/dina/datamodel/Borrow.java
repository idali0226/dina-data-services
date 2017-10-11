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
@Table(name = "borrow")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Borrow.findAll", query = "SELECT b FROM Borrow b"),
    @NamedQuery(name = "Borrow.findByBorrowID", query = "SELECT b FROM Borrow b WHERE b.borrowID = :borrowID"), 
    @NamedQuery(name = "Borrow.findByCollectionMemberID", query = "SELECT b FROM Borrow b WHERE b.collectionMemberID = :collectionMemberID"),
    @NamedQuery(name = "Borrow.findByCurrentDueDate", query = "SELECT b FROM Borrow b WHERE b.currentDueDate = :currentDueDate"),
    @NamedQuery(name = "Borrow.findByDateClosed", query = "SELECT b FROM Borrow b WHERE b.dateClosed = :dateClosed"),
    @NamedQuery(name = "Borrow.findByInvoiceNumber", query = "SELECT b FROM Borrow b WHERE b.invoiceNumber = :invoiceNumber"),
    @NamedQuery(name = "Borrow.findByIsClosed", query = "SELECT b FROM Borrow b WHERE b.isClosed = :isClosed"), 
    @NamedQuery(name = "Borrow.findByOriginalDueDate", query = "SELECT b FROM Borrow b WHERE b.originalDueDate = :originalDueDate"),
    @NamedQuery(name = "Borrow.findByReceivedDate", query = "SELECT b FROM Borrow b WHERE b.receivedDate = :receivedDate"), 
    @NamedQuery(name = "Borrow.findByBorrowDate", query = "SELECT b FROM Borrow b WHERE b.borrowDate = :borrowDate"), 
    @NamedQuery(name = "Borrow.findByNumberOfItemsBorrowed", query = "SELECT b FROM Borrow b WHERE b.numberOfItemsBorrowed = :numberOfItemsBorrowed")})
public class Borrow extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BorrowID")
    private Integer borrowID;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CollectionMemberID")
    private int collectionMemberID;
    
    @Column(name = "CurrentDueDate")
    @Temporal(TemporalType.DATE)
    private Date currentDueDate;
    
    @Column(name = "DateClosed")
    @Temporal(TemporalType.DATE)
    private Date dateClosed;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "InvoiceNumber")
    private String invoiceNumber;
    
    @Column(name = "IsClosed")
    private Boolean isClosed;
    
    @Column(name = "IsFinancialResponsibility")
    private Boolean isFinancialResponsibility;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Number1")
    private Float number1;
    
    @Column(name = "Number2")
    private Float number2;
    
    @Column(name = "OriginalDueDate")
    @Temporal(TemporalType.DATE)
    private Date originalDueDate;
    
    @Column(name = "ReceivedDate")
    @Temporal(TemporalType.DATE)
    private Date receivedDate;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
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
    
    @Column(name = "BorrowDate")
    @Temporal(TemporalType.DATE)
    private Date borrowDate;
    
    @Column(name = "BorrowDatePrecision")
    private Short borrowDatePrecision;
    
    @Column(name = "NumberOfItemsBorrowed")
    private Integer numberOfItemsBorrowed;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "borrowID", fetch = FetchType.LAZY)
    private List<Borrowmaterial> borrowmaterialList;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "AddressOfRecordID", referencedColumnName = "AddressOfRecordID")
    @ManyToOne
    private Addressofrecord addressOfRecordID;
    @OneToMany(mappedBy = "borrowID")
    private List<Shipment> shipmentList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "borrowID", fetch = FetchType.LAZY)
    private List<Borrowagent> borrowagentList;

    public Borrow() {
    }

    public Borrow(Integer borrowID) {
        this.borrowID = borrowID;
    }

    public Borrow(Integer borrowID, Date timestampCreated, int collectionMemberID, String invoiceNumber) {
        this.borrowID = borrowID;
        this.timestampCreated = timestampCreated;
        this.collectionMemberID = collectionMemberID;
        this.invoiceNumber = invoiceNumber;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + borrowID;
    }
    
    @Override
    public int getEntityId() {
        return borrowID;
    }
    
    public Integer getBorrowID() {
        return borrowID;
    }

    public void setBorrowID(Integer borrowID) {
        this.borrowID = borrowID;
    }
 
    public int getCollectionMemberID() {
        return collectionMemberID;
    }

    public void setCollectionMemberID(int collectionMemberID) {
        this.collectionMemberID = collectionMemberID;
    }

    public Date getCurrentDueDate() {
        return currentDueDate;
    }

    public void setCurrentDueDate(Date currentDueDate) {
        this.currentDueDate = currentDueDate;
    }

    public Date getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(Date dateClosed) {
        this.dateClosed = dateClosed;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
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

    public Date getOriginalDueDate() {
        return originalDueDate;
    }

    public void setOriginalDueDate(Date originalDueDate) {
        this.originalDueDate = originalDueDate;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Short getBorrowDatePrecision() {
        return borrowDatePrecision;
    }

    public void setBorrowDatePrecision(Short borrowDatePrecision) {
        this.borrowDatePrecision = borrowDatePrecision;
    }

    public Integer getNumberOfItemsBorrowed() {
        return numberOfItemsBorrowed;
    }

    public void setNumberOfItemsBorrowed(Integer numberOfItemsBorrowed) {
        this.numberOfItemsBorrowed = numberOfItemsBorrowed;
    }

    @XmlTransient
    public List<Borrowmaterial> getBorrowmaterialList() {
        return borrowmaterialList;
    }

    public void setBorrowmaterialList(List<Borrowmaterial> borrowmaterialList) {
        this.borrowmaterialList = borrowmaterialList;
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
    public List<Borrowagent> getBorrowagentList() {
        return borrowagentList;
    }

    public void setBorrowagentList(List<Borrowagent> borrowagentList) {
        this.borrowagentList = borrowagentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (borrowID != null ? borrowID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Borrow)) {
            return false;
        }
        Borrow other = (Borrow) object;
        return !((this.borrowID == null && other.borrowID != null) || (this.borrowID != null && !this.borrowID.equals(other.borrowID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Borrow[ borrowID=" + borrowID + " ]";
    }
    
}
