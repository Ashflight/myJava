package mandy.app;

import org.junit.jupiter.api.Test;

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
}
