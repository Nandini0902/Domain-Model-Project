package com.wedding.service;

import java.util.List;

import java.util.stream.Collectors;

import com.wedding.dao.IWeddingDao;
import com.wedding.dao.WeddingDaoImpl;
import com.wedding.exceptions.OrganizersNotFoundException;
import com.wedding.exceptions.FoodItemsNotFoundException;
import com.wedding.exceptions.OrganizersAndVenueNotFoundException;
import com.wedding.exceptions.PriceAndVenueNotFoundException;
import com.wedding.exceptions.PriceNotFoundException;
import com.wedding.exceptions.VenueNotFoundException;
import com.wedding.model.WeddingPlanner;

public class WeddingServiceImpl implements IWeddingService {

	IWeddingDao weddingService = new WeddingDaoImpl();

	@Override
	public void addWeddingPlanner(WeddingPlanner weddingPlanner) {
		weddingService.addWeddingPlanner(weddingPlanner);

	}

	@Override
	public int updateWeddingPlanner(int bookingId, String foodItems) {
		return weddingService.updateWeddingPlanner(bookingId, foodItems);
	}

	@Override
	public void deleteWeddingPlanner(int bookingId) {
		weddingService.deleteWeddingPlanner(bookingId);

	}

	@Override
	public List<WeddingPlanner> getByPrice(float price)throws PriceNotFoundException {
		List<WeddingPlanner> weddingPlanners = weddingService.findByPrice(price);
		if(weddingPlanners.isEmpty()) 
			 throw new PriceNotFoundException("Wedding Plan is not Found within this range");
		
			
			return weddingService.findByPrice(price);
		
	}

	@Override
	public WeddingPlanner getById(int bookingId) {
		return weddingService.findById(bookingId);
	}

	@Override
	public List<WeddingPlanner> getAllQueries() {
		return weddingService.findAllQueries();
	}

	@Override
	public List<WeddingPlanner> getByOrganizers(String organizers) throws OrganizersNotFoundException {
		List<WeddingPlanner> weddingPlanners = weddingService.findByOrganizers(organizers);
		if(weddingPlanners.isEmpty()) 
		 throw new OrganizersNotFoundException("Organizers with this name is not Found");
	
		return weddingService.findByOrganizers(organizers);
	}

	@Override
	public List<WeddingPlanner> getByVenue(String venue) throws VenueNotFoundException {
		List<WeddingPlanner> weddingPlanners = weddingService.findByVenue(venue);
		if(weddingPlanners.isEmpty()) 
		 throw new VenueNotFoundException("Venue with this name is not Found");
		
		return weddingService.findByVenue(venue);
	}

	@Override
	public List<WeddingPlanner> getByfoodItems(String foodItems) throws FoodItemsNotFoundException {
		List<WeddingPlanner> weddingPlanners = weddingService.findByfoodItems(foodItems);
		if(weddingPlanners.isEmpty()) 
		 throw new FoodItemsNotFoundException("FoodItems is Not Found");
	
		
		return weddingService.findByfoodItems(foodItems);
	}

	@Override
	public List<WeddingPlanner> getByOrganizersAndVenue(String organizers, String venue)
			throws OrganizersNotFoundException {
		List<WeddingPlanner> weddingPlanners = weddingService.findByOrganizersAndVenue(organizers,venue);
		if(weddingPlanners.isEmpty()) 
		 throw new OrganizersAndVenueNotFoundException("Organizers and Venue with these names is not Found");
		return weddingService.findByOrganizersAndVenue(organizers, venue);

	}

	@Override
	public List<WeddingPlanner> getByPriceAndVenue(float price, String venue) throws PriceAndVenueNotFoundException {
		List<WeddingPlanner> weddingPlanners= weddingService.findByPriceAndVenue(price,venue);
		if(weddingPlanners.isEmpty()) 
		 throw new PriceAndVenueNotFoundException("Price and Venue with these names is not Found");
		return weddingService.findByPriceAndVenue(price, venue);
		

	}

}
