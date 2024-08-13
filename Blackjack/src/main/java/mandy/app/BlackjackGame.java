package mandy.app;

import java.util.Scanner;

public class BlackjackGame {
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println(deck.deck); //just testing that im making a functional deck of cards
        deck.deck = deck.deckShuffle(deck.deck);
        System.out.println(deck.deck);
        Scanner scanner = new Scanner(System.in);
        //TODO where the actual playing code will go
        Dealer dealer = new Dealer(deck);
        Player player = new Player(deck);
        boolean active;
        System.out.println("The dealer has" + dealer.getHand());
        System.out.println("You have " + player.getHand());
        do {
            active = player.playTurn(player.getInput(scanner), deck);
            if (player.getScore() > 21) {
                active = false;
            }
        } while (active);
    }
}