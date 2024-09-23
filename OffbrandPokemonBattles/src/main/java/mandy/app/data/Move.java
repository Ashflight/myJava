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
    // for tracking each pokemon's moves
    // TODO code for when a recoil move is used
    // TODO implement fire spin residual damage (Penny's Flareon's Fire Spin move currently does not have its unique effect)
    // honestly if this is that hard to do just swap it for a burn or something
    // TODO code for when a multi-hit move is used
    // TODO code crits
    private final String name;
    private final Type type;
    private final int power;
    private int currentPP;
    private final int maxPP;
    private final int accuracy;
    private final int priority;
    private final EffectBundle[] selfEffects;
    private final EffectBundle[] opponentEffects;
    private final int recoil;
    private final int hits;
    private final int critRate;

    Random random = new Random();

    @JsonCreator
    public Move(@JsonProperty("name") String name, @JsonProperty("type") Type type, @JsonProperty("power") int power,
                @JsonProperty("maxPP") int maxPP, @JsonProperty("accuracy") int accuracy,
                @JsonProperty("priority") Integer priority, @JsonProperty("selfEffects") EffectBundle[] selfEffects,
                @JsonProperty("opponentEffects") EffectBundle[] opponentEffects, @JsonProperty("recoil") Integer recoil,
                @JsonProperty("hits") Integer hits, @JsonProperty("critRate") Integer critRate) {
        this.name = name;
        this.type = type;
        this.power = power;
        this.currentPP = maxPP;
        this.maxPP = maxPP;
        this.accuracy = accuracy;
        this.selfEffects = selfEffects;
        this.opponentEffects = opponentEffects;
        this.priority = (priority != null) ? priority : 0;
        this.recoil = (recoil != null) ? recoil : 0;
        this.hits = (hits != null) ? hits : 1;
        this.critRate = (critRate != null) ? critRate : 4; // APPROXIMATELY
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

    public int getMaxPP() {
        return maxPP;
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
        return randomNumber < accuracy;
    }
    public AttackEffects use(List<Type> userType, Type targetType, int attack, int opponentDefense) {
        currentPP--;
        return new AttackEffects(getDamage(userType, targetType, attack, opponentDefense), decideEffects(selfEffects), decideEffects(opponentEffects));
    }
}
