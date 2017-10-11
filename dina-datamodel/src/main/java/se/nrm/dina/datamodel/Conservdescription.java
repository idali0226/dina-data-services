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
@Table(name = "conservdescription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conservdescription.findAll", query = "SELECT c FROM Conservdescription c"),
    @NamedQuery(name = "Conservdescription.findByConservDescriptionID", query = "SELECT c FROM Conservdescription c WHERE c.conservDescriptionID = :conservDescriptionID"), 
    @NamedQuery(name = "Conservdescription.findByHeight", query = "SELECT c FROM Conservdescription c WHERE c.height = :height"),
    @NamedQuery(name = "Conservdescription.findByObjLength", query = "SELECT c FROM Conservdescription c WHERE c.objLength = :objLength"),
    @NamedQuery(name = "Conservdescription.findByShortDesc", query = "SELECT c FROM Conservdescription c WHERE c.shortDesc = :shortDesc"),
    @NamedQuery(name = "Conservdescription.findByUnits", query = "SELECT c FROM Conservdescription c WHERE c.units = :units"),
    @NamedQuery(name = "Conservdescription.findByWidth", query = "SELECT c FROM Conservdescription c WHERE c.width = :width")})
public class Conservdescription extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ConservDescriptionID")
    private Integer conservDescriptionID;
    
    
    @Lob
    @Size(max = 65535)
    @Column(name = "BackgroundInfo")
    private String backgroundInfo;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Composition")
    private String composition;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Description")
    private String description;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "DisplayRecommendations")
    private String displayRecommendations;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Height")
    private Float height;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "LightRecommendations")
    private String lightRecommendations;
    
    @Column(name = "ObjLength")
    private Float objLength;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "OtherRecommendations")
    private String otherRecommendations;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Size(max = 128)
    @Column(name = "ShortDesc")
    private String shortDesc;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Source")
    private String source;
    
    @Size(max = 16)
    @Column(name = "Units")
    private String units;
    
    @Column(name = "Width")
    private Float width;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CollectionObjectID", referencedColumnName = "CollectionObjectID")
    @ManyToOne
    private Collectionobject collectionObjectID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "DivisionID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne
    private Division divisionID;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conservDescriptionID", fetch = FetchType.LAZY)
    private List<Conservdescriptionattachment> conservdescriptionattachmentList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conservDescriptionID", fetch = FetchType.LAZY)
    private List<Conservevent> conserveventList;

    public Conservdescription() {
    }

    public Conservdescription(Integer conservDescriptionID) {
        this.conservDescriptionID = conservDescriptionID;
    }

    public Conservdescription(Integer conservDescriptionID, Date timestampCreated) {
        this.conservDescriptionID = conservDescriptionID;
        this.timestampCreated = timestampCreated;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + conservDescriptionID;
    }
    
    @Override
    public int getEntityId() {
        return conservDescriptionID;
    }

    public Integer getConservDescriptionID() {
        return conservDescriptionID;
    }

    public void setConservDescriptionID(Integer conservDescriptionID) {
        this.conservDescriptionID = conservDescriptionID;
    }

     

    public String getBackgroundInfo() {
        return backgroundInfo;
    }

    public void setBackgroundInfo(String backgroundInfo) {
        this.backgroundInfo = backgroundInfo;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayRecommendations() {
        return displayRecommendations;
    }

    public void setDisplayRecommendations(String displayRecommendations) {
        this.displayRecommendations = displayRecommendations;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getLightRecommendations() {
        return lightRecommendations;
    }

    public void setLightRecommendations(String lightRecommendations) {
        this.lightRecommendations = lightRecommendations;
    }

    public Float getObjLength() {
        return objLength;
    }

    public void setObjLength(Float objLength) {
        this.objLength = objLength;
    }

    public String getOtherRecommendations() {
        return otherRecommendations;
    }

    public void setOtherRecommendations(String otherRecommendations) {
        this.otherRecommendations = otherRecommendations;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    @XmlIDREF
    public Agent getModifiedByAgentID() {
        return modifiedByAgentID;
    }

    public void setModifiedByAgentID(Agent modifiedByAgentID) {
        this.modifiedByAgentID = modifiedByAgentID;
    }

    @XmlIDREF
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

    @XmlTransient
    public List<Conservdescriptionattachment> getConservdescriptionattachmentList() {
        return conservdescriptionattachmentList;
    }

    public void setConservdescriptionattachmentList(List<Conservdescriptionattachment> conservdescriptionattachmentList) {
        this.conservdescriptionattachmentList = conservdescriptionattachmentList;
    }

    @XmlTransient
    public List<Conservevent> getConserveventList() {
        return conserveventList;
    }

    public void setConserveventList(List<Conservevent> conserveventList) {
        this.conserveventList = conserveventList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conservDescriptionID != null ? conservDescriptionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conservdescription)) {
            return false;
        }
        Conservdescription other = (Conservdescription) object;
        return !((this.conservDescriptionID == null && other.conservDescriptionID != null) || (this.conservDescriptionID != null && !this.conservDescriptionID.equals(other.conservDescriptionID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Conservdescription[ conservDescriptionID=" + conservDescriptionID + " ]";
    }
    
}
