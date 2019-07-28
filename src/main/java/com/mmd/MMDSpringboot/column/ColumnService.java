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
	
	public ColumnModel addColumn(ColumnDTO columnDTO) {
		ColumnModel columnModel = new ColumnModel();
		columnModel.setColumnid(null);
		columnModel.setColumnname(columnDTO.getColumnname());
		columnModel.setColumntype(columnDTO.getColumntype());
		return columnRepository.save(columnModel);
	}
	
	public Long updateColumn(Long id, ColumnModel columnModel) {
		columnModel.setColumnid(id);
		columnRepository.save(columnModel);
		return columnRepository.getOne(id).getColumnid();
	}

}
