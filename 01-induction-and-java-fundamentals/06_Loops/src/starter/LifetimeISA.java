package starter;

public class LifetimeISA {

	public static void main(String[] args) {
        int noOfYears = 32; // proposed LISA rules state from age 18 to 50 at present so not more than 32
        double yearlyContribution = 4000; // this is the proposed maximum yearly contribution
        double yearlyIntRate;  
        double totalLISAValue;

     // do simple calculations to put values in these 3 variables 
        int totalNumberOfContributions;
        double monthlyContribution, monthlyIntRate;
        
     // write a loop to run for the right number of months

        // inside the loop..
        // ...make the monthlycontribution
        // ...add 1 months interest
        // ...if a year end (end of every 12th month) add the HMRC government bonus of 25% of the years contribution
        // ...display the balance at the end of each year
        
        // when loop completes display total contributions made 
        // System.out.printf("Total contributions made by age 50 %.2f\n"
        
        // at age 50 uncertain whether further subscriptions will be allowed but probably will
        // but ... no more HMRC bonuses from age 50
        // the whole wad is accessible TAX-FREE at age 60 as a 'pension' substitute
        // write another loop for the 120 months in your 50's upping the totalValue 
        // via contributions and interest growth only
        
        //System.out.println();
        //System.out.println("Assuming contributions continue for another 120 months + growth but no bonuses");
        //System.out.printf("At age 60 LISA balance will be %.2f\n");
	}

}
