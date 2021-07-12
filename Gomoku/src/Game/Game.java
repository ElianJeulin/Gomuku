/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Board.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Contains the main function. Allows to run the main program and it's
 * sub-functions.
 *
 * @author lpuyastier
 */
public class Game {

    static Color currentColor = Color.BLACK;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try {
            do {
                int menu = 0;
                do {
                    afficherMenu();
                    try {
                        menu = readInt(in);
                        if (menu < 1 || menu > 3) {
                            throw new NumberFormatException("Error : invalid number selected");
                        }
                    } catch (IOException | NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                    if (menu == 3) {
                        playerLeft();
                    }
                } while (menu < 1 || menu > 3);

                String name = askName(in);
                Player p1 = new HumanPlayer(name);
                Player p2 = new RobotPlayer();

                if (menu == 1) {
                    name = askName(in);
                    p2 = new HumanPlayer(name);
                }

                //Ask for the size of the board
                int boardWidth = 0;
                int boardHeight = 0;
                do {
                    try {
                        System.out.println("\nWidth of the board ?");
                        boardWidth = Integer.parseInt(in.readLine());
                        System.out.println("\nHeight of the board ?");
                        boardHeight = Integer.parseInt(in.readLine());
                        if (boardWidth <= 5 || boardHeight <= 5) {
                            throw new NumberFormatException("Error : board too short");
                        }
                    } catch (NumberFormatException | IOException e) {
                        System.out.println(e.getMessage());
                    }
                } while (boardWidth <= 5 || boardHeight <= 5);

                //Ask between the player one and two who starts
                int counter = 0;
                do {
                    try {
                        System.out.println("\nWho starts : 1. " + p1.getName() + "    2. " + p2.getName());
                        counter = Integer.parseInt(in.readLine());
                        if (counter < 1 || counter > 2) {
                            throw new NumberFormatException("Error : number selected not valid");
                        }
                    } catch (NumberFormatException | IOException e) {
                        System.out.println(e.getMessage());
                    }
                } while (counter < 1 || counter > 2);
                if (counter == 1) {
                    p1.setColor(Color.BLACK);
                    p2.setColor(Color.WHITE);
                } else {
                    p2.setColor(Color.BLACK);
                    p1.setColor(Color.WHITE);
                }

                Match m = new Match(p1, p2, boardWidth, boardHeight);

                //Repeat while a player hasn't aligned 5 pieces
                do {
                    m.oneTurn();
                    changeCurrentColor();
                } while (!m.winGame(m.alignedPawns));

                //Advert the winner (depending on which player have five aligned pawns)
                m.congratulateWinner();

            } while (true);
        } catch (GamePlayerLeaves e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Changes the color player after a turn
     */
    private static void changeCurrentColor() {
        if (currentColor.equals(Color.BLACK)) {
            currentColor = Color.WHITE;
        } else {
            currentColor = Color.BLACK;
        }
    }

    /**
     * Method which permits to quit the game.
     *
     * @throws GamePlayerLeaves when the player leaves
     */
    public static void playerLeft() throws GamePlayerLeaves {
        throw new GamePlayerLeaves("Player left the board");
    }

    /**
     * Method which permits to ask the name of the player
     *
     * @param in the line of command
     * @return the name
     */
    private static String askName(BufferedReader in) {
        String name = "";
        do {
            System.out.println("\n\nEnter your name : ");
            try {
                name = in.readLine();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } while (name.isEmpty());
        return name;
    }

    /**
     * Method which prints the game menu.
     */
    private static void afficherMenu() {
        System.out.println("================");
        System.out.println("GOMUKU");
        System.out.println("================\n\n");
        System.out.println("MENU\n");

        System.out.println("1. Play against an other player\n");
        System.out.println("2. Play against the IA\n");
        System.out.println("3. Quit the game\n\n");
        System.out.println("What is your choice ?");
    }

    /**
     * Method which permits to read a int when the player entry a word.
     *
     * @param in the line of command
     * @return an integer
     * @throws IOException line of command exeption
     * @throws NumberFormatException when the player entry a number exeption
     */
    private static int readInt(BufferedReader in) throws IOException, NumberFormatException {
        return Integer.parseInt(in.readLine());
    }
}
