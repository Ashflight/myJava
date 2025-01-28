package mandy.app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // game loop
        // Player One = You, Player Two = computer controlled.
        // computer player currently just randomly hits, no logic yet.
        Scanner scanner = new Scanner(System.in);
        Board playerBoard = scanBoard(scanner);

    }
    private static void printBoard(Board board) {
        String[] printableBoard = board.getBoard();
        for (String row : printableBoard) {
            System.out.println(row);
        }
    }
    // user input reading
    private static Board scanBoard(Scanner scanner) {
        System.out.println("You are Player One.");
        System.out.println("You will have a 10 by 10 board, with each spot marked by a vertical and horizontal coordinate.");
        System.out.println("Coordinates go from 0 to 9, top down, left to right.");
        System.out.println("You have 5 ships to place, in the following order:");
        System.out.println("A Carrier, 5 units long, a Battleship, 4 units long, a Submarine and a Destroyer, each 3 units long, and a Patrol Boat, 2 units long.");
        Ship[] ships = new Ship[5];
        // try updating display with each ship placed to discourage placing ships on top of each other
        System.out.println("e");
        // TODO: Finish all of this user input + computer stuff
        // TODO: Might need to use Try/Except?
        return new Board("Player One", ships);
    }
    // might make a computer class when I add logic for the computer.
}