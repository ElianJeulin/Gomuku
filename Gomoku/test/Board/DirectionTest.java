/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

import static Board.Direction.DOWN;
import static Board.Direction.DOWN_LEFT;
import static Board.Direction.DOWN_RIGHT;
import static Board.Direction.LEFT;
import static Board.Direction.RIGHT;
import static Board.Direction.UP;
import static Board.Direction.UP_LEFT;
import static Board.Direction.UP_RIGHT;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author puyas
 */
public class DirectionTest {
    
    @Test
    public void horizontalMvtTest() {
        assertEquals(0, Direction.horizontalMvt(UP));
        assertEquals(-1, Direction.horizontalMvt(DOWN_LEFT));
        assertEquals(1, Direction.horizontalMvt(RIGHT));
    }
    
    @Test
    public void verticalMvtTest() {
        assertEquals(0, Direction.verticalMvt(LEFT));
        assertEquals(-1, Direction.verticalMvt(UP_RIGHT));
        assertEquals(1, Direction.verticalMvt(DOWN_RIGHT));
    }
    
    @Test
    public void allComplementaryDirectionTest() {
        Direction[][] complementary = {{UP, DOWN}, {LEFT, RIGHT}, {UP_LEFT, DOWN_RIGHT}, {UP_RIGHT, DOWN_LEFT}};
        Assert.assertArrayEquals(complementary, Direction.allComplementaryDirections());
        assertEquals(UP, Direction.allComplementaryDirections()[0][0]);
    }
}
