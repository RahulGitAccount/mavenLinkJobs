package com.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Component;
@Component
public class RestKafkaProducer {
	
	
	 void sendMessage(String value) {
	Properties props = new Properties();
	props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
	props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
	KafkaProducer<String , String> producer = new KafkaProducer<String, String>(props);
	
	ProducerRecord<String, String> record = new ProducerRecord<String, String>("kafkawithjava1", value);
	System.out.println("flushing " + value);
	producer.send(record);
	producer.flush();
	producer.close();
	 }
}
