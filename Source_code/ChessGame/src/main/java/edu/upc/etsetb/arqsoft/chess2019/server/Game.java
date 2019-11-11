/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.chess2019.server;

import edu.upc.etsetb.arqsoft.chess2019.client.NetworkAdapter;

/**
 *
 * @author JuanCarlos
 */
public class Game {
   
    private NetworkAdapter networkAdapter;
    private Player player1;
    private Player player2;
    private Board board;
    

    public Game(NetworkAdapter networkAdapter, Player player1, Player player2, Board board) {
        this.networkAdapter = networkAdapter;
        this.player1=player1;
        this.player2=player2;
        this.board=board;
        //set_Figures();
    }

    /**
     * Get the value of networkAdapter
     *
     * @return the value of networkAdapter
     */
    public NetworkAdapter getNetworkAdapter() {
        return networkAdapter;
    }

    /**
     * Set the value of networkAdapter
     *
     * @param networkAdapter new value of networkAdapter
     */
    public void setNetworkAdapter(NetworkAdapter networkAdapter) {
        this.networkAdapter = networkAdapter;
    }

    public void receivesCommandFromClient(){
        String command = this.networkAdapter.readFromClientToServer() ;
        this.networkAdapter.sendFromServerToClient(command);
    }


}
