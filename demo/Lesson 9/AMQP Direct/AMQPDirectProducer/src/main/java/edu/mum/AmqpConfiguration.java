package edu.mum;

import java.util.Arrays;
import java.util.List;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarable;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
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

/*	    <rabbit:admin connection-factory="connectionFactory" />*/
	    @Bean
	    public AmqpAdmin amqpAdmin() {
	        return new RabbitAdmin(connectionFactory());
	    }

 		
/*		   <!-- *********** DIRECT EXCHANGE IF XML Config ***************** -->
			<rabbit:queue name="orderStoreQueue" durable="true"/>
			<rabbit:queue name="orderOnlineQueue" durable="true"/>

			 <rabbit:direct-exchange name="orderDirectExchange" durable="true">
			  <rabbit:bindings>
			   <rabbit:binding queue="orderStoreQueue" key="order.store"></rabbit:binding>
			   <rabbit:binding queue="orderOnlineQueue" key="order.online"></rabbit:binding>
			  </rabbit:bindings>
			 </rabbit:direct-exchange>
*/
// Declare Queues, Exchange & Bind all at once...
 		   @Bean
		   public List<Declarable> orderDirectExchangeBindings() {
		       Queue orderStoreQueue = new Queue("orderStoreQueue", true);
		       Queue orderOnlineQueue = new Queue("orderOnlineQueue", true);
		       DirectExchange orderDirectExchange = new DirectExchange("orderDirectExchange");
		    
		       List<Declarable> bindingList = Arrays.<Declarable>asList(
		    		   orderStoreQueue,
		    		   orderOnlineQueue,
		    		   orderDirectExchange,
		    	 BindingBuilder.bind(orderStoreQueue).to(orderDirectExchange).with("order.store"),
		         BindingBuilder.bind(orderOnlineQueue).to(orderDirectExchange).with("order.online"));
		       
		       return bindingList;
		   }


/*		   <!-- **************** Store PRODUCER  -->
		   <!-- This producer will publish with this routing key [essentially to queue orderStoreQueue] associated with it...] -->
		       <rabbit:template id="orderStoreTemplate" connection-factory="connectionFactory"
		                        reply-timeout="2000" routing-key="order.store"
		                        exchange="orderDirectExchange" />
*/
		   @Bean
		    public RabbitTemplate orderStoreTemplate() {
		        RabbitTemplate orderStoreTemplate= new RabbitTemplate(connectionFactory());
		        orderStoreTemplate.setRoutingKey("order.store");
		        orderStoreTemplate.setExchange("orderDirectExchange");
		        orderStoreTemplate.setReplyTimeout(2000);
		        return orderStoreTemplate;
		    }
  
/*         <!-- **************** Online PRODUCER  -->
		   <!-- This producer will publish with this routing key [essentially to queue orderDirectOnlineQueue] associated with it...] -->
		       <rabbit:template id="orderDirectOnlineTemplate" connection-factory="connectionFactory"
		                        reply-timeout="2000" routing-key="order.online"
		                        exchange="orderDirectExchange" />
*/
		   @Bean
		    public RabbitTemplate orderOnlineTemplate() {
		        RabbitTemplate orderOnlineTemplate= new RabbitTemplate(connectionFactory());
		        orderOnlineTemplate.setRoutingKey("order.online");
		        orderOnlineTemplate.setExchange("orderDirectExchange");
		        orderOnlineTemplate.setReplyTimeout(2000);
		        return orderOnlineTemplate;
		    }
  
				   
}
