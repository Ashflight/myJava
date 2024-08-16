package mandy.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BlackjackTest {
    Deck deck = new Deck();
    Player player = new Player(deck);
    @Test
    public void testPlayerHit() {
        assertTrue(player.playTurn("hit", deck), "test player turn method");
    }
}
