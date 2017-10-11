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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
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
@Table(name = "accession")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accession.findAll", query = "SELECT a FROM Accession a"),
    @NamedQuery(name = "Accession.findByAccessionID", query = "SELECT a FROM Accession a WHERE a.accessionID = :accessionID"),   
    @NamedQuery(name = "Accession.findByAccessionNumber", query = "SELECT a FROM Accession a WHERE a.accessionNumber = :accessionNumber"),
    @NamedQuery(name = "Accession.findByDateAccessioned", query = "SELECT a FROM Accession a WHERE a.dateAccessioned = :dateAccessioned"),
    @NamedQuery(name = "Accession.findByDateAcknowledged", query = "SELECT a FROM Accession a WHERE a.dateAcknowledged = :dateAcknowledged"),
    @NamedQuery(name = "Accession.findByDateReceived", query = "SELECT a FROM Accession a WHERE a.dateReceived = :dateReceived"), 
    @NamedQuery(name = "Accession.findByType", query = "SELECT a FROM Accession a WHERE a.type = :type") })
public class Accession extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AccessionID")
    private Integer accessionID;
     
    @Size(max = 255)
    @Column(name = "AccessionCondition")
    private String accessionCondition;
    
    @Basic(optional = false)
    @NotNull(message="AccessNumber must be specified.")
    @Size(min = 1, max = 60)
    @Column(name = "AccessionNumber")
    private String accessionNumber;
    
    @Column(name = "DateAccessioned")
    @Temporal(TemporalType.DATE)
    private Date dateAccessioned;
    
    @Column(name = "DateAcknowledged")
    @Temporal(TemporalType.DATE)
    private Date dateAcknowledged;
    
    @Column(name = "DateReceived")
    @Temporal(TemporalType.DATE)
    private Date dateReceived;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Number1")
    private Float number1;
    
    @Column(name = "Number2")
    private Float number2;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Size(max = 32)
    @Column(name = "Status")
    private String status;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text1")
    private String text1;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text2")
    private String text2;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text3")
    private String text3;
    
    @Column(name = "TotalValue")
    private BigDecimal totalValue;
    
    @Size(max = 32)
    @Column(name = "Type")
    private String type;
    
    @Size(max = 50)
    @Column(name = "VerbatimDate")
    private String verbatimDate;
    
    @Column(name = "YesNo1")
    private Boolean yesNo1;
    
    @Column(name = "YesNo2")
    private Boolean yesNo2;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accessionID", fetch = FetchType.LAZY)
    private List<Accessionattachment> accessionattachmentList;
    
    @OneToMany(mappedBy = "accessionID", fetch = FetchType.LAZY)
    private List<Treatmentevent> treatmenteventList;
    
    @OneToMany(mappedBy = "accessionID", fetch = FetchType.LAZY)
    private List<Collectionobject> collectionobjectList;
    
    @OneToMany(mappedBy = "accessionID", cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    private List<Accessionagent> accessionagentList;
    
    @JoinColumn(name = "RepositoryAgreementID", referencedColumnName = "RepositoryAgreementID")
    @ManyToOne( fetch = FetchType.LAZY)
    private Repositoryagreement repositoryAgreementID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "DivisionID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne(optional = false,  fetch = FetchType.LAZY)
    private Division divisionID;
    
    @JoinColumn(name = "AddressOfRecordID", referencedColumnName = "AddressOfRecordID")
    @ManyToOne( fetch = FetchType.LAZY)
    private Addressofrecord addressOfRecordID;
    
    @OneToMany(mappedBy = "accessionID", fetch = FetchType.LAZY)
    private List<Appraisal> appraisalList;
    
    @OneToMany(mappedBy = "accessionID", fetch = FetchType.LAZY)
    private List<Accessionauthorization> accessionauthorizationList;
    
    @OneToMany(mappedBy = "accessionID", fetch = FetchType.LAZY)
    private List<Deaccession> deaccessionList;

    public Accession() {
    }

    public Accession(Integer accessionID) {
        this.accessionID = accessionID;
    }

    public Accession(Integer accessionID, Date timestampCreated, String accessionNumber) {
        this.accessionID = accessionID;
        this.timestampCreated = timestampCreated;
        this.accessionNumber = accessionNumber;
    }

    @XmlID 
    @XmlAttribute(name = "uuid") 
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + accessionID;
    }
    
    @XmlTransient
    @Override
    public int getEntityId() {
        return accessionID == null ? 0 : accessionID;
    }

    public Integer getAccessionID() {
        return accessionID;
    }

    public void setAccessionID(Integer accessionID) {
        this.accessionID = accessionID;
    }
 
    public String getAccessionCondition() {
        return accessionCondition;
    }

    public void setAccessionCondition(String accessionCondition) {
        this.accessionCondition = accessionCondition;
    }

    public String getAccessionNumber() {
        return accessionNumber;
    }

    public void setAccessionNumber(String accessionNumber) {
        this.accessionNumber = accessionNumber;
    }

    public Date getDateAccessioned() {
        return dateAccessioned;
    }

    public void setDateAccessioned(Date dateAccessioned) {
        this.dateAccessioned = dateAccessioned;
    }

    public Date getDateAcknowledged() {
        return dateAcknowledged;
    }

    public void setDateAcknowledged(Date dateAcknowledged) {
        this.dateAcknowledged = dateAcknowledged;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVerbatimDate() {
        return verbatimDate;
    }

    public void setVerbatimDate(String verbatimDate) {
        this.verbatimDate = verbatimDate;
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

    @XmlTransient
    public List<Accessionattachment> getAccessionattachmentList() {
        return accessionattachmentList;
    }

    public void setAccessionattachmentList(List<Accessionattachment> accessionattachmentList) {
        this.accessionattachmentList = accessionattachmentList;
    }

    @XmlTransient
    public List<Treatmentevent> getTreatmenteventList() {
        return treatmenteventList;
    }

    public void setTreatmenteventList(List<Treatmentevent> treatmenteventList) {
        this.treatmenteventList = treatmenteventList;
    }

    @XmlTransient
    public List<Collectionobject> getCollectionobjectList() {
        return collectionobjectList;
    }

    public void setCollectionobjectList(List<Collectionobject> collectionobjectList) {
        this.collectionobjectList = collectionobjectList;
    }

    @XmlIDREF
    @XmlElementWrapper(name = "accessionAgents")
    @XmlElement(name = "accessionAgent")
    public List<Accessionagent> getAccessionagentList() {
        return accessionagentList;
    }

    public void setAccessionagentList(List<Accessionagent> accessionagentList) {
        this.accessionagentList = accessionagentList;
    }

    @XmlTransient
    public Repositoryagreement getRepositoryAgreementID() {
        return repositoryAgreementID;
    }

    public void setRepositoryAgreementID(Repositoryagreement repositoryAgreementID) {
        this.repositoryAgreementID = repositoryAgreementID;
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

    @XmlTransient
    public Division getDivisionID() {
        return divisionID;
    }

    public void setDivisionID(Division divisionID) {
        this.divisionID = divisionID;
    }

    @XmlTransient
    public Addressofrecord getAddressOfRecordID() {
        return addressOfRecordID;
    }

    public void setAddressOfRecordID(Addressofrecord addressOfRecordID) {
        this.addressOfRecordID = addressOfRecordID;
    }

    @XmlTransient
    public List<Appraisal> getAppraisalList() {
        return appraisalList;
    }

    public void setAppraisalList(List<Appraisal> appraisalList) {
        this.appraisalList = appraisalList;
    }

    @XmlTransient
    public List<Accessionauthorization> getAccessionauthorizationList() {
        return accessionauthorizationList;
    }

    public void setAccessionauthorizationList(List<Accessionauthorization> accessionauthorizationList) {
        this.accessionauthorizationList = accessionauthorizationList;
    }

    @XmlTransient
    public List<Deaccession> getDeaccessionList() {
        return deaccessionList;
    }

    public void setDeaccessionList(List<Deaccession> deaccessionList) {
        this.deaccessionList = deaccessionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessionID != null ? accessionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accession)) {
            return false;
        }
        Accession other = (Accession) object;
        return !((this.accessionID == null && other.accessionID != null) || (this.accessionID != null && !this.accessionID.equals(other.accessionID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Accession[ accessionID=" + accessionID + " ]";
    }  
}
