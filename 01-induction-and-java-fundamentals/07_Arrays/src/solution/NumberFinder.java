package solution;

import java.util.Scanner;

public class NumberFinder {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Create and initialise an array of any 8 ints call it 'myNumbers'
		int[] myNumbers = new int[] { 1, 3, 5, 2, 4, 6, 8, 7 };

        // Invoke the PrintNumbers method (after writing it!)
        PrintNumbers(myNumbers);     

        // Ask the user to enter a number
        System.out.println("Enter the number you'd like to search for: ");
        String input = scanner.next();
        
        int numberToFind;
        if (tryParse(input)){
        	numberToFind = Integer.parseInt(input);
        }
        else{
            System.out.println("Must enter a numeric value");
            return;
        }
        
        // Invoke your NumberSearch method and check 
        // the return value from it to see if the number was found 
        // printing out an appropriate message in either situation

        int pos = NumberSearch(myNumbers, numberToFind);
        if (pos != -1)
        {
            System.out.printf("Number %d found at position %d", numberToFind, pos + 1);
        }
        else
        {
        	System.out.printf("Number %d not found in list", numberToFind);
        }        
       
    } // End of Main()
	
    // search for an int in an int[] returning its position in the array if it is there, else -1 if it is not 
    public static int NumberSearch(int[] numbers, int numToFind)
    {
        for (int i = 0; i < numbers.length; i++)
        {
            if (numbers[i] == numToFind)
            {
                return i;
            }
        }
        return -1;
    } 

    // print all the numbers in the array
    public static void PrintNumbers(int[] numbers)
    {
    	for (int num : numbers) {
    		System.out.println(num);			
		}
    	System.out.println();
    }
	
	private static Boolean tryParse(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
} // End of class
