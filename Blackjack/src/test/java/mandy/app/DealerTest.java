package mandy.app;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static mandy.app.Result.BUST;
import static mandy.app.Suit.*;
import static mandy.app.Suit.CLUBS;
import static mandy.app.Value.*;
import static mandy.app.Value.THREE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DealerTest {
    @Test
    public void testDealerInit() {
        Deck deck = new Deck();
        Card card1 = deck.peek(0);
        Card card2 = deck.peek(1);
        Dealer dealer = new Dealer(deck);
        assertEquals(1, dealer.getHand().size());
        assertEquals(card1, dealer.getHand().get(0));
        assertEquals(card2, deck.peek(0));
    }
    @Test
    public void shouldBustWhenOver21() {
        ArrayList<Card> presetDeck = new ArrayList<>();
        presetDeck.add(new Card(DIAMONDS, QUEEN));
        presetDeck.add(new Card(SPADES, SIX));
        presetDeck.add(new Card(HEARTS, EIGHT));
        presetDeck.add(new Card(CLUBS, THREE));
        Deck deck = new Deck(presetDeck);
        Dealer dealer = new Dealer(deck);
        assertEquals(BUST, dealer.playTurn(deck, 17));
        assertEquals(3, dealer.getHand().size());
    }
    @Test
    public void checkPlayerScoreEffect() {
        ArrayList<Card> presetDeck = new ArrayList<>();
        presetDeck.add(new Card(DIAMONDS, QUEEN));
        presetDeck.add(new Card(SPADES, FIVE));
        presetDeck.add(new Card(HEARTS, THREE));
        presetDeck.add(new Card(CLUBS, FOUR));
        presetDeck.add(new Card(HEARTS, TWO));
        Deck deck = new Deck(presetDeck);
        Dealer dealer = new Dealer(deck);
        assertEquals(BUST, dealer.playTurn(deck, 19));
        assertEquals(4, dealer.getHand().size());
    }
    @Test
    public void shouldWinWhen21() {
        ArrayList<Card> presetDeck = new ArrayList<>();
        presetDeck.add(new Card(DIAMONDS, QUEEN));
        presetDeck.add(new Card(SPADES, SIX));
        presetDeck.add(new Card(HEARTS, EIGHT));
        presetDeck.add(new Card(CLUBS, THREE));
        Deck deck = new Deck(presetDeck);
        Dealer dealer = new Dealer(deck);
        assertEquals(BUST, dealer.playTurn(deck, 17));
        assertEquals(3, dealer.getHand().size());
    }
}
