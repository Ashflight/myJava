package mandy.app.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import mandy.app.Effect;
import mandy.app.AttackEffects;
import mandy.app.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Move {
    //for tracking each pokemon's moves
    //TODO implement recoil (Penny's Flareon's Flare Blitz move currently does not have recoil)
    //TODO implement fire spin residual damage (Penny's Flareon's Fire Spin move currently does not have its unique effect)
    //TODO implement multi-hit (Penny's Jolteon's Pin Missile move currently does not have working multi-hit)
    //TODO implement critical hits and moves with increased crit chance (like Penny's Leafeon's Leaf Blade move)
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
    public int getDamage(List<Type> userType, Type targetType, int attack, int opponentDefense) {
        int rawDamage;
        if (type.getIncrease().contains(targetType)) {
            rawDamage = power*2*attack/opponentDefense;
        }
        else if (type.getDecrease().contains(targetType)) {
            rawDamage = power*attack/2/opponentDefense;
        }
        else if (type.getImmune().contains(targetType)) {
            return 0;
        }
        else {
            rawDamage = power*attack/opponentDefense;
        }
        if (userType.contains(type)) {
            return (int) (rawDamage*1.5f);
        }
        else {
            return rawDamage;
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
    public AttackEffects use(List<Type> userType, Type targetType, int attack, int opponentDefense) {
        currentPP--;
        return new AttackEffects(getDamage(userType, targetType, attack, opponentDefense), decideEffects(selfEffects), decideEffects(opponentEffects));
    }
}
