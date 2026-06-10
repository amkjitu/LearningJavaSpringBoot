package CJ_7_Demo;

public class SciCalc extends AdvCalc {
    public double squareRoot(double n) {
        if (n < 0) {
            System.out.println("Square root is not defined for negative numbers.");
            return -1; // Return -1 to indicate an error
        } else {
            return Math.sqrt(n);
        }
    }
}
