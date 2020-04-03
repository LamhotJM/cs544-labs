package edu.mum;

import java.util.Arrays;
import java.util.List;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

 /*
  * This is the Java Config version. It has corresponding "comments" which
  * show the XML config analog.
  */
@Configuration
public class AmqpConfiguration {

/*    <rabbit:connection-factory id="connectionFactory" host="localhost" username="joe" password="joe"/>*/
	    @Bean
	    public ConnectionFactory connectionFactory() {
	    	CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
	    	connectionFactory.setUsername("joe");
	    	connectionFactory.setPassword("joe");
	        return connectionFactory;
	    }

	
/*		<!-- **************** TOPIC PRODUCER  -->
		<!-- routing-key is "default" -->
		    <rabbit:template id="topicTemplate" connection-factory="connectionFactory"
		                     reply-timeout="2000" routing-key="purchases.store"
		                     exchange="order" />

*/
		   @Bean
		    public RabbitTemplate topicTemplate() {
		        RabbitTemplate topicTemplate=new RabbitTemplate(connectionFactory());
		        topicTemplate.setRoutingKey("purchases.store");
		        topicTemplate.setExchange("order");
		        topicTemplate.setReplyTimeout(2000);
		        return topicTemplate;
		    }

	   
}
