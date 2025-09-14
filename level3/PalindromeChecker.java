package Assigned5.level3;

import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        boolean result1 = isPalindromeIterative(input);
        boolean result2 = isPalindromeRecursive(input, 0, getLength(input) - 1);
        boolean result3 = isPalindromeUsingArray(input);

        System.out.println("Palindrome Check (Iterative): " + result1);
        System.out.println("Palindrome Check (Recursive): " + result2);
        System.out.println("Palindrome Check (Char Array): " + result3);
        sc.close();
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

    public static boolean isPalindromeIterative(String str) {
        int start = 0;
        int end = getLength(str) - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    public static boolean isPalindromeUsingArray(String str) {
        char[] original = str.toCharArray();
        char[] reversed = reverseString(str);
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    public static char[] reverseString(String str) {
        int len = getLength(str);
        char[] reversed = new char[len];
        for (int i = 0; i < len; i++) {
            reversed[i] = str.charAt(len - 1 - i);
        }
        return reversed;
    }
}
