package starter;

import java.util.Scanner;

public class NumberFinder {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Create and initialise an array of any 8 ints call it 'myNumbers'
        

        // Invoke the PrintNumbers method (after writing it!)
       

        // Ask the user to enter a number
        System.out.println("Enter the number you'd like to search for: ");
        String input = scanner.next();
        
        // Display an error message and exit if it is not numeric
        int numberToFind;      
        
        
    
        // Invoke your NumberSearch method and check 
        // the return value from it to see if the number was found 
        // printing out an appropriate message in either situation

        
        
        // Use one of these displays if found, the other one if not           
        //System.out.println("Number %d found at position {1}");
        //System.out.println("Number %d not found in list");
       
    } // End of Main()
	
	// Method Printnumbers should receive an int[] and print its contents, one per line


    // Method NumberSearch should receive an int[] and an int (the number to find in the int[]) 
    // Returns its position in the array if it is there, else -1 if it is not 
	
	
	
	private static Boolean tryParse(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}	
} // End of class
