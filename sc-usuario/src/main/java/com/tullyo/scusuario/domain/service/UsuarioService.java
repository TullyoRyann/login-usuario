package com.tullyo.scusuario.domain.service;

import com.tullyo.scusuario.domain.model.Usuario;

public interface UsuarioService {

	public Usuario findByLogin(String login);
	
	public Usuario findById(Long id);
	
}
