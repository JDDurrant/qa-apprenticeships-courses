package Starter.Main;

import java.util.ArrayList;

import Starter.Vehicle.Vehicle;

public class Program {

	public static void main(String[] args) {
		// Display count
		showCount();

		// Create ArrayList of Vehicle
		ArrayList<Vehicle> vehicles = new ArrayList<>();

		// Loop to create 7 vehicles
		for (int i = 0; i < 7; i++) {
			int speed = i + 10;
			int lane = (i % 3) + 1;

			vehicles.add(new Vehicle(speed, lane));
		}

		// Call accelerate or brake
		for (int i = 0; i < vehicles.size(); i++) {
			Vehicle vehicle = vehicles.get(i);

			if(i % 2 == 0)
				vehicle.accelerate(5);
			else
				vehicle.brake(5);
		}

		// Display details
		displayDetails(vehicles);

		// Display count again
		showCount();
	}

	private static void showCount() {

		int count = Vehicle.getCount();
		System.out.printf("Vehicle Count = %d\n\n", count);
	}

	private static void displayDetails(ArrayList<Vehicle> vehicles) {

		for (int i = 0; i < vehicles.size(); i++) {
			String message = String.format("Vehicle%d\n %s", i + 1, parseDetails(vehicles.get(i)));
			System.out.println(message);
		}
	}

	private static String parseDetails(Vehicle vehicle) {

		String[] details = vehicle.getDetails().split(",");

		int speed = Integer.parseInt(details[0]);
		int lane = Integer.parseInt(details[1]);
		String reg = details[2];

		return String.format("Speed: %d Lane: %d Registration: %s", speed, lane, reg);
	}
}
