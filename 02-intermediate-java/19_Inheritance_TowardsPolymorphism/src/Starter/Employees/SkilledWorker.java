package Starter.Employees;

import java.util.ArrayList;

public class SkilledWorker extends Employee
{
	private ArrayList<String> skills = new ArrayList<>();

	public SkilledWorker(String name, String jobTitle) {
		super(name, jobTitle);
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.printf("%s has the following skills:\n", getName());
		for (String skill : getSkills()) {
			System.out.printf("\t%s\n", skill);
		}
	}

	public void addSkill(String skill) {
		skills.add(skill);
	}

	public ArrayList<String> getSkills() {
		return skills;
	}
}
