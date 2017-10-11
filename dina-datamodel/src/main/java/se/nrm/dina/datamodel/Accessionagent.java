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
import javax.persistence.FetchType;
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
import javax.xml.bind.annotation.XmlTransient;
import se.nrm.dina.datamodel.util.Util;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "accessionagent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accessionagent.findAll", query = "SELECT a FROM Accessionagent a"),
    @NamedQuery(name = "Accessionagent.findByAccessionAgentID", query = "SELECT a FROM Accessionagent a WHERE a.accessionAgentID = :accessionAgentID"),  
    @NamedQuery(name = "Accessionagent.findByRole", query = "SELECT a FROM Accessionagent a WHERE a.role = :role")})
public class Accessionagent extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AccessionAgentID")
    private Integer accessionAgentID;
     
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
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Agent agentID;
    
    @JoinColumn(name = "AccessionID", referencedColumnName = "AccessionID")
    @ManyToOne
    private Accession accessionID;
    
    @JoinColumn(name = "RepositoryAgreementID", referencedColumnName = "RepositoryAgreementID")
    @ManyToOne
    private Repositoryagreement repositoryAgreementID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;

    public Accessionagent() {
    }

    public Accessionagent(Integer accessionAgentID) {
        this.accessionAgentID = accessionAgentID;
    }

    public Accessionagent(Integer accessionAgentID, Date timestampCreated, String role) {
        this.accessionAgentID = accessionAgentID;
        this.timestampCreated = timestampCreated;
        this.role = role;
    }

    @XmlID
    @XmlAttribute(name = "id") 
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + accessionAgentID;
    }

    @XmlTransient
    @Override
    public int getEntityId() {
        return accessionAgentID;
    }

    public Integer getAccessionAgentID() {
        return accessionAgentID;
    }

    public void setAccessionAgentID(Integer accessionAgentID) {
        this.accessionAgentID = accessionAgentID;
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

    @XmlTransient
    public Agent getAgentID() {
        return agentID;
    }

    public void setAgentID(Agent agentID) {
        this.agentID = agentID;
    }

    @XmlIDREF
    public Accession getAccessionID() {
        return accessionID;
    }

    public void setAccessionID(Accession accessionID) {
        this.accessionID = accessionID;
    }

    @XmlIDREF
    public Repositoryagreement getRepositoryAgreementID() {
        return repositoryAgreementID;
    }

    public void setRepositoryAgreementID(Repositoryagreement repositoryAgreementID) {
        this.repositoryAgreementID = repositoryAgreementID;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessionAgentID != null ? accessionAgentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accessionagent)) {
            return false;
        }
        Accessionagent other = (Accessionagent) object;
        return (this.accessionAgentID != null || other.accessionAgentID == null) && (this.accessionAgentID == null || this.accessionAgentID.equals(other.accessionAgentID));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Accessionagent[ accessionAgentID=" + accessionAgentID + " ]";
    }
 
}
