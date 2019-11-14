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
public final class Square {
    private Figure figure;
    
    public Square(Figure figure){
        if (figure != null)
        {
            this.setFigure(figure);      
        }
        else
        {
            this.figure = null;
        }  
    }

    public Figure getFigure()
    {
        return this.figure;
    }
    
    public void setFigure(Figure fig) {
        this.figure = fig;
    }      
}
