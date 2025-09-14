package Assigned5.level2;

import java.util.Scanner;

public class StringLengthFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int customLength = getLength(input);
        int builtInLength = input.length();
        System.out.println("Custom Length: " + customLength);
        System.out.println("Built-in Length: " + builtInLength);
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
}
