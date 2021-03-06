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
 
    	 /***************SEND ORDER TO purchases.store ******************************/      
    	// Dummy up an order
    	// First need a Product:
    	Product product = new Product("Bicycle", "Two Wheeler", 79);
    	// Order 2 of them
    	OrderItem orderItem = new OrderItem(2, product);
    	// Make a list of the orderItems [ only 1]
    	List<OrderItem> orderItems = new ArrayList<OrderItem>();
        orderItems.add(orderItem);
 
        OrderPayment orderPayment = new OrderPayment();
        // Create order...
        Order order = new Order("123",orderItems,orderPayment);
        rabbitTemplate.convertAndSend("purchases.store",order);

  /*************************SECOND ORDER TO purchases.store ********************/       
    	// Dummy up a  SECOND order - simply change the product name
        order.getItems().get(0).getProduct().setName("Chandelier");
        rabbitTemplate.convertAndSend("purchases.store",order);
 
        /*************************THIRD ORDER TO purchases.store ********************/       
  	// Dummy up a Third order - simply change the product name
        order.getItems().get(0).getProduct().setName("Soccer Ball");
        rabbitTemplate.convertAndSend("purchases.store",order);
        
        System.out.println();
        System.out.print("************* Bicycle,Chandelier & Soccer Ball sent on TOPIC Exchange with key purchases.store *********************::   ");
        System.out.println();


    }
}
