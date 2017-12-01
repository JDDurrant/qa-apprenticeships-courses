package Starter.Employees;

import java.util.ArrayList;

public class Manager extends Employee
{
	private ArrayList<Employee> employees = new ArrayList<>();

	public Manager(String name, String jobTitle) {
		super(name, jobTitle);
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.printf("%s has the following employees:\n", getName());
		for (Employee employee : getEmployees()) {
			System.out.printf("\t%s\n", employee.getName());
		}
	}

	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}
}
