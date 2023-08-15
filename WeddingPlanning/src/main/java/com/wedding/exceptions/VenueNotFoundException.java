package com.wedding.exceptions;

public class VenueNotFoundException extends RuntimeException{
	
	public VenueNotFoundException() {
		super();
	}

	public VenueNotFoundException(String message) {
		super(message);
	}


}
