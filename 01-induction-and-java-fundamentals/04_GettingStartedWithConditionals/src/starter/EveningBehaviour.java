package starter;

public class EveningBehaviour {
	static boolean summerTime = true;
	static boolean sunnyEvening = true;

	public static void main(String[] args) {

	}

	public static boolean isSummerTime() {
		return summerTime;
	}

	public static boolean isSunnyEvening() {
		return sunnyEvening;
	}

	public static void eat(String where) {
		System.out.printf("Eating %s\n", where);
	}

	public static void doOutdoorHobby() {
		System.out.println("Doing paperwork");
	}

	public static void doOnlineGame() {
		System.out.println("Reading paper in summerhouse");
	}
	
	public static void takeShower() {
		System.out.println("Taking shower");
	}
	
	public static void takeWalk() {
		System.out.println("Taking shower");
	}


	public static void ContactFriends(String how) {
		System.out.println("Reading book in bed");
	}

}
