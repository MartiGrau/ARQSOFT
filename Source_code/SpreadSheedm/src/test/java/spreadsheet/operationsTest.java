/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadsheet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static org.mockito.MockitoAnnotations.initMocks;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author mgrau
 */
@RunWith(MockitoJUnitRunner.class)
public class operationsTest {
    
    SpreadSheet spred;
    
    public operationsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Starting Test for operations");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Ending Test for operations");
    }
    
    @Before
    public void setUp() {
        initMocks(this);
        spred = new SpreadSheet(2,2);
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testSUM() throws EmptyCellException{
        System.out.println("Test SUM");
        spred.editCell(0, 0, "2");
        spred.editCell(0, 1, "2");
        //Make sum of two cells
        spred.editCell(1, 0, "=SUMA(A1,A2)");
        //Call getContent
        String result = spred.getCellContent(1,0);
        String expectedResult = "4.0";       
        //Check if correct operation
        Assert.assertEquals(expectedResult, result);
    }
    
    @Test
    public void testMAX() throws EmptyCellException{
        System.out.println("Test MAX");
        spred.editCell(0, 0, "10");
        spred.editCell(0, 1, "4");
        spred.editCell(1, 0, "2");
        //Make sum of two cells
        spred.editCell(1, 1, "=MAX(A1,A2,B1)");
        //Call getContent
        String result = spred.getCellContent(1,1);
        String expectedResult = "10.0";       
        //Check if correct operation
        Assert.assertEquals(expectedResult, result);
    }
    
        @Test
        public void testMIN() throws EmptyCellException{
        System.out.println("Test MIN");
        spred.editCell(0, 0, "10");
        spred.editCell(0, 1, "4");
        spred.editCell(1, 0, "2");
        //Make sum of two cells
        spred.editCell(1, 1, "=MIN(A1,A2,B1)");
        //Call getContent
        String result = spred.getCellContent(1,1);
        String expectedResult = "2.0";       
        //Check if correct operation
        Assert.assertEquals(expectedResult, result);
    }
        
        @Test
        public void testPROMEDIO() throws EmptyCellException{
        System.out.println("Test PROMEDIO");
        spred.editCell(0, 0, "9");
        spred.editCell(0, 1, "6");
        spred.editCell(1, 0, "3");
        //Make sum of two cells
        spred.editCell(1, 1, "=PROMEDIO(A1,A2,B1)");
        //Call getContent
        String result = spred.getCellContent(1,1);
        String expectedResult = "6.0";       
        //Check if correct operation
        Assert.assertEquals(expectedResult, result);
    }
        
}