package com.edu.dao;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * @author zhou_wenxuan
 *
 * @param <T>
 */
public interface BaseDao<T> {
	/**
	 * 
	 * @param entity
	 */
	public void save(T entity);
	
	/**
	 * 
	 * @param entity
	 */
	public void delete(T entity);
	
	/**
	 * 
	 * @param id
	 */
	public void deleteById(Serializable id);
	
	/**
	 * 
	 * @param entity
	 */
	public void update(T entity);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public T getById(Serializable id);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<T> getByIds(Serializable[] id);
	
	/**
	 * 
	 * @return
	 */
	public List<T> findAll();
}
