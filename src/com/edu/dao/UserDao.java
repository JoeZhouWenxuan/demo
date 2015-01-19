package com.edu.dao;

import java.util.List;

import com.edu.bean.PageBean;
import com.edu.domain.User;
import com.edu.util.QueryHelper;



public interface UserDao extends BaseDao<User> {
	public List<User> getPageRecordList(int pageNum, int pageSize); 
	public int getPageRecordCount();

	public PageBean<User> getPageBean(int pageNum, int pageSize, String hql, List<Object> params);
	public PageBean<User> getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);
}
