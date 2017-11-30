package Starter.Employees;

public class Employee {

	private String name;
	private String jobTitle;
	private int id;

	protected static int idCount;


	public Employee(String name, String jobTitle) {

		generateId();

		setName(name);
		setJobTitle(jobTitle);
	}

	public void generateId() {
		setId(idCount += 10);
	}

	public void showInfo() {
		System.out.println("\n**** *****");

		System.out.printf("Name: %s\n", getName());
        System.out.printf("Job Title: %s\n", getJobTitle());
        System.out.printf("Employee ID: %d\n", getId());
	}



	public String getName() {
		return name;
	}



	private void setName(String name) {
		this.name = name;
	}



	public String getJobTitle() {
		return jobTitle;
	}



	private void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}



	public int getId() {
		return id;
	}



	private void setId(int id) {
		this.id = id;
	}
}
