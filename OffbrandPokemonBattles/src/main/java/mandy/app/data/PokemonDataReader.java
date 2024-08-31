package mandy.app.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class PokemonDataReader {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static PokemonData readFromFile(File file) {
        try {
            PokemonData data = objectMapper.readValue(file, PokemonData.class);
            return data;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
