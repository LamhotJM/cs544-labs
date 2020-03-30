package edu.mum.main;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import edu.mum.domain.Order;
import edu.mum.domain.OrderItem;
import edu.mum.domain.OrderPayment;
import edu.mum.domain.Product;
import edu.mum.service.OrderService;
import edu.mum.service.ProductService;

@Component
public class Main {

	@Autowired
	TestMember testMembers;
	
	@Autowired
	TestFindByEmailAndTotal testFindByEmailAndTotal;

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context/applicationContext.xml");
		applicationContext.getBean(Main.class).mainInternal(applicationContext);
	}

	private void mainInternal(ApplicationContext applicationContext) {

		

		OrderService orderService = (OrderService) applicationContext.getBean("orderServiceImpl");

		ProductService prouctService = (ProductService) applicationContext.getBean("productServiceImpl");

		Order order = new Order();
		order.setOrderNumber("52");

		orderService.save(order);

		OrderPayment op = new OrderPayment();
		op.setAmount(60000);
		op.setPaymentNumber(11112);
		op.setPaymentType("Cash");
		op.setOrder(order);

		order.getPayments().add(op);
		orderService.update(order);

		// order.setOrderNumber("102");

		Product product = new Product("Skates", "a nice glide", 2);
		Product product2 = new Product("Skates 2", "a nice glide", 2);
		// Order 2 of them

		OrderItem orderItem = new OrderItem(2, order, product);
		OrderItem orderItem2 = new OrderItem(2, order, product2);

		Set<OrderItem> orderItems = new HashSet<OrderItem>();
		orderItems.add(orderItem);
		orderItems.add(orderItem2);

		// Create order...

		Order order1 = new Order("123", orderItems);
		orderService.save(order1);

		System.out.println("halo " + orderService.findAllJoinFetch());

		List<Product> products = prouctService.findByAmountRangeAndQuantity(5000, 70000, 1);
		System.out.println("Count " + products);
		
		testMembers.setupMembers();
		testFindByEmailAndTotal.test();
		

	}

}