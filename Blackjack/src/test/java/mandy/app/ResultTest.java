package mandy.app;

import org.junit.jupiter.api.Test;
import static mandy.app.Result.*;
import static org.junit.jupiter.api.Assertions.*;

public class ResultTest {
    @Test
    public void testFlipResult() {
        assertEquals(BUST, flipResult(WIN));
        assertEquals(WIN, flipResult(BUST));
        assertEquals(CONTINUE, flipResult(CONTINUE));
    }
    @Test
    public void testIsRoundTerminated() {
        assertTrue(isRoundTerminated(WIN));
        assertTrue(isRoundTerminated(BUST));
        assertTrue(isRoundTerminated(BLACKJACK));
        assertTrue(isRoundTerminated(TIE));
        assertFalse(isRoundTerminated(CONTINUE));
    }
}
