package com.mmd.MMDSpringboot.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

	public String getProjectAsCSV(Long projectId) {
		String columnNames = "";
		Set<Integer> rowCountSet = new HashSet<Integer>();
		Map<Integer,ArrayList<String>> multiMap = new HashMap<>();
		List<Data> projectData = getDataByProjectId(projectId);
		for(Data tempData: projectData) {
			String columnName = tempData.getColumn().getColumnname();
			columnNames = columnNames + columnName+",";
			rowCountSet.add(tempData.getRowid());
//			multiMap.put(tempData.getRowid(), tempData.getColumnvalue());
		}
		columnNames.substring(0, columnNames.length()-1);
		columnNames += "\n";
		
		int rowCount = rowCountSet.size();

		String [] stringArray = new String[rowCount];
		for(Data tempData: projectData) {

		}
		return "testing";
		
	}

}
