package com.jackdurrant.school_library.views;

import com.jackdurrant.io.PromptGUI;

public class LoginMenu {

	public static String getUsername() {
		return PromptGUI.getString("Please enter your username. Leave blank to exit the program.");
	}

	public static String getPassword() {
		return PromptGUI.getString("Please enter your password.");
	}
}
