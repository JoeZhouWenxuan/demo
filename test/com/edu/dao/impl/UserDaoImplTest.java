package com.edu.dao.impl;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edu.dao.UserDao;

public class UserDaoImplTest {
	private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	@Test
	public void testGetPageRecordCount() {
		UserDao userDao = (UserDao) ac.getBean("userDaoImpl");
		userDao.getPageRecordCount();
	}

}
