package mandy.app;

import org.junit.jupiter.api.Test;
import static mandy.app.Player.*;
import static mandy.app.Result.*;
import static org.junit.jupiter.api.Assertions.*;

class Connect4Test {

    Connect4 connect4 = new Connect4();

    @Test
    void testPlayTurn() {
        Result result = connect4.playTurn(X, 3);
        assertEquals(CONTINUE, result, "description xyz");
    }

    Player[][] board1 = {{null, null, null, null, null, null, null}, {null, null, null, null, null, null, null},
            {null, null,  null, null, null, null, null}, {null, null, null, X, O, null, null},
            {null, null, null, X, O, null, null}, {null, null, null, X, O, null, null}};
    @Test
    void verticalTestCheckWin() {
        connect4.board.setBoard(board1);
        Result result = connect4.playTurn(X, 3);
        assertEquals(WIN, result, "win checker for verticals");
    }
    Player [][] board2 = {{null, null, null, null, null, null, null}, {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null},
            {null, O, O, O, null, null, null}, {null, X, X, X, null, null, null}};

    @Test
    void horizontalTestCheckWin() {
        connect4.board.setBoard(board2);
        Result result = connect4.playTurn(X, 4);
        assertEquals(WIN, result, "win checker for horizontals");
    }
    Player[][] board3 = {{null, null, null, null, null, null, null}, {null, null, null, null, null, null, null},
        {null, null, null, O, null, null, null}, {null, null, O, X, null, null, null},
        {null, null, O, X, X, null, null}, {null, null, O, X, O, X, null}};
    @Test
    void d1TestCheckWin() {
        connect4.board.setBoard(board3);
        Result result = connect4.playTurn(X, 2);
        assertEquals(WIN, result, "win checker for diagonal going from top left to bottom right");
    }
    Player [][] board4 = {{null, null, null, null, null, null, null}, {null, null, null, null, null, null, null},
        {null, null, null, O, null, null, null}, {null, null, null, X, O, null, null},
        {null, null, X, X, O, null, null}, {null, X, O, X, O, null, null}};

    @Test
    void d2TestCheckWin() {
        connect4.board.setBoard(board4);
        Result result = connect4.playTurn(X, 4);
        assertEquals(WIN, result, "win checker for diagonal going from bottom left to top right");
    }
    Player [][] tieBoard = {{O, X, O, null, O, X, O}, {O, X, O, X, O, X, O}, {O, X, O, X, O, X, O},
            {X, O, X, O, X, O, X}, {X, O, X, O, X, O, X}, {X, O, X, O, X, O, X}};

    @Test
    void tieTestCheckWin() {
        connect4.board.setBoard(tieBoard);
        Result result = connect4.playTurn(X, 3);
        assertEquals(TIE, result, "check for tie");
    }
    @Test
    void XGenerateMessage() {
        String msg = connect4.generateMessage(WIN, X);
        assertEquals("The game has ended, player X won!", msg, "tests generateMessage for X winning");
    }
    @Test
    void OGenerateMessage() {
        String msg = connect4.generateMessage(WIN, O);
        assertEquals("The game has ended, player O won!", msg, "tests generateMessage for O winning");
    }
    @Test
    void tieGenerateMessage() {
        String msg = connect4.generateMessage(TIE, O);
        assertEquals("The game has ended and it is a tie.", msg, "tests generateMessage for a tie");
    }
    @Test
    void continueGenerateMessage() {
        String msg = connect4.generateMessage(CONTINUE, O);
        assertEquals("", msg, "tests generateMessage for continue");
    }
    @Test
    void XGetNextPlayer() {
        Player nextPlayer = connect4.getNextPlayer(X);
        assertEquals(O, nextPlayer, "tests getNextPlayer for X");
    }
    @Test
    void OGetNextPlayer() {
        Player nextPlayer = connect4.getNextPlayer(O);
        assertEquals(X, nextPlayer, "tests getNextPlayer for O");
    }
}