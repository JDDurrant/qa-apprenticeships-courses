package com.jackdurrant.school_library.models;

import java.sql.*;
import java.util.ArrayList;

public class BookCopyModel {
	// Object-oriented aspect is a work in progress
	private int _id;
	private int book_id;
	private int user_id;
	private Date borrow_date;
	private Date return_date;
	private char condition;

	public BookCopyModel(int book_id, int user_id) {

		this.book_id = book_id;
		this.user_id = user_id;
		this.condition = 'A';
	}

	public static void main(String[] args) throws SQLException {

		Model.initDB(); // Always remember this line! I forgot it earlier today and was stumped for hours.
//		add("Book of Potions", "Zygmunt Budge");
		ArrayList<BookModel> books = listAvailable();

		System.out.println("Available to rent:");
		for (BookModel book : books) {
			System.out.printf("%s by %s\n", book.getTitle(), book.getAuthor());
		}
	}

	public static boolean add(String title, String author) throws SQLException {

//		ResultSet librarian = UserModel.findLibrarian();
		ResultSet book = BookModel.find(title, author);

		if (!book.next()) {
			BookModel.add(title, author);
			book = BookModel.find(title, author);
			book.next();
		}

		PreparedStatement stmt = Model.getDB().prepareStatement(
				"INSERT INTO `library_book` (`book_id`, `user_id`, `condition`) VALUES (?, ?, 'A');");

		stmt.setInt(1, book.getInt("_id"));
//		stmt.setInt(2, librarian.getInt("_id"));
		stmt.setInt(2, 1);

		return stmt.execute();
	}

	public static ArrayList<BookModel> listAvailable() throws SQLException {

		ResultSet librarian = UserModel.findLibrarian();

		PreparedStatement findCopies = Model.getDB().prepareStatement(
				"SELECT * FROM `library_book` WHERE `user_id` = ?");

		findCopies.setInt(1, librarian.getInt("_id"));

		ResultSet copies = findCopies.executeQuery();

		ArrayList<Integer> ids = new ArrayList<>();

		while (copies.next()) {
			int id = copies.getInt("book_id");

			if (!ids.contains(id)) {
				ids.add(id);
			}
		}

		PreparedStatement findBooks = Model.getDB().prepareStatement(
				"SELECT * FROM `book` WHERE `_id` = ?");

		ArrayList<BookModel> books = new ArrayList<>();

		for (int id : ids) {
			findBooks.setInt(1, id);

			ResultSet query = findBooks.executeQuery();
			query.next();

			BookModel book = new BookModel(query.getString("title"), query.getString("Author"));

			books.add(book);
		}

		return books;
	}
}
