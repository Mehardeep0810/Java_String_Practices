package Assigned5.level3;

import java.util.Scanner;

public class UniqueCharactersFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int length = getLength(input);
        char[] uniqueChars = findUniqueCharacters(input, length);

        System.out.println("Unique Characters:");
        for (char ch : uniqueChars) {
            if (ch != '\0') {
                System.out.print(ch + " ");
            }
        }
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

    public static char[] findUniqueCharacters(String str, int len) {
        char[] result = new char[len];
        int uniqueIndex = 0;

        for (int i = 0; i < len; i++) {
            char current = str.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (str.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                result[uniqueIndex++] = current;
            }
        }

        char[] finalResult = new char[uniqueIndex];
        for (int i = 0; i < uniqueIndex; i++) {
            finalResult[i] = result[i];
        }

        return finalResult;
    }
}