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
final public class Rook extends Figure{

    Rook(Color color)
    {
        super(color);
    }
    @Override
    public boolean checkMove(int initial_row, int initial_col, int dest_row, int dest_col)
    {
       //TODO
       return true;
    }
}
