package Assigned5.level1;

import java.util.Scanner;

public class CharArrayComparison {

    public static char[] getCharsManually(String str) {
        char[] result = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = str.charAt(i);
        }
        return result;
    }

    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.next();

        char[] manualChars = getCharsManually(input);
        char[] builtInChars = input.toCharArray();

        boolean result = compareCharArrays(manualChars, builtInChars);

        System.out.println("\nManual char array: ");
        for (char c : manualChars) {
            System.out.print(c + " ");
        }

        System.out.println("\nBuilt-in char array: ");
        for (char c : builtInChars) {
            System.out.print(c + " ");
        }

        System.out.println("\nComparison result: " + result);

        scanner.close();
    }
}