package edu.mum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import edu.mum.amqp.OrderService;
import edu.mum.amqp.OrderServiceImpl;

public class AmqpTopicProducerStoreMain {
	
    public static void main(String[] args) {
         ApplicationContext context = new GenericXmlApplicationContext("classpath:META-INF/spring/order-app-context.xml");
 
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         System.out.print("*************TO SEE STORE purchases in TEMPORARY QUEUE - AMQPTopicConsumerTempStoreQueue needs to be running before HIT RETURN*********************   ");
         System.out.println();
         System.out.print("*************HIT RETURN To Send orders on TOPIC Exchange*********************::   ");
         System.out.println();
         try {
			in.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
                       
         RabbitTemplate topicTemplate =  context.getBean("topicTemplate",RabbitTemplate.class);
     	OrderService orderService = new OrderServiceImpl();   // Publish to Topic
     	orderService.publish(topicTemplate);

    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


    }
}
