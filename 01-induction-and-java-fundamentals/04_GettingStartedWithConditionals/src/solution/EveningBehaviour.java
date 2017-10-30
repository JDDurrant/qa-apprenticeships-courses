package solution;

public class EveningBehaviour {
	static boolean summerTime = false;
	static boolean sunnyEvening = false;
	static boolean isWeekend = false;

	public static void main(String[] args) {

		if (isWeekend()) {
			doActivity("- having a lie in");
			doActivity("- watch sport on TV");
			doActivity("- go out for a meal");
		} else {
			if (isSummerTime()) {
				take("Shower");
				if (isSunnyEvening()) {
					eat("outside");
				} else {
					eat("inside");
				}
				doActivity("outdoor hobby");
			} else {
				eat("inside");
				if (isSunnyEvening()) {
					take("walk");
				}
				doActivity("online game");
				take("Shower");
			}
			contactFriends("phone");
		}
		doActivity("- cleaning teeth");
	}

	public static boolean isSummerTime() {
		return summerTime;
	}

	public static boolean isSunnyEvening() {
		return sunnyEvening;
	}

	public static boolean isWeekend() {
		return isWeekend;
	}

	public static void eat(String where) {
		System.out.printf("Eating %s\n", where);
	}

	public static void doActivity(String activity) {
		System.out.printf("Doing %s\n", activity);
	}

//	public static void takeShower() {
//	System.out.println("Taking shower");
//}
//	public static void takeShortWalk() {
//	System.out.println("Taking short walk");
//}
	public static void take(String what) {
		System.out.printf("Taking %s\n", what);
	}

	public static void contactFriends(String how) {
	 	   System.out.printf("Contacting friends by %s\n", how);
	}
}
