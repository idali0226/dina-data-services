/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.data.jpa;

import java.util.List;
import java.util.Map;
import se.nrm.dina.datamodel.EntityBean;

/**
 *
 * @author idali
 * @param <T>
 */
public interface DinaGNMDao<T extends EntityBean> {
    
    /**
     * Saves a transient or persistent {@link BaseEntity} to the database. 
     * 
     * @param entity the entity to save.
     * @return a persistent copy of the entity.
     */
    public T create(T entity);
    
    
    /**
     * Merges a transient {@link BaseEntity} to the database. 
     * 
     * @param entity the entity to merge.
     * @return a persistent copy of the entity.
     */
    public T merge(T entity);
    
    /**
     * A generic method to update an entity by query.
     * @param jpql 
     * @return  
     */
    public boolean updateByJPQL(String jpql );
    
    /**
     * Deletes a {@link BaseEntity} from the database. If the delete
     * was successful, the entity's ID will be null.
     * 
     * @param entity the entity to delete. 
     */
    public void delete(T entity);
    
    
    public void deleteByQuery(String className, String primaryKey, int id);
    
    /**
     * Finds a {@link BaseEntity} by its database ID.
     * @param id the database id of the entity we want.
     * @param clazz
     * 
     * @return the instance of the entity from the database with the given id.
     */
    public T findById(int id, Class<T> clazz);
     
    public T findByStringId(String id, Class<T> clazz);
    
    
    /**
     * Find an instance whose state may be lazily fetched
     * 
     * @param id the database id of the entity we want.
     * @param clazz
     * 
     * @return the instance of the entity from the database with the given id.
     */ 
    public T findByReference(int id, Class<T> clazz);
     
    /**
     * Finds all the instances of an entity in the database.
     * @param clazz
     * @return a <code>List</code> of all the entities in the database.
     */
    public List<T> findAll(Class<T> clazz);
 
    public List<T> findAll(Class<T> clazz, String entityName, int limit, Map<String, String> conditions);
    
    /**
     * Find an instance by given jpql
     *
     * @param jpql
     * @return T
     */
    public T getEntityByJPQL(String jpql);

    
    /**
     * Method to get a total count of an entity in database
     * 
     * @param bean
     * @param jpql
     * @return  
     */
    public int getCountByJPQL(T bean, String jpql);
    
    public int getCountByQuery(String strQuery);

    /**
     * Find an instance by given namedQuery
     *
     * @param namedQuery
     * @param conditions
     * @return T
     */
    public T getEntityByNamedQuery(String namedQuery, Map<String, Object> conditions);

    /**
     * Find all the instances of an entity in the database by JPQL
     *
     * @param jpql
     * @return a <code>List</code> of all the instances of an entity in the
     * database.
     */
    public List<T> getAllEntitiesByJPQL(String jpql);

    /**
     * Find a list of array values by native query
     *
     * @param query
     * @return List<Object[]>
     */
    public List<Object[]> getAllByNativeQuery(String query);

    /**
     * Find a list of String values by jpql
     *
     * @param jpql
     * @return
     */
    public List<String> getStringListByJPQL(String jpql);

    /**
     * Get an array of values in an entity by given JPQL
     *
     * @param jpql
     * @return Object[]
     */
    public Object[] getListOfDataByJPQL(String jpql);

    /**
     * Find a list of array values from entities by jpql
     *
     * @param jpql
     * @return
     */
    public List<Object[]> getSearchResultsByJPQL(String jpql);
}
