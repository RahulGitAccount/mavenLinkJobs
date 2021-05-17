package com.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class KafkaCosumerSchedular {
	
	@Autowired
	RestKafkaConsumer consumer;
	
	@Scheduled(fixedDelay = 1000)
	public void schedularDemo() {
		System.out.println("Running Consumer in scheduled time");
		consumer.consumeMessages();
	}

}
