/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.data.util;

import java.util.List; 
import java.util.Map;
import org.apache.commons.lang3.StringUtils; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;  
import se.nrm.dina.datamodel.EntityBean;

/**
 *
 * @author idali
 */
public class NamedQueries {
     
    private final Logger logger = LoggerFactory.getLogger(this.getClass());   
    
    private static NamedQueries instance = null; 

    public static synchronized NamedQueries getInstance() {
        if (instance == null) {
            instance = new NamedQueries();
        }
        return instance;
    }

    public String createQueryFindAllWithSearchCriteria(String entityName,
                                                        Class clazz,
                                                        int offset,
                                                        int minid,
                                                        int maxid,
                                                        List<String> orderBy,
                                                        Map<String, String> criteria) {
 
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT e From ");
        sb.append(entityName);
        sb.append(" e ");

        if (maxid > 0) {
            minid = minid > offset ? minid : offset;
            sb.append(buildConditions(clazz,   minid, maxid, criteria));
        } else if (offset > 0) {
            offset = offset > minid ? offset : minid;
            sb.append(buildConditions(clazz, offset, criteria));
        } else if (criteria != null && !criteria.isEmpty()) {
            sb.append(buildConditions(clazz, criteria));
        }

        if (orderBy != null && !orderBy.isEmpty()) {
            sb.append(buildOrderByString(clazz, orderBy));
        }

        logger.info(sb.toString());

        return sb.toString();

    }

    private String buildConditions(Class clazz, int minid, int maxid, Map<String, String> criteria) {

        EntityBean bean = Util.getInstance().createNewInstance(clazz.getSimpleName());
        String idFieldName = Util.getInstance().getIDFieldName(bean);

        StringBuilder sb = new StringBuilder();
        sb.append("WHERE e.");
        sb.append(idFieldName);
        sb.append(" BETWEEN ");
        sb.append(minid);
        sb.append(" AND ");
        sb.append(maxid);

        if (criteria == null || criteria.isEmpty()) {
            return sb.toString().trim();
        } else { 
            sb.append(" AND ");
            sb.append(buildSearchCriteria(clazz, criteria));
            return sb.toString();
        } 
    }

    private String buildConditions(Class clazz, int offset, Map<String, String> criteria) {

        EntityBean bean = Util.getInstance().createNewInstance(clazz.getSimpleName());
        String idFieldName = Util.getInstance().getIDFieldName(bean);

        StringBuilder sb = new StringBuilder();
        sb.append("WHERE e.");
        sb.append(idFieldName);
        sb.append(" >= ");
        sb.append(offset);

        if (criteria == null || criteria.isEmpty()) {
            return sb.toString().trim();
        } else { 
            sb.append(" AND ");
            sb.append(buildSearchCriteria(clazz, criteria));
            return sb.toString();
        } 
    }
    
    private String buildConditions(Class clazz, Map<String, String> criteria) {
        StringBuilder sb = new StringBuilder();
        sb.append("WHERE"); 
        sb.append(buildSearchCriteria(clazz, criteria));
         
        return sb.toString();
    }
    
    private String buildSearchCriteria(Class clazz, Map<String, String> criteria) {
        
        StringBuilder sb = new StringBuilder();
        criteria.entrySet()
                .stream()
                .forEach(entry -> {
                    sb.append(" e.");
                    sb.append(entry.getKey());
                    if (Util.getInstance().isEntity(clazz, entry.getKey())) {
                        sb.append(".");
                        sb.append(Util.getInstance().getIDFieldName(Util.getInstance().getEntity(clazz, entry.getKey())));
//                    } else if(Util.getInstance().isCollection(clazz, entry.getKey())) {
//                        String entityName = entry.getKey().replace("List", ""); 
//                        EntityBean bean = Util.getInstance().createNewInstance(Util.getInstance().reformClassName(entityName));
//                        sb.append(".");
//                        sb.append(Util.getInstance().getIDFieldName(bean));
                    }
                    sb.append(" = :");
                    sb.append(entry.getKey());
                    sb.append(" AND ");
                });
        return StringUtils.substringBeforeLast(sb.toString(), " AND");
    }
    
    private String buildOrderByString(Class clazz, List<String> list) {
         
        logger.info("buildOrderByString : {} -- {}", clazz, list);
         
        StringBuilder sb = new StringBuilder();
        sb.append(" ORDER BY ");
        list.stream()
                .filter(l -> Util.getInstance().validateFields(clazz, l))
                .forEach(l -> {
                    sb.append("e.");
                    sb.append(l);
                    sb.append(", ");
                });
         
        return StringUtils.substringBeforeLast(sb.toString(), ","); 
    }
    
    public String createNamedQueryFindTotalCount(String entityName) {

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT COUNT(e) FROM "); 
        sb.append(entityName);
        sb.append(" e"); 
        
        return sb.toString();
    }

}
