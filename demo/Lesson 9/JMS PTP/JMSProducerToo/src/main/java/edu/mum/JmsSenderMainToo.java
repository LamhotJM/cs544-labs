package edu.mum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.support.GenericXmlApplicationContext;

import edu.mum.domain.Product;
import edu.mum.sender.MessageSender;

public class JmsSenderMainToo {
    public static void main(String[] args) throws IOException {
    	
 
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:META-INF/spring/jms-sender-app-context.xml");
        context.refresh();
        
        MessageSender messageSender = context.getBean("messageSender", MessageSender.class);
      
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.print("*************JMSProducerToo  *********************::   ");
        System.out.print("*************HIT RETURN To Send PTP*********************::   ");
        System.out.println();
        in.readLine();
         
        // Product to send...   
           	Product product = new Product("Baton", "a Real Twirler", 19);
            messageSender.sendMessage(product);
               
         System.out.print("*************Baton Sent - A real Twirler!! *********************::   ");

    }
}
