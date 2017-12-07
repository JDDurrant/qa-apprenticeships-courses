package com.jackdurrant.school_library.views;

public class BookSearchMenu {

	public static String mainMenu() {

		Menu menu = new Menu("Book Search");

		menu.add("Search by book ID");
		menu.add("Search by title");
		menu.add("Search by author");
		menu.add("Back");

		return menu.getOption();
	}
}
