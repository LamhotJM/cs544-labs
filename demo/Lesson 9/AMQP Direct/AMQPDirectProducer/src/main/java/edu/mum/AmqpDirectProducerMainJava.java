package edu.mum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.mum.amqp.OrderOnlineServiceImpl;
import edu.mum.amqp.OrderStoreServiceImpl;
import edu.mum.amqp.OrderService;

public class AmqpDirectProducerMainJava {
	
    public static void main(String[] args) {
  //       ApplicationContext context = new GenericXmlApplicationContext("classpath:META-INF/spring/order-app-context.xml");
 
         AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AmqpConfiguration.class);
 
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
