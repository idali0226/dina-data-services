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
import javax.persistence.Temporal;
import javax.persistence.TemporalType; 
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
@Table(name = "treatmentevent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Treatmentevent.findAll", query = "SELECT t FROM Treatmentevent t"),
    @NamedQuery(name = "Treatmentevent.findByTreatmentEventID", query = "SELECT t FROM Treatmentevent t WHERE t.treatmentEventID = :treatmentEventID"), 
    @NamedQuery(name = "Treatmentevent.findByDateBoxed", query = "SELECT t FROM Treatmentevent t WHERE t.dateBoxed = :dateBoxed"),
    @NamedQuery(name = "Treatmentevent.findByDateCleaned", query = "SELECT t FROM Treatmentevent t WHERE t.dateCleaned = :dateCleaned"),
    @NamedQuery(name = "Treatmentevent.findByDateCompleted", query = "SELECT t FROM Treatmentevent t WHERE t.dateCompleted = :dateCompleted"),
    @NamedQuery(name = "Treatmentevent.findByDateReceived", query = "SELECT t FROM Treatmentevent t WHERE t.dateReceived = :dateReceived"),
    @NamedQuery(name = "Treatmentevent.findByDateToIsolation", query = "SELECT t FROM Treatmentevent t WHERE t.dateToIsolation = :dateToIsolation"),
    @NamedQuery(name = "Treatmentevent.findByDateTreatmentEnded", query = "SELECT t FROM Treatmentevent t WHERE t.dateTreatmentEnded = :dateTreatmentEnded"),
    @NamedQuery(name = "Treatmentevent.findByDateTreatmentStarted", query = "SELECT t FROM Treatmentevent t WHERE t.dateTreatmentStarted = :dateTreatmentStarted"),
    @NamedQuery(name = "Treatmentevent.findByFieldNumber", query = "SELECT t FROM Treatmentevent t WHERE t.fieldNumber = :fieldNumber"),
    @NamedQuery(name = "Treatmentevent.findByStorage", query = "SELECT t FROM Treatmentevent t WHERE t.storage = :storage"),
    @NamedQuery(name = "Treatmentevent.findByTreatmentNumber", query = "SELECT t FROM Treatmentevent t WHERE t.treatmentNumber = :treatmentNumber"),
    @NamedQuery(name = "Treatmentevent.findByType", query = "SELECT t FROM Treatmentevent t WHERE t.type = :type")})
public class Treatmentevent extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TreatmentEventID")
    private Integer treatmentEventID;
    
    
    @Column(name = "DateBoxed")
    @Temporal(TemporalType.DATE)
    private Date dateBoxed;
    
    @Column(name = "DateCleaned")
    @Temporal(TemporalType.DATE)
    private Date dateCleaned;
    
    @Column(name = "DateCompleted")
    @Temporal(TemporalType.DATE)
    private Date dateCompleted;
    
    @Column(name = "DateReceived")
    @Temporal(TemporalType.DATE)
    private Date dateReceived;
    
    @Column(name = "DateToIsolation")
    @Temporal(TemporalType.DATE)
    private Date dateToIsolation;
    
    @Column(name = "DateTreatmentEnded")
    @Temporal(TemporalType.DATE)
    private Date dateTreatmentEnded;
    
    @Column(name = "DateTreatmentStarted")
    @Temporal(TemporalType.DATE)
    private Date dateTreatmentStarted;
    
    @Size(max = 50)
    @Column(name = "FieldNumber")
    private String fieldNumber;
    
    @Size(max = 64)
    @Column(name = "Storage")
    private String storage;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Size(max = 32)
    @Column(name = "TreatmentNumber")
    private String treatmentNumber;
    
    @Size(max = 32)
    @Column(name = "Type")
    private String type;
    
    @JoinColumn(name = "AccessionID", referencedColumnName = "AccessionID")
    @ManyToOne
    private Accession accessionID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CollectionObjectID", referencedColumnName = "CollectionObjectID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Collectionobject collectionObjectID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "DivisionID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne
    private Division divisionID;

    public Treatmentevent() {
    }

    public Treatmentevent(Integer treatmentEventID) {
        this.treatmentEventID = treatmentEventID;
    }

    public Treatmentevent(Integer treatmentEventID, Date timestampCreated) {
        this.treatmentEventID = treatmentEventID;
        this.timestampCreated = timestampCreated;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + treatmentEventID;
    }
    
    @Override
    public int getEntityId() {
        return treatmentEventID;
    }

    public Integer getTreatmentEventID() {
        return treatmentEventID;
    }

    public void setTreatmentEventID(Integer treatmentEventID) {
        this.treatmentEventID = treatmentEventID;
    }
 
    public Date getDateBoxed() {
        return dateBoxed;
    }

    public void setDateBoxed(Date dateBoxed) {
        this.dateBoxed = dateBoxed;
    }

    public Date getDateCleaned() {
        return dateCleaned;
    }

    public void setDateCleaned(Date dateCleaned) {
        this.dateCleaned = dateCleaned;
    }

    public Date getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(Date dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public Date getDateToIsolation() {
        return dateToIsolation;
    }

    public void setDateToIsolation(Date dateToIsolation) {
        this.dateToIsolation = dateToIsolation;
    }

    public Date getDateTreatmentEnded() {
        return dateTreatmentEnded;
    }

    public void setDateTreatmentEnded(Date dateTreatmentEnded) {
        this.dateTreatmentEnded = dateTreatmentEnded;
    }

    public Date getDateTreatmentStarted() {
        return dateTreatmentStarted;
    }

    public void setDateTreatmentStarted(Date dateTreatmentStarted) {
        this.dateTreatmentStarted = dateTreatmentStarted;
    }

    public String getFieldNumber() {
        return fieldNumber;
    }

    public void setFieldNumber(String fieldNumber) {
        this.fieldNumber = fieldNumber;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTreatmentNumber() {
        return treatmentNumber;
    }

    public void setTreatmentNumber(String treatmentNumber) {
        this.treatmentNumber = treatmentNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlIDREF
    public Accession getAccessionID() {
        return accessionID;
    }

    public void setAccessionID(Accession accessionID) {
        this.accessionID = accessionID;
    }

    @XmlIDREF
    public Agent getModifiedByAgentID() {
        return modifiedByAgentID;
    }

    public void setModifiedByAgentID(Agent modifiedByAgentID) {
        this.modifiedByAgentID = modifiedByAgentID;
    }

    @XmlTransient
    public Collectionobject getCollectionObjectID() {
        return collectionObjectID;
    }

    public void setCollectionObjectID(Collectionobject collectionObjectID) {
        this.collectionObjectID = collectionObjectID;
    }

    @XmlIDREF
    public Agent getCreatedByAgentID() {
        return createdByAgentID;
    }

    public void setCreatedByAgentID(Agent createdByAgentID) {
        this.createdByAgentID = createdByAgentID;
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
        hash += (treatmentEventID != null ? treatmentEventID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Treatmentevent)) {
            return false;
        }
        Treatmentevent other = (Treatmentevent) object;
        return !((this.treatmentEventID == null && other.treatmentEventID != null) || (this.treatmentEventID != null && !this.treatmentEventID.equals(other.treatmentEventID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Treatmentevent[ treatmentEventID=" + treatmentEventID + " ]";
    }
    
}
