package com.jackdurrant.school_library.models;

import java.sql.*;

public class StudentModel {

	public static boolean addStudent(String name, String username, String password, String teacherName) throws SQLException {

		boolean addUser = UserModel.add(username, password, "student");
		if(!addUser) return false;

		ResultSet teacherRecord = TeacherModel.find(name);

		PreparedStatement stmt = Model.getDB().prepareStatement(
				"INSERT INTO `student` (user_id, teacher_id, name) VALUES (?, ?, ?);");

		stmt.setInt(1, teacherRecord.getInt("_id"));
		stmt.setString(2, username);
		stmt.setString(3, password);

		return stmt.execute();
	}
}
