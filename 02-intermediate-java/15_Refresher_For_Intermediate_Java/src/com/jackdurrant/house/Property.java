package com.jackdurrant.house;

public class Property {

	private Location location;
	private String type;
	private int roomCount;

	public Property(Location location, String type, int roomCount) {

		this.setLocation(location);
		this.setType(type);
		this.setRoomCount(roomCount);
	}

	public Property() {

	}

	public String toString() {

		return String.format("You have a %d bedroom %s in %s.",
				this.getRoomCount(), this.getType().toLowerCase(), this.getLocation().getCity());
	}

	public Location getLocation() {
		return location;
	}

	public String getType() {
		return type;
	}

	public int getRoomCount() {
		return roomCount;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setRoomCount(int roomCount) {
		this.roomCount = roomCount;
	}
}
