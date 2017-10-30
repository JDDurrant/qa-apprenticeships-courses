package zz_extra.Solution;

public class PensionPredictor {

	public static void main(String[] args) {
        // Part 1
        int startAge = 21, retireAge = 67;
        double salary = 18000, pensionFund = 0;

        double higherPayRiseRate = 5, lowerPayRiseRate = 2;

        double contributionPercent = 10, fundGrowthRate = 5;
        int ageAtWhichLowerPayRisesCutIn = 41;

        double totalContributions = 0;

        for (int age = startAge; age < retireAge; age++)
        {
            // calculate this years contribution
            double thisYearPensionContribution = salary * contributionPercent / 100;

            // add it to total contributions (needed in Part 2)
            totalContributions += thisYearPensionContribution;

            // add this years contribution to the fund
            pensionFund += thisYearPensionContribution;
            // grow the fund
            pensionFund *= (1 + fundGrowthRate / 100);

            // end of year - salary rise 
            if (age < ageAtWhichLowerPayRisesCutIn) // true at age 40
            {
                salary *= (1 + higherPayRiseRate / 100);
            }
            else // true from age 41
            {
                salary *= (1 + lowerPayRiseRate / 100);
            }
            // or
            //salary *= (1 + (age < ageAtWhichLowerPayRisesCutIn ? higherPayRiseRate : lowerPayRiseRate) / 100);

        }
        double roundedPensFund = Math.round(pensionFund);
        System.out.printf("Value of Pension Fund = £%.2f\n", roundedPensFund);


        // Part 2
        double inflFactor = (double)Math.pow(.98, 46);
        double fundAtCurrentPrices = Math.round(pensionFund * inflFactor);

        
        System.out.printf("Value of Fund at Todays Prices = £%.2f\n", fundAtCurrentPrices);
        System.out.printf("Value of 25%% tax free lump sum = £%d\n", Math.round(fundAtCurrentPrices * .25));

        double personalCostAfterTaxRelief = Math.round(totalContributions / 2 * .8); // as employer pays half
        System.out.printf("Cost of total contributions assuming 20%% tax relief = £%.2f\n",personalCostAfterTaxRelief);


	}

}
