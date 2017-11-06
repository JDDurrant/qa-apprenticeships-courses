package starter.desk_allocation;

import java.util.Arrays;

public class DeskAllocation {

	public static String[][] deskNames = new String[3][4];

	public static String[] names =
		{ "Amy", "Ben", "Carly", "Danesha", "Evy", "Faroukh",
		  "Greg", "Heather", "Ivy", "Jaz", "Keith", "Monica",
		  "Nick" }; // names.length == 13

	public static void main(String[] args) {
		// initialise and size the array at 3 rows * 4 columns

		allocateAllDesks();

		displayDeskMap();

//		searchDesks("Jaz");
//		searchDesks("Nick");

		CLI.searchDesks();

	}

	public static void allocateAllDesks() {

//		displayDeskMap();

		for (String name : names) {
			allocateDesk(name);
		}
	}

	// called from allocateAllDesks()
	public static void allocateDesk(String name) {
//		TODO Fix this code repetition
		boolean deskAssigned = false;

		for (int row = 0; row < deskNames.length; row++) {

			for (int col = 0; col < deskNames[row].length; col++) {

				if(deskNames[row][col] == null) {

					deskNames[row][col] = name;
					deskAssigned = true;

					break;
				}
			}

			if (deskAssigned) break;
		}

		if(!deskAssigned) System.out.printf("No desk assigned to %s.\n", name);
	}

	public static void displayDeskMap() {

		for (int row = 0; row < deskNames.length; row++) {

			for (int col = 0; col < deskNames[row].length; col++) {
				String name = deskNames[row][col];

				if (name != null)
					System.out.printf("%s\t", name);
				else
					System.out.print("EMPTY\t");
			}

			System.out.println();
		}
		System.out.println();
	}

	public static void searchDesks(String name) {

		boolean exists = Arrays.asList(names).contains(name);

		CLI.commandCheck(name);

		if(!exists) {
			System.out.printf("%s is not in this class.\n", name);
			return;
		}

//		boolean deskFound = false;

		for (int row = 0; row < deskNames.length; row++) {

			for (int col = 0; col < deskNames[row].length; col++) {

				if(name.equals(deskNames[row][col])) {

//					deskFound = true;
					System.out.printf("%s is located at row %d column %d.\n", name, row + 1, col + 1);
					return;
				}
			}
		}

		System.out.printf("%s has no desk.\n", name);
	}

	public static void clearAllDesks() {

		for (int row = 0; row < deskNames.length; row++) {

			for (int col = 0; col < deskNames[row].length; col++) {

				deskNames[row][col] = null;
			}
		}
	}
}
