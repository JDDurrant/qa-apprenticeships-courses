package zz_extra.Starter;

public class PensionPredictor {

	public static void main(String[] args) {

		int startAge = 21, retireAge = 67;
		double salary = 18000, pensionFund = 0, pensionContributions = 0;

		double higherPayRiseRate = pct(5), lowerPayRiseRate = pct(2);

		double contributionPercent = pct(10), fundGrowthRate = pct(6);
		int age, ageAtWhichLowerPayRisesCutIn = 41;

		for(age = startAge; age < retireAge; age++) {

//			calculate this year's contribution
			double contribution = salary * contributionPercent;

//			add it to total contributions (needed in Part 2)
			pensionContributions += salary * contributionPercent;

//			add this year's contribution to the fund
			pensionFund += contribution;

//			grow the fund
			pensionFund += pensionFund * fundGrowthRate;

//			end of year - salary rise
			if(age < ageAtWhichLowerPayRisesCutIn)
				salary += salary * higherPayRiseRate;
			else
				salary += salary * lowerPayRiseRate;
		}

		long roundedPensionFund = Math.round(pensionFund);
		System.out.printf("Value of Pension Fund: £%,d\n", roundedPensionFund);


//		******************************************************************************************


//		Part 2
		double inflationFactor = pct(97.5);

		double annuityRate;
//		TODO Fix this monstrosity
		double fundAtCurrentPrices = Math.pow(
			pensionFund * inflationFactor,
			retireAge - startAge);

		double taxFreeLumpSum;
		double totalContributionsLessTaxRelief, annuity;

		System.out.printf("Value of Fund at Today's prices: %f\n", fundAtCurrentPrices);
//
//		System.out.printf("Value of 25%% tax free lump sum: %d\n");
//
//		System.out.printf("Pension available from annuity: %d\n");
//
//		System.out.printf("Cost of total contributions assuming 20%% tax relief: %d\n");
	} // main(String[] args)

	private static double pct(int percentage) {

		return ((double)percentage)/100;
	}

	private static double pct(double percentage) {

		return percentage/100;
	}
}
