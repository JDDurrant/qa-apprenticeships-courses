package com.jackdurrant.house;

import com.jackdurrant.io.Prompt;

public class Location {

	String country;
	String city;

	public Location(String country, String city) {

		setCountry(country);
		setCity(city);
	}

	public static Location generateLocation() {

		String country = Prompt.fieldString("Country");
		String city = Prompt.fieldString("City");

		return new Location(country, city);
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
