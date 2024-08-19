package mandy.app;

import java.util.ArrayList;

public class Player extends Base {
    private final ArrayList<Card> hand;
    public Player(Deck deck) {
        super();
        this.hand = super.getHand();
        hand.add(deck.draw());
        hand.add(deck.draw());
    }
    public void playTurn(String action, Deck deck) {
        if (action.equalsIgnoreCase("hit")) {
            hit(deck);
            System.out.println("You have " + getPrintableHand());
        }
    }
}
