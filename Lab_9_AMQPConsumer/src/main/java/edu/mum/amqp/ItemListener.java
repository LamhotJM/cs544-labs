package edu.mum.amqp;

import edu.mum.domain.Item;

public class ItemListener {

	public void listen(Item item) {
		String name = item.getName();
		String desc = item.getDescription();
		System.out.println("---------- Direct consumer for Item: " + name + " desc" + desc);
	}

}
