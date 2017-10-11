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
@XmlType(name="",propOrder={"scientificName","taxonRank","higherClassification","kingdom","phylum",
                            "clazz","order","family","genus","specificEpithet","infraspecficEpithet","identificationID"})
public class DwcTaxon implements DarwinCoreInterface, Serializable {
    
    private String scientificName;
    private String taxonRank;
    private String higherClassification;
    private String kingdom;
    private String phylum;
    private String clazz;
    private String order;
    private String family;
    private String genus;
    private String specificEpithet;
    private String infraspecficEpithet;
    private String identificationID;

    @XmlElement(name="dwc:class") 
    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    @XmlElement(name="dwc:family") 
    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    @XmlElement(name="dwc:genus") 
    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    @XmlElement(name="dwc:higherClassification") 
    public String getHigherClassification() {
        return higherClassification;
    }

    public void setHigherClassification(String higherClassification) {
        this.higherClassification = higherClassification;
    }

    @XmlElement(name="dwc:identificationID") 
    public String getIdentificationID() {
        return identificationID;
    }

    public void setIdentificationID(String identificationID) {
        this.identificationID = identificationID;
    }

    @XmlElement(name="dwc:kingdom") 
    public String getKingdom() {
        return kingdom;
    }

    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    @XmlElement(name="dwc:order") 
    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @XmlElement(name="dwc:phylum") 
    public String getPhylum() {
        return phylum;
    }

    public void setPhylum(String phylum) {
        this.phylum = phylum;
    }

    @XmlElement(name="dwc:scientificName") 
    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    @XmlElement(name="dwc:taxonRank") 
    public String getTaxonRank() {
        return taxonRank;
    }

    public void setTaxonRank(String taxonRank) {
        this.taxonRank = taxonRank;
    }

    @XmlElement(name="dwc:infraspecificEpithet") 
    public String getInfraspecficEpithet() {
        return infraspecficEpithet;
    }

    public void setInfraspecficEpithet(String infraspecficEpithet) {
        this.infraspecficEpithet = infraspecficEpithet;
    }
    
    
    

    @XmlElement(name="dwc:specificEpithet") 
    public String getSpecificEpithet() {
        return specificEpithet;
    }

    public void setSpecificEpithet(String specificEpithet) {
        this.specificEpithet = specificEpithet;
    } 
}
