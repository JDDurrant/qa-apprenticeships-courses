package starter;

import java.io.IOException;
import java.util.Scanner;

public class Prompt {

	private static Scanner scan = new Scanner(System.in);

	public static String getString(String message) {

		fullPrompt(message);
		return scan.nextLine();
	}

	public static int getInteger(String message) {

		fullPrompt(message);
		return scan.nextInt();
	}

	public static int fieldInteger(String message) {

		slimPrompt(message);
		return scan.nextInt();
	}

	public static double getDouble(String message) {

		fullPrompt(message);
		return scan.nextDouble();
	}

	public static boolean getBoolean(String message) {

		fullPrompt(message);
		return scan.nextBoolean();
	}

	private static void fullPrompt(String message) {

		System.out.printf("%s\n> ", message);
	}

	private static void slimPrompt(String message) {

		System.out.printf("%s: ", message);
	}

	public static void pause(String message) {

		System.out.println(message);
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
