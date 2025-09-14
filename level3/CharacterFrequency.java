package Assigned5.level3;

import java.util.Scanner;

public class CharacterFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[][] frequencyTable = getCharacterFrequencies(input);
        displayFrequencyTable(frequencyTable);
        sc.close();
    }

    public static String[][] getCharacterFrequencies(String str) {
        int[] freq = new int[256];
        int len = getLength(str);

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            freq[ch]++;
        }

        boolean[] added = new boolean[256];
        String[][] result = new String[len][2];
        int index = 0;

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (!added[ch]) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(freq[ch]);
                added[ch] = true;
                index++;
            }
        }

        String[][] finalResult = new String[index][2];
        for (int i = 0; i < index; i++) {
            finalResult[i] = result[i];
        }

        return finalResult;
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

    public static void displayFrequencyTable(String[][] table) {
        System.out.println("Character\tFrequency");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t\t" + table[i][1]);
        }
    }
}
