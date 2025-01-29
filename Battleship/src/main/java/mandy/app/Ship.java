package mandy.app;

public class Ship {
    private String name;
    private int[][] locations;
    private boolean[] hit;
    // place ships by picking location of head and whether the ship should be vertical (down from head) or horizontal (right from head)
    // hit array marks which spots of the ship have been hit (default value of boolean is false)
    public Ship(String name, int yHead, int xHead, int size, String direction) {
        this.name = name;
        this.locations = new int[size][2];
        if (direction == "V") {
            for (int i = 0; i < size; i++) {
                locations[i][0] = yHead + i;
                locations[i][1] = xHead;
            }
        }
        else {
            for (int i = 0; i < size; i++) {
                locations[i][0] = yHead;
                locations[i][1] = xHead + i;
            }
        }
        for (int[] location : locations) {
            for (int coord : location) {
                if (coord > 9 || coord < 0) {
                    throw new IllegalArgumentException("Ships cannot be placed with any parts going out of bounds.");
                }
            }
        }
        this.hit = new boolean[size];
    }
    // return true if hit
    public boolean checkHit(int[] coords) {
        for (int i = 0; i < locations.length; i++) {
            if (locations[i][0] == coords[0] && locations[i][1] == coords[1]) {
                hit[i] = true;
                return true;
            }
        }
        return false;
    }
    // return true if sank (all locations hit)
    public boolean checkSink() {
        for (boolean status : hit) {
            if (status == false) {
                return false;
            }
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public int[][] getLocations() {
        return locations;
    }

    public boolean[] getHit() {
        return hit;
    }
}
