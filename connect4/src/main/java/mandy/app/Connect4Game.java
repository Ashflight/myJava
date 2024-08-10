package mandy.app;

import java.util.Scanner;

import static mandy.app.Result.TIE;
import static mandy.app.Result.WIN;

public class Connect4Game {
    public static int getInput(Scanner scanner, Player player) {
        System.out.printf("Enter an integer, Player %s:%n", player);
        return scanner.nextInt();
    }
    public static void main(String[] args) {
        Connect4 connect4 = new Connect4();
        Scanner scanner = new Scanner(System.in);

        Player player = null;
        Result result;
        do {
            player = connect4.getNextPlayer(player);
            result = connect4.playTurn(player, getInput(scanner, player));
        } while (result != WIN && result != TIE);
        System.out.println(connect4.generateMessage(result, player));
    }
}
