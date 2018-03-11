package com.jackdurrant.school_library.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jackdurrant.io.Prompt;
import com.jackdurrant.io.PromptGUI;
import com.jackdurrant.school_library.models.BookModel;
import com.jackdurrant.school_library.models.StudentModel;
import com.jackdurrant.school_library.models.TeacherModel;
import com.jackdurrant.school_library.views.AdministrationMenu;
import com.jackdurrant.school_library.views.MainMenu;

public class Administration {

	public static void mainMenu() throws SQLException {

		switch (AdministrationMenu.mainMenu()) {
			case "List books":
				listBooks();
				break;
			case "Add a book":
				addBook();
				break;
			case "Remove a book":
				removeBook();
				break;
			case "List teachers":
				listTeachers();
				break;
			case "Add a teacher":
				addTeacher();
				break;
			case "Remove a teacher":
				removeTeacher();
				break;
			case "List students":
				listStudents();
				break;
			case "Add a student":
				addStudent();
				break;
			case "Remove a student":
				removeStudent();
				break;
			case "Back":
				MainMenu.mainMenu();
				break;
			default:
				System.exit(0);
		}
	}

	public static void listBooks() throws SQLException {

		StringBuilder books = new StringBuilder("Books:\n");
		ResultSet query = BookModel.list();

		while(query.next()) {
			String title = query.getString("title");
			String author = query.getString("author");

			books.append(String.format("%s by %s\n", title, author));
		}

		PromptGUI.alert(books.toString());
	}

	public static boolean addBook() throws SQLException {

		String title = PromptGUI.getString("Enter the title");
		String author = PromptGUI.getString("Enter the author");
		int quantity = PromptGUI.getInteger("Enter the quantity of copies");

		return BookModel.add(title, author);
	}

	public static boolean removeBook() throws SQLException {

		String title = PromptGUI.getString("Enter the title");

		return BookModel.remove(title);
	}

	public static void listTeachers() throws SQLException {

		StringBuilder teachers = new StringBuilder("Teachers:\n");
		ResultSet query = TeacherModel.list();

		while (query.next()) {
			String name = query.getString("name");
			String subject = query.getString("subject");

			teachers.append(String.format("%s teaches %s\n", name, subject));
		}

		PromptGUI.alert(teachers.toString());
	}

	public static boolean addTeacher() throws SQLException {

		String name = PromptGUI.getString("Enter their name");
		String subject = PromptGUI.getString("Enter their subject");

		String username = User.generateUsername(name);
		String password = PromptGUI.getString("Enter their password");

		return TeacherModel.add(name, username, password, subject);
	}

	public static void removeTeacher() throws SQLException {

		String name = PromptGUI.getString("Enter their name");

		TeacherModel.remove(name);
	}

	public static void listStudents() throws SQLException {

		StringBuilder students = new StringBuilder("Students:\n");
		ResultSet query = StudentModel.list();

		while (query.next()) {
			String name = query.getString("name");

			students.append(String.format("%s\n", name));
		}

		PromptGUI.alert(students.toString());
	}

	public static boolean addStudent() throws SQLException {

		String studentName = PromptGUI.getString("Enter their name");
		String teacherName = PromptGUI.getString("Enter the name of their teacher");

		String studentUsername = User.generateUsername(studentName);
		String studentPassword = PromptGUI.getString("Enter their password");

		return StudentModel.add(studentName, studentUsername, studentPassword, teacherName);
	}

	public static void removeStudent() throws SQLException {

		String name = PromptGUI.getString("Enter their name");

		StudentModel.remove(name);
	}
}
