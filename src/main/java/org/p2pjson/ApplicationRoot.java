package org.p2pjson;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.Main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationRoot extends Main{

	public static void main(String[] args) throws Exception {
		ApplicationContext appContext = new AnnotationConfigApplicationContext("org.p2pjson");
		CamelContext camelContext = (CamelContext) appContext.getBean("camelContext");
		camelContext.start();
		
		while(true) {
			Thread.sleep(1000);
		}
		
			
	}

}
