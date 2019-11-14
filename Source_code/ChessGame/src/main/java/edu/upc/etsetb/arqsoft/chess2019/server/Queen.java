/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.chess2019.server;
import edu.upc.etsetb.arqsoft.chess2019.client.Color;

/**
 *
 * @author mgrau
 */
final public class Queen extends Figure
{
    Queen(Color color, int row, int column)
    {
        super(color, row, column);
    }
    @Override
    protected void isPieceMovement(int initial_row, int initial_col, int dest_row, int dest_col) throws NoPieceMovementException
    {
        // TODO
    }
    @Override
    protected void isPathFree(int initial_row, int initial_col, int dest_row, int dest_col, Board board) throws NoPathFreeException
    {
        // TODO
    }
}
