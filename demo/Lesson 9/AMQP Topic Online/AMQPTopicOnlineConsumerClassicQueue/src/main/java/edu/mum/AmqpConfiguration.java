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

import edu.mum.amqp.OrderListenerOnlineClassic;

 
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
	 	<rabbit:listener ref="orderListenerOnlineClassic" method="listen" queue-names="purchasesOnlineClassic" />
	</rabbit:listener-container>

	   <bean id="orderListenerOnlineClassic" class="edu.mum.amqp.OrderListenerOnlineClassic" />
*/
		   @Bean
		   public SimpleMessageListenerContainer orderListenerContainerOnlineClassic() {
		       SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		       container.setConnectionFactory(connectionFactory());
		       container.setQueueNames("purchasesOnlineClassic");
		       container.setMessageListener(new MessageListenerAdapter(orderListenerOnlineClassic(),"listen"));
		       return container;
		   }
		   
		   @Bean
		   OrderListenerOnlineClassic orderListenerOnlineClassic() {
			   return new OrderListenerOnlineClassic();
		   }
		   	   

/*
 *   <!-- Dynamic queue -->
    <rabbit:queue name="purchasesOnline" durable="true" auto-delete="false" exclusive="false"/>
	<!--  Bind the dynamic queue -->
    <rabbit:topic-exchange name="order">
        <rabbit:bindings>
               <rabbit:binding queue="purchasesOnline" pattern="purchases.online.#" />
         </rabbit:bindings>
    </rabbit:topic-exchange>

 */
	    // Dynamic Queue....Auto-declaring a non-durable Queue
		    // non durable queue, not exclusive, autodelete
		    @Bean
		    Queue purchasesOnlineQueueClassic() {
		        return new Queue("purchasesOnlineClassic", true,false,false);
		    }
			@Bean
			TopicExchange orderExchange() {
				return new TopicExchange("order");	
			}

			@Bean
			Binding binding() {

			    return (BindingBuilder.bind(purchasesOnlineQueueClassic()).to(orderExchange()).with("purchases.online.classic")	);
			}
			
			

			// Dynamic Queue....for Auto-declaring a non-durable Queue
		    @Bean
		    public RabbitAdmin  amqpAdmin() {
		    	RabbitAdmin  rabbitAdmin =  new RabbitAdmin(connectionFactory());
	 
		        return rabbitAdmin;
		    }
		    

}
