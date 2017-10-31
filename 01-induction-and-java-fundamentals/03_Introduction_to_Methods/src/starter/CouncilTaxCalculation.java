package starter;

public class CouncilTaxCalculation {

	public static void main(String[] args) {

		double councilTaxTotal = Prompt.getDouble(
			"Enter your total council tax for this period.");

		double initial = calculateInitialPayment(councilTaxTotal);
		long subsequent = calculateSubsequentPayments(councilTaxTotal);

		System.out.printf(
			"Your initial payment will be £%.2f. This will be followed by 9 payments of "
			+ "£%d.00.", initial, subsequent);
	}

	private static double calculateInitialPayment(double total) {

		return total - (9 * calculateSubsequentPayments(total));
	}

	private static long calculateSubsequentPayments(double total) {

		return Math.round(total / 10);
	}
}
