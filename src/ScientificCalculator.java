public class ScientificCalculator {
    public static double Pow(double num1, double num2){
        return Math.pow(num1, num2);
    }

    public static double Factorial(double num1){
        if (num1 == 0 || num1 == 1){
            return 1;
        }
        else {
            return num1 * Factorial(num1 - 1);
        }
    }
}