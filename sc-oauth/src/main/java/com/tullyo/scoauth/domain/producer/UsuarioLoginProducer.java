package com.tullyo.scoauth.domain.producer;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.tullyo.scoauth.domain.model.Usuario;
import com.tullyo.scoauth.domain.producer.dto.UsuarioLoginLogTO;

@Component
public class UsuarioLoginProducer {

	@Value("${spring.kafka.usuario-login-topic}")
	private String usuarioLoginTopic;

	@Autowired
	private KafkaTemplate<String, UsuarioLoginLogTO> usuarioKafkaTemplate;

	public void enviarLogUsuarioRealizouLogin(Usuario usuario) {
		UsuarioLoginLogTO usuarioLoginLog = UsuarioLoginLogTO.builder()
		.id(usuario.getId())
		.login(usuario.getLogin())
		.horaLogin(LocalDateTime.now())
		.build();
		
		usuarioKafkaTemplate.send(usuarioLoginTopic, usuarioLoginLog);
	}

}
