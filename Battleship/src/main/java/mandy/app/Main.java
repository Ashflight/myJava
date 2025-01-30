package mandy.app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // game loop
        // Player One = You, Player Two = computer controlled.
        // computer player currently just randomly hits, no logic yet.
        Scanner scanner = new Scanner(System.in);
        Board playerBoard = new Board ("Player One");

    }
    private static void printBoard(String[] board) {
        for (String row : board) {
            System.out.println(row);
        }
    }
    // user input reading to add ships
    private static void scanShips(Scanner scanner, Board board) {
        System.out.println("You are Player One.");
        System.out.println("You will have a 10 by 10 board, with each spot marked by a vertical and horizontal coordinate.");
        System.out.println("Coordinates go from 0 to 9, top down, left to right.");
        System.out.println("You have 5 ships to place, in the following order:");
        System.out.println("A Carrier, 5 units long, a Battleship, 4 units long, a Submarine and a Destroyer, each 3 units long, and a Patrol Boat, 2 units long.");
        String[] shipNames = {"Carrier", "Battleship", "Submarine", "Destroyer", "Patrol Boat"};
        int[] shipSizes = {5, 4, 3, 3, 2};
        boolean placed = false;
        Ship ship = null;
        for (int i = 0; i < 5; i++) {
            while (!placed) {
                System.out.println("You are about to place your " + shipNames[i] + ", it is " + shipSizes[i] + " units long.");
                System.out.println("Enter a vertical coordinate, where 0 would be the top row and 9 would be the bottom row: ");
                int yHead = scanner.nextInt();
                System.out.println("Enter a horizontal coordinate, where 0 would be the leftmost column and 9 would be the rightmost column: ");
                int xHead = scanner.nextInt();
                System.out.println("Enter V to place this ship vertically, with the tail down from the head.");
                System.out.println("Enter H to place it horizontally, with the tail to the right of the head.");
                String direction = scanner.nextLine();
                try {
                    ship = new Ship(shipNames[i], yHead, xHead, shipSizes[i], direction);
                }
                catch (IllegalArgumentException e) {
                    System.out.println("You attempted to place the ship out of bounds, let's try placing it again.");
                    placed = true;
                }
                // this mess is to prevent ships from being placed overlapping
                for (int[] location1 : ship.getLocations()) {
                    for (Ship placedShip : board.getShips()){
                        for (int[] location2 : placedShip.getLocations()) {
                            if (location1[0] == location2[0] && location1[1] == location2[1]) {
                                System.out.println("You attempted to place the ship on top of an already placed ship, let's try placing it again.");
                                placed = true;
                            }
                        }
                    }
                }
                placed = !placed;
            }
            board.addShip(ship);
            printBoard(board.showShips());
        }
        System.out.println("e");
        // TODO: Finish all of this user input + computer stuff
        // TODO: Might need to use Try/Except?
    }
    // might make a computer class when I add logic for the computer.
}