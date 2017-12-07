package com.jackdurrant.school_library.views;

public class AdministrationMenu {

	public static String mainMenu() {

		Menu menu = new Menu("Administration");

		menu.add("Add a book");
		menu.add("Remove a book");

		menu.add("List teachers");
		menu.add("Add a teacher");
		menu.add("Remove a teacher");

		menu.add("List students");
		menu.add("Add a student");
		menu.add("Remove a student");

		menu.add("Back");

		return menu.getOption();
	}
}
