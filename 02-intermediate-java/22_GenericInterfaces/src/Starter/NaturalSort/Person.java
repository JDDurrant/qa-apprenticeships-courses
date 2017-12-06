package Starter.NaturalSort;

public class Person implements Comparable<Person> {

    private int age;
	private String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
	public int compareTo(Person other) {
		return this.getAge() - other.getAge();
	}

    @Override
    public String toString() {
        return String.format("%10s\t%d", getName(), getAge());
    }

    public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}
}
