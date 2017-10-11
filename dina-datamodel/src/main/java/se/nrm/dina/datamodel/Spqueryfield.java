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
@Table(name = "spqueryfield")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spqueryfield.findAll", query = "SELECT s FROM Spqueryfield s"),
    @NamedQuery(name = "Spqueryfield.findBySpQueryFieldID", query = "SELECT s FROM Spqueryfield s WHERE s.spQueryFieldID = :spQueryFieldID"),  
    @NamedQuery(name = "Spqueryfield.findByStartValue", query = "SELECT s FROM Spqueryfield s WHERE s.startValue = :startValue"),
    @NamedQuery(name = "Spqueryfield.findByAllowNulls", query = "SELECT s FROM Spqueryfield s WHERE s.allowNulls = :allowNulls")})
public class Spqueryfield extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SpQueryFieldID")
    private Integer spQueryFieldID;
    
    
    @Column(name = "AlwaysFilter")
    private Boolean alwaysFilter;
    
    @Size(max = 64)
    @Column(name = "ColumnAlias")
    private String columnAlias;
    
    @Column(name = "ContextTableIdent")
    private Integer contextTableIdent;
    
    @Size(max = 255)
    @Column(name = "EndValue")
    private String endValue;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "FieldName")
    private String fieldName;
    
    @Size(max = 64)
    @Column(name = "FormatName")
    private String formatName;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsDisplay")
    private boolean isDisplay;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsNot")
    private boolean isNot;
    
    @Column(name = "IsPrompt")
    private Boolean isPrompt;
    
    @Column(name = "IsRelFld")
    private Boolean isRelFld;
    
    @Column(name = "OperEnd")
    private Short operEnd;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "OperStart")
    private short operStart;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Position")
    private short position;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "SortType")
    private short sortType;
    
    @Size(max = 255)
    @Column(name = "StartValue")
    private String startValue;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "StringId")
    private String stringId;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "TableList")
    private String tableList;
    
    @Column(name = "AllowNulls")
    private Boolean allowNulls;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @JoinColumn(name = "SpQueryID", referencedColumnName = "SpQueryID")
    @ManyToOne
    private Spquery spQueryID;
    
    @OneToMany(mappedBy = "spQueryFieldID", fetch = FetchType.LAZY)
    private List<Spexportschemaitemmapping> spexportschemaitemmappingList;

    public Spqueryfield() {
    }

    public Spqueryfield(Integer spQueryFieldID) {
        this.spQueryFieldID = spQueryFieldID;
    }

    public Spqueryfield(Integer spQueryFieldID, Date timestampCreated, String fieldName, boolean isDisplay, boolean isNot, short operStart, short position, short sortType, String stringId, String tableList) {
        this.spQueryFieldID = spQueryFieldID;
        this.timestampCreated = timestampCreated;
        this.fieldName = fieldName;
        this.isDisplay = isDisplay;
        this.isNot = isNot;
        this.operStart = operStart;
        this.position = position;
        this.sortType = sortType;
        this.stringId = stringId;
        this.tableList = tableList;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + spQueryFieldID;
    }
    
    @Override
    public int getEntityId() {
        return spQueryFieldID;
    }

    public Integer getSpQueryFieldID() {
        return spQueryFieldID;
    }

    public void setSpQueryFieldID(Integer spQueryFieldID) {
        this.spQueryFieldID = spQueryFieldID;
    }
 

    public Boolean getAlwaysFilter() {
        return alwaysFilter;
    }

    public void setAlwaysFilter(Boolean alwaysFilter) {
        this.alwaysFilter = alwaysFilter;
    }

    public String getColumnAlias() {
        return columnAlias;
    }

    public void setColumnAlias(String columnAlias) {
        this.columnAlias = columnAlias;
    }

    public Integer getContextTableIdent() {
        return contextTableIdent;
    }

    public void setContextTableIdent(Integer contextTableIdent) {
        this.contextTableIdent = contextTableIdent;
    }

    public String getEndValue() {
        return endValue;
    }

    public void setEndValue(String endValue) {
        this.endValue = endValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFormatName() {
        return formatName;
    }

    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }

    public boolean getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(boolean isDisplay) {
        this.isDisplay = isDisplay;
    }

    public boolean getIsNot() {
        return isNot;
    }

    public void setIsNot(boolean isNot) {
        this.isNot = isNot;
    }

    public Boolean getIsPrompt() {
        return isPrompt;
    }

    public void setIsPrompt(Boolean isPrompt) {
        this.isPrompt = isPrompt;
    }

    public Boolean getIsRelFld() {
        return isRelFld;
    }

    public void setIsRelFld(Boolean isRelFld) {
        this.isRelFld = isRelFld;
    }

    public Short getOperEnd() {
        return operEnd;
    }

    public void setOperEnd(Short operEnd) {
        this.operEnd = operEnd;
    }

    public short getOperStart() {
        return operStart;
    }

    public void setOperStart(short operStart) {
        this.operStart = operStart;
    }

    public short getPosition() {
        return position;
    }

    public void setPosition(short position) {
        this.position = position;
    }

    public short getSortType() {
        return sortType;
    }

    public void setSortType(short sortType) {
        this.sortType = sortType;
    }

    public String getStartValue() {
        return startValue;
    }

    public void setStartValue(String startValue) {
        this.startValue = startValue;
    }

    public String getStringId() {
        return stringId;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
    }

    public String getTableList() {
        return tableList;
    }

    public void setTableList(String tableList) {
        this.tableList = tableList;
    }

    public Boolean getAllowNulls() {
        return allowNulls;
    }

    public void setAllowNulls(Boolean allowNulls) {
        this.allowNulls = allowNulls;
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
    public Spquery getSpQueryID() {
        return spQueryID;
    }

    public void setSpQueryID(Spquery spQueryID) {
        this.spQueryID = spQueryID;
    }

    @XmlTransient
    public List<Spexportschemaitemmapping> getSpexportschemaitemmappingList() {
        return spexportschemaitemmappingList;
    }

    public void setSpexportschemaitemmappingList(List<Spexportschemaitemmapping> spexportschemaitemmappingList) {
        this.spexportschemaitemmappingList = spexportschemaitemmappingList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (spQueryFieldID != null ? spQueryFieldID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spqueryfield)) {
            return false;
        }
        Spqueryfield other = (Spqueryfield) object;
        return !((this.spQueryFieldID == null && other.spQueryFieldID != null) || (this.spQueryFieldID != null && !this.spQueryFieldID.equals(other.spQueryFieldID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Spqueryfield[ spQueryFieldID=" + spQueryFieldID + " ]";
    }
    
}
