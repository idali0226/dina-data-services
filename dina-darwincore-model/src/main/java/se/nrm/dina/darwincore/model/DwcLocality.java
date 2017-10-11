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
@XmlType(name="",propOrder={"localityId","continent","country","countryCode","stateProvince","county","locality","higherGeography",
                            "decimalLatitude","decimalLongitude","geodeticDatum","coordinateUncertaintyInMeters",
                            "georeferenceSources","minimumElevationInMeters","maximumElevationInMeters",
                            "elevationAccuracy","startDepth","endDepth"})
public class DwcLocality implements DarwinCoreInterface, Serializable {
     
    private String localityId; 
    private String country; 
    private String countryCode;
    private String stateProvince;
    private String county;
    private String continent;
    private String locality;
    private String higherGeography;
    private String decimalLatitude;
    private String decimalLongitude;
    private String geodeticDatum;
    private String coordinateUncertaintyInMeters;
    private String georeferenceSources;
    private String minimumElevationInMeters;
    private String maximumElevationInMeters;
    private String elevationAccuracy;
    private String startDepth;
    private String endDepth;

    @XmlElement(name="dwc:country") 
    public String getCountry() {
        return country;
    }
 
    public void setCountry(String country) {
        this.country = country;
    }

    @XmlElement(name="dwc:countryCode") 
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @XmlElement(name="dwc:locationID") 
    public String getLocalityId() {
        return localityId;
    }

    public void setLocalityId(String localityId) {
        this.localityId = localityId;
    }

    @XmlElement(name="dwc:stateProvince") 
    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    @XmlElement(name="dwc:county")
    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @XmlElement(name="dwc:continent") 
    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
    
    
    
    @XmlElement(name="dwc:locality") 
    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    @XmlElement(name="dwc:higherGeography")
    public String getHigherGeography() {
        return higherGeography;
    }

    public void setHigherGeography(String higherGeography) {
        this.higherGeography = higherGeography;
    }
     
    @XmlElement(name="dwc:coordinateUncertaintyInMeters") 
    public String getCoordinateUncertaintyInMeters() {
        return coordinateUncertaintyInMeters;
    }

    public void setCoordinateUncertaintyInMeters(String coordinateUncertaintyInMeters) {
        this.coordinateUncertaintyInMeters = coordinateUncertaintyInMeters;
    }

    @XmlElement(name="dwc:decimalLatitude") 
    public String getDecimalLatitude() {
        return decimalLatitude;
    }

    public void setDecimalLatitude(String decimalLatitude) {
        this.decimalLatitude = decimalLatitude;
    }

    @XmlElement(name="dwc:decimalLongitude") 
    public String getDecimalLongitude() {
        return decimalLongitude;
    }

    public void setDecimalLongitude(String decimalLongitude) {
        this.decimalLongitude = decimalLongitude;
    }

    @XmlElement(name="dwc:geodeticDatum") 
    public String getGeodeticDatum() {
        return geodeticDatum;
    }

    public void setGeodeticDatum(String geodeticDatum) {
        this.geodeticDatum = geodeticDatum;
    }

    @XmlElement(name="dwc:elevationAccuracy") 
    public String getElevationAccuracy() {
        return elevationAccuracy;
    }

    public void setElevationAccuracy(String elevationAccuracy) {
        this.elevationAccuracy = elevationAccuracy;
    }
 
 

    @XmlElement(name="dwc:endDepth") 
    public String getEndDepth() {
        return endDepth;
    }

    public void setEndDepth(String endDepth) {
        this.endDepth = endDepth;
    }

    @XmlElement(name="dwc:georeferenceSources") 
    public String getGeoreferenceSources() {
        return georeferenceSources;
    }

    public void setGeoreferenceSources(String georeferenceSources) {
        this.georeferenceSources = georeferenceSources;
    }

    @XmlElement(name="dwc:maximumElevationInMeters") 
    public String getMaximumElevationInMeters() {
        return maximumElevationInMeters;
    }

    public void setMaximumElevationInMeters(String maximumElevationInMeters) {
        this.maximumElevationInMeters = maximumElevationInMeters;
    }

    @XmlElement(name="dwc:minimumElevationInMeters") 
    public String getMinimumElevationInMeters() {
        return minimumElevationInMeters;
    }

    public void setMinimumElevationInMeters(String minimumElevationInMeters) {
        this.minimumElevationInMeters = minimumElevationInMeters;
    }

    @XmlElement(name="dwc:startDepth") 
    public String getStartDepth() {
        return startDepth;
    }

    public void setStartDepth(String startDepth) {
        this.startDepth = startDepth;
    }  
    
    
}
