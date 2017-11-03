package starter;

public class Everest {

	public static void main(String[] args) {

		double initialHeight = 8850;
		double finalHeight = 8850;
		double growthRate = 0.000006893;
		int yearCount = 1000;

		for(int i = 0; i < yearCount; i++) {
			finalHeight += initialHeight * growthRate;
		}

		System.out.printf("Mountain Everest height: %f", finalHeight);
	}
}
