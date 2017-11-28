package com.jackdurrant.io;

import javax.swing.JOptionPane;

public class PromptGUI {

	public static void alert(String message) {

		JOptionPane.showMessageDialog(null, message);
	}

	public static String getString(String message) {

		return JOptionPane.showInputDialog(message);
	}

	public static int getInteger(String message) {

		String number = JOptionPane.showInputDialog(message);
		return Integer.parseInt(number);
	}

	public static double getDouble(String message) {

		String number = JOptionPane.showInputDialog(message);
		return Double.parseDouble(number);
	}
}
