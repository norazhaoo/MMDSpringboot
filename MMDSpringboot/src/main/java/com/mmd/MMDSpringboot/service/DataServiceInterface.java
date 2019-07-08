package com.mmd.MMDSpringboot.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.mmd.MMDSpringboot.model.Data;

public interface DataServiceInterface {
	public List<Data> getAllData();
	public List<Data> getDataById(@PathVariable("dataid") int dataid) ;
	public List<Data> findAllByProjectid(@PathVariable("projectid") int projectid) ;
	public Data addData(@RequestBody Data data) ;
	public Data saveOrUpdateData(@RequestBody Data data);
	
}
