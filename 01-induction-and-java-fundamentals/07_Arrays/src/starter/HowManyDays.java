package starter;

import java.text.DateFormatSymbols;
import java.util.*;

public class HowManyDays {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		String dayNames[] = new DateFormatSymbols().getWeekdays();
		System.out
				.println("This lab is about working out which day of the year you were born in\n");
		System.out.printf(
				"Java can do it. Today (%s, %s) is Day %d for example\n",
				dayNames[calendar.get(Calendar.DAY_OF_WEEK)],
				calendar.get(Calendar.DAY_OF_MONTH),
				calendar.get(Calendar.DAY_OF_WEEK));
		System.out
				.println("Could you calculate the right day number for your date of birth?");
		System.out.println();
		int year, month, day;
		year = getInteger("Enter the year you were born as 4 digits e.g 1997");
		if (year <= 1000) {
			System.out.println("Year must be 4 digits");
			return;
		}
		month = getInteger("Enter the month you were born in (1-12)");
		if (month <= 0 || month > 12) {
			System.out.println("Month must be 1-12");
			return;
		}
		day = getInteger("Enter the day you were born on (1-31)");
		if (day <= 0 || day > 31) {
			System.out.println("Day must be 1-31");
			return;
		}
		// Key method call ................
		int dayOfYear = calculateDayOfYear(year, month, day);
		int whatJavaThinksItIs = getJavaToCalculate(year, month, day);

		System.out.printf("You think it was day %d", dayOfYear);
		System.out.printf("Java thinks it was day %d", whatJavaThinksItIs);
		System.out.printf("You got it %s",
				(dayOfYear == whatJavaThinksItIs) ? "right"
						: "wrong - revisit your code!");

	}

	private static int getInteger(String value) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(value);
		String input = scanner.next();
		int num;
		return Integer.parseInt(input);

	}

    private static int calculateDayOfYear(int year, int month, int day)
    {
        // Put 12 values in this array.
        // 30 days have April, Sept, June & November all the rest have 31
        // Except February which has 28 - we will address the Leap Year issue later 
        int[] daysInMonth = { };   

        // This is the variable that is to be returned at end of method
        int dayOfYear = 0; // initialised so you can ADD to it!
        
        // Calculate the days up to the end of the month before you were born
        // Think about what how this would need to work if month number was 5 say
        // How would it then work if month number was 1.
        
        
        
        // Don't forget to include the days of the month you were born in
        
        // Add 1 only if it was a leap year AND you were born AFTER February
        // We have supplied a bool IsLeapYear(int year) method pre-coded for you to use

        return dayOfYear;
    }
   
    // Helper routines

    private static int getJavaToCalculate(int year, int month, int day)
    {
        int dayOfYearAccordingtoJava = 0;
        try
        {
        	Calendar calendar = new GregorianCalendar(year,month,day);
        	
        	dayOfYearAccordingtoJava = calendar.DAY_OF_YEAR;
        }
        catch (Exception e)
        {
            System.out.println("You are trying to break it! that month does not have that many days!");
            //Environment.Exit(0);
        }
        return dayOfYearAccordingtoJava;
    }
	private static Boolean isLeapYear(int year) {
		Boolean divBy4, divBy100, divBy400;

		divBy4 = year % 4 == 0;
		divBy100 = year % 100 == 0;
		divBy400 = year % 400 == 0;

		return (divBy4 && !divBy100) || divBy400;
	}
}
