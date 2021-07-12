/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Board.Color;
import Board.InvalidCoordinatesException;
import Board.Position;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Abstract class that allows to create players.
 *
 * @author Ejeul
 */
public abstract class Player {

    private final String name;
    private Color color;

    protected Player(String name) {
        this.name = name;
    }

    /**
     * Changes the color of the player
     *
     * @param c the new color of the player
     */
    protected void setColor(Color c) {
        this.color = c;
    }

    /**
     * Gets the color of the player
     *
     * @return the color of the player
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Gets the name of the player
     *
     * @return the name of the player
     */
    public String getName() {
        return this.name;
    }

    /**
     * Makes in action the player choice
     *
     * @param possibleActions an array of possible actions
     * @param in the line of command
     * @return the position of the played move.
     * @throws GamePlayerLeaves when the player leaves
     * @throws IOException line of command exeption
     * @throws InvalidCoordinatesException when the player entry an invalid
     * coordinate
     */
    abstract Position selectedMove(ArrayList<String> possibleActions, BufferedReader in) throws GamePlayerLeaves,
            IOException, InvalidCoordinatesException;
}
