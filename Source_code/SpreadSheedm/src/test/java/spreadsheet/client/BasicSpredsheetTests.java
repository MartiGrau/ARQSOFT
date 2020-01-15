/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadsheet.client;


import spreadsheet.SpreadSheet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;
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
public class BasicSpredsheetTests {
    
    private Client clientInstance;
    
    public BasicSpredsheetTests() {
    }
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Starting Test CreteSpreadsheet");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Ending Test CreteSpreadsheet");
    }
    
    @Before
    public void setUp() {
       initMocks(this);
       clientInstance = new Client();
    }
    
    @After
    public void tearDown() {
    }   
    
    // Check if it creates an Spreadsheet correctly
    @Test
    public void testCreateSpreadsheet() {
        System.out.println("Test Create Spreadsheet");
        int numRows = 3;
        int numCols = 3;
        clientInstance.createSpreadSheet(numRows, numCols);
    }
    
    // Check addRow() works properly
    @Test
    public void testAddRow() {
        System.out.println("Test Add Rows");
        //Create Spreadshet 2x2
        clientInstance.createSpreadSheet(2, 2);
        //Add 1 row
        int numRows = 1;
        clientInstance.addRow(numRows);

    }
    
    // Check if getter getMaxRow() returns correct values
    @Test 
    public void testGetNumRows(){
        System.out.println("Test Get Number of Rows");
        SpreadSheet spred = new SpreadSheet(2,2);
        int numRows = spred.getMaxRow();
        int expectedRows = 2;
        Assert.assertEquals(expectedRows, numRows);
        
    }
    
    // Check addCol() works properly
    @Test
    public void testAddCol() {
        System.out.println("Test Add Columns");
        //Create Spreadshet 2x2
        clientInstance.createSpreadSheet(2, 2);
        //Add 1 row
        int numCols = 1;
        clientInstance.addCol(numCols);
    }
    
    // Check if getter getMaxCol() returns correct values
    @Test
    public void testGetNumCols(){
        System.out.println("Test Get Number of Columns");
        SpreadSheet spred = new SpreadSheet(2,2);
        int numCols = spred.getMaxCol();
        int expectedCols = 2;
        Assert.assertEquals(expectedCols, numCols);
    }
    
    // Check If the method EditCell works properly
    @Test
    public void testEditCell(){
        System.out.println("Test Edit Cell");
        clientInstance.createSpreadSheet(2, 2);
        int colToEdit = 0;
        int rowToEdit = 0;
        String inputInt = "5";
 
        clientInstance.editCell(colToEdit, rowToEdit, inputInt);
        
    }
    
    // Check if method getCellContent returns the previous added String 
    @Test
    public void testGetCellContent(){
        System.out.println("Test Get Cell Content");
        clientInstance.createSpreadSheet(1, 1);
        clientInstance.editCell(0, 0, "5");
        
        //GetCellContent
        String content = clientInstance.getCellContent(0, 0);
        String expected_content = "5";
        Assert.assertEquals(content, expected_content);       
    }
    
    // Check methods isExit() and setExit()
    @Test
    public void testsetExit() {
        System.out.println("Test Set Exit");
        //Set isExit()
        boolean setTrue = clientInstance.isExit();
        //Set setExit()
        clientInstance.setExit(setTrue);
    }
}
