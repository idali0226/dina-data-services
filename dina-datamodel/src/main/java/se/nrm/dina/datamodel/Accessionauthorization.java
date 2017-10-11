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
@Table(name = "accessionauthorization")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accessionauthorization.findAll", query = "SELECT a FROM Accessionauthorization a"),
    @NamedQuery(name = "Accessionauthorization.findByAccessionAuthorizationID", query = "SELECT a FROM Accessionauthorization a WHERE a.accessionAuthorizationID = :accessionAuthorizationID")})
public class Accessionauthorization extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AccessionAuthorizationID")
    private Integer accessionAuthorizationID;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
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
    
    @JoinColumn(name = "PermitID", referencedColumnName = "PermitID")
    @ManyToOne(optional = false)
    private Permit permitID;

    public Accessionauthorization() {
    }

    public Accessionauthorization(Integer accessionAuthorizationID) {
        this.accessionAuthorizationID = accessionAuthorizationID;
    }

    public Accessionauthorization(Integer accessionAuthorizationID, Date timestampCreated) {
        this.accessionAuthorizationID = accessionAuthorizationID;
        this.timestampCreated = timestampCreated;
    }

    @XmlID 
    @XmlAttribute(name = "id") 
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + accessionAuthorizationID;
    }
    
    @Override
    public int getEntityId() {
        return accessionAuthorizationID;
    }

    
    public Integer getAccessionAuthorizationID() {
        return accessionAuthorizationID;
    }

    public void setAccessionAuthorizationID(Integer accessionAuthorizationID) {
        this.accessionAuthorizationID = accessionAuthorizationID;
    }

   
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    @XmlIDREF
    public Permit getPermitID() {
        return permitID;
    }

    public void setPermitID(Permit permitID) {
        this.permitID = permitID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessionAuthorizationID != null ? accessionAuthorizationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accessionauthorization)) {
            return false;
        }
        Accessionauthorization other = (Accessionauthorization) object;
        return !((this.accessionAuthorizationID == null && other.accessionAuthorizationID != null) || (this.accessionAuthorizationID != null && !this.accessionAuthorizationID.equals(other.accessionAuthorizationID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Accessionauthorization[ accessionAuthorizationID=" + accessionAuthorizationID + " ]";
    }

    
}
