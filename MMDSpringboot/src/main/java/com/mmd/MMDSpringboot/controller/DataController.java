package com.mmd.MMDSpringboot.controller;

<<<<<<< HEAD
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
=======
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
>>>>>>> develop
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmd.MMDSpringboot.dao.DataDao;
import com.mmd.MMDSpringboot.model.Data;
<<<<<<< HEAD
import com.mmd.MMDSpringboot.service.DataService;
=======
import com.mmd.MMDSpringboot.model.Resource;
>>>>>>> develop

@RestController
public class DataController {

	@Autowired
<<<<<<< HEAD
	private DataService dataService;
	
    @RequestMapping("/data")
    public List<Data> getAllData() {
    	return dataService.getAllData();
=======
	DataDao dataDao;
	
    @RequestMapping("/data")
    public List<Data> getAllData() {
    	return dataDao.findAll();
>>>>>>> develop
    }
	
    @RequestMapping("/data/{dataid}")
    public List<Data> getDataById(@PathVariable("dataid") int dataid) {
<<<<<<< HEAD
    	return dataService.findAllByProjectid(dataid);
=======
    	return dataDao.findAllByDataid(dataid);
>>>>>>> develop
    }
    
    @RequestMapping("/project/{projectid}")
    public List<Data> findAllByProjectid(@PathVariable("projectid") int projectid) {
<<<<<<< HEAD
    	List<Data> specificProject = dataService.findAllByProjectid(projectid);
=======
    	List<Data> specificProject = dataDao.findAllByProjectid(projectid);
>>>>>>> develop
//    	ArrayList<String> arrayOfColumns = new ArrayList<String>();
//    	for(Data tempData: specificProject) {
//    		arrayOfColumns.add(tempData.getColumnname());
//    	}
    	return specificProject;
    }
	
	@PostMapping("/addData")
	public Data addData(@RequestBody Data data) {
<<<<<<< HEAD
		return dataService.addData(data);
	}
	
    @PutMapping("/updateData")
    public Data saveOrUpdateData(@RequestBody Data data) {
    	dataService.saveOrUpdateData(data);
=======
		return dataDao.save(data);
	}
	
    @PutMapping(path = "/updateData", consumes = {"application/json"})
    public Data saveOrUpdateData(@RequestBody Data data) {
    	dataDao.save(data);
>>>>>>> develop
        return data;
    }
	
	
}
