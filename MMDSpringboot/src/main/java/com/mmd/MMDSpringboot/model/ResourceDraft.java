package com.mmd.MMDSpringboot.model;


import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
//@Table(name = "ResourceDraft")
public class ResourceDraft /*implements Serializable*/{

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	@Id
	//@Column(name = "resource_code")
	private String resource_code;
	
	//@Column(name = "resource_name")
	private String resource_name;
	/*public ResourceDraft(String resource_code, String resource_name) {
		this.resource_code = resource_code;
		this.resource_name = resource_name;
	}
*/
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
	
		
	}
