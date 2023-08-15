package com.wedding.client;

import java.util.List;
import java.util.Scanner;

import com.wedding.model.WeddingPlanner;
import com.wedding.service.IWeddingService;
import com.wedding.service.WeddingServiceImpl;
import com.wedding.exceptions.*;
public class WeddingMain  {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		IWeddingService weddingService = new WeddingServiceImpl();
		System.out.println(
				"1.Add Wedding Planning\n 2. Update Wedding Planning\n 3.Delete Wedding Planning\n 4.Get All Wedding Plannings\n 5.Get Plannings By Price\n 6.Get Wedding Plannings by Specific Organizers\n 7.Get Wedding Plannings by Venue\n 8.Get Wedding Plannings by Specific Food Items\n 9.Get Wedding Plannings by Specific Organizers and Venue\n 10.Get Wedding Plannings by Specific Price and Venue\n 11.Get Wedding Plannings by ID's  ");
		int choice = scanner.nextInt();
		if (choice == 1) {
			scanner.nextLine();
			System.out.println("Enter Organizers name: ");
			String organizers = scanner.nextLine();
			System.out.println("Enter BookingId: ");
			int bookingId = scanner.nextInt();
			System.out.println("Enter FoodItems: ");
			scanner.nextLine();
			String foodItems = scanner.nextLine();
			System.out.println("Enter Venue name: ");
			String venue = scanner.nextLine();
			System.out.println("Enter Field experience: ");
			Integer fieldExperience = scanner.nextInt();
			System.out.println("Enter Price: ");
			float price = scanner.nextFloat();
			WeddingPlanner weddingPlanner = new WeddingPlanner(organizers,bookingId,foodItems, venue, fieldExperience, price);
			weddingService.addWeddingPlanner(weddingPlanner);
			
			
		} else if (choice == 2) {
			System.out.println("Enter BookingId to update foodItems");
			int bookingId = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter foodItems to add to Wedding Planning ");
			String foodItems = scanner.nextLine();
			weddingService.updateWeddingPlanner(bookingId, foodItems);
			
			
		} else if (choice == 3) {
			System.out.println("Enter BookingId to delete value from Wedding Planning");
			int bookingId = scanner.nextInt();
			weddingService.deleteWeddingPlanner(bookingId);
			
			
		} else if (choice == 4) {
			List<WeddingPlanner> weds = weddingService.getAllQueries();
			for(WeddingPlanner wed: weds) {
				System.out.println("Organizers: "+wed.getOrganizers());
				System.out.println("BookingId: "+wed.getBookingId());
				System.out.println("Food Items: "+wed.getFoodItems());
				System.out.println("Venue: "+wed.getVenue());
				System.out.println("Field Experience: "+wed.getFieldExperience());
				System.out.println("Price: "+wed.getPrice());
				System.out.println();
				
			}
		} else if (choice == 5) {
			System.out.println("Enter Price to fetch Wedding Planning within the required Price");
			float price = scanner.nextFloat();
			try {
				weddingService.getByPrice(price);
			}catch (PriceNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
			
			
		} else if (choice == 6) {
			System.out.println("Enter your favourite Organizers to fetch Wedding Plannings: ");
			scanner.nextLine();
			String organizers = scanner.nextLine();
			try {
			System.out.println(weddingService.getByOrganizers(organizers));
			}catch (OrganizersNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
		} else if (choice == 7) {
			System.out.println("Enter your favourite Venue to fetch Wedding Plannings");
			scanner.nextLine();
			String venue = scanner.nextLine();
			try {
			System.out.println(weddingService.getByVenue(venue));
			}catch (VenueNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
		} else if (choice == 8) {
			System.out.println("Enter your favourite Iood Items to fetch Wedding Plannings");
			scanner.nextLine();
			String foodItems = scanner.nextLine();
			try {
			System.out.println(weddingService.getByfoodItems(foodItems));
			}catch (FoodItemsNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
			
			
		} else if (choice == 9) {
			System.out.println("Enter Specific Organizers and Venue to fetch Wedding Plannings");
			System.out.println();
			System.out.println("Enter Organizers: ");
			scanner.nextLine();
			String organizers = scanner.nextLine();
			System.out.println("Enter Venue: ");
			String venue = scanner.nextLine();
			System.out.println("Organizers and Venue as per your requirement is:  ");
			try {
			System.out.println(weddingService.getByOrganizersAndVenue(organizers, venue));
			}catch (OrganizersAndVenueNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
			
			
		} else if (choice == 10) {
			System.out.println("Enter Price and Venue to fetch doctors");
			System.out.println();
			System.out.println("Enter price: ");
			scanner.nextLine();
			float price = scanner.nextFloat();
			System.out.println("Enter Venue: ");
			scanner.nextLine();
			String venue = scanner.nextLine();
			
			System.out.println("Price and Venue as per your requirement is: ");
			System.out.println();
			try {
			System.out.println(weddingService.getByPriceAndVenue(price, venue));
			}
			catch (PriceAndVenueNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
			
		} else {
			System.out.println("Enter Booking Id to get Wedding Plans");
			int bookingId = scanner.nextInt();
			weddingService.getById(bookingId);
		}
		scanner.close();

	}
}
