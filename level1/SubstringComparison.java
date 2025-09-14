package Assigned5.level1;

import java.util.Scanner;

public class SubstringComparison {

    public static String customSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    public static boolean compareUsingCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the original string: ");
        String original = scanner.next();

        System.out.print("Enter start index: ");
        int start = scanner.nextInt();

        System.out.print("Enter end index: ");
        int end = scanner.nextInt();

        String manualSubstring = customSubstring(original, start, end);
        String builtInSubstring = original.substring(start, end);

        boolean comparisonResult = compareUsingCharAt(manualSubstring, builtInSubstring);

        System.out.println("\nManual substring: " + manualSubstring);
        System.out.println("Built-in substring: " + builtInSubstring);
        System.out.println("Comparison result: " + comparisonResult);

        scanner.close();
    }
}
