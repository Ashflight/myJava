package mandy.app;

import java.util.Arrays;

public class Board {
    private final String player;
    private final String[][] board;
    private Ship[] ships;
    // stores locations of ships
    // should be printed in a way that prints out only what you're supposed to see
    public Board(String player) {
        this.player = player;
        this.board = new String[10][10];
        for (String[] row : board) {
            Arrays.fill(row, "_");
        }
        this.ships = new Ship[5];
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
    // returns board with ships shown, a ship part is represented by an O if it is still intact and an X if it has already been hit
    public String[] showShips() {
        String[] baseBoard = getBoard();
        StringBuilder builder = null;
        for (Ship ship : ships) {
            for (int i = 0; i < ship.getLocations().length; i++) {
                builder = new StringBuilder(baseBoard[ship.getLocations()[i][0]]);
                if (ship.getHit()[i]) {
                    builder.setCharAt(2 * ship.getLocations()[i][1] + 1, 'X');
                }
                else {
                    builder.setCharAt(2 * ship.getLocations()[i][1] + 1, 'O');
                }
                baseBoard[ship.getLocations()[i][0]] = builder.toString();
            }
        }
        return baseBoard;
    }
    // adds the ships (this allows printing of board with partial or no ships)
    public void addShip(Ship ship) {
        for (int i = 0; i < ships.length; i++) {
            if (ships[i] == null) {
                ships[i] = ship;
                return;
            }
        }
        throw new ArrayIndexOutOfBoundsException("no space for more ships");
    }

    public Ship[] getShips() {
        return ships;
    }
}
