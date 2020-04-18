package com.farmapp.farmapp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmapp.farmapp.entidades.Drogaria;
import com.farmapp.farmapp.services.DrogariaServices;

@RestController
@RequestMapping(value = "/drogarias")
public class DrogariaResource {

	@Autowired
	private DrogariaServices service;
	
	@GetMapping
	public ResponseEntity<List<Drogaria>> findAll(){
		List<Drogaria> listDrogaria = service.findAll();
		return ResponseEntity.ok().body(listDrogaria);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Drogaria> findById(@PathVariable Long id){
		Drogaria obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
