/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.chess2019.server;
import edu.upc.etsetb.arqsoft.chess2019.client.Color;

/**
 *
 * @author JuanCarlos
 */
public class Game {

    private ServerProtocolMngr protMngr;

    private Player player1;
    private Player player2;
    private Board board;
    boolean isPlayer1;
    

    public Game()
    {
        this.player1=new Player(Color.WHITE);
        this.player2=new Player(Color.BLACK);
        this.board=new Board();
        this.isPlayer1 = true;
    }

    public void setServerProtMngr(ServerProtocolMngr protMngr) {
        this.protMngr = protMngr;
    }

    public void move(int rO, int cO, int rD, int cD) {
        System.out.println("Calling move");
        Player actualPlayer;
        if (isPlayer1)
        {
            actualPlayer = player1;
        } 
        else{
            actualPlayer = player2;
        }
        
        // use indexes instead of positions:
        rO -= 1;
        cO -= 1;
        rD -= 1;
        cD -= 1;
        /*
        Initial version: it just sends back an OK message to the client.
        You should modify its code for implementing the sequence diagram in the 
        script of the lab session

        NOTE: USE THE FOLLOWING UNCOMMENTED INSTRUCTION FOR SENDING AN ERROR MESSAGE TO THE CLIENT.
        AN ERROR MESSAGE SHALL BE AN END-OF-LINE FREE STRING STARTING WITH "E "
         */
        //         this.protMngr.sendFromServerToClient("E this is an error message");

        Figure pieceToMove;      
        pieceToMove = this.board.getPiece(rO, cO);              
        
        if (pieceToMove == null || pieceToMove.getColor() != actualPlayer.getColor())
        {
            this.protMngr.sendFromServerToClient("Error: there is not a piece you can move on this pos");
            return;
        }
        
        Figure pieceDest;
        pieceDest = this.board.getPiece(rD, cD);
        
        if (pieceDest != null && pieceDest.getColor() == actualPlayer.getColor())
        {
            this.protMngr.sendFromServerToClient("Error: there is a piece of the same color in the dest pos");
            return;
        }
        
        try
        {        
            actualPlayer.move(pieceToMove, rO, cO, rD, cD, this.board);
        } catch(NoPieceMovementException | NoPathFreeException e)
        {
            System.out.println("Exception thrown while trying to move: " + e);
            return;
        }
        
        try
        {
            isKingOfMovingPieceThreatened();    
        }
        catch (KingIsThreatenedException e)
        {
            this.protMngr.sendFromServerToClient("Error: the movement is invalid because the king is threatened");   
            return;
        }
        
        actualPlayer.proceedToMove(pieceToMove, rD, cD, board);        
        /* 
        DO NOT CHANGE THE CODE BELOW.
        FINAL PART OF THE METHOD. IF ARRIVED HERE, THE MOVEMENT CAN BE PERFORMED
        METHOD assessCheckOrCheckMate(...) CHECKS WHETHER THERE IS CHECK OR CHECK-MATE.
        IF IT IS CHECK-MATE THE METHOD RETURNS TRUE AND A NON-EMPTY STRING
        IF THERE IS CHECK THE METHOD RETURNS FALSE AND A NON-EMPTY STRING
        IF THERE IS NONE OF BOTH, THE METHOD RETURNS FALSE AND AN EMPTY STRING
         */
        StringBuilder assessMess = new StringBuilder();
        boolean isCheckMate = this.assessCheckOrCheckMate(assessMess);

        if (assessMess.length() == 0) {
            this.protMngr.sendFromServerToClient("OK");
        } else {
            this.protMngr.sendFromServerToClient(assessMess.insert(0, "OK\n").toString());
        }
        if(isCheckMate){
            this.proceedToFinalizedGame() ;
        }
        System.out.println("Exit move");
        // Turn of other opponent
        isPlayer1 = !isPlayer1;
    }

    private boolean assessCheckOrCheckMate(StringBuilder assessMess) {
        // IF THE PROGRAM SHOULD BE COMPLETED, IT SHOULD BE IMPLEMENTED
        return false ;
    }

    private void proceedToFinalizedGame() {
        // IF THE PROGRAM SHOULD BE COMPLETED, IT SHOULD BE IMPLEMENTED
        return ;
    }
    
    private void isKingOfMovingPieceThreatened() throws KingIsThreatenedException
    {
        
    } 
}
