package starter;

public class DoingMaths {

	public static void main(String[] args) {
		// Carry out the tasks below

		int number = 5;
		System.out.println("Initial Value: " + number);

		// Task 1
		// - double it using the '*' operator
		// - now double it again using the '*=' operator
		number = number * 2;
		number *= 2;

		System.out.println("\n1. After doubling it twice: " + number);

		// Task 2
		// - add 3 to it using the '+' operator
		// - now add 3 to it using the '+=' operator
		number = number + 3;
		number += 3;

		System.out.println("\n2. After adding 3 twice: " + number);

		// Task 3 - subtract 12 from it using an appropriate 'compound' operator
		number -= 12;

		System.out.println("\n3. After subtracting 12: " + number);

		// Task 4 - divide the number (ought to be 14 now) by 3
		// what do you think the answer is
		number /= 3; // 4, remainder: 2 -> remainder or decimal point not represented, as this is an integer

		System.out.println("\n4. After dividing by 3: " + number);

		// Task 5 write 4 different statements that all do the same thing
		// namely 'add 1 to the number'
		number = number + 1;
		number += 1;
		number++;
		++number;

		/*
		 * int i = number++;
		 * int j = ++number;
		 */

		System.out.println("\n5. After adding 1 four times: " + number);

		// Task 6 decrement by 1 the value of number
		number--;

		System.out.println("\n6. After decrementing once: " + number);

		// Task 7 put the remainder when dividing by 3 into 'remainder'
		int remainder = number % 3;

		System.out.println("\n7. Remainder when dividing by 3 is: " + remainder);

		// Task 8 - after uncommenting the System.out.println(..) below
		// decide what it will print
//		int a = 2, b = 3, c = 5;
//		double d1, d2, d3, d4;
//
//		d1 = a + b * c / 2;
//		d2 = (a + b * c) / 2;
//		d3 = (a + b) * c / 2;
//		d4 = (a + b) * (c / 2);
//		System.out.println("\n8. Values: " + d1 + " : " + d2 + " : " + d3 + " : " + d4);

		// Type your answer here--> Values: 9 : 8 : 12 : 10
		// Correction:				Values: 9.0 : 8.0 : 12.0 : 10.0

		// Task 8.1 - Altering code to ensure that floating point arithmetic is performed
		double a = 2, b = 3, c = 5;
		double d1, d2, d3, d4;

		d1 = a + b * c / 2;
		d2 = (a + b * c) / 2;
		d3 = (a + b) * c / 2;
		d4 = (a + b) * (c / 2);
		System.out.println("\n8. Values: " + d1 + " : " + d2 + " : " + d3 + " : " + d4);

		// Task 9
		int p, q;
		p = 10;
		q = 10;
		p += q++;
		// Decide what the next line will print
		System.out.println("\n9. Result is: " + (p + q)); // 9. Result is: 31
		// My initial guess: 32

		// Task 10
		// Make the following statement compile
		double d7 = 4.3, d8 = 34.7;
		int truncatedSum = (int)(d7 + d8);
		// Above: Store what can be stored of a complex data type as a simpler data type
		System.out.println("\n10. Sum is " + truncatedSum);

		// Task 11
		System.out.println("\n11.");
		// Decide what the following 4 lines will print
		// The 4th one might surprise you
		System.out.println("fred" + 3 + 4); // Answer--> fred34
		System.out.println(3 + 4 + "fred"); // Answer--> 7fred
		System.out.println("" + 3 + 4); // Answer--> 34
		System.out.println(3 + ' ' + 4); // Answer--> 39
		// The single quotes above store a character, not a string. The binary value of
		// ' ' is probably 5.

		/*
		 * The single quotes above are enclosing a character, not a string. This
		 * character is included in a numerical operation and is therefore interpreted as
		 * a number. The numerical value of ' ' is 32. 3 + 32 + 4 = 39.
		 */

		/*
		 * My initial guesses:
		 * fred7
		 * 7fred
		 * 7
		 * 3 4
		 */

		// When you have time ...
		// Change the code of 'Task 8' to ensure floating point
		// arithmetic is performed

	}

}
