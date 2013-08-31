package pl.kwi.daos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;


import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.kwi.db.spring.test.DbUnitUtil;
import pl.kwi.entities.UserEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"/conf/spring-conf.xml",
		"/conf/spring-db-test-unit.xml"
		})
@Transactional
public class UserDaoTest {

	@Autowired
	private UserDao dao;
	
	@Autowired
	public SessionFactory sessionFactory;
	
	@Test
	public void create() {
		
		DbUnitUtil.executeDataFile("/dbunit/userDaoTest.xml", sessionFactory);

		UserEntity user = new UserEntity();
		user.setName("User4");
		
		dao.create(user);
		
		Long id = user.getId();
		assertNotNull(id);

	}

	@Test
	public void read() {
		
		DbUnitUtil.executeDataFile("/dbunit/userDaoTest.xml", sessionFactory);
		
		UserEntity user = dao.read(1L);
		
		assertEquals(Long.valueOf(1), user.getId());
		assertEquals("User1", user.getName());

	}

	@Test
	public void update() {
		
		DbUnitUtil.executeDataFile("/dbunit/userDaoTest.xml", sessionFactory);

		UserEntity user = new UserEntity();
		user.setId(1L);
		user.setName("User4");
		
		dao.update(user);
		user = dao.read(1L);
		
		assertEquals(Long.valueOf(1), user.getId());
		assertEquals("User4", user.getName());

	}

	@Test
	public void delete() {
		
		DbUnitUtil.executeDataFile("/dbunit/userDaoTest.xml", sessionFactory);
		
		UserEntity user = dao.read(1L);
		Assert.assertNotNull(user);
		
		dao.deleteById(1L);		
		user = dao.read(1L);
		
		Assert.assertNull(user);

	}
	
	@Test
	public void findAll(){
		
		DbUnitUtil.executeDataFile("/dbunit/userDaoTest.xml", sessionFactory);
		
		List<UserEntity> users = dao.findAll();
		
		assertEquals(3, users.size());
		
	}

}
