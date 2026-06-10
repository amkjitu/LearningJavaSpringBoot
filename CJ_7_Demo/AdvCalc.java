package CJ_7_Demo;

public class AdvCalc extends Calc {
    int factorial(int n) {
        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            return -1; // Return -1 to indicate an error
        } else if (n == 0 || n == 1) {
            return 1; // Factorial of 0 and 1 is 1
        } else {
            int result = 1;
            for (int i = 2; i <= n; i++) {
                result *= i;
            }
            return result;
        }
    }

    int power(int base, int exponent) {
        if (exponent < 0) {
            System.out.println("Negative exponent is not supported.");
            return -1; // Return -1 to indicate an error
        } else {
            int result = 1;
            for (int i = 0; i < exponent; i++) {
                result *= base;
            }
            return result;
        }
    }
}
