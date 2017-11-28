package Starter.Vehicle;

import Starter.FactoryStuff.RegistrationPlate;
import Starter.FactoryStuff.RegistrationPlateFactory;

public class Vehicle {

	private static int count = 0;
	private int speed, lane;
	private RegistrationPlate registration;

	public Vehicle(int speed, int lane) {
		this.speed = speed;
		this.lane = lane;
		this.registration = RegistrationPlateFactory.produceNextRegistrationPlate();

		Vehicle.count++;
	}

	public static int getCount() {
		return Vehicle.count;
	}

	public void accelerate(int amt) {
		speed += amt;
		if (speed > 70) {
			speed = 70;
		}
	}

	public void brake(int amt) {
		speed -= amt;
		if (speed < 0) {
			speed = 0;
		}
	}

	public String getDetails() {
		return String.format("%d,%d,%s", speed, lane, registration.getRegistrationNo());
	}
}
