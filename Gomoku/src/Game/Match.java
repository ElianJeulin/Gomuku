/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Board.Board;
import Board.Color;
import Board.Direction;
import Board.InvalidCoordinatesException;
import Board.Position;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * A match between two players on a board.
 *
 * @author ejeulin
 */
public class Match {

    int count = 0;
    int alignedPawns;
    Player p1;
    Player p2;
    Player currentP;
    Board board;
    ArrayList<String> historical = new ArrayList<>();
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public Match(Player p1, Player p2, int width, int height) throws GamePlayerLeaves {
        this.p1 = p1;
        this.p2 = p2;
        this.board = new Board(height, width);
    }

    /**
     * Method which permits to play one turn.
     *
     * @throws GamePlayerLeaves when the player leaves
     */
    void oneTurn() throws GamePlayerLeaves {
        changeCurrentPlayer();

        //Display grid and possible actions		
        board.displayGrid();
        possibleActions().forEach(a -> {
            System.out.print(a + ",  ");
        });

        Position pos = placePiece();

        int maxAlignedPawns = 0;
        //For all opposite directions (ex: {LEFT, RIGHT}, {RIGHT_UP, LEFT_DOWN}, ...}
        for (Direction[] dComplementaires : Direction.allComplementaryDirections()) {
            alignedPawns = 1;
            //For each opposite direction
            for (Direction d : dComplementaires) {
                int compteurPawns = 0;
                alignedPawns += alignedPawns(pos, d, Game.currentColor, compteurPawns);
            }
            if (maxAlignedPawns < alignedPawns) {
                maxAlignedPawns = alignedPawns;
            }
        }
        alignedPawns = maxAlignedPawns;
    }

    /**
     * Prints the congratulation to the winner.
     */
    void congratulateWinner() {
        board.displayGrid();
        System.out.println(historical);
        System.out.println("\nCongratulations " + currentP.getName() + " : you won !\n");
    }

    /**
     * Changes the cuurent player.
     */
    private void changeCurrentPlayer() {
        if (p1.getColor() == Game.currentColor) {
            currentP = p1;
        } else {
            currentP = p2;
        }
    }

    /**
     * Method which permits to place a pawn.
     *
     * @return the string of the action
     * @throws GamePlayerLeaves when the player leaves
     */
    private Position placePiece() throws GamePlayerLeaves {
        do {
            System.out.println(currentP.getName() + " : PLACE YOUR PIECE\n");
            try {

                Position position = currentP.selectedMove(possibleActions(), in);
                historical.add(position.toString());
                board.changeCase(position, Game.currentColor);
                return position;

            } catch (InvalidCoordinatesException | IOException e) {
                System.out.println(e.getMessage());
            }

        } while (true);

    }

    /**
     * Method which return true if the player win the game
     *
     * @param alignedPawns the number of aligned pawns
     * @return true if a player win the game.
     */
    boolean winGame(int alignedPawns) {
        return alignedPawns >= 5;
    }

    /**
     * Method which permits to count the number of aligned pawns
     *
     * @param pos the position of a pawn
     * @param d the direction
     * @param playerColor the actual player color
     * @param counterPawns the counter pawns
     * @return the number of aligned pawns
     */
    int alignedPawns(Position pos, Direction d, Color playerColor, int counterPawns) {
        //Takes the position according to the neighbour position.
        try {
            Position voisin = new Position(
                    pos.getRow() + Direction.horizontalMvt(d),
                    pos.getCol() + Direction.verticalMvt(d)
            );
            //If the neighbour case is the same color that the player who played
            if (board.board[voisin.getRow()][voisin.getCol()].getColor() == playerColor) {
                //Je relance ma fonction pour savoir si il y a un autre voisin de la même couleur
                counterPawns = alignedPawns(voisin, d, playerColor, counterPawns + 1);
            }
        } catch (InvalidCoordinatesException e) {
        }

        return counterPawns;
    }

    /**
     * Method which permits to have all possibility to place a pawn.
     *
     * @return all possible actions when we pose a pawn.
     * @throws GamePlayerLeaves when the board is full
     */
    ArrayList<String> possibleActions() throws GamePlayerLeaves {
        ArrayList<String> possibleActions = new ArrayList<>();
        possibleActions.add("/quit");
        if (board.board[Board.NB_ROW / 2][Board.NB_COL / 2].getColor() == Color.NONE) {
            char c = (char) (Board.CHAR_FIRST_COL + Board.NB_COL / 2);
            possibleActions.add(c + "" + (Board.NB_ROW / 2 + 1));
        } else {
            for (int row = 0; row < Board.NB_ROW; row++) {
                for (int col = 0; col < Board.NB_COL; col++) {
                    if (board.board[row][col].getColor() == Color.NONE) {
                        try {
                            Position pos = new Position(row, col);
                            int count = 0;
                            if (pos.near().size() > 0) {
                                while (count < pos.near().size()) {
                                    Position p = pos.near().get(count);
                                    if (!board.board[p.getRow()][p.getCol()].getColor().equals(Color.NONE)) {
                                        char ch = (char) (Board.CHAR_FIRST_COL + row);
                                        possibleActions.add(pos.toString());
                                        count = pos.near().size();
                                    }
                                    count++;
                                }
                            }
                        } catch (InvalidCoordinatesException e) {
                        }
                    }
                }
            }
        }
        if (possibleActions.size() == 1) {
            throw new GamePlayerLeaves("Board is full, leaving the game");
        }
        return possibleActions;
    }
}
