package com.edu.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edu.domain.User;

public class BaseDaoTest {
	private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

	@Test
	public void testGetById() {
		UserDao userDao = (UserDao) ac.getBean("userDaoImpl");
		for(int i = 0; i < 100; i++){
			User user = new User();
			user.setName("zhangsan_" + i);
			userDao.save(user);
			
		}
	
	
	}

}
