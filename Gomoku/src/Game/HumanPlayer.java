/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Board.InvalidCoordinatesException;
import Board.Position;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Creates a human player.
 *
 * @author ejeulin
 */
public class HumanPlayer extends Player {

    public HumanPlayer(String name) {
        super(name);
    }

    /**
     * Makes in action the human choice
     *
     * @param possibleActions an array of possible actions
     * @param in the line of command
     * @return the position of the played move.
     * @throws GamePlayerLeaves when the player leaves
     * @throws IOException line of command exeption
     * @throws InvalidCoordinatesException when the player entry an invalid
     * coordinate
     */
    @Override
    Position selectedMove(ArrayList<String> possibleActions, BufferedReader in) throws GamePlayerLeaves,
            IOException, InvalidCoordinatesException {

        String pos = in.readLine();
        if (!possibleActions.contains(pos)) {
            throw new InvalidCoordinatesException(" Error : " + pos + " is not available");
        }
        if (pos.equals("/quit")) {
            Game.playerLeft();
        }
        Position position = new Position(pos);
        return position;
    }
}
