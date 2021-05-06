package com.tullyo.scoauth.application.service;

import org.springframework.stereotype.Service;

import com.tullyo.scoauth.domain.model.Usuario;
import com.tullyo.scoauth.domain.service.UsuarioService;
import com.tullyo.scoauth.infrastructure.feignclients.UsuarioFeignClient;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioFeignClient usuarioFeignClient;

	private UsuarioServiceImpl(UsuarioFeignClient usuarioFeignClient) {
		this.usuarioFeignClient = usuarioFeignClient;
	}

	@Override
	public Usuario findByLogin(String login) {
		Usuario usuario = usuarioFeignClient.search(login).getBody();

		if (usuario == null) {
			throw new IllegalArgumentException("Login not found");
		}

		return usuario;
	}

}
