package starter;

import java.util.InputMismatchException;

public class Numbers {

	public static void main(String[] args) throws InputMismatchException {
		// Create and initialise an array of 8 ints
		int[] myNumbers = {1, 3, 5, 7, 2, 4, 6, 8};
//		printNumbers(myNumbers);

		// Ask the user to enter a number (and ensure that it is numeric)
		int number;

		try {
			number = Prompt.getInteger("Enter a number to find");
		} catch (Exception e) {
			System.out.println("Please enter a number to continue.");
			return;
		}

		// Invoke your numberFinder method and check
		// the return value from it to see if the number was found
		// printing out an appropriate message
		int index = numberFinder(myNumbers, number);

		if(index < myNumbers.length)
			System.out.printf("Number %d found at index %d.\n\n", number, index);
		else
			System.out.printf("Number %d not found.\n\n", number);

		main(args);
	} // end of main method

	// Write the printNumbers method
	public static void printNumbers(int[] numbers) {

		for (int number : numbers) {
			System.out.println(number);
		}
	}

	public static int numberFinder(int[] numbers, int numToFind) {

		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] == numToFind) return i;
		}

		return numbers.length;
	}
}
