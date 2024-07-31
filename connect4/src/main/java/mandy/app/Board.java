package mandy.app;

import static mandy.app.Result.*;

public class Board {

    private final String[][] board = new String[6][7];

    public Board() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = "_";
            }
        }
    }
    public void printBoard() {
        System.out.println();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print("|" + board[i][j]);
            }
            System.out.println("|");
        }
    }

    public Object[][] getBoard() {
        return board;
    }

    public void addStone(String player, int x) {
        for (int y = 5; y >= 0; y--) {
            if (board[y][x].equals("_")) {
                board[y][x] = player;
                break;
            }
        }
        System.out.print("Player " + player + " placed a stone in column " + x + ".");
    }
    public Result checkWin(String player) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j].equals(player)) {
                    if (board[i][j + 1].equals(player) && board[i][j + 2].equals(player) && board[i][j + 3].equals(player)) {
                        return WIN;
                    }
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if (board[i][j].equals(player)) {
                    if (board[i + 1][j].equals(player) && board[i + 2][j].equals(player) && board[i + 3][j].equals(player)) {
                        return WIN;
                    }
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j].equals(player)) {
                    if (board[i + 1][j + 1].equals(player) && board[i + 2][j + 2].equals(player) && board[i + 3][j + 3].equals(player)) {
                        return WIN;
                    }
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 7; j++) {
                if (board[i][j].equals(player)) {
                    if (board[i + 1][j - 1].equals(player) && board[i + 2][j - 2].equals(player) && board[i + 3][j - 3].equals(player)) {
                        return WIN;
                    }
                }
            }
        }
        boolean notFull = false;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (board[i][j].equals("_")) {
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
