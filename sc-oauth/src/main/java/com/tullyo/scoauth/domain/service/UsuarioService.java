package com.tullyo.scoauth.domain.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tullyo.scoauth.domain.model.Usuario;
import com.tullyo.scoauth.infrastructure.feignclients.UsuarioFeignClient;

@Service
public class UsuarioService implements UserDetailsService {

	private UsuarioFeignClient usuarioFeignClient;

	private UsuarioService(UsuarioFeignClient usuarioFeignClient) {
		this.usuarioFeignClient = usuarioFeignClient;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioFeignClient.search(username).getBody();

		if (usuario == null) {
			throw new IllegalArgumentException("Login not found");
		}

		return usuario;
	}

}
