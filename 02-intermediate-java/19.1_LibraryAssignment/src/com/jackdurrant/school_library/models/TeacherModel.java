package com.jackdurrant.school_library.models;

import java.sql.*;

public class TeacherModel {

	public static ResultSet find(String name) throws SQLException {

		PreparedStatement stmt = Model.statement("SELECT * FROM `teacher` WHERE `name` = ?;");
		stmt.setString(1, name);

		ResultSet query = stmt.executeQuery();

		while (query.next()) {
			return query;
		}

		return null;
	}

	public static boolean add(String name, String username, String password, String subject) throws SQLException {

		boolean addUser = UserModel.add(username, password, "teacher");

		if(!addUser) return false;

		ResultSet user = UserModel.find(username);

		PreparedStatement stmt = Model.getDB().prepareStatement(
				"INSERT INTO `teacher` (user_id, name, subject) VALUES (?, ?, ?);");

		stmt.setInt(1, user.getInt("_id"));
		stmt.setString(2, username);
		stmt.setString(3, password);

		return stmt.execute();
	}
}
