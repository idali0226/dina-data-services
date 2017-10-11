/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.datamodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import se.nrm.dina.datamodel.util.Util;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "sgrbatchmatchresultitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sgrbatchmatchresultitem.findAll", query = "SELECT s FROM Sgrbatchmatchresultitem s"),
    @NamedQuery(name = "Sgrbatchmatchresultitem.findById", query = "SELECT s FROM Sgrbatchmatchresultitem s WHERE s.id = :id"),
    @NamedQuery(name = "Sgrbatchmatchresultitem.findByMatchedId", query = "SELECT s FROM Sgrbatchmatchresultitem s WHERE s.matchedId = :matchedId"),
    @NamedQuery(name = "Sgrbatchmatchresultitem.findByMaxScore", query = "SELECT s FROM Sgrbatchmatchresultitem s WHERE s.maxScore = :maxScore"),
    @NamedQuery(name = "Sgrbatchmatchresultitem.findByQTime", query = "SELECT s FROM Sgrbatchmatchresultitem s WHERE s.qTime = :qTime")})
public class Sgrbatchmatchresultitem implements EntityBean, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "matchedId")
    private String matchedId;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "maxScore")
    private float maxScore;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "qTime")
    private int qTime;
    
    @JoinColumn(name = "batchMatchResultSetId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Sgrbatchmatchresultset batchMatchResultSetId;

    public Sgrbatchmatchresultitem() {
    }

    public Sgrbatchmatchresultitem(Long id) {
        this.id = id;
    }

    public Sgrbatchmatchresultitem(Long id, String matchedId, float maxScore, int qTime) {
        this.id = id;
        this.matchedId = matchedId;
        this.maxScore = maxScore;
        this.qTime = qTime;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + id;
    }
    
    @Override
    public int getEntityId() {
        return  id.intValue();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatchedId() {
        return matchedId;
    }

    public void setMatchedId(String matchedId) {
        this.matchedId = matchedId;
    }

    public float getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(float maxScore) {
        this.maxScore = maxScore;
    }

    public int getQTime() {
        return qTime;
    }

    public void setQTime(int qTime) {
        this.qTime = qTime;
    }

    @XmlIDREF
    public Sgrbatchmatchresultset getBatchMatchResultSetId() {
        return batchMatchResultSetId;
    }

    public void setBatchMatchResultSetId(Sgrbatchmatchresultset batchMatchResultSetId) {
        this.batchMatchResultSetId = batchMatchResultSetId;
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
        if (!(object instanceof Sgrbatchmatchresultitem)) {
            return false;
        }
        Sgrbatchmatchresultitem other = (Sgrbatchmatchresultitem) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Sgrbatchmatchresultitem[ id=" + id + " ]";
    }
    
}
