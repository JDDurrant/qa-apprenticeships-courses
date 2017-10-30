package solution;

public class ArrayWarmUp {

	public static void main(String[] args) {
        basicArrayUsage();

        practicingForEachLoops();

        indexingIntoAnArray();

        passingAnArraytoAmethod();

	}

    private static void basicArrayUsage()
    {
        System.out.println("\n\n** Basic Array Usage **");
        // Task 1 - one of these 2 statements is valid, one is not. Uncomment the correct one
        int[] ages;
        //int[4] ages;

        // Task 2 - one of these 2 statements is valid, one is not. Uncomment the correct one
        //ages = new int[];
        ages = new int[4];

        // Task 3 - here are some statements, uncomment any that you think WOULD compile.
        
        // These are all invalid because no dimension initialiser can be supplied 
        // if there is a element initialiser
        //String[] names1 = new String[3] { "", "", "" };
        //String[] names2 = new String[3] { "Sue", "Graham", "Zach" };
        //String[] names3 = new String[3] { "Sue", "Graham" };
        
        
        String[] names4 = { };
        String[] names5 = { "Dave Dee", "Dozy", "Beaky", "Mick", "Titch" };
        // invalid because of mixed types in the element initialiser
        //String[] names6 = { "Zach", "Zoe", 'Z' };
        
        int[] values = {names4.length, names4.length + names5.length };
        double[] dubs = {12, 34, 56, 5.78};
        int[] pets = new int[dubs.length];

        // Task 4 - uncomment any of the following statements that you think would compile
        // after you have tried this you might like to view an answer/comment at very bottom of file
        int[] numbers = { 3, 6, 8, 12 };
        //System.out.println(numbers[3]);
        //System.out.println(numbers[4]);
        //System.out.println(numbers[-56]); 
        //System.out.println(numbers[numbers.Length]);
        //System.out.println(numbers[numbers.Length - 1]);
        //System.out.println(numbers[numbers.Length] - 1);
        //System.out.println(numbers);
        

        // Task 5 - one of the following loops makes sense but which one?
        int[] numSiblings = { 0, 2, 4, 3, 1 };
        //for (int i = 0; i <= numSiblings.Length; i++) { System.out.println(numSiblings[i]); }
        //for (int i = 0; i < numSiblings.Length; i++) { System.out.println(numSiblings[i]); }
        //for (int i = 0; i == numSiblings.Length; i++) { System.out.println(numSiblings[i]); }
    }     

    private static void practicingForEachLoops()
    {
        System.out.println("\n\n** Practicing ForEach Loops **");

        String[] names = { "Peter", "Pieter", "Piotr", "Pedro" };
        int[] ages = { 23, 4, 12, 78 };
        double[] salaries = {23000, 12000, 48034.45, 0, 6789 };

        // ONLY TASK
        // Display the contents of these 3 arrays (separately) by using 3 foreach loops
        for (String name : names) { System.out.println(name); }
        for (int age : ages) { System.out.println(age); }
        for (double salary : salaries) { System.out.println(salary); }
       
    }

    private static void indexingIntoAnArray()
    {
        System.out.println("\n\n** Indexing into an array **");
        // Task 1
        int[] ages = { 20, 40, 35, 28 };
        // write a line of code to display the penultimate entry in this array (the 35)
        System.out.println(ages[2]);
        // better - doesn't depend on knowing the size of the array 
        System.out.println(ages[ages.length-2]);
        
        // now give the variable on the next line a value 
        // and use it to index into the array to 'pick up' and display the 
        // element whose value is 40
        int theOneIWantPlease = 1;
        System.out.println(ages[theOneIWantPlease]);


        // Task 2
        String[] names = { "Tiger", "Teresa", "Steve" };
        String[] thingsTheyWouldLike = { "to hear Jackie in concert",
                                          "a deal with Europe",
                                          "another major championship" };
        // write a simple FOR loop to produce the following output
        
        // "Tiger would like another major championship"
        // "Teresa would like a deal with Europe"
        // "Steve would like to hear Jackie in concert"
        for (int i = 0, j = names.length - 1; i < names.length; i++,j--)
        {
            System.out.printf("%s would like %s", names[i], thingsTheyWouldLike[j]);
        }


    }

    private static void passingAnArraytoAmethod()
    {
        // Simply do whatever is necessary to compile a call to the method below this one
        int[] values = { 3, 4 };
        needAnArray(values); 
    }
    private static void needAnArray(int[] ages)
    {
        System.out.println("Here i am doing something with those ages you passed me");
    }
    // Answers - 
    // BasicArrayProcessing
    //   Task 4 - all will compile, numbers[-56] will give a warning
    //          - the 2nd, 3rd, 4th and 6th displays will give ArrayIndexOutOfBounds at runtime
    //          - the final display is a common mistake it will say System.Int32[] (its type!)
}
