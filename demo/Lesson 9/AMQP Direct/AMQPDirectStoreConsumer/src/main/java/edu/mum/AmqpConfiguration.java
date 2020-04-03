package edu.mum;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import edu.mum.amqp.DirectStoreListener;


 
@Configuration
@ComponentScan("edu.mum")
public class AmqpConfiguration {

/*    <rabbit:connection-factory id="connectionFactory" host="localhost" username="joe" password="joe"/>*/  
	    @Bean
	    public ConnectionFactory connectionFactory() {
	    	CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
	    	connectionFactory.setUsername("joe");
	    	connectionFactory.setPassword("joe");
	        return connectionFactory;
	    } 
	    
/*
	   <!--  ****************  Store CONSUMER ************************* -->
	    <rabbit:listener-container connection-factory="connectionFactory">
	   	<rabbit:listener ref="queueListener" method="listen" queue-names="orderStoreQueue" />
	   </rabbit:listener-container>

	   <bean id="queueListener" class="edu.mum.amqp.DirectStoreListener" />

*/		   

		   
		   @Bean
		   public SimpleMessageListenerContainer directListenerContainer() {
		       SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		       container.setConnectionFactory(connectionFactory());
		       container.setQueueNames("orderStoreQueue");
		       container.setMessageListener(new MessageListenerAdapter(queueListener(),"listen"));
		       return container;
		   }
		   
		   @Bean
		   DirectStoreListener queueListener() {
			   return new DirectStoreListener();
		   }
		   
		   
}
