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
public abstract class Figure 
{    
    protected Color color;
    private int row;
    private int column;
    
    public Figure(Color color, int row, int column)
    {
        this.color = color;  
        this.row = row;
        this.column = column;
    }
    public Color getColor()
    {
        return this.color;
    }   
    public void canReachDestination(int initial_row, int initial_col, int dest_row, int dest_col, Board board) throws NoPieceMovementException, NoPathFreeException
    {
        isPieceMovement(initial_row, initial_col, dest_row, dest_col);
        isPathFree(initial_row, initial_col, dest_row, dest_col, board);
    }    
    protected abstract void isPieceMovement(int initial_row, int initial_col, int dest_row, int dest_col) throws NoPieceMovementException;
    protected abstract void isPathFree(int initial_row, int initial_col, int dest_row, int dest_col, Board board) throws NoPathFreeException;
    public void proceedToMove(int rD, int cD, Board board)
    {
        board.getSquare(rD,cD).setFigure(this); 
        board.getSquare(row, column).setFigure(null);
    }
    
    
}
