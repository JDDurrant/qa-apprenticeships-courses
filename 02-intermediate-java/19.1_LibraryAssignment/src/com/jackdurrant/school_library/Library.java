package com.jackdurrant.school_library;

import java.util.ArrayList;

import com.jackdurrant.school_library.views.Menu;

public class Library {

	private static ArrayList<Book> books = new ArrayList<>();

	public static void add(Book book) {
		books.add(book);
	}

	public static Menu borrow() {
		Menu selection = new Menu("Choose a book to borrow:");
		for(Book book : books) {
			String item = String.format("%s by %s", book.getTitle(), book.getAuthor());
			selection.add(item);
		}
		return selection;
	}
}
