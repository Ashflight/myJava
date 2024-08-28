package mandy.app;

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
    private boolean alive;
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
        // i have no idea how i'm going to get enough data for each of the moves this got way more complicated than i thought
    }
}
