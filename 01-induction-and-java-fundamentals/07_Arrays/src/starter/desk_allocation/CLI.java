package starter.desk_allocation;

public class CLI {

	public static void commandCheck(String command) {

		command = command.toLowerCase();

		switch (command) {
		case "all":
			DeskAllocation.displayDeskMap();
			break;

		case "clear":
			DeskAllocation.clearAllDesks();
			break;

		default:
			break;
		}
	}

	public static void searchDesks() {

		System.out.println();
		String name = Prompt.getString("Enter the name of a student to find their desk.");
		DeskAllocation.searchDesks(name);

		searchDesks();
	}

}
