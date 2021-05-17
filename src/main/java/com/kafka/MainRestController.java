package com.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {
	
	@Autowired
	RestKafkaProducer producer;
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, value = "/produceKafkaMessage")
	public void produceKafkaMessage(@RequestBody Company cpy) {
		
		producer.sendMessage(cpy.getName());
		
	}

}
