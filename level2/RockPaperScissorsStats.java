package Assigned5.level2;

import java.util.Scanner;

public class RockPaperScissorsStats {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int totalGames = sc.nextInt();
        sc.nextLine();

        String[][] results = new String[totalGames][3];
        int userWins = 0;
        int computerWins = 0;

        for (int i = 0; i < totalGames; i++) {
            System.out.print("Game " + (i + 1) + " - Enter your choice (rock/paper/scissors): ");
            String userChoice = sc.nextLine().toLowerCase();
            String computerChoice = getComputerChoice();
            String winner = getWinner(userChoice, computerChoice);

            results[i][0] = userChoice;
            results[i][1] = computerChoice;
            results[i][2] = winner;

            if (winner.equals("User")) {
                userWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            }
        }

        String[][] stats = calculateStats(userWins, computerWins, totalGames);
        displayResults(results, stats);
        sc.close();
    }

    public static String getComputerChoice() {
        double rand = Math.random();
        if (rand < 0.33) {
            return "rock";
        } else if (rand < 0.66) {
            return "paper";
        } else {
            return "scissors";
        }
    }

    public static String getWinner(String user, String computer) {
        if (user.equals(computer)) {
            return "Draw";
        } else if ((user.equals("rock") && computer.equals("scissors")) ||
                   (user.equals("paper") && computer.equals("rock")) ||
                   (user.equals("scissors") && computer.equals("paper"))) {
            return "User";
        } else {
            return "Computer";
        }
    }

    public static String[][] calculateStats(int userWins, int computerWins, int totalGames) {
        String[][] stats = new String[2][3];
        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.valueOf((userWins * 100) / totalGames) + "%";

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.valueOf((computerWins * 100) / totalGames) + "%";

        return stats;
    }

    public static void displayResults(String[][] results, String[][] stats) {
        System.out.println("\nGame Results:");
        System.out.println("User\tComputer\tWinner");
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i][0] + "\t" + results[i][1] + "\t\t" + results[i][2]);
        }

        System.out.println("\nWin Statistics:");
        System.out.println("Player\tWins\tWin %");
        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2]);
        }
    }
}
