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
@Table(name = "geography")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Geography.findAll", query = "SELECT g FROM Geography g"),
    @NamedQuery(name = "Geography.findByGeographyID", query = "SELECT g FROM Geography g WHERE g.geographyID = :geographyID"), 
    @NamedQuery(name = "Geography.findByAbbrev", query = "SELECT g FROM Geography g WHERE g.abbrev = :abbrev"),
    @NamedQuery(name = "Geography.findByCentroidLat", query = "SELECT g FROM Geography g WHERE g.centroidLat = :centroidLat"),
    @NamedQuery(name = "Geography.findByCentroidLon", query = "SELECT g FROM Geography g WHERE g.centroidLon = :centroidLon"),
    @NamedQuery(name = "Geography.findByCommonName", query = "SELECT g FROM Geography g WHERE g.commonName = :commonName"),
    @NamedQuery(name = "Geography.findByFullName", query = "SELECT g FROM Geography g WHERE g.fullName = :fullName"),
    @NamedQuery(name = "Geography.findByGeographyCode", query = "SELECT g FROM Geography g WHERE g.geographyCode = :geographyCode"),
    @NamedQuery(name = "Geography.findByGuid", query = "SELECT g FROM Geography g WHERE g.guid = :guid"),
    @NamedQuery(name = "Geography.findByHighestChildNodeNumber", query = "SELECT g FROM Geography g WHERE g.highestChildNodeNumber = :highestChildNodeNumber"),
    @NamedQuery(name = "Geography.findByIsAccepted", query = "SELECT g FROM Geography g WHERE g.isAccepted = :isAccepted"),
    @NamedQuery(name = "Geography.findByIsCurrent", query = "SELECT g FROM Geography g WHERE g.isCurrent = :isCurrent"),
    @NamedQuery(name = "Geography.findByName", query = "SELECT g FROM Geography g WHERE g.name = :name"), 
    @NamedQuery(name = "Geography.findByRankID", query = "SELECT g FROM Geography g WHERE g.rankID = :rankID") })
public class Geography extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GeographyID")
    private Integer geographyID;
    
    
    @Size(max = 16)
    @Column(name = "Abbrev")
    private String abbrev;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CentroidLat")
    private BigDecimal centroidLat;
    
    @Column(name = "CentroidLon")
    private BigDecimal centroidLon;
    
    @Size(max = 128)
    @Column(name = "CommonName")
    private String commonName;
    
    @Size(max = 255)
    @Column(name = "FullName")
    private String fullName;
    
    @Size(max = 24)
    @Column(name = "GeographyCode")
    private String geographyCode;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "GML")
    private String gml;
    
    @Size(max = 128)
    @Column(name = "GUID")
    private String guid;
    
    @Column(name = "HighestChildNodeNumber")
    private Integer highestChildNodeNumber;
    
    @Column(name = "IsAccepted")
    private Boolean isAccepted;
    
    @Column(name = "IsCurrent")
    private Boolean isCurrent;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "Name")
    private String name;
    
    @Column(name = "NodeNumber")
    private Integer nodeNumber;
    
    @Column(name = "Number1")
    private Integer number1;
    
    @Column(name = "Number2")
    private Integer number2;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "RankID")
    private int rankID;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Size(max = 32)
    @Column(name = "Text1")
    private String text1;
    
    @Size(max = 32)
    @Column(name = "Text2")
    private String text2;
    
    @Column(name = "TimestampVersion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestampVersion;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @OneToMany(mappedBy = "parentID", fetch = FetchType.LAZY)
    private List<Geography> geographyList;
    
    @JoinColumn(name = "ParentID", referencedColumnName = "GeographyID")
    @ManyToOne
    private Geography parentID;
    
    @JoinColumn(name = "GeographyTreeDefID", referencedColumnName = "GeographyTreeDefID")
    @ManyToOne(optional = false)
    private Geographytreedef geographyTreeDefID;
    
    @JoinColumn(name = "GeographyTreeDefItemID", referencedColumnName = "GeographyTreeDefItemID")
    @ManyToOne(optional = false)
    private Geographytreedefitem geographyTreeDefItemID;
    
    @OneToMany(mappedBy = "acceptedID", fetch = FetchType.LAZY)
    private List<Geography> geographyList1;
    
    @JoinColumn(name = "AcceptedID", referencedColumnName = "GeographyID")
    @ManyToOne
    private Geography acceptedID;
    
    @OneToMany(mappedBy = "geographyID", fetch = FetchType.LAZY)
    private List<Locality> localityList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "geographyID", fetch = FetchType.LAZY)
    private List<Agentgeography> agentgeographyList;

    public Geography() {
    }

    public Geography(Integer geographyID) {
        this.geographyID = geographyID;
    }

    public Geography(Integer geographyID, Date timestampCreated, String name, int rankID) {
        this.geographyID = geographyID;
        this.timestampCreated = timestampCreated;
        this.name = name;
        this.rankID = rankID;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + geographyID;
    }
    
    @Override
    public int getEntityId() {
        return geographyID;
    }
    
    public Integer getGeographyID() {
        return geographyID;
    }

    public void setGeographyID(Integer geographyID) {
        this.geographyID = geographyID;
    }
 

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public BigDecimal getCentroidLat() {
        return centroidLat;
    }

    public void setCentroidLat(BigDecimal centroidLat) {
        this.centroidLat = centroidLat;
    }

    public BigDecimal getCentroidLon() {
        return centroidLon;
    }

    public void setCentroidLon(BigDecimal centroidLon) {
        this.centroidLon = centroidLon;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGeographyCode() {
        return geographyCode;
    }

    public void setGeographyCode(String geographyCode) {
        this.geographyCode = geographyCode;
    }

    public String getGml() {
        return gml;
    }

    public void setGml(String gml) {
        this.gml = gml;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Integer getHighestChildNodeNumber() {
        return highestChildNodeNumber;
    }

    public void setHighestChildNodeNumber(Integer highestChildNodeNumber) {
        this.highestChildNodeNumber = highestChildNodeNumber;
    }

    public Boolean getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(Boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    public Boolean getIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(Boolean isCurrent) {
        this.isCurrent = isCurrent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNodeNumber() {
        return nodeNumber;
    }

    public void setNodeNumber(Integer nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    public Integer getNumber1() {
        return number1;
    }

    public void setNumber1(Integer number1) {
        this.number1 = number1;
    }

    public Integer getNumber2() {
        return number2;
    }

    public void setNumber2(Integer number2) {
        this.number2 = number2;
    }

    public int getRankID() {
        return rankID;
    }

    public void setRankID(int rankID) {
        this.rankID = rankID;
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

    public Date getTimestampVersion() {
        return timestampVersion;
    }

    public void setTimestampVersion(Date timestampVersion) {
        this.timestampVersion = timestampVersion;
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
    public List<Geography> getGeographyList() {
        return geographyList;
    }

    public void setGeographyList(List<Geography> geographyList) {
        this.geographyList = geographyList;
    }

    @XmlIDREF
    public Geography getParentID() {
        return parentID;
    }

    public void setParentID(Geography parentID) {
        this.parentID = parentID;
    }

    @XmlIDREF
    public Geographytreedef getGeographyTreeDefID() {
        return geographyTreeDefID;
    }

    public void setGeographyTreeDefID(Geographytreedef geographyTreeDefID) {
        this.geographyTreeDefID = geographyTreeDefID;
    }

    @XmlIDREF
    public Geographytreedefitem getGeographyTreeDefItemID() {
        return geographyTreeDefItemID;
    }

    public void setGeographyTreeDefItemID(Geographytreedefitem geographyTreeDefItemID) {
        this.geographyTreeDefItemID = geographyTreeDefItemID;
    }

    @XmlTransient
    public List<Geography> getGeographyList1() {
        return geographyList1;
    }

    public void setGeographyList1(List<Geography> geographyList1) {
        this.geographyList1 = geographyList1;
    }

    @XmlIDREF
    public Geography getAcceptedID() {
        return acceptedID;
    }

    public void setAcceptedID(Geography acceptedID) {
        this.acceptedID = acceptedID;
    }

    @XmlTransient
    public List<Locality> getLocalityList() {
        return localityList;
    }

    public void setLocalityList(List<Locality> localityList) {
        this.localityList = localityList;
    }

    @XmlTransient
    public List<Agentgeography> getAgentgeographyList() {
        return agentgeographyList;
    }

    public void setAgentgeographyList(List<Agentgeography> agentgeographyList) {
        this.agentgeographyList = agentgeographyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (geographyID != null ? geographyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Geography)) {
            return false;
        }
        Geography other = (Geography) object;
        return !((this.geographyID == null && other.geographyID != null) || (this.geographyID != null && !this.geographyID.equals(other.geographyID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Geography[ geographyID=" + geographyID + " ]";
    }
    
}
