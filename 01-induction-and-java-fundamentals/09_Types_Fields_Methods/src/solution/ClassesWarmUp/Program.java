package solution.ClassesWarmUp;


public class Program {

	public static void main(String[] args) {
        // Section 1 - CAR
        // Declare 2 variables of type Car call them 'c1' and 'c2'

		Car c1, c2;
        c1 = new Car("Ford");
        c2 = new Car("Audi",4);
        // Just display on the console the model of each car 
        System.out.println(c1.getModel());
        System.out.println(c2.getModel());




        // Section 2 - PERSON
        // A variable of type Person
        Person p1;
        p1 = new Person("Fred", 34);

        // Display the persons details 
        System.out.println(p1.getDetails());





        // Section 3 - COURSE
        // A variable of type course ,initialise it on this line
        Course course = new Course("Java Block 1", "Tom T", 10); 
        // Display the course's details
        System.out.println(course.getDetails());




        // Section 4 - static vs instance
        System.out.println(Car.getDVLALocation());
        System.out.println(Person.getStatePensionAge());
        System.out.println(p1.yearsToRetirement());


	}

}
