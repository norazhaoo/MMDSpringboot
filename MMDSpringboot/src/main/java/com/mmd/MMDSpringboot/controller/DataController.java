package com.mmd.MMDSpringboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmd.MMDSpringboot.dao.DataDao;
import com.mmd.MMDSpringboot.model.Data;
import com.mmd.MMDSpringboot.service.DataService;

@RestController
public class DataController {

	@Autowired
	private DataService dataService;
	
    @RequestMapping("/data")
    public List<Data> getAllData() {
    	return dataService.getAllData();
    }
	
    @RequestMapping("/data/{dataid}")
    public List<Data> getDataById(@PathVariable("dataid") int dataid) {
    	return dataService.findAllByProjectid(dataid);
    }
    
    @RequestMapping("/project/{projectid}")
    public List<Data> findAllByProjectid(@PathVariable("projectid") int projectid) {
    	List<Data> specificProject = dataService.findAllByProjectid(projectid);
//    	ArrayList<String> arrayOfColumns = new ArrayList<String>();
//    	for(Data tempData: specificProject) {
//    		arrayOfColumns.add(tempData.getColumnname());
//    	}
    	return specificProject;
    }
	
	@PostMapping("/addData")
	public Data addData(@RequestBody Data data) {
		return dataService.addData(data);
	}
	
    @PutMapping("/updateData")
    public Data saveOrUpdateData(@RequestBody Data data) {
    	dataService.saveOrUpdateData(data);
        return data;
    }
	
	
}
