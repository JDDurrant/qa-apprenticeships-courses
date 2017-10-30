package starter;

public class PD {
    private static Boolean carOwner;
    private static char gender;  // IMPORTANT - assume only two values 'M' and 'F' are ever allowed in this field
    private static int  age;     // Validation does not allow any negative values here!
    
    // NOTE - This can easily be invoked from Main by typing pd<dot>s(
    public static void set(Boolean carOwner, char gender, int age)
    {
        if ((gender != 'M' && gender != 'F') || age < 0)
        {
            System.out.printf("*** INVALID DATA %b:'%s':%d***", carOwner, gender, age);
            System.exit(0);
        }
        PD.carOwner = carOwner;
        PD.gender = gender;
        PD.age = age;
        // Display the new state to help when running tests
        System.out.printf("\nState is now: %b : '%s' : %d\n",carOwner,gender,age);
        
    }  

    // first 3 methods to be implemented
    public static Boolean IsCarOwner()
    {
        return false;
    }
    public static Boolean IsMale()
    {
        return false;
    }
    public static Boolean IsTeenager()
    {
        return false;
    }
    // next 2 to be implemented
    public static Boolean IsFemale()
    {
        return false;
    }
    public static Boolean IsNotTeenager()
    {
        return false;
    }
    // remaining methods to be implemented
    public static Boolean IsCarOwnerButNotTeenager()
    {
        return false;
    }
    public static Boolean IsMaleOrAge15()
    {
        return false;
    }
    public static Boolean IsFemaleCarOwnerOrNotATeenager()
    {
        return false; 
    }
    public static Boolean IsCarOwnerAndEitherFemaleOrNoLongerInTheirTwenties()
    {
        return false;
    }

    public static String AgeDescription()
    {
        // this method must return one of these 3 values - "Pre-teen", "Teenager" or "Old" !!
        // you work it out
        return "Wibble";
    }

}
