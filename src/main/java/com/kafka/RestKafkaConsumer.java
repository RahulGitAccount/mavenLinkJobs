package com.kafka;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.stereotype.Component;

@Component
public class RestKafkaConsumer {
	
	public void consumeMessages() {

		Properties props = new Properties();
		props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "consumerwithrestkafka");
		props.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
		//consumer.subscribe(Collections.singleton("kafkawithjava")); 
		TopicPartition partition = new TopicPartition("kafkawithjava1", 0);
		consumer.assign(Arrays.asList(partition)); consumer.seek(partition,  consumer.position(partition));
		System.out.println("From Consumer of kafka .. now polling");
		ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(10000));
		System.out.println("polled records " + records.count());
		for (ConsumerRecord<String, String> record : records) {
			System.out.println("Printing record " + "key : " + record.key() + " Value : " + record.value()
			+ " partition : " + record.partition());
		}
		consumer.close();
		System.out.println("Closed COnsumer object");


	}

}
