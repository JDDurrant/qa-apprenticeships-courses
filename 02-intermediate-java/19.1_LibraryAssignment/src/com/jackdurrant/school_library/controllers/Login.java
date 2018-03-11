package com.jackdurrant.school_library.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import com.jackdurrant.school_library.models.UserModel;
import com.jackdurrant.school_library.views.LoginMenu;

public class Login {

	private static ResultSet user;

	public static boolean login() throws SQLException {

		String username = LoginMenu.getUsername();
		if (username.equals("")) System.exit(0);

		String password = LoginMenu.getPassword();
		return authenticate(username, password);
	}

	public static boolean authenticate(String username, String password) throws SQLException {

		ResultSet user = UserModel.find(username);

		if (user == null) return false;

		if (user.getString("password").equals(password)) {
			Login.user = user;
			return true;
		}

		return false;
	}

	public static ResultSet getUser() {
		return Login.user;
	}
}
