package com.mmd.MMDSpringboot.controller;

public class ErrorException extends RuntimeException{
	public ErrorException(String exception) {
	    super(exception);
	  }

}