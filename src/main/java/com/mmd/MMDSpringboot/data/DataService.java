package com.mmd.MMDSpringboot.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mmd.MMDSpringboot.column.ColumnModel;
import com.mmd.MMDSpringboot.column.ColumnService;
import com.mmd.MMDSpringboot.project.Project;
import com.mmd.MMDSpringboot.project.ProjectService;

@Service
public class DataService {
	
	private DataRepository dataRepository;
	private ColumnService columnService;
	private ProjectService projectService;

	public DataService(DataRepository dataRepository, ColumnService columnService, ProjectService projectService) {
		super();
		this.dataRepository = dataRepository;
		this.columnService = columnService;
		this.projectService = projectService;
	}
	
	//get all data
	public List<Data> getAllData(){
		return dataRepository.findAll();
	}
	
	public List<Data> getDataByProjectId(Long projectId){
		return dataRepository.findByProject_Projectid(projectId);
	}
	
	//get data by dataid
	public Data getDataById(Long id) {
		return dataRepository.getOne(id);
	}
	
	//get data by columnname
	public List<Data> getDataByRowid(int rowId) {
		return dataRepository.findByRowid(rowId);
	}

	public Data addData(DataDTO dataDTO) {
	    Data data = new Data();
	    data.setDataid(null);
		data.setProject(projectService.getProjectByProjectname(dataDTO.getProjectname()));
		data.setColumnModel(columnService.getColumnModelByColumnname(dataDTO.getColumnname()));
	    data.setColumnvalue(dataDTO.getColumnvalue());
	    data.setRowid(dataDTO.getRowid());
		return dataRepository.save(data);
	}
	
	public Data updateData(DataDTO dataDTO) {
		//From front end Data object, use project_name to find project
		Project tempProject = projectService.getProjectByProjectname(dataDTO.getProjectname());
		//From front end Data object, use column_name to find columnModel
		ColumnModel tempColumn = columnService.getColumnModelByColumnname(dataDTO.getColumnname());
		
		//using project_id, column_id, row_id, find unique Data_id to perform PUT
		Data tempData = dataRepository.
				findByProject_ProjectidAndColumnModel_ColumnidAndRowid(
						tempProject.getProjectid(), 
						tempColumn.getColumnid(), 
						dataDTO.getRowid());
		
		//once we got the right Data model in our back-end, update the column's value
		tempData.setColumnvalue(dataDTO.getColumnvalue());

		return dataRepository.save(tempData);
	}

	public List<Map<String,String>> getProjectAsCSV(Long projectId) {
		Set<String> columnNameSet = new HashSet<String>();
		
		//  <rowId    <colName>,<colValue>
		Map<String, Map<String,String>> tempCSV = new HashMap<>(); //tempCSV
		List<Data> projectData = getDataByProjectId(projectId); //dataList we're parsing
		for(Data tempData: projectData) {
			columnNameSet.add(tempData.getColumn().getColumnname());
		}

		//populate the HashSet collection
		for(Data tempData : projectData) {
			Map<String, String> columnMap = new HashMap<>();
			if(tempCSV.containsKey(tempData.getRowid())) {
				//retrieve value and replace appropriate string array
				columnMap = tempCSV.get(tempData.getRowid());
				columnMap.replace(tempData.getColumn().getColumnname(), tempData.getColumnvalue());
			}else {
				//add new string array with default values
				for(String tempString : columnNameSet) {
					columnMap.put(tempString, "");
				}
				columnMap.put("rowid", tempData.getRowid()+"");
				//replace default value with real value
				columnMap.replace(tempData.getColumn().getColumnname(), tempData.getColumnvalue());
			}
			tempCSV.put(tempData.getRowid(), columnMap);
		}
		
		List<Map<String,String>> listOfRows = new ArrayList<Map<String,String>>();
        for (Entry<String, Map<String, String>> entry : tempCSV.entrySet()) {
        	listOfRows.add(entry.getValue());
        }

		return listOfRows;
	}
	

}
