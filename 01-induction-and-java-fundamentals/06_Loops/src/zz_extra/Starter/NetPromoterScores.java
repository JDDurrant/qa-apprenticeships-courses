package zz_extra.Starter;

import java.util.InputMismatchException;

public class NetPromoterScores {

	public static void main(String[] args) {

		int[] respondents = new int[11];
		int promoters = 0;
		int passives = 0;
		int detractors = 0;

		for(int i = 0; i < respondents.length; i++) {
			try {
				respondents[i] = Prompt.getInteger("How likely are you to recommend our product to your friends and colleagues?");
			} catch (Exception e) {
				System.out.println("You must enter a number between 1 and 10.");
//				respondents[i] = Prompt.getInteger("How likely are you to recommend us to a friend?");
				break;
			}
		}

		for(int score : respondents) {
			if(score < 6) detractors++;
			if(score >= 7 && score < 9) passives++;
			if(score >= 9) promoters++;
		}
		System.out.println("Net Promoter Score: " + (promoters - detractors) / respondents.length * 100);
	} // main(String[] args)
}
