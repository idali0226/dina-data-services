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
@Table(name = "splocalecontainer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Splocalecontainer.findAll", query = "SELECT s FROM Splocalecontainer s"),
    @NamedQuery(name = "Splocalecontainer.findBySpLocaleContainerID", query = "SELECT s FROM Splocalecontainer s WHERE s.spLocaleContainerID = :spLocaleContainerID"), 
    @NamedQuery(name = "Splocalecontainer.findByFormat", query = "SELECT s FROM Splocalecontainer s WHERE s.format = :format"),
    @NamedQuery(name = "Splocalecontainer.findByIsHidden", query = "SELECT s FROM Splocalecontainer s WHERE s.isHidden = :isHidden"),
    @NamedQuery(name = "Splocalecontainer.findByIsSystem", query = "SELECT s FROM Splocalecontainer s WHERE s.isSystem = :isSystem"),
    @NamedQuery(name = "Splocalecontainer.findByIsUIFormatter", query = "SELECT s FROM Splocalecontainer s WHERE s.isUIFormatter = :isUIFormatter"),
    @NamedQuery(name = "Splocalecontainer.findByName", query = "SELECT s FROM Splocalecontainer s WHERE s.name = :name"),
    @NamedQuery(name = "Splocalecontainer.findByPickListName", query = "SELECT s FROM Splocalecontainer s WHERE s.pickListName = :pickListName"),
    @NamedQuery(name = "Splocalecontainer.findByType", query = "SELECT s FROM Splocalecontainer s WHERE s.type = :type"),
    @NamedQuery(name = "Splocalecontainer.findByAggregator", query = "SELECT s FROM Splocalecontainer s WHERE s.aggregator = :aggregator"),
    @NamedQuery(name = "Splocalecontainer.findByDefaultUI", query = "SELECT s FROM Splocalecontainer s WHERE s.defaultUI = :defaultUI"),
    @NamedQuery(name = "Splocalecontainer.findBySchemaType", query = "SELECT s FROM Splocalecontainer s WHERE s.schemaType = :schemaType")})
public class Splocalecontainer extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SpLocaleContainerID")
    private Integer spLocaleContainerID;
    
    
    @Size(max = 64)
    @Column(name = "Format")
    private String format;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsHidden")
    private boolean isHidden;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsSystem")
    private boolean isSystem;
    
    @Column(name = "IsUIFormatter")
    private Boolean isUIFormatter;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "Name")
    private String name;
    
    @Size(max = 64)
    @Column(name = "PickListName")
    private String pickListName;
    
    @Size(max = 32)
    @Column(name = "Type")
    private String type;
    
    @Size(max = 64)
    @Column(name = "Aggregator")
    private String aggregator;
    
    @Size(max = 64)
    @Column(name = "DefaultUI")
    private String defaultUI;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "SchemaType")
    private short schemaType;
    
    @OneToMany(mappedBy = "spLocaleContainerDescID", fetch = FetchType.LAZY)
    private List<Splocaleitemstr> splocaleitemstrList;
    
    @OneToMany(mappedBy = "spLocaleContainerNameID", fetch = FetchType.LAZY)
    private List<Splocaleitemstr> splocaleitemstrList1;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "spLocaleContainerID", fetch =  FetchType.LAZY)
    private List<Splocalecontaineritem> splocalecontaineritemList;
    
    @JoinColumn(name = "DisciplineID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne(optional = false)
    private Discipline disciplineID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;

    public Splocalecontainer() {
    }

    public Splocalecontainer(Integer spLocaleContainerID) {
        this.spLocaleContainerID = spLocaleContainerID;
    }

    public Splocalecontainer(Integer spLocaleContainerID, Date timestampCreated, boolean isHidden, boolean isSystem, String name, short schemaType) {
        this.spLocaleContainerID = spLocaleContainerID;
        this.timestampCreated = timestampCreated;
        this.isHidden = isHidden;
        this.isSystem = isSystem;
        this.name = name;
        this.schemaType = schemaType;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + spLocaleContainerID;
    }
    
    @Override
    public int getEntityId() {
        return spLocaleContainerID;
    }

    public Integer getSpLocaleContainerID() {
        return spLocaleContainerID;
    }

    public void setSpLocaleContainerID(Integer spLocaleContainerID) {
        this.spLocaleContainerID = spLocaleContainerID;
    }
 
    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }

    public boolean getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(boolean isSystem) {
        this.isSystem = isSystem;
    }

    public Boolean getIsUIFormatter() {
        return isUIFormatter;
    }

    public void setIsUIFormatter(Boolean isUIFormatter) {
        this.isUIFormatter = isUIFormatter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPickListName() {
        return pickListName;
    }

    public void setPickListName(String pickListName) {
        this.pickListName = pickListName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAggregator() {
        return aggregator;
    }

    public void setAggregator(String aggregator) {
        this.aggregator = aggregator;
    }

    public String getDefaultUI() {
        return defaultUI;
    }

    public void setDefaultUI(String defaultUI) {
        this.defaultUI = defaultUI;
    }

    public short getSchemaType() {
        return schemaType;
    }

    public void setSchemaType(short schemaType) {
        this.schemaType = schemaType;
    }

    @XmlTransient
    public List<Splocaleitemstr> getSplocaleitemstrList() {
        return splocaleitemstrList;
    }

    public void setSplocaleitemstrList(List<Splocaleitemstr> splocaleitemstrList) {
        this.splocaleitemstrList = splocaleitemstrList;
    }

    @XmlTransient
    public List<Splocaleitemstr> getSplocaleitemstrList1() {
        return splocaleitemstrList1;
    }

    public void setSplocaleitemstrList1(List<Splocaleitemstr> splocaleitemstrList1) {
        this.splocaleitemstrList1 = splocaleitemstrList1;
    }

    @XmlTransient
    public List<Splocalecontaineritem> getSplocalecontaineritemList() {
        return splocalecontaineritemList;
    }

    public void setSplocalecontaineritemList(List<Splocalecontaineritem> splocalecontaineritemList) {
        this.splocalecontaineritemList = splocalecontaineritemList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (spLocaleContainerID != null ? spLocaleContainerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Splocalecontainer)) {
            return false;
        }
        Splocalecontainer other = (Splocalecontainer) object;
        return !((this.spLocaleContainerID == null && other.spLocaleContainerID != null) || (this.spLocaleContainerID != null && !this.spLocaleContainerID.equals(other.spLocaleContainerID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Splocalecontainer[ spLocaleContainerID=" + spLocaleContainerID + " ]";
    }
    
}
