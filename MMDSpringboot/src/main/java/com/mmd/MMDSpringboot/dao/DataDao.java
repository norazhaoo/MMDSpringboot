package com.mmd.MMDSpringboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmd.MMDSpringboot.model.Data;
import com.mmd.MMDSpringboot.model.DataId;

public interface DataDao extends JpaRepository<Data, DataId>{


//	List<Data> findByDataIdProjectid(int projectid);

}
