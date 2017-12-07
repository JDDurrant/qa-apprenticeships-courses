package com.jackdurrant.school_library.controllers;

import java.sql.SQLException;

import com.jackdurrant.io.PromptGUI;
import com.jackdurrant.school_library.models.StudentModel;
import com.jackdurrant.school_library.models.TeacherModel;
import com.jackdurrant.school_library.views.AdministrationMenu;

public class Administration {

	public static void mainMenu() throws SQLException {

		switch (AdministrationMenu.mainMenu()) {

		case "Add a teacher":
			addTeacher();
			break;
		case "Add a student":
			addStudent();
			break;
		}
	}

	public static boolean addTeacher() throws SQLException {

		String name = PromptGUI.getString("Enter their name");
		String subject = PromptGUI.getString("Enter their subject");

		String username = User.generateUsername(name);
		String password = PromptGUI.getString("Enter their password");

		return TeacherModel.add(name, username, password, subject);
	}

	public static boolean addStudent() throws SQLException {

		String studentName = PromptGUI.getString("Enter their name");
		String teacherName = PromptGUI.getString("Enter the name of their teacher");

		String studentUsername = User.generateUsername(studentName);
		String studentPassword = PromptGUI.getString("Enter their password");

		return StudentModel.add(studentName, studentUsername, studentPassword, teacherName);
	}
}
