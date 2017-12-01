package Starter.Employees;

public class SecurityGuard extends SkilledWorker
{
	private boolean prefersNightWork = false;

	public SecurityGuard(String name, String jobTitle) {
		super(name, jobTitle);
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.printf("Preferred hours: %s", getPrefersNightWork());
	}

	public String getPrefersNightWork() {
		return this.prefersNightWork ? "Night" : "Day";
	}

	public void setPrefersNightWork(boolean prefersNightWork) {
		this.prefersNightWork = prefersNightWork;
	}
}
