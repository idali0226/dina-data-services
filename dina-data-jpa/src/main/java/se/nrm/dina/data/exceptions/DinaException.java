/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.data.exceptions;
 
import javax.ejb.ApplicationException;

/**
 *
 * @author idali
 */
@ApplicationException
public class DinaException extends RuntimeException  {
        
    private int errorCode;
    
    public DinaException() {
    }

    public DinaException(String s) {
        super(s);
    }
 
    public DinaException(String s, int errorCode) {
        super(s);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    } 
}
