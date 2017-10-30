package solution;

import java.util.Scanner;

public class WeightConversions {
	private static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
        ConvertInputToStonesPounds();

        ConvertKgsToStonesPounds();

        ConvertStonesPoundsToKgs();

	}
    private static void ConvertInputToStonesPounds()
    {
    	int pounds = getInteger("Enter Pounds please");

        int stones = pounds / 14;
        pounds = pounds % 14;
        
        System.out.printf("%d stones %d pounds", stones, pounds);
    }

    private static void ConvertKgsToStonesPounds()
    {
        double conversionFactorKgsToLbs = 2.20462;
        int kgs = getInteger("Enter kgs please");
        double rpounds = Math.round(kgs * conversionFactorKgsToLbs);
        int pounds = (int)rpounds; 
        int stones = pounds / 14;
        pounds %= 14;

        System.out.printf("%d stones %d pounds", stones, pounds);
    }

    private static void ConvertStonesPoundsToKgs()
    {
        double conversionFactorKgsToLbs = 2.20462;
        int stones, pounds;
        stones = getInteger("Enter Stones please");
        pounds = getInteger("Enter Pounds please");

        pounds += stones * 14;

        double kg = pounds / conversionFactorKgsToLbs;
        
        System.out.printf("%d kg", kg);
    }
	private static int getInteger(String message) {
		System.out.println(message);
		return s.nextInt();
	}
}
