/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.chess2019.server;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mgrau
 */
public class BishopTest {
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
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of isPieceMovement method, of class Bishop.
     */
    @Test
    public void testIsPieceMovement() throws Exception {
        System.out.println("isPieceMovement");
        int initial_row = 0;
        int initial_col = 0;
        int dest_row = 0;
        int dest_col = 0;
        Bishop instance = null;
        instance.isPieceMovement(initial_row, initial_col, dest_row, dest_col);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPathFree method, of class Bishop.
     */
    @Test
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
    }
    
}
