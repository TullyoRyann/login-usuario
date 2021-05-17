package com.tullyo.scoauth.domain.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tullyo.scoauth.domain.model.Usuario;
import com.tullyo.scoauth.domain.producer.UsuarioLoginProducer;
import com.tullyo.scoauth.infrastructure.feignclients.UsuarioFeignClient;

@Service
public class UsuarioService implements UserDetailsService {

	private UsuarioFeignClient usuarioFeignClient;
	
	private UsuarioLoginProducer usuarioLoginProducer;

	private UsuarioService(UsuarioFeignClient usuarioFeignClient,
			UsuarioLoginProducer usuarioLoginProducer) {
		this.usuarioFeignClient = usuarioFeignClient;
		this.usuarioLoginProducer = usuarioLoginProducer;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioFeignClient.search(username).getBody();

		if (usuario == null) {
			throw new IllegalArgumentException("Login not found");
		}
		usuarioLoginProducer.enviarLogUsuarioRealizouLogin(usuario);
		return usuario;
	}

}
