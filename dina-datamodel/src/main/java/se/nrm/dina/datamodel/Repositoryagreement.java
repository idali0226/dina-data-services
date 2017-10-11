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
@Table(name = "repositoryagreement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Repositoryagreement.findAll", query = "SELECT r FROM Repositoryagreement r"),
    @NamedQuery(name = "Repositoryagreement.findByRepositoryAgreementID", query = "SELECT r FROM Repositoryagreement r WHERE r.repositoryAgreementID = :repositoryAgreementID"), 
    @NamedQuery(name = "Repositoryagreement.findByDateReceived", query = "SELECT r FROM Repositoryagreement r WHERE r.dateReceived = :dateReceived"),
    @NamedQuery(name = "Repositoryagreement.findByEndDate", query = "SELECT r FROM Repositoryagreement r WHERE r.endDate = :endDate"), 
    @NamedQuery(name = "Repositoryagreement.findByRepositoryAgreementNumber", query = "SELECT r FROM Repositoryagreement r WHERE r.repositoryAgreementNumber = :repositoryAgreementNumber"),
    @NamedQuery(name = "Repositoryagreement.findByStartDate", query = "SELECT r FROM Repositoryagreement r WHERE r.startDate = :startDate"),
    @NamedQuery(name = "Repositoryagreement.findByStatus", query = "SELECT r FROM Repositoryagreement r WHERE r.status = :status")})
public class Repositoryagreement extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RepositoryAgreementID")
    private Integer repositoryAgreementID;
    
    
    @Column(name = "DateReceived")
    @Temporal(TemporalType.DATE)
    private Date dateReceived;
    
    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Number1")
    private Float number1;
    
    @Column(name = "Number2")
    private Float number2;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "RepositoryAgreementNumber")
    private String repositoryAgreementNumber;
    
    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    
    @Size(max = 32)
    @Column(name = "Status")
    private String status;
    
    @Size(max = 255)
    @Column(name = "Text1")
    private String text1;
    
    @Size(max = 255)
    @Column(name = "Text2")
    private String text2;
    
    @Size(max = 255)
    @Column(name = "Text3")
    private String text3;
    
    @Column(name = "YesNo1")
    private Boolean yesNo1;
    
    @Column(name = "YesNo2")
    private Boolean yesNo2;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "repositoryAgreementID", fetch = FetchType.LAZY)
    private List<Repositoryagreementattachment> repositoryagreementattachmentList;
    
    @JoinColumn(name = "AgentID", referencedColumnName = "AgentID")
    @ManyToOne(optional = false)
    private Agent agentID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "DivisionID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne(optional = false)
    private Division divisionID;
    
    @JoinColumn(name = "AddressOfRecordID", referencedColumnName = "AddressOfRecordID")
    @ManyToOne
    private Addressofrecord addressOfRecordID;
    
    @OneToMany(mappedBy = "repositoryAgreementID", fetch = FetchType.LAZY)
    private List<Accessionagent> accessionagentList;
    
    @OneToMany(mappedBy = "repositoryAgreementID", fetch = FetchType.LAZY)
    private List<Accession> accessionList;
    
    @OneToMany(mappedBy = "repositoryAgreementID", fetch = FetchType.LAZY)
    private List<Accessionauthorization> accessionauthorizationList;

    public Repositoryagreement() {
    }

    public Repositoryagreement(Integer repositoryAgreementID) {
        this.repositoryAgreementID = repositoryAgreementID;
    }

    public Repositoryagreement(Integer repositoryAgreementID, Date timestampCreated, String repositoryAgreementNumber) {
        this.repositoryAgreementID = repositoryAgreementID;
        this.timestampCreated = timestampCreated;
        this.repositoryAgreementNumber = repositoryAgreementNumber;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + repositoryAgreementID;
    }
    
    @Override
    public int getEntityId() {
        return repositoryAgreementID;
    }

    public Integer getRepositoryAgreementID() {
        return repositoryAgreementID;
    }

    public void setRepositoryAgreementID(Integer repositoryAgreementID) {
        this.repositoryAgreementID = repositoryAgreementID;
    }
 

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public String getRepositoryAgreementNumber() {
        return repositoryAgreementNumber;
    }

    public void setRepositoryAgreementNumber(String repositoryAgreementNumber) {
        this.repositoryAgreementNumber = repositoryAgreementNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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
    public List<Repositoryagreementattachment> getRepositoryagreementattachmentList() {
        return repositoryagreementattachmentList;
    }

    public void setRepositoryagreementattachmentList(List<Repositoryagreementattachment> repositoryagreementattachmentList) {
        this.repositoryagreementattachmentList = repositoryagreementattachmentList;
    }

    @XmlIDREF
    public Agent getAgentID() {
        return agentID;
    }

    public void setAgentID(Agent agentID) {
        this.agentID = agentID;
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
    public List<Accessionagent> getAccessionagentList() {
        return accessionagentList;
    }

    public void setAccessionagentList(List<Accessionagent> accessionagentList) {
        this.accessionagentList = accessionagentList;
    }

    @XmlTransient
    public List<Accession> getAccessionList() {
        return accessionList;
    }

    public void setAccessionList(List<Accession> accessionList) {
        this.accessionList = accessionList;
    }

    @XmlTransient
    public List<Accessionauthorization> getAccessionauthorizationList() {
        return accessionauthorizationList;
    }

    public void setAccessionauthorizationList(List<Accessionauthorization> accessionauthorizationList) {
        this.accessionauthorizationList = accessionauthorizationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (repositoryAgreementID != null ? repositoryAgreementID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Repositoryagreement)) {
            return false;
        }
        Repositoryagreement other = (Repositoryagreement) object;
        return !((this.repositoryAgreementID == null && other.repositoryAgreementID != null) || (this.repositoryAgreementID != null && !this.repositoryAgreementID.equals(other.repositoryAgreementID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Repositoryagreement[ repositoryAgreementID=" + repositoryAgreementID + " ]";
    }
    
}
