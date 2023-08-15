package com.wedding.exceptions;

public class FoodItemsNotFoundException extends RuntimeException{
	
	public FoodItemsNotFoundException() {
		super();
	}

	public FoodItemsNotFoundException(String message) {
		super(message);
	}


}
