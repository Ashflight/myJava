package mandy.app;

import mandy.app.Preset.*;

import java.util.List;

public class Game {
    public static void main(String[] args) {
        //this will be place for game loop
        //also looking at my design SCREW ABILITIES they're going to be pain to add
        //also weather doesn't exist either (Thunder is permanently at 70 accuracy right now)
        // TODO get this running first, even if it's just with two of the same team
        //testing
        String trainer1Name = "Penny";
        Trainer trainer1 = new Trainer(trainer1Name, getTeamNameList(trainer1Name));
        System.out.println(trainer1.getName());
        System.out.println(trainer1.getLead().getPokemonData().getName());
        // currently broken
    }

    public static List<String> getTeamNameList(String name) {
        return Preset.valueOf(name.toUpperCase()).getTeamNames();
    }
}