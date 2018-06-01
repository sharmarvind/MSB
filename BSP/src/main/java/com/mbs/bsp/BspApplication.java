package com.mbs.bsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
//@EnableJpaAuditing 
@EnableResourceServer
@CrossOrigin()
public class BspApplication {

	public static void main(String[] args) {
		SpringApplication.run(BspApplication.class, args);
	}
}
