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
@Table(name = "loanagent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loanagent.findAll", query = "SELECT l FROM Loanagent l"),
    @NamedQuery(name = "Loanagent.findByLoanAgentID", query = "SELECT l FROM Loanagent l WHERE l.loanAgentID = :loanAgentID"), 
    @NamedQuery(name = "Loanagent.findByRole", query = "SELECT l FROM Loanagent l WHERE l.role = :role")})
public class Loanagent extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LoanAgentID")
    private Integer loanAgentID;
    
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
    
    @JoinColumn(name = "LoanID", referencedColumnName = "LoanID")
    @ManyToOne(optional = false)
    private Loan loanID;

    public Loanagent() {
    }

    public Loanagent(Integer loanAgentID) {
        this.loanAgentID = loanAgentID;
    }

    public Loanagent(Integer loanAgentID, Date timestampCreated, String role) {
        this.loanAgentID = loanAgentID;
        this.timestampCreated = timestampCreated;
        this.role = role;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + loanAgentID;
    }
    
    @Override
    public int getEntityId() {
        return loanAgentID;
    }

    public Integer getLoanAgentID() {
        return loanAgentID;
    }

    public void setLoanAgentID(Integer loanAgentID) {
        this.loanAgentID = loanAgentID;
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
    public Loan getLoanID() {
        return loanID;
    }

    public void setLoanID(Loan loanID) {
        this.loanID = loanID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loanAgentID != null ? loanAgentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loanagent)) {
            return false;
        }
        Loanagent other = (Loanagent) object;
        return !((this.loanAgentID == null && other.loanAgentID != null) || (this.loanAgentID != null && !this.loanAgentID.equals(other.loanAgentID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Loanagent[ loanAgentID=" + loanAgentID + " ]";
    }
    
}
