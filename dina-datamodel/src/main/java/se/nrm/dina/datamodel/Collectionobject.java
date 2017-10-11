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
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "collectionobject")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Collectionobject.findAll", query = "SELECT c FROM Collectionobject c"),
    @NamedQuery(name = "Collectionobject.findByCollectionObjectID", query = "SELECT c FROM Collectionobject c WHERE c.collectionObjectID = :collectionObjectID"), 
    @NamedQuery(name = "Collectionobject.findByCollectionMemberID", query = "SELECT c FROM Collectionobject c WHERE c.collectionMemberID = :collectionMemberID"),
    @NamedQuery(name = "Collectionobject.findByAltCatalogNumber", query = "SELECT c FROM Collectionobject c WHERE c.altCatalogNumber = :altCatalogNumber"),
    @NamedQuery(name = "Collectionobject.findByAvailability", query = "SELECT c FROM Collectionobject c WHERE c.availability = :availability"),
    @NamedQuery(name = "Collectionobject.findByCatalogNumber", query = "SELECT c FROM Collectionobject c WHERE c.catalogNumber = :catalogNumber"),
    @NamedQuery(name = "Collectionobject.findByCatalogedDate", query = "SELECT c FROM Collectionobject c WHERE c.catalogedDate = :catalogedDate"), 
    @NamedQuery(name = "Collectionobject.findByFieldNumber", query = "SELECT c FROM Collectionobject c WHERE c.fieldNumber = :fieldNumber"),
    @NamedQuery(name = "Collectionobject.findByGuid", query = "SELECT c FROM Collectionobject c WHERE c.guid = :guid"), 
    @NamedQuery(name = "Collectionobject.findByProjectNumber", query = "SELECT c FROM Collectionobject c WHERE c.projectNumber = :projectNumber"), 
    @NamedQuery(name = "Collectionobject.findBySGRStatus", query = "SELECT c FROM Collectionobject c WHERE c.sGRStatus = :sGRStatus")}) 
//@JsonInclude(Include.NON_NULL)
public class Collectionobject extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CollectionObjectID")
    private Integer collectionObjectID;
     
    @Basic(optional = false)
    @NotNull
    @Column(name = "CollectionMemberID")
    private int collectionMemberID;
     
//    @JsonInclude(Include.NON_NULL)
    @Size(max = 32)
    @Column(name = "AltCatalogNumber")
    private String altCatalogNumber;
    
    @Size(max = 32)
    @Column(name = "Availability")
    private String availability;
    
    @Size(max = 32)
    @Column(name = "CatalogNumber")
    private String catalogNumber;
    
    @Column(name = "CatalogedDate")
    @Temporal(TemporalType.DATE)
    private Date catalogedDate;
    
    @Column(name = "CatalogedDatePrecision")
    private Short catalogedDatePrecision;
    
    @Size(max = 32)
    @Column(name = "CatalogedDateVerbatim")
    private String catalogedDateVerbatim;
    
    @Column(name = "CountAmt")
    private Integer countAmt;
    
    @Column(name = "Deaccessioned")
    private Boolean deaccessioned;
    
    @Size(max = 255)
    @Column(name = "Description")
    private String description;
    
    @Size(max = 50)
    @Column(name = "FieldNumber")
    private String fieldNumber;
    
    @Size(max = 128)
    @Column(name = "GUID")
    private String guid;
    
    @Column(name = "InventoryDate")
    @Temporal(TemporalType.DATE)
    private Date inventoryDate;
    
    @Size(max = 50)
    @Column(name = "Modifier")
    private String modifier;
    
    @Size(max = 64)
    @Column(name = "Name")
    private String name;
    
    @Size(max = 32)
    @Column(name = "Notifications")
    private String notifications;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Number1")
    private Float number1;
    
    @Column(name = "Number2")
    private Float number2;
    
    @Size(max = 64)
    @Column(name = "ObjectCondition")
    private String objectCondition;
    
    @Size(max = 64)
    @Column(name = "ProjectNumber")
    private String projectNumber;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Size(max = 32)
    @Column(name = "Restrictions")
    private String restrictions;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text1")
    private String text1;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text2")
    private String text2;
    
    @Column(name = "TotalValue")
    private BigDecimal totalValue;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "OCR")
    private String ocr;
    
    @Column(name = "Visibility")
    private Short visibility;
    
    @Column(name = "YesNo1")
    private Boolean yesNo1;
    
    @Column(name = "YesNo2")
    private Boolean yesNo2;
    
    @Column(name = "YesNo3")
    private Boolean yesNo3;
    
    @Column(name = "YesNo4")
    private Boolean yesNo4;
    
    @Column(name = "YesNo5")
    private Boolean yesNo5;
    
    @Column(name = "YesNo6")
    private Boolean yesNo6;
    
    @Column(name = "SGRStatus")
    private Short sGRStatus;
    
    @Size(max = 128)
    @Column(name = "ReservedText")
    private String reservedText;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text3")
    private String text3;
    
    @Column(name = "Integer1")
    private Integer integer1;
    
    @Column(name = "Integer2")
    private Integer integer2;
    
    @Column(name = "ReservedInteger3")
    private Integer reservedInteger3;
    
    @Column(name = "ReservedInteger4")
    private Integer reservedInteger4;
    
    @Size(max = 128)
    @Column(name = "ReservedText2")
    private String reservedText2;
    
    @Size(max = 128)
    @Column(name = "ReservedText3")
    private String reservedText3;
    
    @JoinTable(name = "project_colobj", joinColumns = {
        @JoinColumn(name = "CollectionObjectID", referencedColumnName = "CollectionObjectID")}, inverseJoinColumns = {
        @JoinColumn(name = "ProjectID", referencedColumnName = "ProjectID")})
    @ManyToMany(fetch = FetchType.LAZY)
    private transient List<Project> projectList;
    
    @OneToMany( cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH}, orphanRemoval=true, mappedBy = "collectionObjectID", fetch = FetchType.EAGER)
    private List<Determination> determinationList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "collectionObjectID", fetch = FetchType.LAZY)
    private List<Exsiccataitem> exsiccataitemList;
    
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval=true, mappedBy = "collectionObjectID", fetch = FetchType.EAGER )
    private List<Preparation> preparationList;
    
    @OneToMany(mappedBy = "collectionObjectID", fetch = FetchType.LAZY)
    private List<Conservdescription> conservdescriptionList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "collectionObjectID", fetch = FetchType.LAZY)
    private List<Collectionobjectattachment> collectionobjectattachmentList;
    
    @OneToMany(mappedBy = "collectionObjectID", fetch = FetchType.LAZY)
    private List<Treatmentevent> treatmenteventList;
    
    @JoinColumn(name = "VisibilitySetByID", referencedColumnName = "SpecifyUserID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Specifyuser visibilitySetByID;
    
    @JoinColumn(name = "AccessionID", referencedColumnName = "AccessionID")
    @ManyToOne 
    private Accession accessionID;
    
    @JoinColumn(name = "CatalogerID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent catalogerID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "FieldNotebookPageID", referencedColumnName = "FieldNotebookPageID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Fieldnotebookpage fieldNotebookPageID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "CollectionID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne(optional = false)
    private Collection collectionID;
    
    @JoinColumn(name = "PaleoContextID", referencedColumnName = "PaleoContextID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Paleocontext paleoContextID;
    
    @JoinColumn(name = "CollectingEventID", referencedColumnName = "CollectingEventID")
    @ManyToOne
    private Collectingevent collectingEventID;
    
    @JoinColumn(name = "CollectionObjectAttributeID", referencedColumnName = "CollectionObjectAttributeID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Collectionobjectattribute collectionObjectAttributeID;
    
    @JoinColumn(name = "ContainerOwnerID", referencedColumnName = "ContainerID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Container containerOwnerID;
    
    @JoinColumn(name = "ContainerID", referencedColumnName = "ContainerID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Container containerID;
    
    @JoinColumn(name = "AppraisalID", referencedColumnName = "AppraisalID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Appraisal appraisalID;
    
    @OneToMany(mappedBy = "collectionObjectID", fetch = FetchType.LAZY)
    private List<Dnasequence> dnasequenceList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leftSideCollectionID", fetch = FetchType.LAZY)
    private List<Collectionrelationship> collectionrelationshipList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rightSideCollectionID", fetch = FetchType.LAZY)
    private List<Collectionrelationship> collectionrelationshipList1;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "collectionObjectID", fetch = FetchType.LAZY)
    private List<Collectionobjectcitation> collectionobjectcitationList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "collectionObjectID", fetch = FetchType.LAZY)
    private List<Otheridentifier> otheridentifierList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "collectionObjectID", fetch = FetchType.LAZY)
    private List<Collectionobjectattr> collectionobjectattrList;

    public Collectionobject() {
    }

    public Collectionobject(Integer collectionObjectID) {
        this.collectionObjectID = collectionObjectID;
    }

    public Collectionobject(Integer collectionObjectID, Date timestampCreated, int collectionMemberID) {
        this.collectionObjectID = collectionObjectID;
        this.timestampCreated = timestampCreated;
        this.collectionMemberID = collectionMemberID;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + collectionObjectID;
    }
    
    @XmlTransient
    @Override
    public int getEntityId() {
        return collectionObjectID == null ? 0 : collectionObjectID;
    }

    public Integer getCollectionObjectID() {
        return collectionObjectID;
    }

    public void setCollectionObjectID(Integer collectionObjectID) {
        this.collectionObjectID = collectionObjectID;
    }
 
    public int getCollectionMemberID() {
        return collectionMemberID;
    }

    public void setCollectionMemberID(int collectionMemberID) {
        this.collectionMemberID = collectionMemberID;
    }

//    @JsonInclude(Include.NON_NULL)
    public String getAltCatalogNumber() {
        return altCatalogNumber;
    }

    public void setAltCatalogNumber(String altCatalogNumber) {
        this.altCatalogNumber = altCatalogNumber;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(String catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    public Date getCatalogedDate() {
        return catalogedDate;
    }

    public void setCatalogedDate(Date catalogedDate) {
        this.catalogedDate = catalogedDate;
    }

    public Short getCatalogedDatePrecision() {
        return catalogedDatePrecision;
    }

    public void setCatalogedDatePrecision(Short catalogedDatePrecision) {
        this.catalogedDatePrecision = catalogedDatePrecision;
    }

    public String getCatalogedDateVerbatim() {
        return catalogedDateVerbatim;
    }

    public void setCatalogedDateVerbatim(String catalogedDateVerbatim) {
        this.catalogedDateVerbatim = catalogedDateVerbatim;
    }

    public Integer getCountAmt() {
        return countAmt;
    }

    public void setCountAmt(Integer countAmt) {
        this.countAmt = countAmt;
    }

    public Boolean getDeaccessioned() {
        return deaccessioned;
    }

    public void setDeaccessioned(Boolean deaccessioned) {
        this.deaccessioned = deaccessioned;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFieldNumber() {
        return fieldNumber;
    }

    public void setFieldNumber(String fieldNumber) {
        this.fieldNumber = fieldNumber;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Date getInventoryDate() {
        return inventoryDate;
    }

    public void setInventoryDate(Date inventoryDate) {
        this.inventoryDate = inventoryDate;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotifications() {
        return notifications;
    }

    public void setNotifications(String notifications) {
        this.notifications = notifications;
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

    public String getObjectCondition() {
        return objectCondition;
    }

    public void setObjectCondition(String objectCondition) {
        this.objectCondition = objectCondition;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
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

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public String getOcr() {
        return ocr;
    }

    public void setOcr(String ocr) {
        this.ocr = ocr;
    }

    public Short getVisibility() {
        return visibility;
    }

    public void setVisibility(Short visibility) {
        this.visibility = visibility;
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

    public Boolean getYesNo3() {
        return yesNo3;
    }

    public void setYesNo3(Boolean yesNo3) {
        this.yesNo3 = yesNo3;
    }

    public Boolean getYesNo4() {
        return yesNo4;
    }

    public void setYesNo4(Boolean yesNo4) {
        this.yesNo4 = yesNo4;
    }

    public Boolean getYesNo5() {
        return yesNo5;
    }

    public void setYesNo5(Boolean yesNo5) {
        this.yesNo5 = yesNo5;
    }

    public Boolean getYesNo6() {
        return yesNo6;
    }

    public void setYesNo6(Boolean yesNo6) {
        this.yesNo6 = yesNo6;
    }

    public Short getSGRStatus() {
        return sGRStatus;
    }

    public void setSGRStatus(Short sGRStatus) {
        this.sGRStatus = sGRStatus;
    }

    public String getReservedText() {
        return reservedText;
    }

    public void setReservedText(String reservedText) {
        this.reservedText = reservedText;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public Integer getInteger1() {
        return integer1;
    }

    public void setInteger1(Integer integer1) {
        this.integer1 = integer1;
    }

    public Integer getInteger2() {
        return integer2;
    }

    public void setInteger2(Integer integer2) {
        this.integer2 = integer2;
    }

    public Integer getReservedInteger3() {
        return reservedInteger3;
    }

    public void setReservedInteger3(Integer reservedInteger3) {
        this.reservedInteger3 = reservedInteger3;
    }

    public Integer getReservedInteger4() {
        return reservedInteger4;
    }

    public void setReservedInteger4(Integer reservedInteger4) {
        this.reservedInteger4 = reservedInteger4;
    }

    public String getReservedText2() {
        return reservedText2;
    }

    public void setReservedText2(String reservedText2) {
        this.reservedText2 = reservedText2;
    }

    public String getReservedText3() {
        return reservedText3;
    }

    public void setReservedText3(String reservedText3) {
        this.reservedText3 = reservedText3;
    }

    @XmlTransient
    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    @XmlIDREF
    @XmlElementWrapper(name="determinations")
    @XmlElement(name="determination") 
    public List<Determination> getDeterminationList() {
        return determinationList;
    }

    public void setDeterminationList(List<Determination> determinationList) {
        this.determinationList = determinationList;
    }

    @XmlTransient
    public List<Exsiccataitem> getExsiccataitemList() {
        return exsiccataitemList;
    }

    public void setExsiccataitemList(List<Exsiccataitem> exsiccataitemList) {
        this.exsiccataitemList = exsiccataitemList;
    }

    @XmlIDREF
    @XmlElementWrapper(name="preparations")
    @XmlElement(name="preparation") 
    public List<Preparation> getPreparationList() {
        return preparationList;
    }

    public void setPreparationList(List<Preparation> preparationList) {
        this.preparationList = preparationList;
    }

    @XmlTransient
    public List<Conservdescription> getConservdescriptionList() {
        return conservdescriptionList;
    }

    public void setConservdescriptionList(List<Conservdescription> conservdescriptionList) {
        this.conservdescriptionList = conservdescriptionList;
    }

    @XmlTransient
    public List<Collectionobjectattachment> getCollectionobjectattachmentList() {
        return collectionobjectattachmentList;
    }

    public void setCollectionobjectattachmentList(List<Collectionobjectattachment> collectionobjectattachmentList) {
        this.collectionobjectattachmentList = collectionobjectattachmentList;
    }

    @XmlTransient
    public List<Treatmentevent> getTreatmenteventList() {
        return treatmenteventList;
    }

    public void setTreatmenteventList(List<Treatmentevent> treatmenteventList) {
        this.treatmenteventList = treatmenteventList;
    }

    @XmlTransient
    public Specifyuser getVisibilitySetByID() {
        return visibilitySetByID;
    }

    public void setVisibilitySetByID(Specifyuser visibilitySetByID) {
        this.visibilitySetByID = visibilitySetByID;
    }

    @XmlIDREF
    public Accession getAccessionID() {
        return accessionID;
    }

    public void setAccessionID(Accession accessionID) {
        this.accessionID = accessionID;
    }

    @XmlIDREF
    public Agent getCatalogerID() {
        return catalogerID;
    }

    public void setCatalogerID(Agent catalogerID) {
        this.catalogerID = catalogerID;
    }

    @XmlIDREF
    public Agent getModifiedByAgentID() {
        return modifiedByAgentID;
    }

    public void setModifiedByAgentID(Agent modifiedByAgentID) {
        this.modifiedByAgentID = modifiedByAgentID;
    }

    @XmlTransient
    public Fieldnotebookpage getFieldNotebookPageID() {
        return fieldNotebookPageID;
    }

    public void setFieldNotebookPageID(Fieldnotebookpage fieldNotebookPageID) {
        this.fieldNotebookPageID = fieldNotebookPageID;
    }

    @XmlIDREF
    public Agent getCreatedByAgentID() {
        return createdByAgentID;
    }

    public void setCreatedByAgentID(Agent createdByAgentID) {
        this.createdByAgentID = createdByAgentID;
    }

    @XmlIDREF
    public Collection getCollectionID() {
        return collectionID;
    }

    public void setCollectionID(Collection collectionID) {
        this.collectionID = collectionID;
    }

    @XmlTransient
    public Paleocontext getPaleoContextID() {
        return paleoContextID;
    }

    public void setPaleoContextID(Paleocontext paleoContextID) {
        this.paleoContextID = paleoContextID;
    }

    @XmlIDREF
    public Collectingevent getCollectingEventID() {
        return collectingEventID;
    }

    public void setCollectingEventID(Collectingevent collectingEventID) {
        this.collectingEventID = collectingEventID;
    }

    @XmlTransient
    public Collectionobjectattribute getCollectionObjectAttributeID() {
        return collectionObjectAttributeID;
    }

    public void setCollectionObjectAttributeID(Collectionobjectattribute collectionObjectAttributeID) {
        this.collectionObjectAttributeID = collectionObjectAttributeID;
    }

    @XmlTransient
    public Container getContainerOwnerID() {
        return containerOwnerID;
    }

    public void setContainerOwnerID(Container containerOwnerID) {
        this.containerOwnerID = containerOwnerID;
    }

    @XmlTransient
    public Container getContainerID() {
        return containerID;
    }

    public void setContainerID(Container containerID) {
        this.containerID = containerID;
    }

    @XmlTransient
    public Appraisal getAppraisalID() {
        return appraisalID;
    }

    public void setAppraisalID(Appraisal appraisalID) {
        this.appraisalID = appraisalID;
    }

    @XmlTransient
    public List<Dnasequence> getDnasequenceList() {
        return dnasequenceList;
    }

    public void setDnasequenceList(List<Dnasequence> dnasequenceList) {
        this.dnasequenceList = dnasequenceList;
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
    public List<Collectionobjectcitation> getCollectionobjectcitationList() {
        return collectionobjectcitationList;
    }

    public void setCollectionobjectcitationList(List<Collectionobjectcitation> collectionobjectcitationList) {
        this.collectionobjectcitationList = collectionobjectcitationList;
    }

    @XmlTransient
    public List<Otheridentifier> getOtheridentifierList() {
        return otheridentifierList;
    }

    public void setOtheridentifierList(List<Otheridentifier> otheridentifierList) {
        this.otheridentifierList = otheridentifierList;
    }

    @XmlTransient
    public List<Collectionobjectattr> getCollectionobjectattrList() {
        return collectionobjectattrList;
    }

    public void setCollectionobjectattrList(List<Collectionobjectattr> collectionobjectattrList) {
        this.collectionobjectattrList = collectionobjectattrList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (collectionObjectID != null ? collectionObjectID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Collectionobject)) {
            return false;
        }
        Collectionobject other = (Collectionobject) object;
        return !((this.collectionObjectID == null && other.collectionObjectID != null) || (this.collectionObjectID != null && !this.collectionObjectID.equals(other.collectionObjectID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Collectionobject[ collectionObjectID=" + collectionObjectID + " ]";
    }
    
}
