package Board;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BoardTest {
    
    @Test
    public void displayBoardTest() {
        Board b = new Board(19, 19);
        System.out.println("Plateau vide : ");
        b.displayGrid();
        System.out.println("Quelques cases modifiées");
        try {
            b.changeCase(new Position(0, 0), Color.WHITE);
            b.changeCase(new Position(12, 14), Color.WHITE);
            b.changeCase(new Position(5, 6), Color.BLACK);
            b.displayGrid();
            b.changeCase(new Position(0, 0), Color.WHITE);
            b.changeCase(new Position(12, 14), Color.WHITE);
            b.changeCase(new Position(5, 6), Color.BLACK);
            b.displayGrid();
        } catch (InvalidCoordinatesException e) {
        }
    }
    
    @Test
    public void changeGridTest() {
        try {
            Board b = new Board(19, 19);
            b.changeCase(new Position("A1"), Color.BLACK);
            b.changeCase(new Position(1, 2), Color.BLACK);
            b.changeCase(new Position(5, 8), Color.WHITE);
            b.changeCase(new Position(7, 3), Color.WHITE);
            assertEquals(Color.BLACK, b.board[0][0].getColor());
            assertEquals(Color.BLACK, b.board[1][2].getColor());
            assertEquals(Color.WHITE, b.board[5][8].getColor());
            assertEquals(Color.WHITE, b.board[7][3].getColor());
        } catch (InvalidCoordinatesException e) {
        }
    }  
}
