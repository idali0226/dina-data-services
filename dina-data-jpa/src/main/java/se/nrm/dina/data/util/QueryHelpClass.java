/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.data.util;

import java.util.Map;
import java.util.Set;
import javax.persistence.Query;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author idali
 */
public class QueryHelpClass {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private static QueryHelpClass instance = null;

    public static synchronized QueryHelpClass getInstance() {
        if (instance == null) {
            instance = new QueryHelpClass();
        }
        return instance;
    }

    /**
     * Build a namedQuery with parameters
     *
     * @param query
     * @param clazz 
     * @param parameters
     * @return Query
     */
    public Query createQuery(Query query, Class clazz, Map<String, String> parameters) {
        
        if (parameters != null) {
            parameters.entrySet()
                    .stream()
                    .forEach((entry) -> {
                       String fieldName = entry.getKey();
                       if(Util.getInstance().isIntField(clazz, fieldName)) {
                            query.setParameter(entry.getKey(), Integer.parseInt(entry.getValue()));
                        } else if (Util.getInstance().isEntity(clazz, fieldName)) {
                            query.setParameter(entry.getKey(), Integer.parseInt(entry.getValue()));
                        } else {
                            query.setParameter((String) entry.getKey(), entry.getValue());
                        }
                    });
        }
        return query;
    }

    /**
     * Method handles ConstraintViolationException. It logs exception messages,
     * entity properties with invalid values.
     *
     * @param e
     * @return 
     */
    public String handleConstraintViolation(ConstraintViolationException e) {

        StringBuilder sb = new StringBuilder();

        Set<ConstraintViolation<?>> cvs = e.getConstraintViolations();
        cvs.stream().map((cv) -> {
            logger.info("------------------------------------------------");
            return cv;
        }).map((cv) -> {
            logger.info("Violation: {}", cv.getMessage());
            return cv;
        }).map((cv) -> {
            sb.append("Violation:");
            sb.append(cv.getMessage());
            return cv;
        }).map((cv) -> {
            logger.info("Entity: {}", cv.getRootBeanClass().getSimpleName());
            return cv;
        }).map((cv) -> {
            sb.append(" - Entity: ");
            sb.append(cv.getRootBeanClass().getSimpleName());
            return cv;
        }).map((cv) -> {
            if (cv.getLeafBean() != null && cv.getRootBean() != cv.getLeafBean()) {
                logger.info("Embeddable: {}", cv.getLeafBean().getClass().getSimpleName());
                sb.append(" - Embeddable: ");
                sb.append(cv.getLeafBean().getClass().getSimpleName());
            }
            return cv;
        }).map((cv) -> {
            logger.info("Attribute: {}", cv.getPropertyPath());
            return cv;
        }).map((cv) -> {
            sb.append(" - Attribute: ");
            sb.append(cv.getPropertyPath());
            return cv;
        }).map((cv) -> {
            logger.info("Invalid value: {}", cv.getInvalidValue());
            return cv;
        }).forEach((cv) -> {
            sb.append(" - Invalid value: ");
            sb.append(cv.getInvalidValue());
        });
        return sb.toString();
    } 
    
}
