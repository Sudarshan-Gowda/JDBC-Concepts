package com.star.sud.jdbc.connection.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatementExample {

	private static String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	// private static String URL = "jdbc:mysql://localhost:3306/testdb";
	private static String URL_WITH_TIMEZONE = "jdbc:mysql://localhost:3306/testdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	public static void main(String[] args) throws Exception {
		Connection connection = null;
		PreparedStatement preparedstmt = null;
		ResultSet resultSet = null;

		try {

			// Step1: Load and Register the driver
			Class.forName(DRIVER_CLASS);

			// Step2: Establish connection
			connection = DriverManager.getConnection(URL_WITH_TIMEZONE, "root", "root");

			// Step3: Create statement or platform
			String query = "select * from Users where USER_NAME= ?";
			preparedstmt = connection.prepareStatement(query);
			preparedstmt.setString(1, "User");

			// Step4: Execute SQL statement
			resultSet = preparedstmt.executeQuery();

			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Step5: Close Connection
			if (resultSet != null)
				resultSet.close();
			if (preparedstmt != null)
				preparedstmt.close();
			if (connection != null)
				connection.close();
		}
	}

}
