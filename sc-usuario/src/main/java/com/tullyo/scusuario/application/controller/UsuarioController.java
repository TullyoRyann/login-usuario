package com.tullyo.scusuario.application.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tullyo.scusuario.domain.model.Usuario;
import com.tullyo.scusuario.domain.service.UsuarioService;

@RefreshScope
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	private UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping(value = "/search")
	public ResponseEntity<Usuario> search(@RequestParam String login) {
		Usuario usuario = usuarioService.findByLogin(login);
		return ResponseEntity.ok(usuario);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id) {
		Usuario usuario = usuarioService.findById(id);
		return ResponseEntity.ok(usuario);
	}

}
