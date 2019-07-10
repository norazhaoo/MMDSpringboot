package com.mmd.MMDSpringboot.project;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class ProjectService {

	private ProjectRepository projectRepository;

	public ProjectService(ProjectRepository projectRepository) {
		super();
		this.projectRepository = projectRepository;
	}
	
	//get all projects
	public List<Project> getAllProjects(){
		return projectRepository.findAll();
	}
	
	//get project by projectid
	public Project getProjectById(Long id) {
		return projectRepository.getOne(id);
	}
	
	//get project by projectname
	public Project getProjectByProjectname(String projectname) {
		return projectRepository.findByProjectname(projectname);
	}

	public Long addProject(Project project) {
		project.setProjectid(null);
		return projectRepository.save(project).getProjectid();
	}
	
	public Long updateProject(Long id, Project project) {
		project.setProjectid(id);
		projectRepository.save(project);
		return projectRepository.getOne(id).getProjectid();
	}
	
}
