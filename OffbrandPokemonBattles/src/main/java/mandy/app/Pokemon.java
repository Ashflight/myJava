package mandy.app;

import java.util.ArrayList;

import static mandy.app.Effect.*;
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
    public Triple useMove(int moveIndex, Type targetType) {
        return moves[moveIndex].use(targetType);
    }
}
class Sylveon extends Pokemon { // Penny's Sylveon. for testing needs.
    public Sylveon() {
        super("Sylveon", new Type[]{FAIRY}, 394, 350, 180, 240);
        setMove(0, "Moonblast", FAIRY, 95, 15, 100, new Pair[] {},
                new Pair[] {new Pair(ATKDB, 30)});
        setMove(1, "Quick Attack", NORMAL, 40, 30, 100, new Pair[] {},
                new Pair[] {}); // I do not know how to do priority moves yet.
        setMove(2, "Shadow Ball", GHOST, 80, 15, 100, new Pair[] {},
                new Pair[] {new Pair(DEFDB, 20)});
        setMove(3, "Baby Doll Eyes", FAIRY, 0, 30, 100, new Pair[] {},
                new Pair[] {new Pair(ATKDB, 100)});
    }
}
