package com.mmd.MMDSpringboot.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
	
	Project findByProjectname(String projectname);
	
	Project findAllByProjectid(Long projectid);
}
