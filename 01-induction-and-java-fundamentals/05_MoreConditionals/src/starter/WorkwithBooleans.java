package starter;

public class WorkwithBooleans {

	public static void main(String[] args) {
        // SetData receives and stores CarOwner(Boolean), Gender(char), Age(int) 
        PD.set(true, 'M', 18 );
        System.out.printf("IsCarOwner - %b\n", PD.IsCarOwner());
        System.out.printf("Male       - %b\n", PD.IsMale());
        System.out.printf("IsTeenager - %b\n", PD.IsTeenager());

        PD.set(false, 'M', 18);
        System.out.printf("IsCarOwner - %b\n", PD.IsCarOwner());
        System.out.printf("Male       - %b\n", PD.IsMale());
        System.out.printf("IsTeenager - %b\n", PD.IsTeenager());

        
        //System.out.printf("Car owner but not teenager - %b\n", PD.IsCarOwnerButNotTeenager());


        //System.out.printf("Is male OR 15 - %b\n", PD.IsMaleOrAge15());

        
        //System.out.printf("Female Car owner or not a teenager - %b\n", PD.IsFemaleCarOwnerOrNotATeenager());

        
        //System.out.printf("Car owner and either a girl or anyone who has reached 30 - %b\n", PD.IsCarOwnerAndEitherFemaleOrNoLongerInTheirTwenties());

        
        //System.out.printf("Age description is '%b\n'", PD.AgeDescription());
    }
}
