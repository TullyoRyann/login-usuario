package com.tullyo.scusuario.infrastructure.persistence.hibernate;

import com.tullyo.scusuario.domain.model.Usuario;

public interface UsuarioRepository extends BaseRepository<Usuario> {

	public Usuario findByLogin(String login);

}
