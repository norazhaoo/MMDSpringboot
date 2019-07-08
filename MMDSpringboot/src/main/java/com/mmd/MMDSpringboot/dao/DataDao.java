package com.mmd.MMDSpringboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmd.MMDSpringboot.model.Data;

public interface DataDao extends JpaRepository<Data, Integer>{

	List<Data> findAllByDataid(int id);
	
	List<Data> findAllByProjectid(int id);

}
