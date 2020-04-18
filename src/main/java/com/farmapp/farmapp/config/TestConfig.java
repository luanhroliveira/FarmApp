package com.farmapp.farmapp.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.farmapp.farmapp.entidades.Drogaria;
import com.farmapp.farmapp.entidades.Medicamento;
import com.farmapp.farmapp.repositories.DrogariaRepository;
import com.farmapp.farmapp.repositories.MedicamentoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private MedicamentoRepository medicamentoRepository;
	
	@Autowired
	private DrogariaRepository drogariaRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Drogaria d = new Drogaria(null, "Farmais");
		Drogaria d1 = new Drogaria(null, "Farmax");
		
		Medicamento med = new Medicamento(null, "Dorflex", "Bula", 10.00, d);
		Medicamento med2 = new Medicamento(null, "Paracetamol", "Bula", 5.00, d1);
		
		drogariaRepository.saveAll(Arrays.asList(d,d1));
		
		medicamentoRepository.saveAll(Arrays.asList(med, med2));
	}
	
	
	
	
	
}
