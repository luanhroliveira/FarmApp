package com.farmapp.farmapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmapp.farmapp.entidades.PedidoItem;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long>{
	
}