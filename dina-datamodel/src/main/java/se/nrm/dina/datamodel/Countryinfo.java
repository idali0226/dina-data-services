/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.datamodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement; 
import se.nrm.dina.datamodel.util.Util;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "countryinfo")
@XmlRootElement 
@NamedQueries({
    @NamedQuery(name = "Countryinfo.findAll", query = "SELECT c FROM Countryinfo c"), 
    @NamedQuery(name = "Countryinfo.findByName", query = "SELECT c FROM Countryinfo c WHERE c.name = :name"),
    @NamedQuery(name = "Countryinfo.findByCapital", query = "SELECT c FROM Countryinfo c WHERE c.capital = :capital"), 
    @NamedQuery(name = "Countryinfo.findByPopulation", query = "SELECT c FROM Countryinfo c WHERE c.population = :population"),
    @NamedQuery(name = "Countryinfo.findByContinent", query = "SELECT c FROM Countryinfo c WHERE c.continent = :continent"), 
    @NamedQuery(name = "Countryinfo.findByCurrencycode", query = "SELECT c FROM Countryinfo c WHERE c.currencycode = :currencycode"),
    @NamedQuery(name = "Countryinfo.findByCurrencyname", query = "SELECT c FROM Countryinfo c WHERE c.currencyname = :currencyname"), 
    @NamedQuery(name = "Countryinfo.findByPostalformat", query = "SELECT c FROM Countryinfo c WHERE c.postalformat = :postalformat"),
    @NamedQuery(name = "Countryinfo.findByLanguages", query = "SELECT c FROM Countryinfo c WHERE c.languages = :languages"), 
    @NamedQuery(name = "Countryinfo.findByNeighbors", query = "SELECT c FROM Countryinfo c WHERE c.neighbors = :neighbors")})
public class Countryinfo implements EntityBean, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false) 
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;

    
    @Size(max = 2)
    @Column(name = "iso_alpha2")
    private String isoAlpha2;
    
    @Size(max = 3)
    @Column(name = "iso_alpha3")
    private String isoAlpha3;
    
    @Column(name = "iso_numeric")
    private Integer isoNumeric;
    
    @Size(max = 3)
    @Column(name = "fips_code")
    private String fipsCode;
    

    @Size(max = 255)
    @Column(name = "capital")
    private String capital;
    
    @Size(max = 16)
    @Column(name = "areainsqkm")
    private String areainsqkm;
    
    @Size(max = 16)
    @Column(name = "population")
    private String population;
    
    @Size(max = 2)
    @Column(name = "continent")
    private String continent;
    
    @Size(max = 32)
    @Column(name = "tld")
    private String tld;
    
    @Size(max = 3)
    @Column(name = "currencycode")
    private String currencycode;
    
    @Size(max = 32)
    @Column(name = "currencyname")
    private String currencyname;
    
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 32)
    @Column(name = "phone")
    private String phone;
    
    @Size(max = 128)
    @Column(name = "postalformat")
    private String postalformat;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "postalregex")
    private String postalregex;
    
    @Size(max = 255)
    @Column(name = "languages")
    private String languages;
    
    @Column(name = "geonameId")
    private Integer geonameId;
    
    @Size(max = 255)
    @Column(name = "neighbors")
    private String neighbors;

    public Countryinfo() {
    }

    public Countryinfo(String name) {
        this.name = name;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + name;
    }

    @Override
    public int getEntityId() {
        return 0;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getIsoAlpha2() {
        return isoAlpha2;
    }

    public void setIsoAlpha2(String isoAlpha2) {
        this.isoAlpha2 = isoAlpha2;
    }

    public String getIsoAlpha3() {
        return isoAlpha3;
    }

    public void setIsoAlpha3(String isoAlpha3) {
        this.isoAlpha3 = isoAlpha3;
    }

    public Integer getIsoNumeric() {
        return isoNumeric;
    }

    public void setIsoNumeric(Integer isoNumeric) {
        this.isoNumeric = isoNumeric;
    }

    public String getFipsCode() {
        return fipsCode;
    }

    public void setFipsCode(String fipsCode) {
        this.fipsCode = fipsCode;
    }



    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getAreainsqkm() {
        return areainsqkm;
    }

    public void setAreainsqkm(String areainsqkm) {
        this.areainsqkm = areainsqkm;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getTld() {
        return tld;
    }

    public void setTld(String tld) {
        this.tld = tld;
    }

    public String getCurrencycode() {
        return currencycode;
    }

    public void setCurrencycode(String currencycode) {
        this.currencycode = currencycode;
    }

    public String getCurrencyname() {
        return currencyname;
    }

    public void setCurrencyname(String currencyname) {
        this.currencyname = currencyname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostalformat() {
        return postalformat;
    }

    public void setPostalformat(String postalformat) {
        this.postalformat = postalformat;
    }

    public String getPostalregex() {
        return postalregex;
    }

    public void setPostalregex(String postalregex) {
        this.postalregex = postalregex;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public Integer getGeonameId() {
        return geonameId;
    }

    public void setGeonameId(Integer geonameId) {
        this.geonameId = geonameId;
    }

    public String getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(String neighbors) {
        this.neighbors = neighbors;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Countryinfo)) {
            return false;
        }
        Countryinfo other = (Countryinfo) object;
        return !((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Countryinfo[ name=" + name + " ]";
    }
    
}
