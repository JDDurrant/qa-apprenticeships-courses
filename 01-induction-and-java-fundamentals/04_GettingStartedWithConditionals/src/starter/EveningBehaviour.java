package starter;

public class EveningBehaviour {
	static boolean summerTime = true;
	static boolean sunnyEvening = true;
	static boolean weekend = false;

	public static void main(String[] args) {
		if (summerTime) {
			takeShower();

			if (sunnyEvening) {
				eat("outside");
			} else {
				eat("inside");
			}

			doActivity("gardening");
			read("paper", "summerhouse");
		} else {
			eat("inside");
			if (sunnyEvening) read("paper", "summerhouse");
			doActivity("paperwork");
			read("book", "bed");
		}
	}

	public static boolean isSummerTime() {
		return summerTime;
	}

	public static boolean isSunnyEvening() {
		return sunnyEvening;
	}

	public static boolean isWeekend() {
		return weekend;
	}

	public static void takeShower() {
		System.out.println("Taking shower");
	}

	public static void eat(String where) {
		System.out.printf("Eating %s\n", where);
	}

	public static void doActivity(String what) {
		System.out.printf("Doing %s\n", what);
	}

	public static void read(String what, String where) {
		System.out.printf("Reading %s in %s\n", what, where);
	}
}
