package com.jackdurrant.school_library.user_access;

public class Teacher extends User {

	public Teacher(String username, String password) {
		super(username, password, "teacher");
	}
}
