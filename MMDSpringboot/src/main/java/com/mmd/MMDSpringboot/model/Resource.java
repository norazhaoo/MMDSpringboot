package com.mmd.MMDSpringboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Resource {

	@Id
	@GeneratedValue
	private int id;
	private String resource_code;
	private String resource_name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResource_code() {
		return resource_code;
	}
	public void setResource_code(String resource_code) {
		this.resource_code = resource_code;
	}
	public String getResource_name() {
		return resource_name;
	}
	public void setResource_name(String resource_name) {
		this.resource_name = resource_name;
	}
	@Override
	public String toString() {
		return "Resource [id=" + id + ", resource_code=" + resource_code + ", resource_name=" + resource_name + "]";
	}
	
	
	
	
}
