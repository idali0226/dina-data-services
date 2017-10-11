/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.datamodel;
 
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table; 
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import se.nrm.dina.datamodel.util.Util;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "fundingagent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fundingagent.findAll", query = "SELECT f FROM Fundingagent f"),
    @NamedQuery(name = "Fundingagent.findByFundingAgentID", query = "SELECT f FROM Fundingagent f WHERE f.fundingAgentID = :fundingAgentID"), 
    @NamedQuery(name = "Fundingagent.findByIsPrimary", query = "SELECT f FROM Fundingagent f WHERE f.isPrimary = :isPrimary"),
    @NamedQuery(name = "Fundingagent.findByOrderNumber", query = "SELECT f FROM Fundingagent f WHERE f.orderNumber = :orderNumber"),
    @NamedQuery(name = "Fundingagent.findByType", query = "SELECT f FROM Fundingagent f WHERE f.type = :type"),
    @NamedQuery(name = "Fundingagent.findByDivisionID", query = "SELECT f FROM Fundingagent f WHERE f.divisionID = :divisionID"), 
    @NamedQuery(name = "Fundingagent.findByCollectingTripID", query = "SELECT f FROM Fundingagent f WHERE f.collectingTripID = :collectingTripID"),
    @NamedQuery(name = "Fundingagent.findByAgentID", query = "SELECT f FROM Fundingagent f WHERE f.agentID = :agentID")})
public class Fundingagent extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FundingAgentID")
    private Integer fundingAgentID;

    
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsPrimary")
    private boolean isPrimary;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderNumber")
    private int orderNumber;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Size(max = 32)
    @Column(name = "Type")
    private String type;
    
    @Column(name = "DivisionID")
    private Integer divisionID;
    
    @Column(name = "CreatedByAgentID")
    private Integer createdByAgentID;
    
    @Column(name = "ModifiedByAgentID")
    private Integer modifiedByAgentID;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CollectingTripID")
    private int collectingTripID;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "AgentID")
    private int agentID;

    public Fundingagent() {
    }

    public Fundingagent(Integer fundingAgentID) {
        this.fundingAgentID = fundingAgentID;
    }

    public Fundingagent(Integer fundingAgentID, Date timestampCreated, boolean isPrimary, int orderNumber, int collectingTripID, int agentID) {
        this.fundingAgentID = fundingAgentID;
        this.timestampCreated = timestampCreated;
        this.isPrimary = isPrimary;
        this.orderNumber = orderNumber;
        this.collectingTripID = collectingTripID;
        this.agentID = agentID;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + fundingAgentID;
    }

    @Override
    public int getEntityId() {
        return fundingAgentID;
    }
    
    public Integer getFundingAgentID() {
        return fundingAgentID;
    }

    public void setFundingAgentID(Integer fundingAgentID) {
        this.fundingAgentID = fundingAgentID;
    }

  
    public boolean getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDivisionID() {
        return divisionID;
    }

    public void setDivisionID(Integer divisionID) {
        this.divisionID = divisionID;
    }

    public Integer getCreatedByAgentID() {
        return createdByAgentID;
    }

    public void setCreatedByAgentID(Integer createdByAgentID) {
        this.createdByAgentID = createdByAgentID;
    }

    public Integer getModifiedByAgentID() {
        return modifiedByAgentID;
    }

    public void setModifiedByAgentID(Integer modifiedByAgentID) {
        this.modifiedByAgentID = modifiedByAgentID;
    }

    public int getCollectingTripID() {
        return collectingTripID;
    }

    public void setCollectingTripID(int collectingTripID) {
        this.collectingTripID = collectingTripID;
    }

    public int getAgentID() {
        return agentID;
    }

    public void setAgentID(int agentID) {
        this.agentID = agentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fundingAgentID != null ? fundingAgentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fundingagent)) {
            return false;
        }
        Fundingagent other = (Fundingagent) object;
        return !((this.fundingAgentID == null && other.fundingAgentID != null) || (this.fundingAgentID != null && !this.fundingAgentID.equals(other.fundingAgentID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Fundingagent[ fundingAgentID=" + fundingAgentID + " ]";
    }
    
}
