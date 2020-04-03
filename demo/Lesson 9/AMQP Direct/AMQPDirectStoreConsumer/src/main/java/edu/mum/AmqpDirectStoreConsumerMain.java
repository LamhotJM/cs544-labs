package edu.mum;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AmqpDirectStoreConsumerMain {
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        new GenericXmlApplicationContext("classpath:META-INF/spring/order-app-context.xml");
		System.out.println("---------- Messages read from OrderStoreQueue on Order Direct Exchange ");

    }
}
