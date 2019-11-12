/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.chess2019.server;
/**
 *
 * @author mgrau
 */
public class Board {
    Square squares[][] = null;
    
    public Board(){
        // White pawns
        for(int x=0; x<8; x++){
            squares[1][x] = new Square(new Pawn(Color.WHITE));
        }

        // Black pawns
        for(int x=0; x<8; x++){
            squares[6][x] = new Square(new Pawn(Color.BLACK));
        }

        //Rooks
        squares[0][0] = new Square(new Rook(Color.WHITE));
        squares[0][7] = new Square(new Rook(Color.WHITE));
        squares[7][7] = new Square(new Rook(Color.BLACK));
        squares[7][0] = new Square(new Rook(Color.BLACK));

        //Knights
        squares[0][1] = new Square(new Knight(Color.WHITE));
        squares[0][6] = new Square(new Knight(Color.WHITE));
        squares[7][6] = new Square(new Knight(Color.BLACK));
        squares[7][1] = new Square(new Knight(Color.BLACK));

        //Bishops
        squares[0][2] = new Square(new Bishop(Color.WHITE));
        squares[0][5] = new Square(new Bishop(Color.WHITE));
        squares[7][2] = new Square(new Bishop(Color.BLACK));
        squares[7][5] = new Square(new Bishop(Color.BLACK));

        //Queens
        squares[0][3] = new Square(new Queen(Color.WHITE));
        squares[7][3] = new Square(new Queen(Color.BLACK));

        //Kings
        squares[0][4] = new Square(new King(Color.WHITE));
        squares[7][4] = new Square(new King(Color.BLACK));
        
        // initialize the ones without piece
        for (int i = 2; i < 6; i++) { 
            for (int j = 0; j < 8; j++) { 
                squares[i][j] = new Square(null); 
            } 
        } 
        
    }
    
    public Square getSquare(int row, int column)
    {
        if (row < 0 || row > 7 || column < 0 || column > 7) 
        { 
            return null;
        } 
        return squares[row][column];
    }


}
