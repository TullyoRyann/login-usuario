package com.tullyo.scapigatewayzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class ScApiGatewayZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScApiGatewayZuulApplication.class, args);
	}

}
