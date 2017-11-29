package Starter;

import java.awt.Color;
import java.awt.Point;

public class Shape {

	private Color colour;
	private Point position;

	public void printAttributes(String title) {

		System.out.printf("\n%s attributes\n", title);
 		System.out.printf("----------------------\n");
 		System.out.printf("Colour:        %s\n", this.strColour());
 		System.out.printf("Position:      %s\n", this.strPosition());
	}

	public String strColour() {
		return String.format("#%02x%02x%02x", colour.getRed(), colour.getGreen(), colour.getBlue());
	}
	public String strPosition() {
		return String.format("x: %d, y: %d", position.x, position.y);
	}
	public Color getColour() {
		return colour;
	}
	public Point getPosition() {
		return position;
	}
	public void setColour(int colour) {
		this.colour = new Color(colour);
	}
	public void setPosition(int x, int y) {
		this.position = new Point(x, y);
	}
}
