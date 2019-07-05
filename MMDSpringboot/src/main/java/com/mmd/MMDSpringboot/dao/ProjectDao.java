package com.mmd.MMDSpringboot.dao;

import org.springframework.data.repository.CrudRepository;

import com.mmd.MMDSpringboot.model.Resource;

public interface ProjectDao extends CrudRepository<Resource, Integer>{

	
	
}
