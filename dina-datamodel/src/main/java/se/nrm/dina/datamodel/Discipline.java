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
@Table(name = "discipline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Discipline.findAll", query = "SELECT d FROM Discipline d"),
    @NamedQuery(name = "Discipline.findByUserGroupScopeId", query = "SELECT d FROM Discipline d WHERE d.userGroupScopeId = :userGroupScopeId"), 
    @NamedQuery(name = "Discipline.findByDisciplineId", query = "SELECT d FROM Discipline d WHERE d.disciplineId = :disciplineId"),
    @NamedQuery(name = "Discipline.findByName", query = "SELECT d FROM Discipline d WHERE d.name = :name"),
    @NamedQuery(name = "Discipline.findByRegNumber", query = "SELECT d FROM Discipline d WHERE d.regNumber = :regNumber"),
    @NamedQuery(name = "Discipline.findByType", query = "SELECT d FROM Discipline d WHERE d.type = :type"),
    @NamedQuery(name = "Discipline.findByIsPaleoContextEmbedded", query = "SELECT d FROM Discipline d WHERE d.isPaleoContextEmbedded = :isPaleoContextEmbedded"),
    @NamedQuery(name = "Discipline.findByPaleoContextChildTable", query = "SELECT d FROM Discipline d WHERE d.paleoContextChildTable = :paleoContextChildTable")})
public class Discipline extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "UserGroupScopeId")
    private Integer userGroupScopeId;
    
    
    @Column(name = "disciplineId")
    private Integer disciplineId;
    
    @Size(max = 64)
    @Column(name = "Name")
    private String name;
    
    @Size(max = 24)
    @Column(name = "RegNumber")
    private String regNumber;
    
    @Size(max = 64)
    @Column(name = "Type")
    private String type;
    
    @Column(name = "IsPaleoContextEmbedded")
    private Boolean isPaleoContextEmbedded;
    
    @Size(max = 50)
    @Column(name = "PaleoContextChildTable")
    private String paleoContextChildTable;
    
    @JoinTable(name = "autonumsch_dsp", joinColumns = {
        @JoinColumn(name = "DisciplineID", referencedColumnName = "UserGroupScopeId")}, inverseJoinColumns = {
        @JoinColumn(name = "AutoNumberingSchemeID", referencedColumnName = "AutoNumberingSchemeID")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Autonumberingscheme> autonumberingschemeList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplineID", fetch = FetchType.LAZY)
    private List<Gift> giftList;
    
    @JoinColumn(name = "LithoStratTreeDefID", referencedColumnName = "LithoStratTreeDefID")
    @ManyToOne
    private Lithostrattreedef lithoStratTreeDefID;
    
    @JoinColumn(name = "DivisionID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne(optional = false)
    private Division divisionID;
    
    @JoinColumn(name = "GeologicTimePeriodTreeDefID", referencedColumnName = "GeologicTimePeriodTreeDefID")
    @ManyToOne(optional = false)
    private Geologictimeperiodtreedef geologicTimePeriodTreeDefID;
    
    @JoinColumn(name = "GeographyTreeDefID", referencedColumnName = "GeographyTreeDefID")
    @ManyToOne(optional = false)
    private Geographytreedef geographyTreeDefID;
    
    @JoinColumn(name = "DataTypeID", referencedColumnName = "DataTypeID")
    @ManyToOne(optional = false)
    private Datatype dataTypeID;
    
    @JoinColumn(name = "TaxonTreeDefID", referencedColumnName = "TaxonTreeDefID")
    @ManyToOne
    private Taxontreedef taxonTreeDefID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @OneToMany(mappedBy = "disciplineID", fetch = FetchType.LAZY)
    private List<Sptasksemaphore> sptasksemaphoreList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplineID", fetch = FetchType.LAZY)
    private List<Collectingtrip> collectingtripList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplineID", fetch = FetchType.LAZY)
    private List<Locality> localityList;
    
    @OneToMany(mappedBy = "disciplineID", fetch = FetchType.LAZY)
    private List<Localitycitation> localitycitationList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplineID", fetch = FetchType.LAZY)
    private List<Fieldnotebookpageset> fieldnotebookpagesetList;
    
    @OneToMany(mappedBy = "disciplineID", fetch = FetchType.LAZY)
    private List<Paleocontext> paleocontextList;
    
    @OneToMany(mappedBy = "disciplineID", fetch = FetchType.LAZY)
    private List<Loanreturnpreparation> loanreturnpreparationList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplineID", fetch = FetchType.LAZY)
    private List<Localitynamealias> localitynamealiasList;
    
    @OneToMany(mappedBy = "disciplineID", fetch = FetchType.LAZY)
    private List<Collectingeventattribute> collectingeventattributeList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplineID", fetch = FetchType.LAZY)
    private List<Attributedef> attributedefList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplineID", fetch = FetchType.LAZY)
    private List<Collectingevent> collectingeventList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplineID", fetch = FetchType.LAZY)
    private List<Fieldnotebook> fieldnotebookList;
    
    @OneToMany(mappedBy = "disciplineID", fetch = FetchType.LAZY)
    private List<Shipment> shipmentList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplineID", fetch = FetchType.LAZY)
    private List<Splocalecontainer> splocalecontainerList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplineID", fetch = FetchType.LAZY)
    private List<Collection> collectionList;
    
    @OneToMany(mappedBy = "disciplineID", fetch = FetchType.LAZY)
    private List<Spappresourcedir> spappresourcedirList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplineID", fetch = FetchType.LAZY)
    private List<Spexportschema> spexportschemaList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplineID", fetch = FetchType.LAZY)
    private List<Loan> loanList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplineID", fetch = FetchType.LAZY)
    private List<Fieldnotebookpage> fieldnotebookpageList;
    
    @OneToMany(mappedBy = "disciplineID", fetch = FetchType.LAZY)
    private List<Giftagent> giftagentList;
    
    @OneToMany(mappedBy = "disciplineID", fetch = FetchType.LAZY)
    private List<Loanpreparation> loanpreparationList;
    
    @OneToMany(mappedBy = "disciplineID", fetch = FetchType.LAZY)
    private List<Giftpreparation> giftpreparationList;
    
    @OneToMany(mappedBy = "disciplineID", fetch = FetchType.LAZY)
    private List<Loanagent> loanagentList;

    public Discipline() {
    }

    public Discipline(Integer userGroupScopeId) {
        this.userGroupScopeId = userGroupScopeId;
    }

    public Discipline(Integer userGroupScopeId, Date timestampCreated) {
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
 
    public Integer getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(Integer disciplineId) {
        this.disciplineId = disciplineId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getIsPaleoContextEmbedded() {
        return isPaleoContextEmbedded;
    }

    public void setIsPaleoContextEmbedded(Boolean isPaleoContextEmbedded) {
        this.isPaleoContextEmbedded = isPaleoContextEmbedded;
    }

    public String getPaleoContextChildTable() {
        return paleoContextChildTable;
    }

    public void setPaleoContextChildTable(String paleoContextChildTable) {
        this.paleoContextChildTable = paleoContextChildTable;
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

    @XmlIDREF
    public Lithostrattreedef getLithoStratTreeDefID() {
        return lithoStratTreeDefID;
    }

    public void setLithoStratTreeDefID(Lithostrattreedef lithoStratTreeDefID) {
        this.lithoStratTreeDefID = lithoStratTreeDefID;
    }

    @XmlIDREF
    public Division getDivisionID() {
        return divisionID;
    }

    public void setDivisionID(Division divisionID) {
        this.divisionID = divisionID;
    }

    @XmlIDREF
    public Geologictimeperiodtreedef getGeologicTimePeriodTreeDefID() {
        return geologicTimePeriodTreeDefID;
    }

    public void setGeologicTimePeriodTreeDefID(Geologictimeperiodtreedef geologicTimePeriodTreeDefID) {
        this.geologicTimePeriodTreeDefID = geologicTimePeriodTreeDefID;
    }

    @XmlIDREF
    public Geographytreedef getGeographyTreeDefID() {
        return geographyTreeDefID;
    }

    public void setGeographyTreeDefID(Geographytreedef geographyTreeDefID) {
        this.geographyTreeDefID = geographyTreeDefID;
    }

    @XmlIDREF
    public Datatype getDataTypeID() {
        return dataTypeID;
    }

    public void setDataTypeID(Datatype dataTypeID) {
        this.dataTypeID = dataTypeID;
    }

    @XmlIDREF
    public Taxontreedef getTaxonTreeDefID() {
        return taxonTreeDefID;
    }

    public void setTaxonTreeDefID(Taxontreedef taxonTreeDefID) {
        this.taxonTreeDefID = taxonTreeDefID;
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
    public List<Sptasksemaphore> getSptasksemaphoreList() {
        return sptasksemaphoreList;
    }

    public void setSptasksemaphoreList(List<Sptasksemaphore> sptasksemaphoreList) {
        this.sptasksemaphoreList = sptasksemaphoreList;
    }

    @XmlTransient
    public List<Collectingtrip> getCollectingtripList() {
        return collectingtripList;
    }

    public void setCollectingtripList(List<Collectingtrip> collectingtripList) {
        this.collectingtripList = collectingtripList;
    }

    @XmlTransient
    public List<Locality> getLocalityList() {
        return localityList;
    }

    public void setLocalityList(List<Locality> localityList) {
        this.localityList = localityList;
    }

    @XmlTransient
    public List<Localitycitation> getLocalitycitationList() {
        return localitycitationList;
    }

    public void setLocalitycitationList(List<Localitycitation> localitycitationList) {
        this.localitycitationList = localitycitationList;
    }

    @XmlTransient
    public List<Fieldnotebookpageset> getFieldnotebookpagesetList() {
        return fieldnotebookpagesetList;
    }

    public void setFieldnotebookpagesetList(List<Fieldnotebookpageset> fieldnotebookpagesetList) {
        this.fieldnotebookpagesetList = fieldnotebookpagesetList;
    }

    @XmlTransient
    public List<Paleocontext> getPaleocontextList() {
        return paleocontextList;
    }

    public void setPaleocontextList(List<Paleocontext> paleocontextList) {
        this.paleocontextList = paleocontextList;
    }

    @XmlTransient
    public List<Loanreturnpreparation> getLoanreturnpreparationList() {
        return loanreturnpreparationList;
    }

    public void setLoanreturnpreparationList(List<Loanreturnpreparation> loanreturnpreparationList) {
        this.loanreturnpreparationList = loanreturnpreparationList;
    }

    @XmlTransient
    public List<Localitynamealias> getLocalitynamealiasList() {
        return localitynamealiasList;
    }

    public void setLocalitynamealiasList(List<Localitynamealias> localitynamealiasList) {
        this.localitynamealiasList = localitynamealiasList;
    }

    @XmlTransient
    public List<Collectingeventattribute> getCollectingeventattributeList() {
        return collectingeventattributeList;
    }

    public void setCollectingeventattributeList(List<Collectingeventattribute> collectingeventattributeList) {
        this.collectingeventattributeList = collectingeventattributeList;
    }

    @XmlTransient
    public List<Attributedef> getAttributedefList() {
        return attributedefList;
    }

    public void setAttributedefList(List<Attributedef> attributedefList) {
        this.attributedefList = attributedefList;
    }

    @XmlTransient
    public List<Collectingevent> getCollectingeventList() {
        return collectingeventList;
    }

    public void setCollectingeventList(List<Collectingevent> collectingeventList) {
        this.collectingeventList = collectingeventList;
    }

    @XmlTransient
    public List<Fieldnotebook> getFieldnotebookList() {
        return fieldnotebookList;
    }

    public void setFieldnotebookList(List<Fieldnotebook> fieldnotebookList) {
        this.fieldnotebookList = fieldnotebookList;
    }

    @XmlTransient
    public List<Shipment> getShipmentList() {
        return shipmentList;
    }

    public void setShipmentList(List<Shipment> shipmentList) {
        this.shipmentList = shipmentList;
    }

    @XmlTransient
    public List<Splocalecontainer> getSplocalecontainerList() {
        return splocalecontainerList;
    }

    public void setSplocalecontainerList(List<Splocalecontainer> splocalecontainerList) {
        this.splocalecontainerList = splocalecontainerList;
    }

    @XmlTransient
    public List<Collection> getCollectionList() {
        return collectionList;
    }

    public void setCollectionList(List<Collection> collectionList) {
        this.collectionList = collectionList;
    }

    @XmlTransient
    public List<Spappresourcedir> getSpappresourcedirList() {
        return spappresourcedirList;
    }

    public void setSpappresourcedirList(List<Spappresourcedir> spappresourcedirList) {
        this.spappresourcedirList = spappresourcedirList;
    }

    @XmlTransient
    public List<Spexportschema> getSpexportschemaList() {
        return spexportschemaList;
    }

    public void setSpexportschemaList(List<Spexportschema> spexportschemaList) {
        this.spexportschemaList = spexportschemaList;
    }

    @XmlTransient
    public List<Loan> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<Loan> loanList) {
        this.loanList = loanList;
    }

    @XmlTransient
    public List<Fieldnotebookpage> getFieldnotebookpageList() {
        return fieldnotebookpageList;
    }

    public void setFieldnotebookpageList(List<Fieldnotebookpage> fieldnotebookpageList) {
        this.fieldnotebookpageList = fieldnotebookpageList;
    }

    @XmlTransient
    public List<Giftagent> getGiftagentList() {
        return giftagentList;
    }

    public void setGiftagentList(List<Giftagent> giftagentList) {
        this.giftagentList = giftagentList;
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
    public List<Loanagent> getLoanagentList() {
        return loanagentList;
    }

    public void setLoanagentList(List<Loanagent> loanagentList) {
        this.loanagentList = loanagentList;
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
        if (!(object instanceof Discipline)) {
            return false;
        }
        Discipline other = (Discipline) object;
        return !((this.userGroupScopeId == null && other.userGroupScopeId != null) || (this.userGroupScopeId != null && !this.userGroupScopeId.equals(other.userGroupScopeId)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Discipline[ userGroupScopeId=" + userGroupScopeId + " ]";
    }
    
}
