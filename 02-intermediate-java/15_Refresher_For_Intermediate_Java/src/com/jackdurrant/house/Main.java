package com.jackdurrant.house;

import java.util.ArrayList;

//import javax.swing.JOptionPane;

public class Main {

//	private ArrayList<Property> properties = new ArrayList<>();

	public static void main(String[] args) {

//		String location = JOptionPane.showInputDialog(null, "Enter a location");
//		String type = JOptionPane.showInputDialog(null, "Type of house");
//		String roomCountStr = JOptionPane.showInputDialog(null, "Amount of rooms");
//		int roomCount = Integer.parseInt(roomCountStr);
//
//		Property house = new Property(location, type, roomCount);
//
//		String message = String.format("You have a %d bedroom %s in %s.",
//				house.getRoomCount(), house.getType(), house.getLocation());
//
//		System.out.println(message);

		Location brighton = new Location("England", "Brighton");
		Location glasgow = new Location("Scotland", "Glasgow");
		Location london = new Location("England", "London");
		Location sheffield = new Location("England", "Sheffield");

		ArrayList<Property> properties = new ArrayList<>();

		properties.add(new Property(brighton, "Flat", 2));
		properties.add(new Property(brighton, "House", 2));
		properties.add(new Property(glasgow, "Cottage", 2));
		properties.add(new Property(london, "House", 3));
		properties.add(new Property(london, "Studio", 1));
		properties.add(new Property(sheffield, "House", 2));

		ArrayList<Property> propertiesInLondon = findProperties(properties, "London");
		displayProperties(propertiesInLondon);
	}

	public static void addProperty(ArrayList<Property> propertyList, Property property) {
		propertyList.add(property);
	}

	public static void editProperty(Property property, Location location, String type, int roomCount) {
		property = new Property(location, type, roomCount);
	}

	public static ArrayList<Property> findProperties(ArrayList<Property> propertyList, String location) {

		ArrayList<Property> properties = new ArrayList<>();

		for(Property property : propertyList) {
			if(property.getLocation().equals(location)) properties.add(property);
		}

		return properties;
	}

	public static void displayProperties(ArrayList<Property> properties) {

		for (Property property : properties) {
			System.out.println(property.toString());
		}
	}
}
