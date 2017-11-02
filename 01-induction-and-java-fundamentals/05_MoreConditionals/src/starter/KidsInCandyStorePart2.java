package starter;

public class KidsInCandyStorePart2 {

	public static void main(String[] args) {
		double price = Prompt.getCurrency("Price of a bag please?");
		double money = 0;
		double remainder = 0;
		double nextBag = 0;

		if (price > 0) {
			money = Prompt.getCurrency("How much money do you have?");
			remainder = money % price;
			nextBag = price - remainder;
		}

		if (price > 0 && money > 0) {
			long numBags = Math.round(money / price);
//			If price is £%.2f and you have £%.2f, you will be able to buy %s %s.
			System.out.printf("If price is £%.2f and you have £%.2f you will be able to buy %s %s.\n",
				price, money, numBags, (numBags > 1) ? "bags" : "bag");
//			Press enter to buy sweets...
			Prompt.pause("Press enter to buy sweets...");
//			You have £%.2f left. You'll need another £%.2f before you can buy more sweets.
			System.out.printf("You have £%.2f left. You'll need another £%.2f before you can buy more sweets.",
				remainder, nextBag);

			return;
		}

		if (price > 0 && money == 0)
		{
			System.out.println("Come back with your pocket money!");

			return;
		}

		if (price > 0 && money < 0)
		{
			System.out.println("Money must be a non-negative numeric value");

			return;
		}

		if (price == 0)
		{
			System.out.println("They are free take as many as you want!");
			return;
		}

		if (price < 0)
		{
			System.out.println("Price must be a non-negative numeric value");

			return;
		}
	}
}
