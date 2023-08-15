package com.wedding.service;

import java.util.List;

import com.wedding.exceptions.OrganizersNotFoundException;
import com.wedding.exceptions.FoodItemsNotFoundException;
import com.wedding.exceptions.PriceAndVenueNotFoundException;
import com.wedding.exceptions.PriceNotFoundException;
import com.wedding.exceptions.VenueNotFoundException;
import com.wedding.model.WeddingPlanner;

public interface IWeddingService {

	void addWeddingPlanner(WeddingPlanner weddingPlanner);

	int updateWeddingPlanner(int bookingId, String foodItems);

	void deleteWeddingPlanner(int bookingId);

	WeddingPlanner getById(int bookingId);

	List<WeddingPlanner> getByPrice(float price)throws PriceNotFoundException;

	List<WeddingPlanner> getAllQueries();

	List<WeddingPlanner> getByOrganizers(String organizers) throws OrganizersNotFoundException;

	List<WeddingPlanner> getByVenue(String venue) throws VenueNotFoundException;

	List<WeddingPlanner> getByfoodItems(String foodItems) throws FoodItemsNotFoundException;

	List<WeddingPlanner> getByOrganizersAndVenue(String organizers, String venue) throws OrganizersNotFoundException;

	List<WeddingPlanner> getByPriceAndVenue(float price, String venue) throws PriceAndVenueNotFoundException;

}
