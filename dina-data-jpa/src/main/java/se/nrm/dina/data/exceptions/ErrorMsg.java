/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.data.exceptions;

/**
 *
 * @author idali
 */
public class ErrorMsg {
    
    private final String CLASSNAME_CONVERT_ERROR = "The entity name is wrong";

    private static ErrorMsg instance = null;

    public static synchronized ErrorMsg getInstance() {
        if (instance == null) {
            instance = new ErrorMsg();
        }
        return instance;
    } 
    
    public String getEntityNameErrorMsg() {
        return CLASSNAME_CONVERT_ERROR;
    }
    
}
