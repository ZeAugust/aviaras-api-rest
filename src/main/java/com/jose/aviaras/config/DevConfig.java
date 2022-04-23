package com.jose.aviaras.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jose.aviaras.service.AviarasService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private AviarasService aviarasService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instanciaBaseDeDados() {
		if(strategy.equals("create")) {
			aviarasService.instanciaBaseDeDados();
		}
		return false;
	}
	
}
