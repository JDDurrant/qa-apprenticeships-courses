package com.jackdurrant.school_library.views;

public class BorrowingMenu {

    public static String mainMenu() {

        Menu menu = new Menu("Borrowing");

        menu.add("Add book to borrower's list");
        menu.add("Remove book from borrower's list");
        menu.add("List a borrower's books");
        menu.add("Search book menu");
        menu.add("Back");

        return menu.getOption();
    }
}
