package mandy.app;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import static mandy.app.Suit.*;
import static mandy.app.Value.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class BlackjackTest {
    @Test
    public void test() {
        assertTrue(true, "edit later");
        //User mockUser = Mockito.mock(User.class);
    }

    @Test
    public void testCheckBlackjack() {
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
}
