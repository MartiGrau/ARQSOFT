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
    private int row;
    private int col;
    
    public Board(){
        squares = new Square[8][8]; 
        
    }
    
    public int getRow(){
        return this.row;
    }
    
    public void setRow(int row){
        this.row = row;
    }
    
    public int getCol(){
        return this.col;
    }
    
    public void setCol(int col){
        this.col = col;
    }
}
