package com.mmd.MMDSpringboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;


@Entity
@Table(name = "Resource")
@SecondaryTable(name = "ResourceDraft")
public class Resource implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(updatable = false, nullable=false)
	@GeneratedValue
	private int id;

	@Column(table = "ResourceDraft")
	private String resource_code;
	
	@Column(table = "ResourceDraft")
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
