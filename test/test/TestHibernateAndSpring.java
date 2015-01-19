package test;

import javax.annotation.Resource;
import joe.TestService;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHibernateAndSpring {
	private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	@Resource
	private SessionFactory sessionFactory;
//	@Test
//	public void testSessionFactory() throws Exception {
//		SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
//		System.out.println(sessionFactory);
//	}
	
	
	@Test
	public void testHibernate() throws Exception {
		TestService test = (TestService) ac.getBean("testService");
		test.saveTwoUsers();
		
		
	}
}
