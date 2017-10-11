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
@XmlType(name="",propOrder={"resourceRelationshipID","resourceID","relatedResourceID","relationshipOfResource"})
public class DwcResourceRelationship implements DarwinCoreInterface, Serializable {
    
    private String resourceRelationshipID;
    private String resourceID;
    private String relatedResourceID;
    private String relationshipOfResource;

    @XmlElement(name="dwc:relatedResourceID") 
    public String getRelatedResourceID() {
        return relatedResourceID;
    }

    public void setRelatedResourceID(String relatedResourceID) {
        this.relatedResourceID = relatedResourceID;
    }

    @XmlElement(name="dwc:relationshipOfResource") 
    public String getRelationshipOfResource() {
        return relationshipOfResource;
    }

    public void setRelationshipOfResource(String relationshipOfResource) {
        this.relationshipOfResource = relationshipOfResource;
    }

    @XmlElement(name="dwc:resourceID") 
    public String getResourceID() {
        return resourceID;
    }

    public void setResourceID(String resourceID) {
        this.resourceID = resourceID;
    }

    @XmlElement(name="dwc:resourceRelationshipID") 
    public String getResourceRelationshipID() {
        return resourceRelationshipID;
    }

    public void setResourceRelationshipID(String resourceRelationshipID) {
        this.resourceRelationshipID = resourceRelationshipID;
    } 
}
