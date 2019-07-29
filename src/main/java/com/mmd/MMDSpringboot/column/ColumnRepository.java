package com.mmd.MMDSpringboot.column;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColumnRepository extends JpaRepository<ColumnModel, Long>{
	
	ColumnModel findByColumnname(String columnName);
	
	ColumnModel findByColumnnameAndProject_Projectid(String columnName, long projectid);
	
	List<ColumnModel> findByColumntype(String columnType);

}
