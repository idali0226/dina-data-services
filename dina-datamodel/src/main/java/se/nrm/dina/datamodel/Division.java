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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table; 
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
@Table(name = "division")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Division.findAll", query = "SELECT d FROM Division d"),
    @NamedQuery(name = "Division.findByUserGroupScopeId", query = "SELECT d FROM Division d WHERE d.userGroupScopeId = :userGroupScopeId"), 
    @NamedQuery(name = "Division.findByDisciplineType", query = "SELECT d FROM Division d WHERE d.disciplineType = :disciplineType"),
    @NamedQuery(name = "Division.findByDivisionId", query = "SELECT d FROM Division d WHERE d.divisionId = :divisionId"),
    @NamedQuery(name = "Division.findByIconURI", query = "SELECT d FROM Division d WHERE d.iconURI = :iconURI"),
    @NamedQuery(name = "Division.findByName", query = "SELECT d FROM Division d WHERE d.name = :name"), 
    @NamedQuery(name = "Division.findByUri", query = "SELECT d FROM Division d WHERE d.uri = :uri")})
public class Division extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "UserGroupScopeId")
    private Integer userGroupScopeId;
   
    
    @Size(max = 64)
    @Column(name = "Abbrev")
    private String abbrev;
    
    @Size(max = 128)
    @Column(name = "AltName")
    private String altName;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Description")
    private String description;
    
    @Size(max = 64)
    @Column(name = "DisciplineType")
    private String disciplineType;
    
    @Column(name = "divisionId")
    private Integer divisionId;
    
    @Size(max = 255)
    @Column(name = "IconURI")
    private String iconURI;
    
    @Size(max = 255)
    @Column(name = "Name")
    private String name;
    
    @Size(max = 24)
    @Column(name = "RegNumber")
    private String regNumber;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Size(max = 255)
    @Column(name = "Uri")
    private String uri;
    @JoinTable(name = "autonumsch_div", joinColumns = {
        @JoinColumn(name = "DivisionID", referencedColumnName = "UserGroupScopeId")}, inverseJoinColumns = {
        @JoinColumn(name = "AutoNumberingSchemeID", referencedColumnName = "AutoNumberingSchemeID")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Autonumberingscheme> autonumberingschemeList;
    
    @OneToMany(mappedBy = "divisionID", fetch = FetchType.LAZY)
    private List<Gift> giftList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "divisionID", fetch = FetchType.LAZY)
    private List<Discipline> disciplineList;
    
    @JoinColumn(name = "InstitutionID", referencedColumnName = "UserGroupScopeId" )
    @ManyToOne(optional = false )
    private Institution institutionID;
    
    @JoinColumn(name = "AddressID", referencedColumnName = "AddressID")
    @ManyToOne
    private Address addressID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @OneToMany(mappedBy = "divisionID" , fetch = FetchType.LAZY)
    private List<Conservdescription> conservdescriptionList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "divisionID", fetch = FetchType.LAZY)
    private List<Exchangeout> exchangeoutList;
    
    @OneToMany(mappedBy = "divisionID", fetch = FetchType.LAZY)
    private List<Treatmentevent> treatmenteventList;
    
    @OneToMany(mappedBy = "divisionID", fetch = FetchType.LAZY)
    private List<Groupperson> grouppersonList;
    
    @OneToMany(mappedBy = "divisionID", fetch = FetchType.LAZY)
    private List<Agent> agentList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "divisionID", fetch = FetchType.LAZY)
    private List<Repositoryagreement> repositoryagreementList;
    
    @OneToMany(mappedBy = "divisionID", fetch = FetchType.LAZY)
    private List<Loan> loanList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "divisionID", fetch = FetchType.LAZY)
    private List<Accession> accessionList;
    
    @OneToMany(mappedBy = "divisionID", fetch = FetchType.LAZY)
    private List<Collector> collectorList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "divisionID", fetch = FetchType.LAZY)
    private List<Exchangein> exchangeinList;

    public Division() {
    }

    public Division(Integer userGroupScopeId) {
        this.userGroupScopeId = userGroupScopeId;
    }

    public Division(Integer userGroupScopeId, Date timestampCreated) {
        this.userGroupScopeId = userGroupScopeId;
        this.timestampCreated = timestampCreated;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + userGroupScopeId;
    }
    
    @Override
    public int getEntityId() {
        return userGroupScopeId;
    }

    public Integer getUserGroupScopeId() {
        return userGroupScopeId;
    }

    public void setUserGroupScopeId(Integer userGroupScopeId) {
        this.userGroupScopeId = userGroupScopeId;
    }
 
    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public String getAltName() {
        return altName;
    }

    public void setAltName(String altName) {
        this.altName = altName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisciplineType() {
        return disciplineType;
    }

    public void setDisciplineType(String disciplineType) {
        this.disciplineType = disciplineType;
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public String getIconURI() {
        return iconURI;
    }

    public void setIconURI(String iconURI) {
        this.iconURI = iconURI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @XmlTransient
    public List<Autonumberingscheme> getAutonumberingschemeList() {
        return autonumberingschemeList;
    }

    public void setAutonumberingschemeList(List<Autonumberingscheme> autonumberingschemeList) {
        this.autonumberingschemeList = autonumberingschemeList;
    }

    @XmlTransient
    public List<Gift> getGiftList() {
        return giftList;
    }

    public void setGiftList(List<Gift> giftList) {
        this.giftList = giftList;
    }

    @XmlTransient
    public List<Discipline> getDisciplineList() {
        return disciplineList;
    }

    public void setDisciplineList(List<Discipline> disciplineList) {
        this.disciplineList = disciplineList;
    }

    @XmlIDREF
    public Institution getInstitutionID() {
        return institutionID;
    }

    public void setInstitutionID(Institution institutionID) {
        this.institutionID = institutionID;
    }

    @XmlIDREF
    public Address getAddressID() {
        return addressID;
    }

    public void setAddressID(Address addressID) {
        this.addressID = addressID;
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
    public List<Conservdescription> getConservdescriptionList() {
        return conservdescriptionList;
    }

    public void setConservdescriptionList(List<Conservdescription> conservdescriptionList) {
        this.conservdescriptionList = conservdescriptionList;
    }

    @XmlTransient
    public List<Exchangeout> getExchangeoutList() {
        return exchangeoutList;
    }

    public void setExchangeoutList(List<Exchangeout> exchangeoutList) {
        this.exchangeoutList = exchangeoutList;
    }

    @XmlTransient
    public List<Treatmentevent> getTreatmenteventList() {
        return treatmenteventList;
    }

    public void setTreatmenteventList(List<Treatmentevent> treatmenteventList) {
        this.treatmenteventList = treatmenteventList;
    }

    @XmlTransient
    public List<Groupperson> getGrouppersonList() {
        return grouppersonList;
    }

    public void setGrouppersonList(List<Groupperson> grouppersonList) {
        this.grouppersonList = grouppersonList;
    }

    @XmlTransient
    public List<Agent> getAgentList() {
        return agentList;
    }

    public void setAgentList(List<Agent> agentList) {
        this.agentList = agentList;
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
    public List<Collector> getCollectorList() {
        return collectorList;
    }

    public void setCollectorList(List<Collector> collectorList) {
        this.collectorList = collectorList;
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
        hash += (userGroupScopeId != null ? userGroupScopeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Division)) {
            return false;
        }
        Division other = (Division) object;
        return !((this.userGroupScopeId == null && other.userGroupScopeId != null) || (this.userGroupScopeId != null && !this.userGroupScopeId.equals(other.userGroupScopeId)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Division[ userGroupScopeId=" + userGroupScopeId + " ]";
    }
    
}
