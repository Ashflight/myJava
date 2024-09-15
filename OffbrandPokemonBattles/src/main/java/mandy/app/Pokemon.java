package mandy.app;

import mandy.app.data.PokemonData;
import mandy.app.data.PokemonDataReader;

import java.util.Random;
import java.io.File;
import java.net.URL;
import java.util.List;
import static mandy.app.Effect.*;

public class Pokemon {
    // for individual pokemon, like each of the 6 pokemon on you/the opponent's team.
    PokemonData pokemonData;
    Random random = new Random();

    public Pokemon(String name) {
        // read data from file
        URL resource = Pokemon.class.getResource("/" + name + ".json");
        if (resource != null) {
            // Convert the URL to a File object
            File file = new File(resource.getFile());
            this.pokemonData = PokemonDataReader.readFromFile(file);
        } else {
            throw new RuntimeException("File not found for " + name + ".");
        }
    }

    public AttackEffects useMove(int moveIndex, Type targetType, int opponentDefense) {
        return pokemonData.getMoves().get(moveIndex).use(pokemonData.getTypes(), targetType, pokemonData.getAttack(), opponentDefense);
    }

    public PokemonData getPokemonData() {
        return pokemonData;
    }


    public void manageStatStages(List<Effect> newEffects) {
        for (Effect effect : newEffects) {
            if (effect == ATKBUFF) {
                pokemonData.setAttackStage(pokemonData.getAttackStage() + 1); // move all the text out into game?
                // so it doesn't return messages but generates the messages in the game class
            }
            else if (effect == ATKDB) {
                pokemonData.setAttackStage(pokemonData.getAttackStage() - 1);
            }
            else if (effect == DEFBUFF) {
                pokemonData.setDefenseStage(pokemonData.getDefenseStage() + 1);
            }
            else if (effect == DEFDB) {
                pokemonData.setDefenseStage(pokemonData.getDefenseStage() - 1);
            }
            else if (effect == SPEEDBUFF) {
                pokemonData.setSpeedStage(pokemonData.getSpeedStage() + 1);
            }
            else if (effect == SPEEDDB) {
                pokemonData.setSpeedStage(pokemonData.getSpeedStage() - 1);
            }
        }
    }

    public void addStatus(List<Effect> newEffects) {
        for (Effect effect : newEffects) {
            if (effect == BURN && !getPokemonData().getEffects().contains(BURN)) {
                pokemonData.setAttackStage(pokemonData.getAttackStage()-1);
                pokemonData.addEffect(effect);
            }
            else if (effect == FREEZE && !getPokemonData().getEffects().contains(FREEZE)) {
                pokemonData.addEffect(effect);
            }
            else if (effect == PARALYSIS && !getPokemonData().getEffects().contains(PARALYSIS)) {
                pokemonData.setSpeedStage(pokemonData.getSpeedStage() - 1);
                pokemonData.addEffect(effect);
            }
            else if (effect == POISON) {
                pokemonData.addEffect(effect);
            }
            else if (effect == SLEEP && !getPokemonData().getEffects().contains(SLEEP)) {
                pokemonData.addEffect(effect);
            }
            else if (effect == CONFUSION && !getPokemonData().getEffects().contains(CONFUSION)) {
                pokemonData.addEffect(effect);
            }
        }
    }

    public void checkStatus() {
        int randomInt;
        for (Effect effect : pokemonData.getEffects()) {
            if (effect == BURN) {
                pokemonData.setCurrentHP(pokemonData.getCurrentHP() - pokemonData.getMaxHP()/16);
            }
            else if (effect == FREEZE) {
                randomInt = random.nextInt(100);
                if (randomInt < 20) {
                    pokemonData.removeEffect(FREEZE);
                }
            } //Paralysis has no between turn effect, it cannot wear off on its own and does not deal damage.
            else if (effect == POISON) {
                pokemonData.setCurrentHP(pokemonData.getCurrentHP() - pokemonData.getMaxHP()/16);
            }
            else if (effect == SLEEP) {
                randomInt = random.nextInt(100);
                if (randomInt < 50) { //this isn't the actual way pokemon calculates the amount of time you stay asleep,
                    // but it's easier and last similarly long so. it'll do.
                    pokemonData.removeEffect(SLEEP);
                }
            }
            else if (effect == CONFUSION) {
                randomInt = random.nextInt(100);
                if (randomInt < 30) { //once again this isn't how confusion time is actually calculated, just an approximation
                    pokemonData.removeEffect(CONFUSION);
                }
            }
        }
    }
    public void takeDamage(int damage) {
        pokemonData.setCurrentHP(pokemonData.getCurrentHP() - damage);
    }
}
