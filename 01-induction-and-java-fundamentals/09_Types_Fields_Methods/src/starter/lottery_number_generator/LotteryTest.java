package starter.lottery_number_generator;

public class LotteryTest {

	public static void main(String[] args) {

		System.out.println("Play this combination - it'll make you rich!");

		int[] numbers = LotteryNumberGenerator.generateNumbers();
		for(int i : numbers) {
			System.out.printf("%d ", i);
		}
	}
}
