package edu.mum;

import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class AmqpDirectOnlineConsumerMainJava {
//	  @Autowired
//	    private RabbitAdmin rabbitAdmin;

    public static void main(String[] args) {
  //       ApplicationContext context = new GenericXmlApplicationContext("classpath:META-INF/spring/order-app-context.xml");
 
         AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AmqpConfiguration.class);
		    applicationContext.getBean(AmqpDirectOnlineConsumerMainJava.class).mainInternal(applicationContext);
}
 private void mainInternal(ApplicationContext applicationContext) {

		System.out.println("---------- Messages read from OrderOnlineQueue on Order Direct Exchange ");

//         rabbitAdmin.initialize();
    }
}
