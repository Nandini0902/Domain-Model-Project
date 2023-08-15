package com.wedding.util;

public class Queries {

	public static final String CREATE_QUERY = "create table weddingplanner(organizers varchar(50),bookingId integer primary key,"
			+ "foodItems varchar(120),venue varchar(40),fieldExperience int,price float)";
	public static final String INSERT_QUERY = "insert into weddingplanner(organizers,bookingId,foodItems,venue,fieldExperience,price) values(?,?,?,?,?,?)";
	public static final String UPDATE_QUERY = "update weddingplanner set foodItems = ? where bookingId = ?";
	public static final String DELETE_QUERY = "delete from weddingplanner where bookingId=?";
	public static final String QUERYBYPRICE = "select * from weddingplanner where price <= ?";
	public static final String QUERYBYID = "select * from weddingplanner where bookingId = ?";
	public static final String ALL_QUERIES = "select * from weddingplanner";
	public static final String GETBYORGANIZERS = "select * from weddingplanner where organizers=?";
	public static final String GETBYVENUE = "select * from weddingplanner where venue = ?";
	public static final String GETBYFOODITEMS = "select * from weddingplanner where foodItems = ?";
	public static final String GETBYORGANIZERSANDVENUE = "select * from weddingplanner where organizers = ? and venue = ?";
	public static final String GETBYPRICEANDVENUE = "select * from weddingplanner where price <= ? and venue = ?";

}
