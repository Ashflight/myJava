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

    public boolean[][] getCoordbank() {
        return coordbank;
    }

    public void removeCoord(int[] coords) {
        coordbank[coords[0]][coords[1]] = true;
    }

    public void removeCoord(int y, int x) {
        coordbank[y][x] = true;
    }
}