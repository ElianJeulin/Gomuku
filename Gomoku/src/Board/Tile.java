/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

/**
 * Manages cases of a board
 * @author lpuyastier
 */
public class Tile {

    private Color color;

    Tile() {
        this.color = Color.NONE;
    }

    /**
     * Changes the color of a case
     * @param c the new color
     */
    void setColor(Color c) {
        this.color = c;
    }

    /**
     * Prints the color of the case
     * @return a string corresponding to the color
     */
    @Override
    public String toString() {
        switch (color) {
            case NONE:
                return "   ";
            case BLACK:
                return " X ";
            case WHITE:
                return " O ";
            default:
                return "";
        }
    }
    
    /**
     * Return the color of the case
     * @return color value
     */
    public Color getColor() {
        return this.color;
    }
}

