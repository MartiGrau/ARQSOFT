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
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.MockitoAnnotations.initMocks;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author mgrau
 */
@RunWith(MockitoJUnitRunner.class)
public class BishopTest {
    
    @Mock
    private Board mockBoard;
    
    private Bishop bishopInstance;
    
    public BishopTest() {
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
        bishopInstance = new Bishop(Color.WHITE, 3, 1);
    }
    
    @After
    public void tearDown() {
        
    }
    
    /**
     * Test of getColor method, of class Bishop.
     * @throws java.lang.Exception
     */
    @Test    
    public void testConstAndGetColorOK() throws Exception{
        System.out.println("---test ok of constructor");
        Bishop bishop = new Bishop(Color.WHITE, 3, 1);
        Color color = bishop.getColor();
        Assert.assertEquals(color, Color.WHITE);
    }

    /**
     * Test of isPieceMovement method, of class Bishop.
     * @throws java.lang.Exception
     */
    @Test
     public void testIsPieceMovementOKr2c2() throws Exception{
        System.out.println("is piece movement");
        int rO = 4;
        int cO = 4;
        int rD = 6;
        int cD = 6;
        bishopInstance.isPieceMovement(rO, cO, rD, cD);
    }
     
    public void testIsPieceMovementOKrm2cm2() throws Exception{
        System.out.println("is piece movement ok rO+2 cO+2");
        int rO = 4;
        int cO = 4;
        int rD = rO-2;
        int cD = cO-2;
        bishopInstance.isPieceMovement(rO, cO, rD, cD);
    }
    public void testIsPieceMovementOKrm2c2() throws Exception{
        System.out.println("is piece movement ok rO+2 cO+2");
        int rO = 4;
        int cO = 4;
        int rD = rO-2;
        int cD = cO+2;
        bishopInstance.isPieceMovement(rO, cO, rD, cD);
    }
    public void testIsPieceMovementOKr2cm2() throws Exception{
        System.out.println("is piece movement ok rO+2 cO+2");
        int rO = 4;
        int cO = 4;
        int rD = rO+2;
        int cD = cO-2;
        bishopInstance.isPieceMovement(rO, cO, rD, cD);
    }
    
    // Check it throws exception     
    @Test(expected = NoPieceMovementException.class)
    public void testIsPieceMovementKOr3cm2() throws Exception{
        System.out.println("is piece movement ok rO+2 cO+2");
        int rO = 4;
        int cO = 4;
        int rD = rO+3;
        int cD = cO-2;
        bishopInstance.isPieceMovement(rO, cO, rD, cD);
    }

    /**
     * Test of isPathFree method, of class Bishop.
     * @throws java.lang.Exception
     */
    
    @Test
    public void testIsPathFreeOKr3c3() throws Exception {
        System.out.println("isPathFree");
        Mockito.when(mockBoard.getPiece(Mockito.anyInt(), Mockito.anyInt())).thenReturn(null) ;
        int rO = 0;
        int cO = 0;
        int rD = rO+3;
        int cD = cO+3;

        bishopInstance.isPathFree(rO, cO, rD, cD, mockBoard);
    }  
    public void testIsPathFreeOKr2c2() throws Exception {
        System.out.println("isPathFree");
        Mockito.when(mockBoard.getPiece(Mockito.anyInt(), Mockito.anyInt())).thenReturn(null) ;
        int rO = 3;
        int cO = 3;
        int rD = rO+2;
        int cD = cO-2;

        bishopInstance.isPathFree(rO, cO, rD, cD, mockBoard);
    } 
    
    /**
     *
     * @throws Exception
     */
    @Test(expected = NoPathFreeException.class)
    public void testIsPathFreeKOr3c3() throws Exception {
        System.out.println("isPathFree KO");
        Bishop oBishop = new Bishop(Color.BLACK, 3, 1);
        Mockito.when(this.mockBoard.getPiece(6, 6)).thenReturn(oBishop) ;
        int rO = 4;
        int cO = 4;
        int rD = rO+3;
        int cD = cO+3;              

        bishopInstance.isPathFree(rO, cO, rD, cD, mockBoard);
    } 
    
    
}
