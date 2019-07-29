package com.mmd.MMDSpringboot.column;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mmd.MMDSpringboot.project.Project;
import com.mmd.MMDSpringboot.project.ProjectRepository;

@Service
public class ColumnService {
	
	private ColumnRepository columnRepository;
	private ProjectRepository projectRepository;

	public ColumnService(ColumnRepository columnRepository, ProjectRepository projectRepository) {
		super();
		this.columnRepository = columnRepository;
		this.projectRepository = projectRepository;
	}
	
	//get all columns
	public List<ColumnModel> getAllColumns(){
		return columnRepository.findAll();
	}
	
	//get column by columnid
	public ColumnModel getColumnModelById(Long id) {
		return columnRepository.getOne(id);
	}
	
	//get column by columnname
	public ColumnModel getColumnModelByColumnname(String columnname) {
		return columnRepository.findByColumnname(columnname);
	}
	
	public ColumnModel addColumn(ColumnDTO columnDTO) {
		ColumnModel columnModel = new ColumnModel();
		columnModel.setColumnid(null);
		columnModel.setColumnname(columnDTO.getColumnname());
		columnModel.setColumntype(columnDTO.getColumntype());
		Project project = projectRepository.findByProjectname(columnDTO.getProjectname());
		columnModel.setProject(project);
		return columnRepository.save(columnModel);
	}
	
	public Long updateColumn(Long id, ColumnModel columnModel) {
		columnModel.setColumnid(id);
		columnRepository.save(columnModel);
		return columnRepository.getOne(id).getColumnid();
	}

}
