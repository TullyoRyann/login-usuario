package com.tullyo.sceurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ScEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScEurekaServerApplication.class, args);
	}

}
