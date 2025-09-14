package Assigned5.level3;

import java.util.Scanner;

public class UniqueCharFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[][] frequencyTable = getFrequencyUsingUniqueCharacters(input);
        displayFrequencyTable(frequencyTable);
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

    public static char[] findUniqueCharacters(String str) {
        int len = getLength(str);
        char[] temp = new char[len];
        int uniqueCount = 0;

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
                temp[uniqueCount++] = current;
            }
        }

        char[] uniqueChars = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueChars[i] = temp[i];
        }

        return uniqueChars;
    }

    public static String[][] getFrequencyUsingUniqueCharacters(String str) {
        int[] freq = new int[256];
        int len = getLength(str);

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            freq[ch]++;
        }

        char[] uniqueChars = findUniqueCharacters(str);
        String[][] result = new String[uniqueChars.length][2];

        for (int i = 0; i < uniqueChars.length; i++) {
            char ch = uniqueChars[i];
            result[i][0] = String.valueOf(ch);
            result[i][1] = String.valueOf(freq[ch]);
        }

        return result;
    }

    public static void displayFrequencyTable(String[][] table) {
        System.out.println("Character\tFrequency");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t\t" + table[i][1]);
        }
    }
}
