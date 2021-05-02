package com.tullyo.scusuario.application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tullyo.scusuario.domain.model.Usuario;
import com.tullyo.scusuario.domain.service.UsuarioService;
import com.tullyo.scusuario.infrastructure.persistence.hibernate.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioRepository usuarioRepository;

	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Usuario findByLogin(String login) {
		return usuarioRepository.findByLogin(login);
	}

	@Override
	public Usuario findById(Long id) {
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
		if(optionalUsuario.isPresent()) {
			return optionalUsuario.get();
		}
		
		return null;
	}

}
