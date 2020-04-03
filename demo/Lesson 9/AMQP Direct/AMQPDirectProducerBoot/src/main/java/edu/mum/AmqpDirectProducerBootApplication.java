package edu.mum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import edu.mum.amqp.OrderOnlineServiceImpl;
import edu.mum.amqp.OrderService;
import edu.mum.amqp.OrderStoreServiceImpl;

@SpringBootApplication
public class AmqpDirectProducerBootApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;
	
	public static void main(String[] args) {
		SpringApplication.run(AmqpDirectProducerBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        System.out.println();
	        
	        System.out.print("*************HIT RETURN To Send[Kazoo & Water Balloon] with key order.store & Send[Ski & Skates] with key order.online  - to orderDirect Exchange*********************::   ");
	        System.out.println();
	        try {
				in.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	         
	    	// Publish to "direct" exchange on order.store == orderDirectQueue
	        RabbitTemplate orderStoreTemplate =  context.getBean("orderStoreTemplate",RabbitTemplate.class);
	    	OrderService orderStoreService = new OrderStoreServiceImpl();
	    	orderStoreService.publish(orderStoreTemplate);
	 
	    	System.out.print("************* Kazoo & Water Balloon sent to Order Store Queue  on orderDirect Exchange*********************::   ");
	        System.out.println();
	        System.out.println();
	    
	     	// Publish to "direct" exchange on order.online == orderOnlineQueue
	       RabbitTemplate orderOnlineTemplate =  context.getBean("orderOnlineTemplate",RabbitTemplate.class);
	    	OrderService orderOnlineService = new OrderOnlineServiceImpl();
	    	orderOnlineService.publish(orderOnlineTemplate);

	        System.out.print("************* Ski & Skates sent to Order Online Queue  on orderDirect Exchange*********************::   ");
	           System.out.println();
		
	}

}
