package com.jason.SpringBootJPASQLServer.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Data {
	@Id
	private String data_id;
	private String project_id;
	private String project_name;
	private String column_name;
	private String column_value;
	private String column_type;
	
	public String getProject_id() {
		return project_id;
	}
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getColumn_name() {
		return column_name;
	}
	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}
	public String getColumn_value() {
		return column_value;
	}
	public void setColumn_value(String column_value) {
		this.column_value = column_value;
	}
	public String getColumn_type() {
		return column_type;
	}
	public void setColumn_type(String column_type) {
		this.column_type = column_type;
	}

	@Override
	public String toString() {
		return "data [project_id=" + project_id + ", project_name=" + project_name + ", column_name=" + column_name
				+ ", column_value=" + column_value + ", column_type=" + column_type + "]";
	}

}
