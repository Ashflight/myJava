package mandy.app;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static mandy.app.Result.*;
import static mandy.app.Suit.*;
import static mandy.app.Value.*;
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
    public void shouldBustWhenScoreGreatThan21() {
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
    public void shouldWinWhenScoreIs21() {
        ArrayList<Card> presetDeck = new ArrayList<>();
        presetDeck.add(new Card(DIAMONDS, KING));
        presetDeck.add(new Card(SPADES, ACE));
        presetDeck.add(new Card(HEARTS, NINE));
        presetDeck.add(new Card(CLUBS, THREE));
        Deck deck = new Deck(presetDeck);
        Dealer dealer = new Dealer(deck);
        assertEquals(WIN, dealer.playTurn(deck, 17));
        assertEquals(2, dealer.getHand().size());
    }
    @Test
    public void shouldWinWhenScoreGreatThanPlayerScore() {
        ArrayList<Card> presetDeck = new ArrayList<>();
        presetDeck.add(new Card(DIAMONDS, FIVE));
        presetDeck.add(new Card(SPADES, NINE));
        presetDeck.add(new Card(HEARTS, FIVE));
        presetDeck.add(new Card(CLUBS, THREE));
        Deck deck = new Deck(presetDeck);
        Dealer dealer = new Dealer(deck);
        assertEquals(WIN, dealer.playTurn(deck, 18));
        assertEquals(3, dealer.getHand().size());
    }
    @Test
    public void shouldTieWhenScoreEqualsPlayerScore() {
        ArrayList<Card> presetDeck = new ArrayList<>();
        presetDeck.add(new Card(DIAMONDS, SEVEN));
        presetDeck.add(new Card(SPADES, THREE));
        presetDeck.add(new Card(HEARTS, NINE));
        presetDeck.add(new Card(CLUBS, SIX));
        Deck deck = new Deck(presetDeck);
        Dealer dealer = new Dealer(deck);
        assertEquals(TIE, dealer.playTurn(deck, 19));
        assertEquals(3, dealer.getHand().size());
    }
}
