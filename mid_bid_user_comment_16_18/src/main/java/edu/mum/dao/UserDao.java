package edu.mum.dao;

import java.math.BigDecimal;
import java.util.List;

import edu.mum.domain.User;

public interface UserDao extends GenericDao<User> {
      
 	public List<User> findAllJoinFetch();
 	
 	public List<User> findAllBatch();
 	
 	public User findBySoldItemInitialPrice(String email,String itemName, BigDecimal initialPrice);
}
