package mandy.app;
import java.util.ArrayList;
import static mandy.app.Value.*;

public class Dealer extends Blackjack {
    private ArrayList<Card> hand;
    public Dealer(Deck deck) {
        super();
        this.hand = super.getHand();
        hand.add(deck.draw());
    }
}
