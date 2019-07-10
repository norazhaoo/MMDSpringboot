package com.mmd.MMDSpringboot.data;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mmd.MMDSpringboot.column.ColumnModel;
import com.mmd.MMDSpringboot.project.Project;

@Entity
public class Data {

	@Id
	@GeneratedValue
	private Long dataid;


	//represents projectid
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "projectid", nullable = false)
	@JsonIgnore
	private Project project;


	//represents columnid
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "columnid", nullable = false)
	@JsonIgnore
	private ColumnModel columnModel;

	private int rowid;
	private String columnvalue;
	
	public Long getDataid() {return dataid;}
	public void setDataid(Long dataid) {this.dataid = dataid;}
	
	public Project getProject() {return project;}
	public void setProject(Project project) {this.project = project;}
	
	public ColumnModel getColumn() {return columnModel;}
	public void setColumnModel(ColumnModel columnModel) {this.columnModel = columnModel;}
	
	public int getRowid() {return rowid;}
	public void setRowid(int rowid) {this.rowid = rowid;}
	
	public String getColumnvalue() {return columnvalue;}
	public void setColumnvalue(String columnvalue) {this.columnvalue = columnvalue;}
	
	@Override
	public String toString() {
		return "Data [dataid=" + dataid + ", project=" + project + ", columnModel=" + columnModel + ", rowid=" + rowid
				+ ", columnvalue=" + columnvalue + "]";
	}
	
}
