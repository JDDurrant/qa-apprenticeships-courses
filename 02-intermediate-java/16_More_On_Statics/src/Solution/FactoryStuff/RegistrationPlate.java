package Solution.FactoryStuff;

public class RegistrationPlate {
    public final int width = 20;
    public final int height = 8;
    private String registrationNo;

    RegistrationPlate(String registrationNo) {
        this.registrationNo = registrationNo;
    }

	public String getRegistrationNo() {
		return registrationNo;
	}

}
