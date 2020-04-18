package com.farmapp.farmapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmapp.farmapp.entidades.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
}