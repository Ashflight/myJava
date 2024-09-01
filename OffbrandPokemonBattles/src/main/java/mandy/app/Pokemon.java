package mandy.app;

import mandy.app.data.Move;
import mandy.app.data.PokemonData;
import mandy.app.data.PokemonDataReader;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class Pokemon {
    // for individual pokemon, like each of the 6 pokemon on you/the opponent's team.
    PokemonData pokemonData;
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
}
