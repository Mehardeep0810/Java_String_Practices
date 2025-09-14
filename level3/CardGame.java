package Assigned5.level3;

import java.util.Scanner;

public class CardGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] deck = initializeDeck();
        int numOfCards = deck.length;

        deck = shuffleDeck(deck);

        System.out.print("Enter number of cards to distribute: ");
        int n = sc.nextInt();
        System.out.print("Enter number of players: ");
        int x = sc.nextInt();
        sc.close();

        if (n % x != 0 || n > numOfCards) {
            System.out.println("Cannot distribute " + n + " cards evenly among " + x + " players.");
            return;
        }

        String[][] players = distributeCards(deck, n, x);
        printPlayerCards(players);
    }

    public static String[] initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
        "Jack", "Queen", "King", "Ace"};
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];
        int index = 0;
        

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }

        return deck;
    }

    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int)(Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }

    public static String[][] distributeCards(String[] deck, int n, int x) {
        int cardsPerPlayer = n / x;
        String[][] players = new String[x][cardsPerPlayer];
        int cardIndex = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[cardIndex++];
            }
        }

        return players;
    }

    public static void printPlayerCards(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + " cards:");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println("  " + players[i][j]);
            }
            System.out.println();
        }
    }
}
