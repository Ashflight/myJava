package mandy.app;

public class SmartComputer extends Computer {
    private boolean targeting;
    private int targetSize;
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
            // resets system and turns of targeting once target has been sank
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
            // recognize target ship type and size
            String[] messageParts = message.split(" ");
            String shipHit = messageParts[2];
            if (shipHit.equals("Carrier")) {
                targetSize = 5;
            }
            else if (shipHit.equals("Battleship")) {
                targetSize = 4;
            }
            else if (shipHit.equals("Patrol Boat")) {
                targetSize = 2;
            }
            else {
                targetSize = 3;
            }
            // test a random direction
            aimDirection = (int) (4 * Math.random());
            // sets up next shot via target variable
            target = new int[2];
            if (aimDirection == 0) {
                target[0] = targetStart[0] - 1;
                target[1] = targetStart[1];
            }
            else if (aimDirection == 1) {
                target[0] = targetStart[0] + 1;
                target[1] = targetStart[1];
            }

            else if (aimDirection == 2) {
                target[0] = targetStart[0];
                target[1] = targetStart[1] - 1;
            }
            else {
                target[0] = targetStart[0];
                target[1] = targetStart[1] + 1;
            }
            return;
        }
        if (message.contains("hit")) { // for when targeting is active and a hit has occurred
            // sets up now known target direction
            targetDirection = aimDirection;
            // continue incrementing target
            if (targetDirection == 0) {
                target[0] = target[0] - 1;
            }
            else if (targetDirection == 1) {
                target[0] = target[0] + 1;
            }

            else if (targetDirection == 2) {
                target[1] = target[1] - 1;
            }
            else {
                target[1] = target[1] + 1;
            }
            return;
        }
        if (targeting && targetDirection == -1) { // a miss happens while target direction guessing
            checkedDirections[aimDirection] = true;
            // get new direction to check
            while (checkedDirections[aimDirection]) {
                aimDirection = (int) (4 * Math.random());
            }
            // reset target (might turn target setting into a method later for conciseness)
            if (aimDirection == 0) {
                target[0] = targetStart[0] - 1;
                target[1] = targetStart[1];
            }
            else if (aimDirection == 1) {
                target[0] = targetStart[0] + 1;
                target[1] = targetStart[1];
            }

            else if (aimDirection == 2) {
                target[0] = targetStart[0];
                target[1] = targetStart[1] - 1;
            }
            else {
                target[0] = targetStart[0];
                target[1] = targetStart[1] + 1;
            }
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
            if (aimDirection == 0) {
                target[0] = targetStart[0] - 1;
                target[1] = targetStart[1];
            }
            else if (aimDirection == 1) {
                target[0] = targetStart[0] + 1;
                target[1] = targetStart[1];
            }

            else if (aimDirection == 2) {
                target[0] = targetStart[0];
                target[1] = targetStart[1] - 1;
            }
            else {
                target[0] = targetStart[0];
                target[1] = targetStart[1] + 1;
            }
        }
    } // this iss an enormous mess and idk if it works AT ALL and it probably needs tidying up but it is what it is right now
}
