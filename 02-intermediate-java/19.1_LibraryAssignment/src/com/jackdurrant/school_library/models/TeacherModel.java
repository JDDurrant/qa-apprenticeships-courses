package com.jackdurrant.school_library.models;

import java.sql.*;

public class TeacherModel {

	public static void main(String[] args) throws SQLException {

		Model.initDB();

		ResultSet teacher = find("Severus Snape");

		System.out.println(teacher.getInt("_id"));
		System.out.println(teacher.getInt("user_id"));
		System.out.println(teacher.getString("name"));
		System.out.println(teacher.getString("subject"));
	}

	public static ResultSet list() throws SQLException {

		PreparedStatement stmt = Model.statement("SELECT `name`, `subject` FROM `teacher`;");
		return stmt.executeQuery();
	}

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

		UserModel.add(username, password, "teacher");

		// I initially included the statement below, assuming it would only return false if a user wasn't added successfully.
		// However, it seems to return false when the addition is successful. I'd like to find another way of determining the
		// success/failure of adding a record.
//		if(!addUser) return false;

		ResultSet user = UserModel.find(username);

		PreparedStatement stmt = Model.getDB().prepareStatement(
				"INSERT INTO `teacher` (user_id, name, subject) VALUES (?, ?, ?);");

		stmt.setInt(1, user.getInt("_id"));
		stmt.setString(2, name);
		stmt.setString(3, subject);

		return stmt.execute();
	}

	public static void remove(String name) throws SQLException {

		PreparedStatement findTeacher = Model.statement("SELECT `_id`, `user_id` FROM `teacher` WHERE `name` = ?");
		findTeacher.setString(1, name);

		ResultSet teacher = findTeacher.executeQuery();
		teacher.next();

		int teacherID = teacher.getInt("_id");
		int userID = teacher.getInt("user_id");

		PreparedStatement deleteTeacher = Model.statement("DELETE FROM `teacher` WHERE `_id` = ?");
		deleteTeacher.setInt(1, teacherID);
		deleteTeacher.execute();

		PreparedStatement deleteUser = Model.statement("DELETE FROM `user` WHERE `_id` = ?");
		deleteUser.setInt(1, userID);
		deleteUser.execute();
	}
}
