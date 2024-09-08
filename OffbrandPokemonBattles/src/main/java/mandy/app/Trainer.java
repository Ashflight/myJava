package mandy.app;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    // for team management, maybe also item management if I add items. stuff like switching and tracking fainting.
    // also for obvious I don't want to write down every pokemon in existence reasons there shall be a finite number of team options
    // prioritising the rival trio/Arven, Nemona, and Penny, then gen 9 DLC main characters/Carmine and Kieran.
    // then gen 9 gym leaders, BB elite 4, regular elite 4 + Geeta, team star leaders, and finally maybe the academy faculty.
    // should be a random option too ofc
    // basically just pick one out of a bunch of preset copypastas
    // I severely underestimated how complicated this would get

    private final String name;
    private final List<Pokemon> team = new ArrayList<>(); // trust this breaks if it's not arraylist
    private Pokemon lead;

    public Trainer(String name, List<String> teamNames) {
        this.name = name;
        for (String pokemonName : teamNames) {
            team.add(new Pokemon(pokemonName));
        }
        this.lead = team.get(0);
    }

    public void switchPokemon(String name) {
        Pokemon holder;
        for (int i = 0; i < team.size(); i++) {
            if (team.get(i).getPokemonData().getName() == name) {
                holder = team.get(i);
                team.set(i, lead);
                lead = holder;
            }
        }
    }

    public AttackEffects attack() { // TODO actually write something here
        return null;
    } //TODO actually write this

    public void run() {
        // TODO this needs to be done too.
    }

    public String getName() {
        return name;
    }

    public Pokemon getLead() {
        return lead;
    }
}
