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
@Table(name = "spappresourcedir")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spappresourcedir.findAll", query = "SELECT s FROM Spappresourcedir s"),
    @NamedQuery(name = "Spappresourcedir.findBySpAppResourceDirID", query = "SELECT s FROM Spappresourcedir s WHERE s.spAppResourceDirID = :spAppResourceDirID"), 
    @NamedQuery(name = "Spappresourcedir.findByDisciplineType", query = "SELECT s FROM Spappresourcedir s WHERE s.disciplineType = :disciplineType"),
    @NamedQuery(name = "Spappresourcedir.findByIsPersonal", query = "SELECT s FROM Spappresourcedir s WHERE s.isPersonal = :isPersonal"),
    @NamedQuery(name = "Spappresourcedir.findByUserType", query = "SELECT s FROM Spappresourcedir s WHERE s.userType = :userType")})
public class Spappresourcedir extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SpAppResourceDirID")
    private Integer spAppResourceDirID;
    
    
    @Size(max = 64)
    @Column(name = "DisciplineType")
    private String disciplineType;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsPersonal")
    private boolean isPersonal;
    
    @Size(max = 64)
    @Column(name = "UserType")
    private String userType;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "spAppResourceDirID", fetch = FetchType.LAZY)
    private List<Spappresource> spappresourceList;
    
    @JoinColumn(name = "SpecifyUserID", referencedColumnName = "SpecifyUserID")
    @ManyToOne
    private Specifyuser specifyUserID;
    
    @JoinColumn(name = "DisciplineID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne
    private Discipline disciplineID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "CollectionID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne
    private Collection collectionID;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "spAppResourceDirID", fetch = FetchType.LAZY)
    private List<Spviewsetobj> spviewsetobjList;

    public Spappresourcedir() {
    }

    public Spappresourcedir(Integer spAppResourceDirID) {
        this.spAppResourceDirID = spAppResourceDirID;
    }

    public Spappresourcedir(Integer spAppResourceDirID, Date timestampCreated, boolean isPersonal) {
        this.spAppResourceDirID = spAppResourceDirID;
        this.timestampCreated = timestampCreated;
        this.isPersonal = isPersonal;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + spAppResourceDirID;
    }
    
    @Override
    public int getEntityId() {
        return spAppResourceDirID;
    }
    

    public Integer getSpAppResourceDirID() {
        return spAppResourceDirID;
    }

    public void setSpAppResourceDirID(Integer spAppResourceDirID) {
        this.spAppResourceDirID = spAppResourceDirID;
    }
 

    public String getDisciplineType() {
        return disciplineType;
    }

    public void setDisciplineType(String disciplineType) {
        this.disciplineType = disciplineType;
    }

    public boolean getIsPersonal() {
        return isPersonal;
    }

    public void setIsPersonal(boolean isPersonal) {
        this.isPersonal = isPersonal;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @XmlTransient
    public List<Spappresource> getSpappresourceList() {
        return spappresourceList;
    }

    public void setSpappresourceList(List<Spappresource> spappresourceList) {
        this.spappresourceList = spappresourceList;
    }

    @XmlIDREF
    public Specifyuser getSpecifyUserID() {
        return specifyUserID;
    }

    public void setSpecifyUserID(Specifyuser specifyUserID) {
        this.specifyUserID = specifyUserID;
    }

    @XmlIDREF
    public Discipline getDisciplineID() {
        return disciplineID;
    }

    public void setDisciplineID(Discipline disciplineID) {
        this.disciplineID = disciplineID;
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
    public Collection getCollectionID() {
        return collectionID;
    }

    public void setCollectionID(Collection collectionID) {
        this.collectionID = collectionID;
    }

    @XmlTransient
    public List<Spviewsetobj> getSpviewsetobjList() {
        return spviewsetobjList;
    }

    public void setSpviewsetobjList(List<Spviewsetobj> spviewsetobjList) {
        this.spviewsetobjList = spviewsetobjList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (spAppResourceDirID != null ? spAppResourceDirID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spappresourcedir)) {
            return false;
        }
        Spappresourcedir other = (Spappresourcedir) object;
        return !((this.spAppResourceDirID == null && other.spAppResourceDirID != null) || (this.spAppResourceDirID != null && !this.spAppResourceDirID.equals(other.spAppResourceDirID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Spappresourcedir[ spAppResourceDirID=" + spAppResourceDirID + " ]";
    }
    
}
