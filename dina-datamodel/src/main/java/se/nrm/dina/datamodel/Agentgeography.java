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
@Table(name = "agentgeography")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agentgeography.findAll", query = "SELECT a FROM Agentgeography a"),
    @NamedQuery(name = "Agentgeography.findByAgentGeographyID", query = "SELECT a FROM Agentgeography a WHERE a.agentGeographyID = :agentGeographyID"), 
    @NamedQuery(name = "Agentgeography.findByRole", query = "SELECT a FROM Agentgeography a WHERE a.role = :role")})
public class Agentgeography extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AgentGeographyID")
    private Integer agentGeographyID;
    
    
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Size(max = 64)
    @Column(name = "Role")
    private String role;
    
    @JoinColumn(name = "AgentID", referencedColumnName = "AgentID")
    @ManyToOne(optional = false)
    private Agent agentID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "GeographyID", referencedColumnName = "GeographyID")
    @ManyToOne(optional = false)
    private Geography geographyID;

    public Agentgeography() {
    }

    public Agentgeography(Integer agentGeographyID) {
        this.agentGeographyID = agentGeographyID;
    }

    public Agentgeography(Integer agentGeographyID, Date timestampCreated) {
        this.agentGeographyID = agentGeographyID;
        this.timestampCreated = timestampCreated;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + agentGeographyID;
    }
    
    @Override
    public int getEntityId() {
        return agentGeographyID;
    }

    public Integer getAgentGeographyID() {
        return agentGeographyID;
    }

    public void setAgentGeographyID(Integer agentGeographyID) {
        this.agentGeographyID = agentGeographyID;
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
    public Geography getGeographyID() {
        return geographyID;
    }

    public void setGeographyID(Geography geographyID) {
        this.geographyID = geographyID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agentGeographyID != null ? agentGeographyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agentgeography)) {
            return false;
        }
        Agentgeography other = (Agentgeography) object;
        return !((this.agentGeographyID == null && other.agentGeographyID != null) || (this.agentGeographyID != null && !this.agentGeographyID.equals(other.agentGeographyID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Agentgeography[ agentGeographyID=" + agentGeographyID + " ]";
    }
    
}
