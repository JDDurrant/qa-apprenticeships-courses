package com.jackdurrant.school_library.controllers;

public class User {

	public static String generateUsername(String name) {

		String[] names = name.toLowerCase().split(" ");
		return String.join("-", names);
	}
}
