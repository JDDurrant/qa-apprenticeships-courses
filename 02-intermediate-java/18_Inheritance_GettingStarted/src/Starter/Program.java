package Starter;

public class Program {

	public static void main(String[] args) {

        Shape blob = new Shape();

        blob.setColour(0x00ff00);
        blob.setPosition(1, 3);
 		blob.printAttributes("Blob");

 		Circle hoop = new Circle();

 		hoop.setColour(0x800000);
 		hoop.setPosition(3, 2);
 		hoop.setRadius(2.5);
 		hoop.printAttributes("Hoop");

 		Sphere ball = new Sphere();

 		ball.setColour(0x00ffff);
 		ball.setPosition(5, 0);
 		ball.setRadius(5);
 		ball.printAttributes("Ball");

 		System.out.println();

	}

}
