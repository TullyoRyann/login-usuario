package com.tullyo.scusuariologinlog.domain.consumer;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.tullyo.scusuariologinlog.domain.consumer.dto.UsuarioLoginLogTO;
import com.tullyo.scusuariologinlog.domain.model.UsuarioLogin;
import com.tullyo.scusuariologinlog.infrastructure.persistence.hibernate.UsuarioRepository;

@Component
@EnableKafka
public class UsuarioLoginConsumer {
	
	private UsuarioRepository usuarioRepository;
	
	public UsuarioLoginConsumer(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	 @KafkaListener(
			 topics = "${spring.kafka.usuario-login-topic}",
			 groupId="${spring.kafka.usuario-login-grupo}",
			 containerFactory="userKafkaListenerContainerFactory")
	 public void listener(UsuarioLoginLogTO usuarioLoginLogTO) {
		 UsuarioLogin usuarioLogin = new UsuarioLogin(
				 usuarioLoginLogTO.getId(),
				 usuarioLoginLogTO.getLogin(),
				 usuarioLoginLogTO.getHoraLogin());
		 
		 this.usuarioRepository.save(usuarioLogin);
	 }
	
}
