/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.data.service.util;

import java.util.Date;

/**
 *
 * @author idali
 */
public class Util {
    
    private final static String SUBSPECIES = "subspecies";
    private final static String SPECIES ="species";
    private final static String GENUS = "genus";
    private final static String FAMILY = "family";
    private final static String ORDER = "order";
    private final static String CLAZZ = "class";
    private final static String PHYLUM = "phylum";
    private final static String KINGDOM = "kingdom";
    private final static String LIFE = "life";

    public String dateToString(Date date) {
        return null;
    }

    public static String getRankName(int rankId) {

        switch (rankId) {
            case 230:
                return SUBSPECIES;
            case 220:
                return SPECIES;
            case 180:
                return GENUS;
            case 140:
                return FAMILY;
            case 100:
                return ORDER;
            case 60:
                return CLAZZ;
            case 30:
                return PHYLUM;
            case 10:
                return KINGDOM;
            case 0:
                return LIFE;
            default:
                return SPECIES;
        }
    }
}
