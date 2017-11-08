package Starter;

import java.util.Scanner;

public class EnumPractice {

	public static void main(String[] args) {

		HolidayDestination destination = getHolidayDestination();
		processHoliday(destination);
	}


	private static HolidayDestination getHolidayDestination() {

		HolidayDestination[] destinations = HolidayDestination.values();

		System.out.println("Choose a holiday destination");
		// display descriptive values with an incremental count
		// e.g 1 - Africa
		//     2 - Asia
		int count = 0;
		for (HolidayDestination destination : destinations) {
			System.out.printf("%d - %s\n", ++count, destination.toString());
		}
		Scanner scan = new Scanner(System.in);
		// catch the typed choice
		int choice = scan.nextInt();
		scan.close();

		int maxChoices = destinations.length;
		// if not in range assume Other
		if (choice <= 0 || choice > maxChoices) {
			System.out.println("Assuming ... Other");
			return HolidayDestination.Other;
		}
		return destinations[choice - 1];
	}

	private static void processHoliday(HolidayDestination destination) {
		switch (destination) {
		case Africa:
			System.out.println("Safari, and see the big 5");
			break;
		case Asia:
			System.out.println("Try Beijings Forbidden City");
			break;
		case NorthAmerica:
			System.out.println("Take the Rocky Mountaineer");
			break;
		case Europe:
			System.out.println("The flight will be shorter!");
			break;
		case SouthAmerica:
			System.out.println("Machu Picchu is recommended");
			break;
		case India:
			System.out.println("See the Taj Mahal");
		case Australia:
			System.out.println("Don't miss the Great Barrier Reef");
			break;
		default:
			System.out.println("Must be Penguins or Polar Bears then");
			break;
		}
	}





}
