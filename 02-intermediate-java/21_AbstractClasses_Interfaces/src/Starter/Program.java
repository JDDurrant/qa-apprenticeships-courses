package Starter;

public class Program {

	public static void main(String[] args) {

		Object[] things = {
				new Penguin("Pingu"),
				new Duck("Donald"),
				new Fish("Freddie")
		};

		System.out.println("### These are Consumable ###");

		// loop / test / downcast ref's and call
		for (Object animal : things) {
			if (animal instanceof Consumable) {
				Consumable food = (Consumable) animal;
				System.out.printf("%s\t%s\n", food.describeTaste(), food.isMainCourseDish());
			}
		}

		System.out.println("\n### These are Insurable ###");

		for (Object animal : things) {
			if (animal instanceof Insurable) {
				Insurable ii = (Insurable) animal;
				System.out.printf("%s,\t%s\n", ii.getPremium(), ii.expires());
			}
		}
		System.out.println();
	}
}
