package Starter.Cars;

public class RacingCar extends Car {
    private String driver ;

    @Override
    public String getModel() {
    	return String.format("Formula 1 %s", super.getModel());
    }

    @Override
	public void accelerate(int seconds) {

    	int increase = 5 * seconds * getTurboFactor();
		setSpeed(getSpeed() + increase);
	}

	public String getDriver() {
		return driver;
	}
	private void setDriver(String driver) {
		this.driver = driver;
	}

	private int turboFactor ;
	public int getTurboFactor() {
		return turboFactor;
	}
	private void setTurboFactor(int turboFactor) {
		this.turboFactor = turboFactor;
	}


	public RacingCar(String model, String driver, int turboFactor)
    {
		super(model);
        setDriver(driver);
        setTurboFactor(turboFactor);
    }

}
