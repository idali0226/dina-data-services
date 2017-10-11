package se.nrm.dina.darwincore.model;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author idali
 */
@XmlRootElement
public class DarwinCoreError implements Serializable {
    
    private String responseCode;
    private List<String> errorMsgs;

    @XmlElement(name="errors") 
    public List<String> getErrorMsgs() {
        return errorMsgs;
    }

    public void setErrorMsgs(List<String> errorMsgs) {
        this.errorMsgs = errorMsgs;
    }
 
    @XmlElement(name="code") 
    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    } 
}
