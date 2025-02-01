package mandy.app;

public class Computer { // rather unintelligent computer opponent that randomly shoots
    private final boolean[][] coordbank;

    public Computer() {
        this.coordbank = new boolean[10][10]; // starts as all false
    }

    public int[] getCoords() {
        int y = (int) (10 * Math.random());
        int x = (int) (10 * Math.random());
        while (coordbank[y][x]) {
            y = (int) (10 * Math.random());
            x = (int) (10 * Math.random());
        }
        coordbank[y][x] = true;
        return new int[]{y, x};
    }
    public void randomizeShips(Board board) {
        String[] shipNames = {"Carrier", "Battleship", "Submarine", "Destroyer", "Patrol Boat"};
        int[] shipSizes = {5, 4, 3, 3, 2};
        boolean placed = false;
        Ship ship = null;
        for (int i = 0; i < 5; i++) {
            while (!placed) {
                int yHead = (int) (10 * Math.random());
                int xHead = (int) (10 * Math.random());
                int hold = (int) (2 * Math.random());
                String direction;
                if (hold == 0) {
                    direction = "V";
                }
                else {
                    direction = "H";

                }
                try {
                    ship = new Ship(shipNames[i], yHead, xHead, shipSizes[i], direction);
                }
                catch (IllegalArgumentException e) {
                    placed = true;
                }
                // this mess is to prevent ships from being placed overlapping
                if (ship != null) {
                    for (int[] location1 : ship.getLocations()) {
                        for (Ship placedShip : board.getShips()) {
                            if (placedShip == null) {
                                break;
                            }
                            for (int[] location2 : placedShip.getLocations()) {
                                if (location1[0] == location2[0] && location1[1] == location2[1]) {
                                    placed = true;
                                }
                            }
                        }
                    }
                }
                placed = !placed;
            }
            board.addShip(ship);
            placed = false;
        }
    }}
