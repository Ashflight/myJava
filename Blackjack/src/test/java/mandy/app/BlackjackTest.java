package mandy.app;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import static mandy.app.Suit.*;
import static mandy.app.Value.*;
import static mandy.app.Result.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
        //Given
        Deck deck = Mockito.mock(Deck.class);
        Player player = Mockito.mock(Player.class);
        Dealer dealer = Mockito.mock(Dealer.class);
        Blackjack blackjack = new Blackjack(deck, player, dealer);
        when(player.playTurn(eq("hit"), eq(deck))).thenReturn(WIN);

        //When
        Result result = blackjack.playerTurn("hit");

        //Then
        assertEquals(WIN, result);
        verify(dealer, times(0)).playTurn(any(), anyInt());
    }
    @Test
    public void testDealerTurn() {
        Deck deck = Mockito.mock(Deck.class);
        Player player = Mockito.mock(Player.class);
        Dealer dealer = Mockito.mock(Dealer.class);
        Blackjack blackjack = new Blackjack(deck, player, dealer);
        int score = 17;
        when(player.getScore()).thenReturn(score);
        when(dealer.playTurn(eq(deck), eq(score))).thenReturn(WIN);

        Result result = blackjack.dealerTurn();

        assertEquals(WIN, result);
    }
}
