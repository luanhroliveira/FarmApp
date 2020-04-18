package com.farmapp.farmapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmapp.farmapp.entidades.Medicamento;
import com.farmapp.farmapp.repositories.MedicamentoRepository;

@Service
public class MedicamentoServices {

	@Autowired
	private MedicamentoRepository repository;
	
	public List<Medicamento> findAll(){
		return repository.findAll();
	}
	
	public Medicamento findById(Long id) {
		Optional<Medicamento> obj = repository.findById(id);
		return obj.get();
	}
}
