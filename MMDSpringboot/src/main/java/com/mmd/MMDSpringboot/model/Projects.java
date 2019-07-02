package com.mmd.MMDSpringboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Projects {
@Id
@GeneratedValue
private int id;
private String projectId;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getProjectId() {
	return projectId;
}
public void setProjectId(String projectId) {
	this.projectId = projectId;
}
@Override
public String toString() {
	return "Projects [id=" + id + ", projectId=" + projectId + "]";
}
}
