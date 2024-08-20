package mandy.app;

import java.util.ArrayList;

import static mandy.app.Result.*;

public class Player extends Base {
    private final ArrayList<Card> hand;
    public Player(Deck deck) {
        super();
        this.hand = super.getHand();
        hand.add(deck.draw());
        hand.add(deck.draw());
    }
    public Result playTurn(String action, Deck deck) {
        if (action.equalsIgnoreCase("hit")) {
            hit(deck);
        }
        if (getScore() > 21) {
            return BUST;
        }
        else if (getScore() == 21) {
            return WIN;
        }
        else {
            return CONTINUE;
        }
    }
}
