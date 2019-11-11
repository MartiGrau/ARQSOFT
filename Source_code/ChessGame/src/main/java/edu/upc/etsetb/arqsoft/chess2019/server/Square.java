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
public class Square {
    private Figure figure;
    private int row;
    private int col;
    
    public Square(int row, int col, Figure figure){
        this.setFigure(row,col,figure);
        
    }

    public Figure getFigure(){
        return this.figure;
    }
    
    public void setFigure(int row, int col, Figure fig) {
        this.figure = fig;
    }
    
    public int 
}
