package solution;

public class SieveOfErastothenes {

	public static void main(String[] args) {
        // set upper limit of range of prime numbers req'd
        int limit = 100;
        // create array of that size, so if limit is 100 
        // then array is elements 0 - 99 
        Boolean[] flags = new Boolean[limit]; // all will default to false

        
        // make every value from 2 upwards = true 
        // i.e all numbers >= 2 considered prime at this stage
        for (int i = 2; i < flags.length; i++){
            flags[i] = true;
        }

        generatePrimesTech1(flags);
        print(limit, flags);

        generatePrimesTech2(flags);
        print(limit, flags);

        generatePrimesTech3(flags);
        print(limit, flags);

	}
    // EACH of these 3 methods has 2 code fragments for the nested loop
    // as some students see it one way and some the other

    // One mechanism sets the value of 'j' at start of loop 
    // to a value based on what 'i' is and then changes 
    // the value of 'j' again based on 'i's current value and only tests
    // flags[j] i.e. when i = 5, j might start on 10 and get changed to 15,20,25
    // with this mechanism you never see 'i * j' coded
	//
    // A second mechanism is to start j on a value, to then change j by maybe
    // j++ or j+=2 (i.e. regardless of i's value) but to then always use 
    // the value i*j when setting a flag (flags[i*j]).
    // but if 2nd technique is used you always need to be testing for
    // 'is i * j too big, if so break'

    private static void generatePrimesTech1(Boolean[] flags)
    {
        // start at 2 go up to end of array       
    	int numIterations = 0;

        for (int i = 2; i < flags.length; i++){
            if (flags[i]){ 
            	// i.e is a prime then set multiples to not prime
                // start at double loop index, moving on to 3 *, 4 * etc
                for (int j = i * 2; j < flags.length; j += i){
                    numIterations++;
                    flags[j] = false;
                }
                //or
                //for (int j = 2; j < flags.length; j++){
                //

                //    if (i * j > flags.length) 
                //        break;
                //    numIterations++;
                //    flags[i * j] = false;
                //}
            }
            else {  
            	// if already set as not prime then do nothing as all multiples will be already set as not prime 
            }

        }
    
        System.out.println(numIterations);            
        // Enhancement - start at outerloopvalue squared as all smaller
        // multiples of outerloopvalue will have already been set to false

    }
	private static void generatePrimesTech2(Boolean[] flags)
    {
		//start at 2 go up to end of array
        int numIterations = 0;
        for (int i = 2; i < flags.length; i++)
        {
            if (flags[i]) // i.e is a prime then set multiples to not prime
            {
                // Enhancement - start at outerloopvalue squared as all smaller
                // multiples of outerloopvalue will have already been set to 
                // false
                for (int j = i * i; j < flags.length; j += i)
                {
                    numIterations++;
                    flags[j] = false;
                }
                //or
                //for (int j = i; j < flags.length; j++)
                //{

                //    if (i * j > flags.length)
                //    {
                //        break;
                //    }
                //    numIterations++;
                //    flags[i * j] = false;
                //}
            }
            else { } // if already set as not prime then do nothing as all multiples will be already set as not prime 
            
        }
        System.out.println(numIterations);
                              
    }   
	private static void generatePrimesTech3(Boolean[] flags)
    {
		//start at 2 go up to end of array, may need to be a long for i squared
        int numIterations = 0;
        for (int i = 2; i < flags.length; i++)
        {
            // only consider odd values as print routine is going to ignore
            // even numbers > 2
            if (i % 2 == 0) continue;

            if (flags[i]) // i.e is a prime so set multiples to not prime
            {
                // Further Enhancement - start at outerloopvalue squared as per Technique 2 
                // as all smaller multiples of outerloopvalue will have already 
                // been set to false, BUT then only check odd multiples
                // by incrementing moving on to 3 *, 5 *, 7 * etc
                for (int j = i * i; j < flags.length; j += (i * 2))
                {
                    numIterations++;
                    flags[j] = false;
                }
                //or
                //for (int j = i; j < flags.length; j += 2)
                //{
                //    if (i * j > flags.length)
                //    {
                //        break;
                //    }
                //    numIterations++;
                //    flags[i * j] = false;
                //}
            }
            else { } // if already set as not prime do nothing as all multiples will be already set as not prime
        }
        System.out.println(numIterations);
    }

    private static void print(int limit, Boolean[] flags)
    {
        String output = "";
        // loop through the flags
        for (int i = 2; i < flags.length; i++){
            // if prime append this number plus a tab to the output
            if (i > 2 && i % 2 == 0) 
            	continue; // even numbers gt 2, ignore
            if (flags[i]) 
            	output += (i + "\t");
        }

        System.out.printf("The prime numbers up to %d are: ", limit);
        System.out.println(output);
        System.out.println();
    }
}
