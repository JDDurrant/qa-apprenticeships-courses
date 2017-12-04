package Starter;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {
		 Shape blob = new Shape();
         blob.setColour(Color.GREEN);
         blob.setPosition(1, 3);

         Circle hoop = new Circle();
         hoop.setColour(Color.RED);
         hoop.setPosition(3, 4);
         hoop.setRadius(25.55);

         Sphere ball = new Sphere();
         ball.setColour(Color.BLUE);
         ball.setPosition(6, 6);
         ball.setRadius(25.55);

         ArrayList<Shape> shapes = new ArrayList<>();

         shapes.add(blob);
         shapes.add(hoop);
         shapes.add(ball);

         for(Shape shape : shapes) {
        	 shape.printCharacteristics();
         }

         for(Shape shape : shapes) {
        	 printArea(shape);
         }
	}

	private static void printArea(Shape shape) {

		String className =  shape.getClass().getSimpleName();

		if(shape instanceof Circle) {
			double area = ((Circle) shape).getArea();
			System.out.printf("%s Area: %.2f\n", className, area);
		} else {
			System.out.printf("%s has no procedure for calculating its area.\n", className);
		}
	}
}
