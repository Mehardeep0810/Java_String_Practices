package Assigned5.level2;

import java.util.Scanner;
import java.util.Random;

public class VotingEligibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfStudents = 10;

        int[] ages = generateRandomAges(numberOfStudents);
        String[][] eligibilityTable = checkVotingEligibility(ages);
        displayTable(eligibilityTable);
        sc.close();
    }

    public static int[] generateRandomAges(int n) {
        int[] ages = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            ages[i] = rand.nextInt(90); // generates a number between 0 and 89
        }
        return ages;
    }

    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] table = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            table[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) {
                table[i][1] = "false";
            } else if (ages[i] >= 18) {
                table[i][1] = "true";
            } else {
                table[i][1] = "false";
            }
        }
        return table;
    }

    public static void displayTable(String[][] table) {
        System.out.println("Age\tCan Vote");
        for (int i = 0; i < table.length; i++) {
            int age = Integer.parseInt(table[i][0]);
            boolean canVote = Boolean.parseBoolean(table[i][1]);
            System.out.println(age + "\t" + canVote);
        }
    }
}
