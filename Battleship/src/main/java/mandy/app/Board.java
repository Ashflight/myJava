package mandy.app;

import java.util.Arrays;

public class Board {
    private final String player;
    private final String[][] board;
    private final Ship[] ships;
    // stores locations of ships
    // should be printed in a way that prints out only what you're supposed to see
    public Board(String player, Ship[] ships) {
        this.player = player;
        this.board = new String[10][10];
        for (String[] row : board) {
            Arrays.fill(row, "_");
        }
        this.ships = ships;
    }
    // shoots at location on board, returns a string that describes the result
    public String shoot(int[] coords) {
        for (Ship ship : ships) {
            boolean hit = ship.checkHit(coords);
            if (hit) {
                board[coords[0]][coords[1]] = "H";
            }
            if (ship.checkSink()) {
                return (player + "'s " + ship.getName() + " has been hit, and it sank.");
            }
            else if (hit) {
                return (player + "'s " + ship.getName() + " has been hit.");
            }
        }
        board[coords[0]][coords[1]] = "M";
        return (player + " missed.");
    }
    // returns true if all ships have sunk
    public boolean checkLoss() {
        for (Ship ship : ships) {
            if (!ship.checkSink()) {
                return false;
            }
        }
        return true;
    }
    // returns printable board
    public String[] getBoard() {
        String[] printableBoard = new String[10];
        String row;
        for (int i = 0; i < 10; i++) {
            row = "|";
            for (String item : board[i]) {
                row = row + item + "|";
            }
            printableBoard[i] = row;
        }
        return printableBoard;
    }
}
