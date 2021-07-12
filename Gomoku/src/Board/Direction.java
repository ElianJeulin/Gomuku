/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

/**
 * Manages directions for a pawn
 * @author puyas
 */
public enum Direction {
    UP, DOWN, LEFT, RIGHT, UP_LEFT, UP_RIGHT, DOWN_LEFT, DOWN_RIGHT;

    /**
     * Method which permits to have all opposite Directions.
     *
     * @return a double array with opposite directions
     */
    public static Direction[][] allComplementaryDirections() {
        Direction[][] directions = {{UP, DOWN}, {LEFT, RIGHT}, {UP_LEFT, DOWN_RIGHT}, {UP_RIGHT, DOWN_LEFT}};
        return directions;
    }

    /**
     * Calculates the horizontal movement from a departure position.
     *
     * @param d the direction
     * @return the horizontal movement
     */
    public static int horizontalMvt(Direction d) {
        int mvt = 0;
        switch (d) {
            case UP_LEFT:
            case DOWN_LEFT:
            case LEFT:
                mvt = -1;
                break;

            case UP_RIGHT:
            case DOWN_RIGHT:
            case RIGHT:
                mvt = 1;
                break;
        }

        return mvt;
    }

    /**
     * Calculates the vertical movement from a departure position.
     *
     * @param d the direction
     * @return the vertical movement.
     */
    public static int verticalMvt(Direction d) {
        int mvt = 0;
        switch (d) {
            case UP_LEFT:
            case UP_RIGHT:
            case UP:
                mvt = -1;
                break;
            case DOWN_LEFT:
            case DOWN_RIGHT:
            case DOWN:
                mvt = 1;
                break;
        }
        return mvt;
    }
}
