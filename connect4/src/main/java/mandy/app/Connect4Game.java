package mandy.app;

import java.util.Scanner;

import static mandy.app.Result.TIE;
import static mandy.app.Result.WIN;

public class Connect4Game {

    public static void main(String[] args) {
        Connect4 connect4 = new Connect4();
        Scanner scanner = new Scanner(System.in);

        Player player = null;
        Result result;
        do {
            player = connect4.getNextPlayer(player);
            result = connect4.playTurn(player, Connect4.getInput(scanner, player));
        } while (result != WIN && result != TIE);

        connect4.printResult(result, player);
    }
}
