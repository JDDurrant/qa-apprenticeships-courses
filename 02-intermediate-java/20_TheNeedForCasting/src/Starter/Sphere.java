package Starter;

class Sphere extends Circle {

	@Override
	public double getArea() {
		return 4 * super.getArea();
	}

	public double getVolume() {
		return 4 / 3 * Math.PI * Math.pow(getRadius(), 3);
	}

	public void printCharacteristics() {
		super.printCharacteristics();
		System.out.printf("Volume:        %7.2f\n", getVolume());
        padding("Sphere");
	}
}
