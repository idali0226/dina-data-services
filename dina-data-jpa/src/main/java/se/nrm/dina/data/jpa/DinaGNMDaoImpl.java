/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.data.jpa;

import java.io.Serializable;
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
import se.nrm.dina.data.util.QueryHelpClass;
import se.nrm.dina.data.util.Util;
import se.nrm.dina.datamodel.EntityBean;
import se.nrm.dina.datamodel.Geoname;
import se.nrm.dina.datamodel.Recordsetitem;
import se.nrm.dina.datamodel.Sppermission;
import se.nrm.dina.datamodel.Workbenchdataitem;
import se.nrm.dina.datamodel.Workbenchrow;
import se.nrm.dina.datamodel.Workbenchrowimage;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DinaGNMDaoImpl<T extends EntityBean> implements DinaGNMDao<T>, Serializable {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PersistenceContext(unitName = "jpaGnmPU")                  //  persistence unit connect to production database  
    private EntityManager entityManager;

    public DinaGNMDaoImpl() {

    }

    public DinaGNMDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
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
    public boolean updateByJPQL(String jpql) {
        Query query = entityManager.createQuery(jpql);
 
        int updated = query.executeUpdate();
        return updated == 1;
    }

    @Override
    public void delete(T entity) {
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
    public T getEntityByJPQL(String jpql) {
        Query query = entityManager.createQuery(jpql);
        try {
            return (T)query.getSingleResult();
        } catch (javax.persistence.NoResultException | javax.persistence.NonUniqueResultException ex) {
            logger.warn(ex.getMessage());
            return null;                        // if no result, return null
        }
    }

    @Override
    public int getCountByJPQL(T bean, String jpql) {
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
    public T getEntityByNamedQuery(String namedQuery, Map<String, Object> conditions) {
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
    public List<T> getAllEntitiesByJPQL(String jpql) {
        Query query = entityManager.createQuery(jpql);
        return query.getResultList(); 
    }

    @Override
    public List<Object[]> getAllByNativeQuery(String query) {
        Query q = entityManager.createNativeQuery(query);
        return q.getResultList(); 
    } 

    @Override
    public List<String> getStringListByJPQL(String jpql) {

        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
        return query.getResultList();
    }

    @Override
    public Object[] getListOfDataByJPQL(String jpql) {
        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        try {
            return query.getSingleResult();
        } catch (NoResultException | NonUniqueResultException ex) {
            logger.info(ex.getMessage() + " ... " + jpql);
        }
        return null;
    }

    @Override
    public List<Object[]> getSearchResultsByJPQL(String jpql) {
        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        return query.getResultList();
    }
}
