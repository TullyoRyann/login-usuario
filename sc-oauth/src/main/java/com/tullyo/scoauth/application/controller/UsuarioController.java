package com.tullyo.scoauth.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tullyo.scoauth.domain.model.Usuario;
import com.tullyo.scoauth.domain.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private UsuarioService usuarioService;

	private UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping(value = "/search")
	public ResponseEntity<Usuario> findByLogin(@RequestParam String login) {
		Usuario usuario = usuarioService.findByLogin(login);
		return ResponseEntity.ok(usuario);
	}

}
