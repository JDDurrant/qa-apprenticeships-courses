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
    		m1 = new Money(100),
    		m2 = new Money(99),
    		m3 = new Money(0),
    		m4 = new Money(-1);

    	m1.addPennies(100);
    	m2.addPennies(50);
    	m3.addPennies(0);
    	m4.addPennies(-1);

    	check(m1, "£2.00");
    	check(m2, "£1.49");
    	check(m3, "£0.00");
    	check(m4, "Error");
    }

    private static void testingWhenPoundsAndPence() {

    }

    private static void check(Money money, String expected) {
    	System.out.printf("Expected: %s; Actual: %s\n", expected, money.getCurrentMoney());
    }
  }