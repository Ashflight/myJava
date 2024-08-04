package mandy.app;

import org.junit.jupiter.api.Test;

import static mandy.app.Player.X;
import static mandy.app.Result.CONTINUE;
import static org.junit.jupiter.api.Assertions.*;

class Connect4Test {

    Connect4 connect4 = new Connect4();

    @Test
    void testPlayTurn() {
        Result result = connect4.playTurn(X, 3);
        assertEquals(CONTINUE, result, "description xyz");
    }
}