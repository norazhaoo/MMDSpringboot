package com.mmd.MMDSpringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmd.MMDSpringboot.model.Data;

public interface DataDao extends JpaRepository<Data, Integer>{

}
