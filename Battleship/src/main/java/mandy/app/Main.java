package mandy.app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // game loop
        // Player One = You, Player Two = computer controlled.
        // "smart computer" currently completely untested
        // i think it's still minimally functional
        // i hope it is
        // random/base/stupid computer version definitely works
        // praying that the changes to implement a smart computer mode didnt break something
        Scanner scanner = new Scanner(System.in);
        Board playerBoard = new Board("Player One");
        scanShips(scanner, playerBoard);
        Board computerBoard = new Board("Player Two");
        boolean playerTurn = true; // stores whether it is the player's turn or not
        System.out.println("You will play against a computer-controlled Player Two.");
        Computer computer;
        boolean smartComputerActive = false; // intellij says i need this even though boolean default value is false
        System.out.println("Do you wish to turn on \"Smart Computer\" mode? Reply with yes to do so.");
        String reply = scanner.nextLine();
        if (reply.equalsIgnoreCase("yes")) {
            smartComputerActive = true;
            computer = new SmartComputer();
        }
        else {
            computer = new Computer();
        }
        computer.randomizeShips(computerBoard);
        System.out.println("The game is ready to begin.");
        while (!playerBoard.checkLoss() && !computerBoard.checkLoss()) {
            if (playerTurn) {
                // get player input
                System.out.println("It is Player One's turn to shoot.");
                System.out.println("This is the current status of Player Two's Board: ");
                printBoard(computerBoard.getBoard());
                int[] coords = getCoords(scanner);
                System.out.println("Player One will shoot at V: " + coords[0] + " H: " + coords[1] + ".");
                // shoot opposing board
                System.out.println(computerBoard.shoot(coords));
                // print opposing board
                System.out.println("Current status of Player Two's Board: ");
                printBoard(computerBoard.getBoard());
                playerTurn = false;
            }
            else {
                // create random input
                System.out.println("It is Player Two's turn to shoot.");
                int[] coords = computer.getCoords();
                System.out.println("Player Two will shoot at V: " + coords[0] + " H: " + coords[1] + ".");
                // shoot player's board
                String message = playerBoard.shoot(coords);
                System.out.println(message);
                // smart computer tries to manage targeting
                if (smartComputerActive) {
                    SmartComputer refFixedComputer = (SmartComputer) computer;
                    refFixedComputer.checkTargeting(coords, message);
                }
                // print player's board
                System.out.println("Current status of Player One's Board: ");
                printBoard(playerBoard.showShips());
                playerTurn = true;
            }
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (playerBoard.checkLoss()) {
            System.out.println("You lost.");
            System.out.println("Your opponent's board: ");
            printBoard(computerBoard.showShips());
        }
        else {
            System.out.println("You win!");
        }
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
                scanner.nextLine();
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
                if (ship == null) {
                    break;
                }
                for (int[] location1 : ship.getLocations()) {
                    for (Ship placedShip : board.getShips()){
                        if (placedShip == null) {
                            break;
                        }
                        for (int[] location2 : placedShip.getLocations()) {
                            if (location1[0] == location2[0] && location1[1] == location2[1]) {
                                System.out.println("You attempted to place the ship on top of an already placed ship, let's try placing it again.");
                                placed = true;
                                break;
                            }
                        }
                    }
                }
                placed = !placed;
            }
            board.addShip(ship);
            printBoard(board.showShips());
            placed = false;
        }
        System.out.println("You are ready to play.");
    }
    // gets user inputted coordinates for shots
    private static int[] getCoords(Scanner scanner) {
        int[] coords = new int[2];
        System.out.println("Please input a vertical coordinate for this shot: ");
        coords[0] = scanner.nextInt();
        System.out.println("Please input a horizontal coordinate for this shot: ");
        coords[1] = scanner.nextInt();
        return coords;
    }
}