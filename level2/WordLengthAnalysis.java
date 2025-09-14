package Assigned5.level2;

import java.util.Scanner;

public class WordLengthAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] words = splitWords(input);
        String[][] wordLengthTable = buildWordLengthTable(words);
        int[] result = findShortestAndLongest(wordLengthTable);

        System.out.println("Shortest Word: " + wordLengthTable[result[0]][0] + " (Length: " + Integer.parseInt(wordLengthTable[result[0]][1]) + ")");
        System.out.println("Longest Word: " + wordLengthTable[result[1]][0] + " (Length: " + Integer.parseInt(wordLengthTable[result[1]][1]) + ")");
    
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

    public static int[] findShortestAndLongest(String[][] table) {
        int minIndex = 0;
        int maxIndex = 0;
        int minLength = Integer.parseInt(table[0][1]);
        int maxLength = Integer.parseInt(table[0][1]);

        for (int i = 1; i < table.length; i++) {
            int length = Integer.parseInt(table[i][1]);
            if (length < minLength) {
                minLength = length;
                minIndex = i;
            }
            if (length > maxLength) {
                maxLength = length;
                maxIndex = i;
            }
        }

        return new int[]{minIndex, maxIndex};
    }
}
