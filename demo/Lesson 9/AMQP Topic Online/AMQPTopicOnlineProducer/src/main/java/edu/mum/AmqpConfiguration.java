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

	    /*
	     *  ****** Following is ONLY NEEDED IF First time creating exchange/durable queues ******
	     */
	    @Bean
	    public Queue purchasesOnlineQueue() {
	       return new Queue("purchasesOnline");
	    }

	    @Bean
	    public Queue purchasesOnlineClassicQueue() {
	       return new Queue("purchasesOnlineClassic");
	    }
	    
		@Bean
		TopicExchange orderExchange() {
			return new TopicExchange("order");	
		}
		
		@Bean
		List<Binding> bindings() {

		    return Arrays.asList(BindingBuilder.bind(purchasesOnlineQueue()).to(orderExchange()).with("purchases.online.#"),
		    		BindingBuilder.bind(purchasesOnlineClassicQueue()).to(orderExchange()).with("purchases.online.classic.#")
		    		);
		}
/*
 *  ****** Above is ONLY NEEDED IF First time creating exchange/durable queues ******
 */
		
/*		<!-- **************** TOPIC PRODUCER  -->
		<!-- routing-key is "default" -->
		    <rabbit:template id="topicTemplate" connection-factory="connectionFactory"
		                     reply-timeout="2000" routing-key="purchases.online"
		                     exchange="order" />

*/
		   @Bean
		    public RabbitTemplate topicTemplate() {
		        RabbitTemplate topicTemplate=new RabbitTemplate(connectionFactory());
		        topicTemplate.setRoutingKey("purchases.online");
		        topicTemplate.setExchange("order");
		        topicTemplate.setReplyTimeout(2000);
		        return topicTemplate;
		    }

	   
}
