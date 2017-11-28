package Recap_HandleTree.starter.tree;

import java.util.ArrayList;

public class Tree {

	private static double maxHeight = 20;

	private String name;
	private double height;
	private double annualGrowth;
	private TreeType type;

	public Tree(String name, double height, double annualGrowth, TreeType type) {

		setName(name);
		setHeight(height);
		setAnnualGrowth(annualGrowth);
		setType(type);
	}

	public int yearsBeforeRemoval() {
		double height = this.getHeight();
		int years = 0;

		while (height < Tree.getMaxHeight()) {
			height += this.getAnnualGrowth();
			years++;
		}

		return years;
	}

	public double debrisCollectionWeight() {

//		double multiplier;
//
//		switch (this.type) {
//		case Deciduous:
//			multiplier = 0.09;
//			break;
//		case Evergreen:
//			multiplier = 0.02;
//		default:
//			multiplier = 0.00;
//			break;
//		}
//
//		return this.getHeight() * multiplier;

		switch (this.type) {
		case Deciduous:
			return this.getHeight() * 0.09;
		case Evergreen:
			return this.getHeight() * 0.02;
		default:
			break;
		}

		return 0;
	}

	public String details() {
		return String.format("Tree: %s - %s. Height: %.1f metres Growth: %.1f metres p.a.",
				getName(), getType(), getHeight(), getAnnualGrowth());
	}

	public static double getMaxHeight() {
		return maxHeight;
	}

	public void grow() {
		this.height += this.getAnnualGrowth();
	}

	public String getName() {
		return name;
	}

	public double getHeight() {
		return height;
	}

	public double getAnnualGrowth() {
		return annualGrowth;
	}

	public TreeType getType() {
		return type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setAnnualGrowth(double annualGrowth) {
		this.annualGrowth = annualGrowth;
	}

	public void setType(TreeType type) {
		this.type = type;
	}
}
