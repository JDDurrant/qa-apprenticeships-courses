package zz_extra.Solution;

public class SimpleArithmeticWithloops {

	public static void main(String[] args) {
		testsOf_Multiply_PositiveValuesOnly();

        testsOf_Divide_PositiveValuesOnly();

        testsOf_Multiply_AfterNegativeValuesCodedFor();

        testsOf_Divide_AfterNegativeValuesCodedFor();

        testsOf_Remainder_AllValues();
        testsOf_power_AllValues();

	}
    static int multiply(int num1, int num2)
    {

        if (num1 == 0 || num2 == 0) return 0;

        // neither parameter is zero
        // declare a Boolean to track whether the total will need negating
        Boolean resultHasCorrectSign = true;
        if (num1 < 0){
            // make it the opposite of what it was!. It started as true.
            // so if a negative parameter is found - toggle it
            resultHasCorrectSign = !resultHasCorrectSign;
            num1 = -num1;
        }
        if (num2 < 0){
            // make it the opposite of what it was!. 
            // so if a negative parameter is found - toggle it
            resultHasCorrectSign = !resultHasCorrectSign;
            num2 = -num2;
        }

        // this must be done after potentially changing the sign
        MakeFirstParameterTheSmallest(num1, num2);

        int total = doRepeatedAddition(num1, num2);
        return (resultHasCorrectSign) ? total : -total;
    }

    static int divide(int num1, int num2)
    {
        if (num1 == 0 || num2 == 0) return 0; // avoid DividebyZeroException if num2 is 0

        // both params are not zero
        // declare a Boolean to track whether the total will need negating
        Boolean resultHasCorrectSign = true;
        if (num1 < 0)
        {
            // make it the opposite of what it was!. It started as true.
            // so if a negative parameter is found - toggle it
            resultHasCorrectSign = !resultHasCorrectSign;
            num1 = -num1;
        }
        if (num2 < 0)
        {
            // make it the opposite of what it was!. 
            // so if a negative parameter is found - toggle it
            resultHasCorrectSign = !resultHasCorrectSign;
            num2 = -num2;
        }


        int count = doRepeatedSubtraction(num1, num2);
        return (resultHasCorrectSign) ? count : -count;
    }

    static int remainder(int num1, int num2)
    {
        // if numbers are 11 & 4 this is 11 - ((11/4) * 4) 
        return num1 - multiply(divide(num1, num2), num2);
    }

    static int power(int num1, int num2)
    {
        if (num2 == 0) return 1;
        if (num1 == 0) return 0;
        if (num2 < 0) return 0; // cannot do negative powers with ints

        return doRepeatedMultiplication(num1, num2);
    }

    // Helper routines used by Multiply & Divide

    static void MakeFirstParameterTheSmallest(int num1, int num2)
    {
        if (num1 > num2)
        {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

    }

    static int doRepeatedAddition(int num1, int num2)
    {
        int total = 0;
        for (int i = 0; i < num1; i++)
        {
            total += num2;
        }
        return total;
    }

    static int doRepeatedSubtraction(int num1, int num2)
    {
        int count = 0;
        while (num1 >= num2)
        {
            num1 -= num2;
            count++;
        }
        return count;
    }

    static int doRepeatedMultiplication(int num1, int num2)
    {
        int result = 1;
        // if 2 * 4 the loop needs to run 3 times only
        // 2..4..8..16
        for (int i = 0; i < num2; i++)
        {
            result = multiply(result, num1);
        }
        return result;
    }


    static void testsOf_Multiply_PositiveValuesOnly()
    {
        System.out.printf("\n*** Start of Multiply Tests (positive values only) ***");
        int result;
        result = multiply(4, 3);
        System.out.printf("\nMultiply 4 by 3");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", 4 * 3);
        System.out.printf("\t\t\t\t\t%s",(result == 12) ? "PASS":"FAIL");
        result = multiply(3, 4);
        System.out.printf("\nMultiply 3 by 4");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", 3 * 4);
        System.out.printf("\t\t\t\t\t%s", (result == 12) ? "PASS" : "FAIL");
        result = multiply(4, 0);
        System.out.printf("\nMultiply 4 by 0");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", 4 * 0);
        System.out.printf("\t\t\t\t\t%s", (result == 0) ? "PASS" : "FAIL");
        result = multiply(0, 3);
        System.out.printf("\nMultiply 0 by 3");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", 0 * 3);
        System.out.printf("\t\t\t\t\t%s", (result == 0) ? "PASS" : "FAIL");

    }
    static void testsOf_Divide_PositiveValuesOnly()
    {
        System.out.printf("\n*** Start of Divide Tests (+ve values only) ***");
        int result;

        result = divide(8, 2);
        System.out.printf("\nDivide 8 by 2");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", 8 / 2);
        System.out.printf("\t\t\t\t\t%s", (result == 4) ? "PASS" : "FAIL");

        result = divide(7, 2);
        System.out.printf("\nDivide 7 by 2");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", 3);
        System.out.printf("\t\t\t\t\t%s", (result == 3) ? "PASS" : "FAIL");

        result = divide(6, 2);
        System.out.printf("\nDivide 6 by 2");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", 6 / 2);
        System.out.printf("\t\t\t\t\t%s", (result == 3) ? "PASS" : "FAIL");

        result = divide(0, 3);
        System.out.printf("\nDivide 0 by 3");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", 0 / 3);
        System.out.printf("\t\t\t\t\t%s", (result == 0) ? "PASS" : "FAIL");

        result = divide(3, 0);
        System.out.printf("\nDivide 3 by 0"); // method should make answer 0 to avoid a DivideByZeroException
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", 0);
        System.out.printf("\t\t\t\t\t%s", (result == 0) ? "PASS" : "FAIL");
    }
    static void testsOf_Multiply_AfterNegativeValuesCodedFor()
    {
        System.out.printf("\n*** Start of Multiply Tests (-ve values now) ***");
        int result;

        result = multiply(-2, 4);
        System.out.printf("\nMultiply -2 by 4");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", -2 * 4);
        System.out.printf("\t\t\t\t\t%s", (result == -8) ? "PASS" : "FAIL");


        result = multiply(2, -4);
        System.out.printf("\nMultiply 2 by -4");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", 2 * -4);
        System.out.printf("\t\t\t\t\t%s", (result == -8) ? "PASS" : "FAIL");

        result = multiply(-2, 0);
        System.out.printf("\nMultiply -2 by 0");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", -2 * 0);
        System.out.printf("\t\t\t\t\t%s", (result == 0) ? "PASS" : "FAIL");

        result = multiply(0, -4);
        System.out.printf("\nMultiply 0 by -4");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", 0 * -4);
        System.out.printf("\t\t\t\t\t%s", (result == 0) ? "PASS" : "FAIL");

        result = multiply(-2, -4);
        System.out.printf("\nMultiply -2 by -4");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", -2 * -4);
        System.out.printf("\t\t\t\t\t%s", (result == 8) ? "PASS" : "FAIL");
    }
    static void testsOf_Divide_AfterNegativeValuesCodedFor()
    {
        System.out.printf("\n*** Start of Divide Tests (-ve values now) ***");
        int result;
        result = divide(-12, 5);
        System.out.printf("\nDivide -12 by 5");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", -12 / 5);
        System.out.printf("\t\t\t\t\t%s", (result == -2) ? "PASS" : "FAIL");

        result = divide(12, -5);
        System.out.printf("\nDivide 12 by -5");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", 12 / -5);
        System.out.printf("\t\t\t\t\t%s", (result == -2) ? "PASS" : "FAIL");

        result = divide(-12, -5);
        System.out.printf("\nDivide -12 by -5");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", -12 / -5);
        System.out.printf("\t\t\t\t\t%s", (result == 2) ? "PASS" : "FAIL");
    }
    static void testsOf_Remainder_AllValues()
    {
        System.out.printf("\n*** Start of Remainder Tests - all values ***");
        int result;

        result = remainder(12, 5);
        System.out.printf("\nRemainder 12 and 5");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", 12 % 5);
        System.out.printf("\t\t\t\t\t%s", (result == 2) ? "PASS" : "FAIL");

        result = remainder(12, 0);
        System.out.printf("\nRemainder 12 and 0");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", 12);
        System.out.printf("\t\t\t\t\t%s", (result == 12) ? "PASS" : "FAIL");


        result = remainder(5, 12);
        System.out.printf("\nRemainder 5 and 12");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", 5 % 12);
        System.out.printf("\t\t\t\t\t%s", (result == 5) ? "PASS" : "FAIL");

        result = remainder(0, 12);
        System.out.printf("\nRemainder 0 and 12");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", 0 % 12);
        System.out.printf("\t\t\t\t\t%s", (result == 0) ? "PASS" : "FAIL");

        result = remainder(5, 5);
        System.out.printf("\nRemainder 5 and 5");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", 5 % 5);
        System.out.printf("\t\t\t\t\t%s", (result == 0) ? "PASS" : "FAIL");

        result = remainder(12, -5);
        System.out.printf("\nRemainder 12 and - 5");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", 12 % -5);
        System.out.printf("\t\t\t\t\t%s", (result == 2) ? "PASS" : "FAIL");

        result = remainder(-12, 5);
        System.out.printf("\nRemainder -12 and 5");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", -12 % 5);
        System.out.printf("\t\t\t\t\t%s", (result == -2) ? "PASS" : "FAIL");

        result = remainder(-12, -5);
        System.out.printf("\nRemainder -12 and -5");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", -12 % -5);
        System.out.printf("\t\t\t\t\t%s", (result == -2) ? "PASS" : "FAIL");

        


    }
    static void testsOf_power_AllValues()
    {
        System.out.printf("\n*** Start of power Tests - all values ***");
        int result;

        result = power(2, 4);
        System.out.printf("\npower 2 to power 4");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", (int)Math.pow(2, 4));
        System.out.printf("\t\t\t\t\t%s", (result == 16) ? "PASS" : "FAIL");

        result = power(2, 0);
        System.out.printf("\npower 2 to power 0");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", (int)Math.pow(2, 0));
        System.out.printf("\t\t\t\t\t%s", (result == 1) ? "PASS" : "FAIL");

        result = power(0, 2);
        System.out.printf("\npower 0 to power 2");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", (int)Math.pow(0, 2));
        System.out.printf("\t\t\t\t\t%s", (result == 0) ? "PASS" : "FAIL");

        result = power(2, -4);
        System.out.printf("\npower: 2 to power -4");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", 0);
        System.out.printf("\t\t\t\t\t%s", (result == 0) ? "PASS" : "FAIL");

        result = power(-2, 3);
        System.out.printf("\npower: -2 to power 3");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", (int)Math.pow(-2, 3));
        System.out.printf("\t\t\t\t\t%s", (result == -8) ? "PASS" : "FAIL");

        result = power(-2, 0);
        System.out.printf("\npower: -2 to power 0");
        System.out.printf("Actual result is:  %d", result);
        System.out.printf("Expected result is:%d", (int)Math.pow(-2, 0));
        System.out.printf("\t\t\t\t\t%s", (result == 1) ? "PASS" : "FAIL");
    }
}
