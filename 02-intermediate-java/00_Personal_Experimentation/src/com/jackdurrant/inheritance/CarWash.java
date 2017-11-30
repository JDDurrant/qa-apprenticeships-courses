package com.jackdurrant.inheritance;

public class CarWash {

	private static String[] adjectives = { "nice", "awesome", "rad"};
	private static int i = 0;

	public static void clean(Car c) {
		c.setClean();
		System.out.println(c.isClean());
	}

	public static void compliment(Car c) {
		String message = String.format("That's a(n) %s %s.", adjectives[i], c.getMake());

		i++;
		if(i >= adjectives.length) i = 0;

		System.out.println(message);
	}
}
