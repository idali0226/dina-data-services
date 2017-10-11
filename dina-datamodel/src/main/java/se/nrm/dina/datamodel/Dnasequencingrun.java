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
@Table(name = "dnasequencingrun")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dnasequencingrun.findAll", query = "SELECT d FROM Dnasequencingrun d"),
    @NamedQuery(name = "Dnasequencingrun.findByDNASequencingRunID", query = "SELECT d FROM Dnasequencingrun d WHERE d.dNASequencingRunID = :dNASequencingRunID"), 
    @NamedQuery(name = "Dnasequencingrun.findByCollectionMemberID", query = "SELECT d FROM Dnasequencingrun d WHERE d.collectionMemberID = :collectionMemberID"), 
    @NamedQuery(name = "Dnasequencingrun.findByPCRCocktailPrimer", query = "SELECT d FROM Dnasequencingrun d WHERE d.pCRCocktailPrimer = :pCRCocktailPrimer"),
    @NamedQuery(name = "Dnasequencingrun.findByPCRForwardPrimerCode", query = "SELECT d FROM Dnasequencingrun d WHERE d.pCRForwardPrimerCode = :pCRForwardPrimerCode"),
    @NamedQuery(name = "Dnasequencingrun.findByPCRPrimerName", query = "SELECT d FROM Dnasequencingrun d WHERE d.pCRPrimerName = :pCRPrimerName"),
    @NamedQuery(name = "Dnasequencingrun.findByPCRPrimerSequence53", query = "SELECT d FROM Dnasequencingrun d WHERE d.pCRPrimerSequence53 = :pCRPrimerSequence53"),
    @NamedQuery(name = "Dnasequencingrun.findByPCRReversePrimerCode", query = "SELECT d FROM Dnasequencingrun d WHERE d.pCRReversePrimerCode = :pCRReversePrimerCode"),
    @NamedQuery(name = "Dnasequencingrun.findByReadDirection", query = "SELECT d FROM Dnasequencingrun d WHERE d.readDirection = :readDirection"),
    @NamedQuery(name = "Dnasequencingrun.findByRunDate", query = "SELECT d FROM Dnasequencingrun d WHERE d.runDate = :runDate"),
    @NamedQuery(name = "Dnasequencingrun.findByScoreFileName", query = "SELECT d FROM Dnasequencingrun d WHERE d.scoreFileName = :scoreFileName"),
    @NamedQuery(name = "Dnasequencingrun.findBySequenceCocktailPrimer", query = "SELECT d FROM Dnasequencingrun d WHERE d.sequenceCocktailPrimer = :sequenceCocktailPrimer"),
    @NamedQuery(name = "Dnasequencingrun.findBySequencePrimerCode", query = "SELECT d FROM Dnasequencingrun d WHERE d.sequencePrimerCode = :sequencePrimerCode"),
    @NamedQuery(name = "Dnasequencingrun.findBySequencePrimerName", query = "SELECT d FROM Dnasequencingrun d WHERE d.sequencePrimerName = :sequencePrimerName"),
    @NamedQuery(name = "Dnasequencingrun.findBySequencePrimerSequence53", query = "SELECT d FROM Dnasequencingrun d WHERE d.sequencePrimerSequence53 = :sequencePrimerSequence53"),
    @NamedQuery(name = "Dnasequencingrun.findByTraceFileName", query = "SELECT d FROM Dnasequencingrun d WHERE d.traceFileName = :traceFileName") })
public class Dnasequencingrun extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DNASequencingRunID")
    private Integer dNASequencingRunID;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CollectionMemberID")
    private int collectionMemberID;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Number1")
    private Float number1;
    
    @Column(name = "Number2")
    private Float number2;
    
    @Column(name = "Number3")
    private Float number3;
    
    @Column(name = "Ordinal")
    private Integer ordinal;
    
    @Column(name = "PCRCocktailPrimer")
    private Boolean pCRCocktailPrimer;
    
    @Size(max = 32)
    @Column(name = "PCRForwardPrimerCode")
    private String pCRForwardPrimerCode;
    
    @Size(max = 32)
    @Column(name = "PCRPrimerName")
    private String pCRPrimerName;
    
    @Size(max = 64)
    @Column(name = "PCRPrimerSequence5_3")
    private String pCRPrimerSequence53;
    
    @Size(max = 32)
    @Column(name = "PCRReversePrimerCode")
    private String pCRReversePrimerCode;
    @Size(max = 16)
    
    @Column(name = "ReadDirection")
    private String readDirection;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Column(name = "RunDate")
    @Temporal(TemporalType.DATE)
    private Date runDate;
    
    @Size(max = 32)
    @Column(name = "ScoreFileName")
    private String scoreFileName;
    
    @Column(name = "SequenceCocktailPrimer")
    private Boolean sequenceCocktailPrimer;
    
    @Size(max = 32)
    @Column(name = "SequencePrimerCode")
    private String sequencePrimerCode;
    
    @Size(max = 32)
    @Column(name = "SequencePrimerName")
    private String sequencePrimerName;
    
    @Size(max = 64)
    @Column(name = "SequencePrimerSequence5_3")
    private String sequencePrimerSequence53;
    
    @Size(max = 32)
    @Column(name = "Text1")
    private String text1;
    
    @Size(max = 32)
    @Column(name = "Text2")
    private String text2;
    
    @Size(max = 64)
    @Column(name = "Text3")
    private String text3;
    
    @Size(max = 32)
    @Column(name = "TraceFileName")
    private String traceFileName;
    
    @Column(name = "YesNo1")
    private Boolean yesNo1;
    
    @Column(name = "YesNo2")
    private Boolean yesNo2;
    
    @Column(name = "YesNo3")
    private Boolean yesNo3;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "GeneSequence")
    private String geneSequence;
    
    @JoinColumn(name = "DNASequenceID", referencedColumnName = "DnaSequenceID")
    @ManyToOne(optional = false)
    private Dnasequence dNASequenceID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "RunByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent runByAgentID;
    
    @JoinColumn(name = "PreparedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent preparedByAgentID;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dNASequencingRunID", fetch = FetchType.LAZY)
    private List<Dnasequencingruncitation> dnasequencingruncitationList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dnaSequencingRunID", fetch = FetchType.LAZY)
    private List<Dnasequencerunattachment> dnasequencerunattachmentList;

    public Dnasequencingrun() {
    }

    public Dnasequencingrun(Integer dNASequencingRunID) {
        this.dNASequencingRunID = dNASequencingRunID;
    }

    public Dnasequencingrun(Integer dNASequencingRunID, Date timestampCreated, int collectionMemberID) {
        this.dNASequencingRunID = dNASequencingRunID;
        this.timestampCreated = timestampCreated;
        this.collectionMemberID = collectionMemberID;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + dNASequencingRunID;
    }
    
    @Override
    public int getEntityId() {
        return dNASequencingRunID;
    }

    public Integer getDNASequencingRunID() {
        return dNASequencingRunID;
    }

    public void setDNASequencingRunID(Integer dNASequencingRunID) {
        this.dNASequencingRunID = dNASequencingRunID;
    }

    

    public int getCollectionMemberID() {
        return collectionMemberID;
    }

    public void setCollectionMemberID(int collectionMemberID) {
        this.collectionMemberID = collectionMemberID;
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

    public Float getNumber3() {
        return number3;
    }

    public void setNumber3(Float number3) {
        this.number3 = number3;
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }

    public Boolean getPCRCocktailPrimer() {
        return pCRCocktailPrimer;
    }

    public void setPCRCocktailPrimer(Boolean pCRCocktailPrimer) {
        this.pCRCocktailPrimer = pCRCocktailPrimer;
    }

    public String getPCRForwardPrimerCode() {
        return pCRForwardPrimerCode;
    }

    public void setPCRForwardPrimerCode(String pCRForwardPrimerCode) {
        this.pCRForwardPrimerCode = pCRForwardPrimerCode;
    }

    public String getPCRPrimerName() {
        return pCRPrimerName;
    }

    public void setPCRPrimerName(String pCRPrimerName) {
        this.pCRPrimerName = pCRPrimerName;
    }

    public String getPCRPrimerSequence53() {
        return pCRPrimerSequence53;
    }

    public void setPCRPrimerSequence53(String pCRPrimerSequence53) {
        this.pCRPrimerSequence53 = pCRPrimerSequence53;
    }

    public String getPCRReversePrimerCode() {
        return pCRReversePrimerCode;
    }

    public void setPCRReversePrimerCode(String pCRReversePrimerCode) {
        this.pCRReversePrimerCode = pCRReversePrimerCode;
    }

    public String getReadDirection() {
        return readDirection;
    }

    public void setReadDirection(String readDirection) {
        this.readDirection = readDirection;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getRunDate() {
        return runDate;
    }

    public void setRunDate(Date runDate) {
        this.runDate = runDate;
    }

    public String getScoreFileName() {
        return scoreFileName;
    }

    public void setScoreFileName(String scoreFileName) {
        this.scoreFileName = scoreFileName;
    }

    public Boolean getSequenceCocktailPrimer() {
        return sequenceCocktailPrimer;
    }

    public void setSequenceCocktailPrimer(Boolean sequenceCocktailPrimer) {
        this.sequenceCocktailPrimer = sequenceCocktailPrimer;
    }

    public String getSequencePrimerCode() {
        return sequencePrimerCode;
    }

    public void setSequencePrimerCode(String sequencePrimerCode) {
        this.sequencePrimerCode = sequencePrimerCode;
    }

    public String getSequencePrimerName() {
        return sequencePrimerName;
    }

    public void setSequencePrimerName(String sequencePrimerName) {
        this.sequencePrimerName = sequencePrimerName;
    }

    public String getSequencePrimerSequence53() {
        return sequencePrimerSequence53;
    }

    public void setSequencePrimerSequence53(String sequencePrimerSequence53) {
        this.sequencePrimerSequence53 = sequencePrimerSequence53;
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

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getTraceFileName() {
        return traceFileName;
    }

    public void setTraceFileName(String traceFileName) {
        this.traceFileName = traceFileName;
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

    public Boolean getYesNo3() {
        return yesNo3;
    }

    public void setYesNo3(Boolean yesNo3) {
        this.yesNo3 = yesNo3;
    }

    public String getGeneSequence() {
        return geneSequence;
    }

    public void setGeneSequence(String geneSequence) {
        this.geneSequence = geneSequence;
    }

    @XmlIDREF
    public Dnasequence getDNASequenceID() {
        return dNASequenceID;
    }

    public void setDNASequenceID(Dnasequence dNASequenceID) {
        this.dNASequenceID = dNASequenceID;
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
    public Agent getRunByAgentID() {
        return runByAgentID;
    }

    public void setRunByAgentID(Agent runByAgentID) {
        this.runByAgentID = runByAgentID;
    }

    @XmlIDREF
    public Agent getPreparedByAgentID() {
        return preparedByAgentID;
    }

    public void setPreparedByAgentID(Agent preparedByAgentID) {
        this.preparedByAgentID = preparedByAgentID;
    }

    @XmlTransient
    public List<Dnasequencingruncitation> getDnasequencingruncitationList() {
        return dnasequencingruncitationList;
    }

    public void setDnasequencingruncitationList(List<Dnasequencingruncitation> dnasequencingruncitationList) {
        this.dnasequencingruncitationList = dnasequencingruncitationList;
    }

    @XmlTransient
    public List<Dnasequencerunattachment> getDnasequencerunattachmentList() {
        return dnasequencerunattachmentList;
    }

    public void setDnasequencerunattachmentList(List<Dnasequencerunattachment> dnasequencerunattachmentList) {
        this.dnasequencerunattachmentList = dnasequencerunattachmentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dNASequencingRunID != null ? dNASequencingRunID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dnasequencingrun)) {
            return false;
        }
        Dnasequencingrun other = (Dnasequencingrun) object;
        return !((this.dNASequencingRunID == null && other.dNASequencingRunID != null) || (this.dNASequencingRunID != null && !this.dNASequencingRunID.equals(other.dNASequencingRunID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Dnasequencingrun[ dNASequencingRunID=" + dNASequencingRunID + " ]";
    }
    
}
