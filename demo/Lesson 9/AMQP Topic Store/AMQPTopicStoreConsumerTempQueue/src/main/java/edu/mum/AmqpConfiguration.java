package edu.mum;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import edu.mum.amqp.OrderListenerStore;

 
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
 * Topic Consumer
 
	 <rabbit:listener-container connection-factory="connectionFactory">
	 	<rabbit:listener ref="orderListenerStore" method="listen" queue-names="purchasesStoreToo" />
	</rabbit:listener-container>

	   <bean id="orderListenerStore" class="edu.mum.amqp.OrderListenerStore" />
*/
		   @Bean
		   public SimpleMessageListenerContainer orderListenerContainerStore() {
		       SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		       container.setConnectionFactory(connectionFactory());
		       container.setQueueNames("purchasesStoreToo");
		       container.setMessageListener(new MessageListenerAdapter(orderListenerStore(),"listen"));
		       return container;
		   }
		   
		   @Bean
		   OrderListenerStore orderListenerStore() {
			   return new OrderListenerStore();
		   }
		   	   

/*
 *   <!-- Dynamic queue -->
    <rabbit:queue name="purchasesStoreToo" durable="false" auto-delete="true" exclusive="false"/>
	<!--  Bind the dynamic queue -->
    <rabbit:topic-exchange name="order">
        <rabbit:bindings>
               <rabbit:binding queue="purchasesStoreToo" pattern="purchases.store.#" />
         </rabbit:bindings>
    </rabbit:topic-exchange>

 */
	    // Dynamic Queue....Auto-declaring a non-durable Queue
		    // non durable queue, not exclusive, autodelete
		    @Bean
		    Queue purchasesStoreTooQueue() {
		        return new Queue("purchasesStoreToo", false,false,true);
		    }
			@Bean
			TopicExchange orderExchange() {
				return new TopicExchange("order");	
			}

			@Bean
			Binding binding() {

			    return (BindingBuilder.bind(purchasesStoreTooQueue()).to(orderExchange()).with("purchases.store.#")	);
			}
			
			

			// Dynamic Queue....for Auto-declaring a non-durable Queue
		    @Bean
		    public RabbitAdmin  amqpAdmin() {
		    	RabbitAdmin  rabbitAdmin =  new RabbitAdmin(connectionFactory());
	 
		        return rabbitAdmin;
		    }
		    

}
