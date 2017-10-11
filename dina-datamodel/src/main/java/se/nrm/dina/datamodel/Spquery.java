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
@Table(name = "spquery")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spquery.findAll", query = "SELECT s FROM Spquery s"),
    @NamedQuery(name = "Spquery.findBySpQueryID", query = "SELECT s FROM Spquery s WHERE s.spQueryID = :spQueryID"), 
    @NamedQuery(name = "Spquery.findByContextName", query = "SELECT s FROM Spquery s WHERE s.contextName = :contextName"),
    @NamedQuery(name = "Spquery.findByContextTableId", query = "SELECT s FROM Spquery s WHERE s.contextTableId = :contextTableId"),
    @NamedQuery(name = "Spquery.findByCountOnly", query = "SELECT s FROM Spquery s WHERE s.countOnly = :countOnly"),
    @NamedQuery(name = "Spquery.findByIsFavorite", query = "SELECT s FROM Spquery s WHERE s.isFavorite = :isFavorite"),
    @NamedQuery(name = "Spquery.findByName", query = "SELECT s FROM Spquery s WHERE s.name = :name"),
    @NamedQuery(name = "Spquery.findByOrdinal", query = "SELECT s FROM Spquery s WHERE s.ordinal = :ordinal"),
    @NamedQuery(name = "Spquery.findBySearchSynonymy", query = "SELECT s FROM Spquery s WHERE s.searchSynonymy = :searchSynonymy"),
    @NamedQuery(name = "Spquery.findBySelectDistinct", query = "SELECT s FROM Spquery s WHERE s.selectDistinct = :selectDistinct"),
    @NamedQuery(name = "Spquery.findBySmushed", query = "SELECT s FROM Spquery s WHERE s.smushed = :smushed")})
public class Spquery extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SpQueryID")
    private Integer spQueryID;
    
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "ContextName")
    private String contextName;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ContextTableId")
    private short contextTableId;
    
    @Column(name = "CountOnly")
    private Boolean countOnly;
    
    @Column(name = "IsFavorite")
    private Boolean isFavorite;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "Name")
    private String name;
    
    @Column(name = "Ordinal")
    private Short ordinal;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Column(name = "SearchSynonymy")
    private Boolean searchSynonymy;
    
    @Column(name = "SelectDistinct")
    private Boolean selectDistinct;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "SqlStr")
    private String sqlStr;
    
    @Column(name = "Smushed")
    private Boolean smushed;
    
    @JoinColumn(name = "SpecifyUserID", referencedColumnName = "SpecifyUserID")
    @ManyToOne(optional = false)
    private Specifyuser specifyUserID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @OneToMany(mappedBy = "spQueryID",fetch = FetchType.LAZY)
    private List<Spqueryfield> spqueryfieldList;
    
    @OneToMany(mappedBy = "spQueryID", fetch = FetchType.LAZY)
    private List<Spreport> spreportList;

    public Spquery() {
    }

    public Spquery(Integer spQueryID) {
        this.spQueryID = spQueryID;
    }

    public Spquery(Integer spQueryID, Date timestampCreated, String contextName, short contextTableId, String name) {
        this.spQueryID = spQueryID;
        this.timestampCreated = timestampCreated;
        this.contextName = contextName;
        this.contextTableId = contextTableId;
        this.name = name;
    }

    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + spQueryID;
    }
    
    @Override
    public int getEntityId() {
        return spQueryID;
    }
    
    public Integer getSpQueryID() {
        return spQueryID;
    }

    public void setSpQueryID(Integer spQueryID) {
        this.spQueryID = spQueryID;
    }
 
    public String getContextName() {
        return contextName;
    }

    public void setContextName(String contextName) {
        this.contextName = contextName;
    }

    public short getContextTableId() {
        return contextTableId;
    }

    public void setContextTableId(short contextTableId) {
        this.contextTableId = contextTableId;
    }

    public Boolean getCountOnly() {
        return countOnly;
    }

    public void setCountOnly(Boolean countOnly) {
        this.countOnly = countOnly;
    }

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Short ordinal) {
        this.ordinal = ordinal;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Boolean getSearchSynonymy() {
        return searchSynonymy;
    }

    public void setSearchSynonymy(Boolean searchSynonymy) {
        this.searchSynonymy = searchSynonymy;
    }

    public Boolean getSelectDistinct() {
        return selectDistinct;
    }

    public void setSelectDistinct(Boolean selectDistinct) {
        this.selectDistinct = selectDistinct;
    }

    public String getSqlStr() {
        return sqlStr;
    }

    public void setSqlStr(String sqlStr) {
        this.sqlStr = sqlStr;
    }

    public Boolean getSmushed() {
        return smushed;
    }

    public void setSmushed(Boolean smushed) {
        this.smushed = smushed;
    }

    @XmlIDREF
    public Specifyuser getSpecifyUserID() {
        return specifyUserID;
    }

    public void setSpecifyUserID(Specifyuser specifyUserID) {
        this.specifyUserID = specifyUserID;
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
    public List<Spqueryfield> getSpqueryfieldList() {
        return spqueryfieldList;
    }

    public void setSpqueryfieldList(List<Spqueryfield> spqueryfieldList) {
        this.spqueryfieldList = spqueryfieldList;
    }

    @XmlTransient
    public List<Spreport> getSpreportList() {
        return spreportList;
    }

    public void setSpreportList(List<Spreport> spreportList) {
        this.spreportList = spreportList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (spQueryID != null ? spQueryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spquery)) {
            return false;
        }
        Spquery other = (Spquery) object;
        return !((this.spQueryID == null && other.spQueryID != null) || (this.spQueryID != null && !this.spQueryID.equals(other.spQueryID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Spquery[ spQueryID=" + spQueryID + " ]";
    }
    
}
