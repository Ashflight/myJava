package mandy.app;

import java.util.ArrayList;
import static mandy.app.Type.*;

public class Pokemon {
    // for individual pokemon, like each of the 6 pokemon on you/the opponent's team.
    private final String name;
    private final Type[] type;
    private final int maxHP;
    private int currentHP;
    private final int atk;
    private int atkStage;
    private final int def;
    private int defStage;
    private final int speed;
    private int speedStage;
    private ArrayList<Effect> currentEffects;
    private boolean alive;
    private Move[] moves;
    public Pokemon(String name, Type[] type, int maxHP, int atk, int def, int speed) {
        this.name = name;
        this.type = type;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.atk = atk;
        this.atkStage = 0;
        this.def = def;
        this.defStage = 0;
        this.speed = speed;
        this.speedStage = 1;
        this.alive = true;
        this.currentEffects = new ArrayList<>();
        // I might have to hardcode all the moves, pokemon and trainers as package private classes...
    }
    public void setMove(int index, String name, Type type, int basePower, int maxPP, int accuracy, Pair[] selfEffects,
                        Pair[] opponentEffects) {
        moves[index] = new Move(name, type, basePower, maxPP, accuracy, selfEffects, opponentEffects);
    }
}
class Sylveon extends Pokemon { // Penny's Sylveon. for testing needs.
    public Sylveon() {
        super("Sylveon", new Type[]{FAIRY}, 394, 350, 180, 240);
    }
}
