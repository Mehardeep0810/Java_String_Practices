package Assigned5.level3;

import java.util.Scanner;

public class FirstUniqueCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        char result = findFirstNonRepeating(input);
        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
        sc.close();
    }

    public static char findFirstNonRepeating(String str) {
        int[] freq = new int[256];
        int len = getLength(str);

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            freq[ch]++;
        }

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (freq[ch] == 1) {
                return ch;
            }
        }

        return '\0';
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