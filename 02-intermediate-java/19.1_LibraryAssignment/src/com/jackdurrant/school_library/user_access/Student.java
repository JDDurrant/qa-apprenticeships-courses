package com.jackdurrant.school_library.user_access;

public class Student extends User {

	public Student(String username, String password) {
		super(username, password, "student");
	}
}
