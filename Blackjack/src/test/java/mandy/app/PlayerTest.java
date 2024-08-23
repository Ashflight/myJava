package mandy.app;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static mandy.app.Result.*;
import static mandy.app.Suit.*;
import static mandy.app.Value.*;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    public void testPlayerInit() {
        Deck deck = new Deck();
        Card card1 = deck.peek(0);
        Card card2 = deck.peek(1);
        Card card3 = deck.peek(2);
        Player player = new Player(deck);
        assertEquals(2, player.getHand().size());
        assertEquals(card1, player.getHand().get(0));
        assertEquals(card2, player.getHand().get(1));
        assertEquals(card3, deck.peek(0));
    }
    @Test
    public void testPlayerHit() {
        Deck deck = new Deck();
        Player player = new Player(deck);
        Card card1 = deck.peek(0);
        Card card2 = deck.peek(1);
        player.playTurn("hit", deck);
        assertEquals(3, player.getHand().size());
        assertEquals(card1, player.getHand().get(2));
        assertEquals(card2, deck.peek(0));
    }
    @Test
    public void shouldReturnBustWhenScoreGreatThan21() {
        ArrayList<Card> presetDeck = new ArrayList<>();
        presetDeck.add(new Card(DIAMONDS, QUEEN));
        presetDeck.add(new Card(SPADES, SEVEN));
        presetDeck.add(new Card(HEARTS, EIGHT));
        presetDeck.add(new Card(CLUBS, THREE));
        Deck deck = new Deck(presetDeck);
        Player player = new Player(deck);
        assertEquals(BUST, player.playTurn("hit", deck));
    }
    @Test
    public void shouldReturnWinWhenScoreIs21() {
        ArrayList<Card> presetDeck = new ArrayList<>();
        presetDeck.add(new Card(HEARTS, ACE));
        presetDeck.add(new Card(SPADES, SIX));
        presetDeck.add(new Card(DIAMONDS, FOUR));
        presetDeck.add(new Card(CLUBS, TWO));
        Deck deck = new Deck(presetDeck);
        Player player = new Player(deck);
        assertEquals(WIN, player.playTurn("hit", deck));
    }
    @Test
    public void shouldReturnContinueWhenScoreLessThan21() {
        ArrayList<Card> presetDeck = new ArrayList<>();
        presetDeck.add(new Card(DIAMONDS, QUEEN));
        presetDeck.add(new Card(SPADES, NINE));
        presetDeck.add(new Card(HEARTS, ACE));
        presetDeck.add(new Card(CLUBS, ACE));
        Deck deck = new Deck(presetDeck);
        Player player = new Player(deck);
        assertEquals(CONTINUE, player.playTurn("hit", deck));
    }
    @Test
    public void shouldReturnContinueWhenUserInputStand() {
        ArrayList<Card> presetDeck = new ArrayList<>();
        presetDeck.add(new Card(DIAMONDS, KING));
        presetDeck.add(new Card(SPADES, JACK));
        presetDeck.add(new Card(HEARTS, FIVE));
        presetDeck.add(new Card(CLUBS, NINE));
        Deck deck = new Deck(presetDeck);
        Player player = new Player(deck);
        assertEquals(CONTINUE, player.playTurn("stand", deck));
    }
}
