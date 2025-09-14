package Assigned5.level2;

import java.util.Scanner;

public class ManualTrimCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int[] bounds = findTrimBounds(input);
        String manualTrimmed = manualSubstring(input, bounds[0], bounds[1]);
        String builtInTrimmed = input.trim();

        boolean isEqual = compareStrings(manualTrimmed, builtInTrimmed);

        System.out.println("Manual Trimmed: '" + manualTrimmed + "'");
        System.out.println("Built-in Trimmed: '" + builtInTrimmed + "'");
        System.out.println("Are both equal? " + isEqual);
        sc.close();
    }

    public static int[] findTrimBounds(String str) {
        int start = 0;
        int end = getLength(str) - 1;

        try {
            while (str.charAt(start) == ' ') {
                start++;
            }
        } catch (Exception e) {
            return new int[]{0, -1};
        }

        try {
            while (str.charAt(end) == ' ') {
                end--;
            }
        } catch (Exception e) {
            return new int[]{0, -1};
        }

        return new int[]{start, end};
    }

    public static String manualSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    public static boolean compareStrings(String a, String b) {
        int lenA = getLength(a);
        int lenB = getLength(b);

        if (lenA != lenB) {
            return false;
        }

        for (int i = 0; i < lenA; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }
}