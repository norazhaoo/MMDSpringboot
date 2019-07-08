package com.mmd.MMDSpringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.mmd.MMDSpringboot.dao.DataDao;
import com.mmd.MMDSpringboot.model.Data;
@Service
public class DataService implements DataServiceInterface{
	@Autowired
	private DataDao dataDao;
	
    @Override
    public List<Data> getAllData() {
    	return dataDao.findAll();
    }
	
    @Override
    public List<Data> getDataById(@PathVariable("dataid") int dataid) {
    	return dataDao.findAllByDataid(dataid);
    }
    
    @Override
    public List<Data> findAllByProjectid(@PathVariable("projectid") int projectid) {
    	List<Data> specificProject = dataDao.findAllByProjectid(projectid);
//    	ArrayList<String> arrayOfColumns = new ArrayList<String>();
//    	for(Data tempData: specificProject) {
//    		arrayOfColumns.add(tempData.getColumnname());
//    	}
    	return specificProject;
    }
	
    @Override
	public Data addData(@RequestBody Data data) {
		return dataDao.save(data);
	}
	
    @Override
    public Data saveOrUpdateData(@RequestBody Data data) {
    	dataDao.save(data);
        return data;
    }
	
}

