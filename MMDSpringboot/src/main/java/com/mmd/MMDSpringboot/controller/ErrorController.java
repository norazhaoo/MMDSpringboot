package com.mmd.MMDSpringboot.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mmd.MMDSpringboot.ErrorHandling;


@ControllerAdvice
@RestController
public class ErrorController extends ResponseEntityExceptionHandler {

	  @ExceptionHandler(ErrorException.class)
	  public ErrorHandling ErrorException(ErrorException ex, String message) {
		  ErrorHandling error = new ErrorHandling();
		  error.setMessage(message);
		  return error;
	  }
}
