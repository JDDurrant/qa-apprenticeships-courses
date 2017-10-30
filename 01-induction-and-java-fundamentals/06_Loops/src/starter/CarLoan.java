package starter;

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
	// Presupplied method tryParse(String) returning Boolean if the string
	// parameter contains a number
	// Need to count the number of months it takes
	// In loop, keep displaying amount paid back this month, and total paid back
	// so far, and remaining balance

	// At END of loop display total amount repaid and how much was interest
	// & what % the interest cost was of the original loan

	public static void main(String[] args) {
		// 4 pre-declared variables so everyone's code looks 'similar'
		double loanAmount, intRate, minMnthlyPayment, maxMnthlyPayment;
		
		// initialise these 4 variables by prompting for the 4 key numeric values 
        // by calling GetAmount() 4 times in (correct) sequence


        // setup the balanceRemaining - should be the whole of the loan at this stage
		double balanceRemaining;

        // define and initialise variables to count the months & track totalPayments


        // loop to add interest and generate a monthly payment as long as some loan is outstanding
        while (true){ // Note infinite loop - change this
		
        
        // calculate interest for the month and add it to the balanceRemaining (use += or *=)

        // increment the month count

        // generate this months repayment - call GenerateThisMonthsRepayment(..,..)
        double thisMonthsPayment;

        // if it is greater than outstanding balance then change it to equal the outstanding balance

        // update the balance outstanding

        // update total payments made

        // display 4 things - month number, this months repayment, total repayments, balance remaining
        // uncomment the code below and refactor
		/*        
		 * System.out.printf("Month %d - repaid %.2f, total repaid - %.2f, balance remaining - %.2f\n",
            dummyNo,
            dummyNo,
            dummyNo,
            dummyNo);
        */
        }
    
        // uncomment the code below and refactor
        /*
		System.out.printf("\nTotal Repayments = %.2f, cost of credit was %.2f\n", dummyNo, dummyNo);
		// also what the total interest is as a % of original loan amount
		System.out.printf("Interest as a percentage of original loan = %.2f%%", dummyNo);
		*/
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
