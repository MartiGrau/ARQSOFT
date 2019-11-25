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
final public class Knight extends Figure 
{
    Knight(Color color, int row, int column)
    {
        super(color, row, column);
    }
    @Override
    protected void isPieceMovement(int initial_row, int initial_col, int dest_row, int dest_col) throws NoPieceMovementException
    {
        if (abs(initial_row - dest_row)!= 2 && abs(initial_col - dest_col) != 1)
        {
            throw new NoPieceMovementException();
        }
        
        if (abs(initial_row - dest_row)!= 1 && abs(initial_col - dest_col) != 2)
        {
            throw new NoPieceMovementException();
        }
    }
    @Override
    protected void isPathFree(int initial_row, int initial_col, int dest_row, int dest_col, Board board) throws NoPathFreeException
    {
        // TODO
    }

    
}
