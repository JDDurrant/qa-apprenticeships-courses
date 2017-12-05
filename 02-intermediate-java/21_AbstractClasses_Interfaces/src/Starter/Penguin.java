package Starter;

public class Penguin extends Bird {

	public Penguin(String name) {
		super(name);
	}

	@Override
	public String describeTaste() {
		return String.format("%s: Chocolaty", getName());
	}

	@Override
	public String isMainCourseDish() {
		return String.format("%s: False", getName());
	}

}
