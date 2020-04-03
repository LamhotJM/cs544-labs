package edu.mum;

import org.springframework.context.support.GenericXmlApplicationContext;

public class JmsSubscriberTooMain {
    public static void main(String[] args) {
    	
 
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/jms-listener-app-context.xml");
        ctx.refresh();
        
        System.out.println();
        System.out.print("*************JMSSubscriberToo  Topic Listener*********************::   ");
        System.out.println();
		System.out.println("---------- TO SEE published messages in TEMPORARY subsription - Be sure run this app BEFORE running JMSPublisher - ");
       System.out.println();
 

        
     }
}
