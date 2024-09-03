package mandy.app;

import mandy.app.data.PokemonData;
import mandy.app.data.PokemonDataReader;

import java.util.Random;
import java.util.random.*;
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

    public Triple useMove(int moveIndex, Type targetType) {
        return pokemonData.getMoves().get(moveIndex).use(targetType);
    }

    public PokemonData getPokemonData() {
        return pokemonData;
    }


    public List<String> manageStatStages(List<Effect> newEffects) {
        // separating processing of stat changes and status conditions to make the if else things a bit smaller
        // idk how to implement sharp or drastic change messages yet.
        List<String> messages = List.of();
        for (Effect effect : newEffects) {
            if (effect == ATKBUFF) {
                pokemonData.setAttackStage(pokemonData.getAttackStage() + 1);
                messages.add(getPokemonData().getName() + "'s attack rose!");
            }
            else if (effect == ATKDB) {
                pokemonData.setAttackStage(pokemonData.getAttackStage() - 1);
                messages.add(getPokemonData().getName() + "'s attack dropped!");
            }
            else if (effect == DEFBUFF) {
                pokemonData.setDefenseStage(pokemonData.getDefenseStage() + 1);
                messages.add(pokemonData.getName() + "'s defense rose!");
            }
            else if (effect == DEFDB) {
                pokemonData.setDefenseStage(pokemonData.getDefenseStage() - 1);
                messages.add(pokemonData.getName() + "'s defense dropped!");
            }
            else if (effect == SPEEDBUFF) {
                pokemonData.setSpeedStage(pokemonData.getSpeedStage() + 1);
                messages.add(pokemonData.getName() + "'s speed rose!");
            }
            else if (effect == SPEEDDB) {
                pokemonData.setSpeedStage(pokemonData.getSpeedStage() - 1);
                messages.add(pokemonData.getName() + "'s speed dropped!");
            }
        }
    }

    public List<String> addStatus(List<Effect> newEffects) {
        List<String> messages = List.of();
        for (Effect effect : newEffects) {
            if (effect == BURN) {
                pokemonData.setAttackStage(pokemonData.getAttackStage()-1);
                pokemonData.addEffect(effect);
                messages.add(pokemonData.getName() + " was burned!");
            }
            else if (effect == FREEZE) {
                pokemonData.addEffect(effect);
                messages.add(pokemonData.getName() + " was frozen!");
            }
            else if (effect == PARALYSIS) {
                pokemonData.setSpeedStage(pokemonData.getSpeedStage() - 1);
                pokemonData.addEffect(effect);
                messages.add(pokemonData.getName() + " was paralysed!");
            }
            else if (effect == POISON) {
                pokemonData.addEffect(effect);
                messages.add(pokemonData.getName() + " was poisoned!");
            }
            else if (effect == SLEEP) {
                pokemonData.addEffect(effect);
                messages.add(pokemonData.getName() + " fell asleep!");
            }
            else if (effect == CONFUSION) {
                pokemonData.addEffect(effect);
                messages.add(pokemonData.getName() + " became confused!");
            }
        }
        return messages;
    }

    public List<String> checkStatus() {
        List<String> messages = List.of();
        int randomInt;
        for (Effect effect : pokemonData.getEffects()) {
            if (effect == BURN) {
                pokemonData.setCurrentHP(pokemonData.getCurrentHP() - pokemonData.getMaxHP()/16);
                messages.add(pokemonData.getName() + " was hurt by its burn!");
            }
            else if (effect == FREEZE) {
                randomInt = random.nextInt(100);
                if (randomInt < 20) {
                    pokemonData.removeEffect(FREEZE);
                    messages.add(pokemonData.getName() + " thawed out!");
                }
            } //Paralysis has no between turn effect, it cannot wear off on its own and does not deal damage.
            else if (effect == POISON) {
                pokemonData.setCurrentHP(pokemonData.getCurrentHP() - pokemonData.getMaxHP()/16);
                messages.add(pokemonData.getName() + " was hurt by poisoning!");
            }
            else if (effect == SLEEP) {
                randomInt = random.nextInt(100);
                if (randomInt < 50) { //this isn't the actual way pokemon calculates the amount of time you stay asleep
                    // but it's easier and last similarly long so. it'll do.
                    pokemonData.removeEffect(SLEEP);
                    messages.add(pokemonData.getName() + " woke up!");
                }
            }
            else if (effect == CONFUSION) {
                randomInt = random.nextInt(100);
                if (randomInt < 30) { //once again this isn't how confusion time is actually calculated, just an approximation
                    pokemonData.removeEffect(CONFUSION);
                    messages.add(pokemonData.getName() + " snapped out of its confusion!");
                }
            }
        }
        return messages;
    }
}
