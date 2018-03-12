package com.jackdurrant.school_library.controllers;

import com.jackdurrant.io.PromptGUI;
import com.jackdurrant.school_library.models.BookModel;
import com.jackdurrant.school_library.models.UserModel;
import com.jackdurrant.school_library.views.BorrowingMenu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Borrowing {

    public static void mainMenu() throws SQLException {

        switch (BorrowingMenu.mainMenu()) {
            case "Add book to borrower's list":
            case "Remove book from borrower's list":
            case "List a borrower's books":
            case "Search book menu":
            case "Back":
            default:
                System.exit(0);
        }
    }

    public static void borrowBook() throws SQLException {

        String username = PromptGUI.getString("Enter the borrower's username");
        String bookTitle = PromptGUI.getString("Enter the book they want to borrow");

        ResultSet user = UserModel.find(username);
        ResultSet book = BookModel.findByTitle(bookTitle);


    }
}
