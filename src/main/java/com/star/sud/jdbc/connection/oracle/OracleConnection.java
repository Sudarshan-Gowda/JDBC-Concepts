package com.star.sud.jdbc.connection.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleConnection {

	private static String DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
	private static String URL = "jdbc:oracle:thin:@localhost:1521:orcl";

	public static void main(String[] args) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {

			// Step1: Load and Register the driver
			Class.forName(DRIVER_CLASS);

			// Step2: Establish connection
			connection = DriverManager.getConnection(URL, "testdb", "root");

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
