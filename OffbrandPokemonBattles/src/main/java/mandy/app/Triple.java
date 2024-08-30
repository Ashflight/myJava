package mandy.app;

import java.util.ArrayList;

public record Triple(int damage, ArrayList<Effect> selfEffects, ArrayList<Effect> opponentEffects) {
}
// basically a java three term tuple
// trust I also need this for moves to work