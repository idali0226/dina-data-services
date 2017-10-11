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
@Table(name = "institutionnetwork")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Institutionnetwork.findAll", query = "SELECT i FROM Institutionnetwork i"),
    @NamedQuery(name = "Institutionnetwork.findByInstitutionNetworkID", query = "SELECT i FROM Institutionnetwork i WHERE i.institutionNetworkID = :institutionNetworkID"),  
    @NamedQuery(name = "Institutionnetwork.findByCode", query = "SELECT i FROM Institutionnetwork i WHERE i.code = :code"), 
    @NamedQuery(name = "Institutionnetwork.findByName", query = "SELECT i FROM Institutionnetwork i WHERE i.name = :name"),
    @NamedQuery(name = "Institutionnetwork.findByUri", query = "SELECT i FROM Institutionnetwork i WHERE i.uri = :uri"),
    @NamedQuery(name = "Institutionnetwork.findByAddressID", query = "SELECT i FROM Institutionnetwork i WHERE i.addressID = :addressID") })
public class Institutionnetwork extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "InstitutionNetworkID")
    private Integer institutionNetworkID;
    
    
    @Size(max = 128)
    @Column(name = "AltName")
    private String altName;
    
    @Size(max = 64)
    @Column(name = "Code")
    private String code;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Copyright")
    private String copyright;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Description")
    private String description;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Disclaimer")
    private String disclaimer;
    
    @Size(max = 255)
    @Column(name = "IconURI")
    private String iconURI;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Ipr")
    private String ipr;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "License")
    private String license;
    
    @Size(max = 255)
    @Column(name = "Name")
    private String name;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "TermsOfUse")
    private String termsOfUse;
    
    @Size(max = 255)
    @Column(name = "Uri")
    private String uri;
    
    @Column(name = "AddressID")
    private Integer addressID;
    
    @Column(name = "ModifiedByAgentID")
    private Integer modifiedByAgentID;
    
    @Column(name = "CreatedByAgentID")
    private Integer createdByAgentID;

    public Institutionnetwork() {
    }

    public Institutionnetwork(Integer institutionNetworkID) {
        this.institutionNetworkID = institutionNetworkID;
    }

    public Institutionnetwork(Integer institutionNetworkID, Date timestampCreated) {
        this.institutionNetworkID = institutionNetworkID;
        this.timestampCreated = timestampCreated;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + institutionNetworkID;
    }
    
    @Override
    public int getEntityId() {
        return institutionNetworkID;
    }

    public Integer getInstitutionNetworkID() {
        return institutionNetworkID;
    }

    public void setInstitutionNetworkID(Integer institutionNetworkID) {
        this.institutionNetworkID = institutionNetworkID;
    }

 
    public String getAltName() {
        return altName;
    }

    public void setAltName(String altName) {
        this.altName = altName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getIconURI() {
        return iconURI;
    }

    public void setIconURI(String iconURI) {
        this.iconURI = iconURI;
    }

    public String getIpr() {
        return ipr;
    }

    public void setIpr(String ipr) {
        this.ipr = ipr;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTermsOfUse() {
        return termsOfUse;
    }

    public void setTermsOfUse(String termsOfUse) {
        this.termsOfUse = termsOfUse;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Integer getAddressID() {
        return addressID;
    }

    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    public Integer getModifiedByAgentID() {
        return modifiedByAgentID;
    }

    public void setModifiedByAgentID(Integer modifiedByAgentID) {
        this.modifiedByAgentID = modifiedByAgentID;
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
        hash += (institutionNetworkID != null ? institutionNetworkID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Institutionnetwork)) {
            return false;
        }
        Institutionnetwork other = (Institutionnetwork) object;
        return !((this.institutionNetworkID == null && other.institutionNetworkID != null) || (this.institutionNetworkID != null && !this.institutionNetworkID.equals(other.institutionNetworkID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Institutionnetwork[ institutionNetworkID=" + institutionNetworkID + " ]";
    }
    
}
