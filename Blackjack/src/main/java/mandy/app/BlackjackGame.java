package mandy.app;

import java.util.Scanner;

public class BlackjackGame {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Scanner scanner = new Scanner(System.in);
        //TODO where the actual playing code will go
        Dealer dealer = new Dealer(deck);
        Player player = new Player(deck);
        boolean active;
        int playerScore;
        int dealerScore;
        System.out.println("The dealer has " + dealer.getHand());
        System.out.println("You have " + player.getHand());
        do {
            active = player.playTurn(player.getInput(scanner), deck);
            playerScore = player.getScore();
            if (playerScore > 21) {
                System.out.println("Your hand has bust, you lose.");
                return;
            }
        } while (active);
        do {
            dealer.hit(deck);
            dealerScore = dealer.getScore();
        } while (dealerScore < 17);
        System.out.println("The dealer has " + dealer.getHand());
        if (dealerScore > 21) {
            System.out.println("The dealer's hand has bust, you win!");
            return;
        }
        System.out.println("You have " + player.getHand());
        if (playerScore > dealerScore) {
            System.out.println("You scored closer to 21 than the dealer, you win!");
        }
        else if (playerScore < dealerScore) {
            System.out.println("The dealer scored closer to 21 than you, you lose.");
        }
        else {
            System.out.println("You and the dealer have the same score, so it is a tie.");
        }
    }
}