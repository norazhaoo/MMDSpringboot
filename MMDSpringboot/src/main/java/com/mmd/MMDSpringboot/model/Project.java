package com.mmd.MMDSpringboot.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Project {

	@Id
	@GeneratedValue
	int id;
	String projectname;
	
	@OneToMany(mappedBy="project")
	List<Data> projectdata;

	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	public String getProjectname() {return projectname;}
	public void setProjectname(String projectname) {this.projectname = projectname;}

	public List<Data> getProjectdata() {return projectdata;}

	public void setProjectdata(List<Data> projectdata) {this.projectdata = projectdata;}
	
	@Override
	public String toString() {
		return "Project [id=" + id + ", projectname=" + projectname + ", projectdata=" + projectdata + "]";
	}
	
	
}
