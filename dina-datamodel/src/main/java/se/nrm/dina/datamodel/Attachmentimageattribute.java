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
import javax.persistence.Temporal;
import javax.persistence.TemporalType; 
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
@Table(name = "attachmentimageattribute")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attachmentimageattribute.findAll", query = "SELECT a FROM Attachmentimageattribute a"),
    @NamedQuery(name = "Attachmentimageattribute.findByAttachmentImageAttributeID", query = "SELECT a FROM Attachmentimageattribute a WHERE a.attachmentImageAttributeID = :attachmentImageAttributeID"),
    @NamedQuery(name = "Attachmentimageattribute.findByCreativeCommons", query = "SELECT a FROM Attachmentimageattribute a WHERE a.creativeCommons = :creativeCommons"), 
    @NamedQuery(name = "Attachmentimageattribute.findByTimestampLastUpdateCheck", query = "SELECT a FROM Attachmentimageattribute a WHERE a.timestampLastUpdateCheck = :timestampLastUpdateCheck"),
    @NamedQuery(name = "Attachmentimageattribute.findByMorphBankViewID", query = "SELECT a FROM Attachmentimageattribute a WHERE a.morphBankViewID = :morphBankViewID"),
    @NamedQuery(name = "Attachmentimageattribute.findByImageType", query = "SELECT a FROM Attachmentimageattribute a WHERE a.imageType = :imageType"), 
    @NamedQuery(name = "Attachmentimageattribute.findByViewDescription", query = "SELECT a FROM Attachmentimageattribute a WHERE a.viewDescription = :viewDescription") })
public class Attachmentimageattribute extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AttachmentImageAttributeID")
    private Integer attachmentImageAttributeID;
    
    
    @Size(max = 500)
    @Column(name = "CreativeCommons")
    private String creativeCommons;
    
    @Column(name = "Height")
    private Integer height;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Magnification")
    private Double magnification;
    
    @Column(name = "MBImageID")
    private Integer mBImageID;
    
    @Column(name = "Resolution")
    private Double resolution;
    
    @Column(name = "TimestampLastSend")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestampLastSend;
    
    @Column(name = "TimestampLastUpdateCheck")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestampLastUpdateCheck;
    
    @Column(name = "Width")
    private Integer width;
    
    @Column(name = "CreatedByAgentID")
    private Integer createdByAgentID;
    
    @Column(name = "ModifiedByAgentID")
    private Integer modifiedByAgentID;
    
    @Column(name = "MorphBankViewID")
    private Integer morphBankViewID;
    
    @Size(max = 80)
    @Column(name = "ImageType")
    private String imageType;
    
    @Column(name = "Number1")
    private Double number1;
    
    @Column(name = "Number2")
    private Double number2;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Size(max = 200)
    @Column(name = "Text1")
    private String text1;
    
    @Size(max = 200)
    @Column(name = "Text2")
    private String text2;
    
    @Size(max = 80)
    @Column(name = "ViewDescription")
    private String viewDescription;
    
    @Column(name = "YesNo1")
    private Boolean yesNo1;
    
    @Column(name = "YesNo2")
    private Boolean yesNo2;
    

    public Attachmentimageattribute() {
    }

    public Attachmentimageattribute(Integer attachmentImageAttributeID) {
        this.attachmentImageAttributeID = attachmentImageAttributeID;
    }

    public Attachmentimageattribute(Integer attachmentImageAttributeID, Date timestampCreated) {
        this.attachmentImageAttributeID = attachmentImageAttributeID;
        this.timestampCreated = timestampCreated;
    }

    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + attachmentImageAttributeID;
    }
    
    @Override
    public int getEntityId() {
        return attachmentImageAttributeID;
    }

    public Integer getAttachmentImageAttributeID() {
        return attachmentImageAttributeID;
    }

    public void setAttachmentImageAttributeID(Integer attachmentImageAttributeID) {
        this.attachmentImageAttributeID = attachmentImageAttributeID;
    }

   
    public String getCreativeCommons() {
        return creativeCommons;
    }

    public void setCreativeCommons(String creativeCommons) {
        this.creativeCommons = creativeCommons;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Double getMagnification() {
        return magnification;
    }

    public void setMagnification(Double magnification) {
        this.magnification = magnification;
    }

    public Integer getMBImageID() {
        return mBImageID;
    }

    public void setMBImageID(Integer mBImageID) {
        this.mBImageID = mBImageID;
    }

    public Double getResolution() {
        return resolution;
    }

    public void setResolution(Double resolution) {
        this.resolution = resolution;
    }

    public Date getTimestampLastSend() {
        return timestampLastSend;
    }

    public void setTimestampLastSend(Date timestampLastSend) {
        this.timestampLastSend = timestampLastSend;
    }

    public Date getTimestampLastUpdateCheck() {
        return timestampLastUpdateCheck;
    }

    public void setTimestampLastUpdateCheck(Date timestampLastUpdateCheck) {
        this.timestampLastUpdateCheck = timestampLastUpdateCheck;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getCreatedByAgentID() {
        return createdByAgentID;
    }

    public void setCreatedByAgentID(Integer createdByAgentID) {
        this.createdByAgentID = createdByAgentID;
    }

    public Integer getModifiedByAgentID() {
        return modifiedByAgentID;
    }

    public void setModifiedByAgentID(Integer modifiedByAgentID) {
        this.modifiedByAgentID = modifiedByAgentID;
    }

    public Integer getMorphBankViewID() {
        return morphBankViewID;
    }

    public void setMorphBankViewID(Integer morphBankViewID) {
        this.morphBankViewID = morphBankViewID;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
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

    public String getViewDescription() {
        return viewDescription;
    }

    public void setViewDescription(String viewDescription) {
        this.viewDescription = viewDescription;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attachmentImageAttributeID != null ? attachmentImageAttributeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attachmentimageattribute)) {
            return false;
        }
        Attachmentimageattribute other = (Attachmentimageattribute) object;
        return !((this.attachmentImageAttributeID == null && other.attachmentImageAttributeID != null) || (this.attachmentImageAttributeID != null && !this.attachmentImageAttributeID.equals(other.attachmentImageAttributeID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Attachmentimageattribute[ attachmentImageAttributeID=" + attachmentImageAttributeID + " ]";
    }
    
}
