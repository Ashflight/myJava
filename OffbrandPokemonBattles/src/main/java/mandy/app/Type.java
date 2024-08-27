package mandy.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Type {
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

    private final List<String> increase;
    private final List<String> decrease;
    private final List<String> immune;

    Type(String increaseString, String decreaseString, String immuneString) {
        this.increase = Arrays.asList(increaseString.split(" "));
        this.decrease = Arrays.asList(decreaseString.split(" "));
        this.immune = Arrays.asList(immuneString.split(" "));
    }

    public List<Type> getIncrease() {
        return convertToEnum(increase);
    }

    public List<Type> getDecrease() {
        return convertToEnum(decrease);
    }

    public List<Type> getImmune() {
        return convertToEnum(immune);
    }

    private List<Type> convertToEnum(List<String> starterString) {
        // return starterString.stream().map(Type::valueOf).toList();
        List<Type> resultList = new ArrayList<>();
        for (String s : starterString) {
            if (!s.equals("")) {
                resultList.add(Type.valueOf(s));
            }
        }
        return resultList;
    }
}