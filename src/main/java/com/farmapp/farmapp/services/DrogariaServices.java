package com.farmapp.farmapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmapp.farmapp.entidades.Drogaria;
import com.farmapp.farmapp.repositories.DrogariaRepository;

@Service
public class DrogariaServices {

	@Autowired
	private DrogariaRepository repository;
	
	public List<Drogaria> findAll(){
		return repository.findAll();
	}
	
	public Drogaria findById(Long id) {
		Optional<Drogaria> obj = repository.findById(id);
		return obj.get();
	}
}
