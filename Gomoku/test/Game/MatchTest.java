/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Board.Color;
import Board.Direction;
import Board.InvalidCoordinatesException;
import Board.Position;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author puyas
 */
public class MatchTest {

    @Test
    public void possibleActionsTest() {
        try {
            Match m = new Match(
                    new RobotPlayer(), new RobotPlayer(),
                    19, 19);
            assertTrue(m.possibleActions().contains("J10"));
            m.board.changeCase(new Position("J10"), Color.BLACK);
            assertTrue(m.possibleActions().contains("J9")
                    && m.possibleActions().contains("J11"));
        } catch (InvalidCoordinatesException | GamePlayerLeaves e) {
            System.out.println(e.getMessage());
        }
        try {
            Match m = new Match(new RobotPlayer(), new RobotPlayer(), 1, 1);
            m.board.changeCase(new Position("A1"), Color.BLACK);
            //throws exception
            m.possibleActions();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void alignedPawnsTest() {
        try {
            Match m = new Match(new RobotPlayer(), new RobotPlayer(), 19, 19
            );

            m.board.changeCase(new Position(0, 0), Color.WHITE);
            m.board.changeCase(new Position(0, 1), Color.WHITE);
            m.board.changeCase(new Position(0, 2), Color.WHITE);
            m.board.changeCase(new Position(0, 3), Color.WHITE);
            assertEquals(2, m.alignedPawns(new Position(0, 1), Direction.UP, Color.WHITE, 1));
            assertEquals(4, m.alignedPawns(new Position(0, 1), Direction.DOWN, Color.WHITE, 2));
        } catch (Exception e) {

        }
    }
}
