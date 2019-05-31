package org.p2pjson.config;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.p2pjson.routes.PapogiRoute;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Camel {

	@Bean
	public CamelContext camelContext () throws Exception {
		CamelContext camelContext = new  DefaultCamelContext();
		camelContext.addRoutes(new PapogiRoute());
		camelContext.start();
		return camelContext;
	}
}
