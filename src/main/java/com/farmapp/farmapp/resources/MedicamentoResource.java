package com.farmapp.farmapp.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmapp.farmapp.entidades.Medicamento;

@RestController
@RequestMapping(value = "/medicamentos")
public class MedicamentoResource {

	@GetMapping
	public ResponseEntity<Medicamento> findAll(){
		
		Medicamento medicamento = new Medicamento(1, "Dorflex", "BULA", 5.00);
		
		return ResponseEntity.ok().body(medicamento);
		
	}
	
}
