package com.apimoradoresderua.homeless.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AgeBetwennMustBeWithTwotFoundException extends ResponseStatusException  {
	
	private static final long serialVersionUID = 1L;

	public AgeBetwennMustBeWithTwotFoundException() {
		super(HttpStatus.BAD_REQUEST, "AgeBetwenn Must Be With Twot FoundException!");
	}

}
