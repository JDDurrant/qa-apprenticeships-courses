package solution.ClassesWarmUp;

public class Car {
    // author a constructor that receives a model and stores it
	 private String model;
     private int numdoors; 
     public Car(String model, int numdoors)
     {
         this.model = model;
         this.numdoors = numdoors;
     }
     // overloaded constructor
     public Car(String model) {
    	 this(model, 5);
     }
    

     public String getModel()
     {
         return model;
     }
     public static String getDVLALocation()
     {
         return "Swansea";
     }
}
