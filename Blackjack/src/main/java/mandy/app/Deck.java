package mandy.app;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
    ArrayList<String> deck = new ArrayList<>();
    public Deck() {
        int i = 0;
        final String[] cards = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        final String[] suits = {"Diamonds", "Hearts", "Clubs", "Spades"};
        do {
            for (int card = 0; card < 13; card++) {
                for (int suit = 0; suit < 4; suit++) {
                    deck.add(cards[card] + " of " + suits[suit]);
                    i++;
                }
            }
        } while (i < 51);
    }
    public ArrayList<String> deckShuffle(ArrayList<String> arraylist) {
        Random rand = new Random();
        for (int i = arraylist.size() - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            // Swap array[i] with array[j]
            String temp = arraylist.get(i);
            arraylist.set(i, arraylist.get(j));
            arraylist.set(j, temp);
        }
        return arraylist;
    }
}
