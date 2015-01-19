package com.edu.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.edu.dao.BaseDao;
@Transactional
public class BaseDaoImpl<T> implements BaseDao<T> {

	private Class<T> clazz = null;

	private Logger log = null;
	@Resource
	private SessionFactory sessionFactory = null;

	public BaseDaoImpl() {
		this.clazz = getClazz();
		log = Logger.getLogger(clazz);
		log.info(clazz.getName());
	}

	/**
	 * 保存一个实体
	 */
	@Override
	public void save(T entity) {
		getSession().save(entity);
	}

	/**
	 * 删除一个实体
	 */
	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}

	/**
	 * 根据id删除一个实体
	 */
	@Override
	public void deleteById(Serializable id) {
		getSession().delete(getById(id));
	}

	/**
	 * 更新一个实体
	 */
	@Override
	public void update(T entity) {
		getSession().update(entity);
	}
	/**
	 * 根据id获取实体
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T getById(Serializable id) {
		return (T) getSession().get(clazz, id);
	}

	/**
	 *根据一个id集合获取一个实体list
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getByIds(Serializable[] id) {
		/**
		 * 如果id集合为空，返回一个空的list
		 */
		if(null == id || id.length == 0){
			return Collections.EMPTY_LIST;
		}
		return getSession().createQuery(//
				"FROM " + clazz.getSimpleName() + " where id IN (:ids)")//
				.setParameterList("ids", id)//
				.list();
	}

	/**
	 * 获取全部实体
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return getSession().createQuery(//
				"FROM " + clazz.getSimpleName())//
				.list();
	}

	protected Session getSession() {

		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	private Class<T> getClazz() {

		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		return (Class<T>) pt.getActualTypeArguments()[0];
	}
}
