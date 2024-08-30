package mandy.app.data;

import mandy.app.Effect;
import mandy.app.Pair;
import mandy.app.Triple;
import mandy.app.Type;

import java.util.ArrayList;
import java.util.Random;

public class Move {
    //for tracking each pokemon's moves
    private final String name;
    private final Type type;
    private final int power;
    private final int pp;
    private final int accuracy;
    private final Pair[] selfEffects;
    private final Pair[] opponentEffects;
    public Move(String name, Type type, int basePower, int maxPP, int accuracy, Pair[] selfEffects,
                Pair[] opponentEffects) {
        this.name = name;
        this.type = type;
        this.power = basePower;
        this.pp = maxPP;
        this.accuracy = accuracy;
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
    public int getPp() {
        return pp;
    }
    public int getAccuracy() {
        return accuracy;
    }
    public Pair[] getSelfEffects() {
        return selfEffects;
    }
    public Pair[] getOpponentEffects() {
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
    public ArrayList<mandy.app.Effect> decideEffects(Pair[] allPossibleEffects) {
        ArrayList<Effect> newEffects = new ArrayList<>();
        int randomNumber;
        Random random = new Random();
        for (Pair possibleEffect : allPossibleEffects) {
            randomNumber = random.nextInt(100);
            if (randomNumber < possibleEffect.chance()) {
                newEffects.add(possibleEffect.effect());
            }
        }
        return newEffects;
    }
    public Triple use(Type targetType) {
        return new Triple(getDamage(targetType), decideEffects(selfEffects), decideEffects(opponentEffects));
    }
}
