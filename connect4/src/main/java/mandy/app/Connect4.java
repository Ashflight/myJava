package mandy.app;
import java.util.Scanner;

import static mandy.app.Result.TIE;
import static mandy.app.Result.WIN;

public class Connect4 {
    public static void main(String[] args) {
        Board board = new Board();
        board.printBoard();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (playTurn(scanner, board, "x")) break;
            if (playTurn(scanner, board, "o")) break;
        }
    }

    private static boolean playTurn(Scanner scanner, Board board, String player) {
        System.out.printf("Enter an integer, Player %s:%n", player);
        int input = scanner.nextInt();
        board.addStone(player, input);
        board.printBoard();
        Result result = board.checkWin(player);
        //
        if (result == WIN) {
            System.out.printf("The game has ended, player %s won!", player);
            return true;
        }
        else if (result == TIE) {
            System.out.println("The game has ended and it is a tie.");
            return true;
        }
        return false;
    }
}
