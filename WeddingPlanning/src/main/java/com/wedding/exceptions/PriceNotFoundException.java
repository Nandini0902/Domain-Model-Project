package com.wedding.exceptions;

public class PriceNotFoundException extends RuntimeException{
	public  PriceNotFoundException() {
		super();
	}

	public PriceNotFoundException(String message) {
		super(message);
	}

}
