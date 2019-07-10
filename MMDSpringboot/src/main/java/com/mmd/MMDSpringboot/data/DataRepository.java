package com.mmd.MMDSpringboot.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Data, Long>{
	
	public List<Data> findByProject_Projectid(Long projectId);
	
	public Data findByColumnModel_Columnid(Long columnId);
	
	public List<Data> findByRowid(int rowId);
	
}
