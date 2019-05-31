package org.p2pjson.routes;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@Component
public class PapogiRoute extends SpringRouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:panget?noop=true").process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				String panget = exchange.getIn().getBody(String.class);
				JsonParser jp = new JsonParser();
				JsonElement element = jp.parse(panget);
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				String pogiJson = gson.toJson(element);
				exchange.getOut().setBody(pogiJson);
				Map<String, Object> pangetHeader = exchange.getIn().getHeaders();
				exchange.getOut().setHeaders(pangetHeader);
			}
		}).to("file:pogi");
	}

}
