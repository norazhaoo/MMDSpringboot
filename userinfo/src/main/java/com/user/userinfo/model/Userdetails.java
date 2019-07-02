package com.user.userinfo.model;

import java.util.Arrays;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Userdetails {
	@Id
	private int id;
	private String uname;
	private String pass;
	private byte[] salt;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUname() {
		return uname;
	}
	
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public byte[] getSalt() {
		return salt;
	}
	
	public void setSalt(byte[] salt) {
		this.salt = salt;
	}
	
	@Override
	public String toString() {
		return "Userdetails [id=" + id + ", uname=" + uname + ", pass=" + pass + ", salt=" + Arrays.toString(salt)
				+ "]";
	}
}
