import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(){
        Menu.showMenu();

        Scanner input = new Scanner(System.in);
        System.out.println("Добро пожаловать в калькулятор!!");
        System.out.println("Выберите действие: ");
        System.out.println("1. Сложение (add)\n2. Вычитание (subtract)\n3. Умножение (multiply)\n4. деление (divide)\n5. Возведение в степень (pow)\n6. Вычисление факториала (factorial)\n");

        int choose = input.nextInt();

        System.out.print("\n\nВведите 1 число: ");
        double num1 = input.nextDouble();

        System.out.print("\n\nВведите 2 число: ");
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
        }

        else if (choose == 2) {
            funcRes =  Calculator.Substract(num1, num2);
        }

        else if (choose == 3) {
            funcRes =  Calculator.Multiply(num1, num2);
        }

        else if (choose == 4) {
            try {
                double result = Calculator.Divide(num1, num2);
                funcRes = result;
            }
            catch (ArithmeticException e){
                System.out.println("Ошибка: Деление на ноль невозможно.");
            }
        }

        else if (choose == 5) {
            funcRes =  ScientificCalculator.Pow(num1, num2);
        }

        else if (choose == 6) {
            funcRes =  ScientificCalculator.Factorial(num1);
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