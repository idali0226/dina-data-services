package se.nrm.dina.darwincore.model; 

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType; 

/**
 *
 * @author idali
 */
@XmlRootElement 
@XmlType(name="",propOrder={"eventId","eventDate","startDayOfYear","endDayOfYear","year","month","day",
                            "verbatimEventDate","habitat","fieldNumber","fieldNotes","collector","remarks","locationID"})
public class DwcEvent implements DarwinCoreInterface, Serializable {
    
    private String eventId;
    private String eventDate;
    private String startDayOfYear;
    private String endDayOfYear;
    private String year;
    private String month;
    private String day;
    private String verbatimEventDate;
    private String habitat;
    private String fieldNumber;
    private String fieldNotes;
    private String collector;
    private String locationID;
    private String remarks;
    
    private List<String> collectors;
    

    @XmlElement(name="dwc:day") 
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @XmlElement(name="dwc:endDayOfYear") 
    public String getEndDayOfYear() {
        return endDayOfYear;
    }

    public void setEndDayOfYear(String endDayOfYear) {
        this.endDayOfYear = endDayOfYear;
    }

    @XmlElement(name="dwc:eventDate") 
    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    @XmlElement(name="dwc:eventID") 
    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    @XmlElement(name="dwc:fieldNotes") 
    public String getFieldNotes() {
        return fieldNotes;
    }

    public void setFieldNotes(String fieldNotes) {
        this.fieldNotes = fieldNotes;
    }

    @XmlElement(name="dwc:habitat") 
    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    @XmlElement(name="dwc:locationID") 
    public String getLocationID() {
        return locationID;
    }
 
    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    @XmlElement(name="dwc:month") 
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @XmlElement(name="dwc:startDayOfYear") 
    public String getStartDayOfYear() {
        return startDayOfYear;
    }

    public void setStartDayOfYear(String startDayOfYear) {
        this.startDayOfYear = startDayOfYear;
    }

    @XmlElement(name="dwc:verbatimEventDate") 
    public String getVerbatimEventDate() {
        return verbatimEventDate;
    }

    public void setVerbatimEventDate(String verbatimEventDate) {
        this.verbatimEventDate = verbatimEventDate;
    }

    @XmlElement(name="dwc:year") 
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @XmlElement(name="dwc:fieldNumber")
    public String getFieldNumber() {
        return fieldNumber;
    }

    public void setFieldNumber(String fieldNumber) {
        this.fieldNumber = fieldNumber;
    }

    @XmlElement(name="dwc:recordedBy")
    public String getCollector() { 
        return collector;
    }

    public void setCollector(String collector) {
        
        this.collector = collector;
    }
     
    @XmlTransient 
    public List<String> getCollectors() {
        return collectors;
    }

    public void setCollectors(List<String> collectors) {
        this.collectors = collectors;
    } 
     
    @XmlElement(name="dwc:eventRemarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    } 
}
