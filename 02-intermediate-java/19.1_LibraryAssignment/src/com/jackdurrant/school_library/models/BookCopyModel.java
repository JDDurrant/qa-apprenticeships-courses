package com.jackdurrant.school_library.models;

import java.sql.*;

public class BookCopyModel {

	public static void main(String[] args) throws SQLException {

		add("Fantastic Beasts and Where to Find Them", "Newt Scamander");
	}

	public static boolean add(String title, String author) throws SQLException {

//		ResultSet librarian = UserModel.findLibrarian();
		ResultSet book = BookModel.find(title, author);

		if(!book.next()) {
			BookModel.add(title, author);
			book = BookModel.find(title, author);
			book.next();
		}

		PreparedStatement stmt = Model.getDB().prepareStatement(
				"INSERT INTO `library_book` (`book_id`, `user_id`, `condition`) VALUES (?, ?, 'A');");

		stmt.setInt(1, book.getInt("_id"));
//		stmt.setInt(2, librarian.getInt("_id"));
		stmt.setInt(2,  1);

		return stmt.execute();
	}
}
