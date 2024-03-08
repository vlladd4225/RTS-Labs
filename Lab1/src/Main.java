import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator complex1 = new Calculator(2, 5);
        Calculator complex2 = new Calculator(4, -1);

        while (true) {
            System.out.println("Calculator");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Addition Result: " + complex1.add(complex2));
                    break;
                case 2:
                    System.out.println("Subtraction Result: " + complex1.subtract(complex2));
                    break;
                case 3:
                    System.out.println("Multiplication Result: " + complex1.multiply(complex2));
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}