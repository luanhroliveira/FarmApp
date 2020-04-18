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
		
		Medicamento med = new Medicamento(null, "Dorflex", "Bula", 10.00);
		Medicamento med2 = new Medicamento(null, "Paracetamol", "Bula", 5.00);
		
		medicamentoRepository.saveAll(Arrays.asList(med, med2));
	}
	
	
	
	
	
}
