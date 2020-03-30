package edu.mum.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.domain.Item;
import edu.mum.domain.User;
import edu.mum.service.ItemService;
import edu.mum.service.UserService;

@Component
public class TestFindByBoughtItemShippedZip{

	@Autowired
	ItemService itemService;
	
 	@Autowired
	UserService userService;	

	public void test() {
 

	 	System.out.println();
	    System.out.println("********** find By Zip  ***************");
 
	    User user = userService.findByBoughtItemShippedZip("john@Doe.com", "52566"); // "Jane Doe"
	    
	    System.out.print("Find by zip " + user.getEmail());
	
	    
	}
}
