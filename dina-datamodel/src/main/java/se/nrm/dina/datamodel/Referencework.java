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
@Table(name = "referencework")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Referencework.findAll", query = "SELECT r FROM Referencework r"),
    @NamedQuery(name = "Referencework.findByReferenceWorkID", query = "SELECT r FROM Referencework r WHERE r.referenceWorkID = :referenceWorkID"),  
    @NamedQuery(name = "Referencework.findByIsPublished", query = "SELECT r FROM Referencework r WHERE r.isPublished = :isPublished"),
    @NamedQuery(name = "Referencework.findByIsbn", query = "SELECT r FROM Referencework r WHERE r.isbn = :isbn"),
    @NamedQuery(name = "Referencework.findByLibraryNumber", query = "SELECT r FROM Referencework r WHERE r.libraryNumber = :libraryNumber"), 
    @NamedQuery(name = "Referencework.findByPlaceOfPublication", query = "SELECT r FROM Referencework r WHERE r.placeOfPublication = :placeOfPublication"),
    @NamedQuery(name = "Referencework.findByPublisher", query = "SELECT r FROM Referencework r WHERE r.publisher = :publisher"),
    @NamedQuery(name = "Referencework.findByReferenceWorkType", query = "SELECT r FROM Referencework r WHERE r.referenceWorkType = :referenceWorkType"),
    @NamedQuery(name = "Referencework.findByTitle", query = "SELECT r FROM Referencework r WHERE r.title = :title"),
    @NamedQuery(name = "Referencework.findByVolume", query = "SELECT r FROM Referencework r WHERE r.volume = :volume") })
public class Referencework extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ReferenceWorkID")
    private Integer referenceWorkID;
    
    
    @Size(max = 128)
    @Column(name = "GUID")
    private String guid;
    
    @Column(name = "IsPublished")
    private Boolean isPublished;
    
    @Size(max = 16)
    @Column(name = "ISBN")
    private String isbn;
    
    @Size(max = 50)
    @Column(name = "LibraryNumber")
    private String libraryNumber;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Number1")
    private Float number1;
    
    @Column(name = "Number2")
    private Float number2;
    
    @Size(max = 50)
    @Column(name = "Pages")
    private String pages;
    
    @Size(max = 50)
    @Column(name = "PlaceOfPublication")
    private String placeOfPublication;
    
    @Size(max = 250)
    @Column(name = "Publisher")
    private String publisher;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ReferenceWorkType")
    private short referenceWorkType;
    
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
    
    @Size(max = 255)
    @Column(name = "Title")
    private String title;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "URL")
    private String url;
    
    @Size(max = 25)
    @Column(name = "Volume")
    private String volume;
    
    @Size(max = 25)
    @Column(name = "WorkDate")
    private String workDate;
    
    @Column(name = "YesNo1")
    private Boolean yesNo1;
    
    @Column(name = "YesNo2")
    private Boolean yesNo2;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "referenceWorkID", fetch = FetchType.LAZY)
    private List<Localitycitation> localitycitationList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "referenceWorkID", fetch = FetchType.LAZY)
    private List<Exsiccata> exsiccataList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "referenceWorkID", fetch = FetchType.LAZY)
    private List<Determinationcitation> determinationcitationList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "referenceWorkID", fetch = FetchType.LAZY)
    private List<Commonnametxcitation> commonnametxcitationList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "referenceWorkID", fetch = FetchType.LAZY)
    private List<Taxoncitation> taxoncitationList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "referenceWorkID", fetch = FetchType.LAZY)
    private List<Dnasequencingruncitation> dnasequencingruncitationList;
    
    @OneToMany(mappedBy = "containedRFParentID", fetch = FetchType.LAZY)
    private List<Referencework> referenceworkList;
    
    @JoinColumn(name = "ContainedRFParentID", referencedColumnName = "ReferenceWorkID")
    @ManyToOne
    private Referencework containedRFParentID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "JournalID", referencedColumnName = "JournalID")
    @ManyToOne
    private Journal journalID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "InstitutionID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne(optional = false)
    private Institution institutionID;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "referenceWorkID", fetch = FetchType.LAZY)
    private List<Author> authorList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "referenceWorkID", fetch = FetchType.LAZY)
    private List<Collectionobjectcitation> collectionobjectcitationList;

    public Referencework() {
    }

    public Referencework(Integer referenceWorkID) {
        this.referenceWorkID = referenceWorkID;
    }

    public Referencework(Integer referenceWorkID, Date timestampCreated, short referenceWorkType) {
        this.referenceWorkID = referenceWorkID;
        this.timestampCreated = timestampCreated;
        this.referenceWorkType = referenceWorkType;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + referenceWorkID;
    }
    
    @Override
    public int getEntityId() {
        return referenceWorkID;
    }

    public Integer getReferenceWorkID() {
        return referenceWorkID;
    }

    public void setReferenceWorkID(Integer referenceWorkID) {
        this.referenceWorkID = referenceWorkID;
    }
 

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Boolean getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(Boolean isPublished) {
        this.isPublished = isPublished;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public void setLibraryNumber(String libraryNumber) {
        this.libraryNumber = libraryNumber;
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

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPlaceOfPublication() {
        return placeOfPublication;
    }

    public void setPlaceOfPublication(String placeOfPublication) {
        this.placeOfPublication = placeOfPublication;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public short getReferenceWorkType() {
        return referenceWorkType;
    }

    public void setReferenceWorkType(short referenceWorkType) {
        this.referenceWorkType = referenceWorkType;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
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
    public List<Localitycitation> getLocalitycitationList() {
        return localitycitationList;
    }

    public void setLocalitycitationList(List<Localitycitation> localitycitationList) {
        this.localitycitationList = localitycitationList;
    }

    @XmlTransient
    public List<Exsiccata> getExsiccataList() {
        return exsiccataList;
    }

    public void setExsiccataList(List<Exsiccata> exsiccataList) {
        this.exsiccataList = exsiccataList;
    }

    @XmlTransient
    public List<Determinationcitation> getDeterminationcitationList() {
        return determinationcitationList;
    }

    public void setDeterminationcitationList(List<Determinationcitation> determinationcitationList) {
        this.determinationcitationList = determinationcitationList;
    }

    @XmlTransient
    public List<Commonnametxcitation> getCommonnametxcitationList() {
        return commonnametxcitationList;
    }

    public void setCommonnametxcitationList(List<Commonnametxcitation> commonnametxcitationList) {
        this.commonnametxcitationList = commonnametxcitationList;
    }

    @XmlTransient
    public List<Taxoncitation> getTaxoncitationList() {
        return taxoncitationList;
    }

    public void setTaxoncitationList(List<Taxoncitation> taxoncitationList) {
        this.taxoncitationList = taxoncitationList;
    }

    @XmlTransient
    public List<Dnasequencingruncitation> getDnasequencingruncitationList() {
        return dnasequencingruncitationList;
    }

    public void setDnasequencingruncitationList(List<Dnasequencingruncitation> dnasequencingruncitationList) {
        this.dnasequencingruncitationList = dnasequencingruncitationList;
    }

    @XmlTransient
    public List<Referencework> getReferenceworkList() {
        return referenceworkList;
    }

    public void setReferenceworkList(List<Referencework> referenceworkList) {
        this.referenceworkList = referenceworkList;
    }

    @XmlIDREF
    public Referencework getContainedRFParentID() {
        return containedRFParentID;
    }

    public void setContainedRFParentID(Referencework containedRFParentID) {
        this.containedRFParentID = containedRFParentID;
    }

    @XmlIDREF
    public Agent getModifiedByAgentID() {
        return modifiedByAgentID;
    }

    public void setModifiedByAgentID(Agent modifiedByAgentID) {
        this.modifiedByAgentID = modifiedByAgentID;
    }

    @XmlIDREF
    public Journal getJournalID() {
        return journalID;
    }

    public void setJournalID(Journal journalID) {
        this.journalID = journalID;
    }

    @XmlIDREF
    public Agent getCreatedByAgentID() {
        return createdByAgentID;
    }

    public void setCreatedByAgentID(Agent createdByAgentID) {
        this.createdByAgentID = createdByAgentID;
    }

    @XmlIDREF
    public Institution getInstitutionID() {
        return institutionID;
    }

    public void setInstitutionID(Institution institutionID) {
        this.institutionID = institutionID;
    }

    @XmlTransient
    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    @XmlTransient
    public List<Collectionobjectcitation> getCollectionobjectcitationList() {
        return collectionobjectcitationList;
    }

    public void setCollectionobjectcitationList(List<Collectionobjectcitation> collectionobjectcitationList) {
        this.collectionobjectcitationList = collectionobjectcitationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (referenceWorkID != null ? referenceWorkID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Referencework)) {
            return false;
        }
        Referencework other = (Referencework) object;
        return !((this.referenceWorkID == null && other.referenceWorkID != null) || (this.referenceWorkID != null && !this.referenceWorkID.equals(other.referenceWorkID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Referencework[ referenceWorkID=" + referenceWorkID + " ]";
    }
    
}
