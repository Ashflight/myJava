package mandy.app;

import mandy.app.data.Move;
import mandy.app.data.PokemonData;

import java.util.ArrayList;

public class Pokemon {
    // for individual pokemon, like each of the 6 pokemon on you/the opponent's team.
    private final String name;
//    private final Type[] type;
//    private final int maxHP;
//    private int currentHP;
//    private final int atk;
//    private int atkStage;
//    private final int def;
//    private int defStage;
//    private final int speed;
//    private int speedStage;
//    private ArrayList<Effect> currentEffects;
//    private boolean alive;
    private Move[] moves;
    PokemonData pokemonData;
    public Pokemon(String name) {
        this.name = name;
        // read data from file
    }

    public Pokemon(PokemonData pokemonData, String name) {

        this.name = name;
    }

    public void setMove(int index, String name, Type type, int basePower, int maxPP, int accuracy, Pair[] selfEffects,
                        Pair[] opponentEffects) {
        moves[index] = new Move(name, type, basePower, maxPP, accuracy, selfEffects, opponentEffects);
    }
    public Triple useMove(int moveIndex, Type targetType) {
        return moves[moveIndex].use(targetType);
    }
}
