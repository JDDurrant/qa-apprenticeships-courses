package Starter.Employees;

/**
 * Class ********** Base Class ******** Fields ************************ Methods ***********************************************
 * Employee			Object				String name,					String getName(), void setName(String name),
 * 										String jobTitle,				String getJobTitle, void setJobTitle(String jobTitle)
 * 										int id,							int getId(), void setId(int id), void generateId(),
 * 										static int idCount				void showInfo()
 *
 * SkilledEmployee	Employee			ArrayList<String> skills
 *
 * TechnicalAuthor	SkilledEmployee
 *
 * Draughtsman		SkilledEmployee
 *
 * SecurityGuard	SkilledEmployee
 *
 * Manager			Employee			ArrayList<Employee> employees
 *
@author Jack Durrant */

public class Program {

	public static void main(String[] args) {

		Manager mgr = new Manager("Sue Dunlop", "Boss");
		TechnicalAuthor ta = new TechnicalAuthor("Jim Ronald", "Technical Author");
		SecurityGuard secG = new SecurityGuard("Bobby Gee", "Security Guard");
		Draughtsman drman = new Draughtsman("Fred Morris", "Draughtsman");
		Employee oj = new Employee("Billy Bowen", "Office Junior");

		// assign employees to manager
		mgr.addEmployee(ta);
		mgr.addEmployee(secG);
		mgr.addEmployee(drman);
		mgr.addEmployee(oj);

		// give Tech Auth a single skill
		ta.addSkill("Technical writing");

		// give Security Guard a single skill and
		// set his work preference
		secG.addSkill("Watching TV");
		secG.setPrefersNightWork(true);

		// give DrMan 3 skills
		drman.addSkill("Technical drawing");
		drman.addSkill("CAD/CAM");
		drman.addSkill("Mentoring");

		 mgr.showInfo();
		 ta.showInfo();
		 secG.showInfo();
		 drman.showInfo();
		 oj.showInfo();



		Employee[] employees = { mgr, ta, secG, drman, oj };
		for (Employee e : employees) {
			e.showInfo();
		}

	}

}
