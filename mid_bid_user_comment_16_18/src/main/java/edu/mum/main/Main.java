package edu.mum.main;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import edu.mum.domain.Item;
import edu.mum.domain.User;
import edu.mum.service.ItemService;
import edu.mum.service.UserService;

@Component
public class Main {

	@Autowired
	UserService userService;

	@Autowired
	ItemService itemService;

	@Autowired
	TestData testData;

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context/applicationContext.xml");
		applicationContext.getBean(Main.class).mainInternal(applicationContext);
	}

	private void mainInternal(ApplicationContext applicationContext) {

		testData.setupData();

		System.out.println();
		

		// Initiate the fetch..............
		List<User> users = userService.findAllJoinFetch();

		for (User userFound : users) {
			System.out.println("User Name : " + userFound.getFirstName() + "  " + userFound.getLastName());

			for (Item item : userFound.getBoughtItems()) {
				System.out.println("          Item : " + item.getName());
			}
		}
   
		
		System.out.println("        ********* FindBySoldItemInitialPrice **********");


		User userSold = userService.findBySoldItemInitialPrice("john@Doe.com", "cardboard box", new BigDecimal(70));
		

		System.out.println("Find by Sub select .. " + itemService.findBySubSelect());
		
		System.out.println("FindBySoldItemInitialPrice  email .." + userSold);

	}

}
