package solution;

public class LifetimeISA {

	public static void main(String[] args) {
        int noOfYears = 32; // proposed LISA rules state from age 18 to 50 at present so not more than 32
        double yearlyContribution = 4000; // this is the proposed maximum yearly contribution
        double yearlyIntRate = 2;  // bit optimistic at present if it is just a Cash LISA

        double totalLISAValue = 0;

        int totalNumberOfContributions = noOfYears * 12;
        double monthlyContribution = yearlyContribution / 12;
        double monthlyIntRate = yearlyIntRate / 12;
        
        for (int month = 1; month <= totalNumberOfContributions; month++){
            // Make the monthlycontribution
            totalLISAValue += monthlyContribution;
            // Add 1 months interest
            totalLISAValue += totalLISAValue * monthlyIntRate / 100;

            // If a year end add the HMRC government bonus
            if (month % 12 == 0){
                totalLISAValue += (yearlyContribution * .25);
                System.out.printf("End of year %d LISA balance will be %.2f\n", month / 12, totalLISAValue);
            }
        }
        System.out.printf("Total contributions made by age 50 %.2f\n", noOfYears * yearlyContribution);


        // at age 50 uncertain whether further subscriptions will be allowed but probably will
        // but no more HMRC bonuses from age 50
        // the whole wad is accessible TAX-FREE at age 60 as a 'pension' substitute
        // so .. 120 months in your 50's
        for (int month = 1; month <= 120; month++){
            totalLISAValue += monthlyContribution;
            totalLISAValue += totalLISAValue * monthlyIntRate / 100;
        }
        System.out.println();
        System.out.println("Assuming contributions continue for another 120 months + growth but no bonuses");
        System.out.printf("At age 60 LISA balance will be %.2f\n", totalLISAValue);


	}
}
