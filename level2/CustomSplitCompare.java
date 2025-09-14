package Assigned5.level2;

import java.util.Scanner;

public class CustomSplitCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] customSplit = customSplit(input);
        String[] builtInSplit = input.split(" ");

        boolean areEqual = compareArrays(customSplit, builtInSplit);

        System.out.println("Custom Split:");
        for (String word : customSplit) {
            System.out.println(word);
        }

        System.out.println("Built-in Split:");
        for (String word : builtInSplit) {
            System.out.println(word);
        }

        System.out.println("Are both splits equal? " + areEqual);
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

    public static String[] customSplit(String str) {
        int len = getLength(str);
        int spaceCount = 0;

        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        int[] spaceIndexes = new int[spaceCount];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                spaceIndexes[idx++] = i;
            }
        }

        String[] words = new String[spaceCount + 1];
        int start = 0;
        for (int i = 0; i < spaceCount; i++) {
            int end = spaceIndexes[i];
            words[i] = extractWord(str, start, end);
            start = end + 1;
        }
        words[spaceCount] = extractWord(str, start, len);
        return words;
    }

    public static String extractWord(String str, int start, int end) {
        String word = "";
        for (int i = start; i < end; i++) {
            word += str.charAt(i);
        }
        return word;
    }

    public static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                return false;
            }
        }
        return true;
    }
}