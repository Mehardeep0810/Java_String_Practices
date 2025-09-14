package Assigned5.level1;

import java.util.Scanner;

public class StringIndexDemo {

    public static void generateException(String text) {
        System.out.println(text.charAt(text.length())); // Invalid index
    }

    public static void handleException(String text) {
        try {
            System.out.println(text.charAt(text.length())); // Invalid index
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
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
