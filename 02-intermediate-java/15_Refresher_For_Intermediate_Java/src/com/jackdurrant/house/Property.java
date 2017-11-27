package com.jackdurrant.house;

public class Property {

	private String location;
	private String type;
	private int roomCount;

	public Property(String location, String type, int roomCount) {

		this.setLocation(location);
		this.setType(type);
		this.setRoomCount(roomCount);
	}

	public Property() {

		this.setLocation("London");
		this.setType("Flat");
		this.setRoomCount(2);
	}

	public String toString() {

		return String.format("You have a %d bedroom %s in %s.",
				this.getRoomCount(), this.getType().toLowerCase(), this.getLocation());
	}

	public String getLocation() {
		return location;
	}

	public String getType() {
		return type;
	}

	public int getRoomCount() {
		return roomCount;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setRoomCount(int roomCount) {
		this.roomCount = roomCount;
	}
}
