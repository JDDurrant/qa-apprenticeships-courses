package starter;

public class KidsInCandyStore_Part1 {

	private static int price, money;

	public static void main(String[] args) {
//		TODO Refactor this mess! Split things out across more methods.
		System.out.println("How many bags of sweets can you buy? Let's find out!\n");

		price = Prompt.fieldInteger("Price");
		int numBags, remainder, nextBag;

		if(price > 0) {
			money = Prompt.fieldInteger("Money");

			if (money >= 0) {
				numBags = money / price;
				remainder = money % price;
				nextBag = price - remainder;

				check(sufficientFunds(),
					String.format("With %dp, can buy %d bags of sweets. After that, "
						+ "you'll need %dp to buy another bag.\n",
						money, numBags, nextBag),
					String.format(
						"You don't have enough money to buy sweets. You'll have to get "
						+ "%dp and then buy a bag.\n", nextBag)
				);

//				check(sufficientFunds(),
//					"With %dp, can buy %d bags of sweets. After that, you'll need %dp to buy another bag.",
//					money, numBags, nextBag);



			} else if(money < 0) {
				System.out.println("Aren't you a little young to be in debt?");
			}

		} else {
			System.out.printf("%dp a bag? That sounds too good to be true.", price);
		}
	}

	public static boolean hasMoney() {
		return money > 0;
	}

	public static boolean sufficientFunds() {
		return money >= price;
	}

	public static void check(boolean condition, String ifTrue, String ifFalse) {
		if (condition) System.out.println(ifTrue);
		else System.out.println(ifFalse);
	}

//	public static void check(boolean condition, String message, int... data) {
//		if (condition) System.out.printf();
//	}
}
