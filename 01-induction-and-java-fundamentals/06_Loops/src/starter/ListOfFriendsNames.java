package starter;

import java.util.Scanner;

public class ListOfFriendsNames {

	public static void main(String[] args) {
		String name = getNextName();


        displayNames();

	}
    /**
     *  Section contains GetNextName(), DisplayNames() & StoreName(String)"
     */
    private static String getNextName(){
    	Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter %s friend's name or type 'Q' to quit", isFirstName ? "a":"another");
        String s = scanner.next();
        if (s.contains(",")){
            System.out.println("Can't have a comma in a friends name");
            return "Q";
        }
        return s;
    }
    private static void displayNames(){
        if (sb.length() == 0 || sb.toString() == "Q"){
            System.out.println("You seem to be Billy Nomates");
            return;
        }
        // Using ternary expression to handle grammar
        System.out.printf("Your friend%s %s: %s\n",(count > 1) ? "s":"",(count > 1) ? "are" : "is" ,sb);
    }
	/**
	 * Appends the name to the end of the StringBuilder string 
	 */
    static void storeName(String name){
    	// Note shorthand version of if statement
        if (!isFirstName) sb.append(", ");
        sb.append(name);
        count++;
        isFirstName = false;
    }	
    static StringBuilder sb = new StringBuilder();
    static Boolean isFirstName = true;
    static int count;}
