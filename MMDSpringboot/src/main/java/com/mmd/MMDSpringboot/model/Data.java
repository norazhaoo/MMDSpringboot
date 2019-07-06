package com.mmd.MMDSpringboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Data {

	@Id
	@GeneratedValue
	private int dataid;
	private int projectid;
	private int rowid;
	private String projectname;
	private String columnname;
	private String columnvalue;
	private String columntype;
	
	private Project project;
	
	public int getDataid() {
		return dataid;
	}
	public void setDataid(int dataid) {
		this.dataid = dataid;
	}
	public int getProjectid() {
		return projectid;
	}
	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
	public int getRowid() {
		return rowid;
	}
	public void setRowid(int rowid) {
		this.rowid = rowid;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String getColumnname() {
		return columnname;
	}
	public void setColumnname(String columnname) {
		this.columnname = columnname;
	}
	public String getColumnvalue() {
		return columnvalue;
	}
	public void setColumnvalue(String columnvalue) {
		this.columnvalue = columnvalue;
	}
	public String getColumntype() {
		return columntype;
	}
	public void setColumntype(String columntype) {
		this.columntype = columntype;
	}
	
	@Override
	public String toString() {
		return "Data [dataid=" + dataid + ", projectid=" + projectid + ", rowid=" + rowid + ", projectname="
				+ projectname + ", columnname=" + columnname + ", columnvalue=" + columnvalue + ", columntype="
				+ columntype + "]";
	}
	
	
}
