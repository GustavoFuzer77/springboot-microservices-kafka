package com.api.kafkamicroservices;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class KafkaMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaMicroservicesApplication.class, args);
	}

	@Bean
	NewTopic createTopic() {
		return TopicBuilder.name("product-update-topic").build();
	}

}
