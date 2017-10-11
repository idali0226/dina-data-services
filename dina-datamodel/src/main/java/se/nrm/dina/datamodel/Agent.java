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
import javax.validation.constraints.Pattern;
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
@Table(name = "agent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agent.findAll", query = "SELECT a FROM Agent a"),
    @NamedQuery(name = "Agent.findByAgentID", query = "SELECT a FROM Agent a WHERE a.agentID = :agentID"),  
    @NamedQuery(name = "Agent.findByAgentType", query = "SELECT a FROM Agent a WHERE a.agentType = :agentType"),   
    @NamedQuery(name = "Agent.findByEmail", query = "SELECT a FROM Agent a WHERE a.email = :email"),
    @NamedQuery(name = "Agent.findByFirstName", query = "SELECT a FROM Agent a WHERE a.firstName = :firstName"),
    @NamedQuery(name = "Agent.findByGuid", query = "SELECT a FROM Agent a WHERE a.guid = :guid"),   
    @NamedQuery(name = "Agent.findByLastName", query = "SELECT a FROM Agent a WHERE a.lastName = :lastName"),  
    @NamedQuery(name = "Agent.findByDateType", query = "SELECT a FROM Agent a WHERE a.dateType = :dateType") })
public class Agent extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AgentID")
    private Integer agentID;
    
    @Size(max = 50)
    @Column(name = "Abbreviation")
    private String abbreviation;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "AgentType")
    private short agentType;
    
    @Column(name = "DateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    
    @Column(name = "DateOfBirthPrecision")
    private Short dateOfBirthPrecision;
    
    @Column(name = "DateOfDeath")
    @Temporal(TemporalType.DATE)
    private Date dateOfDeath;
    
    @Column(name = "DateOfDeathPrecision")
    private Short dateOfDeathPrecision;
    
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "Email")
    private String email;
    
    @Size(max = 50)
    @Column(name = "FirstName")
    private String firstName;
    
    @Size(max = 128)
    @Column(name = "GUID")
    private String guid;
    
    @Size(max = 8)
    @Column(name = "Initials")
    private String initials;
    
    @Size(max = 255)
    @Column(name = "Interests")
    private String interests;
    
    @Size(max = 50)
    @Column(name = "JobTitle")
    private String jobTitle;
    
    @Size(max = 128)
    @Column(name = "LastName")
    private String lastName;
    
    @Size(max = 50)
    @Column(name = "MiddleInitial")
    private String middleInitial;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Size(max = 50)
    @Column(name = "Title")
    private String title;
    
    @Column(name = "DateType")
    private Short dateType;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "URL")
    private String url;
    
    @Size(max = 50)
    @Column(name = "Suffix")
    private String suffix;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Container> containerList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Container> containerList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Gift> giftList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Gift> giftList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Geologictimeperiodtreedef> geologictimeperiodtreedefList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Geologictimeperiodtreedef> geologictimeperiodtreedefList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Collectingeventattachment> collectingeventattachmentList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Collectingeventattachment> collectingeventattachmentList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Taxontreedef> taxontreedefList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Taxontreedef> taxontreedefList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Preparationattachment> preparationattachmentList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Preparationattachment> preparationattachmentList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Determination> determinationList;
    
    @OneToMany(mappedBy = "createdByAgentID",fetch = FetchType.LAZY)
    private List<Determination> determinationList1;
    
    @OneToMany(mappedBy = "determinerID", fetch = FetchType.LAZY)
    private List<Determination> determinationList2;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Discipline> disciplineList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Discipline> disciplineList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Spfieldvaluedefault> spfieldvaluedefaultList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Spfieldvaluedefault> spfieldvaluedefaultList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Exsiccataitem> exsiccataitemList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Exsiccataitem> exsiccataitemList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Preparation> preparationList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Preparation> preparationList1;
    
    @OneToMany(mappedBy = "preparedByID", fetch = FetchType.LAZY)
    private List<Preparation> preparationList2;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Division> divisionList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Division> divisionList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Sptasksemaphore> sptasksemaphoreList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Sptasksemaphore> sptasksemaphoreList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Repositoryagreementattachment> repositoryagreementattachmentList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Repositoryagreementattachment> repositoryagreementattachmentList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Geography> geographyList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Geography> geographyList1;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agentID", fetch = FetchType.LAZY)
    private List<Agentattachment> agentattachmentList;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Agentattachment> agentattachmentList1;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Agentattachment> agentattachmentList2;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Picklistitem> picklistitemList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Picklistitem> picklistitemList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Permitattachment> permitattachmentList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Permitattachment> permitattachmentList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Collectingtrip> collectingtripList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Collectingtrip> collectingtripList1;
    
    @OneToMany(mappedBy = "agentID", fetch = FetchType.LAZY)
    private List<Geocoorddetail> geocoorddetailList;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Geocoorddetail> geocoorddetailList1;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Geocoorddetail> geocoorddetailList2;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Dnasequencingrun> dnasequencingrunList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Dnasequencingrun> dnasequencingrunList1;
    
    @OneToMany(mappedBy = "runByAgentID", fetch = FetchType.LAZY)
    private List<Dnasequencingrun> dnasequencingrunList2;
    
    @OneToMany(mappedBy = "preparedByAgentID", fetch = FetchType.LAZY)
    private List<Dnasequencingrun> dnasequencingrunList3;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Preptype> preptypeList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Preptype> preptypeList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Conservdescription> conservdescriptionList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Conservdescription> conservdescriptionList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Locality> localityList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Locality> localityList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Accessionattachment> accessionattachmentList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Accessionattachment> accessionattachmentList1;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catalogedByID", fetch = FetchType.LAZY)
    private List<Exchangeout> exchangeoutList;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Exchangeout> exchangeoutList1;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Exchangeout> exchangeoutList2;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sentToOrganizationID", fetch = FetchType.LAZY)
    private List<Exchangeout> exchangeoutList3;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Borrowmaterial> borrowmaterialList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Borrowmaterial> borrowmaterialList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Dnasequenceattachment> dnasequenceattachmentList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Dnasequenceattachment> dnasequenceattachmentList1;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agentID",fetch = FetchType.LAZY)
    private List<Agentvariant> agentvariantList;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Agentvariant> agentvariantList1;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Agentvariant> agentvariantList2;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Localitycitation> localitycitationList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Localitycitation> localitycitationList1;
    
    @OneToMany(mappedBy = "agentID", fetch = FetchType.LAZY)
    private List<Fieldnotebookpageset> fieldnotebookpagesetList;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Fieldnotebookpageset> fieldnotebookpagesetList1;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Fieldnotebookpageset> fieldnotebookpagesetList2;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Paleocontext> paleocontextList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Paleocontext> paleocontextList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Collectionobjectattribute> collectionobjectattributeList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Collectionobjectattribute> collectionobjectattributeList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Collectionobjectattachment> collectionobjectattachmentList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Collectionobjectattachment> collectionobjectattachmentList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY )
    private List<Storageattachment> storageattachmentList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Storageattachment> storageattachmentList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Exsiccata> exsiccataList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Exsiccata> exsiccataList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Attachmentmetadata> attachmentmetadataList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Attachmentmetadata> attachmentmetadataList1;
    
    @OneToMany(mappedBy = "receivedByID", fetch = FetchType.LAZY)
    private List<Loanreturnpreparation> loanreturnpreparationList;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Loanreturnpreparation> loanreturnpreparationList1;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Loanreturnpreparation> loanreturnpreparationList2;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Localitynamealias> localitynamealiasList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Localitynamealias> localitynamealiasList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Recordset> recordsetList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Recordset> recordsetList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Spappresource> spappresourceList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Spappresource> spappresourceList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Taxonattachment> taxonattachmentList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Taxonattachment> taxonattachmentList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Storagetreedefitem> storagetreedefitemList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Storagetreedefitem> storagetreedefitemList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Determinationcitation> determinationcitationList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Determinationcitation> determinationcitationList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Conserveventattachment> conserveventattachmentList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Conserveventattachment> conserveventattachmentList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Lithostrattreedefitem> lithostrattreedefitemList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Lithostrattreedefitem> lithostrattreedefitemList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Journal> journalList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Journal> journalList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Datatype> datatypeList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Datatype> datatypeList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Collectionreltype> collectionreltypeList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Collectionreltype> collectionreltypeList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Taxon> taxonList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Taxon> taxonList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Localityattachment> localityattachmentList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Localityattachment> localityattachmentList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Treatmentevent> treatmenteventList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Treatmentevent> treatmenteventList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Storagetreedef> storagetreedefList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Storagetreedef> storagetreedefList1;
    
    @OneToMany(mappedBy = "agentID", fetch = FetchType.LAZY)
    private List<Address> addressList;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Address> addressList1;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Address> addressList2;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Spexportschemaitem> spexportschemaitemList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Spexportschemaitem> spexportschemaitemList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Splocaleitemstr> splocaleitemstrList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Splocaleitemstr> splocaleitemstrList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Workbenchtemplatemappingitem> workbenchtemplatemappingitemList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Workbenchtemplatemappingitem> workbenchtemplatemappingitemList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Lithostrattreedef> lithostrattreedefList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Lithostrattreedef> lithostrattreedefList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Autonumberingscheme> autonumberingschemeList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Autonumberingscheme> autonumberingschemeList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Conservdescriptionattachment> conservdescriptionattachmentList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Conservdescriptionattachment> conservdescriptionattachmentList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Collectingeventattribute> collectingeventattributeList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Collectingeventattribute> collectingeventattributeList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Spquery> spqueryList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Spquery> spqueryList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Geographytreedef> geographytreedefList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Geographytreedef> geographytreedefList1;
    
    @OneToMany(mappedBy = "agentID", fetch = FetchType.LAZY)
    private List<Addressofrecord> addressofrecordList;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Addressofrecord> addressofrecordList1;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Addressofrecord> addressofrecordList2;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agentID", fetch = FetchType.LAZY)
    private List<Deaccessionagent> deaccessionagentList;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Deaccessionagent> deaccessionagentList1;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Deaccessionagent> deaccessionagentList2;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Borrow> borrowList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Borrow> borrowList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Localitydetail> localitydetailList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Localitydetail> localitydetailList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Commonnametxcitation> commonnametxcitationList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Commonnametxcitation> commonnametxcitationList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Spqueryfield> spqueryfieldList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Spqueryfield> spqueryfieldList1;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "memberID", fetch = FetchType.LAZY)
    private List<Groupperson> grouppersonList;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Groupperson> grouppersonList1;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Groupperson> grouppersonList2;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupID", fetch = FetchType.LAZY)
    private List<Groupperson> grouppersonList3;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Attributedef> attributedefList;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Attributedef> attributedefList1;
    
    @JoinColumn(name = "CollectionCCID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Collection collectionCCID;
    
    @JoinColumn(name = "CollectionTCID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Collection collectionTCID;
    
    @JoinColumn(name = "SpecifyUserID", referencedColumnName = "SpecifyUserID")
    @ManyToOne
    private Specifyuser specifyUserID;
    
    @OneToMany(mappedBy = "modifiedByAgentID", fetch = FetchType.LAZY)
    private List<Agent> agentList;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @OneToMany(mappedBy = "createdByAgentID", fetch = FetchType.LAZY)
    private List<Agent> agentList1;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @OneToMany(mappedBy = "parentOrganizationID", fetch = FetchType.LAZY)
    private List<Agent> agentList2;
    
    @JoinColumn(name = "ParentOrganizationID", referencedColumnName = "AgentID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Agent parentOrganizationID;
    
    @JoinColumn(name = "InstitutionCCID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne(  fetch = FetchType.LAZY)
    private Institution institutionCCID;
    
    @JoinColumn(name = "InstitutionTCID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne(  fetch = FetchType.LAZY)
    private Institution institutionTCID;
    
    @JoinColumn(name = "DivisionID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne(  fetch = FetchType.LAZY)
    private Division divisionID;
    
    @OneToMany(mappedBy = "catalogerID",  fetch = FetchType.LAZY )
    private List<Collectionobject> collectionobjectList;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Collectionobject> collectionobjectList1;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Collectionobject> collectionobjectList2;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Project> projectList;
    
    @OneToMany(mappedBy = "projectAgentID",  fetch = FetchType.LAZY )
    private List<Project> projectList1;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Project> projectList2;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Splocalecontaineritem> splocalecontaineritemList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Splocalecontaineritem> splocalecontaineritemList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Institution> institutionList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Institution> institutionList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Collectingevent> collectingeventList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Collectingevent> collectingeventList1;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agentID",  fetch = FetchType.LAZY )
    private List<Fieldnotebook> fieldnotebookList;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Fieldnotebook> fieldnotebookList1;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Fieldnotebook> fieldnotebookList2;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Geologictimeperiod> geologictimeperiodList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Geologictimeperiod> geologictimeperiodList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Lithostrat> lithostratList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Lithostrat> lithostratList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Taxoncitation> taxoncitationList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Taxoncitation> taxoncitationList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Dnasequencingruncitation> dnasequencingruncitationList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Dnasequencingruncitation> dnasequencingruncitationList1;
    
    @OneToMany(mappedBy = "agentID",  fetch = FetchType.LAZY )
    private List<Dnasequence> dnasequenceList;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Dnasequence> dnasequenceList1;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Dnasequence> dnasequenceList2;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Preparationattr> preparationattrList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Preparationattr> preparationattrList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Borrowreturnmaterial> borrowreturnmaterialList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Borrowreturnmaterial> borrowreturnmaterialList1;
    
    @OneToMany(mappedBy = "returnedByID",  fetch = FetchType.LAZY )
    private List<Borrowreturnmaterial> borrowreturnmaterialList2;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Workbench> workbenchList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Workbench> workbenchList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Spauditlogfield> spauditlogfieldList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Spauditlogfield> spauditlogfieldList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Referencework> referenceworkList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Referencework> referenceworkList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Shipment> shipmentList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Shipment> shipmentList1;
    
    @OneToMany(mappedBy = "shippedByID",  fetch = FetchType.LAZY )
    private List<Shipment> shipmentList2;
    
    @OneToMany(mappedBy = "shippedToID",  fetch = FetchType.LAZY )
    private List<Shipment> shipmentList3;
    
    @OneToMany(mappedBy = "shipperID",  fetch = FetchType.LAZY )
    private List<Shipment> shipmentList4;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agentID",  fetch = FetchType.LAZY )
    private List<Repositoryagreement> repositoryagreementList;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Repositoryagreement> repositoryagreementList1;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Repositoryagreement> repositoryagreementList2;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Splocalecontainer> splocalecontainerList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Splocalecontainer> splocalecontainerList1;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agentID",  fetch = FetchType.LAZY )
    private List<Author> authorList;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Author> authorList1;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Author> authorList2;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agentID",  fetch = FetchType.LAZY )
    private List<Accessionagent> accessionagentList;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Accessionagent> accessionagentList1;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Accessionagent> accessionagentList2;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Workbenchtemplate> workbenchtemplateList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Workbenchtemplate> workbenchtemplateList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Taxontreedefitem> taxontreedefitemList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Taxontreedefitem> taxontreedefitemList1;
    
    @OneToMany(mappedBy = "examinedByAgentID",  fetch = FetchType.LAZY )
    private List<Conservevent> conserveventList;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Conservevent> conserveventList1;
    
    @OneToMany(mappedBy = "treatedByAgentID",  fetch = FetchType.LAZY )
    private List<Conservevent> conserveventList2;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Conservevent> conserveventList3;
    
    @OneToMany(mappedBy = "curatorID",  fetch = FetchType.LAZY )
    private List<Conservevent> conserveventList4;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Collection> collectionList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Collection> collectionList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Fieldnotebookpageattachment> fieldnotebookpageattachmentList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Fieldnotebookpageattachment> fieldnotebookpageattachmentList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Spprincipal> spprincipalList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Spprincipal> spprincipalList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Fieldnotebookattachment> fieldnotebookattachmentList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Fieldnotebookattachment> fieldnotebookattachmentList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Preparationattribute> preparationattributeList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Preparationattribute> preparationattributeList1;
    
    @OneToMany(mappedBy = "agentID",  fetch = FetchType.LAZY )
    private List<Inforequest> inforequestList;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Inforequest> inforequestList1;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Inforequest> inforequestList2;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY ) 
    private List<Collectingeventattr> collectingeventattrList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Collectingeventattr> collectingeventattrList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Spappresourcedir> spappresourcedirList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Spappresourcedir> spappresourcedirList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Spexportschema> spexportschemaList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Spexportschema> spexportschemaList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Collectionrelationship> collectionrelationshipList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Collectionrelationship> collectionrelationshipList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Attachmenttag> attachmenttagList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Attachmenttag> attachmenttagList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Geographytreedefitem> geographytreedefitemList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Geographytreedefitem> geographytreedefitemList1;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agentID",  fetch = FetchType.LAZY )
    private List<Borrowagent> borrowagentList;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Borrowagent> borrowagentList1;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Borrowagent> borrowagentList2;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Geologictimeperiodtreedefitem> geologictimeperiodtreedefitemList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Geologictimeperiodtreedefitem> geologictimeperiodtreedefitemList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Loan> loanList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Loan> loanList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Fieldnotebookpage> fieldnotebookpageList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Fieldnotebookpage> fieldnotebookpageList1;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agentID",  fetch = FetchType.LAZY )
    private List<Agentspecialty> agentspecialtyList;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Agentspecialty> agentspecialtyList1;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Agentspecialty> agentspecialtyList2;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Picklist> picklistList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Picklist> picklistList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Accession> accessionList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Accession> accessionList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Storage> storageList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Storage> storageList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Dnasequencerunattachment> dnasequencerunattachmentList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Dnasequencerunattachment> dnasequencerunattachmentList1;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agentID",  fetch = FetchType.LAZY )
    private List<Giftagent> giftagentList;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Giftagent> giftagentList1;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Giftagent> giftagentList2;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agentID",  fetch = FetchType.LAZY )
    private List<Collector> collectorList;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Collector> collectorList1;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Collector> collectorList2;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Attachment> attachmentList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Attachment> attachmentList1;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agentID",  fetch = FetchType.LAZY )
    private List<Appraisal> appraisalList;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Appraisal> appraisalList1;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Appraisal> appraisalList2;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agentID",  fetch = FetchType.LAZY )
    private List<Agentgeography> agentgeographyList;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Agentgeography> agentgeographyList1;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Agentgeography> agentgeographyList2;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Collectionobjectcitation> collectionobjectcitationList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Collectionobjectcitation> collectionobjectcitationList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Spappresourcedata> spappresourcedataList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Spappresourcedata> spappresourcedataList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Spexportschemaitemmapping> spexportschemaitemmappingList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Spexportschemaitemmapping> spexportschemaitemmappingList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Specifyuser> specifyuserList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Specifyuser> specifyuserList1;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catalogedByID",  fetch = FetchType.LAZY )
    private List<Exchangein> exchangeinList;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Exchangein> exchangeinList1;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Exchangein> exchangeinList2;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receivedFromOrganizationID",  fetch = FetchType.LAZY )
    private List<Exchangein> exchangeinList3;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Fieldnotebookpagesetattachment> fieldnotebookpagesetattachmentList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Fieldnotebookpagesetattachment> fieldnotebookpagesetattachmentList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Commonnametx> commonnametxList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Commonnametx> commonnametxList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Loanpreparation> loanpreparationList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Loanpreparation> loanpreparationList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Otheridentifier> otheridentifierList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Otheridentifier> otheridentifierList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Spexportschemamapping> spexportschemamappingList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Spexportschemamapping> spexportschemamappingList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Giftpreparation> giftpreparationList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Giftpreparation> giftpreparationList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Spversion> spversionList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Spversion> spversionList1;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agentID",  fetch = FetchType.LAZY )
    private List<Loanagent> loanagentList;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Loanagent> loanagentList1;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Loanagent> loanagentList2;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Spviewsetobj> spviewsetobjList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Spviewsetobj> spviewsetobjList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Deaccessionpreparation> deaccessionpreparationList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Deaccessionpreparation> deaccessionpreparationList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Accessionauthorization> accessionauthorizationList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Accessionauthorization> accessionauthorizationList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Permit> permitList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Permit> permitList1;
    
    @OneToMany(mappedBy = "issuedByID",  fetch = FetchType.LAZY )
    private List<Permit> permitList2;
    
    @OneToMany(mappedBy = "issuedToID",  fetch = FetchType.LAZY )
    private List<Permit> permitList3;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Collectionobjectattr> collectionobjectattrList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Collectionobjectattr> collectionobjectattrList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Spauditlog> spauditlogList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Spauditlog> spauditlogList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Spreport> spreportList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Spreport> spreportList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Deaccession> deaccessionList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Deaccession> deaccessionList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Loanattachment> loanattachmentList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Loanattachment> loanattachmentList1;
    
    @OneToMany(mappedBy = "modifiedByAgentID",  fetch = FetchType.LAZY )
    private List<Spsymbiotainstance> spsymbiotainstanceList;
    
    @OneToMany(mappedBy = "createdByAgentID",  fetch = FetchType.LAZY )
    private List<Spsymbiotainstance> spsymbiotainstanceList1;

    public Agent() {
    }

    public Agent(Integer agentID) {
        this.agentID = agentID;
    }

    public Agent(Integer agentID, Date timestampCreated, short agentType) {
        this.agentID = agentID;
        this.timestampCreated = timestampCreated;
        this.agentType = agentType;
    }

    @XmlID
    @XmlAttribute(name = "id") 
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + agentID;
    }

    @Override
    public int getEntityId() {
        return agentID;
    }
    
    public Integer getAgentID() {
        return agentID;
    }

    public void setAgentID(Integer agentID) {
        this.agentID = agentID;
    }

    
    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public short getAgentType() {
        return agentType;
    }

    public void setAgentType(short agentType) {
        this.agentType = agentType;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Short getDateOfBirthPrecision() {
        return dateOfBirthPrecision;
    }

    public void setDateOfBirthPrecision(Short dateOfBirthPrecision) {
        this.dateOfBirthPrecision = dateOfBirthPrecision;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Short getDateOfDeathPrecision() {
        return dateOfDeathPrecision;
    }

    public void setDateOfDeathPrecision(Short dateOfDeathPrecision) {
        this.dateOfDeathPrecision = dateOfDeathPrecision;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Short getDateType() {
        return dateType;
    }

    public void setDateType(Short dateType) {
        this.dateType = dateType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @XmlTransient
    public List<Container> getContainerList() {
        return containerList;
    }

    public void setContainerList(List<Container> containerList) {
        this.containerList = containerList;
    }

    @XmlTransient
    public List<Container> getContainerList1() {
        return containerList1;
    }

    public void setContainerList1(List<Container> containerList1) {
        this.containerList1 = containerList1;
    }

    @XmlTransient
    public List<Gift> getGiftList() {
        return giftList;
    }

    public void setGiftList(List<Gift> giftList) {
        this.giftList = giftList;
    }

    @XmlTransient
    public List<Gift> getGiftList1() {
        return giftList1;
    }

    public void setGiftList1(List<Gift> giftList1) {
        this.giftList1 = giftList1;
    }

    @XmlTransient
    public List<Geologictimeperiodtreedef> getGeologictimeperiodtreedefList() {
        return geologictimeperiodtreedefList;
    }

    public void setGeologictimeperiodtreedefList(List<Geologictimeperiodtreedef> geologictimeperiodtreedefList) {
        this.geologictimeperiodtreedefList = geologictimeperiodtreedefList;
    }

    @XmlTransient
    public List<Geologictimeperiodtreedef> getGeologictimeperiodtreedefList1() {
        return geologictimeperiodtreedefList1;
    }

    public void setGeologictimeperiodtreedefList1(List<Geologictimeperiodtreedef> geologictimeperiodtreedefList1) {
        this.geologictimeperiodtreedefList1 = geologictimeperiodtreedefList1;
    }

    @XmlTransient
    public List<Collectingeventattachment> getCollectingeventattachmentList() {
        return collectingeventattachmentList;
    }

    public void setCollectingeventattachmentList(List<Collectingeventattachment> collectingeventattachmentList) {
        this.collectingeventattachmentList = collectingeventattachmentList;
    }

    @XmlTransient
    public List<Collectingeventattachment> getCollectingeventattachmentList1() {
        return collectingeventattachmentList1;
    }

    public void setCollectingeventattachmentList1(List<Collectingeventattachment> collectingeventattachmentList1) {
        this.collectingeventattachmentList1 = collectingeventattachmentList1;
    }

    @XmlTransient
    public List<Taxontreedef> getTaxontreedefList() {
        return taxontreedefList;
    }

    public void setTaxontreedefList(List<Taxontreedef> taxontreedefList) {
        this.taxontreedefList = taxontreedefList;
    }

    @XmlTransient
    public List<Taxontreedef> getTaxontreedefList1() {
        return taxontreedefList1;
    }

    public void setTaxontreedefList1(List<Taxontreedef> taxontreedefList1) {
        this.taxontreedefList1 = taxontreedefList1;
    }

    @XmlTransient
    public List<Preparationattachment> getPreparationattachmentList() {
        return preparationattachmentList;
    }

    public void setPreparationattachmentList(List<Preparationattachment> preparationattachmentList) {
        this.preparationattachmentList = preparationattachmentList;
    }

    @XmlTransient
    public List<Preparationattachment> getPreparationattachmentList1() {
        return preparationattachmentList1;
    }

    public void setPreparationattachmentList1(List<Preparationattachment> preparationattachmentList1) {
        this.preparationattachmentList1 = preparationattachmentList1;
    }

    @XmlTransient
    public List<Determination> getDeterminationList() {
        return determinationList;
    }

    public void setDeterminationList(List<Determination> determinationList) {
        this.determinationList = determinationList;
    }

    @XmlTransient
    public List<Determination> getDeterminationList1() {
        return determinationList1;
    }

    public void setDeterminationList1(List<Determination> determinationList1) {
        this.determinationList1 = determinationList1;
    }

    @XmlTransient
    public List<Determination> getDeterminationList2() {
        return determinationList2;
    }

    public void setDeterminationList2(List<Determination> determinationList2) {
        this.determinationList2 = determinationList2;
    }

    @XmlTransient
    public List<Discipline> getDisciplineList() {
        return disciplineList;
    }

    public void setDisciplineList(List<Discipline> disciplineList) {
        this.disciplineList = disciplineList;
    }

    @XmlTransient
    public List<Discipline> getDisciplineList1() {
        return disciplineList1;
    }

    public void setDisciplineList1(List<Discipline> disciplineList1) {
        this.disciplineList1 = disciplineList1;
    }

    @XmlTransient
    public List<Spfieldvaluedefault> getSpfieldvaluedefaultList() {
        return spfieldvaluedefaultList;
    }

    public void setSpfieldvaluedefaultList(List<Spfieldvaluedefault> spfieldvaluedefaultList) {
        this.spfieldvaluedefaultList = spfieldvaluedefaultList;
    }

    @XmlTransient
    public List<Spfieldvaluedefault> getSpfieldvaluedefaultList1() {
        return spfieldvaluedefaultList1;
    }

    public void setSpfieldvaluedefaultList1(List<Spfieldvaluedefault> spfieldvaluedefaultList1) {
        this.spfieldvaluedefaultList1 = spfieldvaluedefaultList1;
    }

    @XmlTransient
    public List<Exsiccataitem> getExsiccataitemList() {
        return exsiccataitemList;
    }

    public void setExsiccataitemList(List<Exsiccataitem> exsiccataitemList) {
        this.exsiccataitemList = exsiccataitemList;
    }

    @XmlTransient
    public List<Exsiccataitem> getExsiccataitemList1() {
        return exsiccataitemList1;
    }

    public void setExsiccataitemList1(List<Exsiccataitem> exsiccataitemList1) {
        this.exsiccataitemList1 = exsiccataitemList1;
    }

    @XmlTransient
    public List<Preparation> getPreparationList() {
        return preparationList;
    }

    public void setPreparationList(List<Preparation> preparationList) {
        this.preparationList = preparationList;
    }

    @XmlTransient
    public List<Preparation> getPreparationList1() {
        return preparationList1;
    }

    public void setPreparationList1(List<Preparation> preparationList1) {
        this.preparationList1 = preparationList1;
    }

    @XmlTransient
    public List<Preparation> getPreparationList2() {
        return preparationList2;
    }

    public void setPreparationList2(List<Preparation> preparationList2) {
        this.preparationList2 = preparationList2;
    }

    @XmlTransient
    public List<Division> getDivisionList() {
        return divisionList;
    }

    public void setDivisionList(List<Division> divisionList) {
        this.divisionList = divisionList;
    }

    @XmlTransient
    public List<Division> getDivisionList1() {
        return divisionList1;
    }

    public void setDivisionList1(List<Division> divisionList1) {
        this.divisionList1 = divisionList1;
    }

    @XmlTransient
    public List<Sptasksemaphore> getSptasksemaphoreList() {
        return sptasksemaphoreList;
    }

    public void setSptasksemaphoreList(List<Sptasksemaphore> sptasksemaphoreList) {
        this.sptasksemaphoreList = sptasksemaphoreList;
    }

    @XmlTransient
    public List<Sptasksemaphore> getSptasksemaphoreList1() {
        return sptasksemaphoreList1;
    }

    public void setSptasksemaphoreList1(List<Sptasksemaphore> sptasksemaphoreList1) {
        this.sptasksemaphoreList1 = sptasksemaphoreList1;
    }

    @XmlTransient
    public List<Repositoryagreementattachment> getRepositoryagreementattachmentList() {
        return repositoryagreementattachmentList;
    }

    public void setRepositoryagreementattachmentList(List<Repositoryagreementattachment> repositoryagreementattachmentList) {
        this.repositoryagreementattachmentList = repositoryagreementattachmentList;
    }

    @XmlTransient
    public List<Repositoryagreementattachment> getRepositoryagreementattachmentList1() {
        return repositoryagreementattachmentList1;
    }

    public void setRepositoryagreementattachmentList1(List<Repositoryagreementattachment> repositoryagreementattachmentList1) {
        this.repositoryagreementattachmentList1 = repositoryagreementattachmentList1;
    }

    @XmlTransient
    public List<Geography> getGeographyList() {
        return geographyList;
    }

    public void setGeographyList(List<Geography> geographyList) {
        this.geographyList = geographyList;
    }

    @XmlTransient
    public List<Geography> getGeographyList1() {
        return geographyList1;
    }

    public void setGeographyList1(List<Geography> geographyList1) {
        this.geographyList1 = geographyList1;
    }

    @XmlTransient
    public List<Agentattachment> getAgentattachmentList() {
        return agentattachmentList;
    }

    public void setAgentattachmentList(List<Agentattachment> agentattachmentList) {
        this.agentattachmentList = agentattachmentList;
    }

    @XmlTransient
    public List<Agentattachment> getAgentattachmentList1() {
        return agentattachmentList1;
    }

    public void setAgentattachmentList1(List<Agentattachment> agentattachmentList1) {
        this.agentattachmentList1 = agentattachmentList1;
    }

    @XmlTransient
    public List<Agentattachment> getAgentattachmentList2() {
        return agentattachmentList2;
    }

    public void setAgentattachmentList2(List<Agentattachment> agentattachmentList2) {
        this.agentattachmentList2 = agentattachmentList2;
    }

    @XmlTransient
    public List<Picklistitem> getPicklistitemList() {
        return picklistitemList;
    }

    public void setPicklistitemList(List<Picklistitem> picklistitemList) {
        this.picklistitemList = picklistitemList;
    }

    @XmlTransient
    public List<Picklistitem> getPicklistitemList1() {
        return picklistitemList1;
    }

    public void setPicklistitemList1(List<Picklistitem> picklistitemList1) {
        this.picklistitemList1 = picklistitemList1;
    }

    @XmlTransient
    public List<Permitattachment> getPermitattachmentList() {
        return permitattachmentList;
    }

    public void setPermitattachmentList(List<Permitattachment> permitattachmentList) {
        this.permitattachmentList = permitattachmentList;
    }

    @XmlTransient
    public List<Permitattachment> getPermitattachmentList1() {
        return permitattachmentList1;
    }

    public void setPermitattachmentList1(List<Permitattachment> permitattachmentList1) {
        this.permitattachmentList1 = permitattachmentList1;
    }

    @XmlTransient
    public List<Collectingtrip> getCollectingtripList() {
        return collectingtripList;
    }

    public void setCollectingtripList(List<Collectingtrip> collectingtripList) {
        this.collectingtripList = collectingtripList;
    }

    @XmlTransient
    public List<Collectingtrip> getCollectingtripList1() {
        return collectingtripList1;
    }

    public void setCollectingtripList1(List<Collectingtrip> collectingtripList1) {
        this.collectingtripList1 = collectingtripList1;
    }

    @XmlTransient
    public List<Geocoorddetail> getGeocoorddetailList() {
        return geocoorddetailList;
    }

    public void setGeocoorddetailList(List<Geocoorddetail> geocoorddetailList) {
        this.geocoorddetailList = geocoorddetailList;
    }

    @XmlTransient
    public List<Geocoorddetail> getGeocoorddetailList1() {
        return geocoorddetailList1;
    }

    public void setGeocoorddetailList1(List<Geocoorddetail> geocoorddetailList1) {
        this.geocoorddetailList1 = geocoorddetailList1;
    }

    @XmlTransient
    public List<Geocoorddetail> getGeocoorddetailList2() {
        return geocoorddetailList2;
    }

    public void setGeocoorddetailList2(List<Geocoorddetail> geocoorddetailList2) {
        this.geocoorddetailList2 = geocoorddetailList2;
    }

    @XmlTransient
    public List<Dnasequencingrun> getDnasequencingrunList() {
        return dnasequencingrunList;
    }

    public void setDnasequencingrunList(List<Dnasequencingrun> dnasequencingrunList) {
        this.dnasequencingrunList = dnasequencingrunList;
    }

    @XmlTransient
    public List<Dnasequencingrun> getDnasequencingrunList1() {
        return dnasequencingrunList1;
    }

    public void setDnasequencingrunList1(List<Dnasequencingrun> dnasequencingrunList1) {
        this.dnasequencingrunList1 = dnasequencingrunList1;
    }

    @XmlTransient
    public List<Dnasequencingrun> getDnasequencingrunList2() {
        return dnasequencingrunList2;
    }

    public void setDnasequencingrunList2(List<Dnasequencingrun> dnasequencingrunList2) {
        this.dnasequencingrunList2 = dnasequencingrunList2;
    }

    @XmlTransient
    public List<Dnasequencingrun> getDnasequencingrunList3() {
        return dnasequencingrunList3;
    }

    public void setDnasequencingrunList3(List<Dnasequencingrun> dnasequencingrunList3) {
        this.dnasequencingrunList3 = dnasequencingrunList3;
    }

    @XmlTransient
    public List<Preptype> getPreptypeList() {
        return preptypeList;
    }

    public void setPreptypeList(List<Preptype> preptypeList) {
        this.preptypeList = preptypeList;
    }

    @XmlTransient
    public List<Preptype> getPreptypeList1() {
        return preptypeList1;
    }

    public void setPreptypeList1(List<Preptype> preptypeList1) {
        this.preptypeList1 = preptypeList1;
    }

    @XmlTransient
    public List<Conservdescription> getConservdescriptionList() {
        return conservdescriptionList;
    }

    public void setConservdescriptionList(List<Conservdescription> conservdescriptionList) {
        this.conservdescriptionList = conservdescriptionList;
    }

    @XmlTransient
    public List<Conservdescription> getConservdescriptionList1() {
        return conservdescriptionList1;
    }

    public void setConservdescriptionList1(List<Conservdescription> conservdescriptionList1) {
        this.conservdescriptionList1 = conservdescriptionList1;
    }

    @XmlTransient
    public List<Locality> getLocalityList() {
        return localityList;
    }

    public void setLocalityList(List<Locality> localityList) {
        this.localityList = localityList;
    }

    @XmlTransient
    public List<Locality> getLocalityList1() {
        return localityList1;
    }

    public void setLocalityList1(List<Locality> localityList1) {
        this.localityList1 = localityList1;
    }

    @XmlTransient
    public List<Accessionattachment> getAccessionattachmentList() {
        return accessionattachmentList;
    }

    public void setAccessionattachmentList(List<Accessionattachment> accessionattachmentList) {
        this.accessionattachmentList = accessionattachmentList;
    }

    @XmlTransient
    public List<Accessionattachment> getAccessionattachmentList1() {
        return accessionattachmentList1;
    }

    public void setAccessionattachmentList1(List<Accessionattachment> accessionattachmentList1) {
        this.accessionattachmentList1 = accessionattachmentList1;
    }

    @XmlTransient
    public List<Exchangeout> getExchangeoutList() {
        return exchangeoutList;
    }

    public void setExchangeoutList(List<Exchangeout> exchangeoutList) {
        this.exchangeoutList = exchangeoutList;
    }

    @XmlTransient
    public List<Exchangeout> getExchangeoutList1() {
        return exchangeoutList1;
    }

    public void setExchangeoutList1(List<Exchangeout> exchangeoutList1) {
        this.exchangeoutList1 = exchangeoutList1;
    }

    @XmlTransient
    public List<Exchangeout> getExchangeoutList2() {
        return exchangeoutList2;
    }

    public void setExchangeoutList2(List<Exchangeout> exchangeoutList2) {
        this.exchangeoutList2 = exchangeoutList2;
    }

    @XmlTransient
    public List<Exchangeout> getExchangeoutList3() {
        return exchangeoutList3;
    }

    public void setExchangeoutList3(List<Exchangeout> exchangeoutList3) {
        this.exchangeoutList3 = exchangeoutList3;
    }

    @XmlTransient
    public List<Borrowmaterial> getBorrowmaterialList() {
        return borrowmaterialList;
    }

    public void setBorrowmaterialList(List<Borrowmaterial> borrowmaterialList) {
        this.borrowmaterialList = borrowmaterialList;
    }

    @XmlTransient
    public List<Borrowmaterial> getBorrowmaterialList1() {
        return borrowmaterialList1;
    }

    public void setBorrowmaterialList1(List<Borrowmaterial> borrowmaterialList1) {
        this.borrowmaterialList1 = borrowmaterialList1;
    }

    @XmlTransient
    public List<Dnasequenceattachment> getDnasequenceattachmentList() {
        return dnasequenceattachmentList;
    }

    public void setDnasequenceattachmentList(List<Dnasequenceattachment> dnasequenceattachmentList) {
        this.dnasequenceattachmentList = dnasequenceattachmentList;
    }

    @XmlTransient
    public List<Dnasequenceattachment> getDnasequenceattachmentList1() {
        return dnasequenceattachmentList1;
    }

    public void setDnasequenceattachmentList1(List<Dnasequenceattachment> dnasequenceattachmentList1) {
        this.dnasequenceattachmentList1 = dnasequenceattachmentList1;
    }

    @XmlTransient
    public List<Agentvariant> getAgentvariantList() {
        return agentvariantList;
    }

    public void setAgentvariantList(List<Agentvariant> agentvariantList) {
        this.agentvariantList = agentvariantList;
    }

    @XmlTransient
    public List<Agentvariant> getAgentvariantList1() {
        return agentvariantList1;
    }

    public void setAgentvariantList1(List<Agentvariant> agentvariantList1) {
        this.agentvariantList1 = agentvariantList1;
    }

    @XmlTransient
    public List<Agentvariant> getAgentvariantList2() {
        return agentvariantList2;
    }

    public void setAgentvariantList2(List<Agentvariant> agentvariantList2) {
        this.agentvariantList2 = agentvariantList2;
    }

    @XmlTransient
    public List<Localitycitation> getLocalitycitationList() {
        return localitycitationList;
    }

    public void setLocalitycitationList(List<Localitycitation> localitycitationList) {
        this.localitycitationList = localitycitationList;
    }

    @XmlTransient
    public List<Localitycitation> getLocalitycitationList1() {
        return localitycitationList1;
    }

    public void setLocalitycitationList1(List<Localitycitation> localitycitationList1) {
        this.localitycitationList1 = localitycitationList1;
    }

    @XmlTransient
    public List<Fieldnotebookpageset> getFieldnotebookpagesetList() {
        return fieldnotebookpagesetList;
    }

    public void setFieldnotebookpagesetList(List<Fieldnotebookpageset> fieldnotebookpagesetList) {
        this.fieldnotebookpagesetList = fieldnotebookpagesetList;
    }

    @XmlTransient
    public List<Fieldnotebookpageset> getFieldnotebookpagesetList1() {
        return fieldnotebookpagesetList1;
    }

    public void setFieldnotebookpagesetList1(List<Fieldnotebookpageset> fieldnotebookpagesetList1) {
        this.fieldnotebookpagesetList1 = fieldnotebookpagesetList1;
    }

    @XmlTransient
    public List<Fieldnotebookpageset> getFieldnotebookpagesetList2() {
        return fieldnotebookpagesetList2;
    }

    public void setFieldnotebookpagesetList2(List<Fieldnotebookpageset> fieldnotebookpagesetList2) {
        this.fieldnotebookpagesetList2 = fieldnotebookpagesetList2;
    }

    @XmlTransient
    public List<Paleocontext> getPaleocontextList() {
        return paleocontextList;
    }

    public void setPaleocontextList(List<Paleocontext> paleocontextList) {
        this.paleocontextList = paleocontextList;
    }

    @XmlTransient
    public List<Paleocontext> getPaleocontextList1() {
        return paleocontextList1;
    }

    public void setPaleocontextList1(List<Paleocontext> paleocontextList1) {
        this.paleocontextList1 = paleocontextList1;
    }

    @XmlTransient
    public List<Collectionobjectattribute> getCollectionobjectattributeList() {
        return collectionobjectattributeList;
    }

    public void setCollectionobjectattributeList(List<Collectionobjectattribute> collectionobjectattributeList) {
        this.collectionobjectattributeList = collectionobjectattributeList;
    }

    @XmlTransient
    public List<Collectionobjectattribute> getCollectionobjectattributeList1() {
        return collectionobjectattributeList1;
    }

    public void setCollectionobjectattributeList1(List<Collectionobjectattribute> collectionobjectattributeList1) {
        this.collectionobjectattributeList1 = collectionobjectattributeList1;
    }

    @XmlTransient
    public List<Collectionobjectattachment> getCollectionobjectattachmentList() {
        return collectionobjectattachmentList;
    }

    public void setCollectionobjectattachmentList(List<Collectionobjectattachment> collectionobjectattachmentList) {
        this.collectionobjectattachmentList = collectionobjectattachmentList;
    }

    @XmlTransient
    public List<Collectionobjectattachment> getCollectionobjectattachmentList1() {
        return collectionobjectattachmentList1;
    }

    public void setCollectionobjectattachmentList1(List<Collectionobjectattachment> collectionobjectattachmentList1) {
        this.collectionobjectattachmentList1 = collectionobjectattachmentList1;
    }

    @XmlTransient
    public List<Storageattachment> getStorageattachmentList() {
        return storageattachmentList;
    }

    public void setStorageattachmentList(List<Storageattachment> storageattachmentList) {
        this.storageattachmentList = storageattachmentList;
    }

    @XmlTransient
    public List<Storageattachment> getStorageattachmentList1() {
        return storageattachmentList1;
    }

    public void setStorageattachmentList1(List<Storageattachment> storageattachmentList1) {
        this.storageattachmentList1 = storageattachmentList1;
    }

    @XmlTransient
    public List<Exsiccata> getExsiccataList() {
        return exsiccataList;
    }

    public void setExsiccataList(List<Exsiccata> exsiccataList) {
        this.exsiccataList = exsiccataList;
    }

    @XmlTransient
    public List<Exsiccata> getExsiccataList1() {
        return exsiccataList1;
    }

    public void setExsiccataList1(List<Exsiccata> exsiccataList1) {
        this.exsiccataList1 = exsiccataList1;
    }

    @XmlTransient
    public List<Attachmentmetadata> getAttachmentmetadataList() {
        return attachmentmetadataList;
    }

    public void setAttachmentmetadataList(List<Attachmentmetadata> attachmentmetadataList) {
        this.attachmentmetadataList = attachmentmetadataList;
    }

    @XmlTransient
    public List<Attachmentmetadata> getAttachmentmetadataList1() {
        return attachmentmetadataList1;
    }

    public void setAttachmentmetadataList1(List<Attachmentmetadata> attachmentmetadataList1) {
        this.attachmentmetadataList1 = attachmentmetadataList1;
    }

    @XmlTransient
    public List<Loanreturnpreparation> getLoanreturnpreparationList() {
        return loanreturnpreparationList;
    }

    public void setLoanreturnpreparationList(List<Loanreturnpreparation> loanreturnpreparationList) {
        this.loanreturnpreparationList = loanreturnpreparationList;
    }

    @XmlTransient
    public List<Loanreturnpreparation> getLoanreturnpreparationList1() {
        return loanreturnpreparationList1;
    }

    public void setLoanreturnpreparationList1(List<Loanreturnpreparation> loanreturnpreparationList1) {
        this.loanreturnpreparationList1 = loanreturnpreparationList1;
    }

    @XmlTransient
    public List<Loanreturnpreparation> getLoanreturnpreparationList2() {
        return loanreturnpreparationList2;
    }

    public void setLoanreturnpreparationList2(List<Loanreturnpreparation> loanreturnpreparationList2) {
        this.loanreturnpreparationList2 = loanreturnpreparationList2;
    }

    @XmlTransient
    public List<Localitynamealias> getLocalitynamealiasList() {
        return localitynamealiasList;
    }

    public void setLocalitynamealiasList(List<Localitynamealias> localitynamealiasList) {
        this.localitynamealiasList = localitynamealiasList;
    }

    @XmlTransient
    public List<Localitynamealias> getLocalitynamealiasList1() {
        return localitynamealiasList1;
    }

    public void setLocalitynamealiasList1(List<Localitynamealias> localitynamealiasList1) {
        this.localitynamealiasList1 = localitynamealiasList1;
    }

    @XmlTransient
    public List<Recordset> getRecordsetList() {
        return recordsetList;
    }

    public void setRecordsetList(List<Recordset> recordsetList) {
        this.recordsetList = recordsetList;
    }

    @XmlTransient
    public List<Recordset> getRecordsetList1() {
        return recordsetList1;
    }

    public void setRecordsetList1(List<Recordset> recordsetList1) {
        this.recordsetList1 = recordsetList1;
    }

    @XmlTransient
    public List<Spappresource> getSpappresourceList() {
        return spappresourceList;
    }

    public void setSpappresourceList(List<Spappresource> spappresourceList) {
        this.spappresourceList = spappresourceList;
    }

    @XmlTransient
    public List<Spappresource> getSpappresourceList1() {
        return spappresourceList1;
    }

    public void setSpappresourceList1(List<Spappresource> spappresourceList1) {
        this.spappresourceList1 = spappresourceList1;
    }

    @XmlTransient
    public List<Taxonattachment> getTaxonattachmentList() {
        return taxonattachmentList;
    }

    public void setTaxonattachmentList(List<Taxonattachment> taxonattachmentList) {
        this.taxonattachmentList = taxonattachmentList;
    }

    @XmlTransient
    public List<Taxonattachment> getTaxonattachmentList1() {
        return taxonattachmentList1;
    }

    public void setTaxonattachmentList1(List<Taxonattachment> taxonattachmentList1) {
        this.taxonattachmentList1 = taxonattachmentList1;
    }

    @XmlTransient
    public List<Storagetreedefitem> getStoragetreedefitemList() {
        return storagetreedefitemList;
    }

    public void setStoragetreedefitemList(List<Storagetreedefitem> storagetreedefitemList) {
        this.storagetreedefitemList = storagetreedefitemList;
    }

    @XmlTransient
    public List<Storagetreedefitem> getStoragetreedefitemList1() {
        return storagetreedefitemList1;
    }

    public void setStoragetreedefitemList1(List<Storagetreedefitem> storagetreedefitemList1) {
        this.storagetreedefitemList1 = storagetreedefitemList1;
    }

    @XmlTransient
    public List<Determinationcitation> getDeterminationcitationList() {
        return determinationcitationList;
    }

    public void setDeterminationcitationList(List<Determinationcitation> determinationcitationList) {
        this.determinationcitationList = determinationcitationList;
    }

    @XmlTransient
    public List<Determinationcitation> getDeterminationcitationList1() {
        return determinationcitationList1;
    }

    public void setDeterminationcitationList1(List<Determinationcitation> determinationcitationList1) {
        this.determinationcitationList1 = determinationcitationList1;
    }

    @XmlTransient
    public List<Conserveventattachment> getConserveventattachmentList() {
        return conserveventattachmentList;
    }

    public void setConserveventattachmentList(List<Conserveventattachment> conserveventattachmentList) {
        this.conserveventattachmentList = conserveventattachmentList;
    }

    @XmlTransient
    public List<Conserveventattachment> getConserveventattachmentList1() {
        return conserveventattachmentList1;
    }

    public void setConserveventattachmentList1(List<Conserveventattachment> conserveventattachmentList1) {
        this.conserveventattachmentList1 = conserveventattachmentList1;
    }

    @XmlTransient
    public List<Lithostrattreedefitem> getLithostrattreedefitemList() {
        return lithostrattreedefitemList;
    }

    public void setLithostrattreedefitemList(List<Lithostrattreedefitem> lithostrattreedefitemList) {
        this.lithostrattreedefitemList = lithostrattreedefitemList;
    }

    @XmlTransient
    public List<Lithostrattreedefitem> getLithostrattreedefitemList1() {
        return lithostrattreedefitemList1;
    }

    public void setLithostrattreedefitemList1(List<Lithostrattreedefitem> lithostrattreedefitemList1) {
        this.lithostrattreedefitemList1 = lithostrattreedefitemList1;
    }

    @XmlTransient
    public List<Journal> getJournalList() {
        return journalList;
    }

    public void setJournalList(List<Journal> journalList) {
        this.journalList = journalList;
    }

    @XmlTransient
    public List<Journal> getJournalList1() {
        return journalList1;
    }

    public void setJournalList1(List<Journal> journalList1) {
        this.journalList1 = journalList1;
    }

    @XmlTransient
    public List<Datatype> getDatatypeList() {
        return datatypeList;
    }

    public void setDatatypeList(List<Datatype> datatypeList) {
        this.datatypeList = datatypeList;
    }

    @XmlTransient
    public List<Datatype> getDatatypeList1() {
        return datatypeList1;
    }

    public void setDatatypeList1(List<Datatype> datatypeList1) {
        this.datatypeList1 = datatypeList1;
    }

    @XmlTransient
    public List<Collectionreltype> getCollectionreltypeList() {
        return collectionreltypeList;
    }

    public void setCollectionreltypeList(List<Collectionreltype> collectionreltypeList) {
        this.collectionreltypeList = collectionreltypeList;
    }

    @XmlTransient
    public List<Collectionreltype> getCollectionreltypeList1() {
        return collectionreltypeList1;
    }

    public void setCollectionreltypeList1(List<Collectionreltype> collectionreltypeList1) {
        this.collectionreltypeList1 = collectionreltypeList1;
    }

    @XmlTransient
    public List<Taxon> getTaxonList() {
        return taxonList;
    }

    public void setTaxonList(List<Taxon> taxonList) {
        this.taxonList = taxonList;
    }

    @XmlTransient
    public List<Taxon> getTaxonList1() {
        return taxonList1;
    }

    public void setTaxonList1(List<Taxon> taxonList1) {
        this.taxonList1 = taxonList1;
    }

    @XmlTransient
    public List<Localityattachment> getLocalityattachmentList() {
        return localityattachmentList;
    }

    public void setLocalityattachmentList(List<Localityattachment> localityattachmentList) {
        this.localityattachmentList = localityattachmentList;
    }

    @XmlTransient
    public List<Localityattachment> getLocalityattachmentList1() {
        return localityattachmentList1;
    }

    public void setLocalityattachmentList1(List<Localityattachment> localityattachmentList1) {
        this.localityattachmentList1 = localityattachmentList1;
    }

    @XmlTransient
    public List<Treatmentevent> getTreatmenteventList() {
        return treatmenteventList;
    }

    public void setTreatmenteventList(List<Treatmentevent> treatmenteventList) {
        this.treatmenteventList = treatmenteventList;
    }

    @XmlTransient
    public List<Treatmentevent> getTreatmenteventList1() {
        return treatmenteventList1;
    }

    public void setTreatmenteventList1(List<Treatmentevent> treatmenteventList1) {
        this.treatmenteventList1 = treatmenteventList1;
    }

    @XmlTransient
    public List<Storagetreedef> getStoragetreedefList() {
        return storagetreedefList;
    }

    public void setStoragetreedefList(List<Storagetreedef> storagetreedefList) {
        this.storagetreedefList = storagetreedefList;
    }

    @XmlTransient
    public List<Storagetreedef> getStoragetreedefList1() {
        return storagetreedefList1;
    }

    public void setStoragetreedefList1(List<Storagetreedef> storagetreedefList1) {
        this.storagetreedefList1 = storagetreedefList1;
    }

    @XmlTransient
    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @XmlTransient
    public List<Address> getAddressList1() {
        return addressList1;
    }

    public void setAddressList1(List<Address> addressList1) {
        this.addressList1 = addressList1;
    }

    @XmlTransient
    public List<Address> getAddressList2() {
        return addressList2;
    }

    public void setAddressList2(List<Address> addressList2) {
        this.addressList2 = addressList2;
    }

    @XmlTransient
    public List<Spexportschemaitem> getSpexportschemaitemList() {
        return spexportschemaitemList;
    }

    public void setSpexportschemaitemList(List<Spexportschemaitem> spexportschemaitemList) {
        this.spexportschemaitemList = spexportschemaitemList;
    }

    @XmlTransient
    public List<Spexportschemaitem> getSpexportschemaitemList1() {
        return spexportschemaitemList1;
    }

    public void setSpexportschemaitemList1(List<Spexportschemaitem> spexportschemaitemList1) {
        this.spexportschemaitemList1 = spexportschemaitemList1;
    }

    @XmlTransient
    public List<Splocaleitemstr> getSplocaleitemstrList() {
        return splocaleitemstrList;
    }

    public void setSplocaleitemstrList(List<Splocaleitemstr> splocaleitemstrList) {
        this.splocaleitemstrList = splocaleitemstrList;
    }

    @XmlTransient
    public List<Splocaleitemstr> getSplocaleitemstrList1() {
        return splocaleitemstrList1;
    }

    public void setSplocaleitemstrList1(List<Splocaleitemstr> splocaleitemstrList1) {
        this.splocaleitemstrList1 = splocaleitemstrList1;
    }

    @XmlTransient
    public List<Workbenchtemplatemappingitem> getWorkbenchtemplatemappingitemList() {
        return workbenchtemplatemappingitemList;
    }

    public void setWorkbenchtemplatemappingitemList(List<Workbenchtemplatemappingitem> workbenchtemplatemappingitemList) {
        this.workbenchtemplatemappingitemList = workbenchtemplatemappingitemList;
    }

    @XmlTransient
    public List<Workbenchtemplatemappingitem> getWorkbenchtemplatemappingitemList1() {
        return workbenchtemplatemappingitemList1;
    }

    public void setWorkbenchtemplatemappingitemList1(List<Workbenchtemplatemappingitem> workbenchtemplatemappingitemList1) {
        this.workbenchtemplatemappingitemList1 = workbenchtemplatemappingitemList1;
    }

    @XmlTransient
    public List<Lithostrattreedef> getLithostrattreedefList() {
        return lithostrattreedefList;
    }

    public void setLithostrattreedefList(List<Lithostrattreedef> lithostrattreedefList) {
        this.lithostrattreedefList = lithostrattreedefList;
    }

    @XmlTransient
    public List<Lithostrattreedef> getLithostrattreedefList1() {
        return lithostrattreedefList1;
    }

    public void setLithostrattreedefList1(List<Lithostrattreedef> lithostrattreedefList1) {
        this.lithostrattreedefList1 = lithostrattreedefList1;
    }

    @XmlTransient
    public List<Autonumberingscheme> getAutonumberingschemeList() {
        return autonumberingschemeList;
    }

    public void setAutonumberingschemeList(List<Autonumberingscheme> autonumberingschemeList) {
        this.autonumberingschemeList = autonumberingschemeList;
    }

    @XmlTransient
    public List<Autonumberingscheme> getAutonumberingschemeList1() {
        return autonumberingschemeList1;
    }

    public void setAutonumberingschemeList1(List<Autonumberingscheme> autonumberingschemeList1) {
        this.autonumberingschemeList1 = autonumberingschemeList1;
    }

    @XmlTransient
    public List<Conservdescriptionattachment> getConservdescriptionattachmentList() {
        return conservdescriptionattachmentList;
    }

    public void setConservdescriptionattachmentList(List<Conservdescriptionattachment> conservdescriptionattachmentList) {
        this.conservdescriptionattachmentList = conservdescriptionattachmentList;
    }

    @XmlTransient
    public List<Conservdescriptionattachment> getConservdescriptionattachmentList1() {
        return conservdescriptionattachmentList1;
    }

    public void setConservdescriptionattachmentList1(List<Conservdescriptionattachment> conservdescriptionattachmentList1) {
        this.conservdescriptionattachmentList1 = conservdescriptionattachmentList1;
    }

    @XmlTransient
    public List<Collectingeventattribute> getCollectingeventattributeList() {
        return collectingeventattributeList;
    }

    public void setCollectingeventattributeList(List<Collectingeventattribute> collectingeventattributeList) {
        this.collectingeventattributeList = collectingeventattributeList;
    }

    @XmlTransient
    public List<Collectingeventattribute> getCollectingeventattributeList1() {
        return collectingeventattributeList1;
    }

    public void setCollectingeventattributeList1(List<Collectingeventattribute> collectingeventattributeList1) {
        this.collectingeventattributeList1 = collectingeventattributeList1;
    }

    @XmlTransient
    public List<Spquery> getSpqueryList() {
        return spqueryList;
    }

    public void setSpqueryList(List<Spquery> spqueryList) {
        this.spqueryList = spqueryList;
    }

    @XmlTransient
    public List<Spquery> getSpqueryList1() {
        return spqueryList1;
    }

    public void setSpqueryList1(List<Spquery> spqueryList1) {
        this.spqueryList1 = spqueryList1;
    }

    @XmlTransient
    public List<Geographytreedef> getGeographytreedefList() {
        return geographytreedefList;
    }

    public void setGeographytreedefList(List<Geographytreedef> geographytreedefList) {
        this.geographytreedefList = geographytreedefList;
    }

    @XmlTransient
    public List<Geographytreedef> getGeographytreedefList1() {
        return geographytreedefList1;
    }

    public void setGeographytreedefList1(List<Geographytreedef> geographytreedefList1) {
        this.geographytreedefList1 = geographytreedefList1;
    }

    @XmlTransient
    public List<Addressofrecord> getAddressofrecordList() {
        return addressofrecordList;
    }

    public void setAddressofrecordList(List<Addressofrecord> addressofrecordList) {
        this.addressofrecordList = addressofrecordList;
    }

    @XmlTransient
    public List<Addressofrecord> getAddressofrecordList1() {
        return addressofrecordList1;
    }

    public void setAddressofrecordList1(List<Addressofrecord> addressofrecordList1) {
        this.addressofrecordList1 = addressofrecordList1;
    }

    @XmlTransient
    public List<Addressofrecord> getAddressofrecordList2() {
        return addressofrecordList2;
    }

    public void setAddressofrecordList2(List<Addressofrecord> addressofrecordList2) {
        this.addressofrecordList2 = addressofrecordList2;
    }

    @XmlTransient
    public List<Deaccessionagent> getDeaccessionagentList() {
        return deaccessionagentList;
    }

    public void setDeaccessionagentList(List<Deaccessionagent> deaccessionagentList) {
        this.deaccessionagentList = deaccessionagentList;
    }

    @XmlTransient
    public List<Deaccessionagent> getDeaccessionagentList1() {
        return deaccessionagentList1;
    }

    public void setDeaccessionagentList1(List<Deaccessionagent> deaccessionagentList1) {
        this.deaccessionagentList1 = deaccessionagentList1;
    }

    @XmlTransient
    public List<Deaccessionagent> getDeaccessionagentList2() {
        return deaccessionagentList2;
    }

    public void setDeaccessionagentList2(List<Deaccessionagent> deaccessionagentList2) {
        this.deaccessionagentList2 = deaccessionagentList2;
    }

    @XmlTransient
    public List<Borrow> getBorrowList() {
        return borrowList;
    }

    public void setBorrowList(List<Borrow> borrowList) {
        this.borrowList = borrowList;
    }

    @XmlTransient
    public List<Borrow> getBorrowList1() {
        return borrowList1;
    }

    public void setBorrowList1(List<Borrow> borrowList1) {
        this.borrowList1 = borrowList1;
    }

    @XmlTransient
    public List<Localitydetail> getLocalitydetailList() {
        return localitydetailList;
    }

    public void setLocalitydetailList(List<Localitydetail> localitydetailList) {
        this.localitydetailList = localitydetailList;
    }

    @XmlTransient
    public List<Localitydetail> getLocalitydetailList1() {
        return localitydetailList1;
    }

    public void setLocalitydetailList1(List<Localitydetail> localitydetailList1) {
        this.localitydetailList1 = localitydetailList1;
    }

    @XmlTransient
    public List<Commonnametxcitation> getCommonnametxcitationList() {
        return commonnametxcitationList;
    }

    public void setCommonnametxcitationList(List<Commonnametxcitation> commonnametxcitationList) {
        this.commonnametxcitationList = commonnametxcitationList;
    }

    @XmlTransient
    public List<Commonnametxcitation> getCommonnametxcitationList1() {
        return commonnametxcitationList1;
    }

    public void setCommonnametxcitationList1(List<Commonnametxcitation> commonnametxcitationList1) {
        this.commonnametxcitationList1 = commonnametxcitationList1;
    }

    @XmlTransient
    public List<Spqueryfield> getSpqueryfieldList() {
        return spqueryfieldList;
    }

    public void setSpqueryfieldList(List<Spqueryfield> spqueryfieldList) {
        this.spqueryfieldList = spqueryfieldList;
    }

    @XmlTransient
    public List<Spqueryfield> getSpqueryfieldList1() {
        return spqueryfieldList1;
    }

    public void setSpqueryfieldList1(List<Spqueryfield> spqueryfieldList1) {
        this.spqueryfieldList1 = spqueryfieldList1;
    }

    @XmlTransient
    public List<Groupperson> getGrouppersonList() {
        return grouppersonList;
    }

    public void setGrouppersonList(List<Groupperson> grouppersonList) {
        this.grouppersonList = grouppersonList;
    }

    @XmlTransient
    public List<Groupperson> getGrouppersonList1() {
        return grouppersonList1;
    }

    public void setGrouppersonList1(List<Groupperson> grouppersonList1) {
        this.grouppersonList1 = grouppersonList1;
    }

    @XmlTransient
    public List<Groupperson> getGrouppersonList2() {
        return grouppersonList2;
    }

    public void setGrouppersonList2(List<Groupperson> grouppersonList2) {
        this.grouppersonList2 = grouppersonList2;
    }

    @XmlTransient
    public List<Groupperson> getGrouppersonList3() {
        return grouppersonList3;
    }

    public void setGrouppersonList3(List<Groupperson> grouppersonList3) {
        this.grouppersonList3 = grouppersonList3;
    }

    @XmlTransient
    public List<Attributedef> getAttributedefList() {
        return attributedefList;
    }

    public void setAttributedefList(List<Attributedef> attributedefList) {
        this.attributedefList = attributedefList;
    }

    @XmlTransient
    public List<Attributedef> getAttributedefList1() {
        return attributedefList1;
    }

    public void setAttributedefList1(List<Attributedef> attributedefList1) {
        this.attributedefList1 = attributedefList1;
    }

    @XmlTransient
    public Collection getCollectionCCID() {
        return collectionCCID;
    }

    public void setCollectionCCID(Collection collectionCCID) {
        this.collectionCCID = collectionCCID;
    }

    @XmlTransient
    public Collection getCollectionTCID() {
        return collectionTCID;
    }

    public void setCollectionTCID(Collection collectionTCID) {
        this.collectionTCID = collectionTCID;
    }

    @XmlTransient
    public Specifyuser getSpecifyUserID() {
        return specifyUserID;
    }

    public void setSpecifyUserID(Specifyuser specifyUserID) {
        this.specifyUserID = specifyUserID;
    }

    @XmlTransient
    public List<Agent> getAgentList() {
        return agentList;
    }

    public void setAgentList(List<Agent> agentList) {
        this.agentList = agentList;
    }

    @XmlIDREF
    public Agent getModifiedByAgentID() {
        return modifiedByAgentID;
    }

    public void setModifiedByAgentID(Agent modifiedByAgentID) {
        this.modifiedByAgentID = modifiedByAgentID;
    }

    @XmlTransient
    public List<Agent> getAgentList1() {
        return agentList1;
    }

    public void setAgentList1(List<Agent> agentList1) {
        this.agentList1 = agentList1;
    }

    @XmlIDREF
    public Agent getCreatedByAgentID() {
        return createdByAgentID;
    }

    public void setCreatedByAgentID(Agent createdByAgentID) {
        this.createdByAgentID = createdByAgentID;
    }

    @XmlTransient
    public List<Agent> getAgentList2() {
        return agentList2;
    }

    public void setAgentList2(List<Agent> agentList2) {
        this.agentList2 = agentList2;
    }

    public Agent getParentOrganizationID() {
        return parentOrganizationID;
    }

    public void setParentOrganizationID(Agent parentOrganizationID) {
        this.parentOrganizationID = parentOrganizationID;
    }

    public Institution getInstitutionCCID() {
        return institutionCCID;
    }

    public void setInstitutionCCID(Institution institutionCCID) {
        this.institutionCCID = institutionCCID;
    }

    @XmlTransient
    public Institution getInstitutionTCID() {
        return institutionTCID;
    }

    public void setInstitutionTCID(Institution institutionTCID) {
        this.institutionTCID = institutionTCID;
    }

    @XmlTransient
    public Division getDivisionID() {
        return divisionID;
    }

    public void setDivisionID(Division divisionID) {
        this.divisionID = divisionID;
    }

    @XmlTransient
    public List<Collectionobject> getCollectionobjectList() {
        return collectionobjectList;
    }

    public void setCollectionobjectList(List<Collectionobject> collectionobjectList) {
        this.collectionobjectList = collectionobjectList;
    }

    @XmlTransient
    public List<Collectionobject> getCollectionobjectList1() {
        return collectionobjectList1;
    }

    public void setCollectionobjectList1(List<Collectionobject> collectionobjectList1) {
        this.collectionobjectList1 = collectionobjectList1;
    }

    @XmlTransient
    public List<Collectionobject> getCollectionobjectList2() {
        return collectionobjectList2;
    }

    public void setCollectionobjectList2(List<Collectionobject> collectionobjectList2) {
        this.collectionobjectList2 = collectionobjectList2;
    }

    @XmlTransient
    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    @XmlTransient
    public List<Project> getProjectList1() {
        return projectList1;
    }

    public void setProjectList1(List<Project> projectList1) {
        this.projectList1 = projectList1;
    }

    @XmlTransient
    public List<Project> getProjectList2() {
        return projectList2;
    }

    public void setProjectList2(List<Project> projectList2) {
        this.projectList2 = projectList2;
    }

    @XmlTransient
    public List<Splocalecontaineritem> getSplocalecontaineritemList() {
        return splocalecontaineritemList;
    }

    public void setSplocalecontaineritemList(List<Splocalecontaineritem> splocalecontaineritemList) {
        this.splocalecontaineritemList = splocalecontaineritemList;
    }

    @XmlTransient
    public List<Splocalecontaineritem> getSplocalecontaineritemList1() {
        return splocalecontaineritemList1;
    }

    public void setSplocalecontaineritemList1(List<Splocalecontaineritem> splocalecontaineritemList1) {
        this.splocalecontaineritemList1 = splocalecontaineritemList1;
    }

    @XmlTransient
    public List<Institution> getInstitutionList() {
        return institutionList;
    }

    public void setInstitutionList(List<Institution> institutionList) {
        this.institutionList = institutionList;
    }

    @XmlTransient
    public List<Institution> getInstitutionList1() {
        return institutionList1;
    }

    public void setInstitutionList1(List<Institution> institutionList1) {
        this.institutionList1 = institutionList1;
    }

    @XmlTransient
    public List<Collectingevent> getCollectingeventList() {
        return collectingeventList;
    }

    public void setCollectingeventList(List<Collectingevent> collectingeventList) {
        this.collectingeventList = collectingeventList;
    }

    @XmlTransient
    public List<Collectingevent> getCollectingeventList1() {
        return collectingeventList1;
    }

    public void setCollectingeventList1(List<Collectingevent> collectingeventList1) {
        this.collectingeventList1 = collectingeventList1;
    }

    @XmlTransient
    public List<Fieldnotebook> getFieldnotebookList() {
        return fieldnotebookList;
    }

    public void setFieldnotebookList(List<Fieldnotebook> fieldnotebookList) {
        this.fieldnotebookList = fieldnotebookList;
    }

    @XmlTransient
    public List<Fieldnotebook> getFieldnotebookList1() {
        return fieldnotebookList1;
    }

    public void setFieldnotebookList1(List<Fieldnotebook> fieldnotebookList1) {
        this.fieldnotebookList1 = fieldnotebookList1;
    }

    @XmlTransient
    public List<Fieldnotebook> getFieldnotebookList2() {
        return fieldnotebookList2;
    }

    public void setFieldnotebookList2(List<Fieldnotebook> fieldnotebookList2) {
        this.fieldnotebookList2 = fieldnotebookList2;
    }

    @XmlTransient
    public List<Geologictimeperiod> getGeologictimeperiodList() {
        return geologictimeperiodList;
    }

    public void setGeologictimeperiodList(List<Geologictimeperiod> geologictimeperiodList) {
        this.geologictimeperiodList = geologictimeperiodList;
    }

    @XmlTransient
    public List<Geologictimeperiod> getGeologictimeperiodList1() {
        return geologictimeperiodList1;
    }

    public void setGeologictimeperiodList1(List<Geologictimeperiod> geologictimeperiodList1) {
        this.geologictimeperiodList1 = geologictimeperiodList1;
    }

    @XmlTransient
    public List<Lithostrat> getLithostratList() {
        return lithostratList;
    }

    public void setLithostratList(List<Lithostrat> lithostratList) {
        this.lithostratList = lithostratList;
    }

    @XmlTransient
    public List<Lithostrat> getLithostratList1() {
        return lithostratList1;
    }

    public void setLithostratList1(List<Lithostrat> lithostratList1) {
        this.lithostratList1 = lithostratList1;
    }

    @XmlTransient
    public List<Taxoncitation> getTaxoncitationList() {
        return taxoncitationList;
    }

    public void setTaxoncitationList(List<Taxoncitation> taxoncitationList) {
        this.taxoncitationList = taxoncitationList;
    }

    @XmlTransient
    public List<Taxoncitation> getTaxoncitationList1() {
        return taxoncitationList1;
    }

    public void setTaxoncitationList1(List<Taxoncitation> taxoncitationList1) {
        this.taxoncitationList1 = taxoncitationList1;
    }

    @XmlTransient
    public List<Dnasequencingruncitation> getDnasequencingruncitationList() {
        return dnasequencingruncitationList;
    }

    public void setDnasequencingruncitationList(List<Dnasequencingruncitation> dnasequencingruncitationList) {
        this.dnasequencingruncitationList = dnasequencingruncitationList;
    }

    @XmlTransient
    public List<Dnasequencingruncitation> getDnasequencingruncitationList1() {
        return dnasequencingruncitationList1;
    }

    public void setDnasequencingruncitationList1(List<Dnasequencingruncitation> dnasequencingruncitationList1) {
        this.dnasequencingruncitationList1 = dnasequencingruncitationList1;
    }

    @XmlTransient
    public List<Dnasequence> getDnasequenceList() {
        return dnasequenceList;
    }

    public void setDnasequenceList(List<Dnasequence> dnasequenceList) {
        this.dnasequenceList = dnasequenceList;
    }

    @XmlTransient
    public List<Dnasequence> getDnasequenceList1() {
        return dnasequenceList1;
    }

    public void setDnasequenceList1(List<Dnasequence> dnasequenceList1) {
        this.dnasequenceList1 = dnasequenceList1;
    }

    @XmlTransient
    public List<Dnasequence> getDnasequenceList2() {
        return dnasequenceList2;
    }

    public void setDnasequenceList2(List<Dnasequence> dnasequenceList2) {
        this.dnasequenceList2 = dnasequenceList2;
    }

    @XmlTransient
    public List<Preparationattr> getPreparationattrList() {
        return preparationattrList;
    }

    public void setPreparationattrList(List<Preparationattr> preparationattrList) {
        this.preparationattrList = preparationattrList;
    }

    @XmlTransient
    public List<Preparationattr> getPreparationattrList1() {
        return preparationattrList1;
    }

    public void setPreparationattrList1(List<Preparationattr> preparationattrList1) {
        this.preparationattrList1 = preparationattrList1;
    }

    @XmlTransient
    public List<Borrowreturnmaterial> getBorrowreturnmaterialList() {
        return borrowreturnmaterialList;
    }

    public void setBorrowreturnmaterialList(List<Borrowreturnmaterial> borrowreturnmaterialList) {
        this.borrowreturnmaterialList = borrowreturnmaterialList;
    }

    @XmlTransient
    public List<Borrowreturnmaterial> getBorrowreturnmaterialList1() {
        return borrowreturnmaterialList1;
    }

    public void setBorrowreturnmaterialList1(List<Borrowreturnmaterial> borrowreturnmaterialList1) {
        this.borrowreturnmaterialList1 = borrowreturnmaterialList1;
    }

    @XmlTransient
    public List<Borrowreturnmaterial> getBorrowreturnmaterialList2() {
        return borrowreturnmaterialList2;
    }

    public void setBorrowreturnmaterialList2(List<Borrowreturnmaterial> borrowreturnmaterialList2) {
        this.borrowreturnmaterialList2 = borrowreturnmaterialList2;
    }

    @XmlTransient
    public List<Workbench> getWorkbenchList() {
        return workbenchList;
    }

    public void setWorkbenchList(List<Workbench> workbenchList) {
        this.workbenchList = workbenchList;
    }

    @XmlTransient
    public List<Workbench> getWorkbenchList1() {
        return workbenchList1;
    }

    public void setWorkbenchList1(List<Workbench> workbenchList1) {
        this.workbenchList1 = workbenchList1;
    }

    @XmlTransient
    public List<Spauditlogfield> getSpauditlogfieldList() {
        return spauditlogfieldList;
    }

    public void setSpauditlogfieldList(List<Spauditlogfield> spauditlogfieldList) {
        this.spauditlogfieldList = spauditlogfieldList;
    }

    @XmlTransient
    public List<Spauditlogfield> getSpauditlogfieldList1() {
        return spauditlogfieldList1;
    }

    public void setSpauditlogfieldList1(List<Spauditlogfield> spauditlogfieldList1) {
        this.spauditlogfieldList1 = spauditlogfieldList1;
    }

    @XmlTransient
    public List<Referencework> getReferenceworkList() {
        return referenceworkList;
    }

    public void setReferenceworkList(List<Referencework> referenceworkList) {
        this.referenceworkList = referenceworkList;
    }

    @XmlTransient
    public List<Referencework> getReferenceworkList1() {
        return referenceworkList1;
    }

    public void setReferenceworkList1(List<Referencework> referenceworkList1) {
        this.referenceworkList1 = referenceworkList1;
    }

    @XmlTransient
    public List<Shipment> getShipmentList() {
        return shipmentList;
    }

    public void setShipmentList(List<Shipment> shipmentList) {
        this.shipmentList = shipmentList;
    }

    @XmlTransient
    public List<Shipment> getShipmentList1() {
        return shipmentList1;
    }

    public void setShipmentList1(List<Shipment> shipmentList1) {
        this.shipmentList1 = shipmentList1;
    }

    @XmlTransient
    public List<Shipment> getShipmentList2() {
        return shipmentList2;
    }

    public void setShipmentList2(List<Shipment> shipmentList2) {
        this.shipmentList2 = shipmentList2;
    }

    @XmlTransient
    public List<Shipment> getShipmentList3() {
        return shipmentList3;
    }

    public void setShipmentList3(List<Shipment> shipmentList3) {
        this.shipmentList3 = shipmentList3;
    }

    @XmlTransient
    public List<Shipment> getShipmentList4() {
        return shipmentList4;
    }

    public void setShipmentList4(List<Shipment> shipmentList4) {
        this.shipmentList4 = shipmentList4;
    }

    @XmlTransient
    public List<Repositoryagreement> getRepositoryagreementList() {
        return repositoryagreementList;
    }

    public void setRepositoryagreementList(List<Repositoryagreement> repositoryagreementList) {
        this.repositoryagreementList = repositoryagreementList;
    }

    @XmlTransient
    public List<Repositoryagreement> getRepositoryagreementList1() {
        return repositoryagreementList1;
    }

    public void setRepositoryagreementList1(List<Repositoryagreement> repositoryagreementList1) {
        this.repositoryagreementList1 = repositoryagreementList1;
    }

    @XmlTransient
    public List<Repositoryagreement> getRepositoryagreementList2() {
        return repositoryagreementList2;
    }

    public void setRepositoryagreementList2(List<Repositoryagreement> repositoryagreementList2) {
        this.repositoryagreementList2 = repositoryagreementList2;
    }

    @XmlTransient
    public List<Splocalecontainer> getSplocalecontainerList() {
        return splocalecontainerList;
    }

    public void setSplocalecontainerList(List<Splocalecontainer> splocalecontainerList) {
        this.splocalecontainerList = splocalecontainerList;
    }

    @XmlTransient
    public List<Splocalecontainer> getSplocalecontainerList1() {
        return splocalecontainerList1;
    }

    public void setSplocalecontainerList1(List<Splocalecontainer> splocalecontainerList1) {
        this.splocalecontainerList1 = splocalecontainerList1;
    }

    @XmlTransient
    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    @XmlTransient
    public List<Author> getAuthorList1() {
        return authorList1;
    }

    public void setAuthorList1(List<Author> authorList1) {
        this.authorList1 = authorList1;
    }

    @XmlTransient
    public List<Author> getAuthorList2() {
        return authorList2;
    }

    public void setAuthorList2(List<Author> authorList2) {
        this.authorList2 = authorList2;
    }

    @XmlTransient
    public List<Accessionagent> getAccessionagentList() {
        return accessionagentList;
    }

    public void setAccessionagentList(List<Accessionagent> accessionagentList) {
        this.accessionagentList = accessionagentList;
    }

    @XmlTransient
    public List<Accessionagent> getAccessionagentList1() {
        return accessionagentList1;
    }

    public void setAccessionagentList1(List<Accessionagent> accessionagentList1) {
        this.accessionagentList1 = accessionagentList1;
    }

    @XmlTransient
    public List<Accessionagent> getAccessionagentList2() {
        return accessionagentList2;
    }

    public void setAccessionagentList2(List<Accessionagent> accessionagentList2) {
        this.accessionagentList2 = accessionagentList2;
    }

    @XmlTransient
    public List<Workbenchtemplate> getWorkbenchtemplateList() {
        return workbenchtemplateList;
    }

    public void setWorkbenchtemplateList(List<Workbenchtemplate> workbenchtemplateList) {
        this.workbenchtemplateList = workbenchtemplateList;
    }

    @XmlTransient
    public List<Workbenchtemplate> getWorkbenchtemplateList1() {
        return workbenchtemplateList1;
    }

    public void setWorkbenchtemplateList1(List<Workbenchtemplate> workbenchtemplateList1) {
        this.workbenchtemplateList1 = workbenchtemplateList1;
    }

    @XmlTransient
    public List<Taxontreedefitem> getTaxontreedefitemList() {
        return taxontreedefitemList;
    }

    public void setTaxontreedefitemList(List<Taxontreedefitem> taxontreedefitemList) {
        this.taxontreedefitemList = taxontreedefitemList;
    }

    @XmlTransient
    public List<Taxontreedefitem> getTaxontreedefitemList1() {
        return taxontreedefitemList1;
    }

    public void setTaxontreedefitemList1(List<Taxontreedefitem> taxontreedefitemList1) {
        this.taxontreedefitemList1 = taxontreedefitemList1;
    }

    @XmlTransient
    public List<Conservevent> getConserveventList() {
        return conserveventList;
    }

    public void setConserveventList(List<Conservevent> conserveventList) {
        this.conserveventList = conserveventList;
    }

    @XmlTransient
    public List<Conservevent> getConserveventList1() {
        return conserveventList1;
    }

    public void setConserveventList1(List<Conservevent> conserveventList1) {
        this.conserveventList1 = conserveventList1;
    }

    @XmlTransient
    public List<Conservevent> getConserveventList2() {
        return conserveventList2;
    }

    public void setConserveventList2(List<Conservevent> conserveventList2) {
        this.conserveventList2 = conserveventList2;
    }

    @XmlTransient
    public List<Conservevent> getConserveventList3() {
        return conserveventList3;
    }

    public void setConserveventList3(List<Conservevent> conserveventList3) {
        this.conserveventList3 = conserveventList3;
    }

    @XmlTransient
    public List<Conservevent> getConserveventList4() {
        return conserveventList4;
    }

    public void setConserveventList4(List<Conservevent> conserveventList4) {
        this.conserveventList4 = conserveventList4;
    }

    @XmlTransient
    public List<Collection> getCollectionList() {
        return collectionList;
    }

    public void setCollectionList(List<Collection> collectionList) {
        this.collectionList = collectionList;
    }

    @XmlTransient
    public List<Collection> getCollectionList1() {
        return collectionList1;
    }

    public void setCollectionList1(List<Collection> collectionList1) {
        this.collectionList1 = collectionList1;
    }

    @XmlTransient
    public List<Fieldnotebookpageattachment> getFieldnotebookpageattachmentList() {
        return fieldnotebookpageattachmentList;
    }

    public void setFieldnotebookpageattachmentList(List<Fieldnotebookpageattachment> fieldnotebookpageattachmentList) {
        this.fieldnotebookpageattachmentList = fieldnotebookpageattachmentList;
    }

    @XmlTransient
    public List<Fieldnotebookpageattachment> getFieldnotebookpageattachmentList1() {
        return fieldnotebookpageattachmentList1;
    }

    public void setFieldnotebookpageattachmentList1(List<Fieldnotebookpageattachment> fieldnotebookpageattachmentList1) {
        this.fieldnotebookpageattachmentList1 = fieldnotebookpageattachmentList1;
    }

    @XmlTransient
    public List<Spprincipal> getSpprincipalList() {
        return spprincipalList;
    }

    public void setSpprincipalList(List<Spprincipal> spprincipalList) {
        this.spprincipalList = spprincipalList;
    }

    @XmlTransient
    public List<Spprincipal> getSpprincipalList1() {
        return spprincipalList1;
    }

    public void setSpprincipalList1(List<Spprincipal> spprincipalList1) {
        this.spprincipalList1 = spprincipalList1;
    }

    @XmlTransient
    public List<Fieldnotebookattachment> getFieldnotebookattachmentList() {
        return fieldnotebookattachmentList;
    }

    public void setFieldnotebookattachmentList(List<Fieldnotebookattachment> fieldnotebookattachmentList) {
        this.fieldnotebookattachmentList = fieldnotebookattachmentList;
    }

    @XmlTransient
    public List<Fieldnotebookattachment> getFieldnotebookattachmentList1() {
        return fieldnotebookattachmentList1;
    }

    public void setFieldnotebookattachmentList1(List<Fieldnotebookattachment> fieldnotebookattachmentList1) {
        this.fieldnotebookattachmentList1 = fieldnotebookattachmentList1;
    }

    @XmlTransient
    public List<Preparationattribute> getPreparationattributeList() {
        return preparationattributeList;
    }

    public void setPreparationattributeList(List<Preparationattribute> preparationattributeList) {
        this.preparationattributeList = preparationattributeList;
    }

    @XmlTransient
    public List<Preparationattribute> getPreparationattributeList1() {
        return preparationattributeList1;
    }

    public void setPreparationattributeList1(List<Preparationattribute> preparationattributeList1) {
        this.preparationattributeList1 = preparationattributeList1;
    }

    @XmlTransient
    public List<Inforequest> getInforequestList() {
        return inforequestList;
    }

    public void setInforequestList(List<Inforequest> inforequestList) {
        this.inforequestList = inforequestList;
    }

    @XmlTransient
    public List<Inforequest> getInforequestList1() {
        return inforequestList1;
    }

    public void setInforequestList1(List<Inforequest> inforequestList1) {
        this.inforequestList1 = inforequestList1;
    }

    @XmlTransient
    public List<Inforequest> getInforequestList2() {
        return inforequestList2;
    }

    public void setInforequestList2(List<Inforequest> inforequestList2) {
        this.inforequestList2 = inforequestList2;
    }

    @XmlTransient
    public List<Collectingeventattr> getCollectingeventattrList() {
        return collectingeventattrList;
    }

    public void setCollectingeventattrList(List<Collectingeventattr> collectingeventattrList) {
        this.collectingeventattrList = collectingeventattrList;
    }

    @XmlTransient
    public List<Collectingeventattr> getCollectingeventattrList1() {
        return collectingeventattrList1;
    }

    public void setCollectingeventattrList1(List<Collectingeventattr> collectingeventattrList1) {
        this.collectingeventattrList1 = collectingeventattrList1;
    }

    @XmlTransient
    public List<Spappresourcedir> getSpappresourcedirList() {
        return spappresourcedirList;
    }

    public void setSpappresourcedirList(List<Spappresourcedir> spappresourcedirList) {
        this.spappresourcedirList = spappresourcedirList;
    }

    @XmlTransient
    public List<Spappresourcedir> getSpappresourcedirList1() {
        return spappresourcedirList1;
    }

    public void setSpappresourcedirList1(List<Spappresourcedir> spappresourcedirList1) {
        this.spappresourcedirList1 = spappresourcedirList1;
    }

    @XmlTransient
    public List<Spexportschema> getSpexportschemaList() {
        return spexportschemaList;
    }

    public void setSpexportschemaList(List<Spexportschema> spexportschemaList) {
        this.spexportschemaList = spexportschemaList;
    }

    @XmlTransient
    public List<Spexportschema> getSpexportschemaList1() {
        return spexportschemaList1;
    }

    public void setSpexportschemaList1(List<Spexportschema> spexportschemaList1) {
        this.spexportschemaList1 = spexportschemaList1;
    }

    @XmlTransient
    public List<Collectionrelationship> getCollectionrelationshipList() {
        return collectionrelationshipList;
    }

    public void setCollectionrelationshipList(List<Collectionrelationship> collectionrelationshipList) {
        this.collectionrelationshipList = collectionrelationshipList;
    }

    @XmlTransient
    public List<Collectionrelationship> getCollectionrelationshipList1() {
        return collectionrelationshipList1;
    }

    public void setCollectionrelationshipList1(List<Collectionrelationship> collectionrelationshipList1) {
        this.collectionrelationshipList1 = collectionrelationshipList1;
    }

    @XmlTransient
    public List<Attachmenttag> getAttachmenttagList() {
        return attachmenttagList;
    }

    public void setAttachmenttagList(List<Attachmenttag> attachmenttagList) {
        this.attachmenttagList = attachmenttagList;
    }

    @XmlTransient
    public List<Attachmenttag> getAttachmenttagList1() {
        return attachmenttagList1;
    }

    public void setAttachmenttagList1(List<Attachmenttag> attachmenttagList1) {
        this.attachmenttagList1 = attachmenttagList1;
    }

    @XmlTransient
    public List<Geographytreedefitem> getGeographytreedefitemList() {
        return geographytreedefitemList;
    }

    public void setGeographytreedefitemList(List<Geographytreedefitem> geographytreedefitemList) {
        this.geographytreedefitemList = geographytreedefitemList;
    }

    @XmlTransient
    public List<Geographytreedefitem> getGeographytreedefitemList1() {
        return geographytreedefitemList1;
    }

    public void setGeographytreedefitemList1(List<Geographytreedefitem> geographytreedefitemList1) {
        this.geographytreedefitemList1 = geographytreedefitemList1;
    }

    @XmlTransient
    public List<Borrowagent> getBorrowagentList() {
        return borrowagentList;
    }

    public void setBorrowagentList(List<Borrowagent> borrowagentList) {
        this.borrowagentList = borrowagentList;
    }

    @XmlTransient
    public List<Borrowagent> getBorrowagentList1() {
        return borrowagentList1;
    }

    public void setBorrowagentList1(List<Borrowagent> borrowagentList1) {
        this.borrowagentList1 = borrowagentList1;
    }

    @XmlTransient
    public List<Borrowagent> getBorrowagentList2() {
        return borrowagentList2;
    }

    public void setBorrowagentList2(List<Borrowagent> borrowagentList2) {
        this.borrowagentList2 = borrowagentList2;
    }

    @XmlTransient
    public List<Geologictimeperiodtreedefitem> getGeologictimeperiodtreedefitemList() {
        return geologictimeperiodtreedefitemList;
    }

    public void setGeologictimeperiodtreedefitemList(List<Geologictimeperiodtreedefitem> geologictimeperiodtreedefitemList) {
        this.geologictimeperiodtreedefitemList = geologictimeperiodtreedefitemList;
    }

    @XmlTransient
    public List<Geologictimeperiodtreedefitem> getGeologictimeperiodtreedefitemList1() {
        return geologictimeperiodtreedefitemList1;
    }

    public void setGeologictimeperiodtreedefitemList1(List<Geologictimeperiodtreedefitem> geologictimeperiodtreedefitemList1) {
        this.geologictimeperiodtreedefitemList1 = geologictimeperiodtreedefitemList1;
    }

    @XmlTransient
    public List<Loan> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<Loan> loanList) {
        this.loanList = loanList;
    }

    @XmlTransient
    public List<Loan> getLoanList1() {
        return loanList1;
    }

    public void setLoanList1(List<Loan> loanList1) {
        this.loanList1 = loanList1;
    }

    @XmlTransient
    public List<Fieldnotebookpage> getFieldnotebookpageList() {
        return fieldnotebookpageList;
    }

    public void setFieldnotebookpageList(List<Fieldnotebookpage> fieldnotebookpageList) {
        this.fieldnotebookpageList = fieldnotebookpageList;
    }

    @XmlTransient
    public List<Fieldnotebookpage> getFieldnotebookpageList1() {
        return fieldnotebookpageList1;
    }

    public void setFieldnotebookpageList1(List<Fieldnotebookpage> fieldnotebookpageList1) {
        this.fieldnotebookpageList1 = fieldnotebookpageList1;
    }

    @XmlTransient
    public List<Agentspecialty> getAgentspecialtyList() {
        return agentspecialtyList;
    }

    public void setAgentspecialtyList(List<Agentspecialty> agentspecialtyList) {
        this.agentspecialtyList = agentspecialtyList;
    }

    @XmlTransient
    public List<Agentspecialty> getAgentspecialtyList1() {
        return agentspecialtyList1;
    }

    public void setAgentspecialtyList1(List<Agentspecialty> agentspecialtyList1) {
        this.agentspecialtyList1 = agentspecialtyList1;
    }

    @XmlTransient
    public List<Agentspecialty> getAgentspecialtyList2() {
        return agentspecialtyList2;
    }

    public void setAgentspecialtyList2(List<Agentspecialty> agentspecialtyList2) {
        this.agentspecialtyList2 = agentspecialtyList2;
    }

    @XmlTransient
    public List<Picklist> getPicklistList() {
        return picklistList;
    }

    public void setPicklistList(List<Picklist> picklistList) {
        this.picklistList = picklistList;
    }

    @XmlTransient
    public List<Picklist> getPicklistList1() {
        return picklistList1;
    }

    public void setPicklistList1(List<Picklist> picklistList1) {
        this.picklistList1 = picklistList1;
    }

    @XmlTransient
    public List<Accession> getAccessionList() {
        return accessionList;
    }

    public void setAccessionList(List<Accession> accessionList) {
        this.accessionList = accessionList;
    }

    @XmlTransient
    public List<Accession> getAccessionList1() {
        return accessionList1;
    }

    public void setAccessionList1(List<Accession> accessionList1) {
        this.accessionList1 = accessionList1;
    }

    @XmlTransient
    public List<Storage> getStorageList() {
        return storageList;
    }

    public void setStorageList(List<Storage> storageList) {
        this.storageList = storageList;
    }

    @XmlTransient
    public List<Storage> getStorageList1() {
        return storageList1;
    }

    public void setStorageList1(List<Storage> storageList1) {
        this.storageList1 = storageList1;
    }

    @XmlTransient
    public List<Dnasequencerunattachment> getDnasequencerunattachmentList() {
        return dnasequencerunattachmentList;
    }

    public void setDnasequencerunattachmentList(List<Dnasequencerunattachment> dnasequencerunattachmentList) {
        this.dnasequencerunattachmentList = dnasequencerunattachmentList;
    }

    @XmlTransient
    public List<Dnasequencerunattachment> getDnasequencerunattachmentList1() {
        return dnasequencerunattachmentList1;
    }

    public void setDnasequencerunattachmentList1(List<Dnasequencerunattachment> dnasequencerunattachmentList1) {
        this.dnasequencerunattachmentList1 = dnasequencerunattachmentList1;
    }

    @XmlTransient
    public List<Giftagent> getGiftagentList() {
        return giftagentList;
    }

    public void setGiftagentList(List<Giftagent> giftagentList) {
        this.giftagentList = giftagentList;
    }

    @XmlTransient
    public List<Giftagent> getGiftagentList1() {
        return giftagentList1;
    }

    public void setGiftagentList1(List<Giftagent> giftagentList1) {
        this.giftagentList1 = giftagentList1;
    }

    @XmlTransient
    public List<Giftagent> getGiftagentList2() {
        return giftagentList2;
    }

    public void setGiftagentList2(List<Giftagent> giftagentList2) {
        this.giftagentList2 = giftagentList2;
    }

    @XmlTransient
    public List<Collector> getCollectorList() {
        return collectorList;
    }

    public void setCollectorList(List<Collector> collectorList) {
        this.collectorList = collectorList;
    }

    @XmlTransient
    public List<Collector> getCollectorList1() {
        return collectorList1;
    }

    public void setCollectorList1(List<Collector> collectorList1) {
        this.collectorList1 = collectorList1;
    }

    @XmlTransient
    public List<Collector> getCollectorList2() {
        return collectorList2;
    }

    public void setCollectorList2(List<Collector> collectorList2) {
        this.collectorList2 = collectorList2;
    }

    @XmlTransient
    public List<Attachment> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(List<Attachment> attachmentList) {
        this.attachmentList = attachmentList;
    }

    @XmlTransient
    public List<Attachment> getAttachmentList1() {
        return attachmentList1;
    }

    public void setAttachmentList1(List<Attachment> attachmentList1) {
        this.attachmentList1 = attachmentList1;
    }

    @XmlTransient
    public List<Appraisal> getAppraisalList() {
        return appraisalList;
    }

    public void setAppraisalList(List<Appraisal> appraisalList) {
        this.appraisalList = appraisalList;
    }

    @XmlTransient
    public List<Appraisal> getAppraisalList1() {
        return appraisalList1;
    }

    public void setAppraisalList1(List<Appraisal> appraisalList1) {
        this.appraisalList1 = appraisalList1;
    }

    @XmlTransient
    public List<Appraisal> getAppraisalList2() {
        return appraisalList2;
    }

    public void setAppraisalList2(List<Appraisal> appraisalList2) {
        this.appraisalList2 = appraisalList2;
    }

    @XmlTransient
    public List<Agentgeography> getAgentgeographyList() {
        return agentgeographyList;
    }

    public void setAgentgeographyList(List<Agentgeography> agentgeographyList) {
        this.agentgeographyList = agentgeographyList;
    }

    @XmlTransient
    public List<Agentgeography> getAgentgeographyList1() {
        return agentgeographyList1;
    }

    public void setAgentgeographyList1(List<Agentgeography> agentgeographyList1) {
        this.agentgeographyList1 = agentgeographyList1;
    }

    @XmlTransient
    public List<Agentgeography> getAgentgeographyList2() {
        return agentgeographyList2;
    }

    public void setAgentgeographyList2(List<Agentgeography> agentgeographyList2) {
        this.agentgeographyList2 = agentgeographyList2;
    }

    @XmlTransient
    public List<Collectionobjectcitation> getCollectionobjectcitationList() {
        return collectionobjectcitationList;
    }

    public void setCollectionobjectcitationList(List<Collectionobjectcitation> collectionobjectcitationList) {
        this.collectionobjectcitationList = collectionobjectcitationList;
    }

    @XmlTransient
    public List<Collectionobjectcitation> getCollectionobjectcitationList1() {
        return collectionobjectcitationList1;
    }

    public void setCollectionobjectcitationList1(List<Collectionobjectcitation> collectionobjectcitationList1) {
        this.collectionobjectcitationList1 = collectionobjectcitationList1;
    }

    @XmlTransient
    public List<Spappresourcedata> getSpappresourcedataList() {
        return spappresourcedataList;
    }

    public void setSpappresourcedataList(List<Spappresourcedata> spappresourcedataList) {
        this.spappresourcedataList = spappresourcedataList;
    }

    @XmlTransient
    public List<Spappresourcedata> getSpappresourcedataList1() {
        return spappresourcedataList1;
    }

    public void setSpappresourcedataList1(List<Spappresourcedata> spappresourcedataList1) {
        this.spappresourcedataList1 = spappresourcedataList1;
    }

    @XmlTransient
    public List<Spexportschemaitemmapping> getSpexportschemaitemmappingList() {
        return spexportschemaitemmappingList;
    }

    public void setSpexportschemaitemmappingList(List<Spexportschemaitemmapping> spexportschemaitemmappingList) {
        this.spexportschemaitemmappingList = spexportschemaitemmappingList;
    }

    @XmlTransient
    public List<Spexportschemaitemmapping> getSpexportschemaitemmappingList1() {
        return spexportschemaitemmappingList1;
    }

    public void setSpexportschemaitemmappingList1(List<Spexportschemaitemmapping> spexportschemaitemmappingList1) {
        this.spexportschemaitemmappingList1 = spexportschemaitemmappingList1;
    }

    @XmlTransient
    public List<Specifyuser> getSpecifyuserList() {
        return specifyuserList;
    }

    public void setSpecifyuserList(List<Specifyuser> specifyuserList) {
        this.specifyuserList = specifyuserList;
    }

    @XmlTransient
    public List<Specifyuser> getSpecifyuserList1() {
        return specifyuserList1;
    }

    public void setSpecifyuserList1(List<Specifyuser> specifyuserList1) {
        this.specifyuserList1 = specifyuserList1;
    }

    @XmlTransient
    public List<Exchangein> getExchangeinList() {
        return exchangeinList;
    }

    public void setExchangeinList(List<Exchangein> exchangeinList) {
        this.exchangeinList = exchangeinList;
    }

    @XmlTransient
    public List<Exchangein> getExchangeinList1() {
        return exchangeinList1;
    }

    public void setExchangeinList1(List<Exchangein> exchangeinList1) {
        this.exchangeinList1 = exchangeinList1;
    }

    @XmlTransient
    public List<Exchangein> getExchangeinList2() {
        return exchangeinList2;
    }

    public void setExchangeinList2(List<Exchangein> exchangeinList2) {
        this.exchangeinList2 = exchangeinList2;
    }

    @XmlTransient
    public List<Exchangein> getExchangeinList3() {
        return exchangeinList3;
    }

    public void setExchangeinList3(List<Exchangein> exchangeinList3) {
        this.exchangeinList3 = exchangeinList3;
    }

    @XmlTransient
    public List<Fieldnotebookpagesetattachment> getFieldnotebookpagesetattachmentList() {
        return fieldnotebookpagesetattachmentList;
    }

    public void setFieldnotebookpagesetattachmentList(List<Fieldnotebookpagesetattachment> fieldnotebookpagesetattachmentList) {
        this.fieldnotebookpagesetattachmentList = fieldnotebookpagesetattachmentList;
    }

    @XmlTransient
    public List<Fieldnotebookpagesetattachment> getFieldnotebookpagesetattachmentList1() {
        return fieldnotebookpagesetattachmentList1;
    }

    public void setFieldnotebookpagesetattachmentList1(List<Fieldnotebookpagesetattachment> fieldnotebookpagesetattachmentList1) {
        this.fieldnotebookpagesetattachmentList1 = fieldnotebookpagesetattachmentList1;
    }

    @XmlTransient
    public List<Commonnametx> getCommonnametxList() {
        return commonnametxList;
    }

    public void setCommonnametxList(List<Commonnametx> commonnametxList) {
        this.commonnametxList = commonnametxList;
    }

    @XmlTransient
    public List<Commonnametx> getCommonnametxList1() {
        return commonnametxList1;
    }

    public void setCommonnametxList1(List<Commonnametx> commonnametxList1) {
        this.commonnametxList1 = commonnametxList1;
    }

    @XmlTransient
    public List<Loanpreparation> getLoanpreparationList() {
        return loanpreparationList;
    }

    public void setLoanpreparationList(List<Loanpreparation> loanpreparationList) {
        this.loanpreparationList = loanpreparationList;
    }

    @XmlTransient
    public List<Loanpreparation> getLoanpreparationList1() {
        return loanpreparationList1;
    }

    public void setLoanpreparationList1(List<Loanpreparation> loanpreparationList1) {
        this.loanpreparationList1 = loanpreparationList1;
    }

    @XmlTransient
    public List<Otheridentifier> getOtheridentifierList() {
        return otheridentifierList;
    }

    public void setOtheridentifierList(List<Otheridentifier> otheridentifierList) {
        this.otheridentifierList = otheridentifierList;
    }

    @XmlTransient
    public List<Otheridentifier> getOtheridentifierList1() {
        return otheridentifierList1;
    }

    public void setOtheridentifierList1(List<Otheridentifier> otheridentifierList1) {
        this.otheridentifierList1 = otheridentifierList1;
    }

    @XmlTransient
    public List<Spexportschemamapping> getSpexportschemamappingList() {
        return spexportschemamappingList;
    }

    public void setSpexportschemamappingList(List<Spexportschemamapping> spexportschemamappingList) {
        this.spexportschemamappingList = spexportschemamappingList;
    }

    @XmlTransient
    public List<Spexportschemamapping> getSpexportschemamappingList1() {
        return spexportschemamappingList1;
    }

    public void setSpexportschemamappingList1(List<Spexportschemamapping> spexportschemamappingList1) {
        this.spexportschemamappingList1 = spexportschemamappingList1;
    }

    @XmlTransient
    public List<Giftpreparation> getGiftpreparationList() {
        return giftpreparationList;
    }

    public void setGiftpreparationList(List<Giftpreparation> giftpreparationList) {
        this.giftpreparationList = giftpreparationList;
    }

    @XmlTransient
    public List<Giftpreparation> getGiftpreparationList1() {
        return giftpreparationList1;
    }

    public void setGiftpreparationList1(List<Giftpreparation> giftpreparationList1) {
        this.giftpreparationList1 = giftpreparationList1;
    }

    @XmlTransient
    public List<Spversion> getSpversionList() {
        return spversionList;
    }

    public void setSpversionList(List<Spversion> spversionList) {
        this.spversionList = spversionList;
    }

    @XmlTransient
    public List<Spversion> getSpversionList1() {
        return spversionList1;
    }

    public void setSpversionList1(List<Spversion> spversionList1) {
        this.spversionList1 = spversionList1;
    }

    @XmlTransient
    public List<Loanagent> getLoanagentList() {
        return loanagentList;
    }

    public void setLoanagentList(List<Loanagent> loanagentList) {
        this.loanagentList = loanagentList;
    }

    @XmlTransient
    public List<Loanagent> getLoanagentList1() {
        return loanagentList1;
    }

    public void setLoanagentList1(List<Loanagent> loanagentList1) {
        this.loanagentList1 = loanagentList1;
    }

    @XmlTransient
    public List<Loanagent> getLoanagentList2() {
        return loanagentList2;
    }

    public void setLoanagentList2(List<Loanagent> loanagentList2) {
        this.loanagentList2 = loanagentList2;
    }

    @XmlTransient
    public List<Spviewsetobj> getSpviewsetobjList() {
        return spviewsetobjList;
    }

    public void setSpviewsetobjList(List<Spviewsetobj> spviewsetobjList) {
        this.spviewsetobjList = spviewsetobjList;
    }

    @XmlTransient
    public List<Spviewsetobj> getSpviewsetobjList1() {
        return spviewsetobjList1;
    }

    public void setSpviewsetobjList1(List<Spviewsetobj> spviewsetobjList1) {
        this.spviewsetobjList1 = spviewsetobjList1;
    }

    @XmlTransient
    public List<Deaccessionpreparation> getDeaccessionpreparationList() {
        return deaccessionpreparationList;
    }

    public void setDeaccessionpreparationList(List<Deaccessionpreparation> deaccessionpreparationList) {
        this.deaccessionpreparationList = deaccessionpreparationList;
    }

    @XmlTransient
    public List<Deaccessionpreparation> getDeaccessionpreparationList1() {
        return deaccessionpreparationList1;
    }

    public void setDeaccessionpreparationList1(List<Deaccessionpreparation> deaccessionpreparationList1) {
        this.deaccessionpreparationList1 = deaccessionpreparationList1;
    }

    @XmlTransient
    public List<Accessionauthorization> getAccessionauthorizationList() {
        return accessionauthorizationList;
    }

    public void setAccessionauthorizationList(List<Accessionauthorization> accessionauthorizationList) {
        this.accessionauthorizationList = accessionauthorizationList;
    }

    @XmlTransient
    public List<Accessionauthorization> getAccessionauthorizationList1() {
        return accessionauthorizationList1;
    }

    public void setAccessionauthorizationList1(List<Accessionauthorization> accessionauthorizationList1) {
        this.accessionauthorizationList1 = accessionauthorizationList1;
    }

    @XmlTransient
    public List<Permit> getPermitList() {
        return permitList;
    }

    public void setPermitList(List<Permit> permitList) {
        this.permitList = permitList;
    }

    @XmlTransient
    public List<Permit> getPermitList1() {
        return permitList1;
    }

    public void setPermitList1(List<Permit> permitList1) {
        this.permitList1 = permitList1;
    }

    @XmlTransient
    public List<Permit> getPermitList2() {
        return permitList2;
    }

    public void setPermitList2(List<Permit> permitList2) {
        this.permitList2 = permitList2;
    }

    @XmlTransient
    public List<Permit> getPermitList3() {
        return permitList3;
    }

    public void setPermitList3(List<Permit> permitList3) {
        this.permitList3 = permitList3;
    }

    @XmlTransient
    public List<Collectionobjectattr> getCollectionobjectattrList() {
        return collectionobjectattrList;
    }

    public void setCollectionobjectattrList(List<Collectionobjectattr> collectionobjectattrList) {
        this.collectionobjectattrList = collectionobjectattrList;
    }

    @XmlTransient
    public List<Collectionobjectattr> getCollectionobjectattrList1() {
        return collectionobjectattrList1;
    }

    public void setCollectionobjectattrList1(List<Collectionobjectattr> collectionobjectattrList1) {
        this.collectionobjectattrList1 = collectionobjectattrList1;
    }

    @XmlTransient
    public List<Spauditlog> getSpauditlogList() {
        return spauditlogList;
    }

    public void setSpauditlogList(List<Spauditlog> spauditlogList) {
        this.spauditlogList = spauditlogList;
    }

    @XmlTransient
    public List<Spauditlog> getSpauditlogList1() {
        return spauditlogList1;
    }

    public void setSpauditlogList1(List<Spauditlog> spauditlogList1) {
        this.spauditlogList1 = spauditlogList1;
    }

    @XmlTransient
    public List<Spreport> getSpreportList() {
        return spreportList;
    }

    public void setSpreportList(List<Spreport> spreportList) {
        this.spreportList = spreportList;
    }

    @XmlTransient
    public List<Spreport> getSpreportList1() {
        return spreportList1;
    }

    public void setSpreportList1(List<Spreport> spreportList1) {
        this.spreportList1 = spreportList1;
    }

    @XmlTransient
    public List<Deaccession> getDeaccessionList() {
        return deaccessionList;
    }

    public void setDeaccessionList(List<Deaccession> deaccessionList) {
        this.deaccessionList = deaccessionList;
    }

    @XmlTransient
    public List<Deaccession> getDeaccessionList1() {
        return deaccessionList1;
    }

    public void setDeaccessionList1(List<Deaccession> deaccessionList1) {
        this.deaccessionList1 = deaccessionList1;
    }

    @XmlTransient
    public List<Loanattachment> getLoanattachmentList() {
        return loanattachmentList;
    }

    public void setLoanattachmentList(List<Loanattachment> loanattachmentList) {
        this.loanattachmentList = loanattachmentList;
    }

    @XmlTransient
    public List<Loanattachment> getLoanattachmentList1() {
        return loanattachmentList1;
    }

    public void setLoanattachmentList1(List<Loanattachment> loanattachmentList1) {
        this.loanattachmentList1 = loanattachmentList1;
    }

    @XmlTransient
    public List<Spsymbiotainstance> getSpsymbiotainstanceList() {
        return spsymbiotainstanceList;
    }

    public void setSpsymbiotainstanceList(List<Spsymbiotainstance> spsymbiotainstanceList) {
        this.spsymbiotainstanceList = spsymbiotainstanceList;
    }

    @XmlTransient
    public List<Spsymbiotainstance> getSpsymbiotainstanceList1() {
        return spsymbiotainstanceList1;
    }

    public void setSpsymbiotainstanceList1(List<Spsymbiotainstance> spsymbiotainstanceList1) {
        this.spsymbiotainstanceList1 = spsymbiotainstanceList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agentID != null ? agentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agent)) {
            return false;
        }
        Agent other = (Agent) object;
        return !((this.agentID == null && other.agentID != null) || (this.agentID != null && !this.agentID.equals(other.agentID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Agent[ agentID=" + agentID + " ]";
    } 
}
