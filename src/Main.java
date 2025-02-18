import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Menu.showMenu();  // shows menu panel
        int choose = input.nextInt();

        // выдача ошибки если ввод действия > 6
        if (choose > 6){
            System.out.println("\nНеверный ввод действия!!");
            return;
        }

        System.out.print("\n\nВведите 1 число: ");
        double num1 = input.nextDouble();

        System.out.print("Введите 2 число: ");
        double num2 = input.nextDouble();


        // Запись num1 и num2 в текстовый файлик
        try {
            FileWriter writer = new FileWriter("input.txt", false);

            writer.write("Первое число: "+ num1 + "\n");

            writer.write("Второе число: "+ num2 + "\n");

            writer.close();
        } catch (IOException e) {
            System.out.println("Возникла ошибка во время записи, проверьте данные.");
        }
        finally {
            input.close();
        }

        double funcRes = 0; // for function's results

        // Вызовы функций
        if (choose == 1) {
            funcRes = Calculator.Add(num1, num2);
            System.out.println("Сумма = " + funcRes);
        }
        else if (choose == 2) {
            funcRes = Calculator.Substract(num1, num2);
            System.out.println("Разность = " + funcRes);
        }
        else if (choose == 3) {
            funcRes = Calculator.Multiply(num1, num2);
            System.out.println("Произведение = " + funcRes);
        }
        else if (choose == 4) {
            try {
                double result = Calculator.Divide(num1, num2);
                funcRes = result;
                System.out.println("Частное = " + funcRes);
            } catch (ArithmeticException e) {
                System.out.println("Ошибка: Деление на ноль невозможно.");
            }
        }
        else if (choose == 5) {
            funcRes = ScientificCalculator.Pow(num1, num2);
            System.out.println("Число возведенное в степень = " + funcRes);
        }
        else if (choose == 6) {
            funcRes = ScientificCalculator.Factorial(num1);
            System.out.println("Факториал числа = " + funcRes);


            // запись результата функции в текстовый файлик
            try {
                FileWriter writer = new FileWriter("output.txt", false);

                writer.write("Результат функции = " + Double.toString(funcRes));

                writer.close();
            } catch (IOException e) {
                System.out.println("Возникла ошибка во время записи, проверьте данные.");
            }
        }
    }
}