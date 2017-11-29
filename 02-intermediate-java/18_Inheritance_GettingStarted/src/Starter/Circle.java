package Starter;

public class Circle extends Shape {

	private double radius;

	public void printAttributes(String title) {
		super.printAttributes(title);

		System.out.println();
 		System.out.printf("Radius:        %5.2f\n", this.getRadius());
 		System.out.printf("Diameter:      %5.2f\n", this.getDiameter());
 		System.out.printf("Circumference: %5.2f\n", this.getCircumference());
 		System.out.printf("Area:          %5.2f\n", this.getArea());
	}

	public double getRadius() {
		return radius;
	}

	public double getDiameter() {
		return 2 * radius;
	}

	public double getCircumference() {
		return 2 * Math.PI * radius;
	}

	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	public void setRadius(double radius) {
		if (radius >= 0) {
			this.radius = radius;
		}
	}
}
