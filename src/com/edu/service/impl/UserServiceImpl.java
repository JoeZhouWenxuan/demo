package com.edu.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.bean.PageBean;
import com.edu.dao.UserDao;
import com.edu.domain.User;
import com.edu.service.UserService;
import com.edu.util.QueryHelper;
@Transactional
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	@Override
	public PageBean<User> getPageBean(int pageNum, int pageSize) {
//		List<User> recordList = userDao.getPageRecordList(pageNum, pageSize);
//		int recordCount = userDao.getPageRecordCount();
//		return new PageBean<User>(pageNum, pageSize, recordList, recordCount);
//		String hql = "From User u";
//		List<Object> params = new ArrayList<Object>();
//		
		QueryHelper queryHelper = new QueryHelper(User.class, "u")
			.addOrderProperty("u.id", true);
		return userDao.getPageBean(pageNum, pageSize,queryHelper);
	}
}
