package starter;

import java.util.Scanner;

public class LuhnAlgorithm {

	public static void main(String[] args) {
        // CreditCard No 1234567890123452 is a valid one, change final digit and it isn't
		Scanner scanner = new Scanner(System.in);
        System.out.printf("Please enter a valid 16 digit credit card number");
        String strCCNo = scanner.next();
        long ccNo;
        
        // if it is not a valid 'long' OR length is not 16 OR number is negative
//        if(??????){
//        
//            System.out.printf("Must be a 16 digit numeric with no spaces");
//            return;
//        }
        // Need to display either "Valid" or "Invalid", based on what comes back 
        // from call to validateCCNo(long ccNo)
        System.out.printf("The Credit Card number is %s");

	}
	// This is where the Card number is validated
    static Boolean validateCCNo(long ccNo)
    {
        // We got here so it is a 16 digit numeric
        // Convert it to a string and then into a 16 char array (ToCharArray())

        // Initialise running 'check digit' total
        // Loop thru array 16 times, need to know which element you are on

        // In loop...
        // Calculate an int version of this digit as chars will convert to int
        // If 1st or 3rd or 5th digit of number then double it
        // If now greater than 9 subtract 9
        // and add to runningTotal

        // if it was 2nd / 4th / 6th number etc then add unaltered value to runningTotal

        // Hint: Think about the value of i when it is the 1st/3rd/5th element



        // after loop return true only if it is divisible by 10
        return false; // to make it compile
    }
	private static Boolean tryParse(String value) {
		try {
			Double.parseDouble(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	}
