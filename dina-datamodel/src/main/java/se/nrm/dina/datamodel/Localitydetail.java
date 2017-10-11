/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.datamodel;
 
import java.math.BigDecimal;
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
@Table(name = "localitydetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localitydetail.findAll", query = "SELECT l FROM Localitydetail l"),
    @NamedQuery(name = "Localitydetail.findByLocalityDetailID", query = "SELECT l FROM Localitydetail l WHERE l.localityDetailID = :localityDetailID") })
public class Localitydetail extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LocalityDetailID")
    private Integer localityDetailID;
    
    
    @Size(max = 50)
    @Column(name = "BaseMeridian")
    private String baseMeridian;
    
    @Size(max = 64)
    @Column(name = "Drainage")
    private String drainage;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "StartDepth")
    private Double startDepth;
    
    @Column(name = "StartDepthUnit")
    private Short startDepthUnit;
    
    @Size(max = 32)
    @Column(name = "StartDepthVerbatim")
    private String startDepthVerbatim;
    
    @Column(name = "EndDepth")
    private Double endDepth;
    
    @Column(name = "EndDepthUnit")
    private Short endDepthUnit;
    
    @Size(max = 32)
    @Column(name = "EndDepthVerbatim")
    private String endDepthVerbatim;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "GML")
    private String gml;
    
    @Size(max = 16)
    @Column(name = "HucCode")
    private String hucCode;
    
    @Size(max = 64)
    @Column(name = "Island")
    private String island;
    
    @Size(max = 64)
    @Column(name = "IslandGroup")
    private String islandGroup;
    
    @Size(max = 64)
    @Column(name = "NationalParkName")
    private String nationalParkName;
    
    @Column(name = "Number1")
    private Double number1;
    
    @Column(name = "Number2")
    private Double number2;
    
    @Size(max = 50)
    @Column(name = "RangeDesc")
    private String rangeDesc;
    
    @Size(max = 50)
    @Column(name = "RangeDirection")
    private String rangeDirection;
    
    @Size(max = 50)
    @Column(name = "Section")
    private String section;
    
    @Size(max = 50)
    @Column(name = "SectionPart")
    private String sectionPart;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text1")
    private String text1;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text2")
    private String text2;
    
    @Size(max = 50)
    @Column(name = "Township")
    private String township;
    
    @Size(max = 50)
    @Column(name = "TownshipDirection")
    private String townshipDirection;
    
    @Size(max = 255)
    @Column(name = "UtmDatum")
    private String utmDatum;
    
    @Column(name = "UtmEasting")
    private BigDecimal utmEasting;
    
    @Column(name = "UtmFalseEasting")
    private Integer utmFalseEasting;
    
    @Column(name = "UtmFalseNorthing")
    private Integer utmFalseNorthing;
    
    @Column(name = "UtmNorthing")
    private BigDecimal utmNorthing;
    
    @Column(name = "UtmOrigLatitude")
    private BigDecimal utmOrigLatitude;
    
    @Column(name = "UtmOrigLongitude")
    private BigDecimal utmOrigLongitude;
    
    @Column(name = "UtmScale")
    private BigDecimal utmScale;
    
    @Column(name = "UtmZone")
    private Short utmZone;
    
    @Size(max = 64)
    @Column(name = "WaterBody")
    private String waterBody;
    
    @Column(name = "YesNo1")
    private Boolean yesNo1;
    
    @Column(name = "YesNo2")
    private Boolean yesNo2;
    
    @Size(max = 4)
    @Column(name = "MgrsZone")
    private String mgrsZone;
    
    @Column(name = "Number3")
    private Float number3;
    
    @Column(name = "Number4")
    private Float number4;
    
    @Column(name = "Number5")
    private Float number5;
    
    @Size(max = 32)
    @Column(name = "PaleoLat")
    private String paleoLat;
    
    @Size(max = 32)
    @Column(name = "PaleoLng")
    private String paleoLng;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text3")
    private String text3;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text4")
    private String text4;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text5")
    private String text5;
    
    @Column(name = "YesNo3")
    private Boolean yesNo3;
    
    @Column(name = "YesNo4")
    private Boolean yesNo4;
    
    @Column(name = "YesNo5")
    private Boolean yesNo5;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "LocalityID", referencedColumnName = "LocalityID")
    @ManyToOne
    private Locality localityID;

    public Localitydetail() {
    }

    public Localitydetail(Integer localityDetailID) {
        this.localityDetailID = localityDetailID;
    }

    public Localitydetail(Integer localityDetailID, Date timestampCreated) {
        this.localityDetailID = localityDetailID;
        this.timestampCreated = timestampCreated;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + localityDetailID;
    }
    
    @Override
    public int getEntityId() {
        return localityDetailID;
    }

    public Integer getLocalityDetailID() {
        return localityDetailID;
    }

    public void setLocalityDetailID(Integer localityDetailID) {
        this.localityDetailID = localityDetailID;
    }

    

    public String getBaseMeridian() {
        return baseMeridian;
    }

    public void setBaseMeridian(String baseMeridian) {
        this.baseMeridian = baseMeridian;
    }

    public String getDrainage() {
        return drainage;
    }

    public void setDrainage(String drainage) {
        this.drainage = drainage;
    }

    public Double getStartDepth() {
        return startDepth;
    }

    public void setStartDepth(Double startDepth) {
        this.startDepth = startDepth;
    }

    public Short getStartDepthUnit() {
        return startDepthUnit;
    }

    public void setStartDepthUnit(Short startDepthUnit) {
        this.startDepthUnit = startDepthUnit;
    }

    public String getStartDepthVerbatim() {
        return startDepthVerbatim;
    }

    public void setStartDepthVerbatim(String startDepthVerbatim) {
        this.startDepthVerbatim = startDepthVerbatim;
    }

    public Double getEndDepth() {
        return endDepth;
    }

    public void setEndDepth(Double endDepth) {
        this.endDepth = endDepth;
    }

    public Short getEndDepthUnit() {
        return endDepthUnit;
    }

    public void setEndDepthUnit(Short endDepthUnit) {
        this.endDepthUnit = endDepthUnit;
    }

    public String getEndDepthVerbatim() {
        return endDepthVerbatim;
    }

    public void setEndDepthVerbatim(String endDepthVerbatim) {
        this.endDepthVerbatim = endDepthVerbatim;
    }

    public String getGml() {
        return gml;
    }

    public void setGml(String gml) {
        this.gml = gml;
    }

    public String getHucCode() {
        return hucCode;
    }

    public void setHucCode(String hucCode) {
        this.hucCode = hucCode;
    }

    public String getIsland() {
        return island;
    }

    public void setIsland(String island) {
        this.island = island;
    }

    public String getIslandGroup() {
        return islandGroup;
    }

    public void setIslandGroup(String islandGroup) {
        this.islandGroup = islandGroup;
    }

    public String getNationalParkName() {
        return nationalParkName;
    }

    public void setNationalParkName(String nationalParkName) {
        this.nationalParkName = nationalParkName;
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

    public String getRangeDesc() {
        return rangeDesc;
    }

    public void setRangeDesc(String rangeDesc) {
        this.rangeDesc = rangeDesc;
    }

    public String getRangeDirection() {
        return rangeDirection;
    }

    public void setRangeDirection(String rangeDirection) {
        this.rangeDirection = rangeDirection;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSectionPart() {
        return sectionPart;
    }

    public void setSectionPart(String sectionPart) {
        this.sectionPart = sectionPart;
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

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public String getTownshipDirection() {
        return townshipDirection;
    }

    public void setTownshipDirection(String townshipDirection) {
        this.townshipDirection = townshipDirection;
    }

    public String getUtmDatum() {
        return utmDatum;
    }

    public void setUtmDatum(String utmDatum) {
        this.utmDatum = utmDatum;
    }

    public BigDecimal getUtmEasting() {
        return utmEasting;
    }

    public void setUtmEasting(BigDecimal utmEasting) {
        this.utmEasting = utmEasting;
    }

    public Integer getUtmFalseEasting() {
        return utmFalseEasting;
    }

    public void setUtmFalseEasting(Integer utmFalseEasting) {
        this.utmFalseEasting = utmFalseEasting;
    }

    public Integer getUtmFalseNorthing() {
        return utmFalseNorthing;
    }

    public void setUtmFalseNorthing(Integer utmFalseNorthing) {
        this.utmFalseNorthing = utmFalseNorthing;
    }

    public BigDecimal getUtmNorthing() {
        return utmNorthing;
    }

    public void setUtmNorthing(BigDecimal utmNorthing) {
        this.utmNorthing = utmNorthing;
    }

    public BigDecimal getUtmOrigLatitude() {
        return utmOrigLatitude;
    }

    public void setUtmOrigLatitude(BigDecimal utmOrigLatitude) {
        this.utmOrigLatitude = utmOrigLatitude;
    }

    public BigDecimal getUtmOrigLongitude() {
        return utmOrigLongitude;
    }

    public void setUtmOrigLongitude(BigDecimal utmOrigLongitude) {
        this.utmOrigLongitude = utmOrigLongitude;
    }

    public BigDecimal getUtmScale() {
        return utmScale;
    }

    public void setUtmScale(BigDecimal utmScale) {
        this.utmScale = utmScale;
    }

    public Short getUtmZone() {
        return utmZone;
    }

    public void setUtmZone(Short utmZone) {
        this.utmZone = utmZone;
    }

    public String getWaterBody() {
        return waterBody;
    }

    public void setWaterBody(String waterBody) {
        this.waterBody = waterBody;
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

    public String getMgrsZone() {
        return mgrsZone;
    }

    public void setMgrsZone(String mgrsZone) {
        this.mgrsZone = mgrsZone;
    }

    public Float getNumber3() {
        return number3;
    }

    public void setNumber3(Float number3) {
        this.number3 = number3;
    }

    public Float getNumber4() {
        return number4;
    }

    public void setNumber4(Float number4) {
        this.number4 = number4;
    }

    public Float getNumber5() {
        return number5;
    }

    public void setNumber5(Float number5) {
        this.number5 = number5;
    }

    public String getPaleoLat() {
        return paleoLat;
    }

    public void setPaleoLat(String paleoLat) {
        this.paleoLat = paleoLat;
    }

    public String getPaleoLng() {
        return paleoLng;
    }

    public void setPaleoLng(String paleoLng) {
        this.paleoLng = paleoLng;
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
    public Locality getLocalityID() {
        return localityID;
    }

    public void setLocalityID(Locality localityID) {
        this.localityID = localityID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (localityDetailID != null ? localityDetailID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localitydetail)) {
            return false;
        }
        Localitydetail other = (Localitydetail) object;
        return !((this.localityDetailID == null && other.localityDetailID != null) || (this.localityDetailID != null && !this.localityDetailID.equals(other.localityDetailID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Localitydetail[ localityDetailID=" + localityDetailID + " ]";
    }
    
}
