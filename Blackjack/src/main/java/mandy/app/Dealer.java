package mandy.app;
import java.util.ArrayList;

public class Dealer extends Base {
    private ArrayList<Card> hand;
    public Dealer(Deck deck) {
        super();
        this.hand = super.getHand();
        hand.add(deck.draw());
    }
}
