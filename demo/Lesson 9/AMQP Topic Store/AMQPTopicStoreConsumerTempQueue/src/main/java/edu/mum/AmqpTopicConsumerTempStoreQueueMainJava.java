package edu.mum;

import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class AmqpTopicConsumerTempStoreQueueMainJava {

	public static void main(String[] args) {
  //       ApplicationContext context = new GenericXmlApplicationContext("classpath:META-INF/spring/order-app-context.xml");
 
         AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AmqpConfiguration.class);
		    applicationContext.getBean(AmqpTopicConsumerTempStoreQueueMainJava.class).mainInternal(applicationContext);
}
 private void mainInternal(ApplicationContext applicationContext) {

		System.out.println("---------- TO SEE STORE purchases in TEMPORARY QUEUE - Be sure run this app BEFORE running AMQPTopicProducer - ");


    }
}
