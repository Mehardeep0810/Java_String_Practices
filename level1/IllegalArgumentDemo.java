package Assigned5.level1;

import java.util.Scanner;

public class IllegalArgumentDemo {

    public static void generateException(String text) {
        System.out.println(text.substring(5, 2)); // start > end
    }

    public static void handleException(String text) {
        try {
            System.out.println(text.substring(5, 2)); // start > end
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.next();

        // Uncomment to see the exception
        // generateException(input);

        // Refactored to handle the exception
        handleException(input);

        scanner.close();
    }
}