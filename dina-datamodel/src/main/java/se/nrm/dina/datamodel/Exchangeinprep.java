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
@Table(name = "exchangeinprep")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exchangeinprep.findAll", query = "SELECT e FROM Exchangeinprep e"),
    @NamedQuery(name = "Exchangeinprep.findByExchangeInPrepID", query = "SELECT e FROM Exchangeinprep e WHERE e.exchangeInPrepID = :exchangeInPrepID"), 
    @NamedQuery(name = "Exchangeinprep.findByDescriptionOfMaterial", query = "SELECT e FROM Exchangeinprep e WHERE e.descriptionOfMaterial = :descriptionOfMaterial"),
    @NamedQuery(name = "Exchangeinprep.findByNumber1", query = "SELECT e FROM Exchangeinprep e WHERE e.number1 = :number1"),
    @NamedQuery(name = "Exchangeinprep.findByQuantity", query = "SELECT e FROM Exchangeinprep e WHERE e.quantity = :quantity"),
    @NamedQuery(name = "Exchangeinprep.findByPreparationID", query = "SELECT e FROM Exchangeinprep e WHERE e.preparationID = :preparationID"),
    @NamedQuery(name = "Exchangeinprep.findByModifiedByAgentID", query = "SELECT e FROM Exchangeinprep e WHERE e.modifiedByAgentID = :modifiedByAgentID"),
    @NamedQuery(name = "Exchangeinprep.findByDisciplineID", query = "SELECT e FROM Exchangeinprep e WHERE e.disciplineID = :disciplineID"),
    @NamedQuery(name = "Exchangeinprep.findByExchangeInID", query = "SELECT e FROM Exchangeinprep e WHERE e.exchangeInID = :exchangeInID"),
    @NamedQuery(name = "Exchangeinprep.findByCreatedByAgentID", query = "SELECT e FROM Exchangeinprep e WHERE e.createdByAgentID = :createdByAgentID")})
public class Exchangeinprep extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ExchangeInPrepID")
    private Integer exchangeInPrepID;
  
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Comments")
    private String comments;
    
    @Size(max = 255)
    @Column(name = "DescriptionOfMaterial")
    private String descriptionOfMaterial;
    
    @Column(name = "Number1")
    private Integer number1;
    
    @Column(name = "Quantity")
    private Integer quantity;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text1")
    private String text1;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text2")
    private String text2;
    
    @Column(name = "PreparationID")
    private Integer preparationID;
    
    @Column(name = "ModifiedByAgentID")
    private Integer modifiedByAgentID;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DisciplineID")
    private int disciplineID;
    
    @Column(name = "ExchangeInID")
    private Integer exchangeInID;
    
    @Column(name = "CreatedByAgentID")
    private Integer createdByAgentID;

    public Exchangeinprep() {
    }

    public Exchangeinprep(Integer exchangeInPrepID) {
        this.exchangeInPrepID = exchangeInPrepID;
    }

    public Exchangeinprep(Integer exchangeInPrepID, Date timestampCreated, int disciplineID) {
        this.exchangeInPrepID = exchangeInPrepID;
        this.timestampCreated = timestampCreated;
        this.disciplineID = disciplineID;
    }

    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + exchangeInPrepID;
    }
    
    @Override
    public int getEntityId() {
        return exchangeInPrepID;
    }
    
    public Integer getExchangeInPrepID() {
        return exchangeInPrepID;
    }

    

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDescriptionOfMaterial() {
        return descriptionOfMaterial;
    }

    public void setDescriptionOfMaterial(String descriptionOfMaterial) {
        this.descriptionOfMaterial = descriptionOfMaterial;
    }

    public Integer getNumber1() {
        return number1;
    }

    public void setNumber1(Integer number1) {
        this.number1 = number1;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public Integer getPreparationID() {
        return preparationID;
    }

    public void setPreparationID(Integer preparationID) {
        this.preparationID = preparationID;
    }

    public Integer getModifiedByAgentID() {
        return modifiedByAgentID;
    }

    public void setModifiedByAgentID(Integer modifiedByAgentID) {
        this.modifiedByAgentID = modifiedByAgentID;
    }

    public int getDisciplineID() {
        return disciplineID;
    }

    public void setDisciplineID(int disciplineID) {
        this.disciplineID = disciplineID;
    }

    public Integer getExchangeInID() {
        return exchangeInID;
    }

    public void setExchangeInID(Integer exchangeInID) {
        this.exchangeInID = exchangeInID;
    }

    public Integer getCreatedByAgentID() {
        return createdByAgentID;
    }

    public void setCreatedByAgentID(Integer createdByAgentID) {
        this.createdByAgentID = createdByAgentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (exchangeInPrepID != null ? exchangeInPrepID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exchangeinprep)) {
            return false;
        }
        Exchangeinprep other = (Exchangeinprep) object;
        return !((this.exchangeInPrepID == null && other.exchangeInPrepID != null) || (this.exchangeInPrepID != null && !this.exchangeInPrepID.equals(other.exchangeInPrepID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Exchangeinprep[ exchangeInPrepID=" + exchangeInPrepID + " ]";
    }
    
}
