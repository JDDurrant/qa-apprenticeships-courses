package Starter;

public class StringPractice {

	public static void main(String[] args) {
		// Declare and create a String called name with the exact value 'Fred'
		String fred = "Fred";
		System.out.println(fred);
		// Display its 3rd character - 'e'
		System.out.println(fred.substring(2, 3));
		System.out.println(fred.charAt(2));

		// In lower case
		System.out.println(fred.toLowerCase());

		// In upper case
		System.out.println(fred.toUpperCase());

		// Iterate over it
		for (char letter : fred.toCharArray()) {
			System.out.printf("%s\t", letter);
		}

		System.out.println();

		// startsWith
		System.out.println(fred.startsWith("F"));

		// endsWith
		System.out.println(fred.endsWith("d"));

		// indexOf - success
		System.out.println(fred.indexOf("e"));

		// indexOf - fail
		System.out.println(fred.indexOf("a"));

		// concatenation
		String fullName = fred + " Weasley";

		// Stringbuilder
		StringBuilder sb = new StringBuilder("Bruce Springsteen ");

		sb.append("is the artist ever");

		int adjIndex = sb.indexOf("artist");

		sb.insert(adjIndex, "most obscure ");

		System.out.println(sb.toString().indexOf("artist"));

		sb.replace(38, 44, "guiatrist");

		System.out.println(sb.toString());


	}

}
