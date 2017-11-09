package Starter.Volume;

public class Volume {
	// fields to hold the class' data
	private int gallons;
	private int pints;
	private boolean validVolume;

	public int getGallons() {
		return this.gallons;
	}

	public int getPints() {
		return this.pints;
	}

	public boolean getValidVolume() {
		return this.validVolume;
	}

	// return true if parameters represent a valid volume
	public boolean validate(int gallons, int pints) {
//		TODO Make this method static?
		if(gallons >= 0 && pints >= 0 && pints < 8)
			return this.validVolume = true;

		return this.validVolume = false;
	}

	// returns the current volume formatted as a String
	public String getCurrentVolume() {
		if(this.validVolume)
			return String.format("%d gallons %d pints", this.gallons, this.pints);

		return "";
	}

	// Constructor to create a volume
	public Volume(int gallons, int pints) {
//		TODO Move constructor methods to the top of the class
		this.validVolume = validate(gallons, pints);

		this.gallons = gallons;
		this.pints = pints;
	}

	// Add parameters representing gallons and pints to the
	// encapsulated data
	public void addVolume(int gallons2, int pints2) {
//		TODO Use better variable names
		if(this.validVolume) {


			validate(this.gallons, this.pints);
		}
	}

	// Subtract parameters representing gallons and pints from the
	// encapsulated data
	public void subtractVolume(int gallons2, int pints2) {

	}

	private int convertToPints(int gallons, int pints) {
		return 0;
	}
}
