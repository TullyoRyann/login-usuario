package com.tullyo.scusuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ScUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScUsuarioApplication.class, args);
	}

}
