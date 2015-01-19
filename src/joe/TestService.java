package joe;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.domain.User;


@Service("testService")
public class TestService {

	@Resource
	private SessionFactory factory;
	
	@Transactional
	public void saveTwoUsers(){
		Session session = factory.getCurrentSession();
		session.save(new User());
		session.save(new User());
	}
}
