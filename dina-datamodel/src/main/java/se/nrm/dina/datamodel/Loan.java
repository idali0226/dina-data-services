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
@Table(name = "loan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loan.findAll", query = "SELECT l FROM Loan l"),
    @NamedQuery(name = "Loan.findByLoanID", query = "SELECT l FROM Loan l WHERE l.loanID = :loanID"), 
    @NamedQuery(name = "Loan.findByCurrentDueDate", query = "SELECT l FROM Loan l WHERE l.currentDueDate = :currentDueDate"),
    @NamedQuery(name = "Loan.findByDateClosed", query = "SELECT l FROM Loan l WHERE l.dateClosed = :dateClosed"),
    @NamedQuery(name = "Loan.findByDateReceived", query = "SELECT l FROM Loan l WHERE l.dateReceived = :dateReceived"),
    @NamedQuery(name = "Loan.findByIsClosed", query = "SELECT l FROM Loan l WHERE l.isClosed = :isClosed"),
    @NamedQuery(name = "Loan.findByIsFinancialResponsibility", query = "SELECT l FROM Loan l WHERE l.isFinancialResponsibility = :isFinancialResponsibility"),
    @NamedQuery(name = "Loan.findByLoanDate", query = "SELECT l FROM Loan l WHERE l.loanDate = :loanDate"),
    @NamedQuery(name = "Loan.findByLoanNumber", query = "SELECT l FROM Loan l WHERE l.loanNumber = :loanNumber"), 
    @NamedQuery(name = "Loan.findByOriginalDueDate", query = "SELECT l FROM Loan l WHERE l.originalDueDate = :originalDueDate"),
    @NamedQuery(name = "Loan.findByOverdueNotiSetDate", query = "SELECT l FROM Loan l WHERE l.overdueNotiSetDate = :overdueNotiSetDate") })
public class Loan extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LoanID")
    private Integer loanID;
    
   
    
    @Column(name = "CurrentDueDate")
    @Temporal(TemporalType.DATE)
    private Date currentDueDate;
    
    @Column(name = "DateClosed")
    @Temporal(TemporalType.DATE)
    private Date dateClosed;
    
    @Column(name = "DateReceived")
    @Temporal(TemporalType.DATE)
    private Date dateReceived;
    
    @Column(name = "IsClosed")
    private Boolean isClosed;
    
    @Column(name = "IsFinancialResponsibility")
    private Boolean isFinancialResponsibility;
    
    @Column(name = "LoanDate")
    @Temporal(TemporalType.DATE)
    private Date loanDate;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LoanNumber")
    private String loanNumber;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Number1")
    private Float number1;
    
    @Column(name = "Number2")
    private Float number2;
    
    @Column(name = "OriginalDueDate")
    @Temporal(TemporalType.DATE)
    private Date originalDueDate;
    
    @Column(name = "OverdueNotiSetDate")
    @Temporal(TemporalType.DATE)
    private Date overdueNotiSetDate;
    
    @Size(max = 64)
    @Column(name = "PurposeOfLoan")
    private String purposeOfLoan;
    
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
    
    @OneToMany(mappedBy = "loanID", fetch = FetchType.LAZY)
    private List<Shipment> shipmentList;
    
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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loanID", fetch = FetchType.LAZY)
    private List<Loanpreparation> loanpreparationList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loanID", fetch = FetchType.LAZY)
    private List<Loanagent> loanagentList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loanID", fetch = FetchType.LAZY)
    private List<Loanattachment> loanattachmentList;

    public Loan() {
    }

    public Loan(Integer loanID) {
        this.loanID = loanID;
    }

    public Loan(Integer loanID, Date timestampCreated, String loanNumber) {
        this.loanID = loanID;
        this.timestampCreated = timestampCreated;
        this.loanNumber = loanNumber;
    }

    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + loanID;
    }
    
    @Override
    public int getEntityId() {
        return loanID;
    }
    
    public Integer getLoanID() {
        return loanID;
    }

    public void setLoanID(Integer loanID) {
        this.loanID = loanID;
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

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
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

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public String getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(String loanNumber) {
        this.loanNumber = loanNumber;
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

    public Date getOverdueNotiSetDate() {
        return overdueNotiSetDate;
    }

    public void setOverdueNotiSetDate(Date overdueNotiSetDate) {
        this.overdueNotiSetDate = overdueNotiSetDate;
    }

    public String getPurposeOfLoan() {
        return purposeOfLoan;
    }

    public void setPurposeOfLoan(String purposeOfLoan) {
        this.purposeOfLoan = purposeOfLoan;
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

    @XmlTransient
    public List<Shipment> getShipmentList() {
        return shipmentList;
    }

    public void setShipmentList(List<Shipment> shipmentList) {
        this.shipmentList = shipmentList;
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

    public Addressofrecord getAddressOfRecordID() {
        return addressOfRecordID;
    }

    public void setAddressOfRecordID(Addressofrecord addressOfRecordID) {
        this.addressOfRecordID = addressOfRecordID;
    }

    @XmlTransient
    public List<Loanpreparation> getLoanpreparationList() {
        return loanpreparationList;
    }

    public void setLoanpreparationList(List<Loanpreparation> loanpreparationList) {
        this.loanpreparationList = loanpreparationList;
    }

    @XmlTransient
    public List<Loanagent> getLoanagentList() {
        return loanagentList;
    }

    public void setLoanagentList(List<Loanagent> loanagentList) {
        this.loanagentList = loanagentList;
    }

    @XmlTransient
    public List<Loanattachment> getLoanattachmentList() {
        return loanattachmentList;
    }

    public void setLoanattachmentList(List<Loanattachment> loanattachmentList) {
        this.loanattachmentList = loanattachmentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loanID != null ? loanID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loan)) {
            return false;
        }
        Loan other = (Loan) object;
        return !((this.loanID == null && other.loanID != null) || (this.loanID != null && !this.loanID.equals(other.loanID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Loan[ loanID=" + loanID + " ]";
    }
    
}
