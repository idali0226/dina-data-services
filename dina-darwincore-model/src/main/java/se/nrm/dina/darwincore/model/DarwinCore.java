package se.nrm.dina.darwincore.model;

 
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.io.Serializable;
import java.util.List; 
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements; 
import javax.xml.bind.annotation.XmlRootElement; 

/**
 *
 * @author idali
 */ 
@XmlRootElement(name="DarwinRecordSet", namespace="http://rs.tdwg.org/dwc/dwcrecord/")  
public class DarwinCore implements Serializable {
     
    @XmlElements({
        @XmlElement(name = "dwc:Event", type = DwcEvent.class),
        @XmlElement(name = "dcterms:Location", type = DwcLocality.class),
        @XmlElement(name = "dwc:Taxon", type = DwcTaxon.class),
        @XmlElement(name = "dwc:Identification", type = DwcIdentification.class),
        @XmlElement(name = "dwc:ResourceRelationship", type = DwcResourceRelationship.class),
        @XmlElement(name = "dwc:Occurrence", type = DwcOccurrence.class)
    })
    private List<? extends DarwinCoreInterface> records;
       
    private int collectionObjectId;
    
    private DarwinCoreError error;
     
    
    public DarwinCore() {
        
    }
       
    public List<? extends DarwinCoreInterface> getRecords() {
        return records;
    }

    public void setRecords(List<DarwinCoreInterface> records) {
        this.records = records;
    }

    @XmlElement(name = "error", type = DarwinCoreError.class)
    public DarwinCoreError getError() {
        return error;
    }

    public void setError(DarwinCoreError error) {
        this.error = error;
    }

    public int getCollectionObjectId() {
        return collectionObjectId;
    }

    public void setCollectionObjectId(int collectionObjectId) {
        this.collectionObjectId = collectionObjectId;
    } 
    
}
