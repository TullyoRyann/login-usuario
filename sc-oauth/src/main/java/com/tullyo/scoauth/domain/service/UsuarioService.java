package com.tullyo.scoauth.domain.service;

import com.tullyo.scoauth.domain.model.Usuario;

public interface UsuarioService {

	Usuario findByLogin(String login);
	
}
