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
@Table(name = "paleocontext")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paleocontext.findAll", query = "SELECT p FROM Paleocontext p"),
    @NamedQuery(name = "Paleocontext.findByPaleoContextID", query = "SELECT p FROM Paleocontext p WHERE p.paleoContextID = :paleoContextID"),  
    @NamedQuery(name = "Paleocontext.findByPaleoContextName", query = "SELECT p FROM Paleocontext p WHERE p.paleoContextName = :paleoContextName") })
public class Paleocontext extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PaleoContextID")
    private Integer paleoContextID;
    
    
    @Size(max = 64)
    @Column(name = "Text1")
    private String text1;
    
    @Size(max = 64)
    @Column(name = "Text2")
    private String text2;
    
    @Column(name = "YesNo1")
    private Boolean yesNo1;
    
    @Column(name = "YesNo2")
    private Boolean yesNo2;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Number1")
    private Double number1;
    
    @Column(name = "Number2")
    private Double number2;
    
    @Column(name = "Number3")
    private Double number3;
    
    @Column(name = "Number4")
    private Double number4;
    
    @Column(name = "Number5")
    private Double number5;
    
    @Size(max = 80)
    @Column(name = "PaleoContextName")
    private String paleoContextName;
    
    @Size(max = 500)
    @Column(name = "Text3")
    private String text3;
    
    @Size(max = 500)
    @Column(name = "Text4")
    private String text4;
    
    @Size(max = 500)
    @Column(name = "Text5")
    private String text5;
    
    @Column(name = "YesNo3")
    private Boolean yesNo3;
    
    @Column(name = "YesNo4")
    private Boolean yesNo4;
    
    @Column(name = "YesNo5")
    private Boolean yesNo5;
    
    @OneToMany(mappedBy = "paleoContextID", fetch = FetchType.LAZY)
    private List<Locality> localityList;
    
    @JoinColumn(name = "ChronosStratEndID", referencedColumnName = "GeologicTimePeriodID")
    @ManyToOne
    private Geologictimeperiod chronosStratEndID;
    
    @JoinColumn(name = "DisciplineID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne
    private Discipline disciplineID;
    
    @JoinColumn(name = "ChronosStratID", referencedColumnName = "GeologicTimePeriodID")
    @ManyToOne
    private Geologictimeperiod chronosStratID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "BioStratID", referencedColumnName = "GeologicTimePeriodID")
    @ManyToOne
    private Geologictimeperiod bioStratID;
    
    @JoinColumn(name = "LithoStratID", referencedColumnName = "LithoStratID")
    @ManyToOne
    private Lithostrat lithoStratID;
    
    @OneToMany(mappedBy = "paleoContextID", fetch = FetchType.LAZY)
    private List<Collectionobject> collectionobjectList;
    
    @OneToMany(mappedBy = "paleoContextID", fetch = FetchType.LAZY)
    private List<Collectingevent> collectingeventList;

    public Paleocontext() {
    }

    public Paleocontext(Integer paleoContextID) {
        this.paleoContextID = paleoContextID;
    }

    public Paleocontext(Integer paleoContextID, Date timestampCreated) {
        this.paleoContextID = paleoContextID;
        this.timestampCreated = timestampCreated;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + paleoContextID;
    }

    @Override
    public int getEntityId() {
        return paleoContextID;
    }
    
    public Integer getPaleoContextID() {
        return paleoContextID;
    }

    public void setPaleoContextID(Integer paleoContextID) {
        this.paleoContextID = paleoContextID;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Double getNumber1() {
        return number1;
    }

    public void setNumber1(Double number1) {
        this.number1 = number1;
    }

    public Double getNumber2() {
        return number2;
    }

    public void setNumber2(Double number2) {
        this.number2 = number2;
    }

    public Double getNumber3() {
        return number3;
    }

    public void setNumber3(Double number3) {
        this.number3 = number3;
    }

    public Double getNumber4() {
        return number4;
    }

    public void setNumber4(Double number4) {
        this.number4 = number4;
    }

    public Double getNumber5() {
        return number5;
    }

    public void setNumber5(Double number5) {
        this.number5 = number5;
    }

    public String getPaleoContextName() {
        return paleoContextName;
    }

    public void setPaleoContextName(String paleoContextName) {
        this.paleoContextName = paleoContextName;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getText4() {
        return text4;
    }

    public void setText4(String text4) {
        this.text4 = text4;
    }

    public String getText5() {
        return text5;
    }

    public void setText5(String text5) {
        this.text5 = text5;
    }

    public Boolean getYesNo3() {
        return yesNo3;
    }

    public void setYesNo3(Boolean yesNo3) {
        this.yesNo3 = yesNo3;
    }

    public Boolean getYesNo4() {
        return yesNo4;
    }

    public void setYesNo4(Boolean yesNo4) {
        this.yesNo4 = yesNo4;
    }

    public Boolean getYesNo5() {
        return yesNo5;
    }

    public void setYesNo5(Boolean yesNo5) {
        this.yesNo5 = yesNo5;
    }

    @XmlTransient
    public List<Locality> getLocalityList() {
        return localityList;
    }

    public void setLocalityList(List<Locality> localityList) {
        this.localityList = localityList;
    }

    @XmlIDREF
    public Geologictimeperiod getChronosStratEndID() {
        return chronosStratEndID;
    }

    public void setChronosStratEndID(Geologictimeperiod chronosStratEndID) {
        this.chronosStratEndID = chronosStratEndID;
    }

    @XmlIDREF
    public Discipline getDisciplineID() {
        return disciplineID;
    }

    public void setDisciplineID(Discipline disciplineID) {
        this.disciplineID = disciplineID;
    }

    @XmlIDREF
    public Geologictimeperiod getChronosStratID() {
        return chronosStratID;
    }

    public void setChronosStratID(Geologictimeperiod chronosStratID) {
        this.chronosStratID = chronosStratID;
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
    public Geologictimeperiod getBioStratID() {
        return bioStratID;
    }

    public void setBioStratID(Geologictimeperiod bioStratID) {
        this.bioStratID = bioStratID;
    }

    @XmlIDREF
    public Lithostrat getLithoStratID() {
        return lithoStratID;
    }

    public void setLithoStratID(Lithostrat lithoStratID) {
        this.lithoStratID = lithoStratID;
    }

    @XmlTransient
    public List<Collectionobject> getCollectionobjectList() {
        return collectionobjectList;
    }

    public void setCollectionobjectList(List<Collectionobject> collectionobjectList) {
        this.collectionobjectList = collectionobjectList;
    }

    @XmlTransient
    public List<Collectingevent> getCollectingeventList() {
        return collectingeventList;
    }

    public void setCollectingeventList(List<Collectingevent> collectingeventList) {
        this.collectingeventList = collectingeventList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paleoContextID != null ? paleoContextID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paleocontext)) {
            return false;
        }
        Paleocontext other = (Paleocontext) object;
        return !((this.paleoContextID == null && other.paleoContextID != null) || (this.paleoContextID != null && !this.paleoContextID.equals(other.paleoContextID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Paleocontext[ paleoContextID=" + paleoContextID + " ]";
    }
    
}
