package com.tullyo.scoauth.domain.producer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.tullyo.scoauth.domain.producer.UsuarioLoginSerializer;
import com.tullyo.scoauth.domain.producer.dto.UsuarioLoginLogTO;

@Configuration
public class UsuarioProducerConfig {

	@Value("${spring.kafka.bootstrap-servers}")
	private String kafkaServer;

	@Bean
	public ProducerFactory<String, UsuarioLoginLogTO> userProducerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, UsuarioLoginSerializer.class.getName());
		return new DefaultKafkaProducerFactory<>(props);
	}

	@Bean
	public KafkaTemplate<String, UsuarioLoginLogTO> userKafkaTemplate() {
		return new KafkaTemplate<>(userProducerFactory());
	}

}
