package mandy.app;

import java.util.ArrayList;

import static java.util.Arrays.*;

public enum Type { // the type chart
    // increased means moves of the type deal 2x damage to pokemon of these types
    // decreased means moves of the type deal 0.5x damage to pokemon of these types
    // immune means moves of the type deal no damage to pokemon of these types
    // convoluted i know but DEAL WITH IT
    NORMAL("", "ROCK STEEL", "GHOST"),
    FIRE("GRASS ICE BUG STEEL", "FIRE WATER ROCK DRAGON", ""),
    WATER("FIRE GROUND ROCK", "WATER GRASS DRAGON", ""),
    GRASS("WATER GROUND ROCK", "FIRE GRASS POISON FLYING BUG DRAGON STEEL", ""),
    ELECTRIC("WATER FLYING", "GRASS ELECTRIC DRAGON", "GROUND"),
    ICE("GRASS GROUND FLYING DRAGON", "FIRE WATER ICE STEEL", ""),
    FIGHTING("NORMAL ICE ROCK DARK STEEL", "POISON FLYING PSYCHIC BUG FAIRY", "GHOST"),
    POISON("GRASS FAIRY", "POISON ROCK GROUND GHOST", "STEEL"),
    GROUND("FIRE ELECTRIC POISON ROCK STEEL", "GRASS BUG", "FLYING"),
    FLYING("GRASS FIGHTING BUG", "ELECTRIC ROCK STEEL", ""),
    PSYCHIC("FIGHTING POISON", "PSYCHIC STEEL", "DARK"),
    BUG("GRASS PSYCHIC DARK", "FIRE FIGHTING POISON FLYING GHOST STEEL FAIRY", ""),
    ROCK("FIRE ICE FLYING BUG", "FIGHTING GROUND STEEL", ""),
    GHOST("PSYCHIC GHOST", "DARK", "NORMAL"),
    DRAGON("DRAGON", "STEEL", "FAIRY"),
    DARK("PSYCHIC GHOST", "FIGHTING DARK FAIRY", ""),
    STEEL("ICE ROCK FAIRY", "FIRE WATER ELECTRIC STEEL", ""),
    FAIRY("FIGHTING DRAGON DARK", "FIRE POISON STEEL", "");

    private final ArrayList<Type> increase;
    private final ArrayList<Type> decrease;
    private final ArrayList<Type> immune;

    Type(String increase, String decrease, String immune) {
        String[] stringArray = increase.split(" ");
        ArrayList<String> stringList = new ArrayList<>(asList(stringArray));
        ArrayList<Type> resistanceList = new ArrayList<>();
        for (String string : stringList) {
            resistanceList.add(Type.valueOf(string));
        }
        this.increase = resistanceList;

        stringArray = decrease.split(" ");
        stringList = new ArrayList<>(asList(stringArray));
        ArrayList<Type> weaknessList = new ArrayList<>();
        for (String string : stringList) {
            weaknessList.add(Type.valueOf(string));
        }
        this.decrease = weaknessList;

        stringArray = immune.split(" ");
        stringList = new ArrayList<>(asList(stringArray));
        ArrayList<Type> immunityList = new ArrayList<>();
        for (String string : stringList) {
            immunityList.add(Type.valueOf(string));
        }
        this.immune = immunityList;
    }

    public ArrayList<Type> getIncrease() {
        return increase;
    }

    public ArrayList<Type> getDecrease() {
        return decrease;
    }

    public ArrayList<Type> getImmune() {
        return immune;
    }
}