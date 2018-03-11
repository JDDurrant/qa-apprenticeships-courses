package com.jackdurrant.school_library.models;

import java.sql.*;

/**
 * SQL query structure:
 * SELECT [fields] FROM [table] WHERE [conditions];
 *
 * Example:
 * SELECT name, email FROM user WHERE id = 001;
 * SELECT * FROM user;
 *
 * @author Administrator
 *
 */

public class Model {

	private static Connection db;

	public static Connection getDB() {
		return db;
	}

	public static void initDB() {

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

			/**
			 * query.next() is similar to ArrayList.pop(), except that it returns a boolean stating whether there are any
			 */

		} catch(Exception e) {
			System.out.println("Database connection failed");
			e.printStackTrace();
		}
	}

	public static ResultSet query(String sql) throws SQLException {

		ResultSet q;

//		Statement stmt = db.createStatement();
//		q = stmt.executeQuery(sql);

		PreparedStatement stmt = db.prepareStatement(sql);
		q = stmt.executeQuery();

//		try {
//			Statement stmt = db.createStatement();
//			q = stmt.executeQuery(sql);
//		}
//		catch(SQLException e) {
//
//			q = null;
//
//			System.out.println("Query failed:");
//			e.printStackTrace();
//		}
//		catch (Exception e) {
//
//			q = null;
//
//
//			System.out.println("Unknown exception:");
//			e.printStackTrace();
//		}

		return q;
	}

	public static PreparedStatement statement(String sql) throws SQLException {

		PreparedStatement stmt;
		try {
			stmt = db.prepareStatement(sql);
			System.out.println("Model.statement(): Assignment successful");
		}
		catch (Exception e) {
			stmt = null;
			System.out.println("Model.statement(): Assignment unsuccessful");
		}

//		try {
//			stmt = db.prepareStatement(sql);
//		}
//		catch (Exception e) {
//
//			stmt = null;
//
//			System.out.println("Unknown exception:");
//			e.printStackTrace();
//		}

		return stmt;
	}
}
