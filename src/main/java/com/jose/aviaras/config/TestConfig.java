package com.jose.aviaras.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jose.aviaras.service.AviarasService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private AviarasService aviarasService;
	
	@Bean
	public void instanciaBaseDeDados() {
		this.aviarasService.instanciaBaseDeDados();
	}
}
