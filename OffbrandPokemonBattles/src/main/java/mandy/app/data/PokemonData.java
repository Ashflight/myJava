package mandy.app.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import mandy.app.Type;

import java.util.List;

public class PokemonData {

    private final String name;
    private final int maxHP;
    private int currentHP;
    private final int attack;
    private int attackStage;
    private final int defense;
    private int defenseStage;
    private final int speed;
    private int speedStage;
    private final List<Type> types;
    private final List<Move> moves;

    @JsonCreator
    public PokemonData(@JsonProperty("name") String name, @JsonProperty("maxHP") int maxHP, @JsonProperty("attack") int attack,
                       @JsonProperty("defense") int defense, @JsonProperty("speed") int speed,
                       @JsonProperty("types") List<Type> types, @JsonProperty("moves") List<Move> moves) {
        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.attack = attack;
        this.attackStage = 0;
        this.defense = defense;
        this.defenseStage = 0;
        this.speed = speed;
        this.speedStage = 0;
        this.types = types;
        this.moves = moves;
    }

    // Getters and Setters

    public int getMaxHP() {
        return maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getAttack() {
        return attack;
    }

    public int getAttackStage() {
        return attackStage;
    }

    public void setAttackStage(int attackStage) {
        this.attackStage = attackStage;
    }

    public int getDefense() {
        return defense;
    }

    public int getDefenseStage() {
        return defenseStage;
    }

    public void setDefenseStage(int defenseStage) {
        this.defenseStage = defenseStage;
    }

    public int getSpeed() {
        return speed;
    }

    public int getSpeedStage() {
        return speedStage;
    }

    public void setSpeedStage(int speedStage) {
        this.speedStage = speedStage;
    }

    public String getName() {
        return name;
    }

    public List<Type> getTypes() {
        return types;
    }

    public List<Move> getMoves() {
        return moves;
    }
}
