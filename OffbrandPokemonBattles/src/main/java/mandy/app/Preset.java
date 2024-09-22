package mandy.app;

import java.util.List;
import java.util.Random;

public enum Preset { //trust I need this to handle the input of team choices
    // mostly because we already configured all the json stuff and I don't want to touch it anymore
    // since Nemona's ace is the starter weak to yours, her ace will be a random one of the 3 starters
    ARVEN(List.of("Greedent", "Cloyster", "Scovillain", "Toedscruel", "Garganacl", "Mabostiff")),
    NEMONA(List.of("Lycanroc Midday", "Goodra", "Dudunsparce", "Orthworm", "Pawmot", "RandomStarter")),
    PENNY(List.of("Umbreon", "Leafeon", "Vaporeon", "Jolteon", "Flareon", "Sylveon"));
    // TODO add json for Arven and Nemona's pokemon
    // already did Greedent and Lycanroc Midday

    Random random = new Random();
    private final List<String> teamNames;

    Preset(List<String> teamNames) {
        this.teamNames = teamNames;
    }

    public List<String> getTeamNames() {
        for (int i=0; i < teamNames.size(); i++) {
            if (teamNames.get(i) == "RandomStarter") {
                int starterNumber = random.nextInt(3);
                if (starterNumber == 0) {
                    teamNames.set(i, "Meowscarada");
                }
                else if (starterNumber == 1) {
                    teamNames.set(i, "Skeledirge");
                }
                else if (starterNumber == 2) {
                    teamNames.set(i, "Quaquaval");
                }
            }
        }
        return teamNames;
    }
}
