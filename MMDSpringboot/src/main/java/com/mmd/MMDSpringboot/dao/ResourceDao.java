package com.mmd.MMDSpringboot.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mmd.MMDSpringboot.model.Resource;

public interface ResourceDao extends JpaRepository<Resource, Integer>{

}
