package com.mmd.MMDSpringboot.project;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.mmd.MMDSpringboot.data.Data;

@Entity
public class Project {

	@Id
	@GeneratedValue
	private Long projectid;
	private String projectname;

	public Long getProjectid() {return projectid;}
	public void setProjectid(Long projectid) {this.projectid = projectid;}
	
	public String getProjectname() {return projectname;}
	public void setProjectname(String projectname) {this.projectname = projectname;}
	
	@Override
	public String toString() {
		return "Project [projectid=" + projectid + ", projectname=" + projectname + "]";
	}
	
	
}
