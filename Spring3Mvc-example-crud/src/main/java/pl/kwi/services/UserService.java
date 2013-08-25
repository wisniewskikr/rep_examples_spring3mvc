package pl.kwi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.kwi.daos.UserDao;
import pl.kwi.entities.UserEntity;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	/**
	 * Method creates user in database.
	 * 
	 * @param user object <code>UserEntity</code> with entity of
	 * user which should be created in database
	 * @return object <code>Long</code> with id of created user
	 */
	@Transactional
	public Long createUser(UserEntity user){
		
		userDao.create(user);
		return user.getId();
		
	}
	
	/**
	 * Method gets user with specified id from database.
	 * 
	 * @param id object <code>Long</code> with id of user which
	 * should be get from database.
	 * @return object <code>UserEntity</code> with user from database
	 * with specified id
	 */
	@Transactional
	public UserEntity readUser(Long id){
		
		return userDao.read(id);
		
	}
	
	/**
	 * Method updates user in database.
	 * 
	 * @param user object <code>UserEntity</code> with entity of
	 * user which should be updated in database
	 */
	@Transactional
	public void updateUser(UserEntity user){
		
		userDao.update(user);
		
	}
	
	/**
	 * Method deletes user from database.
	 * 
	 * @param user object <code>UserEntity</code> with entity of
	 * user which should be deleted in database
	 */
	@Transactional
	public void deleteUser(UserEntity user){
		
		userDao.delete(user);
		
	}
	
	/**
	 * Method gets list of all users from database.
	 * 
	 * @return list of all users from database
	 */
	@Transactional
	public List<UserEntity> getUserList(){
		
		return userDao.findAll();
		
	}

}
