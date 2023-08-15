package com.wedding.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wedding.exceptions.OrganizersNotFoundException;
import com.wedding.exceptions.PriceAndVenueNotFoundException;
import com.wedding.exceptions.PriceNotFoundException;
import com.wedding.exceptions.FoodItemsNotFoundException;
import com.wedding.exceptions.OrganizersAndVenueNotFoundException;
import com.wedding.exceptions.VenueNotFoundException;
import com.wedding.model.WeddingPlanner;
import com.wedding.util.DbConnection;
import com.wedding.util.Queries;

public class WeddingDaoImpl implements IWeddingDao {

	@Override
	public void addWeddingPlanner(WeddingPlanner weddingPlanner) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.INSERT_QUERY);) {
			preparedStatement.setString(1, weddingPlanner.getOrganizers());
			preparedStatement.setInt(2, weddingPlanner.getBookingId());
			preparedStatement.setString(3, weddingPlanner.getFoodItems());
			preparedStatement.setString(4, weddingPlanner.getVenue());
			preparedStatement.setInt(5, weddingPlanner.getFieldExperience());
			preparedStatement.setFloat(6, weddingPlanner.getPrice());
			preparedStatement.execute();
			System.out.println("------Wedding Planning is added successfully----- ");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int updateWeddingPlanner(int bookingId, String foodItems) {

		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.UPDATE_QUERY);) {
			preparedStatement.setString(1, foodItems);
			preparedStatement.setInt(2, bookingId);
			preparedStatement.execute();
			System.out.println("------Wedding Planning is updated successfully----- ");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bookingId;
	}

	@Override
	public void deleteWeddingPlanner(int bookingId) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.DELETE_QUERY);) {
			preparedStatement.setInt(1, bookingId);
			preparedStatement.execute();
			System.out.println("-----Value is deleted successfully----- ");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<WeddingPlanner> findByPrice(float price) throws PriceNotFoundException {
		List<WeddingPlanner> priceList = new ArrayList<WeddingPlanner>();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.QUERYBYPRICE);) {
			preparedStatement.setFloat(1, price);
			System.out.println("Fetching Wedding Plannings with the required Price: ");
			// System.out.println();
			try (ResultSet rs = preparedStatement.executeQuery();) {
				while (rs.next()) {
					String organizers = rs.getString("organizers");
					int bookingId = rs.getInt("bookingId");
					String foodItems = rs.getString("foodItems");
					Integer fieldExperience = rs.getInt("fieldExperience");
					String venue = rs.getString("venue");
					float price1 = rs.getFloat("price");
					System.out.println();
					System.out
							.println("------Price within the given range " + price1 + " is found  successfully----- ");
					WeddingPlanner weddingPlanner = new WeddingPlanner(organizers, bookingId, foodItems, venue,
							fieldExperience, price1);
					priceList.add(weddingPlanner);
					System.out.println(weddingPlanner.toString());
				}
			}
			return priceList;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<WeddingPlanner> findAllQueries() {
		List<WeddingPlanner> weddingList = new ArrayList<WeddingPlanner>();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.ALL_QUERIES);) {
			System.out.println("Fetching all Wedding Plannings.....");
			System.out.println();
			try (ResultSet weddingResultSet = preparedStatement.executeQuery();) {
				while (weddingResultSet.next()) {
					String organizers = weddingResultSet.getString("organizers");
					int bookingId = weddingResultSet.getInt("bookingId");
					String foodItems = weddingResultSet.getString("foodItems");
					String venue = weddingResultSet.getString("venue");
					Integer fieldExperience = weddingResultSet.getInt("fieldExperience");
					float price = weddingResultSet.getFloat("price");
					WeddingPlanner weddingPlanner = new WeddingPlanner(organizers, bookingId, foodItems, venue,
							fieldExperience, price);
					weddingList.add(weddingPlanner);
					// System.out.println(weddingList.toString());
				}
				return weddingList;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<WeddingPlanner> findByOrganizers(String organizers) throws OrganizersNotFoundException {

		List<WeddingPlanner> weddingList = new ArrayList<WeddingPlanner>();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement organizerStatement = connection.prepareStatement(Queries.GETBYORGANIZERS);) {
			organizerStatement.setString(1, organizers);
			System.out.println();

			try (ResultSet organizersResultSet = organizerStatement.executeQuery()) {
				while (organizersResultSet.next()) {
					String organizers1 = organizersResultSet.getString("organizers");
					int bookingId = organizersResultSet.getInt("bookingId");
					String venue = organizersResultSet.getString("venue");
					String foodItems = organizersResultSet.getString("foodItems");
					Integer fieldExperience = organizersResultSet.getInt("fieldExperience");
					float price = organizersResultSet.getFloat("price");

					WeddingPlanner weddingPlanner = new WeddingPlanner(organizers1, bookingId, foodItems, venue,
							fieldExperience, price);

					weddingList.add(weddingPlanner);
					// weddingPlanner.toString();
				}

			}
			return weddingList;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	@Override
	public List<WeddingPlanner> findByVenue(String venue) throws VenueNotFoundException {
		List<WeddingPlanner> weddingList = new ArrayList<WeddingPlanner>();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement venueStatement = connection.prepareStatement(Queries.GETBYVENUE);) {
			venueStatement.setString(1, venue);
			System.out.println();

			try (ResultSet venueResultSet = venueStatement.executeQuery()) {
				while (venueResultSet.next()) {
					String organizers = venueResultSet.getString("organizers");
					int bookingId = venueResultSet.getInt("bookingId");
					String foodItems = venueResultSet.getString("foodItems");
					Integer fieldExperience = venueResultSet.getInt("fieldExperience");
					float price = venueResultSet.getFloat("price");
					WeddingPlanner weddingPlanner = new WeddingPlanner(organizers, bookingId, foodItems, venue,
							fieldExperience, price);

					weddingList.add(weddingPlanner);
				}
			}
			return weddingList;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<WeddingPlanner> findByfoodItems(String foodItems) throws FoodItemsNotFoundException {

		List<WeddingPlanner> weddingList = new ArrayList<WeddingPlanner>();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement foodItemsStatement = connection.prepareStatement(Queries.GETBYFOODITEMS);) {
			foodItemsStatement.setString(1, foodItems);
			System.out.println();
			try (ResultSet foodItemsResultSet = foodItemsStatement.executeQuery()) {
				while (foodItemsResultSet.next()) {
					String organizers = foodItemsResultSet.getString("organizers");
					int bookingId = foodItemsResultSet.getInt("bookingId");
					String foodItems1 = foodItemsResultSet.getString("foodItems");
					String venue = foodItemsResultSet.getString("venue");
					Integer fieldExperience = foodItemsResultSet.getInt("fieldExperience");
					float price = foodItemsResultSet.getFloat("price");
					WeddingPlanner weddingPlanner = new WeddingPlanner(organizers, bookingId, foodItems1, venue,
							fieldExperience, price);

					weddingList.add(weddingPlanner);
				}
				return weddingList;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<WeddingPlanner> findByOrganizersAndVenue(String organizers, String venue)
			throws OrganizersAndVenueNotFoundException {

		List<WeddingPlanner> weddingList = new ArrayList<>();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.GETBYORGANIZERSANDVENUE);) {

			preparedStatement.setString(1, organizers);
			preparedStatement.setString(2, venue);
			System.out.println();
			try (ResultSet rs = preparedStatement.executeQuery()) {
				while (rs.next()) {
					String organizers1 = rs.getString("organizers");
					int bookingId = rs.getInt("bookingId");
					String foodItems = rs.getString("foodItems");
					String venue1 = rs.getString("venue");
					Integer fieldExperience = rs.getInt("fieldExperience");
					float price = rs.getFloat("price");

					WeddingPlanner weddingPlanner = new WeddingPlanner(organizers1, bookingId, foodItems, venue1,
							fieldExperience, price);
					weddingList.add(weddingPlanner);
					
				}
				return weddingList;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<WeddingPlanner> findByPriceAndVenue(float price, String venue) throws PriceAndVenueNotFoundException {

		List<WeddingPlanner> weddingList = new ArrayList<>();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.GETBYPRICEANDVENUE);) {

			preparedStatement.setFloat(1, price);
			preparedStatement.setString(2, venue);
			
			try (ResultSet rs = preparedStatement.executeQuery()) {
				while (rs.next()) {
					String organizers = rs.getString("organizers");
					int bookingId = rs.getInt("bookingId");
					String foodItems = rs.getString("foodItems");
					String venue1 = rs.getString("venue");
					Integer fieldExperience = rs.getInt("fieldExperience");
					float price1 = rs.getFloat("price");
					WeddingPlanner weddingPlanner = new WeddingPlanner(organizers, bookingId, foodItems, venue1,
							fieldExperience, price1);
					weddingList.add(weddingPlanner);
					

				}
				return weddingList;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public WeddingPlanner findById(int bookingId) {

		WeddingPlanner weddingPlanner = new WeddingPlanner();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.QUERYBYID);) {
			preparedStatement.setInt(1, bookingId);
			try (ResultSet rs = preparedStatement.executeQuery();) {
				while (rs.next()) {
					String organizers = rs.getString("organizers");
					int bookingId1 = rs.getInt("bookingId");
					String foodItems = rs.getString("foodItems");
					String venue = rs.getString("venue");
					Integer fieldExperience = rs.getInt("fieldExperience");
					float price = rs.getFloat("price");

					weddingPlanner.setOrganizers(organizers);
					weddingPlanner.setBookingId(bookingId1);
					weddingPlanner.setFoodItems(foodItems);
					weddingPlanner.setFieldExperience(fieldExperience);
					weddingPlanner.setPrice(price);
					System.out.println("------Wedding Plan is found sucesfully-----");
					System.out.println(weddingPlanner.toString());
				}
				return weddingPlanner;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
