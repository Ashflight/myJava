package mandy.app;

import java.util.List;

public enum Preset { //trust I need this to handle the input of team choices
    // mostly because we already configured all the json stuff and I don't want to touch it anymore
    PENNY(List.of("Umbreon", "Leafeon", "Vaporeon", "Jolteon", "Flareon", "Sylveon"));


    private final List<String> teamNames;

    Preset(List<String> teamNames) {
        this.teamNames = teamNames;
    }
}
