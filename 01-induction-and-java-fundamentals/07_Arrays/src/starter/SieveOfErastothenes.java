package starter;

public class SieveOfErastothenes {

	public static void main(String[] args) {
        // set upper limit of range of prime numbers req'd
        int limit;
        // create array of that size, so if limit is 100 
        // then array is elements 0 - 99 
        // all will default to false

        
        // make every value from 2 upwards = true 
        // i.e all numbers >= 2 considered prime at this stage
        

        //generatePrimesTech1(flags);
        //print(limit, flags);

        //generatePrimesTech2(flags);
        //print(limit, flags);

        //generatePrimesTech3(flags);
        //print(limit, flags);

	}
	private static void generatePrimesTech1(Boolean[] flags)
    {
        // start at 2 go up to end of array

        // if it is a prime then set multiples to not prime
        // starting at double loop index, moving on to 3 *, 4 * etc
                              
    }
    private static void generatePrimesTech2(Boolean[] flags)
    {
        // start at 2 go up to end of array       
        // if it is a prime then set multiples to not prime
            
        // Enhancement - start at outerloopvalue squared as all smaller
        // multiples of outerloopvalue will have already been set to false

    }
    private static void generatePrimesTech3(Boolean[] flags)
    {
        //start at 2 go up to end of array

        // ENHANCEMENT: only consider odd values as print routine is going 
        // to ignore even numbers > 2


        // if it is a prime set multiples to not prime

        // Further Enhancement - start at outerloopvalue squared as per Technique 2 
        // as all smaller multiples of outerloopvalue will have already 
        // been set to false, BUT then only check odd multiples
        // by incrementing moving on to 3 *, 5 *, 7 * etc

        
    }

    private static void print(int limit, Boolean[] flags)
    {
        String output = "";
        // loop through the flags
        for (int i = 2; i < flags.length; i++)
        {
            // if prime append this number plus a tab to the output

        }

        System.out.printf("The prime numbers up to {0} are", limit);
        System.out.println(output);
        System.out.println();
    }
}
