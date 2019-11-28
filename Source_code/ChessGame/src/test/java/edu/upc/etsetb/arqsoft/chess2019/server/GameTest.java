/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.chess2019.server;

import edu.upc.etsetb.arqsoft.chess2019.client.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.MockitoAnnotations.initMocks;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author uni
 */
@RunWith(MockitoJUnitRunner.class)
public class GameTest 
{
    @InjectMocks
    private Game game;
    
    @Mock (name = "board")
    private Board mockBoard;    
    @Mock (name = "player1")
    private Player mockPlayer;
    @Mock
    private ServerProtocolMngr mockProtoManager;   
              
    public GameTest(){
        
    }    
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Starting Test for class Bishop");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Ending Test for class Bishop");
    }
    
    @Before
    public void setUp() {
        initMocks(this);  
    }
    
    @After
    public void tearDown() {     
    }
        
    
    @Test
    public void testMoveOk() throws Exception{
        System.out.println("test move OK");
        int rO = 4;
        int cO = 4;
        int rD = 6;
        int cD = 6;

        Bishop pieceMoved = new Bishop(Color.WHITE, rO, cO); 
        // now the coordenates are -1 because we deal with indeces instead
        Mockito.when(this.mockBoard.getPiece(rO-1,cO-1)).thenReturn(pieceMoved); 
        Mockito.when(this.mockBoard.getPieceColor(rO-1, cO-1)).thenReturn(Color.WHITE);
        Mockito.when(this.mockPlayer.getColor()).thenReturn(Color.WHITE);
        Mockito.when(this.mockBoard.getPiece(rD-1,cD-1)).thenReturn(null);
        
        game.move(rO, cO, rD, cD);
    }
    
    @Test
    public void testMoveNoPieceOnPositionKO() throws Exception{
        System.out.println("test move NoPiecePos");
        int rO = 4;
        int cO = 4;
        int rD = 6;
        int cD = 6;

        // now the coordenates are -1 because we deal with indeces instead
        Mockito.when(this.mockBoard.getPiece(rO-1,cO-1)).thenReturn(null);   
        
        game.move(rO, cO, rD, cD);
        
        Mockito.verify(this.mockProtoManager).sendFromServerToClient("Error: there is not a piece you can move on this pos");
    }
    
    @Test
    public void testMovePieceSameColorOnDestKO() throws Exception{
        System.out.println("test move SameColorOnDest");
        int rO = 4;
        int cO = 4;
        int rD = 6;
        int cD = 6;  
       
        Bishop pieceMoved = new Bishop(Color.WHITE, rO, cO); 
        Bishop pieceOnDest = new Bishop(Color.WHITE, rD, cD); 
        // now the coordenates are -1 because we deal with indeces instead
        Mockito.when(this.mockBoard.getPiece(ArgumentMatchers.anyInt(),ArgumentMatchers.anyInt())).thenReturn(pieceMoved,pieceOnDest); 
        Mockito.when(this.mockBoard.getPieceColor(ArgumentMatchers.anyInt(),ArgumentMatchers.anyInt())).thenReturn(Color.WHITE);
        Mockito.when(this.mockPlayer.getColor()).thenReturn(Color.WHITE);      
       
        game.move(rO, cO, rD, cD);
        Mockito.verify(this.mockProtoManager).sendFromServerToClient("Error: there is a piece of the same color in the dest pos");
    }
}
