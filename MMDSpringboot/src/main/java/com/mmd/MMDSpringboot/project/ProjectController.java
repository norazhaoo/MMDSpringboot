package com.mmd.MMDSpringboot.project;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("project")
public class ProjectController {

	private ProjectService projectService;

	public ProjectController(ProjectService projectService) {
		super();
		this.projectService = projectService;
	}

	//GET /project
	@GetMapping
	public List<Project> getAllProjects(){
		return projectService.getAllProjects();
	}
	
	@PostMapping("/addProject")
	public Long addProject(@RequestBody Project project, HttpServletResponse httpResponse) {
		Long id = projectService.addProject(project);
		httpResponse.setStatus(HttpServletResponse.SC_CREATED);
		return id;
	}
	
	@PutMapping("/updateProject/{projectId}")
	public Long updateProject(@PathVariable Long projectId, @Valid @RequestBody Project project) {
		return projectService.updateProject(projectId, project);
	}	


}
