package edu.mum.main;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import edu.mum.domain.Item;
import edu.mum.domain.User;
import edu.mum.service.UserService;

@Component
public class Main {

	@Autowired
	UserService userService;

	@Autowired
	TestData testData;

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context/applicationContext.xml");
		applicationContext.getBean(Main.class).mainInternal(applicationContext);
	}

	private void mainInternal(ApplicationContext applicationContext) {

		testData.setupData();

		System.out.println();
		System.out.println("        ********* TYPE OF FETCH GOES HERE s **********");

		// Initiate the fetch..............
		// List<User> users = userService.findAllJoinFetch();

		User userFound = userService.findBySoldItemInitialPrice("john@Doe.com", "cardboard box", new BigDecimal(70));

//    for (User userFound : users) {
// 	   System.out.println("User Name : " + userFound.getFirstName() + "  " +  userFound.getLastName() );
// 		
// 		   for (Item item : userFound.getBoughtItems()) {
// 		       System.out.println("          Item : " + item.getName() );
// 		   }
// 	}
//    

		System.out.println("User Name : " + userFound.getFirstName() + "  " + userFound.getLastName());

		for (Item item : userFound.getBoughtItems()) {
		System.out.println("          Item : " + item.getName());
	}

	}

}
