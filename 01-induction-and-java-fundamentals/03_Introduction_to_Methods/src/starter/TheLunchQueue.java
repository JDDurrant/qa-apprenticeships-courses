package starter;

import java.util.Scanner;

public class TheLunchQueue {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

//		Scanner scan = new Scanner(System.in);

		String mainCourse = getString("What main dish would you like?");

		//System.out.println("How many roast potatoes?");
		int roastCount = getInteger("How many roast potatoes would you like?");

		//System.out.println("How many brussel sprouts?");
		int sproutCount = getInteger("How many brussel sprouts would you like?");

	    // Put any display of final output (printf) under here!

		System.out.printf(
				"Your lunch today is %s with %d roast potatoes and %d brussel sprouts.",
				mainCourse, roastCount, sproutCount
				);
	}

	public static String getString(String question) {

		prompt(question);
		return scan.nextLine();
	}

	public static int getInteger(String question) {

		prompt(question);
		return scan.nextInt();
	}

	public static void prompt(String question) {

		System.out.println(question);
		System.out.print("> ");
	}
}
