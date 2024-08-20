package mandy.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
