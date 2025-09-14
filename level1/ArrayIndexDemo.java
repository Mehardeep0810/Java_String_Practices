package Assigned5.level1;

import java.util.Scanner;

public class ArrayIndexDemo {

    public static void generateException(String[] names) {
        System.out.println(names[names.length]); // Invalid index
    }

    public static void handleException(String[] names) {
        try {
            System.out.println(names[names.length]); // Invalid index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of names: ");
        int count = scanner.nextInt();

        String[] names = new String[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = scanner.next();
        }

      
        handleException(names);

        scanner.close();
    }
}
