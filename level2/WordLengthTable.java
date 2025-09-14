package Assigned5.level2;

import java.util.Scanner;

public class WordLengthTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] words = splitWords(input);
        String[][] wordLengthTable = buildWordLengthTable(words);

        System.out.println("Word\tLength");
        for (int i = 0; i < wordLengthTable.length; i++) {
            String word = wordLengthTable[i][0];
            int length = Integer.parseInt(wordLengthTable[i][1]);
            System.out.println(word + "\t" + length);
            sc.close();
        }
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

    public static String[] splitWords(String str) {
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

    public static String[][] buildWordLengthTable(String[] words) {
        String[][] table = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            table[i][0] = words[i];
            table[i][1] = String.valueOf(getLength(words[i]));
        }
        return table;
    }
}
