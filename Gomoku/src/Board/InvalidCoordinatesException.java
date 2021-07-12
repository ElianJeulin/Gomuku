/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

/**
 * Manages the exception when someone enters a invalid coordinate
 * @author lpuyastier
 */
public class InvalidCoordinatesException extends Exception {

    public InvalidCoordinatesException(String description) {
        super(description);
    }
}
