package com.mmd.MMDSpringboot.column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mmd.MMDSpringboot.project.Project;

@Entity
public class ColumnModel {

	@Id
	@GeneratedValue
	private Long columnid;
	
	//represents projectid
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "projectid", nullable = false)
	private Project project;
	
	private String columnname;
	private String columntype;
	
	public Long getColumnid() {
		return columnid;
	}
	public void setColumnid(Long columnid) {
		this.columnid = columnid;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public String getColumnname() {
		return columnname;
	}
	public void setColumnname(String columnname) {
		this.columnname = columnname;
	}
	public String getColumntype() {
		return columntype;
	}
	public void setColumntype(String columntype) {
		this.columntype = columntype;
	}
	

	
	

	
}
