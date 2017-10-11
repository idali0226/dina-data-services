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
@Table(name = "giftagent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Giftagent.findAll", query = "SELECT g FROM Giftagent g"),
    @NamedQuery(name = "Giftagent.findByGiftAgentID", query = "SELECT g FROM Giftagent g WHERE g.giftAgentID = :giftAgentID"), 
    @NamedQuery(name = "Giftagent.findByRole", query = "SELECT g FROM Giftagent g WHERE g.role = :role")})
public class Giftagent extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GiftAgentID")
    private Integer giftAgentID;
    
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Role")
    private String role;
    
    @JoinColumn(name = "AgentID", referencedColumnName = "AgentID")
    @ManyToOne(optional = false)
    private Agent agentID;
    
    @JoinColumn(name = "DisciplineID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne
    private Discipline disciplineID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "GiftID", referencedColumnName = "GiftID")
    @ManyToOne(optional = false)
    private Gift giftID;

    public Giftagent() {
    }

    public Giftagent(Integer giftAgentID) {
        this.giftAgentID = giftAgentID;
    }

    public Giftagent(Integer giftAgentID, Date timestampCreated, String role) {
        this.giftAgentID = giftAgentID;
        this.timestampCreated = timestampCreated;
        this.role = role;
    }

    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + giftAgentID;
    }
    
    @Override
    public int getEntityId() {
        return giftAgentID;
    }
    
    public Integer getGiftAgentID() {
        return giftAgentID;
    }

    public void setGiftAgentID(Integer giftAgentID) {
        this.giftAgentID = giftAgentID;
    }

  

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @XmlIDREF
    public Agent getAgentID() {
        return agentID;
    }

    public void setAgentID(Agent agentID) {
        this.agentID = agentID;
    }

    @XmlIDREF
    public Discipline getDisciplineID() {
        return disciplineID;
    }

    public void setDisciplineID(Discipline disciplineID) {
        this.disciplineID = disciplineID;
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
    public Gift getGiftID() {
        return giftID;
    }

    public void setGiftID(Gift giftID) {
        this.giftID = giftID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (giftAgentID != null ? giftAgentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Giftagent)) {
            return false;
        }
        Giftagent other = (Giftagent) object;
        return !((this.giftAgentID == null && other.giftAgentID != null) || (this.giftAgentID != null && !this.giftAgentID.equals(other.giftAgentID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Giftagent[ giftAgentID=" + giftAgentID + " ]";
    }
    
}
