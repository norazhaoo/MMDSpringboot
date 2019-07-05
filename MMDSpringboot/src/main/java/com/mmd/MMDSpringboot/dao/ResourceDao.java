package com.mmd.MMDSpringboot.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mmd.MMDSpringboot.model.Resource;

@Repository
public interface ResourceDao extends JpaRepository<Resource, Integer>{

	//Optional<Resource> findResourceNameLike = null;

	
}
