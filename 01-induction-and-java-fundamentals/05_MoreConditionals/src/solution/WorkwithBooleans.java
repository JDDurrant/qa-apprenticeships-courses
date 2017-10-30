package solution;

public class WorkwithBooleans {

	public static void main(String[] args) {
        
        // SetData receives and stores CarOwner(Boolean), Gender(char), Age(int) 
        PD.Set(true, 'M', 18 );
        System.out.printf("\tIsCarOwner - %b\n", PD.IsCarOwner());
        System.out.printf("\tMale       - %b\n", PD.IsMale());
        System.out.printf("\tIsTeenager - %b\n", PD.IsTeenager());

        PD.Set(false, 'M', 18);
        System.out.printf("\tIsCarOwner - %b\n", PD.IsCarOwner());
        System.out.printf("\tMale       - %b\n", PD.IsMale());
        System.out.printf("\tIsTeenager - %b\n", PD.IsTeenager());

        PD.Set(false, 'F', 18);
        System.out.printf("\tIsCarOwner - %b\n", PD.IsCarOwner());
        System.out.printf("\tMale       - %b\n", PD.IsMale());
        System.out.printf("\tIsTeenager - %b\n", PD.IsTeenager());

        PD.Set(false, 'F', 20);
        System.out.printf("\tIsCarOwner - %b\n", PD.IsCarOwner());
        System.out.printf("\tMale       - %b\n", PD.IsMale());
        System.out.printf("\tIsTeenager - %b\n", PD.IsTeenager());

        PD.Set(true, 'M', 12);
        //PD.Set(true, 'M', 13);
        System.out.printf("\tCar owner but not teenager - %b\n", PD.IsCarOwnerButNotTeenager());


        PD.Set(true, 'F', 15);
        //PD.Set(true, 'M', 14);
        System.out.printf("\tIs male OR 15 - %b\n", PD.IsMaleOrAge15());

        PD.Set(true, 'M', 7);
        //PD.Set(true, 'F', 7);
        //PD.Set(true, 'M', 14);
        System.out.printf("\tFemale Car owner or not a teenager - %b\n",PD.IsFemaleCarOwnerOrNotATeenager());

        PD.Set(true, 'M', 30);
        //PD.Set(true, 'F', 29);
        //PD.Set(false, 'F', 30);
        System.out.printf("\tCar owner and either a girl or anyone who has reached 30 - %b\n", PD.IsCarOwnerAndEitherFemaleOrNoLongerInTheirTwenties());

        PD.Set(true, 'M', 12);
        //PD.Set(true, 'M', 19);
        //PD.Set(true, 'M', 20);
        System.out.printf("\tAge description is '%b\n'", PD.AgeDescription());
    }

}
