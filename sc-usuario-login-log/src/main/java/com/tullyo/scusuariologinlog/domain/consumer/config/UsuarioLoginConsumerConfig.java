package com.tullyo.scusuariologinlog.domain.consumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import com.tullyo.scusuariologinlog.domain.consumer.deserializer.UsuarioLoginLogDeserializer;
import com.tullyo.scusuariologinlog.domain.consumer.dto.UsuarioLoginLogTO;

@Configuration
public class UsuarioLoginConsumerConfig {

	@Value("${spring.kafka.bootstrap-servers}")
	private String kafkaServer;
	
	@Value("${spring.kafka.usuario-login-grupo}")
	private String usuarioLoginGrupo;
	
	public ConsumerFactory<String, UsuarioLoginLogTO> userConsumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, usuarioLoginGrupo);
		
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, UsuarioLoginLogDeserializer.class.getName());
		
		return new DefaultKafkaConsumerFactory<>(props);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, UsuarioLoginLogTO> userKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, UsuarioLoginLogTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(userConsumerFactory());

		return factory;
	}
	
}
