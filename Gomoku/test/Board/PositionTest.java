/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author puyas
 */
public class PositionTest {

    @Test
    public void positionTest() {
        Board b = new Board(19, 19);
        try {
            Position p1 = new Position("A6");
            assertEquals(0, p1.getCol());
            assertEquals(5, p1.getRow());
            //throws exception
            Position p2 = new Position("BUZCCBO");
        } catch (InvalidCoordinatesException e) {
            System.out.println(e.getMessage());
        }
        try {
            Position p1 = new Position(0, 0);
            assertEquals(0, p1.getRow());
            assertEquals(0, p1.getCol());
            //throws exception
            Position p2 = new Position(19, 19);
        } catch (InvalidCoordinatesException e) {
            System.out.println(e.getMessage()
            );
        }

    }

    @Test
    public void toStringTest() {
        Board b = new Board(19, 19);
        try {
            Position p1 = new Position("A1");
            assertEquals("A1", p1.toString());
            Position p2 = new Position("F5");
            assertEquals("F5", p2.toString());
            Position p3 = new Position("S19");
            assertEquals("S19", p3.toString());
            Position p4 = new Position("D11");
            assertEquals("D11", p4.toString());
        } catch (InvalidCoordinatesException e) {
        }
    }

    @Test
    public void nearTest() {
        Board b = new Board(5, 5);
        try {
            Position p1 = new Position(2, 2);
            assertTrue(p1.near().contains(new Position(1, 1)));
            assertTrue(p1.near().contains(new Position(3, 2)));
            assertTrue(p1.near().contains(new Position(2, 3)));
        } catch (InvalidCoordinatesException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void equalsTest() {
        Board b = new Board(5, 5);
        try {
            Position p1 = new Position(0, 0);
            Position p2 = new Position(0, 0);
            assertEquals(p1, p2);
        } catch (InvalidCoordinatesException e) {

        }
    }
}
