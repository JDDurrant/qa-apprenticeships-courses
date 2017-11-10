package Starter.Volume;

public class Volume {
	// fields to hold the class' data
	private int gallons;
	private int pints;
	private boolean validVolume;

	// Constructor to create a volume
	public Volume(int gallons, int pints) {

		this.validVolume = validate(gallons, pints);

		this.gallons = gallons;
		this.pints = pints;
	}

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

	// Add parameters representing gallons and pints to the
	// encapsulated data
	public void addVolume(int addedGallons, int addedPints) {

		if(this.validVolume) {
			if(!validate(addedGallons, addedPints)) {
				this.validVolume = false;
				return;
			}

			int totalGallons = this.gallons + addedGallons;
			int totalPints = this.pints + addedPints;

			while(totalPints >= 8) {
				totalGallons++;
				totalPints -= 8;
			}

			this.gallons = totalGallons;
			this.pints = totalPints;

			validate(this.gallons, this.pints);
		}
	}

	// Subtract parameters representing gallons and pints from the
	// encapsulated data
	public void subtractVolume(int subtractedGallons, int subtractedPints) {

		if(this.validVolume) {
			if(!validate(subtractedGallons, subtractedPints)) {
				this.validVolume = false;
				return;
			}

			int totalGallons = this.gallons - subtractedGallons;
			int totalPints = this.pints - subtractedPints;

			while(totalPints < 0) {
				totalGallons--;
				totalPints += 8;
			}

			this.gallons = totalGallons;
			this.pints = totalPints;

			validate(this.gallons, this.pints);
		}
	}

	private int convertToPints(int gallons, int pints) {
		return 0;
	}
}
