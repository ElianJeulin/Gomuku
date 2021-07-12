/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 * Exception launched when the player leaves the game.
 *
 * @author puyas
 */
public class GamePlayerLeaves extends Exception {

    public GamePlayerLeaves(String text) {
        super(text);
    }
}
