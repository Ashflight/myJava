package mandy.app;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Base {
    private ArrayList<Card> hand;
    public Player(Deck deck) {
        super();
        hand.add(deck.draw());
        hand.add(deck.draw());
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
