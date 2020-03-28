package edu.mum.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.domain.User;
import edu.mum.service.UserService;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("context/applicationContext.xml");

		UserService userService = (UserService) context.getBean("userServiceImpl");

		User user = new User();
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setEmail("john@Doe.com");
		userService.save(user);

		User readUser = userService.findByEmail("john@Doe.com");

		System.out.println();
		System.out.println("        *********  User **********");

		System.out.println("User Name: " + readUser.getFirstName() + " " + readUser.getLastName());

	//	user.setEmail("lamhot1@mum.edu");
	  //  userService.update(user);
	//	user.setEmail("lamhot2@mum.edu");
	//	userService.update(user);
		
		userService.flush();
		userService.refresh(readUser);
		//user
	}

}