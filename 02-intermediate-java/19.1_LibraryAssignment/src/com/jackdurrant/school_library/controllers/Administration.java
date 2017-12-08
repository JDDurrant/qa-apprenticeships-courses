package com.jackdurrant.school_library.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jackdurrant.io.PromptGUI;
import com.jackdurrant.school_library.models.StudentModel;
import com.jackdurrant.school_library.models.TeacherModel;
import com.jackdurrant.school_library.views.AdministrationMenu;

public class Administration {

	public static void mainMenu() throws SQLException {

		switch (AdministrationMenu.mainMenu()) {
			case "Add a book":
				break;
			case "Remove a book":
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
			case "Exit":
			default:
				System.exit(0);
		}
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
