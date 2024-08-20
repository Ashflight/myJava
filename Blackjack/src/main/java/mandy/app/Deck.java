package mandy.app;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private final ArrayList<Card> deck;
    public Deck() {
        deck = initialDeck();
        Collections.shuffle(deck);
    }

    protected ArrayList<Card> initialDeck() {
        ArrayList<Card> deck = new ArrayList<>();
        for (Value value : Value.values()) {
            for (Suit suit : Suit.values()) {
                deck.add(new Card(suit, value));
            }
        }
        return deck;
    }

    public Card draw() { //TODO unit test this
        return deck.remove(0);
    }
    public Card peek(int index) {
        return deck.get(index);
    }
}
