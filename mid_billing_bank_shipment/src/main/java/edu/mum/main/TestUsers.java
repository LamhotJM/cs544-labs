package edu.mum.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.domain.Address;
import edu.mum.domain.Shipment;
import edu.mum.domain.User;
import edu.mum.domain.UserCredentials;
import edu.mum.service.UserCredentialsService;
import edu.mum.service.UserService;

@Component
public class TestUsers {

	@Autowired
	UserService userService;

	@Autowired
	UserCredentialsService userCredentialsService;

	public void setupUsers() {

		// Add 2 users for JPQL testing

		User user = new User();
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setEmail("john@Doe.com");
		Address add1 = new Address();
		add1.setCity("Iowa");
		add1.setStreet("ST 4 #61");
		add1.setZipcode("52566");
		add1.setUser(user);
		user.getAddresses().add(add1);
		
		Shipment ship1 = new Shipment();
		ship1.setDeliveryAddress(add1);
		ship1.setBuyer(user);
		ship1.setSeller(user);
		user.getSellShipments().add(ship1);
		
		userService.save(user);

		UserCredentials userCredentials = new UserCredentials();
		userCredentials.setUserName("JohnDoe");
		userCredentials.setPassword("DoeNuts");
		userCredentials.setVerifyPassword("DoeNuts");

		// Set both sides
		userCredentials.setUser(user);
		user.setUserCredentials(userCredentials);

		userCredentialsService.update(userCredentials);

		// Add second for JPQL testing
		user = new User();
		user.setFirstName("Jane");
		user.setLastName("Doe");
		user.setEmail("jane@Doe.com");
		userService.save(user);

	}
}
