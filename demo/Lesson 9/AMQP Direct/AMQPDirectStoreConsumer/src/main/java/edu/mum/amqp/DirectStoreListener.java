package edu.mum.amqp;

import edu.mum.domain.Order;

public class DirectStoreListener {

	public void listen(Order order) {
			
		String name = order.getItems().get(0).getProduct().getName();
		System.out.println("---------- AMQPClient Order for Product on OrderStoreQueue: " + name);
	}
}
