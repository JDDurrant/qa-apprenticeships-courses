package com.jackdurrant.inheritance;

public class Car {

	private String make;
	private boolean clean = false;

	public Car(String make) {
		this.make = make;
	}

	public Car() {}

	public String getMake() {
		return make;
	}

	public void setClean() {
		this.clean = true;
	}

	public String isClean() {
		if(this.clean)
			return "Clean as a whistle!";
		else
			return "Filthy as a ditch!";
	}
}
