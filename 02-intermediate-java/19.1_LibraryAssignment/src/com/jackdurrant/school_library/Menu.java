package com.jackdurrant.school_library;

import java.util.ArrayList;

import com.jackdurrant.io.PromptGUI;

public class Menu {

	String title;
	ArrayList<String> items = new ArrayList<>();

	public Menu(String title) {
		this.title = title;
	}

	public Menu(String title, ArrayList<String> items) {
		this(title);
		this.items = items;
	}

	public Menu(String title, String... items) {
		this(title);
		for (String item : this.items) {
			this.add(item);
		}
	}

	public void add(String item) {
		this.items.add(item);
	}

	public int display() {

		StringBuilder message = new StringBuilder(this.title);
		int i = 0;

		for (String item : this.items) {
			String index = String.format("\n%d. ", ++i);

			message.append(index);
			message.append(item);
		}

		return PromptGUI.getInteger(message.toString());
	}
}
