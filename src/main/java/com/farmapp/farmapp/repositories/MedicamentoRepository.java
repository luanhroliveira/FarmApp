package com.farmapp.farmapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmapp.farmapp.entidades.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long>{
	
}