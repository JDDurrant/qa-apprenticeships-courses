package com.jackdurrant.school_library.models;

import java.sql.*;

public class UserModel {

	public static void main(String[] args) throws SQLException {
		// Test method
		Model.initDB();

//		addUser("snape", "1h@t3h@rry", "teacher");
//		remove("snape");

		System.out.println(list());
	}

	public static String list() throws SQLException {
		// Essentially a demo method for void main. If I'm going to keep it, I should move it to the controllers.
		StringBuilder users = new StringBuilder();

		ResultSet query = Model.query("SELECT * FROM `user` WHERE `role` = 'librarian';");

		while (query.next()) {
			int id = query.getInt("_id");
			String username = query.getString("username");
			String password = query.getString("password");

			users.append(String.format("%04d %12s %12s\n", id, username, password));
		}

		return users.toString();
	}

	public static ResultSet find(int id) throws SQLException {

		PreparedStatement stmt = Model.statement("SELECT * FROM `user` WHERE `_id` = ?;");
		stmt.setInt(1, id);

		ResultSet query = stmt.executeQuery();

		while (query.next()) {
			return query;
		}

		return null;
	}

	public static ResultSet findLibrarian() throws SQLException {

//		ResultSet query = Model.query("SELECT * FROM `user` WHERE `role` = 'librarian';");
		ResultSet query;

		try {
			query = Model.query("SELECT * FROM `user` WHERE `role` = 'librarian';");
			System.out.println("Query successful");
		}
		catch (Exception e) {
			query = null;
			System.out.println("findLibrarian(): Query unsuccessful");
		}

		query.next();
		return query;

//		while (query.next()) {
//			return query;
//		}
//
//		return null;
	}

	public static ResultSet find(String username) throws SQLException {
		// TODO Do something about the code repitition
		PreparedStatement stmt = Model.statement("SELECT * FROM `user` WHERE `username` = ?;");
		stmt.setString(1, username);

		ResultSet query = stmt.executeQuery();

		while (query.next()) {
			return query;
		}

		return null;
	}

	public static boolean add(String username, String password, String role) throws SQLException {

		PreparedStatement stmt = Model.statement("INSERT INTO `user` (`username`, `password`, `role`) VALUES (?, ?, ?);");

		stmt.setString(1, username);
		stmt.setString(2, password);
		stmt.setString(3, role);

		return stmt.execute();
	}

	public static boolean addLibrarian(String username, String password) throws SQLException {
		return add(username, password, "librarian");
	}

	public static boolean addAdministrator(String username, String password) throws SQLException {
		return add(username, password, "administrator");
	}

	public static boolean remove(int id) throws SQLException {

		PreparedStatement stmt = Model.statement("DELETE FROM `user` WHERE `_id` = ?;");
		stmt.setInt(1, id);

		return stmt.execute();
	}

	public static boolean remove(String username) throws SQLException {

		PreparedStatement stmt = Model.statement("DELETE FROM `user` WHERE `username` = ?;");
		stmt.setString(1, username);

		return stmt.execute();
	}

	public static boolean updatePassword(int id, String password) throws SQLException {

		PreparedStatement stmt = Model.statement("UPDATE `user` SET `password` = ? WHERE `_id` = ?;");
		stmt.setString(1, password);
		stmt.setInt(2, id);

		return stmt.execute();
	}

	public static boolean updatePassword(String username, String password) throws SQLException {

		PreparedStatement stmt = Model.statement("UPDATE `user` SET `password` = ? WHERE `username` = ?;");
		stmt.setString(1, password);
		stmt.setString(2, username);

		return stmt.execute();
	}
}
