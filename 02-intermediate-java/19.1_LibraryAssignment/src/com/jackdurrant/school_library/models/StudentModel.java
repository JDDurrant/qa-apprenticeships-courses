package com.jackdurrant.school_library.models;

import java.sql.*;

public class StudentModel {

	public static void main(String[] args) throws SQLException {

		Model.initDB();

		add("Draco Malfoy", "draco", "password", "Severus Snape");
	}

	public static boolean add(String name, String username, String password, String teacherName) throws SQLException {

		UserModel.add(username, password, "student");
//		if(!addUser) return false;

		ResultSet user = UserModel.find(username);

		ResultSet teacher = TeacherModel.find(teacherName);

		PreparedStatement stmt = Model.getDB().prepareStatement(
				"INSERT INTO `student` (user_id, teacher_id, name) VALUES (?, ?, ?);");

		stmt.setInt(1, user.getInt("_id"));
		stmt.setInt(2, teacher.getInt("_id"));
		stmt.setString(3, name);

		return stmt.execute();
	}
}
