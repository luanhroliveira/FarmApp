package com.farmapp.farmapp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmapp.farmapp.entidades.Medicamento;
import com.farmapp.farmapp.services.MedicamentoServices;

@RestController
@RequestMapping(value = "/medicamentos")
public class MedicamentoResource {

	@Autowired
	private MedicamentoServices service;
	
	@GetMapping
	public ResponseEntity<List<Medicamento>> findAll(){
		List<Medicamento> listMedicamento = service.findAll();
		return ResponseEntity.ok().body(listMedicamento);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Medicamento> findById(@PathVariable Long id){
		Medicamento obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
