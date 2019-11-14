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
public class Board {
    Square squares[][] = new Square[8][8];
    
    public Board(){
        for (int i = 0; i < 8; i++)
        {            
            for (int j = 0; j<8; j++)
            {
                squares[i][j] = new Square(null); 
            }
        }  
        // White pawns
        for(int x=0; x<8; x++){
            squares[1][x] = new Square(new Pawn(Color.WHITE, 1, x));
        }

        // Black pawns
        for(int x=0; x<8; x++){
            squares[6][x] = new Square(new Pawn(Color.BLACK, 6, x));
        }

        //Rooks
        squares[0][0] = new Square(new Rook(Color.WHITE, 0, 0));
        squares[0][7] = new Square(new Rook(Color.WHITE, 0, 7));
        squares[7][7] = new Square(new Rook(Color.BLACK, 7, 7));
        squares[7][0] = new Square(new Rook(Color.BLACK, 7, 0));

        //Knights
        squares[0][1] = new Square(new Knight(Color.WHITE, 0, 1));
        squares[0][6] = new Square(new Knight(Color.WHITE, 0, 6));
        squares[7][6] = new Square(new Knight(Color.BLACK, 7, 6));
        squares[7][1] = new Square(new Knight(Color.BLACK, 7, 1));

        //Bishops
        squares[0][2] = new Square(new Bishop(Color.WHITE, 0, 2));
        squares[0][5] = new Square(new Bishop(Color.WHITE, 0, 5));
        squares[7][2] = new Square(new Bishop(Color.BLACK, 7, 2));
        squares[7][5] = new Square(new Bishop(Color.BLACK, 7, 5));

        //Queens
        squares[0][3] = new Square(new Queen(Color.WHITE, 0, 3));
        squares[7][3] = new Square(new Queen(Color.BLACK, 7, 3));

        //Kings
        squares[0][4] = new Square(new King(Color.WHITE, 0, 4));
        squares[7][4] = new Square(new King(Color.BLACK, 7, 4)); 
        
    }
    
    public Square getSquare(int row, int column)
    {
        if (row < 0 || row > 7 || column < 0 || column > 7) 
        { 
            return null;
        } 
        return squares[row][column];
    }

    public Figure getPiece(int row, int  col) 
    {
         return squares[row][col].getFigure();
    }


}
