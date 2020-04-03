package edu.mum;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

//@Component
public class AMQPTopicConsumerOnlineClassicQueueMain {

	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
        new GenericXmlApplicationContext("classpath:META-INF/spring/order-app-context.xml");

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AmqpConfiguration.class);

		System.out.println("----------  Online purchases in DURABLE QUEUE - purchasesOnlineClassic - ");

	}
}
