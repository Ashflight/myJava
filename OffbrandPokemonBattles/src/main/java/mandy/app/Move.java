package mandy.app;

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
}
