package com.jackdurrant.school_library.models;

import com.jackdurrant.io.PromptGUI;
import com.jackdurrant.school_library.views.BookSearchMenu;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookSearch {

    public static void mainMenu() throws SQLException {

        switch (BookSearchMenu.mainMenu()) {
            case "Search by book ID":
                byId();
                break;
            case "Search by title":
                byTitle();
                break;
            case "Search by author":
                byAuthor();
                break;
            case "Back":
                System.exit(0);
                break;
            default:
                System.exit(0);
        }
    }

    public static void byId() throws SQLException {

        int id = PromptGUI.getInteger("Enter the book ID");
        ResultSet query = BookModel.findById(id);

        if (query.next()) {
            String title = query.getString("title");
            String author = query.getString("author");

            PromptGUI.alert(String.format("%s by %s", title, author));
        }
        else {
            PromptGUI.alert("Not found");
        }
    }

    public static void byTitle() throws SQLException {

        String titleInput = PromptGUI.getString("Enter a title to search for");
        StringBuilder books = new StringBuilder("Books:\n");
        ResultSet query = BookModel.findByTitle(titleInput);

        while (query.next()) {
            String title = query.getString("title");
            String author = query.getString("author");

            books.append(String.format("%s by %s\n", title, author));
        }

        PromptGUI.alert(books.toString());
    }

    public static void byAuthor() throws SQLException {

        String author = PromptGUI.getString("Enter the author");
        StringBuilder books = new StringBuilder("Books:\n");
        ResultSet query = BookModel.findByAuthor(author);

        while (query.next()) {
            String title = query.getString("title");
            books.append(String.format("%s\n", title));
        }

        PromptGUI.alert(books.toString());
    }
}
