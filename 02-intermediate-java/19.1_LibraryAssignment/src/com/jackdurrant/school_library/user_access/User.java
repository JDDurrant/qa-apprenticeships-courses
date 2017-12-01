package com.jackdurrant.school_library.user_access;

public class User {

	private String username;
	private String password;
	private String type;

	public User(String username, String password, String type) {
		this.username = username;
		this.password = password;
		this.type = type;
	}

	public boolean authenticate(String password) {
		if (password.equals(this.password))
			return true;
		else
			return false;
	}
}
