/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

import java.util.ArrayList;

/**
 * Manages coordinates of a board 
 * @author lpuyastier
 */
public class Position {

    private final int row, col;

    /**
     * Creates a position with the row and column already stated
     *
     * @param row the row corresponding to the position
     * @param col the col corresponding to the position
     * @throws InvalidCoordinatesException when the player entry an invalid
     * coordinate
     */
    public Position(int row, int col) throws InvalidCoordinatesException {
        if (row >= 0 && row < Board.NB_ROW
                && col >= 0 && col < Board.NB_COL) {
            this.row = row;
            this.col = col;
        } else {
            throw new InvalidCoordinatesException("Error : " + row + "," + col + " is not a valid position");
        }
    }

    /**
     * Creates a position from a string
     *
     * @param name the string from which to take the position
     * @throws InvalidCoordinatesException when the player entry an invalid
     * coordinate
     */
    public Position(String name) throws InvalidCoordinatesException {
        try {
            this.row = rowFromString(name);
            this.col = colFromString(name);
        } catch (InvalidCoordinatesException e) {
            throw (e);
        }
    }

    /**
     * Extracts the column from a string
     *
     * @param coord the string
     * @return the int number of the column
     * @throws InvalidCoordinatesException when the player entry an invalid
     * coordinate
     */
    static private int colFromString(String coord) throws InvalidCoordinatesException {
        final char carMin = Board.CHAR_FIRST_COL;
        final char carMax = (char) (Board.CHAR_FIRST_COL + Board.NB_ROW - 1);

        char col = coord.charAt(0);
        if ((col < carMin) || (col > carMax)) {
            throw new InvalidCoordinatesException(
                    "Error : col " + col + " isn't part of the board");
        }
        return col - Board.CHAR_FIRST_COL;
    }

    /**
     * Extracts the row number from a string
     *
     * @param coord the string
     * @return the int value of the row
     * @throws InvalidCoordinatesException when the player entry an invalid
     * coordinate
     */
    static private int rowFromString(String coord) throws InvalidCoordinatesException {
        String substring = coord.substring(1);
        try {
            Integer.decode(substring);
        } catch (NumberFormatException e) {
            throw new InvalidCoordinatesException("Error : invalid caracters typed : " + substring);
        }

        int row = Integer.parseInt(substring) - 1;
        if ((row < 0) || (row >= Board.NB_ROW)) {
            throw new InvalidCoordinatesException(
                    "Error : row " + row + " isn't part of the board");
        }
        return row;
    }

    /**
     * Get adjacent positions.
     *
     * @return an array with adjacent positions
     */
    public ArrayList<Position> near() {
        ArrayList<Position> near = new ArrayList<>();
        for (Direction d : Direction.values()) {
            try {
                Position p = new Position(this.row + Direction.verticalMvt(d),
                        this.col + Direction.horizontalMvt(d));
                near.add(p);
            } catch (InvalidCoordinatesException e) {
            }
        }
        return near;
    }

    /**
     * Get the column number
     *
     * @return col value
     */
    public int getCol() {
        return this.col;
    }

    /**
     * Get the row number
     *
     * @return row value
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Prints position
     *
     * @return a String corespondant to the position
     */
    @Override
    public String toString() {
        char c = (char) (Board.CHAR_FIRST_COL + this.col);
        int newRow = this.row + 1;
        return c + "" + newRow;
    }

    /**
     * Verify if an object is equal to an other object
     * @param obj an object
     * @return true if the two objects are equals
     */
    @Override
    public boolean equals(Object obj) {
        Position p = (Position) obj;
        return (this.col == p.getCol() && this.row == p.getRow());
    }

 
    /**
     * Generate hash code.
     * @return hash code
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.row;
        hash = 17 * hash + this.col;
        return hash;
    }
}
