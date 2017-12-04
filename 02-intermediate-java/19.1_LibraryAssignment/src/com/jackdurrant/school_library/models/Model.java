package com.jackdurrant.school_library.models;

import java.sql.*;

/**
 * SQL query structure:
 * SELECT [fields] FROM [table] WHERE [conditions];
 *
 * Example:
 * SELECT name, email FROM user WHERE id = 001;
 *
 * @author Administrator
 *
 */

public class Model {

	private static Connection db;

	public static Connection getDB() {

		try {
			// Connect to database
			db = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_library", "root", "Pa$$w0rd");

			// Create a statement
			// Statement stmt = db.createStatement();

			// Execute query
			// ResultSet query = stmt.executeQuery("select * from teacher");

			// Process results
			// while (query.next()) {
			// 	System.out.println(query.getString("name"));
			// }

		} catch(Exception e) {
			System.out.println("Database connection failed");
			e.printStackTrace();
		}

		return db;
	}
}
