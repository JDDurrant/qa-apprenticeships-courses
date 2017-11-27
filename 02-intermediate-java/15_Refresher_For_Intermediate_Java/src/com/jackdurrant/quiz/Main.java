package com.jackdurrant.quiz;

import java.io.IOException;
import java.util.ArrayList;

import com.jackdurrant.house.Location;

public class Main {

	public static void main(String[] args) throws IOException {

		ArrayList<Location> locations = Quiz.parseQuiz();
		Quiz quiz = new Quiz(locations);

		quiz.conduct();
		quiz.evaluate();
	}
}
