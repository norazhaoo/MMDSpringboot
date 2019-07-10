package com.mmd.MMDSpringboot.column;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ColumnService {
	
	private ColumnRepository columnRepository;

	public ColumnService(ColumnRepository columnRepository) {
		super();
		this.columnRepository = columnRepository;
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
	
	public Long addColumn(ColumnModel columnModel) {
		columnModel.setColumnid(null);
		return columnRepository.save(columnModel).getColumnid();
	}
	
	public Long updateColumn(Long id, ColumnModel columnModel) {
		columnModel.setColumnid(id);
		columnRepository.save(columnModel);
		return columnRepository.getOne(id).getColumnid();
	}

}
