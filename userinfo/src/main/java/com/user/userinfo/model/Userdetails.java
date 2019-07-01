package com.user.userinfo.model;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.user.userinfo.HashPW;

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
	public void setPass(String pass) throws NoSuchAlgorithmException, InvalidKeySpecException {				
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
		return "UserDetails [id=" + id + ", uname=" + uname + ", pass=" + pass + ", salt=" + salt + "]";
	}
	
	
	
    
	
	
	

	
}
