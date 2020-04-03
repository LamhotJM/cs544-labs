package edu.mum.amqp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import edu.mum.domain.Order;
import edu.mum.domain.OrderItem;
import edu.mum.domain.OrderPayment;
import edu.mum.domain.Product;

public class OrderServiceImpl implements OrderService {
    public void publish(RabbitTemplate rabbitTemplate) {
 
    	 /***************SEND ORDER TO purchases.online ******************************/      
    	// Dummy up an order
    	// First need a Product:
    	Product product = new Product("Horton hears a Who", "Children love this", 79);
    	// Order 2 of them
    	OrderItem orderItem = new OrderItem(2, product);
    	// Make a list of the orderItems [ only 1]
    	List<OrderItem> orderItems = new ArrayList<OrderItem>();
        orderItems.add(orderItem);
 
        OrderPayment orderPayment = new OrderPayment();
        // Create order...
        Order order = new Order("123",orderItems,orderPayment);
  
        // This will be consumed ONLY By any client subscribing to purchases.online

         rabbitTemplate.convertAndSend("purchases.online",order);
 
        System.out.println();
        System.out.print("************* Horton hears a Who sent on TOPIC Exchange to purchases.online *********************::   ");
        System.out.println();

        /*************************Second ORDER TO purchases.online ********************/       
        // This will be consumed By any client subscribing to EITHER purchases.online OR purchases.online.classic
       	order.getItems().get(0).getProduct().setName("Leather Stocking Tales");
        rabbitTemplate.convertAndSend("purchases.online.classic",order);
 
        System.out.println();
        System.out.print("************* Leather Stocking Tales sent on TOPIC Exchange to purchases.online.classic *********************::   ");
        System.out.println();

    }
}
