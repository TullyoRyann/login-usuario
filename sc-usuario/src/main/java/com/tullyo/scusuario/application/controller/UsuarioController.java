package com.tullyo.scusuario.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
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
	
	private Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
	@Value("${test.config}")
	private String testConfig;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfigs() {
		logger.info("CONFIG = " + testConfig);
		return ResponseEntity.noContent().build();
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
