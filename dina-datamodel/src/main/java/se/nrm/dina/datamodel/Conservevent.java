/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.datamodel;
 
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "conservevent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conservevent.findAll", query = "SELECT c FROM Conservevent c"),
    @NamedQuery(name = "Conservevent.findByConservEventID", query = "SELECT c FROM Conservevent c WHERE c.conservEventID = :conservEventID"), 
    @NamedQuery(name = "Conservevent.findByCompletedDate", query = "SELECT c FROM Conservevent c WHERE c.completedDate = :completedDate"),
    @NamedQuery(name = "Conservevent.findByCuratorApprovalDate", query = "SELECT c FROM Conservevent c WHERE c.curatorApprovalDate = :curatorApprovalDate"), 
    @NamedQuery(name = "Conservevent.findByTreatmentCompDatePrecision", query = "SELECT c FROM Conservevent c WHERE c.treatmentCompDatePrecision = :treatmentCompDatePrecision")})
public class Conservevent extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ConservEventID")
    private Integer conservEventID;
  
    
    @Lob
    @Size(max = 65535)
    @Column(name = "AdvTestingExam")
    private String advTestingExam;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "AdvTestingExamResults")
    private String advTestingExamResults;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "CompletedComments")
    private String completedComments;
    
    @Column(name = "CompletedDate")
    @Temporal(TemporalType.DATE)
    private Date completedDate;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "ConditionReport")
    private String conditionReport;
    
    @Column(name = "CuratorApprovalDate")
    @Temporal(TemporalType.DATE)
    private Date curatorApprovalDate;
    
    @Column(name = "ExamDate")
    @Temporal(TemporalType.DATE)
    private Date examDate;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "PhotoDocs")
    private String photoDocs;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Size(max = 64)
    @Column(name = "Text1")
    private String text1;
    
    @Size(max = 64)
    @Column(name = "Text2")
    private String text2;
    
    @Column(name = "Number1")
    private Integer number1;
    
    @Column(name = "Number2")
    private Integer number2;
    
    @Column(name = "YesNo1")
    private Boolean yesNo1;
    
    @Column(name = "YesNo2")
    private Boolean yesNo2;
    
    @Column(name = "TreatmentCompDate")
    @Temporal(TemporalType.DATE)
    private Date treatmentCompDate;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "TreatmentReport")
    private String treatmentReport;
    
    @Column(name = "CompletedDatePrecision")
    private Short completedDatePrecision;
    
    @Column(name = "CuratorApprovalDatePrecision")
    private Short curatorApprovalDatePrecision;
    
    @Column(name = "ExamDatePrecision")
    private Short examDatePrecision;
    
    @Column(name = "TreatmentCompDatePrecision")
    private Short treatmentCompDatePrecision;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conservEventID", fetch = FetchType.LAZY)
    private List<Conserveventattachment> conserveventattachmentList;
    
    @JoinColumn(name = "ExaminedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent examinedByAgentID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "TreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent treatedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "CuratorID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent curatorID;
    
    @JoinColumn(name = "ConservDescriptionID", referencedColumnName = "ConservDescriptionID")
    @ManyToOne(optional = false)
    private Conservdescription conservDescriptionID;

    public Conservevent() {
    }

    public Conservevent(Integer conservEventID) {
        this.conservEventID = conservEventID;
    }

    public Conservevent(Integer conservEventID, Date timestampCreated) {
        this.conservEventID = conservEventID;
        this.timestampCreated = timestampCreated;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + conservEventID;
    }
    
    @Override
    public int getEntityId() {
        return conservEventID;
    }

    public Integer getConservEventID() {
        return conservEventID;
    }

    public void setConservEventID(Integer conservEventID) {
        this.conservEventID = conservEventID;
    }
 
    public String getAdvTestingExam() {
        return advTestingExam;
    }

    public void setAdvTestingExam(String advTestingExam) {
        this.advTestingExam = advTestingExam;
    }

    public String getAdvTestingExamResults() {
        return advTestingExamResults;
    }

    public void setAdvTestingExamResults(String advTestingExamResults) {
        this.advTestingExamResults = advTestingExamResults;
    }

    public String getCompletedComments() {
        return completedComments;
    }

    public void setCompletedComments(String completedComments) {
        this.completedComments = completedComments;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    public String getConditionReport() {
        return conditionReport;
    }

    public void setConditionReport(String conditionReport) {
        this.conditionReport = conditionReport;
    }

    public Date getCuratorApprovalDate() {
        return curatorApprovalDate;
    }

    public void setCuratorApprovalDate(Date curatorApprovalDate) {
        this.curatorApprovalDate = curatorApprovalDate;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public String getPhotoDocs() {
        return photoDocs;
    }

    public void setPhotoDocs(String photoDocs) {
        this.photoDocs = photoDocs;
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

    public Integer getNumber1() {
        return number1;
    }

    public void setNumber1(Integer number1) {
        this.number1 = number1;
    }

    public Integer getNumber2() {
        return number2;
    }

    public void setNumber2(Integer number2) {
        this.number2 = number2;
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

    public Date getTreatmentCompDate() {
        return treatmentCompDate;
    }

    public void setTreatmentCompDate(Date treatmentCompDate) {
        this.treatmentCompDate = treatmentCompDate;
    }

    public String getTreatmentReport() {
        return treatmentReport;
    }

    public void setTreatmentReport(String treatmentReport) {
        this.treatmentReport = treatmentReport;
    }

    public Short getCompletedDatePrecision() {
        return completedDatePrecision;
    }

    public void setCompletedDatePrecision(Short completedDatePrecision) {
        this.completedDatePrecision = completedDatePrecision;
    }

    public Short getCuratorApprovalDatePrecision() {
        return curatorApprovalDatePrecision;
    }

    public void setCuratorApprovalDatePrecision(Short curatorApprovalDatePrecision) {
        this.curatorApprovalDatePrecision = curatorApprovalDatePrecision;
    }

    public Short getExamDatePrecision() {
        return examDatePrecision;
    }

    public void setExamDatePrecision(Short examDatePrecision) {
        this.examDatePrecision = examDatePrecision;
    }

    public Short getTreatmentCompDatePrecision() {
        return treatmentCompDatePrecision;
    }

    public void setTreatmentCompDatePrecision(Short treatmentCompDatePrecision) {
        this.treatmentCompDatePrecision = treatmentCompDatePrecision;
    }

    @XmlTransient
    public List<Conserveventattachment> getConserveventattachmentList() {
        return conserveventattachmentList;
    }

    public void setConserveventattachmentList(List<Conserveventattachment> conserveventattachmentList) {
        this.conserveventattachmentList = conserveventattachmentList;
    }

    @XmlIDREF
    public Agent getExaminedByAgentID() {
        return examinedByAgentID;
    }

    public void setExaminedByAgentID(Agent examinedByAgentID) {
        this.examinedByAgentID = examinedByAgentID;
    }

    @XmlIDREF
    public Agent getModifiedByAgentID() {
        return modifiedByAgentID;
    }

    public void setModifiedByAgentID(Agent modifiedByAgentID) {
        this.modifiedByAgentID = modifiedByAgentID;
    }

    @XmlIDREF
    public Agent getTreatedByAgentID() {
        return treatedByAgentID;
    }

    public void setTreatedByAgentID(Agent treatedByAgentID) {
        this.treatedByAgentID = treatedByAgentID;
    }

    @XmlIDREF
    public Agent getCreatedByAgentID() {
        return createdByAgentID;
    }

    public void setCreatedByAgentID(Agent createdByAgentID) {
        this.createdByAgentID = createdByAgentID;
    }

    @XmlIDREF
    public Agent getCuratorID() {
        return curatorID;
    }

    public void setCuratorID(Agent curatorID) {
        this.curatorID = curatorID;
    }

    @XmlIDREF
    public Conservdescription getConservDescriptionID() {
        return conservDescriptionID;
    }

    public void setConservDescriptionID(Conservdescription conservDescriptionID) {
        this.conservDescriptionID = conservDescriptionID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conservEventID != null ? conservEventID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conservevent)) {
            return false;
        }
        Conservevent other = (Conservevent) object;
        return !((this.conservEventID == null && other.conservEventID != null) || (this.conservEventID != null && !this.conservEventID.equals(other.conservEventID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Conservevent[ conservEventID=" + conservEventID + " ]";
    }
    
}
