package com.mmd.MMDSpringboot.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

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

	public Long addData(Long projId, Long colId, Data data) {
		data.setDataid(null);
		data.setProject(projectService.getProjectById(projId));
		data.setColumnModel(columnService.getColumnModelById(colId));
		return dataRepository.save(data).getDataid();
	}
	
	public Long updateData(Long dataId, Data data) {
		Data tempData = dataRepository.getOne(dataId);
		ColumnModel tempColumn = columnService.getColumnModelById(tempData.getColumn().getColumnid());
		Project tempProject = projectService.getProjectById(tempData.getProject().getProjectid());
		tempData.setColumnModel(tempColumn);
		tempData.setProject(tempProject);
		tempData.setColumnvalue(data.getColumnvalue());
		tempData.setRowid(data.getRowid());
		tempData.setDataid(dataId);
		dataRepository.save(tempData);
		return dataRepository.getOne(dataId).getDataid();
	}

	public List<Map<String,String>> getProjectAsCSV(Long projectId) {
		Set<String> columnNameSet = new HashSet<String>();
		
		//  <rowId    <colName>,<colValue>
		Map<Integer, Map<String,String>> tempCSV = new HashMap<>(); //tempCSV
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
        for (Entry<Integer, Map<String, String>> entry : tempCSV.entrySet()) {
        	listOfRows.add(entry.getValue());
        }

		return listOfRows;
	}
	

}
