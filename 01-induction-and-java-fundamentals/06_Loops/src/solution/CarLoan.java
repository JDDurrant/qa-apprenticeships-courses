package solution;

import java.util.Random;
import java.util.Scanner;

public class CarLoan {
	// Student will supply at command prompt, 4 values, the value of loan,
	// yearly interest rate
	// and a min and max repayment they could make each month
	// Outstanding balance will go up by 1/12th of the yearly interest rate at
	// beginning of each month
	// Presupplied method GenerateThisMonthsRepayment(double min, double max)
	// uses Math.Random to
	// produce a monthly repayment value in the min-max range
	// Need to count the number of months it takes
	// In loop, keep displaying amount paid back this month, and total paid back
	// so far, and remaining balance

	// At END of loop display total amount repaid and how much was interest
	// & what % the interest cost was of the original loan

	public static void main(String[] args) {
		// 4 pre-declared variables so everyone's code looks 'similar'
		double loanAmount, intRate, minMnthlyPayment, maxMnthlyPayment;
		
		// prompt for the 4 key numeric values by calling GetAmount() 4 times in
		// sequence

		loanAmount = getAmount();
		intRate = getAmount();
		minMnthlyPayment = getAmount();
		maxMnthlyPayment = getAmount();

		// setup the balanceRemaining - the whole of the loan at this stage
		double balanceRemaining = loanAmount;

		// define variables to count the months & track totalPayments(double)
		double totalPayments = 0;
		int months = 0;

		// loop to generate a monthly payment as long as some loan is
		// outstanding
		while (balanceRemaining > 0) {
			// calculate interest for the month and add it to the
			// balanceRemaining
			balanceRemaining += balanceRemaining * (intRate / 12.0) / 100;
			// balanceRemaining *= (100 + (intRate / 12.0M)) / 100;

			// increment the month count
			months++;

			// generate this month's repayment - call
			// GenerateThisMonthsRepayment(..,..)
			double thisMonthsPayment = generateThisMonthsRepayment(
					minMnthlyPayment, maxMnthlyPayment);

			// if it is greater than outstanding balance then change it to equal
			// the outstanding balance
			if (thisMonthsPayment > balanceRemaining) {
				thisMonthsPayment = balanceRemaining;
			}
			// update the balance outstanding
			balanceRemaining -= thisMonthsPayment;
			// update total payments made
			totalPayments += thisMonthsPayment;

			// display 4 things - month number, this months repayment, total
			// repayments, balance remaining
			System.out
					.printf("Month %d - repaid %.2f, total repaid - %.2f, balance remaining - %.2f\n",
							months, thisMonthsPayment, totalPayments,
							balanceRemaining);
		}
		// After loop completes display total repayments and cost of credit (the
		// interest paid)
		System.out.printf(
				"\nTotal Repayments = %.2f, cost of credit was %.2f\n",
				totalPayments, totalPayments - loanAmount);
		// also what the total interest is as a % of original loan amount
		System.out.printf("Interest as a percentage of original loan = %.2f%%",
				((totalPayments - loanAmount) / loanAmount) * 100);

	}

	private static double generateThisMonthsRepayment(double minMnthlyPayment,
			double maxMnthlyPayment) {
		if (minMnthlyPayment > maxMnthlyPayment) {
			System.out.printf("Minimum can't be greater than maximum!");
			System.exit(0);
		}
		// A method of returning a random number within a range
		return r.nextInt(((int) maxMnthlyPayment - (int) minMnthlyPayment) + 1)
				+ minMnthlyPayment;
	}

	/**
	 * Helper methods that don't need looking at YET
	 */
	private static double getAmount() {
		Scanner scanner = new Scanner(System.in);
		double amount = 0;
		if (promptNo >= prompts.length)
        {
            System.out.println("Can't call method GetAmount() more than 4 times");
            System.exit(0);
        }
		
		System.out.printf("Please enter %s", prompts[promptNo++]);
		String valueEntered = scanner.next();
		
		if (!tryParse(valueEntered)) {
			System.out.println("Must enter a numeric value - program stopped");
			System.exit(0);
		} 
		else {
			amount = Double.parseDouble(valueEntered);
			if (amount <= 0) {
				System.out.println("Must enter a positive numeric value - program stopped");
				System.exit(0);
			}
		}
		return amount;
	}
	
	private static Boolean tryParse(String value) {
		try {
			Double.parseDouble(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private static int promptNo = 0;
	private static String[] prompts = { "total car loan amount in £",
			"yearly interest rate",
			"minimum £ amount you could always repay in a given month",
			"maximum £ amount you could ever afford in a given month" };

	private static Random r = new Random();

}
