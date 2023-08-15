package com.wedding.exceptions;

public class OrganizersNotFoundException extends RuntimeException{
	
	public OrganizersNotFoundException() {
		super();
	}

	public OrganizersNotFoundException(String message) {
		super(message);
	}

}
