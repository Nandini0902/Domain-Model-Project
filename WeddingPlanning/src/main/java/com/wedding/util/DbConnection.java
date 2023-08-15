package com.wedding.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

	static Connection connection;

	public static Connection openConnection() {

		String url = "jdbc:mysql://localhost:3306/mysql";
		String username = "root";
		String password = "admin@123";

		try {
			connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			//statement.execute(Queries.CREATE_QUERY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;

	}

	public static void closeConnection() {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
