package edu.mum;

import java.io.IOException;

import org.springframework.context.support.GenericXmlApplicationContext;
 
public class JmsConsumerMain {
    public static void main(String[] args) throws IOException {
    	
 
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:META-INF/spring/jms-listener-app-context.xml");
        context.refresh();
        
        System.out.println();
        System.out.print("*************JMS Queue Consumer*********************::   ");
        System.out.println();
 
    }
}
