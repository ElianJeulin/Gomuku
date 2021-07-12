/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author puyas
 */
public class TileTest {

    @Test
    public void setColorTest() {
        Tile c = new Tile();
        c.setColor(Color.BLACK);
        assertEquals(Color.BLACK, c.getColor());
        c.setColor(Color.WHITE);
        assertEquals(Color.WHITE, c.getColor());
    }
    
    @Test
    public void toStringTest() {
        Tile c = new Tile();
        assertEquals("   ", c.toString());
        c.setColor(Color.WHITE);
        assertEquals(" O ", c.toString());
        c.setColor(Color.BLACK);
        assertEquals(" X ", c.toString());        
    }
}
