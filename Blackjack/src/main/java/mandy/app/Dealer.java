package mandy.app;
import java.util.ArrayList;
import java.util.HashMap;

public class Dealer {
    private final ArrayList<String> hand = new ArrayList<>();
    private final HashMap<String, Integer> valueMap = new HashMap<>();
    public Dealer(Deck deck) {
        valueMap.put("Ace", 11);
        valueMap.put("Two", 2);
        valueMap.put("Three", 3);
        valueMap.put("Four", 4);
        valueMap.put("Five", 5);
        valueMap.put("Six", 6);
        valueMap.put("Seven", 7);
        valueMap.put("Eight", 8);
        valueMap.put("Nine", 9);
        valueMap.put("Ten", 10);
        valueMap.put("Jack", 10);
        valueMap.put("Queen", 10);
        valueMap.put("King", 10);
        hand.add(deck.draw());
    }
    public ArrayList<String> getHand() {
        return hand;
    }
    public void hit(Deck deck) {
        hand.add(deck.draw());
    }
    public int getScore() {
        int cardScore;
        int total = 0;
        int aceCounter = 0;
        String cardNumber;
        for (String s : hand) { //find first total
            cardNumber = s.split(" ")[0];
            if (cardNumber.equals("Ace")) {
                aceCounter++;
            }
            cardScore = valueMap.get(cardNumber);
            total = total + cardScore;
        }
        while (total > 21 && aceCounter > 0) { //reduce aces if needed
            aceCounter--;
            total = total - 10;
        }
        return total;
    }
}
