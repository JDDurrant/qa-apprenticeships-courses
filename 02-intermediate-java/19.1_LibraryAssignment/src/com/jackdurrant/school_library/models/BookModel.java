package com.jackdurrant.school_library.models;

import java.sql.*;

public class BookModel {

	public static ResultSet find(String title, String author) throws SQLException {

		PreparedStatement stmt = Model.statement("SELECT * FROM `book` WHERE `title` = ? AND `author` = ?;");
		stmt.setString(1, title);
		stmt.setString(2, author);

		ResultSet query = stmt.executeQuery();

		return query;
	}

	public static boolean add(String title, String author) throws SQLException {

		PreparedStatement stmt = Model.statement("INSERT INTO `book` (`title`, `author`) VALUES (?, ?);");

		stmt.setString(1, title);
		stmt.setString(2, author);

		return stmt.execute();
	}
}
