/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.datamodel.util;

/**
 *
 * @author idali
 */
public class Util {

    private final String URL_LINK = "https://www.dina-web.nrm/dina-service/dina/v0/";

    private static Util instance = null;

    public static synchronized Util getInstance() {
        if (instance == null) {
            instance = new Util();
        }
        return instance;
    }
    
    public String getURLLink(String entityName) {
        return URL_LINK + entityName + "/";
    }

}
