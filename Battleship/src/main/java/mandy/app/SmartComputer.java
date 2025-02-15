package mandy.app;

public class SmartComputer extends Computer {
    private boolean targeting;
    private int targetDirection; // can be up (0), down (1), left (2), or right (3)
    private int aimDirection; // same number system as targetDirection;
    private boolean[] checkedDirections; // each term becomes true as its direction is confirmed to not have the ship
    private int[] targetStart;
    private int[] target;

    public SmartComputer() {
        super();
        this.checkedDirections = new boolean[4];
        this.targetDirection = -1; // fixes confounding caused by int default value being 1
        // targeting defaults to false
    }

    @Override
    public int[] getCoords() {
        if (targeting) {
            return target;
        }
        int y = 2 * (int) (5 * Math.random());
        int x = 2 * (int) (5 * Math.random());
        // optimal guessing strategy for when not targeting is to guess in a checkerboard fashion
        while (super.getCoordbank()[y][x]) {
            y = 2 * (int) (5 * Math.random());
            x = 2 * (int) (5 * Math.random());
        }
        super.removeCoord(y, x);
        return new int[]{y, x};
    }

    // call after each shot
    public void checkTargeting(int[] shot, String message) {
        if (message.contains("sank")) {
            // resets system and turns off targeting once target has been sank
            targeting = false;
            checkedDirections = new boolean[4];
            targetDirection = -1;
            return;
        }
        if (message.contains("hit") && !targeting) { // finds a target
            // turn on targeting
            targeting = true;
            // set where target was found
            targetStart = shot;
            // test a random direction
            aimDirection = (int) (4 * Math.random());
            // sets up next shot via target variable
            target = makeTarget(targetStart, aimDirection);
            return;
        }
        if (message.contains("hit")) { // for when targeting is active and a hit has occurred
            // sets up now known target direction
            targetDirection = aimDirection;
            // continue incrementing target
            target = makeTarget(target, targetDirection);
            return;
        }
        if (targeting && targetDirection == -1) { // a miss happens while target direction guessing
            checkedDirections[aimDirection] = true;
            // get new direction to check
            while (checkedDirections[aimDirection]) {
                aimDirection = (int) (4 * Math.random());
            }
            // reset target
            target = makeTarget(targetStart, targetDirection);
            return;
        }
        if (targeting) { // a miss happens while targeting and direction is known due to finding end of ship
            // switches targeting direction to opposite direction
            if (targetDirection == 0) {
                targetDirection = 1;
            }
            else if (targetDirection == 1) {
                targetDirection = 0;
            }
            else if (targetDirection == 2) {
                targetDirection = 3;
            }
            else {
                targetDirection = 2;
            }
            // resets target for next shot
            target = makeTarget(targetStart, targetDirection);
        }
    } // idk if this is an optimal way to do targeting but im praying it works

    private int[] makeTarget(int[] in, int direction) {
        int[] out= new int[2];
        if (direction == 0) {
            out[0] = in[0] - 1;
            out[1] = in[1];
        }
        else if (direction == 1) {
            out[0] = in[0] + 1;
            out[1] = in[1];
        }

        else if (direction == 2) {
            out[0] = in[0];
            out[1] = in[1] - 1;
        }
        else {
            out[0] = in[0];
            out[1] = in[1] + 1;
        }
        return out;
    }
}
