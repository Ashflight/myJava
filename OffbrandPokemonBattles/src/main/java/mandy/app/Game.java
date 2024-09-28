package mandy.app;

import mandy.app.Preset.*;
import mandy.app.data.Move;

import java.util.List;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        //this will be place for game loop
        //also looking at my design SCREW ABILITIES they're going to be pain to add
        //also weather doesn't exist either (Thunder is permanently at 70 accuracy right now)
        // TODO get this running first, even if it's just with two of the same team
        Scanner scanner = new Scanner(System.in);
        int moveIndex1;
        int moveIndex2;
        System.out.println("It's Player 1's turn to pick their team.");
        String trainer1Name = getTrainerChoice(scanner);
        Trainer trainer1 = new Trainer(trainer1Name, getTeamNameList(trainer1Name));
        System.out.println("It's Player 2's turn to pick their team.");
        String trainer2Name = getTrainerChoice(scanner);
        Trainer trainer2 = new Trainer(trainer2Name, getTeamNameList(trainer2Name));
        System.out.println("It's time to battle!");
        do {
            displayPokemon(trainer1, 1);
            displayPokemon(trainer2, 2);
            displayMoves(trainer1);
            moveIndex1 = getMoveIndex(trainer1, 1, scanner);
            displayMoves(trainer2);
            moveIndex2 = getMoveIndex(trainer2, 2, scanner);
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

    public static void displayPokemon(Trainer trainer, int player) {
        System.out.println(trainer.getName() + " (Player " + player + ")");
        System.out.println(trainer.getLead().getPokemonData().getName());
        System.out.print(trainer.getLead().getPokemonData().getCurrentHP());
        System.out.print("/");
        System.out.print(trainer.getLead().getPokemonData().getMaxHP());
        System.out.print(" HP\n");
        if (!trainer.getLead().getPokemonData().getEffects().isEmpty()) {
            System.out.println(trainer.getLead().getPokemonData().getEffects());
        }
    }

    public static void displayMoves(Trainer trainer) {
        for (Move move : trainer.getLead().getPokemonData().getMoves()) {
            System.out.println("(" + move.getType() + ") " + move.getName() + ", " + move.getCurrentPP() + "/"
                    + move.getMaxPP() + " PP");
        }
    }

    public static int getMoveIndex(Trainer trainer, int player, Scanner scanner) {
        System.out.println("ENTER: ");
        for (int i = 0; i < trainer.getLead().getPokemonData().getMoves().size(); i++) {
            System.out.println(i + " for " + trainer.getLead().getPokemonData().getMoves().get(i));
        }
        System.out.println("Which move do you want to use, Player " + player + "?");
        int moveInt = scanner.nextInt();
        scanner.nextLine();
        return moveInt;
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