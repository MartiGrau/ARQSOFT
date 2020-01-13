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
public class ClientTest {
    
    @Mock
    private SpreadSheet mockSpreadSheet;
    private Client clientInstance;
    
    public ClientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Starting Test for class Client");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Ending Test for class Client");
    }
    
    @Before
    public void setUp() {
       initMocks(this);
       clientInstance = new Client();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isExit method, of class Client.
     */
    @Test
    public void testIsExit() {
        System.out.println("Test is Exit");
        boolean expResult = true;
        boolean shouldExit = true;
        clientInstance.setExit(shouldExit);
        boolean result = clientInstance.isExit();
        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of setExit method, of class Client.
     */
    //@Test
    public void testSetExit() {
        System.out.println("Test Set Exit");
        boolean shouldExit = false;
        clientInstance.setExit(shouldExit);
        
    }

    /**
     * Test of createSpreadSheet method, of class Client.
     */
    @Test
    public void testCreateSpreadSheet() {
        System.out.println("Create SpreadSheet");
        int numRows = 3;
        int numCols = 3;
        clientInstance.createSpreadSheet(numRows, numCols);
    }

    /**
     * Test of addRow method, of class Client.
     */
    @Test
    public void testAddRow(){
        System.out.println("Adding new rows");
        int numOfRows = 2;
        clientInstance.addRow(numOfRows);
    }

    /**
     * Test of addCol method, of class Client.
     */
    @Test
    public void testAddCol() {
        System.out.println("Adding new columns");
        int numOfCols = 2;
        clientInstance.addCol(numOfCols);
    }

    /**
     * Test of editCell method, of class Client.
     */
    @Test
    public void testEditCell() {
        System.out.println("Edit Cell");
        int row = 2;
        int col = 2;
        String input = "5";
        clientInstance.editCell(row, col, input);
    }

    /**
     * Test of getCellContent method, of class Client.
     */
    @Test
    public void testGetCellContent() {
        System.out.println("Get Cell content");
        int row = 2;
        int col = 2;
        String expResult = "5";
        String result = clientInstance.getCellContent(row, col);
        Assert.assertEquals(expResult, result);
        fail("The values are not the same");
    }

    /**
     * Test of exportSpreadSheet method, of class Client.
     */
    //@Test
    public void testExportSpreadSheet() {
        System.out.println("exportSpreadSheet");
        String path = "";
        Client instance = new Client();
        boolean expResult = false;
        boolean result = instance.exportSpreadSheet(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importSpreadSheet method, of class Client.
     */
    //@Test
    public void testImportSpreadSheet() {
        System.out.println("importSpreadSheet");
        String path = "";
        Client instance = new Client();
        boolean expResult = false;
        boolean result = instance.importSpreadSheet(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createSpreadSheetOption method, of class Client.
     */
    //@Test
    public void testCreateSpreadSheetOption() {
        System.out.println("Create SpreadSheet Option");
        Client client = null;
        Client.createSpreadSheetOption(client);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRowOption method, of class Client.
     */
    //@Test
    public void testAddRowOption() {
        System.out.println("Add Rows Menu Option");
        //Client client = null;
        Client.addRowOption(clientInstance);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addColOption method, of class Client.
     */
    //@Test
    public void testAddColOption() {
        System.out.println("Add Columns Menu Option");
        Client client = null;
        Client.addColOption(client);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editCellOption method, of class Client.
     */
    //@Test
    public void testEditCellOption() {
        System.out.println("editCellOption");
        Client client = null;
        Client.editCellOption(client);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCellValueOption method, of class Client.
     */
    //@Test
    public void testGetCellValueOption() {
        System.out.println("getCellValueOption");
        Client client = null;
        Client.getCellValueOption(client);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportSpreadSheetOption method, of class Client.
     */
    //@Test
    public void testExportSpreadSheetOption() {
        System.out.println("exportSpreadSheetOption");
        Client client = null;
        Client.exportSpreadSheetOption(client);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importSpreadSheetOption method, of class Client.
     */
    //@Test
    public void testImportSpreadSheetOption() {
        System.out.println("importSpreadSheetOption");
        Client client = null;
        Client.importSpreadSheetOption(client);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Client.
     */
    //@Test
    public void testMain() {
        System.out.println("Show main text ok");
        String[] args = null;
        clientInstance.main(args);
    }
}
