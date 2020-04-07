

package edu.mum.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class Main {

	private final static String[] configFilesGatewayDemo = {
		"/META-INF/spring/integration/common.xml",
 		"/META-INF/spring/integration/itemGateway.xml",
		"/META-INF/spring/integration/amqp-item-app-context.xml",
		"/META-INF/spring/integration/jms-item-app-context.xml"
	};


	public static void main(String[] args) {

		final Scanner scanner = new Scanner(System.in);

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configFilesGatewayDemo, Main.class);

	    applicationContext.getBean(Main.class).mainInternal(applicationContext);
	  }

	    private void mainInternal(ApplicationContext applicationContext) {
				// Wait for Messages
	    }

}