package mandy.app;

import java.util.Scanner;

import static mandy.app.Result.BUST;
import static mandy.app.Result.WIN;

public class BlackjackGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Blackjack blackjack = new Blackjack();
        blackjack.display(); //TODO fix object printing, currently unplayable because of display problems
        if (playerTurn(scanner, blackjack)) {
            return;
        }
        if (dealerTurn(blackjack)) {
            return;
        }
        displayResult(blackjack);
    }
    private static boolean playerTurn(Scanner scanner, Blackjack blackjack) {
        String input;
        Result status;
        do { //TODO turn this into a player turn function
            input = getInput(scanner);
            // get hit from player, call blackjack "player hit"
            status = blackjack.playerTurn(input);
            // return result, win/not win
            if (status == WIN) {
                System.out.println("You scored 21, you win!");
                return true;
            } else if (status == BUST) {
                System.out.println("Your hand bust, you lost.");
                return true;
            }
        } while (input.equals("hit"));
        return false;
    }
    private static boolean dealerTurn(Blackjack blackjack) {
        Result status = blackjack.dealerTurn();
        if (status == WIN) {
            System.out.println("The dealer scored 21, you lose.");
            return true;
        } else if (status == BUST) {
            System.out.println("The dealer's hand bust, you win!");
            return true;
        }
        return false;
    }
    private static void displayResult(Blackjack blackjack) {
        Result status = blackjack.compareScores();
        if (status == WIN) {
            System.out.println("You scored higher than the dealer, you win!");
        }
        else if (status == BUST) {
            System.out.println("The dealer scored higher than you, you lost.");
        }
        else {
            System.out.println("You and the dealer scored the same, it is a tie.");
        }
    }
    public static String getInput(Scanner scanner) {
        System.out.print("Hit or stand? ");
        return scanner.nextLine();
    }
}