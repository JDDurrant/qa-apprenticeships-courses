package Starter.FactoryStuff;

public class RegistrationPlateFactory {
	private static String[] regPlates
	    = { "MRB1G", "RU16", "TOYS4US", "HNZ57","PUT3", "JB007" };

	private static int nextAvailablePlate = 0;

	public static RegistrationPlate produceNextRegistrationPlate() {

		return new RegistrationPlate(nextReg());
	}

	private static String nextReg() {

		String reg;

		if(nextAvailablePlate < regPlates.length)
			reg = regPlates[nextAvailablePlate];
		else
			reg = "XXXX";

		nextAvailablePlate++;
		return reg;
	}
}
