package zz_extra.Starter;

public class NetPromoterScores {

	public static void main(String[] args) {

		int[] respondents = new int[11];
		double promoters = 0;
		double detractors = 0;

		for(int i = 0; i < respondents.length; i++) {
			try {
				respondents[i] = Prompt.getInteger("How likely are you to recommend our product to your friends and colleagues?");
			} catch (Exception e) {
				System.out.println("You must enter a number between 1 and 10.");
				return;
			}
		}

		for(int score : respondents) {
			if(score < 6) detractors++;
			if(score >= 9) promoters++;
		}

		double nps = ((promoters - detractors) / respondents.length) * 100;

		System.out.printf("Net Promoter Score: %.1f", nps);
	} // main(String[] args)
}
