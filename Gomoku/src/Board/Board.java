/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

/**
 * Permits to manage the board
 * @author lpuyastier
 */
public class Board {

    public static int NB_ROW;
    public static int NB_COL;
    public static final char CHAR_FIRST_COL = 'A';

    public Tile[][] board;

    public Board(int NB_ROW, int NB_COL) {
        Board.NB_ROW = NB_ROW;
        Board.NB_COL = NB_COL;
        this.board = new Tile[Board.NB_ROW][Board.NB_COL];
        for (int row = 0; row < Board.NB_ROW; row++) {
            for (int col = 0; col < Board.NB_COL; col++) {
                board[row][col] = new Tile();
            }
        }
    }

    /**
     * Method which permits to display the board.
     */
    public void displayGrid() {
        StringBuilder grid = new StringBuilder();
        //prints the row with letters
        grid.append("    ");
        char letter = Board.CHAR_FIRST_COL;
        for (int i = 0; i < Board.NB_COL; i++) {
            grid.append(" ").append(letter).append(" ");
            letter++;
        }
        grid.append("\n");

        //prints the second row
        grid.append("   +");
        for (int i = 0; i < Board.NB_COL; i++) {
            grid.append("---");
        }
        grid.append(" +");
        grid.append("\n");

        //prints the content of the board
        for (int i = 0; i < Board.NB_ROW; i++) {
            if (i >= 9) {
                grid.append(i + 1).append(" |");
            } else {
                grid.append(i + 1).append("  |");
            }

            for (int j = 0; j < Board.NB_COL; j++) {
                grid.append(board[i][j]);
            }
            grid.append(" | \n");
        }

        //prints the last row
        grid.append("   +");
        for (int i = 0; i < Board.NB_COL; i++) {
            grid.append("---");
        }
        grid.append(" +");

        System.out.println(grid);
    }

    /**
     * Changes the color of a case
     *
     * @param p the position
     * @param c the color
     */
    public void changeCase(Position p, Color c) {
        board[p.getRow()][p.getCol()].setColor(c);
    }
}
