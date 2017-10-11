package se.nrm.dina.darwincore.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement; 
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author idali
 */
@XmlRootElement
@XmlType(name="",propOrder={"identificationID","identifiedBy","dateIdentified","identificationQualifier","typeStatus","occurrenceID"})
public class DwcIdentification implements DarwinCoreInterface, Serializable {
    
    private String identificationID;
    private String identifiedBy;
    private String dateIdentified;
    private String identificationQualifier;
    private String occurrenceID;
    private String typeStatus;

    @XmlElement(name="dwc:dateIdentified") 
    public String getDateIdentified() {
        return dateIdentified;
    }

    public void setDateIdentified(String dateIdentified) {
        this.dateIdentified = dateIdentified;
    }

    @XmlElement(name="dwc:identificationID") 
    public String getIdentificationID() {
        return identificationID;
    }

    public void setIdentificationID(String identificationID) {
        this.identificationID = identificationID;
    }

    @XmlElement(name="dwc:identificationQualifier") 
    public String getIdentificationQualifier() {
        return identificationQualifier;
    }

    public void setIdentificationQualifier(String identificationQualifier) {
        this.identificationQualifier = identificationQualifier;
    }

    @XmlElement(name="dwc:identifiedBy") 
    public String getIdentifiedBy() {
        return identifiedBy;
    }

    public void setIdentifiedBy(String identifiedBy) {
        this.identifiedBy = identifiedBy;
    }

    @XmlElement(name="dwc:typeStatus")
    public String getTypeStatus() {
        return typeStatus;
    }

    public void setTypeStatus(String typeStatus) {
        this.typeStatus = typeStatus;
    }
    
    

    @XmlElement(name="dwc:occurrenceID") 
    public String getOccurrenceID() {
        return occurrenceID;
    }

    public void setOccurrenceID(String occurrenceID) {
        this.occurrenceID = occurrenceID;
    }
    
    
    
    
}
