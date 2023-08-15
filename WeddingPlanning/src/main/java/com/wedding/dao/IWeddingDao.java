package com.wedding.dao;

import java.util.List;


import com.wedding.exceptions.OrganizersNotFoundException;
import com.wedding.exceptions.FoodItemsNotFoundException;
import com.wedding.exceptions.PriceAndVenueNotFoundException;
import com.wedding.exceptions.PriceNotFoundException;
import com.wedding.exceptions.VenueNotFoundException;
import com.wedding.model.WeddingPlanner;

public interface IWeddingDao {
	
	void addWeddingPlanner(WeddingPlanner weddingPlanner);
	
	int updateWeddingPlanner(int bookingId,String foodItems);
	
	void deleteWeddingPlanner(int bookingId);
	
	WeddingPlanner findById(int bookingId);
	
	List<WeddingPlanner> findByPrice(float price)throws PriceNotFoundException ;
	
	List<WeddingPlanner> findAllQueries();
	
	List<WeddingPlanner> findByOrganizers(String organizers) throws OrganizersNotFoundException;
	
	List<WeddingPlanner> findByVenue(String venue) throws VenueNotFoundException;
	
	List<WeddingPlanner> findByfoodItems(String foodItems) throws FoodItemsNotFoundException;
	
    List<WeddingPlanner> findByOrganizersAndVenue(String organizers,String venue)throws OrganizersNotFoundException;
    
    List<WeddingPlanner> findByPriceAndVenue(float price,String venue) throws PriceAndVenueNotFoundException;

}
