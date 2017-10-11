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
@Table(name = "addressofrecord")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Addressofrecord.findAll", query = "SELECT a FROM Addressofrecord a"),
    @NamedQuery(name = "Addressofrecord.findByAddressOfRecordID", query = "SELECT a FROM Addressofrecord a WHERE a.addressOfRecordID = :addressOfRecordID"), 
    @NamedQuery(name = "Addressofrecord.findByAddress", query = "SELECT a FROM Addressofrecord a WHERE a.address = :address"),
    @NamedQuery(name = "Addressofrecord.findByAddress2", query = "SELECT a FROM Addressofrecord a WHERE a.address2 = :address2"),
    @NamedQuery(name = "Addressofrecord.findByCity", query = "SELECT a FROM Addressofrecord a WHERE a.city = :city"),
    @NamedQuery(name = "Addressofrecord.findByCountry", query = "SELECT a FROM Addressofrecord a WHERE a.country = :country"),
    @NamedQuery(name = "Addressofrecord.findByPostalCode", query = "SELECT a FROM Addressofrecord a WHERE a.postalCode = :postalCode"),
    @NamedQuery(name = "Addressofrecord.findByState", query = "SELECT a FROM Addressofrecord a WHERE a.state = :state")})
public class Addressofrecord extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AddressOfRecordID")
    private Integer addressOfRecordID;
 
    @Size(max = 255)
    @Column(name = "Address")
    private String address;
    
    @Size(max = 255)
    @Column(name = "Address2")
    private String address2;
    
    @Size(max = 64)
    @Column(name = "City")
    private String city;
    
    @Size(max = 64)
    @Column(name = "Country")
    private String country;
    
    @Size(max = 32)
    @Column(name = "PostalCode")
    private String postalCode;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Size(max = 64)
    @Column(name = "State")
    private String state;
    
    @OneToMany(mappedBy = "addressOfRecordID", fetch = FetchType.LAZY)
    private List<Gift> giftList;
    
    @OneToMany(mappedBy = "addressOfRecordID", fetch = FetchType.LAZY)
    private List<Exchangeout> exchangeoutList;
    
    @JoinColumn(name = "AgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent agentID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @OneToMany(mappedBy = "addressOfRecordID", fetch = FetchType.LAZY)
    private List<Borrow> borrowList;
    
    @OneToMany(mappedBy = "addressOfRecordID", fetch = FetchType.LAZY)
    private List<Repositoryagreement> repositoryagreementList;
    
    @OneToMany(mappedBy = "addressOfRecordID", fetch = FetchType.LAZY)
    private List<Loan> loanList;
    
    @OneToMany(mappedBy = "addressOfRecordID", fetch = FetchType.LAZY)
    private List<Accession> accessionList;
    
    @OneToMany(mappedBy = "addressOfRecordID", fetch = FetchType.LAZY)
    private List<Exchangein> exchangeinList;

    public Addressofrecord() {
    }

    public Addressofrecord(Integer addressOfRecordID) {
        this.addressOfRecordID = addressOfRecordID;
    }

    public Addressofrecord(Integer addressOfRecordID, Date timestampCreated) {
        this.addressOfRecordID = addressOfRecordID;
        this.timestampCreated = timestampCreated;
    }

    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + addressOfRecordID;
    }

    @Override
    public int getEntityId() {
        return addressOfRecordID;
    }

    public Integer getAddressOfRecordID() {
        return addressOfRecordID;
    }

    public void setAddressOfRecordID(Integer addressOfRecordID) {
        this.addressOfRecordID = addressOfRecordID;
    }
 

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @XmlTransient
    public List<Gift> getGiftList() {
        return giftList;
    }

    public void setGiftList(List<Gift> giftList) {
        this.giftList = giftList;
    }

    @XmlTransient
    public List<Exchangeout> getExchangeoutList() {
        return exchangeoutList;
    }

    public void setExchangeoutList(List<Exchangeout> exchangeoutList) {
        this.exchangeoutList = exchangeoutList;
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

    @XmlTransient
    public List<Borrow> getBorrowList() {
        return borrowList;
    }

    public void setBorrowList(List<Borrow> borrowList) {
        this.borrowList = borrowList;
    }

    @XmlTransient
    public List<Repositoryagreement> getRepositoryagreementList() {
        return repositoryagreementList;
    }

    public void setRepositoryagreementList(List<Repositoryagreement> repositoryagreementList) {
        this.repositoryagreementList = repositoryagreementList;
    }

    @XmlTransient
    public List<Loan> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<Loan> loanList) {
        this.loanList = loanList;
    }

    @XmlTransient
    public List<Accession> getAccessionList() {
        return accessionList;
    }

    public void setAccessionList(List<Accession> accessionList) {
        this.accessionList = accessionList;
    }

    @XmlTransient
    public List<Exchangein> getExchangeinList() {
        return exchangeinList;
    }

    public void setExchangeinList(List<Exchangein> exchangeinList) {
        this.exchangeinList = exchangeinList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressOfRecordID != null ? addressOfRecordID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Addressofrecord)) {
            return false;
        }
        Addressofrecord other = (Addressofrecord) object;
        return !((this.addressOfRecordID == null && other.addressOfRecordID != null) || (this.addressOfRecordID != null && !this.addressOfRecordID.equals(other.addressOfRecordID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Addressofrecord[ addressOfRecordID=" + addressOfRecordID + " ]";
    }
    
}
