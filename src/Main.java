//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        while (true) {
            System.out.println("\n==== Calculator ====");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Square Root");
            System.out.println("6. Power");
            System.out.println("7. Exit");

            System.out.print("Choose option: ");

            try {
                int choice = sc.nextInt();

                if (choice == 7) {
                    System.out.println("Exiting...");
                    break;
                }


                switch (choice) {
                    case 1, 2, 3, 4 -> {
                        System.out.print("Enter first number: ");
                        String a = sc.next();

                        System.out.print("Enter second number: ");
                        String b = sc.next();

                        System.out.println("Result: " + calc.basicOperation(choice, a, b));
                    }

                    case 5 -> {
                        System.out.print("Enter number: ");
                        double num = sc.nextDouble();
                        System.out.println("Result: " + calc.squareRoot(num));
                    }

                    case 6 -> {
                        System.out.print("Base: ");
                        double base = sc.nextDouble();
                        System.out.print("Exponent: ");
                        double exp = sc.nextDouble();
                        System.out.println("Result: " + calc.power(base, exp));
                    }

                    default -> System.out.println("Invalid choice");
                }

            } catch (Exception e) {
                System.out.println("Invalid input! Try again.");
                sc.nextLine(); // clear buffer
            }
        }

        sc.close();
    }
}