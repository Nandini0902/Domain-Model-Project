package com.wedding.exceptions;

public class OrganizersAndVenueNotFoundException extends RuntimeException {
	
	public OrganizersAndVenueNotFoundException() {
		super();
	}

	public OrganizersAndVenueNotFoundException(String message) {
		super(message);
	}
}
