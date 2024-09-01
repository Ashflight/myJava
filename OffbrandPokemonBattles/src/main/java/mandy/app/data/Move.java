package mandy.app.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import mandy.app.Effect;
import mandy.app.Triple;
import mandy.app.Type;

import java.util.ArrayList;
import java.util.Random;

public class Move {
    //for tracking each pokemon's moves
    private final String name;
    private final Type type;
    private final int power;
    private int currentPP;
    private final int maxPP;
    private final int accuracy;
    private final int priority;
    private final EffectBundle[] selfEffects;
    private final EffectBundle[] opponentEffects;

    Random random = new Random();

    @JsonCreator
    public Move(@JsonProperty("name") String name, @JsonProperty("type") Type type, @JsonProperty("power") int power,
                @JsonProperty("maxPP") int maxPP, @JsonProperty("accuracy") int accuracy,
                @JsonProperty("priority") int priority, @JsonProperty("selfEffects") EffectBundle[] selfEffects,
                @JsonProperty("opponentEffects") EffectBundle[] opponentEffects) {
        this.name = name;
        this.type = type;
        this.power = power;
        this.currentPP = maxPP;
        this.maxPP = maxPP;
        this.accuracy = accuracy;
        this.priority = priority;
        this.selfEffects = selfEffects;
        this.opponentEffects = opponentEffects;
    }
    public String getName() {
        return name;
    }
    public Type getType() {
        return type;
    }
    public int getPower() {
        return power;
    }
    public int getCurrentPP() {
        return currentPP;
    }
    public int getAccuracy() {
        return accuracy;
    }
    public EffectBundle[] getSelfEffects() {
        return selfEffects;
    }
    public EffectBundle[] getOpponentEffects() {
        return opponentEffects;
    }
    public int getDamage(Type targetType) {
        if (type.getIncrease().contains(targetType)) {
            return power*2;
        }
        else if (type.getDecrease().contains(targetType)) {
            return power/2;
        }
        else if (type.getImmune().contains(targetType)) {
            return 0;
        }
        else {
            return power;
        }
    }
    public ArrayList<mandy.app.Effect> decideEffects(EffectBundle[] allPossibleEffects) {
        ArrayList<Effect> newEffects = new ArrayList<>();
        int randomNumber;
        for (EffectBundle possibleEffect : allPossibleEffects) {
            randomNumber = random.nextInt(100);
            if (randomNumber < possibleEffect.getChance()) {
                newEffects.add(possibleEffect.getEffect());
            }
        }
        return newEffects;
    }
    public boolean checkHit() {
        int randomNumber = random.nextInt(100);
        if (randomNumber < accuracy) {
            return true;
        }
        return false;
    }
    public Triple use(Type targetType) {
        currentPP--;
        return new Triple(getDamage(targetType), decideEffects(selfEffects), decideEffects(opponentEffects));
    }
}
