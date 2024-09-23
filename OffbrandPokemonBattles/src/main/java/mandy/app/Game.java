package mandy.app;

import mandy.app.Preset.*;

import java.util.List;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        //this will be place for game loop
        //also looking at my design SCREW ABILITIES they're going to be pain to add
        //also weather doesn't exist either (Thunder is permanently at 70 accuracy right now)
        // TODO get this running first, even if it's just with two of the same team
        Scanner scanner = new Scanner(System.in);
        System.out.println("It's Player 1's turn to pick their team.");
        String trainer1Name = getTrainerChoice(scanner);
        Trainer trainer1 = new Trainer(trainer1Name, getTeamNameList(trainer1Name));
        System.out.println("It's Player 2's turn to pick their team.");
        String trainer2Name = getTrainerChoice(scanner);
        Trainer trainer2 = new Trainer(trainer2Name, getTeamNameList(trainer2Name));
        System.out.println("It's time to battle!");
        do {
            displayPokemon(trainer1, trainer2);
        } while (!trainer1.getTeam().isEmpty() || !trainer2.getTeam().isEmpty());
        // currently functional but DO NOT RUN it's just an endless loop
    }

    public static List<String> getTeamNameList(String name) {
        return Preset.valueOf(name.toUpperCase()).getTeamNames();
    }

    public static String getTrainerChoice(Scanner scanner) {
        System.out.println("Which character do you want to play as?");
        String name = scanner.nextLine();
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        return name;
    }

    public static void displayPokemon(Trainer trainer1, Trainer trainer2) {
        System.out.println(trainer1.getName() + " (Player 1)");
        System.out.println(trainer1.getLead().getPokemonData().getName());
        System.out.print(trainer1.getLead().getPokemonData().getCurrentHP());
        System.out.print("/");
        System.out.print(trainer1.getLead().getPokemonData().getMaxHP());
        System.out.print(" HP\n");
        if (!trainer1.getLead().getPokemonData().getEffects().isEmpty()) {
            System.out.println(trainer1.getLead().getPokemonData().getEffects());
        }
        System.out.println(trainer2.getName() + " (Player 2)");
        System.out.println(trainer2.getLead().getPokemonData().getName());
        System.out.print(trainer2.getLead().getPokemonData().getCurrentHP());
        System.out.print("/");
        System.out.print(trainer2.getLead().getPokemonData().getMaxHP());
        System.out.print(" HP\n");
        if (!trainer2.getLead().getPokemonData().getEffects().isEmpty()) {
            System.out.println(trainer2.getLead().getPokemonData().getEffects());
        }
    }

    //some code for processing multi-hit damage that i put in the wrong place but might be able to salvage/reuse
//    public int getDamage(List<Type> userType, Type targetType, int attack, int opponentDefense) {
//        int rawDamage = 0;
//        for (int i = 0; i < hits; i++) {
//            if (type.getIncrease().contains(targetType)) {
//                rawDamage = rawDamage + power * 2 * attack / opponentDefense;
//            } else if (type.getDecrease().contains(targetType)) {
//                rawDamage = rawDamage + power * attack / 2 / opponentDefense;
//            } else if (type.getImmune().contains(targetType)) {
//                return 0;
//            } else {
//                rawDamage = power * attack / opponentDefense;
//            }
//        }
//        if (userType.contains(type)) {
//            return (int) (rawDamage * 1.5f);
//        }
//        return rawDamage;
//    }
}