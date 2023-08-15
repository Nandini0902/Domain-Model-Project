package com.wedding.exceptions;

public class PriceAndVenueNotFoundException extends RuntimeException{
	
	public PriceAndVenueNotFoundException() {
		super();
	}

	public PriceAndVenueNotFoundException(String message) {
		super(message);
	}

}
