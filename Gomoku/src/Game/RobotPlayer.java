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
import java.util.Random;

/**
 * Creates a robot player.
 *
 * @author ejeulin
 */
public class RobotPlayer extends Player {

    public RobotPlayer() {
        super("Bot");
    }

    /**
     * Makes in action the robot choice
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
        Random r = new Random();
        Position p = null;
        try {
            p = new Position(possibleActions.get(r.nextInt(possibleActions.size() - 1) + 1));
        } catch (InvalidCoordinatesException e) {
        }
        return p;
    }

}
