package edu.mum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.support.GenericXmlApplicationContext;

import edu.mum.domain.Product;
import edu.mum.sender.MessageSender;
 
public class JmsPublisherMain {
    public static void main(String[] args) throws IOException {
    	
 
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load(
        		"classpath:META-INF/spring/jms-sender-app-context.xml",
        		"classpath:META-INF/spring/jms-init-context.xml");
        context.refresh();
        
        String selector = null;
        String value = null;
        
         // Pub/Sub Sender
        MessageSender topicMessageSender = context.getBean("topicMessageSender", MessageSender.class);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.print("*************TO SEE messages in TEMPORARY subscriber - JMSSubscriberToo needs to be running before HIT RETURN*********************   ");
        System.out.println();
        System.out.print("*************HIT RETURN To Send PUB-SUB*********************::  ");
        System.out.println();
        in.readLine();
         
    	Product product = new Product("Bicycle", "Two Wheeler", 79);
        topicMessageSender.sendMessage(product,selector,value);
 
        System.out.println("*************Bicycle Sent - Cycle Mania!! *********************::   ");
        System.out.println();

        // the JmsTopicToo project listener filters on the  "online" selector
    	product = new Product("Chandelier", "Sunny Day", 880);
    	selector = "online";
    	value="true";
        topicMessageSender.sendMessage(product,selector,value);
 
        System.out.println("************* Chandelier Sent - Lumière étincelantes!! *********************::   ");
        System.out.println();
        
    }
}
