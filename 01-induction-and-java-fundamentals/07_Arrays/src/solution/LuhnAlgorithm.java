package solution;

import java.util.Scanner;

public class LuhnAlgorithm {

	public static void main(String[] args) {
        // CreditCard No 1234567890123452 is a valid one, change final digit and it isn't
		Scanner scanner = new Scanner(System.in);
        System.out.printf("Please enter a valid 16 digit credit card number");
        String strCCNo = scanner.next();
        long ccNo;
        
        // if it is not a valid 'long' OR length is not 16 OR number is negative
        if(!tryParse(strCCNo)){
            System.out.println("Must be a 16 digit numeric with no spaces");
            return;
        }
        else{
        	ccNo = Long.parseLong(strCCNo);
        	if(strCCNo.length() != 16 || ccNo < 0){
        		System.out.println("Must be a 16 digit numeric");
                return;
        	}
        	
        }
        // Need to display either "Valid" or "Invalid", based on what comes back 
        // from call to ValidateCCNo(long ccNo)
        System.out.printf("The Credit Card number is %s",validateCCNo(ccNo) ? "Valid":"Invalid");

	}

	// This is where the Card number is validated
	static Boolean validateCCNo(long ccNo) {
		// We got here so it is a 16 digit numeric
		// Convert it to a string and then into a 16 char array (ToCharArray())
		char[] chars =  Long.toString(ccNo).toCharArray();
		
        // Initialise running check digit total
        int sum = 0;
        // Loop through array 16 times
        for (int i = 0; i < chars.length; i++)
        {
            // calculate an int version of this digit as chars
            // will convert to int
            int digit = chars[i] - '0';

            // if 1st or 3rd or 5th digit of number 
            // (i being even 0/2/4 etc)
            if (i % 2 == 0)
            {
                // double it
                digit *= 2;
                // if greater than 9 subtract 9
                if (digit > 9) digit -= 9;
            }
            // always add to runningTotal
            // if it was 2nd / 4th / 6th number etc then added unaltered
            sum += digit;
        }
        // return true if it is divisible by 10
        return (sum % 10 == 0);
	}

	private static Boolean tryParse(String value) {
		try {
			Long.parseLong(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
