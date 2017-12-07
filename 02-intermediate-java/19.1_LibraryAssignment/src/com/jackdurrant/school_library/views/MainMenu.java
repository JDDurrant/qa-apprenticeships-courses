package com.jackdurrant.school_library.views;

import java.sql.SQLException;

import com.jackdurrant.school_library.controllers.Administration;

public class MainMenu {

	public static void mainMenu() throws SQLException {

		Menu menu = new Menu("Main Menu");
		menu.add("Administration");
		menu.add("Borrow books");
		menu.add("Search books");
		menu.add("Back");

		switch (menu.getOption()) {

		case "Administration":
			Administration.mainMenu();
			break;
		case "Search books":
			BookSearchMenu.mainMenu();
		}
	}
}