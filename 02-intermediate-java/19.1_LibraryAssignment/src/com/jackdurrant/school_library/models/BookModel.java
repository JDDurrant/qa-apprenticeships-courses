package com.jackdurrant.school_library.models;

import java.sql.*;

public class BookModel {

	private int _id;
	private String title;
	private String author;

	public BookModel(String title, String author) {

		this.title = title;
		this.author = author;
	}

	public static ResultSet list() throws SQLException {

		PreparedStatement stmt = Model.statement("SELECT `title`, `author` FROM `book`;");
		return stmt.executeQuery();
	}

	public static ResultSet find(String title, String author) throws SQLException {

		ResultSet query;

		try {
			PreparedStatement stmt = Model.statement("SELECT * FROM `book` WHERE `title` = ? AND `author` = ?;");
			stmt.setString(1, title);
			stmt.setString(2, author);

			query = stmt.executeQuery();
		}
		catch (Exception e) {
			query = null;
			System.out.println("BookModel.find(): Query unsuccessful");
		}

		return query;
	}

	public static ResultSet findById(int id) throws SQLException {

		ResultSet query;

		try {
			PreparedStatement stmt = Model.statement("SELECT * FROM `book` WHERE `_id` = ?;");
			stmt.setInt(1, id);

			query = stmt.executeQuery();
		}
		catch (Exception e) {
			query = null;
			System.out.println("BookModel.findById(): Query unsuccessful");
		}

		return query;
	}

	public static ResultSet findByTitle(String title) throws SQLException {

		ResultSet query;

		try {
			PreparedStatement stmt = Model.statement("SELECT * FROM `book` WHERE `title` LIKE ?;");
			stmt.setString(1, title);

			query = stmt.executeQuery();
		}
		catch (Exception e) {
			query = null;
			System.out.println("BookModel.findByTitle(): Query unsuccessful");
		}

		return query;
	}

	public static ResultSet findByAuthor(String author) throws SQLException {

		ResultSet query;

		try {
			PreparedStatement stmt = Model.statement("SELECT * FROM `book` WHERE `author` = ?;");
			stmt.setString(1, author);

			query = stmt.executeQuery();
		}
		catch (Exception e) {
			query = null;
			System.out.println("BookModel.findByAuthor(): Query unsuccessful");
		}

		return query;
	}

	public static boolean add(String title, String author) throws SQLException {

		PreparedStatement stmt = Model.statement("INSERT INTO `book` (`title`, `author`) VALUES (?, ?);");

		stmt.setString(1, title);
		stmt.setString(2, author);

		return stmt.execute();
	}

	public static boolean remove(String title) throws SQLException {

		PreparedStatement stmt = Model.statement("DELETE FROM `book` WHERE `title` = ?;");

		stmt.setString(1, title);

		return stmt.execute();
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}
}
