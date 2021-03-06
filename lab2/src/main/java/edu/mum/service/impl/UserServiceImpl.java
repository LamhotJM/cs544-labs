package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;
import edu.mum.service.UserService;

@Service
@Transactional 
public class UserServiceImpl implements UserService {
	
 	@Autowired
	private UserDao userDao;

 	
     public void save( User user) {  		
  		userDao.save(user);
 	}
  	
  	
	public List<User> findAll() {
		return (List<User>)userDao.findAll();
	}

	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}
	
	public User update(User user) {
		return userDao.update(user);
	}
	
	public void refresh(User user) {
		userDao.refresh(user);
	}
	
	public void flush() {
		userDao.flush();
	}
 
}
