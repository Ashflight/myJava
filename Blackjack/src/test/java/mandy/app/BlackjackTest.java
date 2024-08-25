package mandy.app;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static mandy.app.Suit.*;
import static mandy.app.Value.*;
import static mandy.app.Result.*;
import static org.junit.jupiter.api.Assertions.*;

public class BlackjackTest {
    @Test
    public void test() {
        assertTrue(true, "edit later");
        //User mockUser = Mockito.mock(User.class);
    }

    @Test
    public void testCheckBlackjackCaseClubs() {
        ArrayList<Card> presetDeck = new ArrayList<>();
        presetDeck.add(new Card(SPADES, ACE));
        presetDeck.add(new Card(CLUBS, JACK));
        presetDeck.add(new Card(HEARTS, NINE));
        presetDeck.add(new Card(DIAMONDS, TWO));
        presetDeck.add(new Card(HEARTS, THREE));
        presetDeck.add(new Card(DIAMONDS, SIX));
        presetDeck.add(new Card(CLUBS, FOUR));
        presetDeck.add(new Card(SPADES, KING));
        Deck deck = new Deck(presetDeck);
        Player player = new Player(deck);
        Dealer dealer = new Dealer(deck);
        Blackjack blackjack = new Blackjack(deck, player, dealer);
        assertTrue(blackjack.checkBlackjack());
    }
    @Test
    public void testCheckBlackjackCaseSpades() {
        ArrayList<Card> presetDeck = new ArrayList<>();
        presetDeck.add(new Card(SPADES, ACE));
        presetDeck.add(new Card(SPADES, JACK));
        presetDeck.add(new Card(HEARTS, NINE));
        presetDeck.add(new Card(DIAMONDS, TWO));
        presetDeck.add(new Card(HEARTS, THREE));
        presetDeck.add(new Card(DIAMONDS, SIX));
        presetDeck.add(new Card(CLUBS, FOUR));
        presetDeck.add(new Card(CLUBS, KING));
        Deck deck = new Deck(presetDeck);
        Player player = new Player(deck);
        Dealer dealer = new Dealer(deck);
        Blackjack blackjack = new Blackjack(deck, player, dealer);
        assertTrue(blackjack.checkBlackjack());
    }
    @Test
    public void testPlayerTurn() {
        ArrayList<Card> presetDeck = new ArrayList<>();
        presetDeck.add(new Card(SPADES, NINE));
        presetDeck.add(new Card(CLUBS, TEN));
        presetDeck.add(new Card(HEARTS, ACE));
        presetDeck.add(new Card(DIAMONDS, TWO));
        presetDeck.add(new Card(HEARTS, THREE));
        presetDeck.add(new Card(DIAMONDS, SIX));
        presetDeck.add(new Card(CLUBS, FOUR));
        presetDeck.add(new Card(SPADES, KING));
        Deck deck = new Deck(presetDeck);
        Player player = new Player(deck);
        Dealer dealer = new Dealer(deck);
        Blackjack blackjack = new Blackjack(deck, player, dealer);
        assertEquals(WIN, blackjack.playerTurn("hit"));
    }
    @Test
    public void testDealerTurn() {
        ArrayList<Card> presetDeck = new ArrayList<>();
        presetDeck.add(new Card(SPADES, NINE));
        presetDeck.add(new Card(CLUBS, EIGHT));
        presetDeck.add(new Card(HEARTS, ACE));
        presetDeck.add(new Card(DIAMONDS, TEN));
        presetDeck.add(new Card(HEARTS, THREE));
        presetDeck.add(new Card(DIAMONDS, SIX));
        presetDeck.add(new Card(CLUBS, FOUR));
        presetDeck.add(new Card(SPADES, KING));
        Deck deck = new Deck(presetDeck);
        Player player = new Player(deck);
        Dealer dealer = new Dealer(deck);
        Blackjack blackjack = new Blackjack(deck, player, dealer);
        assertEquals(WIN, blackjack.dealerTurn());
    }
}
