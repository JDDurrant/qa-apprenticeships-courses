package starter.WorkingWithMoney;

class Program {
    public static void main(String[] args) {
      // to be used in Part 1 of money
      testingWhenOnlyPence();



      // to be used in Part 2 after Pounds are introduced as parameters
      //testingWhenPoundsAndPence();
    }

    private static void testingWhenOnlyPence() {
    	Money
    		m1 = new Money(99),
    		m2 = new Money(0),
    		m3 = new Money(-1),
    		m4 = new Money(100);

    	System.out.println("Constructor testing...");
    	System.out.printf("Expected: %s; Actual: %s\n", "£0.99", m1.getCurrentMoney());
    	System.out.printf("Expected: %s; Actual: %s\n", "£0.00", m2.getCurrentMoney());
    	System.out.printf("Expected: %s; Actual: %s\n", "Error", m3.getCurrentMoney());
    	System.out.printf("Expected: %s; Actual: %s\n", "£1.00", m4.getCurrentMoney());

    }

    private static void testingWhenPoundsAndPence() {

    }
  }