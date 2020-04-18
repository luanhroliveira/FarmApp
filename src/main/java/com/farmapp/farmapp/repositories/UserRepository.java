package com.farmapp.farmapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmapp.farmapp.entidades.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}