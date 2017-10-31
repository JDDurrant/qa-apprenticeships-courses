package starter;

public class WeightConversions {

	static int conversionFactorStonesToPounds = 14;
	static double conversionFactorKgsToLbs = 2.20462;

	public static void main(String[] args)
	{
		System.out.println("Welcome to Weight Conversions.");

		greetUser();
	}

	private static void greetUser() {

		 System.out.println("Please select one of the following options:\n\n"
	        		+ "1. Pounds to Stones and Pounds\n"
	        		+ "2. Kilograms to Stones and Pounds\n"
	        		+ "3. Stones and Pounds to Kilograms\n"
	        		+ "0. Quit\n");

        int conversion = Prompt.fieldInteger("Conversion");

        switch (conversion) {
        	case 1:
        		ConvertInputToStonesPounds();
        		break;
        	case 2:
        		ConvertKgsToStonesPounds();
        		break;
        	case 3:
        		ConvertStonesPoundsToKgs();
        		break;
        	case 0:
        		break;
        }
	}

    private static void ConvertInputToStonesPounds()
    {
    	int poundsTotal = Prompt.getInteger(
    		"Enter the quantity of pounds you wish to convert to stones.");

//    	TODO Refactor
    	int stones = poundsTotal / conversionFactorStonesToPounds;
    	int pounds = poundsTotal % conversionFactorStonesToPounds;

        System.out.printf("%d stones %d pounds\n\n", stones, pounds);

        Prompt.pause("Press enter to continue...");
        greetUser();
    }

    private static void ConvertKgsToStonesPounds()
    {
    	double kgsTotal = Prompt.getDouble(
    		"Enter the quantity of kilograms you wish to convert to stones and pounds.");

    	double poundsTotal = kgsTotal * conversionFactorKgsToLbs;

    	int stones = (int)poundsTotal / conversionFactorStonesToPounds;
    	int pounds = (int)poundsTotal % conversionFactorStonesToPounds;

        System.out.printf("%d stones %d pounds\n\n", stones, pounds);

        Prompt.pause("Press enter to continue...");
        greetUser();
    }

    private static void ConvertStonesPoundsToKgs()
    {
    	System.out.println(
    		"Enter the quantity of stones and pounds you wish to convert to kilograms.");
    	int stones = Prompt.fieldInteger("Stones");
    	int pounds = Prompt.fieldInteger("Pounds");

    	int poundsTotal = pounds + (stones * 14);

    	double kgs = poundsTotal / conversionFactorKgsToLbs;

        System.out.printf("%.1fkg\n\n", kgs);

        Prompt.pause("Press enter to continue...");
        greetUser();
    }
}
