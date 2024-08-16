package mandy.app;

import java.util.ArrayList;
import static mandy.app.Value.*;

public class Blackjack {
    private final ArrayList<Card> hand;
    public Blackjack() {
        hand = new ArrayList<>();
    }
    public void hit(Deck deck) {
        hand.add(deck.draw());
    }
    public int getScore() {
        int cardScore;
        int total = 0;
        int aceCounter = 0;
        for (Card card : hand) { //find first total
            if (card.equals(ACE)) {
                aceCounter++;
            }
            cardScore = card.getValue().getNumber();
            total = total + cardScore;
        }
        while (total > 21 && aceCounter > 0) { //reduce aces if needed
            aceCounter--;
            total = total - 10;
        }
        return total;
    }
    public ArrayList<Card> getHand() {
        return hand;
    }
}
