package Starter;

public class Sphere extends Circle {

	public void printAttributes(String title) {
		super.printAttributes(title);

		System.out.printf("Volume:        %5.2f\n", this.getVolume());
	}

	public double getVolume() {
		return (4/3) * Math.PI * Math.pow(this.getRadius(), 3);
	}
}
