/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.nrm.dina.data.jpa;

import java.io.Serializable;   
import java.util.ArrayList;
import java.util.List; 
import java.util.Map;   
import javax.ejb.Stateless;   
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;  
import javax.persistence.LockModeType;  
import javax.persistence.NoResultException; 
import javax.persistence.NonUniqueResultException;
import javax.persistence.OptimisticLockException; 
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;   
import javax.validation.ConstraintViolationException;  
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;  
import se.nrm.dina.data.exceptions.DinaException;
import se.nrm.dina.data.jpa.vo.CommonVO;
import se.nrm.dina.data.util.QueryHelpClass;
import se.nrm.dina.data.util.Util;
import se.nrm.dina.datamodel.*; 

/**
 *
 * @author idali
 * @param <T>
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DinaDaoImpl<T extends EntityBean> implements DinaDao<T>, Serializable {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PersistenceContext(unitName = "jpaPU")                  //  persistence unit connect to production database  
    private EntityManager entityManager;
 
    public DinaDaoImpl() { 
    }

    public DinaDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
  
    @Override
    public List<T> findAll(Class<T> clazz) {
//        logger.info("findAll : {}", clazz);
        
        Query query = entityManager.createNamedQuery(clazz.getSimpleName() + ".findAll"); 
        return query.getResultList(); 
    }
    
    @Override
    public List<T> findAll(Class<T> clazz, String jpql, int limit, Map<String, String> conditions) {
        logger.info("findAll : {} -- {}", jpql, conditions);
         
        Query query = entityManager.createQuery(jpql);

        try {
            query = QueryHelpClass.getInstance().createQuery(query, clazz, conditions);
            query.setMaxResults(Util.getInstance().maxLimit(limit));
            return query.getResultList();  
        } catch (Exception e) {
            logger.warn(e.getMessage());
            throw new DinaException(e.getMessage());
        }
    }
 
    @Override
    public T findById(int id, Class<T> clazz) {
        logger.info("findById - class : {} - id : {}", clazz, id);
 
         // Entity has no version can not have Optimistic lock
        if (clazz.getSimpleName().equals(Recordsetitem.class.getSimpleName())
                || clazz.getSimpleName().equals(Sppermission.class.getSimpleName())
                || clazz.getSimpleName().equals(Workbenchrow.class.getSimpleName())
                || clazz.getSimpleName().equals(Workbenchdataitem.class.getSimpleName())
                || clazz.getSimpleName().equals(Workbenchrowimage.class.getSimpleName())
                || clazz.getSimpleName().equals(Geoname.class.getSimpleName())) {

            return entityManager.find(clazz, id, LockModeType.PESSIMISTIC_WRITE);
        }

        T tmp = null;
        try {
            tmp = entityManager.find(clazz, id, LockModeType.OPTIMISTIC);
            entityManager.flush();
        } catch (OptimisticLockException ex) { 
            entityManager.refresh(tmp);
            logger.warn(ex.getMessage());
        } catch(Exception e) {
            logger.warn(e.getMessage()); 
        }  
        return tmp; 
    }

    @Override
    public T findByStringId(String id, Class<T> clazz) {
        logger.info("findByStringId - class : {} - id : {}", clazz, id); 

        T tmp = null;
        try {
            tmp = entityManager.find(clazz, id, LockModeType.NONE);
            entityManager.flush();
        } catch (OptimisticLockException ex) { 
            entityManager.refresh(tmp);
            logger.warn(ex.getMessage());
        } catch(Exception e) {
            logger.warn(e.getMessage()); 
        }  
        return tmp; 
    }


    @Override
    public T findByReference(int id, Class<T> clazz) {
        return entityManager.getReference(clazz, id);
    }
 
    @Override
    public T create(T entity) {
        logger.info("create(T) : {}", entity);

        T tmp = entity;
        try {
            entityManager.persist(entity);
            entityManager.flush();  
            
            logger.info("temp : {}", tmp);
        } catch (ConstraintViolationException e) { 
            logger.warn(e.getMessage());
            throw new DinaException(QueryHelpClass.getInstance().handleConstraintViolation(e));
        } catch (Exception e) { 
            logger.warn(e.getMessage());
        }    
        
        return tmp;
    }

    @Override
    public T merge(T entity) {
                
        logger.info("merge: {}", entity);

        T tmp = entity;
        try { 
            tmp = entityManager.merge(entity); 
            entityManager.flush();                              // this one used for throwing OptimisticLockException if method called with web service
        } catch (OptimisticLockException e) { 
            logger.warn(e.getMessage());
        } catch (ConstraintViolationException e) { 
            logger.warn(e.getMessage());
            throw new DinaException(QueryHelpClass.getInstance().handleConstraintViolation(e));
        } catch (Exception e) {  
            logger.warn(e.getMessage());
        }  
        return tmp;
    }
    
    @Override
    public boolean updateByJPQL(String jpql ) {
//        logger.info("updateByJPQL : {} ", jpql );
        Query query = entityManager.createQuery(jpql);
 
        int updated = query.executeUpdate();
        return updated == 1;
    }

    @Override
    public int getCountByJPQL(T bean, String jpql) {
        
//        logger.info("getCountByJPQL: {} - {}", bean, jpql);

        Number number = 0;
        Query query = entityManager.createQuery(jpql);
        try {
            if (bean != null) {
                query.setParameter(bean.getClass().getSimpleName().toLowerCase(), bean);
            }
            number = (Number) query.getSingleResult();
            
        } catch (IllegalArgumentException e) {
            logger.warn(e.getMessage());
        }
        return number.intValue();
    }

    @Override
    public int getCountByQuery(String strQuery) {

        logger.info("getCountByQuery: {} ", strQuery);
        
        Number number;
        Query query = entityManager.createQuery(strQuery);
        
        try {
            number = (Number) query.getSingleResult();
        } catch (Exception e) {
            return 0;
        }  
        return number.intValue();
    }
 

    @Override
    public void delete(T entity) {
//        logger.info("delete - {}", entity);

        try {
            entityManager.remove(entity);
            entityManager.flush();                              // this is needed for throwing internal exception
        } catch (ConstraintViolationException e) { 
            logger.warn(e.getMessage());
        } catch (Exception e) { 
            logger.warn(e.getMessage());
        }
    }
 
    @Override
    public String getLastCatalogunumber(String jpql) {

//        logger.info("getLastRecord: {}", jpql);
        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
        query.setMaxResults(1);

        try {
            return query.getSingleResult();
        } catch (javax.persistence.NoResultException | javax.persistence.NonUniqueResultException ex) {
            logger.warn(ex.getMessage());
            return null;                        // if no result, return null
        } 
    }
 
    @Override
    public List<Object[]> getSearchResultsByJPQL(String jpql) {
//        logger.info("jpql : {}", jpql);
        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        return query.getResultList();  
    }
 
    @Override
    public List<String> getStringListByJPQL(String jpql) {
        
//        logger.info("getStringListByJPQL : {}", jpql);
        
        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
        return query.getResultList();  
    }
 
    @Override
    public List<Integer> getIntListByJPQL(String jpql) {
        
//        logger.info("getStringListByJPQL : {}", jpql);
        
        TypedQuery<Integer> query = entityManager.createQuery(jpql, Integer.class);
        return query.getResultList();  
    }
 
    @Override
    public String getSingleValueByJPQL(String jpql) {
//        logger.info("getSingleValueByJPQL : {}", jpql);
        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);

        try {
            return query.getSingleResult();
        } catch (javax.persistence.NoResultException | javax.persistence.NonUniqueResultException ex) {
            logger.warn(ex.getMessage());
            return null;                        // if no result, return null
        } 
    }
    
    
    @Override
    public int getSingleIdByJPQL(String jpql) {
//        logger.info("getSingleValueByJPQL : {}", jpql);
        TypedQuery<Integer> query = entityManager.createQuery(jpql, Integer.class);
        query.setMaxResults(1); 
        try {
            return query.getSingleResult();
        } catch(javax.persistence.NoResultException | javax.persistence.NonUniqueResultException ex) {
            return 0;
        } 
    }

    @Override
    public Object[] getListOfDataByJPQL(String jpql) {

//        logger.info("getListOfDataByJPQL : {}", jpql);

        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);  
        try {
            return query.getSingleResult(); 
        } catch (NoResultException | NonUniqueResultException ex) {
            logger.info(ex.getMessage() + " ... " + jpql);
        }
        return null;
    }
    
    @Override
    public List<CommonVO> getListByJPQL(String jpql) {

//        logger.info("getTextListByJPQL: {}", jpql);
         
        TypedQuery<CommonVO> query = entityManager.createQuery(jpql, CommonVO.class);
        return query.getResultList(); 
    }

    @Override
    public List<T> getAllEntitiesByJPQL(String jpql) {
//        logger.info("getAllEntitiesByJPQL - jpql: {}", jpql);

        Query query = entityManager.createQuery(jpql);
        return query.getResultList(); 
    } 
    
         
    @Override
    public T getEntityByJPQL(String jpql) {

//        logger.info("getEntityByJPQL - jpql: {}", jpql);

        Query query = entityManager.createQuery(jpql);
        try {
            return (T)query.getSingleResult();
        } catch (javax.persistence.NoResultException | javax.persistence.NonUniqueResultException ex) {
            logger.warn(ex.getMessage());
            return null;                        // if no result, return null
        }
    }
    
    @Override
    public T getEntityByNamedQuery(String namedQuery, Map<String, Object> conditions) {
        
//        logger.info("getEntityByNamedQuery -  {} -- {}", namedQuery, conditions);
 
        Query query = entityManager.createNamedQuery(namedQuery);
        conditions.entrySet().stream().forEach((entry) -> {
            query.setParameter(entry.getKey(), entry.getValue());
        });
          
        try {
            T bean = (T) query.getSingleResult();
            return  bean;
        } catch (NoResultException ex) {
            logger.warn(ex.getMessage());
            return null;
        } 
    }
 
    @Override
    public List getAllEntitiesByNamedQuery(String namedQuery, Map<String, Object> parameters) {

//        logger.info("getAllEntitiesByNamedQuery - parameters: {}", parameters);

        List<T> list = createNamedQuery(namedQuery, parameters).getResultList(); 

        return list;
    }
     
    
    @Override
    public List<Object[]> getAllByNativeQuery(String query, int start) {

//        logger.info("getAllByNativeQuery - {}", query);

        Query q = entityManager.createNativeQuery(query);
        q.setFirstResult(start);
        q.setMaxResults(1000);
        List<Object[]> results = q.getResultList(); 
        
        entityManager.flush();
        entityManager.clear();   
        
        return results;
    }
    
    @Override
    public List<Object[]> getAllByNativeQuery(String query) {

//        logger.info("getAllByNativeQuery - {}", query);

        Query q = entityManager.createNativeQuery(query); 
        List<Object[]> results = q.getResultList(); 
        
        entityManager.flush();
        entityManager.clear();   
        
        return results;
    }
 
    @Override
    public Object[] getByNativeQuery(String query) {

//        logger.info("getByNativeQuery - {}", query);
        
        Query q = entityManager.createNativeQuery(query); 
        try {
            List<Object[]> list = q.getResultList();
            if(list != null && !list.isEmpty()) {
                return list.get(0);
            }  
        } catch (NoResultException ex) {
            logger.info(ex.getMessage());
        } 
        return null; 
    }
    
//    /**
//     * 
//     * @param fullName
//     * @param treeDefId
//     * @return 
//     */ 
//    @Override
//    public String getTaxonHighClassification(String fullName, int treeDefId) { 
//        Query query = entityManager.createNamedQuery("Taxon.findByFullNameAndDefinition");
//        query.setParameter("fullName", fullName);
//        query.setParameter("taxonTreeDefId", treeDefId);  
//        
//        Taxon taxon; 
//        try {
//            taxon = (Taxon) query.getSingleResult();
//        } catch (javax.persistence.NoResultException | javax.persistence.NonUniqueResultException ex) {
//            logger.error(ex.getMessage());
//            return null;                        // if no result, return null
//        }  
//        return taxon.getHighClassification();
//    }

    /**
     * Build a namedQuery with parameters
     * @param namedQuery
     * @param parameters
     * @return 
     */
    private Query createNamedQuery(String namedQuery, Map<String, Object> parameters) { 
        Query query = entityManager.createNamedQuery(namedQuery);

        if (parameters != null) {
            parameters.entrySet().stream().forEach((entry) -> {
                query.setParameter((String) entry.getKey(), entry.getValue());
            });
        }
        return query;
    }


    
    @Override
    public void deleteByQuery(String className, String primaryKey, int id) {
        logger.info("deleteByQuery");
        
        StringBuilder sb = new StringBuilder(); 
        sb.append("DELETE FROM ");
        sb.append(className);
        sb.append(" o WHERE o.");
        sb.append(primaryKey);
        sb.append(" = ");
        sb.append(id); 
        
        Query query = entityManager.createQuery(sb.toString());
        query.executeUpdate();
    }
    
    
//    @Override
//    public List<Loan> getOverDueLoans() {
//         
//        
//        java.util.Date today = new java.util.Date();
//        java.sql.Date sqlToday = new java.sql.Date(today.getTime());
//         
//        String jpql = "SELECT l FROM Loan l WHERE l.currentDueDate <= '" +  sqlToday + "' AND l.isClosed = 0"; 
//        
//        
//        return entityManager.
//    } 
    

    @Override
    public void deleteByJPQL() {
        logger.info("deleteByJPQL"); 
  
        Collectionobject co = new Collectionobject();
       
        
        List<String> list = new ArrayList();
        
        list.add("DELETE FROM Collectionobjectattr attr WHERE attr.collectionMemberId = 655361");                        // c-file
        list.add("DELETE FROM Collectionobjectattr attr WHERE attr.collectionMemberId = 688128");                        // d-file
        list.add("DELETE FROM Attributedef def WHERE def.discipline = 655360");
        list.add("DELETE FROM Preparation p WHERE p.collectionMemberId = 688128");                                         // d-file only
        list.add("DELETE FROM Determination d WHERE d.collectionMemberId = 655361");                                   // c-file
        list.add("DELETE FROM Determination d WHERE d.collectionMemberId = 688128");                                   // d-file
        list.add("DELETE FROM Collectionobject co WHERE co.collectionMemberId = 655361");
        list.add("DELETE FROM Collectionobject co WHERE co.collectionMemberId = 688128");
        list.add("DELETE FROM Taxon t WHERE t.definition=11 AND t.text5='exceltest'");
        list.add("DELETE FROM Preptype p WHERE p.collection.userGroupScopeId = 655361");
        list.add("DELETE FROM Preptype p WHERE p.collection.userGroupScopeId = 688128");  
        
        list.stream().map((strQry) -> entityManager.createQuery(strQry)).forEach((query) -> {
            query.executeUpdate();
        }); 
    } 
}
