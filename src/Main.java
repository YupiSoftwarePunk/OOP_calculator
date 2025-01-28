import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Menu.showMenu();

        Scanner input = new Scanner(System.in);

        int choose = input.nextInt();

        System.out.print("\n\nВведите 1 число: ");
        double num1 = input.nextDouble();

        System.out.print("Введите 2 число: ");
        double num2 = input.nextDouble();

        double funcRes = 0; // for function's results

        try {
            FileWriter writer = new FileWriter("input.txt", true);

            writer.write((int) num1);

            writer.write((int) num2);

            writer.close();
        }
        catch (IOException e){
            System.out.println("Возникла ошибка во время записи, проверьте данные.");
        }

        if (choose == 1){
            funcRes =  Calculator.Add(num1, num2);
            System.out.println(funcRes);
        }

        else if (choose == 2) {
            funcRes =  Calculator.Substract(num1, num2);
            System.out.println(funcRes);
        }

        else if (choose == 3) {
            funcRes =  Calculator.Multiply(num1, num2);
            System.out.println(funcRes);
        }

        else if (choose == 4) {
            try {
                double result = Calculator.Divide(num1, num2);
                funcRes = result;
                System.out.println(funcRes);
            }
            catch (ArithmeticException e){
                System.out.println("Ошибка: Деление на ноль невозможно.");
            }
        }

        else if (choose == 5) {
            funcRes =  ScientificCalculator.Pow(num1, num2);
            System.out.println(funcRes);
        }

        else if (choose == 6) {
            funcRes =  ScientificCalculator.Factorial(num1);
            System.out.println(funcRes);
        }

        try {
            FileWriter writer = new FileWriter("output.txt", true);

            writer.write((int) funcRes);

            writer.close();
        }
        catch (IOException e){
            System.out.println("Возникла ошибка во время записи, проверьте данные.");
        }
    }
}