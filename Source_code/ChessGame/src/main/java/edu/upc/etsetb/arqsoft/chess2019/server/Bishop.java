/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.chess2019.server;
import edu.upc.etsetb.arqsoft.chess2019.client.Color;
import static java.lang.Math.abs;

/**
 *
 * @author mgrau
 */
final public class Bishop extends Figure
{
    Bishop(Color color, int row, int column)
    {
        super(color, row, column);
    }
    
    @Override
    protected void isPieceMovement(int initial_row, int initial_col, int dest_row, int dest_col) throws NoPieceMovementException
    {   
        // check movement is diagonal
        if (abs(initial_row - dest_row)!= abs(initial_col - dest_col))
        {
            throw new NoPieceMovementException();
        } 
        if (initial_row == dest_row || initial_col == dest_col)
        {
            throw new NoPieceMovementException();
        }
    }
    @Override
    protected void isPathFree(int initial_row, int initial_col, int dest_row, int dest_col, Board board) throws NoPathFreeException
    {
        int direction_row = dest_row > initial_row ? 1 : -1;
        int direction_col = dest_col > initial_col ? 1 : -1;
        for (int i=1; i <= abs(dest_row - initial_row)-1; i++)
        {
            if(board.getPiece(initial_row + i*direction_row, initial_col + i*direction_col) != null)
            {
                throw new NoPathFreeException();
                
            }
        } 
    }
}
