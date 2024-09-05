package mandy.app.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import mandy.app.Effect;
import mandy.app.Type;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokemonData {

//    private static HashMap<Integer, Float> stagesConverter = (HashMap<Integer, Float>)Map.of(
//            -6, 1f/3f,
//            -5, 2f/5f
//    );
    private static HashMap<Integer, Float> stagesConverter = new HashMap<>();
    static {
        stagesConverter.put(-6, 1f/4f);
        stagesConverter.put(-5, 2f/7f);
        stagesConverter.put(-4, 1f/3f);
        stagesConverter.put(-3, 2f/5f);
        stagesConverter.put(-2, 1f/2f);
        stagesConverter.put(-1, 2f/3f);
        stagesConverter.put(0, 1f);
        stagesConverter.put(1, 3f/2f);
        stagesConverter.put(2, 2f);
        stagesConverter.put(3, 5f/2f);
        stagesConverter.put(4, 3f);
        stagesConverter.put(5, 7f/2f);
        stagesConverter.put(6, 4f);
    }

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
    private List<Effect> effects;

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
        this.effects = List.of();
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
        return (int) (attack*stagesConverter.get(attackStage));
    }

    public int getAttackStage() {
        return attackStage;
    }

    public void setAttackStage(int attackStage) {
        this.attackStage = attackStage;
    }

    public int getDefense() {
        return (int) (defense*stagesConverter.get(defenseStage));
    }

    public int getDefenseStage() {
        return defenseStage;
    }

    public void setDefenseStage(int defenseStage) {
        this.defenseStage = defenseStage;
    }

    public int getSpeed() {
        return (int) (speed*stagesConverter.get(speedStage));
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

    public List<Effect> getEffects() {
        return effects;
    }

    public void addEffect(Effect effect) {
        if (!effects.contains(effect)) {
            effects.add(effect);
        }
    }

    public void removeEffect(Effect effect) {
        for (Effect currentEffect : effects) {
            if (currentEffect == effect) {
                effects.remove(currentEffect);
            }
        }
    }
}
