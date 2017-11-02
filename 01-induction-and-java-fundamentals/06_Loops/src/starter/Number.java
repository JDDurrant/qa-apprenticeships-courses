package starter;

public class Number {

	public static void main(String[] args) {

		long result = 1, max = 9999999999L;

		System.out.println("Exp.\tResult");

		for (int i = 1; true; i++) {
			result *= 2;

			if(result > max) break;

			printFormatted(i, result);
		}
	}

	private static void printFormatted(int i, long result) {
		System.out.printf("%2d\t%10d\n", i, result);
	}
}
