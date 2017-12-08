package com.jackdurrant.school_library.models;

import java.sql.*;

public class StudentModel {

	public static void main(String[] args) throws SQLException {

		Model.initDB();

		add("Draco Malfoy", "draco", "password", "Severus Snape");
	}

	public static ResultSet list() throws SQLException {

		PreparedStatement stmt = Model.statement("SELECT `name` FROM `student`;");
		return stmt.executeQuery();
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

	public static void remove(String name) throws SQLException {

		PreparedStatement findStudent = Model.statement("SELECT `_id`, `user_id` FROM `student` WHERE `name` = ?");
		findStudent.setString(1, name);

		ResultSet student = findStudent.executeQuery();
		student.next();

		int studentID = student.getInt("_id");
		int userID = student.getInt("user_id");

		PreparedStatement deleteStudent = Model.statement("DELETE FROM `student` WHERE `_id` = ?");
		deleteStudent.setInt(1, studentID);
		deleteStudent.execute();

		PreparedStatement deleteUser = Model.statement("DELETE FROM `user` WHERE `_id` = ?");
		deleteUser.setInt(1, userID);
		deleteUser.execute();
	}
}
