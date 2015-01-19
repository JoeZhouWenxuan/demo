package com.edu.dao.impl;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.edu.bean.PageBean;
import com.edu.dao.UserDao;
import com.edu.domain.User;
import com.edu.util.QueryHelper;
@Transactional
@Repository("userDaoImpl")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getPageRecordList(int pageNum, int pageSize) {
		List<User> list = getSession().createQuery(//
				"FROM User u ORDER BY u.id")//
				.setFirstResult((pageNum - 1) * pageSize)
				.setMaxResults(pageSize)
				.list();

		return list;
	}

	@Override
	public int getPageRecordCount() {
		Number result = (Number) getSession().createQuery("SELECT COUNT(*) FROM User u ").uniqueResult();
		return result.intValue();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public PageBean getPageBean(int pageNum, int pageSize, String hql, List<Object> params) {
		Query listQuery = getSession().createQuery(hql);
		if(params != null){
			for(int i = 0; i < params.size(); i++){
				listQuery.setParameter(i, params.get(i));
			}
		}
		listQuery.setFirstResult((pageNum - 1) * pageSize);
		listQuery.setMaxResults(pageSize);
		List<User> recordList = listQuery.list();
		Query countQuery = getSession().createQuery("SELECT COUNT(*) " + hql);
		if(params != null){
			for(int i = 0; i < params.size(); i++){
				countQuery.setParameter(i, params.get(i));
			}
		}
		Long recordCount = (Long) countQuery.uniqueResult();
		
		return new PageBean<User>(pageNum, pageSize, recordList, recordCount.intValue());
	}

	@Override
	public PageBean<User> getPageBean(int pageNum, int pageSize, QueryHelper queryHelper) {
		//获取参数
		List<Object> params = queryHelper.getParameters();
		Query countQuery = getSession().createQuery(queryHelper.getCountQueryHql());
		if(params != null){
			for(int i = 0; i < params.size(); i++){
				countQuery.setParameter(i, params.get(i));
			}
		}
		//查询所有记录数
		Long recordCount = (Long) countQuery.uniqueResult();
		PageBean<User> pageBean = new PageBean<User>(pageNum, pageSize, null, recordCount.intValue());
		int pageCount = pageBean.getPageCount();
		if(pageNum > pageCount){
			pageNum = pageCount;
		}
		Query listQuery = getSession().createQuery(queryHelper.getListQueryHql());
		
		if(params != null){
			for(int i = 0; i < params.size(); i++){
				listQuery.setParameter(i, params.get(i));
			}
		}
		listQuery.setFirstResult((pageNum - 1) * pageSize);
		listQuery.setMaxResults(pageSize);
		List<User> recordList = listQuery.list();
		pageBean.setRecordList(recordList);
		return pageBean;
	}

	
}
