package starter;

public class TheLunchQueue {

	public static void main(String[] args) {

		String mainCourse = Prompt.getString("What main dish would you like?");
		int roastCount = Prompt.getInteger("How many roast potatoes would you like?");
		int sproutCount = Prompt.getInteger("How many brussel sprouts would you like?");

		System.out.printf(
			"Your lunch today is %s with %d roast potatoes and %d brussel sprouts.\n",
			mainCourse, roastCount, sproutCount);

		Prompt.pause("Press enter to continue...");

//		TODO Calculate sprout:potato ratio
	}
}
