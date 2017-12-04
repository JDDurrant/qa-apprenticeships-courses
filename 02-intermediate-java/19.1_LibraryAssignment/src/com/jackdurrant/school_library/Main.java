package com.jackdurrant.school_library;

import java.util.ArrayList;

import com.jackdurrant.school_library.user_access.Student;
import com.jackdurrant.school_library.user_access.Teacher;

public class Main {

	private static ArrayList<Teacher> teachers = new ArrayList<>();
	private static ArrayList<Student> students = new ArrayList<>();

	public static void main(String[] args) {

		populateSchool();
		populateLibrary();

		welcome();
	}

	private static void populateSchool() {

		teachers.add(new Teacher("Severus Snape", "h@lf8l00dPr1nc3"));
		teachers.add(new Teacher("Pomona Sprout", "m@ndr@k35"));

		students.add(new Student("George Weasley", "m@r@ud3r5M@p"));
		students.add(new Student("Draco Malfoy", "1mT3ll1nMyF@th3r@b0utTh15"));
		students.add(new Student("Luna Lovegood", "th3yC@llM3L00ny"));
	}

	private static void populateLibrary() {

	}

	private static void welcome() {
		Menu welcome = new Menu("Login as:");
		welcome.add("Student");
		welcome.add("Teacher");
		welcome.add("Quit");

		welcome.display();
	}
}
