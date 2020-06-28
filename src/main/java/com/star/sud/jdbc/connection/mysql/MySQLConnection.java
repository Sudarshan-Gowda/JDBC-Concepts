package com.star.sud.jdbc.connection.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLConnection {

	private static String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	// private static String URL = "jdbc:mysql://localhost:3306/testdb";
	private static String URL_WITH_TIMEZONE = "jdbc:mysql://localhost:3306/testdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	public static void main(String[] args) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {

			// Step1: Load and Register the driver
			Class.forName(DRIVER_CLASS);

			// Step2: Establish connection
			connection = DriverManager.getConnection(URL_WITH_TIMEZONE, "root", "root");

			// Step3: Create statement or platform
			statement = connection.createStatement();

			// Step4: Execute SQL statement
			resultSet = statement.executeQuery("select * from Users");

			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Step5: Close Connection
			if (resultSet != null)
				resultSet.close();
			if (statement != null)
				statement.close();
			if (connection != null)
				connection.close();
		}
	}

}
