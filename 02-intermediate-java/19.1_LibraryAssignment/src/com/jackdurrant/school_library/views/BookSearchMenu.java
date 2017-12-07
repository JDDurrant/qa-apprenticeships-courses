package com.jackdurrant.school_library.views;

public class BookSearchMenu {

	public static void mainMenu() {

		Menu bookSearch = new Menu("Book Search");

		bookSearch.add("Search by book ID");
		bookSearch.add("Search by title");
		bookSearch.add("Search by author");
		bookSearch.add("Back");
	}
}
