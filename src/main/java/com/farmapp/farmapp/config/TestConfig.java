package com.farmapp.farmapp.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.farmapp.farmapp.entidades.Medicamento;
import com.farmapp.farmapp.repositories.MedicamentoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private MedicamentoRepository medicamentoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		
	
	}
	
	
	
	
	
}
