package com.wedding.model;

public class WeddingPlanner {

	private String organizers;
	private Integer bookingId;
	private String foodItems;
	private String venue;
	private int fieldExperience;
	private float price;

	public WeddingPlanner() {
		super();
	}

	public WeddingPlanner(String organizers,Integer bookingId, String foodItems, String venue, int fieldExperience,
			float price) {
		super();
		this.organizers = organizers;
		this.bookingId = bookingId;
		this.foodItems = foodItems;
		this.venue = venue;
		this.fieldExperience = fieldExperience;
		this.price = price;
	}
//	public WeddingPlanner(String organizers, int bookingId, String foodItems, String venue, int fieldExperience,
//			float price) {
//		super();
//		this.organizers = organizers;
//		this.bookingId = bookingId;
//		this.foodItems = foodItems;
//		this.venue = venue;
//		this.fieldExperience = fieldExperience;
//		this.price = price;
//	}
	

	public String getOrganizers() {
		return organizers;
	}

	public void setOrganizers(String organizers) {
		this.organizers = organizers;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public String getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(String foodItems) {
		this.foodItems = foodItems;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public int getFieldExperience() {
		return fieldExperience;
	}

	public void setFieldExperience(int fieldExperience) {
		this.fieldExperience = fieldExperience;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "WeddingPlanner [organizers=" + organizers + ", bookingId=" + bookingId + ", foodItems=" + foodItems
				+ ", venue=" + venue + ", fieldExperience=" + fieldExperience + ", price=" + price + "]";
	}

}