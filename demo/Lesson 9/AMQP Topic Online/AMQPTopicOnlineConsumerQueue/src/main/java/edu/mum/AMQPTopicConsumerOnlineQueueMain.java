package edu.mum;

import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

//@Component
public class AMQPTopicConsumerOnlineQueueMain {

	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
        new GenericXmlApplicationContext("classpath:META-INF/spring/order-app-context.xml");

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AmqpConfiguration.class);

		System.out.println("----------  Online purchases in DURABLE QUEUE - purchasesOnline - ");

	}
}
