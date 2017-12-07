package com.jackdurrant.school_library.models;

import java.sql.*;

public class BookModel {

	private int _id;
	private String title;

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	private String author;

	public BookModel(String title, String author) {

		this.title = title;
		this.author = author;
	}

	public static ResultSet find(String title, String author) throws SQLException {

		ResultSet query;

		try {
			PreparedStatement stmt = Model.statement("SELECT * FROM `book` WHERE `title` = ? AND `author` = ?;");
			stmt.setString(1, title);
			stmt.setString(2, author);

			query = stmt.executeQuery();
		}
		catch (Exception e)
		{
			query = null;
			System.out.println("BookModel.find(): Query unsuccessful");
		}

		return query;
	}

	public static boolean add(String title, String author) throws SQLException {

		PreparedStatement stmt = Model.statement("INSERT INTO `book` (`title`, `author`) VALUES (?, ?);");

		stmt.setString(1, title);
		stmt.setString(2, author);

		return stmt.execute();
	}
}
