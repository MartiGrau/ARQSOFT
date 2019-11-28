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
import org.mockito.InjectMocks;
import org.mockito.Mock;

/**
 *
 * @author mgrau
 */
public class BishopTest {
    
    @Mock
    private Board mockBoard;
    
    @InjectMocks
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
    public void testIsPieceMovementOKr3cm2() throws Exception{
        System.out.println("is piece movement ok rO+2 cO+2");
        int rO = 4;
        int cO = 4;
        int rD = rO+3;
        int cD = cO-2;
        bishopInstance.isPieceMovement(rO, cO, rD, cD);
    }

    /**
     * Test of isPathFree method, of class Bishop.
     */
    
    /*@Test
    public void testIsPathFree() throws Exception {
        System.out.println("isPathFree");
        int initial_row = 0;
        int initial_col = 0;
        int dest_row = 0;
        int dest_col = 0;
        Board board = null;
        Bishop instance = null;
        instance.isPathFree(initial_row, initial_col, dest_row, dest_col, board);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } */
    
}
