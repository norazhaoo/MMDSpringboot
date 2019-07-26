package com.mmd.MMDSpringboot.data;

public class DataDTO {

	private String rowid;
	private String projectname;
	private String columnname;
	private String columnvalue;
	
	public String getRowid() {
		return rowid;
	}
	public void setRowid(String rowid) {
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

}
