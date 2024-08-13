package mandy.app;
import java.util.ArrayList;

public class Dealer {
    private final ArrayList<String> hand = new ArrayList<>();
    public Dealer(Deck deck) {
        hand.add(deck.deck.remove(0));
    }
    public ArrayList<String> getHand() {
        return hand;
    }
}
