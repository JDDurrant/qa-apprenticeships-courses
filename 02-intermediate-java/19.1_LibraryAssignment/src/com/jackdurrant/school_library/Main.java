package com.jackdurrant.school_library;

import java.sql.SQLException;
//import java.util.ArrayList;

import com.jackdurrant.io.PromptGUI;
import com.jackdurrant.school_library.controllers.Login;
import com.jackdurrant.school_library.models.Model;
//import com.jackdurrant.school_library.user_access.Student;
//import com.jackdurrant.school_library.user_access.Teacher;
import com.jackdurrant.school_library.views.BookSearchMenu;

public class Main {

//	private static ArrayList<Teacher> teachers = new ArrayList<>();
//	private static ArrayList<Student> students = new ArrayList<>();

	public static void main(String[] args) throws SQLException {

		Model.initDB();

//		populateSchool();
//		populateLibrary();

//		welcome();

		boolean login = Login.login();

		if (login) {
			PromptGUI.alert("Successfully logged in");

			switch (Login.getUser().getString("role")) {

			case "administrator":
			case "librarian":
			case "teacher":
				// Teacher actions
				break;
			case "student":
				BookSearchMenu.mainMenu();
				break;
			}
		}
		else PromptGUI.alert("Incorrect username or password");
	}

//	private static void populateSchool() {
//
////		teachers.add(new Teacher("Severus Snape", "h@lf8l00dPr1nc3"));
////		teachers.add(new Teacher("Pomona Sprout", "m@ndr@k35"));
////
////		students.add(new Student("George Weasley", "m@r@ud3r5M@p"));
////		students.add(new Student("Draco Malfoy", "1mT3ll1nMyF@th3r@b0utTh15"));
////		students.add(new Student("Luna Lovegood", "th3yC@llM3L00ny"));
//	}
//
//	private static void populateLibrary() {
//
//	}

//	private static void welcome() {
//		Menu welcome = new Menu("Login as:");
//		welcome.add("Student");
//		welcome.add("Teacher");
//		welcome.add("Quit");
//
//		welcome.display();
//	}
}
