package com.jason.SpringBootJPASQLServer.dao;

import org.springframework.data.repository.CrudRepository;

import com.jason.SpringBootJPASQLServer.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer>{

	
	
}
