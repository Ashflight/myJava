package mandy.app;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Base {
    private ArrayList<Card> hand;
    public Player(Deck deck) {
        super();
        this.hand = super.getHand();
        hand.add(deck.draw());
        hand.add(deck.draw());
    }
    public void playTurn(String action, Deck deck) {
        if (action.equalsIgnoreCase("hit")) {
            hit(deck);
            System.out.println("You have " + hand);
        }
    }
}
