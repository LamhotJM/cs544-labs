package edu.mum.amqp;

import edu.mum.domain.Order;

public class OrderListenerOnline {

	public void listen(Order order) {
		
		String name = order.getItems().get(0).getProduct().getName();
		System.out.println("---------- AMQPTopicConsumerOnlineQueue - TOPIC Order for Product with key purchases.online.# ...: " + name);
	}
}
