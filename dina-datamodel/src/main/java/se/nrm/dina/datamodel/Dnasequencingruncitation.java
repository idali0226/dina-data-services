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
@Table(name = "dnasequencingruncitation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dnasequencingruncitation.findAll", query = "SELECT d FROM Dnasequencingruncitation d"),
    @NamedQuery(name = "Dnasequencingruncitation.findByDNASequencingRunCitationID", query = "SELECT d FROM Dnasequencingruncitation d WHERE d.dNASequencingRunCitationID = :dNASequencingRunCitationID") })
public class Dnasequencingruncitation extends  BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DNASequencingRunCitationID")
    private Integer dNASequencingRunCitationID;
    
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Number1")
    private Float number1;
    
    @Column(name = "Number2")
    private Float number2;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text1")
    private String text1;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text2")
    private String text2;
    
    @Column(name = "YesNo1")
    private Boolean yesNo1;
    
    @Column(name = "YesNo2")
    private Boolean yesNo2;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "ReferenceWorkID", referencedColumnName = "ReferenceWorkID")
    @ManyToOne(optional = false)
    private Referencework referenceWorkID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "DNASequencingRunID", referencedColumnName = "DNASequencingRunID")
    @ManyToOne(optional = false)
    private Dnasequencingrun dNASequencingRunID;

    public Dnasequencingruncitation() {
    }

    public Dnasequencingruncitation(Integer dNASequencingRunCitationID) {
        this.dNASequencingRunCitationID = dNASequencingRunCitationID;
    }

    public Dnasequencingruncitation(Integer dNASequencingRunCitationID, Date timestampCreated) {
        this.dNASequencingRunCitationID = dNASequencingRunCitationID;
        this.timestampCreated = timestampCreated;
    }

    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + dNASequencingRunCitationID;
    }
    
    @Override
    public int getEntityId() {
        return dNASequencingRunCitationID;
    }

    public Integer getDNASequencingRunCitationID() {
        return dNASequencingRunCitationID;
    }

    public void setDNASequencingRunCitationID(Integer dNASequencingRunCitationID) {
        this.dNASequencingRunCitationID = dNASequencingRunCitationID;
    }
 

    public Float getNumber1() {
        return number1;
    }

    public void setNumber1(Float number1) {
        this.number1 = number1;
    }

    public Float getNumber2() {
        return number2;
    }

    public void setNumber2(Float number2) {
        this.number2 = number2;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public Boolean getYesNo1() {
        return yesNo1;
    }

    public void setYesNo1(Boolean yesNo1) {
        this.yesNo1 = yesNo1;
    }

    public Boolean getYesNo2() {
        return yesNo2;
    }

    public void setYesNo2(Boolean yesNo2) {
        this.yesNo2 = yesNo2;
    }

    @XmlIDREF
    public Agent getModifiedByAgentID() {
        return modifiedByAgentID;
    }

    public void setModifiedByAgentID(Agent modifiedByAgentID) {
        this.modifiedByAgentID = modifiedByAgentID;
    }

    @XmlIDREF
    public Referencework getReferenceWorkID() {
        return referenceWorkID;
    }

    public void setReferenceWorkID(Referencework referenceWorkID) {
        this.referenceWorkID = referenceWorkID;
    }

    @XmlIDREF
    public Agent getCreatedByAgentID() {
        return createdByAgentID;
    }

    public void setCreatedByAgentID(Agent createdByAgentID) {
        this.createdByAgentID = createdByAgentID;
    }

    @XmlIDREF
    public Dnasequencingrun getDNASequencingRunID() {
        return dNASequencingRunID;
    }

    public void setDNASequencingRunID(Dnasequencingrun dNASequencingRunID) {
        this.dNASequencingRunID = dNASequencingRunID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dNASequencingRunCitationID != null ? dNASequencingRunCitationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dnasequencingruncitation)) {
            return false;
        }
        Dnasequencingruncitation other = (Dnasequencingruncitation) object;
        return !((this.dNASequencingRunCitationID == null && other.dNASequencingRunCitationID != null) || (this.dNASequencingRunCitationID != null && !this.dNASequencingRunCitationID.equals(other.dNASequencingRunCitationID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Dnasequencingruncitation[ dNASequencingRunCitationID=" + dNASequencingRunCitationID + " ]";
    }
    
}
