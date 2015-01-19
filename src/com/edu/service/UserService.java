package com.edu.service;


import com.edu.bean.PageBean;
import com.edu.domain.User;

public interface UserService {
	public PageBean<User> getPageBean(int pageNum, int pageSize);
}
