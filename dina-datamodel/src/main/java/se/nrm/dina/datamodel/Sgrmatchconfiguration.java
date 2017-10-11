/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.datamodel;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import se.nrm.dina.datamodel.util.Util;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "sgrmatchconfiguration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sgrmatchconfiguration.findAll", query = "SELECT s FROM Sgrmatchconfiguration s"),
    @NamedQuery(name = "Sgrmatchconfiguration.findById", query = "SELECT s FROM Sgrmatchconfiguration s WHERE s.id = :id"),
    @NamedQuery(name = "Sgrmatchconfiguration.findByName", query = "SELECT s FROM Sgrmatchconfiguration s WHERE s.name = :name"),
    @NamedQuery(name = "Sgrmatchconfiguration.findByFilterQuery", query = "SELECT s FROM Sgrmatchconfiguration s WHERE s.filterQuery = :filterQuery"),
    @NamedQuery(name = "Sgrmatchconfiguration.findByBoostInterestingTerms", query = "SELECT s FROM Sgrmatchconfiguration s WHERE s.boostInterestingTerms = :boostInterestingTerms"),
    @NamedQuery(name = "Sgrmatchconfiguration.findByNRows", query = "SELECT s FROM Sgrmatchconfiguration s WHERE s.nRows = :nRows")})
public class Sgrmatchconfiguration implements EntityBean, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "similarityFields")
    private String similarityFields;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "serverUrl")
    private String serverUrl;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "filterQuery")
    private String filterQuery;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "queryFields")
    private String queryFields;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "remarks")
    private String remarks;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "boostInterestingTerms")
    private boolean boostInterestingTerms;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "nRows")
    private int nRows;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matchConfigurationId", fetch = FetchType.LAZY)
    private List<Sgrbatchmatchresultset> sgrbatchmatchresultsetList;

    public Sgrmatchconfiguration() {
    }

    public Sgrmatchconfiguration(Long id) {
        this.id = id;
    }

    public Sgrmatchconfiguration(Long id, String name, String similarityFields, String serverUrl, String filterQuery, String queryFields, String remarks, boolean boostInterestingTerms, int nRows) {
        this.id = id;
        this.name = name;
        this.similarityFields = similarityFields;
        this.serverUrl = serverUrl;
        this.filterQuery = filterQuery;
        this.queryFields = queryFields;
        this.remarks = remarks;
        this.boostInterestingTerms = boostInterestingTerms;
        this.nRows = nRows;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + id;
    }
 
    public Long getId() {
        return id;
    }
    
        
    public int getEntityId() {
        return id.intValue();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSimilarityFields() {
        return similarityFields;
    }

    public void setSimilarityFields(String similarityFields) {
        this.similarityFields = similarityFields;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getFilterQuery() {
        return filterQuery;
    }

    public void setFilterQuery(String filterQuery) {
        this.filterQuery = filterQuery;
    }

    public String getQueryFields() {
        return queryFields;
    }

    public void setQueryFields(String queryFields) {
        this.queryFields = queryFields;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean getBoostInterestingTerms() {
        return boostInterestingTerms;
    }

    public void setBoostInterestingTerms(boolean boostInterestingTerms) {
        this.boostInterestingTerms = boostInterestingTerms;
    }

    public int getNRows() {
        return nRows;
    }

    public void setNRows(int nRows) {
        this.nRows = nRows;
    }

    @XmlTransient
    public List<Sgrbatchmatchresultset> getSgrbatchmatchresultsetList() {
        return sgrbatchmatchresultsetList;
    }

    public void setSgrbatchmatchresultsetList(List<Sgrbatchmatchresultset> sgrbatchmatchresultsetList) {
        this.sgrbatchmatchresultsetList = sgrbatchmatchresultsetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sgrmatchconfiguration)) {
            return false;
        }
        Sgrmatchconfiguration other = (Sgrmatchconfiguration) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Sgrmatchconfiguration[ id=" + id + " ]";
    }
    
}
