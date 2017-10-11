/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.datamodel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author idali
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable, EntityBean {

    private static final long serialVersionUID = 1L;
    
    @Version
    @Column(name = "Version")
    protected Integer version;

    @Basic(optional = false) 
    @Column(name = "TimestampCreated")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date timestampCreated;

    @Column(name = "TimestampModified")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date timestampModified;

    public BaseEntity() {
    }

    @XmlAttribute
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getTimestampCreated() {
        return timestampCreated;
    }

    public void setTimestampCreated(Date timestampCreated) {
        this.timestampCreated = timestampCreated;
    }

    public Date getTimestampModified() {
        return timestampModified;
    }

    public void setTimestampModified(Date timestampModified) {
        this.timestampModified = timestampModified;
    }
    
    

}
