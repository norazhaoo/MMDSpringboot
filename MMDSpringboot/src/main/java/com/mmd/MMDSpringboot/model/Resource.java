package com.mmd.MMDSpringboot.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Resource")
public class Resource  {

	
	private int id;

	//@Column(table = "ResourceDraft")
	private String resource_code;
	
	//@Column(table = "ResourceDraft")
	private String resource_name;
	public Resource() {
		
	}
	
	public Resource(Integer id, String resource_code, String resource_name ) {
		this.id = id;
		this.resource_code = resource_code;
		this.resource_name = resource_name;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "resource_code", nullable = false)
	public String getResource_code() {
		return resource_code;
	}
	
	@Column(name = "resource_name", nullable = false)
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

