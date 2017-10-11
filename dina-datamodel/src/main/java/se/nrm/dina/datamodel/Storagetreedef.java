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
@Table(name = "storagetreedef")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Storagetreedef.findAll", query = "SELECT s FROM Storagetreedef s"),
    @NamedQuery(name = "Storagetreedef.findByStorageTreeDefID", query = "SELECT s FROM Storagetreedef s WHERE s.storageTreeDefID = :storageTreeDefID"), 
    @NamedQuery(name = "Storagetreedef.findByFullNameDirection", query = "SELECT s FROM Storagetreedef s WHERE s.fullNameDirection = :fullNameDirection"),
    @NamedQuery(name = "Storagetreedef.findByName", query = "SELECT s FROM Storagetreedef s WHERE s.name = :name")})
public class Storagetreedef extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StorageTreeDefID")
    private Integer storageTreeDefID;
    
    
    @Column(name = "FullNameDirection")
    private Integer fullNameDirection;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "Name")
    private String name;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storageTreeDefID", fetch = FetchType.LAZY)
    private List<Storagetreedefitem> storagetreedefitemList;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @OneToMany(mappedBy = "storageTreeDefID", fetch = FetchType.LAZY )
    private List<Institution> institutionList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storageTreeDefID", fetch = FetchType.LAZY)
    private List<Storage> storageList;

    public Storagetreedef() {
    }

    public Storagetreedef(Integer storageTreeDefID) {
        this.storageTreeDefID = storageTreeDefID;
    }

    public Storagetreedef(Integer storageTreeDefID, Date timestampCreated, String name) {
        this.storageTreeDefID = storageTreeDefID;
        this.timestampCreated = timestampCreated;
        this.name = name;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + storageTreeDefID;
    }
    
    @Override
    public int getEntityId() {
        return storageTreeDefID;
    }

    public Integer getStorageTreeDefID() {
        return storageTreeDefID;
    }

    public void setStorageTreeDefID(Integer storageTreeDefID) {
        this.storageTreeDefID = storageTreeDefID;
    }
 
    public Integer getFullNameDirection() {
        return fullNameDirection;
    }

    public void setFullNameDirection(Integer fullNameDirection) {
        this.fullNameDirection = fullNameDirection;
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

    @XmlTransient
    public List<Storagetreedefitem> getStoragetreedefitemList() {
        return storagetreedefitemList;
    }

    public void setStoragetreedefitemList(List<Storagetreedefitem> storagetreedefitemList) {
        this.storagetreedefitemList = storagetreedefitemList;
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

    @XmlTransient
    public List<Institution> getInstitutionList() {
        return institutionList;
    }

    public void setInstitutionList(List<Institution> institutionList) {
        this.institutionList = institutionList;
    }

    @XmlTransient
    public List<Storage> getStorageList() {
        return storageList;
    }

    public void setStorageList(List<Storage> storageList) {
        this.storageList = storageList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storageTreeDefID != null ? storageTreeDefID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Storagetreedef)) {
            return false;
        }
        Storagetreedef other = (Storagetreedef) object;
        return !((this.storageTreeDefID == null && other.storageTreeDefID != null) || (this.storageTreeDefID != null && !this.storageTreeDefID.equals(other.storageTreeDefID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Storagetreedef[ storageTreeDefID=" + storageTreeDefID + " ]";
    }
    
}
