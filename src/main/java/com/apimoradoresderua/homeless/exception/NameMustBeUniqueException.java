package com.apimoradoresderua.homeless.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NameMustBeUniqueException extends ResponseStatusException{
	
	private static final long serialVersionUID = 1L;
	
	public NameMustBeUniqueException() {
		super(HttpStatus.BAD_REQUEST, "firstName must be unique !");
	}
}
