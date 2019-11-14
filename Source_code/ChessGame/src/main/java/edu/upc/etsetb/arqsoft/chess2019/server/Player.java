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
public class Player 
{
    private final Color color;
    public Player(Color color)
    {
        this.color = color;
    } 
    public Color getColor()
    {
        return this.color;
    }

    public void move(Figure pieceToMove, int rO, int cO, int rD, int cD, Board board) throws NoPieceMovementException, NoPathFreeException 
    {        
        pieceToMove.canReachDestination(rO, cO, rD, cD, board);          
    }
    
    public void proceedToMove(Figure piece, int rD, int cD, Board board)
    {
        piece.proceedToMove(rD, cD, board);    
    }
}
