package com.jackdurrant.school_library.views;

import java.sql.SQLException;

import com.jackdurrant.school_library.controllers.Administration;
import com.jackdurrant.school_library.controllers.BookSearch;
import com.jackdurrant.school_library.controllers.Borrowing;

public class MainMenu {

	public static void mainMenu() throws SQLException {

		Menu menu = new Menu("Main Menu");
		menu.add("Administration");
		menu.add("Borrow books");
		menu.add("Search books");
		menu.add("Exit");

		switch (menu.getOption()) {
			case "Administration":
				Administration.mainMenu();
				break;
			case "Borrow books":
				Borrowing.mainMenu();
				break;
			case "Search books":
				BookSearch.mainMenu();
			case "Back":
			default:
				break;
		}
	}
}
