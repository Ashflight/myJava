package mandy.app;

import java.util.Scanner;

import static mandy.app.Result.BUST;
import static mandy.app.Result.WIN;

public class BlackjackGame {
    public static void main(String[] args) {
        boolean playing;
        int balance = 10;
        int bet;
        do {
            Scanner scanner = new Scanner(System.in);
            Blackjack blackjack = new Blackjack();
            System.out.println("You have " + balance + " token(s).");
            bet = getBet(scanner);
            display(blackjack);
            if (checkBlackjack(blackjack)) {
                //FYI blackjack is when your had is ace of spades + jack of spades or clubs (a black suit basically)
                // it gives you an increased payout, usually 10x the bet.
                balance = balance + 10*bet;
                playing = updatePlaying(scanner);
                continue;
            }
            Result playerReturn = playerTurn(scanner, blackjack);
            if (playerReturn == WIN) {
                balance = balance + bet;
                playing = updatePlaying(scanner);
                continue;
            }
            else if (playerReturn == BUST) {
                balance = balance - bet;
                if (checkBalance(balance)) {
                    return;
                }
                playing = updatePlaying(scanner);
                continue;
            }
            Result dealerReturn = dealerTurn(blackjack);
            if (dealerReturn == WIN) {
                balance = balance - bet;
                if (checkBalance(balance)) {
                    return;
                }
                playing = updatePlaying(scanner);
                continue;
            }
            else if (dealerReturn == BUST) {
                balance = balance + bet;
                playing = updatePlaying(scanner);
                continue;
            }
            if (checkBalance(balance)) {
                return;
            }
            playing = updatePlaying(scanner);
        } while (playing);
        System.out.println("Your final balance is " + balance + " tokens.");
    }
    private static Result playerTurn(Scanner scanner, Blackjack blackjack) {
        String input;
        Result status;
        do {
            input = getInput(scanner);
            status = blackjack.playerTurn(input);
            display(blackjack);
            if (status == WIN) {
                System.out.println("You scored 21, you win!");
                return status;
            } else if (status == BUST) {
                System.out.println("Your hand bust, you lost.");
                return status;
            }
        } while (input.equals("hit"));
        return status;
    }
    private static Result dealerTurn(Blackjack blackjack) {
        Result status = blackjack.dealerTurn();
        display(blackjack);
        if (status == WIN) {
            System.out.println("The dealer scored closer to 21 than you, you lose.");
            return status;
        } else if (status == BUST) {
            System.out.println("The dealer's hand bust. or you scored closer to 21 than the dealer, you win!");
            return status;
        }
        else {
            System.out.println("You and the dealer score the same, the game has ended in a tie.");
            return status;
        }
    }
    private static boolean checkBlackjack(Blackjack blackjack) {
        return blackjack.checkBlackjack();
    }

    public static String getInput(Scanner scanner) {
        System.out.print("Hit or stand? ");
        return scanner.nextLine();
    }

    public static boolean updatePlaying(Scanner scanner) {
        System.out.print("Do you want to play again? ");
        return scanner.nextLine().equalsIgnoreCase("yes");
    }

    public static int getBet(Scanner scanner) {
        System.out.print("How many tokens do you want to bet? ");
        int nextInt = scanner.nextInt();
        scanner.nextLine();
        return nextInt;
    }
    public static boolean checkBalance(int balance) {
        if (balance < 1) {
            System.out.println("You ran out of tokens, game over.");
            return true;
        }
        return false;
    }
    public static void display(Blackjack blackjack) {
        System.out.println("===========================================================================");
        System.out.printf("The dealer has: %s. Their score is %s.%n",
                blackjack.getDealer().getPrintableHand(), blackjack.getDealer().getScore());
        System.out.printf("You have: %s. Your score is %s.%n",
                blackjack.getPlayer().getPrintableHand(), blackjack.getPlayer().getScore());
    }
}