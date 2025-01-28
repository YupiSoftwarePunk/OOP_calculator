import java.util.Scanner;

public class Menu {
    public static void showMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("Добро пожаловать в калькулятор!!");
        System.out.println("Выберите действие: ");
        System.out.println("1. Сложение (add)\n2. Вычитание (subtract)\n3. Умножение (multiply)\n4. деление (divide)\n5. Возведение в степень (pow)\n6. Вычисление факториала (factorial)\n");

        int choose = input.nextInt();

        System.out.print("\n\nВведите 1 число: ");
        double num1 = input.nextDouble();

        System.out.print("\n\nВведите 2 число: ");
        double num2 = input.nextDouble();
    }

}
