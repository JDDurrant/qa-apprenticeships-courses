package com.jackdurrant.quiz;

import java.io.IOException;
import java.util.ArrayList;

import com.jackdurrant.house.Location;
import com.jackdurrant.io.*;

public class Quiz {

	ArrayList<Location> locations;
	int stat, total;

	public Quiz(ArrayList<Location> locations) {

		this.locations = locations;
		this.stat = 0;
		this.total = locations.size();
	}

	public void conduct() {

		for(Location location : this.locations) {
			this.ask(location);
		}
	}

	public void ask(Location location) {

		String question = String.format("What's the capital of %s?", location.getCountry());
		String answer = Prompt.getString(question);

		if(answer.equalsIgnoreCase(location.getCity())) this.stat++;
	}

	public void evaluate() {

		String message = String.format("You scored %d out of %d. Would you like to try again?", this.stat, this.total);
		String tryAgain = Prompt.getString(message);

		if(tryAgain.equalsIgnoreCase("yes")) this.restart();
	}

	public void reset() {
		this.stat = 0;
	}

	public void restart() {
		this.reset();
		this.conduct();
		this.evaluate();
	}

	public static ArrayList<Location> parseQuiz() throws IOException {

		ArrayList<Location> locations = new ArrayList<>();

		String quiz = FileHandler.readFile("C:\\quiz.txt");
		String[] lines = quiz.split("\n");

		for(String line : lines) {
			String[] split = line.split(":");

			Location location = new Location(split[0], split[1]);
			locations.add(location);
		}

		return locations;
	}
}
