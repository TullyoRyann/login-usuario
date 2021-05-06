package com.tullyo.scoauth.infrastructure.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tullyo.scoauth.domain.model.Usuario;

@Component
@FeignClient(name = "sc-usuario", path = "/usuarios")
public interface UsuarioFeignClient {

	@GetMapping(value = "/search")
	ResponseEntity<Usuario> search(@RequestParam String login);

}
