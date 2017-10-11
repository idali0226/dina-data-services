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
@Table(name = "deaccessionpreparation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deaccessionpreparation.findAll", query = "SELECT d FROM Deaccessionpreparation d"),
    @NamedQuery(name = "Deaccessionpreparation.findByDeaccessionPreparationID", query = "SELECT d FROM Deaccessionpreparation d WHERE d.deaccessionPreparationID = :deaccessionPreparationID"), 
    @NamedQuery(name = "Deaccessionpreparation.findByQuantity", query = "SELECT d FROM Deaccessionpreparation d WHERE d.quantity = :quantity")})
public class Deaccessionpreparation extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DeaccessionPreparationID")
    private Integer deaccessionPreparationID;
    
    
    @Column(name = "Quantity")
    private Short quantity;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @OneToMany(mappedBy = "deaccessionPreparationID", fetch = FetchType.LAZY)
    private List<Loanreturnpreparation> loanreturnpreparationList;
    
    @JoinColumn(name = "PreparationID", referencedColumnName = "PreparationID")
    @ManyToOne
    private Preparation preparationID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "DeaccessionID", referencedColumnName = "DeaccessionID")
    @ManyToOne(optional = false)
    private Deaccession deaccessionID;

    public Deaccessionpreparation() {
    }

    public Deaccessionpreparation(Integer deaccessionPreparationID) {
        this.deaccessionPreparationID = deaccessionPreparationID;
    }

    public Deaccessionpreparation(Integer deaccessionPreparationID, Date timestampCreated) {
        this.deaccessionPreparationID = deaccessionPreparationID;
        this.timestampCreated = timestampCreated;
    }

      
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + deaccessionPreparationID;
    }
    
    @Override
    public int getEntityId() {
        return deaccessionPreparationID;
    }
    
    public Integer getDeaccessionPreparationID() {
        return deaccessionPreparationID;
    }

    public void setDeaccessionPreparationID(Integer deaccessionPreparationID) {
        this.deaccessionPreparationID = deaccessionPreparationID;
    }
 
    public Short getQuantity() {
        return quantity;
    }

    public void setQuantity(Short quantity) {
        this.quantity = quantity;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @XmlTransient
    public List<Loanreturnpreparation> getLoanreturnpreparationList() {
        return loanreturnpreparationList;
    }

    public void setLoanreturnpreparationList(List<Loanreturnpreparation> loanreturnpreparationList) {
        this.loanreturnpreparationList = loanreturnpreparationList;
    }

    @XmlIDREF
    public Preparation getPreparationID() {
        return preparationID;
    }

    public void setPreparationID(Preparation preparationID) {
        this.preparationID = preparationID;
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
    public Deaccession getDeaccessionID() {
        return deaccessionID;
    }

    public void setDeaccessionID(Deaccession deaccessionID) {
        this.deaccessionID = deaccessionID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deaccessionPreparationID != null ? deaccessionPreparationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deaccessionpreparation)) {
            return false;
        }
        Deaccessionpreparation other = (Deaccessionpreparation) object;
        return !((this.deaccessionPreparationID == null && other.deaccessionPreparationID != null) || (this.deaccessionPreparationID != null && !this.deaccessionPreparationID.equals(other.deaccessionPreparationID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Deaccessionpreparation[ deaccessionPreparationID=" + deaccessionPreparationID + " ]";
    }
    
}
