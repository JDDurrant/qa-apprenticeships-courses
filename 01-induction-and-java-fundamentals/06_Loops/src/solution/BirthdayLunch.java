package solution;

public class BirthdayLunch {

	public static void main(String[] args) {
		double originalFunds = 100;
        double priceOfNextMeal = 12;
        int noGuests = 0;
        double fundsRemaining = originalFunds;
        double cheapestMeal = priceOfNextMeal;
        while (priceOfNextMeal < fundsRemaining) {
            noGuests++;
            fundsRemaining -= priceOfNextMeal;
            cheapestMeal = priceOfNextMeal;
            System.out.printf("Meal price: %.2f\n",priceOfNextMeal);
            priceOfNextMeal *= 0.95;
        }

        System.out.printf("I can entertain %d guests (incl myself) from %.2f and will have %.2f towards a taxi home%n",
            noGuests, originalFunds, fundsRemaining);
        System.out.printf("The average price of each meal was %.2f\n", (originalFunds - fundsRemaining) / noGuests);
        System.out.printf("The cheapest meal was %.2f", cheapestMeal);

	}

}
