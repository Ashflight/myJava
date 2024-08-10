package mandy.app;
import java.util.Scanner;

import static mandy.app.Player.*;
import static mandy.app.Result.*;

public class Connect4 {

    Board board;
    public Connect4() {
        board = new Board();
        board.printBoard();
    }

    public Result playTurn(Player player, int col) {
        addStone(player, col);
        return checkWin(player);
    }

    private void addStone(Player player, int input) {
        board.addStone(player, input);
        board.printBoard();
    }

    public String generateMessage(Result result, Player player) {
        if (result == WIN) {
            return ("The game has ended, player " + player.toString() + " won!");
        }
        else if (result == TIE) {
            return "The game has ended and it is a tie.";
        }
        else {
            return "";
        }
        }

    public Player getNextPlayer(Player player) {
        if (player == X) {
            return O;
        }
        else {
            return X;
        }
    }

    public Result checkWin(Player player) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (player==board.getBoard()[i][j]) {
                    if (player==board.getBoard()[i][j + 1] && board.getBoard()[i][j + 2]==player && board.getBoard()[i][j + 3]==player) {
                        return WIN;
                    }
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if (board.getBoard()[i][j]==player) {
                    if (board.getBoard()[i + 1][j]==player && board.getBoard()[i + 2][j]==player && board.getBoard()[i + 3][j]==player) {
                        return WIN;
                    }
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (board.getBoard()[i][j]==player) {
                    if (board.getBoard()[i + 1][j + 1]==player && board.getBoard()[i + 2][j + 2]==player && board.getBoard()[i + 3][j + 3]==player) {
                        return WIN;
                    }
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 7; j++) {
                if (board.getBoard()[i][j]==player) {
                    if (board.getBoard()[i + 1][j - 1]==player && board.getBoard()[i + 2][j - 2]==player && board.getBoard()[i + 3][j - 3]==player) {
                        return WIN;
                    }
                }
            }
        }
        boolean notFull = false;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (board.getBoard()[i][j] == null) {
                    notFull = true;
                    break;
                }
            }
        }
        if (notFull) {
            return CONTINUE;
        }
        else {
            return TIE;
        }
    }
}
