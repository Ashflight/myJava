package mandy.app;

import java.util.ArrayList;
import static mandy.app.Result.*;

public class Dealer extends Base {
    private ArrayList<Card> hand;
    public Dealer(Deck deck) {
        super();
        this.hand = super.getHand();
        hand.add(deck.draw());
    }
    public Result playTurn(Deck deck, int playerScore) {
        do {
            hit(deck);
        } while (getScore() < 17 || getScore() < playerScore);
        if (getScore() > 21) {
            return BUST;
        }
        else if (getScore() == 21 || getScore() > playerScore) {
            return WIN;
        }
        else {
            return TIE;
        }
    }
}
