package mandy.app;

import java.util.Scanner;

public class BlackjackGame { //TODO refactor this into game parts then make an actual game class.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // new blackjack
        Blackjack blackjack = new Blackjack();
        // TODO make initial display function
        System.out.println("The dealer has " + blackjack.getDealerHand());
        System.out.println("You have " + blackjack.getPlayerHand());
        // ask player next step, either hit or stand
        String input;
        do { //TODO turn this into a player turn function
            input = getInput(scanner);
            // get hit from player, call blackjack "player hit"
            Result status = blackjack.playerTurn(input);
            // return result, win/not win
            if (status == Result.WIN) {
                System.out.println("You win!");
                return;
            } else if (status == Result.BUST) {
                System.out.println("You lost.");
                return;
            }
        } while (input.equals("hit"));
        // until get stand form player, ask dealer next step , either hit or stand

//        boolean active;
//        System.out.println("The dealer has " + dealer.getHand());
//        //TODO fix object printing, currently unplayable because of display problems
//        System.out.println("You have " + player.getHand());
//        do {
//            active = player.playTurn(player.getInput(scanner), deck);
//            playerScore = player.getScore();
//            if (playerScore > 21) {
//                System.out.println("Your hand has bust, you lose.");
//                return;
//            }
//        } while (active);
//        do {
//            dealer.hit(deck);
//            dealerScore = dealer.getScore();
//        } while (dealerScore < 17);
//        System.out.println("The dealer has " + dealer.getHand());
//        if (dealerScore > 21) {
//            System.out.println("The dealer's hand has bust, you win!");
//            return;
//        }
//        System.out.println("You have " + player.getHand());
//        if (playerScore > dealerScore) {
//            System.out.println("You scored closer to 21 than the dealer, you win!");
//        }
//        else if (playerScore < dealerScore) {
//            System.out.println("The dealer scored closer to 21 than you, you lose.");
//        }
//        else {
//            System.out.println("You and the dealer have the same score, so it is a tie.");
//        }
    }
    public static String getInput(Scanner scanner) {
        System.out.print("Hit or stand? ");
        return scanner.nextLine();
    }
}