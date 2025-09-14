package Assigned5.level2;

import java.util.Scanner;

public class CharacterTypeDisplay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[][] resultTable = analyzeCharacters(input);
        displayTable(resultTable);
        sc.close();
    }

    public static String checkCharacterType(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
        }

        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }

    public static String[][] analyzeCharacters(String str) {
        int index = 0;
        String[][] table = new String[getLength(str)][2];

        try {
            while (true) {
                char ch = str.charAt(index);
                table[index][0] = String.valueOf(ch);
                table[index][1] = checkCharacterType(ch);
                index++;
            }
        } catch (Exception e) {
            return table;
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

    public static void displayTable(String[][] table) {
        System.out.println("Character\tType");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t\t" + table[i][1]);
        }
    }
}
