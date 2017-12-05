package Starter;

public abstract class Bird implements Consumable {

	private String name;

	public String getName() {
		return name;
	}

	public Bird(String name) {
		this.name = name;
	}

	@Override
	public String describeTaste() {
		return String.format("%s: Tastes delicate", getName());
	}

	@Override
	public String isMainCourseDish() {
		return String.format("%s: False", getName());
	}


}
