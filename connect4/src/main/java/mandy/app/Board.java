package mandy.app;

import static mandy.app.Result.*;

public class Board {

    private Player[][] board = new Player[6][7];

    public Board() {
    }

    public void printBoard() {
        System.out.println();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                String symbol = board[i][j] == null ? "_" : board[i][j].toString() ;
                System.out.print("|" + symbol);
            }
            System.out.println("|");
        }
    }

    public Player[][] getBoard() {
        return board;
    }

    public void setBoard(Player[][] newBoard) {
        board = newBoard;
    }

    public void addStone(Player player, int x) {
        for (int y = 5; y >= 0; y--) {
            if (board[y][x] == null) {
                board[y][x] = player;
                break;
            }
        }
        System.out.print("Player " + player + " placed a stone in column " + x + ".");
    }
}
