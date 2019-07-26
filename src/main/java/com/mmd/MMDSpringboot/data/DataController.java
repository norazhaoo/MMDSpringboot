package com.mmd.MMDSpringboot.data;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mmd.MMDSpringboot.column.ColumnModel;
import com.mmd.MMDSpringboot.column.ColumnService;
import com.mmd.MMDSpringboot.project.ProjectService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("data")
public class DataController {
	
	private DataService dataService;

	public DataController(DataService dataService, ColumnService columnService, ProjectService projectService) {
		super();
		this.dataService = dataService;
	}

	//GET /data
	@GetMapping
	public List<Data> getAllData(){
		return dataService.getAllData();
	}
	
	@GetMapping("/projectData/{projectId}")
	public List<Data> getDataByProjectId(@PathVariable Long projectId) {
		List<Data> projectData = dataService.getDataByProjectId(projectId);
		return projectData;
	}
	
	
//	@RequestMapping(value = "/projectCSV/{projectId}", method = RequestMethod.GET, produces = "application/json")
	@GetMapping("/projectCSV/{projectId}")
	public List<Map<String,String>> getProjectAsCSV(@PathVariable Long projectId) {
		return dataService.getProjectAsCSV(projectId);
	}
	
	@PostMapping("/addData")
	public Data addData(@RequestBody DataDTO dataDTO, HttpServletResponse httpResponse) {
	        return dataService.addData(dataDTO);

	}
	
	@PutMapping("/updateData")
	public Data updateData(@Valid @RequestBody DataDTO dataDTO) {
		return dataService.updateData(dataDTO);
	}

}
