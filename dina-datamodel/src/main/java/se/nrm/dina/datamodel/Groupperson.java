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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "groupperson")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groupperson.findAll", query = "SELECT g FROM Groupperson g"),
    @NamedQuery(name = "Groupperson.findByGroupPersonID", query = "SELECT g FROM Groupperson g WHERE g.groupPersonID = :groupPersonID"), 
    @NamedQuery(name = "Groupperson.findByOrderNumber", query = "SELECT g FROM Groupperson g WHERE g.orderNumber = :orderNumber")})
public class Groupperson extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GroupPersonID")
    private Integer groupPersonID;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderNumber")
    private short orderNumber;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @JoinColumn(name = "MemberID", referencedColumnName = "AgentID")
    @ManyToOne(optional = false)
    private Agent memberID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "GroupID", referencedColumnName = "AgentID")
    @ManyToOne(optional = false)
    private Agent groupID;
    
    @JoinColumn(name = "DivisionID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne
    private Division divisionID;

    public Groupperson() {
    }

    public Groupperson(Integer groupPersonID) {
        this.groupPersonID = groupPersonID;
    }

    public Groupperson(Integer groupPersonID, Date timestampCreated, short orderNumber) {
        this.groupPersonID = groupPersonID;
        this.timestampCreated = timestampCreated;
        this.orderNumber = orderNumber;
    }

    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + groupPersonID;
    }
    
    @Override
    public int getEntityId() {
        return groupPersonID;
    }
    
    public Integer getGroupPersonID() {
        return groupPersonID;
    }

    public void setGroupPersonID(Integer groupPersonID) {
        this.groupPersonID = groupPersonID;
    }
 
    public short getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(short orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @XmlIDREF
    public Agent getMemberID() {
        return memberID;
    }

    public void setMemberID(Agent memberID) {
        this.memberID = memberID;
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

    @XmlIDREF
    public Agent getGroupID() {
        return groupID;
    }

    public void setGroupID(Agent groupID) {
        this.groupID = groupID;
    }

    @XmlIDREF
    public Division getDivisionID() {
        return divisionID;
    }

    public void setDivisionID(Division divisionID) {
        this.divisionID = divisionID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupPersonID != null ? groupPersonID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupperson)) {
            return false;
        }
        Groupperson other = (Groupperson) object;
        return !((this.groupPersonID == null && other.groupPersonID != null) || (this.groupPersonID != null && !this.groupPersonID.equals(other.groupPersonID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Groupperson[ groupPersonID=" + groupPersonID + " ]";
    }
    
}
