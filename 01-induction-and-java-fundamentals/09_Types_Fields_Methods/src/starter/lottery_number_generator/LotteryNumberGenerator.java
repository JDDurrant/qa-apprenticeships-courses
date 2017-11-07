package starter.lottery_number_generator;

import java.util.Random;

public class LotteryNumberGenerator {

	private static Random random = new Random();

	public static int[] generateNumbers() {

		int[] numbers = new int[6];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = generateNumber();
		}

		return numbers;
	}

	public static int generateNumber() {

		return random.nextInt(48) + 1;
	}
}
