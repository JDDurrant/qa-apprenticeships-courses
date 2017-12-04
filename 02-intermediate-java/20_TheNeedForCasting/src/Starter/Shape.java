package Starter;

import java.awt.Color;
import java.awt.Point;

public class Shape {

	private Color colour;
	private Point position;

	public String strPosition() {
		return String.format("%d, %d", position.x, position.y);
	}

    public Point getPosition() {
		return position;
	}
	public void setPosition(Point position) {
		this.position = position;
	}

	public void setPosition(int x, int y) {
		this.position = new Point(x, y);
	}

	public String strColour() {
		return String.format("#%02x%02x%02x", colour.getRed(), colour.getGreen(), colour.getBlue());
	}

	public Color getColour() {
      return colour;

    }
	public void setColour(Color colour) {
		this.colour = colour;
	}

    public void printCharacteristics() {
//    	System.out.println();
    	System.out.printf("%s Characteristics\n", this.getClass().getSimpleName());
        System.out.printf("-----------------------\n");
        System.out.printf("Colour:         %s\n", strColour());
        System.out.printf("Position:          %s\n", strPosition());
        padding("Shape");
    }

    protected void padding(String className) {
    	if(this.getClass().getSimpleName().equals(className)) {
    		System.out.println();
    	}
    }
  }
