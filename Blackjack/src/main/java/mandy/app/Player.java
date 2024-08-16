package mandy.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static mandy.app.Value.ACE;

public class Player extends Blackjack {
    private ArrayList<Card> hand;
    public Player(Deck deck) {
        super();
        this.hand = super.getHand();
        hand.add(deck.draw());
        hand.add(deck.draw());
    }
    public String getInput(Scanner scanner) {
        System.out.print("Hit or stand? ");
        return scanner.nextLine();
    }
    public boolean playTurn(String action, Deck deck) {
        if (action.equalsIgnoreCase("hit")) {
            hit(deck);
            System.out.println("You have " + hand);
            return true;
        }
        else if (action.equalsIgnoreCase("stand")) {
            return false;
        }
        else {
            System.out.println("Input invalid.");
            return true;
        }
    }
}
